package view;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.faces.model.SelectItem;

import oracle.adf.model.BindingContext;
import oracle.adf.model.DataControlFrame;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.model.dcframe.TransactionProperties;
import oracle.adf.share.ADFContext;
import oracle.adf.share.security.SecurityContext;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupCanceledEvent;
import oracle.adf.view.rich.event.PopupFetchEvent;

import oracle.adf.view.rich.event.QueryEvent;
import oracle.adf.view.rich.model.FilterableQueryDescriptor;

import oracle.adf.view.rich.render.ClientEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;
import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.uicli.binding.JUCtrlHierBinding;
import oracle.jbo.uicli.binding.JUCtrlValueBindingRef;


public class OrdrBean {
    public OrdrBean() {
    }

    private String getSessionUser() {
        ADFContext adfCtx = ADFContext.getCurrent();
        SecurityContext secCntx = adfCtx.getSecurityContext();
        String user = secCntx.getUserPrincipal().getName();
        return user;
    }

    protected static int NUMBER = Types.NUMERIC;
    /*  public static int DATE = Types.DATE;
    public static int VARCHAR2 = Types.VARCHAR; */

    public BigDecimal getSessionUserId() {
        BigDecimal _id = (BigDecimal)callStoredFunction(NUMBER, "GET_USERID(?)", new Object[] { getSessionUser() });
        if (_id.intValue() == 0)
            return new BigDecimal(1);
        else
            return _id;
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    public void beginNewTransaction() {
        BindingContext context = BindingContext.getCurrent();
        String dataControlFrameName = context.getCurrentDataControlFrame();
        DataControlFrame dcFrame = context.findDataControlFrame(dataControlFrameName);
        dcFrame.beginTransaction(new TransactionProperties());
    }

    public void commitTransaction() {
        BindingContext context = BindingContext.getCurrent();
        String dataControlFrameName = context.getCurrentDataControlFrame();
        DataControlFrame dcFrame = context.findDataControlFrame(dataControlFrameName);
        dcFrame.commit();
    }

    public void rollbackTransaction() {
        BindingContext context = BindingContext.getCurrent();
        String dataControlFrameName = context.getCurrentDataControlFrame();
        DataControlFrame dcFrame = context.findDataControlFrame(dataControlFrameName);
        dcFrame.rollback();
    }

    public Object resolveExpression(String expression) {
        FacesContext facesContext = getFacesContext();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        ValueExpression valueExp = elFactory.createValueExpression(elContext, expression, Object.class);
        return valueExp.getValue(elContext);
    }

    public ApplicationModule getApplicationModuleForDataControl(String name) {
        return (ApplicationModule)resolveExpression("#{data." + name + ".dataProvider}");
    }

    public String commitOrder() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        refreshOrders();
        return null;
    }

    public void OplatyFetchListener(PopupFetchEvent popupFetchEvent) {
        if (popupFetchEvent.getLaunchSourceClientId().contains("cbInsertOplata")) {
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert1");
            operationBinding.execute();
        }
    }

    public void OplatyCancelListener(PopupCanceledEvent popupCanceledEvent) {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Rollback");
        operationBinding.execute();
    }

    public void OplatyDialogListener(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome().name().equals("ok"))
            commitOrder();
        else if (dialogEvent.getOutcome().name().equals("cancel")) {
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("Rollback");
            operationBinding.execute();
        }
    }

    public void DostavkaFetchListener(PopupFetchEvent popupFetchEvent) {
        if (popupFetchEvent.getLaunchSourceClientId().contains("cbInsertDostavka")) {
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert2");
            operationBinding.execute();
            /* DCTaskFlowBinding tf = (DCTaskFlowBinding)JsfUtils.resolveExpression("#{bindings.addDostavka1}"); // or any other way to get to the region
             tf.getRegionModel().refresh(FacesContext.getCurrentInstance()); */
        }
    }

    public void DeleteFetchListener(PopupFetchEvent popupFetchEvent) {
        if (popupFetchEvent.getLaunchSourceClientId().contains("cmiDelete")) {
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("Delete");
            operationBinding.execute();
        }
    }

    public void ZakSummFetchListener(PopupFetchEvent popupFetchEvent) {
        //if (popupFetchEvent.getLaunchSourceClientId().contains("cbZakSumm")) {
        beginNewTransaction();
        //}
    }

    public void ZakSummDialogListener(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome().name().equals("ok")) {
            BindingContainer bindings = getBindings();
            DCIteratorBinding iter = (DCIteratorBinding)bindings.get("VwOrderView1Iterator");
            Row r = iter.getCurrentRow();
            BigDecimal id_user = getSessionUserId();
            BigDecimal id_ordr = (BigDecimal)r.getAttribute("Id");
            BigDecimal summ = (BigDecimal)r.getAttribute("ZakSumm");
            if (summ.intValue() >= 0)
                return;
            try {
                callStoredProcedure("OPLATA_ISCHOD_PKG.CREATEPAYMENT(?,?,?,?)",
                                    new Object[] { id_user, "ZakSumm", id_ordr, summ });
                commitTransaction();
                refreshOrders();
            } catch (Exception e) {
                rollbackTransaction();
            }
        } else {
            rollbackTransaction();
        }
    }

    public void ZamerDialogListener(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome().name().equals("ok")) {
            BindingContainer bindings = getBindings();
            DCIteratorBinding iter = (DCIteratorBinding)bindings.get("VwOrderView1Iterator");
            Row r = iter.getCurrentRow();
            BigDecimal id_user = getSessionUserId();
            BigDecimal id_ordr = (BigDecimal)r.getAttribute("Id");
            BigDecimal summ = (BigDecimal)r.getAttribute("Zamer");
            if (summ.intValue() >= 0)
                return;
            try {
                callStoredProcedure("OPLATA_ISCHOD_PKG.CREATEPAYMENT(?,?,?,?)",
                                    new Object[] { id_user, "Zamer", id_ordr, summ });
                commitTransaction();
                refreshOrders();
            } catch (Exception e) {
                rollbackTransaction();
            }
        } else {
            rollbackTransaction();
        }
    }

    public void KonsultDialogListener(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome().name().equals("ok")) {
            BindingContainer bindings = getBindings();
            DCIteratorBinding iter = (DCIteratorBinding)bindings.get("VwOrderView1Iterator");
            Row r = iter.getCurrentRow();
            BigDecimal id_user = getSessionUserId();
            BigDecimal id_ordr = (BigDecimal)r.getAttribute("Id");
            BigDecimal summ = (BigDecimal)r.getAttribute("Konsult");
            if (summ.intValue() >= 0)
                return;
            try {
                callStoredProcedure("OPLATA_ISCHOD_PKG.CREATEPAYMENT(?,?,?,?)",
                                    new Object[] { id_user, "Konsult", id_ordr, summ });
                commitTransaction();
                refreshOrders();
            } catch (Exception e) {
                rollbackTransaction();
            }
        } else {
            rollbackTransaction();
        }
    }

    public void MontagDialogListener(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome().name().equals("ok")) {
            BindingContainer bindings = getBindings();
            DCIteratorBinding iter = (DCIteratorBinding)bindings.get("VwOrderView1Iterator");
            Row r = iter.getCurrentRow();
            BigDecimal id_user = getSessionUserId();
            BigDecimal id_ordr = (BigDecimal)r.getAttribute("Id");
            BigDecimal summ = (BigDecimal)r.getAttribute("Montag");
            if (summ.intValue() >= 0)
                return;
            try {
                callStoredProcedure("OPLATA_ISCHOD_PKG.CREATEPAYMENT(?,?,?,?)",
                                    new Object[] { id_user, "Montag", id_ordr, summ });
                commitTransaction();
                refreshOrders();
            } catch (Exception e) {
                rollbackTransaction();
            }
        } else {
            rollbackTransaction();
        }
    }

    public void DostavkaDialogListener(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome().name().equals("ok")) {
            BindingContainer bindings = getBindings();
            DCIteratorBinding iter = (DCIteratorBinding)bindings.get("VwOrderView1Iterator");
            Row r = iter.getCurrentRow();
            BigDecimal id_user = getSessionUserId();
            BigDecimal id_ordr = (BigDecimal)r.getAttribute("Id");
            BigDecimal summ = (BigDecimal)r.getAttribute("Dostavka");
            if (summ.intValue() >= 0)
                return;
            try {
                callStoredProcedure("OPLATA_ISCHOD_PKG.CREATEPAYMENT(?,?,?,?)",
                                    new Object[] { id_user, "Dostavka", id_ordr, summ });
                commitTransaction();
                refreshOrders();
            } catch (Exception e) {
                rollbackTransaction();
            }
        } else {
            rollbackTransaction();
        }
    }

    public void BankDialogListener(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome().name().equals("ok")) {
            BindingContainer bindings = getBindings();
            DCIteratorBinding iter = (DCIteratorBinding)bindings.get("VwOrderView1Iterator");
            Row r = iter.getCurrentRow();
            BigDecimal id_user = getSessionUserId();
            BigDecimal id_ordr = (BigDecimal)r.getAttribute("Id");
            BigDecimal summ = (BigDecimal)r.getAttribute("Bank");
            if (summ.intValue() >= 0)
                return;
            try {
                callStoredProcedure("OPLATA_ISCHOD_PKG.CREATEPAYMENT(?,?,?,?)",
                                    new Object[] { id_user, "Bank", id_ordr, summ });
                commitTransaction();
                refreshOrders();
            } catch (Exception e) {
                rollbackTransaction();
            }
        } else {
            rollbackTransaction();
        }
    }

    public void ZakSummCancelListener(PopupCanceledEvent popupCanceledEvent) {
        rollbackTransaction();
    }

    public void DeleteCancelListener(PopupCanceledEvent popupCanceledEvent) {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Rollback");
        operationBinding.execute();
    }

    public void DeleteDialogListener(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome().name().equals("ok")) {
            /* BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("Delete");
            operationBinding.execute(); */
            commitOrder();
        } else if (dialogEvent.getOutcome().name().equals("cancel")) {
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("Rollback");
            operationBinding.execute();
        }
    }

    public String commitSetting() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }

    public String refreshOrders() {
        BindingContainer bindings = getBindings();
        // Save current row key
        DCIteratorBinding iter = (DCIteratorBinding)bindings.get("VwOrderView1Iterator");
        String oldKey = iter.getCurrentRowKeyString();

        // Refresh query
        iter.executeQuery();

        // Reset saved row key
        iter.invalidateCache();
        try {
            iter.setCurrentRowWithKey(oldKey);
        } finally {

            //DCIteratorBinding iterto = (DCIteratorBinding)bindings.get("VwTurnoverWeekView1Iterator");
            // Refresh query
            //iterto.executeQuery();
            DCIteratorBinding iterdo = (DCIteratorBinding)bindings.get("DostavkaView1Iterator");
            // Refresh query
            iterdo.executeQuery();
            DCIteratorBinding iterdolg = (DCIteratorBinding)bindings.get("DolgKontragents1Iterator");
            // Refresh query
            iterdolg.executeQuery();
            return null;
        }
    }

    protected void callStoredProcedure(String stmt, Object[] bindVars) {
        ApplicationModuleImpl am = (ApplicationModuleImpl)getApplicationModuleForDataControl("AppModuleDataControl");
        PreparedStatement st = null;
        try {
            // 1. Create a JDBC PreparedStatement for
            st = am.getDBTransaction().createPreparedStatement("begin " + stmt + ";end;", 0);
            if (bindVars != null) {
                // 2. Loop over values for the bind variables passed in, if any
                for (int z = 0; z < bindVars.length; z++) {
                    // 3. Set the value of each bind variable in the statement
                    st.setObject(z + 1, bindVars[z]);
                }
            }
            // 4. Execute the statement
            st.executeUpdate();
        } catch (SQLException e) {
            throw new JboException(e);
        } finally {
            if (st != null) {
                try {
                    // 5. Close the statement
                    st.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    protected Object callStoredFunction(int sqlReturnType, String stmt, Object[] bindVars) {
        ApplicationModuleImpl am = (ApplicationModuleImpl)getApplicationModuleForDataControl("AppModuleDataControl");
        CallableStatement st = null;
        try {
            // 1. Create a JDBC CallabledStatement
            st = am.getDBTransaction().createCallableStatement("begin ? := " + stmt + ";end;", 0);
            // 2. Register the first bind variable for the return value
            st.registerOutParameter(1, sqlReturnType);
            if (bindVars != null) {
                // 3. Loop over values for the bind variables passed in, if any
                for (int z = 0; z < bindVars.length; z++) {
                    // 4. Set the value of user-supplied bind vars in the stmt
                    st.setObject(z + 2, bindVars[z]);
                }
            }
            // 5. Set the value of user-supplied bind vars in the stmt
            st.executeUpdate();
            // 6. Return the value of the first bind variable
            return st.getObject(1);
        } catch (SQLException e) {
            throw new JboException(e);
        } finally {
            if (st != null) {
                try {
                    // 7. Close the statement
                    st.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public List<SelectItem> onSuggest(String string) {
        BindingContext bctx = BindingContext.getCurrent();
        BindingContainer bindings = bctx.getCurrentBindingsEntry();
        //set the bind variable value that is used to filter the View Object
        //query of the suggest list. The View Object instance has a View
        //Criteria assigned
        OperationBinding setVariable = (OperationBinding)bindings.get("setSearchCriteria");
        setVariable.getParamsMap().put("value", string);
        setVariable.execute();

        JUCtrlHierBinding hierBinding = (JUCtrlHierBinding)bindings.get("ZamerNameLookupVO1");
        //re-query the list based on the new bind variable values
        hierBinding.executeQuery();
        //The rangeSet,  the list   of queries entries, is of type
        //JUCtrlValueBndingRef.
        List<JUCtrlValueBindingRef> displayDataList = hierBinding.getRangeSet();
        ArrayList<SelectItem> selectItems = new ArrayList<SelectItem>();
        for (JUCtrlValueBindingRef displayData : displayDataList) {
            Row rw = displayData.getRow();
            //populate the SelectItem list
            selectItems.add(new SelectItem((BigDecimal)rw.getAttribute("Id"), (String)rw.getAttribute("Id")));
        }
        return selectItems;
    }
}

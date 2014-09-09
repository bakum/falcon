package view;

import java.util.Calendar;

import java.util.Iterator;

import javax.faces.event.ActionEvent;

import javax.faces.event.PhaseEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.view.rich.component.rich.data.RichTreeTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import org.apache.myfaces.trinidad.model.RowKeySet;

public class ReportBean extends BeanCls {
    private RichInputDate ids;
    private RichTreeTable treeTable;

    public ReportBean() {
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String refreshZatrPerMonth() {
        BindingContainer bindings = getBindings();
        // Save current row key
        DCIteratorBinding iter = (DCIteratorBinding)bindings.get("ReportsView1Iterator");
        //String oldKey = iter.getCurrentRowKeyString();

        // Refresh query
        iter.executeQuery();

        // Reset saved row key
        iter.invalidateCache();
        //iter.setCurrentRowWithKey(oldKey);
        return null;
    }

    public void ExecuteWithUser(ActionEvent actionEvent) {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("setRangeForDetailVwSalesPerMonthAccessorViewObject");
        OperationBinding ob = bindings.getOperationBinding("ExecuteWithParams");
        //DCIteratorBinding iter = (DCIteratorBinding)bindings.get("DivisionsView1Iterator");
        String name = getSessionUserName();
        operationBinding.getParamsMap().put("u_name", name);
        ob.getParamsMap().put("u_name", name);
        Object o = ids.getValue();
        if (o == null) {
            Calendar calendar = Calendar.getInstance();
            //calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMaximum(Calendar.DAY_OF_YEAR)); // это будет конец месяца
            java.util.Date pDate = calendar.getTime();
            o = new oracle.jbo.domain.Date(new java.sql.Date(pDate.getTime()));
            ids.setValue(o);
        }
        operationBinding.getParamsMap().put("u_dat", o);
        ob.getParamsMap().put("u_dat", o);

        operationBinding.execute();
        ob.execute();
        //iter.executeQuery();
        //iter.invalidateCache();
        return;
    }

    public void setIds(RichInputDate ids) {
        this.ids = ids;
    }

    public RichInputDate getIds() {
        return ids;
    }

    public void ExecuteWithUserRep(ActionEvent actionEvent) {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("setRangeForDetailVwZatratyPerMonthAccessorViewObject");
        String name = getSessionUserName();
        operationBinding.getParamsMap().put("u_name", name);
        Object o = ids.getValue();
        if (o == null) {
            Calendar calendar = Calendar.getInstance();
            //calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMaximum(Calendar.DAY_OF_YEAR)); // это будет конец месяца
            java.util.Date pDate = calendar.getTime();
            o = new oracle.jbo.domain.Date(new java.sql.Date(pDate.getTime()));
            ids.setValue(o);
        }
        operationBinding.getParamsMap().put("u_dat", o);
        operationBinding.execute();
        return;
    }

    public void setTreeTable(RichTreeTable treeTable) {
        this.treeTable = treeTable;
    }

    public RichTreeTable getTreeTable() {
        return treeTable;
    }
}

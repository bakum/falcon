package view;


import falcon.app_module.AppModuleImpl;

import java.math.BigDecimal;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.List;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.datatransfer.DataFlavor;
import oracle.adf.view.rich.datatransfer.Transferable;
import oracle.adf.view.rich.dnd.DnDAction;
import oracle.adf.view.rich.event.DropEvent;

import oracle.binding.BindingContainer;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.uicli.binding.JUCtrlHierBinding;

import org.apache.myfaces.trinidad.model.CollectionModel;
import org.apache.myfaces.trinidad.model.RowKeySet;

public class DnDBean {
    public DnDBean() {
    }
    
    protected void callStoredProcedure(String stmt, Object[] bindVars) {
      //AppModuleImpl am = (AppModuleImpl)BindingContext.getCurrent().getDefaultDataControl().getApplicationModule();
      AppModuleImpl am = (AppModuleImpl) ADFUtils.getApplicationModuleForDataControl("AppModuleDataControl");
      PreparedStatement st = null;
      try {
        // 1. Create a JDBC PreparedStatement for
        st = am.getDBTransaction().createPreparedStatement("begin "+stmt+";end;",0);
        if (bindVars != null) {
          // 2. Loop over values for the bind variables passed in, if any
          for (int z = 0; z < bindVars.length; z++) {
            // 3. Set the value of each bind variable in the statement
            st.setObject(z + 1, bindVars[z]);
          }
        }
        // 4. Execute the statement
        st.executeUpdate();
      }
      catch (SQLException e) {
        throw new JboException(e);
      }
      finally {
        if (st != null) {
          try {
            // 5. Close the statement
            st.close();
          }
          catch (SQLException e) {
              System.out.println(e.getMessage());}
        }
      }
    }
    
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public DnDAction addOrderListener(DropEvent dropEvent) {
        try {

            Transferable transferable = dropEvent.getTransferable();

            DataFlavor<RowKeySet> df =
                DataFlavor.getDataFlavor(RowKeySet.class);
            RowKeySet droppedValue = transferable.getData(df);

            if (droppedValue == null) {
                return DnDAction.NONE;
            }
            Object[] keys = droppedValue.toArray();

            BindingContext bindingctx = BindingContext.getCurrent();
            BindingContainer bindings = null;
            bindings = bindingctx.getCurrentBindingsEntry();

            CollectionModel cm = transferable.getData(CollectionModel.class);

            for (int i = 0; i < keys.length; i++) {
                cm.setRowKey((List)keys[i]);

                JUCtrlHierBinding rData =
                    (JUCtrlHierBinding)bindings.get("VwUdevordersView1");

                BigDecimal id = (BigDecimal)rData.getAttribute("Id");
                BigDecimal regionId = (BigDecimal)rData.getAttribute("Summa");


                addItem(id, regionId, "DostavkaTabPartOrdersView2Iterator");
            }
            calculateDopSum(null);
            return DnDAction.MOVE;
        } catch (Exception ex) {
            System.out.println("drop failed with : " + ex.getMessage());
        }
        return DnDAction.NONE;
    }
    
    public DnDAction removeOrderListener(DropEvent dropEvent) {
        try {

            Transferable transferable = dropEvent.getTransferable();

            DataFlavor<RowKeySet> df =
                DataFlavor.getDataFlavor(RowKeySet.class);
            RowKeySet droppedValue = transferable.getData(df);

            if (droppedValue == null) {
                return DnDAction.NONE;
            }
            Object[] keys = droppedValue.toArray();

            BindingContext bindingctx = BindingContext.getCurrent();
            BindingContainer bindings = null;
            bindings = bindingctx.getCurrentBindingsEntry();

            CollectionModel cm = transferable.getData(CollectionModel.class);

            for (int i = 0; i < keys.length; i++) {
                cm.setRowKey((List)keys[i]);

                JUCtrlHierBinding rData =
                    (JUCtrlHierBinding)bindings.get("DostavkaTabPartOrdersView2");

                BigDecimal id = (BigDecimal)rData.getAttribute("OrderId");
                BigDecimal sum = (BigDecimal)rData.getAttribute("Summa");


                addItemBack(id, sum, "VwUdevordersView1Iterator");
            }
            calculateDopSum(null);
            return DnDAction.MOVE;
        } catch (Exception ex) {
            System.out.println("drop failed with : " + ex.getMessage());
        }
        return DnDAction.NONE;
    }
    
    public void endListenerUnDevOrders(DropEvent dropEvent) {
        deleteCurrentRowFrom("VwUdevordersView1Iterator");
        AdfFacesContext.getCurrentInstance().addPartialTarget(dropEvent.getDragComponent()); // Add event code here...
    }
    
    public void endListenerOrders(DropEvent dropEvent) {
        deleteCurrentRowFrom("DostavkaTabPartOrdersView2Iterator");
        AdfFacesContext.getCurrentInstance().addPartialTarget(dropEvent.getDragComponent()); // Add event code here...
    }
    
    private void deleteCurrentRowFrom(String itername) {
        DCBindingContainer bc =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcib = bc.findIteratorBinding(itername);

        RowSetIterator iter = dcib.getRowSetIterator();
        Row removeRow = iter.removeCurrentRowAndRetain();
    }
    
    private void addItemBack(BigDecimal id, BigDecimal region,
                         String itername) {
        DCBindingContainer bc =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcib = bc.findIteratorBinding(itername);

        RowSetIterator iter = dcib.getRowSetIterator();
        Row newRow = iter.createRow();
        //newRow.setAttribute("Id", id);
        //newRow.setAttribute("CountryName", name);
        newRow.setAttribute("Summa", region);
        
        iter.insertRowAtRangeIndex(iter.getRowCount(), newRow);
    }
    
    private void addItem(BigDecimal id, BigDecimal region,
                         String itername) {
        DCBindingContainer bc =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcib = bc.findIteratorBinding(itername);

        RowSetIterator iter = dcib.getRowSetIterator();
        Row newRow = iter.createRow();
        newRow.setAttribute("OrderId", id);
        //newRow.setAttribute("CountryName", name);
        newRow.setAttribute("Summa", region);
        
        iter.insertRowAtRangeIndex(iter.getRowCount(), newRow);
    }
    
    private void deleteAllRowFrom(String itername) {
        DCBindingContainer bc =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcib = bc.findIteratorBinding(itername);

        RowSetIterator iter = dcib.getRowSetIterator();
        Row[] rows = iter.getAllRowsInRange();
        for(Row row: rows){
            callStoredProcedure("DELIVER_PKG.undo_deliver(?)",
                                    new Object[] { (BigDecimal)row.getAttribute("OrderId")});
            row.remove(); 
        }
        //Row removeRow = iter.removeCurrentRowAndRetain();
    }

    public String clearAll() {
        deleteAllRowFrom("DostavkaTabPartOrdersView2Iterator") ;
        BindingContainer bindings = getBindings();
        DCIteratorBinding iter = (DCIteratorBinding)bindings.get("VwUdevordersView1Iterator");

        // Refresh query
        iter.executeQuery();
        return null;
    }
    
    public void calculateDopSum(ActionEvent actionEvent) {
        BindingContainer bindings = getBindings();
        
        // Save current row key
        DCIteratorBinding iter = (DCIteratorBinding)bindings.get("DostavkaTabPartOrdersView2Iterator");
        DCIteratorBinding iterd = (DCIteratorBinding)bindings.get("DostavkaView1Iterator");
        Row currDostavka = iterd.getCurrentRow();
        Row[] rows = iter.getAllRowsInRange();
        BigDecimal column_summ = new BigDecimal(0);
        BigDecimal column_dop_summ = new BigDecimal(0);
        BigDecimal all_summ = (BigDecimal)currDostavka.getAttribute("Summa");
        Long base = (Long)currDostavka.getAttribute("IdBase");
        int rcount = rows.length;
        if (base.intValue() == 21) {
        
        for(Row row: rows){
            column_summ = column_summ.add((BigDecimal)row.getAttribute("Summa")); 
            }
        for(Row row: rows){
               BigDecimal cSumm = (BigDecimal)row.getAttribute("Summa");
               double koef = cSumm.doubleValue()/column_summ.doubleValue();
               row.setAttribute("DopSumma", new BigDecimal(koef*all_summ.doubleValue()).setScale(2, BigDecimal.ROUND_FLOOR));
            }
        } else {
            for(Row row: rows){
                double DopSumm = all_summ.doubleValue()/rcount;
                row.setAttribute("DopSumma", new BigDecimal(DopSumm).setScale(2,BigDecimal.ROUND_FLOOR));
                }
            
        }
        for(Row row: rows){
            column_dop_summ = column_dop_summ.add((BigDecimal)row.getAttribute("DopSumma")); 
            }
        BigDecimal rasni = all_summ.subtract(column_dop_summ);
        if (rasni.doubleValue() != 0 && rcount != 1) {
            Row addRow = rows[0];
            BigDecimal CurrSum = (BigDecimal)addRow.getAttribute("DopSumma");
            addRow.setAttribute("DopSumma", CurrSum.add(rasni).setScale(2,BigDecimal.ROUND_FLOOR));
        }
        
    }

}

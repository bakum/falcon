package view;

import java.math.BigDecimal;

import java.util.Iterator;
import java.util.List;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.data.RichTree;
import oracle.adf.view.rich.component.rich.data.RichTreeTable;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.datatransfer.DataFlavor;
import oracle.adf.view.rich.datatransfer.Transferable;
import oracle.adf.view.rich.dnd.DnDAction;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.adf.view.rich.event.DropEvent;
import oracle.adf.view.rich.event.PopupCanceledEvent;
import oracle.adf.view.rich.event.PopupFetchEvent;

import oracle.adf.view.rich.event.QueryEvent;
import oracle.adf.view.rich.model.FilterableQueryDescriptor;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;

import oracle.jbo.uicli.binding.JUCtrlHierBinding;
import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import org.apache.myfaces.trinidad.model.CollectionModel;
import org.apache.myfaces.trinidad.model.RowKeySet;

public class OtherBean {
    private RichTable featureTable;

    public OtherBean() {
    }
    
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    
    public String commitOther() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        // Save current row key
        DCIteratorBinding iter = (DCIteratorBinding)bindings.get("OtherZatratyView1Iterator");
        String oldKey = iter.getCurrentRowKeyString();

        // Refresh query
        iter.executeQuery();

        // Reset saved row key
        iter.invalidateCache();
        try {
           iter.setCurrentRowWithKey(oldKey);
        } finally {    
           return null;
        }   
    }

    public void OtherDialogListener(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome().name().equals("ok"))
            commitOther();
        else if (dialogEvent.getOutcome().name().equals("cancel")) {
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("Rollback");
            operationBinding.execute();
        }
    }

    public void OtherFetchListener(PopupFetchEvent popupFetchEvent) {
        if (popupFetchEvent.getLaunchSourceClientId().contains("cbInsert")) {
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert");
            operationBinding.execute();
        }
    }
    
    public void DeleteFetchListener(PopupFetchEvent popupFetchEvent) {
        if (popupFetchEvent.getLaunchSourceClientId().contains("cmiDelete")) {
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("Delete");
            operationBinding.execute();
        }
    }

    public void OtherCancelListener(PopupCanceledEvent popupCanceledEvent) {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Rollback");
        operationBinding.execute();
    }
    

    public DnDAction addZatratyListener(DropEvent dropEvent) {
       try {
            //RichTable table = (RichTable)dropEvent.getDropComponent();

            RichTreeTable tree = (RichTreeTable)dropEvent.getDragComponent();
            //List dropRowKey = (List) dropEvent.getDropSite();
            //if no dropsite then drop area was not a data area
            /* if(dropRowKey == null){
            return DnDAction.NONE;
            } 

            Object currentRowKey = table.getRowKey();
            table.setRowKey(dropRowKey); */
            Transferable t = dropEvent.getTransferable();
            DataFlavor<RowKeySet> df =
            DataFlavor.getDataFlavor(RowKeySet.class);
            //RowKeySet rkst = tree.getSelectedRowKeys();
            RowKeySet rks = t.getData(df);
            if (rks == null) {
                return DnDAction.NONE;
            }
            CollectionModel cm = t.getData(CollectionModel.class);
            Object oldRowKey = tree.getRowKey();
            Iterator iter = rks.iterator();
            while (iter.hasNext()) {
                List key = (List)iter.next();
                cm.setRowKey(key);
                tree.setRowKey(key);
                JUCtrlHierNodeBinding rowBinding =
                (JUCtrlHierNodeBinding)tree.getRowData();
                
                //JUCtrlHierBinding rb = rowBinding.getHierBinding();
                
                
                Row treeRow = (Row)rowBinding.getRow();
                BigDecimal id = (BigDecimal)treeRow.getAttribute("Id");
                //BigDecimal _id = (BigDecimal)rb.getAttribute("Id");
                    
                  
                
                addItem(id, "OtherZatratyTabPartZatratyView2Iterator");
                }
                tree.setRowKey(oldRowKey);
                return DnDAction.COPY;
            
                    
                } catch (Exception ex) {
                    System.out.println("drop failed with : " + ex.getMessage());
                }
        return DnDAction.NONE;
    /* try {

        Transferable transferable = dropEvent.getTransferable();
        RichTreeTable tree = (RichTreeTable)dropEvent.getDragComponent();

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
            //cm.setRowKey((List)keys[i]);
            
            tree.setRowKey((List)keys[i]);
            JUCtrlHierNodeBinding rowBinding =
            (JUCtrlHierNodeBinding)tree.getRowData();
            Row treeRow = rowBinding.getRow();
            BigDecimal id = (BigDecimal)treeRow.getAttribute("Id");

            JUCtrlHierBinding rData =
                (JUCtrlHierBinding)bindings.get("ZatratyPostView2");

            //BigDecimal id = (BigDecimal)rData.getAttribute("Id");
            //BigDecimal regionId = (BigDecimal)rData.getAttribute("Summa");


            addItem(id, "OtherZatratyTabPartZatratyView2Iterator");
        }
        return DnDAction.COPY;
    } catch (Exception ex) {
        System.out.println("drop failed with : " + ex.getMessage());
    } 
    return DnDAction.NONE;*/

}
    
    private JUCtrlHierNodeBinding getFirstChild(JUCtrlHierNodeBinding node) {
        if (node!=null) {
            return (JUCtrlHierNodeBinding)node.getChildren().get(0);
        }
        return null;
    }
    
    private void addItem(BigDecimal id, String itername) {
        DCBindingContainer bc =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcib = bc.findIteratorBinding(itername);

        RowSetIterator iter = dcib.getRowSetIterator();
        Row newRow = iter.createRow();
        newRow.setAttribute("ZatrId", id);
        //newRow.setAttribute("CountryName", name);
        //newRow.setAttribute("Summa", region);
        
        iter.insertRowAtRangeIndex(iter.getRowCount(), newRow);
    }

    public void DragListener(DropEvent dropEvent) {
        AdfFacesContext.getCurrentInstance().addPartialTarget(dropEvent.getDragComponent());
    }

    public String refreshOther() {
        BindingContainer bindings = getBindings();
        // Save current row key
        DCIteratorBinding iter = (DCIteratorBinding)bindings.get("OtherZatratyView1Iterator");
        //String oldKey = iter.getCurrentRowKeyString();

        // Refresh query
        iter.executeQuery();

        // Reset saved row key
        iter.invalidateCache();
        //iter.setCurrentRowWithKey(oldKey);
        return null;
    }
    
    public String refreshZatr() {
        BindingContainer bindings = getBindings();
        // Save current row key
        DCIteratorBinding iter = (DCIteratorBinding)bindings.get("ZatratyPostView2Iterator");
        //String oldKey = iter.getCurrentRowKeyString();

        // Refresh query
        iter.executeQuery();

        // Reset saved row key
        iter.invalidateCache();
        //iter.setCurrentRowWithKey(oldKey);
        return null;
    }

    public void NewZatratyDialogListener(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome().name().equals("ok")) {
            BindingContainer bindings = getBindings();
            //OperationBinding varBinding = bindings.getOperationBinding("za");
            OperationBinding operationBinding = bindings.getOperationBinding("createZatratyArticle");
            operationBinding.execute();
            refreshZatr();
            }
        else if (dialogEvent.getOutcome().name().equals("cancel")) {
            
        }
            
    }

    public void setFeatureTable(RichTable featureTable) {
        this.featureTable = featureTable;
    }

    public RichTable getFeatureTable() {
        return featureTable;
    }
    
    public void resetTableFilter(ActionEvent actionEvent) {
        FilterableQueryDescriptor queryDescriptor = (FilterableQueryDescriptor)getFeatureTable().getFilterModel();
        if (queryDescriptor != null && queryDescriptor.getFilterCriteria() != null) {
            queryDescriptor.getFilterCriteria().clear();
            getFeatureTable().queueEvent(new QueryEvent(getFeatureTable(), queryDescriptor));
        }
    }
}

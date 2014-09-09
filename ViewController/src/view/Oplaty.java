package view;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupCanceledEvent;
import oracle.adf.view.rich.event.PopupFetchEvent;

import oracle.adf.view.rich.event.QueryEvent;
import oracle.adf.view.rich.model.FilterableQueryDescriptor;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class Oplaty {
    private RichTable featureTable;

    public Oplaty() {
    }
    
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    
    public String commitOplata() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        refreshOplata();
        return null;
    }
    
    public String refreshOplata() {
        BindingContainer bindings = getBindings();
        // Save current row key
        DCIteratorBinding iter = (DCIteratorBinding)bindings.get("OplataIschodView1Iterator");
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

    public void OplatyDialogListener(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome().name().equals("ok"))
            commitOplata();
        else if (dialogEvent.getOutcome().name().equals("cancel")) {
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("Rollback");
            operationBinding.execute();
        }
    }
    
    public void DeleteFetchListener(PopupFetchEvent popupFetchEvent) {
        if (popupFetchEvent.getLaunchSourceClientId().contains("ctbDelete")) {
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("Delete");
            operationBinding.execute();
        }
    }

    public void DeleteCancelListener(PopupCanceledEvent popupCanceledEvent) {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Rollback");
        operationBinding.execute();
    }

    public void DeleteDialogListener(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome().name().equals("ok"))
            commitOplata();
        else if (dialogEvent.getOutcome().name().equals("cancel")) {
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("Rollback");
            operationBinding.execute();
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

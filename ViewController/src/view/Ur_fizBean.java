package view;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupCanceledEvent;
import oracle.adf.view.rich.event.PopupFetchEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class Ur_fizBean {
    public Ur_fizBean() {
    }
    
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    
    public String commitUr() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        refreshUr();
        return null;
    }
    
    public String refreshUr() {
        BindingContainer bindings = getBindings();
        // Save current row key
        DCIteratorBinding iter5 = (DCIteratorBinding)bindings.get("AccFizView5Iterator");
        DCIteratorBinding iter = (DCIteratorBinding)bindings.get("AccFizDolgView1Iterator");
        DCIteratorBinding iter1 = (DCIteratorBinding)bindings.get("KontragentsView1Iterator");
        String oldKey = iter.getCurrentRowKeyString();

        // Refresh query
        iter1.executeQuery();
        iter.executeQuery();
        iter5.executeQuery();

        // Reset saved row key
        iter1.invalidateCache();
        iter.invalidateCache();
        iter5.invalidateCache();
        try {
            iter.setCurrentRowWithKey(oldKey);
        } finally {
        return null;
        }
    }
    
    public void urPopFetchListener(PopupFetchEvent popupFetchEvent) {
        if (popupFetchEvent.getLaunchSourceClientId().contains("ctbInsert")) {
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert");
            operationBinding.execute();
            //refreshUr();
        }
    }
    
    public void urdocPopFetchListener(PopupFetchEvent popupFetchEvent) {
        if (popupFetchEvent.getLaunchSourceClientId().contains("ctbInsert1")) {
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert1");
            operationBinding.execute();
            //refreshUr();
        }
    }

    public void urPopCancelListener(PopupCanceledEvent popupCanceledEvent) {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Rollback");
        operationBinding.execute();
        refreshUr();
    }

    public void nameDialogListener(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome().name().equals("ok"))
            commitUr();
        else if (dialogEvent.getOutcome().name().equals("cancel")) {
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("Rollback");
            operationBinding.execute();
            refreshUr();
        }
    }

    public void DelDialogListener(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome().name().equals("ok")) {
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("Delete");
            operationBinding.execute();
            commitUr();
        }
    }
}

package view;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.adf.view.rich.event.PopupCanceledEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class AccCostBean {
    public AccCostBean() {
    }
    
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
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
    
    public String commitAccCost() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        refreshOrders();
        return null;
    }

    public void AccCostDialogListener(DialogEvent dialogEvent) {

        if (dialogEvent.getOutcome().name().equals("ok"))
            commitAccCost();
        else if (dialogEvent.getOutcome().name().equals("cancel")) {
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("Rollback");
            operationBinding.execute();
        }
    }
    
    public void AccCostCancelListener(PopupCanceledEvent popupCanceledEvent) {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Rollback");
        operationBinding.execute();
    }

}

package view;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupCanceledEvent;
import oracle.adf.view.rich.event.PopupFetchEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class AccCurrencyBean {
    public AccCurrencyBean() {
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void onPopup(PopupFetchEvent popupFetchEvent) {
        if (popupFetchEvent.getLaunchSourceClientId().contains("cbInsertOrder")) {
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert");
            operationBinding.execute();
        }
    }

    public void onPopupCancel(PopupCanceledEvent popupCanceledEvent) {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Rollback");
        operationBinding.execute();
    }

    public void onAcceptDialog(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome().name().equals("ok"))
            commitOrder();
        else if (dialogEvent.getOutcome().name().equals("cancel")) {
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("Rollback");
            operationBinding.execute();
        }
    }

    public void onDeleteDialog(DialogEvent dialogEvent) {
        BindingContainer bindings = getBindings();
        if (dialogEvent.getOutcome().name().equals("ok")) {
            OperationBinding operationBinding = getBindings().getOperationBinding("Delete");
            Object result = operationBinding.execute();
            commitOrder();
            /* operationBinding = getBindings().getOperationBinding("Commit");
            result = operationBinding.execute(); */
        } else if (dialogEvent.getOutcome().name().equals("cancel")) {
            OperationBinding operationBinding = bindings.getOperationBinding("Rollback");
            operationBinding.execute();
        }
    }

    public String commitOrder() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        OperationBinding ob = bindings.getOperationBinding("setRefreshForAccCurDivAccessorViewObject");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        DCIteratorBinding iter = (DCIteratorBinding)bindings.get("AccCurrencyView1Iterator");
        iter.executeQuery();
        ob.execute();
        return null;
    }
}

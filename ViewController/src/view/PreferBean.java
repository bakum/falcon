package view;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupCanceledEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class PreferBean {
    public PreferBean() {
    }
    
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    
    public String commitPrefer() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        refreshPrefer();
        return null;
    }
    
    public String refreshPrefer() {
        BindingContainer bindings = getBindings();
        // Save current row key
        DCIteratorBinding iter = (DCIteratorBinding)bindings.get("ObmenSettingsView1Iterator");
        //String oldKey = iter.getCurrentRowKeyString();

        // Refresh query
        iter.executeQuery();

        // Reset saved row key
        iter.invalidateCache();
        //iter.setCurrentRowWithKey(oldKey);
        
        //DCIteratorBinding iterr = (DCIteratorBinding)bindings.get("ObmenSettingsView1Iterator");
        return null;
    }

    public void cancelListener(PopupCanceledEvent popupCanceledEvent) {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Rollback");
        operationBinding.execute();
    }

    public void dialogListener(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome().name().equals("ok"))
            commitPrefer();
        else if (dialogEvent.getOutcome().name().equals("cancel")) {
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("Rollback");
            operationBinding.execute();
        }
    }

    public String execureRefreshSync() {
        /* BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("doSynchronization");
        operationBinding.execute(); */
        refreshPrefer();
        return null;
    }

}

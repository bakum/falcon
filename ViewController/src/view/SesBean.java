package view;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.binding.BindingContainer;

public class SesBean {
    public SesBean() {
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String RefreshSes() {
        BindingContainer bindings = getBindings();
        // Save current row key
        DCIteratorBinding iter = (DCIteratorBinding)bindings.get("SessionsView1Iterator");
        // Refresh query
        iter.executeQuery(); 
        return null;
    }
}

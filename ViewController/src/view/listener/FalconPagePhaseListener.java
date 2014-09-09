package view.listener;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.controller.v2.lifecycle.Lifecycle;
import oracle.adf.controller.v2.lifecycle.PagePhaseEvent;
import oracle.adf.controller.v2.lifecycle.PagePhaseListener;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;

public class FalconPagePhaseListener implements PagePhaseListener {
    public FalconPagePhaseListener() {
        super();
    }

    @Override
    public void afterPhase(PagePhaseEvent pagePhaseEvent) {
        if (pagePhaseEvent.getPhaseId() == Lifecycle.PREPARE_RENDER_ID) {
            //DCBindingContainer dcBindings = ADFUtils.getDCBindingContainer();
            //DCBindingContainer dcBindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            //dcBindings.refreshControl();
            /* FacesContext fctx = FacesContext.getCurrentInstance();
            String viewId = fctx.getViewRoot().getViewId();
            FacesMessage message = new FacesMessage("Hello Page no " + viewId);
            fctx.addMessage(null, message);  */
            /* FacesContext fctx = FacesContext.getCurrentInstance();
            String viewId = fctx.getViewRoot().getViewId();
           if (viewId.contains("dostavka")) {
                FacesMessage message = new FacesMessage("Hello Page no " + viewId);
                fctx.addMessage(null, message); }*/
            }

       
    }

    @Override
    public void beforePhase(PagePhaseEvent pagePhaseEvent) {
    }
}

package view;

import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCIteratorBinding;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

public class FalconBean {
    public FalconBean() {
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String getCreateEnabled() {
        BindingContainer bc = this.getBindings();
        oracle.adf.model.OperationBinding ob =
            (oracle.adf.model.OperationBinding)bc.getOperationBinding("getRowStatus");
        return (String)ob.execute();
    }

    public String getCellColor() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ExpressionFactory ef = ctx.getApplication().getExpressionFactory();
        ValueExpression ve = ef.createValueExpression(ctx.getELContext(), "#{row}", JUCtrlHierNodeBinding.class);

        JUCtrlHierNodeBinding node = (JUCtrlHierNodeBinding)ve.getValue(ctx.getELContext());
        Row row = node.getRow();

        BindingContainer bc = this.getBindings();
        oracle.adf.model.OperationBinding ob =
            (oracle.adf.model.OperationBinding)bc.getOperationBinding("getRowStatusColor");
        ob.getParamsMap().put("row", row);
        String status = (String)ob.execute();

        if (status.equals("Modified")) {
            return "background-color:Red;";
        }

        else if (status.equals("New")) {
            return "background-color:Gray;";
        }

        return null;
    }

}

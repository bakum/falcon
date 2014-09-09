package view;

import java.util.Calendar;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.input.RichInputDate;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class AnalyzeBean {
    private RichInputDate i_dat;

    public AnalyzeBean() {
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void setI_dat(RichInputDate i_dat) {
        this.i_dat = i_dat;
    }

    public RichInputDate getI_dat() {
        return i_dat;
    }

    public void onClickRefresh(ActionEvent actionEvent) {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("setRangeForBepAccessorViewObject");
        Object o = i_dat.getValue();
        if (o == null) {
            Calendar calendar = Calendar.getInstance();
            //calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMaximum(Calendar.DAY_OF_YEAR)); // это будет конец месяца
            java.util.Date pDate = calendar.getTime();
            o = new oracle.jbo.domain.Date(new java.sql.Date(pDate.getTime()));
            i_dat.setValue(o);
        }
        operationBinding.getParamsMap().put("u_dat", o);
        try {
        operationBinding.execute();
        return;
        } catch (Exception ex) {
            System.out.println("failed execution: " + ex.getMessage());
            return;
        }
    }
}

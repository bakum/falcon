package falcon.view.client;

import falcon.view.common.DivisionsView;

import oracle.jbo.client.remote.ViewUsageImpl;
import oracle.jbo.domain.Date;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Jan 26 14:59:29 EET 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class DivisionsViewClient extends ViewUsageImpl implements DivisionsView {
    /**
     * This is the default constructor (do not remove).
     */
    public DivisionsViewClient() {
    }


    public void setRangeForBepAccessorViewObject(Date u_dat) {
        Object _ret =
            getApplicationModuleProxy().riInvokeExportedMethod(this,"setRangeForBepAccessorViewObject",new String [] {"oracle.jbo.domain.Date"},new Object[] {u_dat});
        return;
    }

    public void setRangeForDetailVwSalesPerMonthAccessorViewObject(String u_name, Date u_dat) {
        Object _ret =
            getApplicationModuleProxy().riInvokeExportedMethod(this,"setRangeForDetailVwSalesPerMonthAccessorViewObject",new String [] {"java.lang.String","oracle.jbo.domain.Date"},new Object[] {u_name, u_dat});
        return;
    }

    public void setRangeForDetailVwZatratyPerMonthAccessorViewObject(String u_name, Date u_dat) {
        Object _ret =
            getApplicationModuleProxy().riInvokeExportedMethod(this,"setRangeForDetailVwZatratyPerMonthAccessorViewObject",new String [] {"java.lang.String","oracle.jbo.domain.Date"},new Object[] {u_name, u_dat});
        return;
    }

    public void setRefreshForAccCurDivAccessorViewObject() {
        Object _ret =
            getApplicationModuleProxy().riInvokeExportedMethod(this,"setRefreshForAccCurDivAccessorViewObject",null,null);
        return;
    }
}

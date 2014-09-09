package falcon.view.client;

import falcon.view.common.VwOrderView;

import oracle.jbo.Row;
import oracle.jbo.client.remote.ViewUsageImpl;
import oracle.jbo.domain.Date;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Nov 23 15:31:28 EET 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class VwOrderViewClient extends ViewUsageImpl implements VwOrderView {
    /**
     * This is the default constructor (do not remove).
     */
    public VwOrderViewClient() {
    }


    public String getRowStatus(Row row) {
        Object _ret =
            getApplicationModuleProxy().riInvokeExportedMethod(this,"getRowStatus",new String [] {"oracle.jbo.Row"},new Object[] {row});
        return (String)_ret;
    }

    public void setf_dat(Date value) {
        Object _ret =
            getApplicationModuleProxy().riInvokeExportedMethod(this,"setf_dat",new String [] {"oracle.jbo.domain.Date"},new Object[] {value});
        return;
    }

    public void setl_dat(Date value) {
        Object _ret =
            getApplicationModuleProxy().riInvokeExportedMethod(this,"setl_dat",new String [] {"oracle.jbo.domain.Date"},new Object[] {value});
        return;
    }
}
package falcon.view.client;

import falcon.view.common.VwZatratyPerMonthView;

import oracle.jbo.client.remote.ViewUsageImpl;
import oracle.jbo.domain.Date;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Jan 26 14:04:34 EET 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class VwZatratyPerMonthViewClient extends ViewUsageImpl implements VwZatratyPerMonthView {
    /**
     * This is the default constructor (do not remove).
     */
    public VwZatratyPerMonthViewClient() {
    }

    public void setu_dat(Date value) {
        Object _ret =
            getApplicationModuleProxy().riInvokeExportedMethod(this,"setu_dat",new String [] {"oracle.jbo.domain.Date"},new Object[] {value});
        return;
    }
}
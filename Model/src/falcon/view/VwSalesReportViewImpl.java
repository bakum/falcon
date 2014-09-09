package falcon.view;

import falcon.view.common.VwSalesReportView;

import model.FalconFiltersViewObjectImpl;

import oracle.jbo.domain.Date;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Jan 11 19:25:15 EET 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class VwSalesReportViewImpl extends FalconFiltersViewObjectImpl implements VwSalesReportView {
    /**
     * This is the default constructor (do not remove).
     */
    public VwSalesReportViewImpl() {
    }

    /**
     * Returns the bind variable value for u_name.
     * @return bind variable value for u_name
     */
     public String getu_name() {
         //return (String)getNamedWhereClauseParam("u_name");
         return  getSessionUserName();
     }

    /**
     * Sets <code>value</code> for bind variable u_name.
     * @param value value to bind as u_name
     */
    public void setu_name(String value) {
        setNamedWhereClauseParam("u_name", value);
    }

    /**
     * Returns the variable value for u_dat.
     * @return variable value for u_dat
     */
    public Date getu_dat() {
        return (Date)ensureVariableManager().getVariableValue("u_dat");
    }

    /**
     * Sets <code>value</code> for variable u_dat.
     * @param value value to bind as u_dat
     */
    public void setu_dat(Date value) {
        ensureVariableManager().setVariableValue("u_dat", value);
    }
}

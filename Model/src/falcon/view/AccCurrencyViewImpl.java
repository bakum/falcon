package falcon.view;

import model.FalconFiltersViewObjectImpl;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Apr 14 12:05:49 EEST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AccCurrencyViewImpl extends FalconFiltersViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public AccCurrencyViewImpl() {
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
}

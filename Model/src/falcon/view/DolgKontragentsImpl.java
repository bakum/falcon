package falcon.view;

import java.math.BigDecimal;

import model.FalconFiltersViewObjectImpl;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Nov 24 13:51:00 EET 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class DolgKontragentsImpl extends FalconFiltersViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public DolgKontragentsImpl() {
    }

    /**
     * Returns the bind variable value for u_name.
     * @return bind variable value for u_name
     */
    public String getu_name() {
        //return (String)getNamedWhereClauseParam("u_name");
        return getSessionUserName();
    }

    /**
     * Sets <code>value</code> for bind variable u_name.
     * @param value value to bind as u_name
     */
    public void setu_name(String value) {
        setNamedWhereClauseParam("u_name", value);
    }


}
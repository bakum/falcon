package falcon.view;

import falcon.view.common.DivisionsView;

import java.util.HashMap;
import java.util.Map;

import model.FalconFiltersViewObjectImpl;

import oracle.jbo.Row;
import oracle.jbo.RowSet;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.Date;
import oracle.jbo.server.ViewObjectImpl;

import org.codehaus.groovy.runtime.InvokerHelper;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Jan 11 18:41:40 EET 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class DivisionsViewImpl extends FalconFiltersViewObjectImpl implements DivisionsView {
    /**
     * This is the default constructor (do not remove).
     */
    public DivisionsViewImpl() {
    }
    
    private class AgrFuncHelper extends HashMap {
        private String funcName;

        public AgrFuncHelper(String funcName) {
            super();
            this.funcName = funcName;
        }


        public Object get(Object key) {
            //Invoke private method
            //of our DefaultRowSet (sum,count,avg,min,max)
            //key is argument expression for the aggr funcion being called
            //sum("Salary")

            return InvokerHelper.invokeMethod(getDefaultRowSet(), funcName, key);
        }


    }

    public Map getSum() {
        return new AgrFuncHelper("sum");
    }

    public Map getCount() {
        return new AgrFuncHelper("count");
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

    public void setRangeForDetailVwZatratyPerMonthAccessorViewObject(String u_name, Date u_dat) {
        Row r = getCurrentRow();
        if (r != null) {
            RowSet rs = (RowSet)r.getAttribute("VwZatratyPerMonthView");
            if (rs != null) {
                ViewObject accessorVO = rs.getViewObject();
                accessorVO.ensureVariableManager();
                accessorVO.getVariableManager().setVariableValue("u_name", u_name);
                accessorVO.getVariableManager().setVariableValue("u_dat", u_dat);
                /* ViewCriteriaManager vcm = accessorVO.getViewCriteriaManager();
                ViewCriteria vc = vcm.getViewCriteria("QueryBySalaryRange");
                accessorVO.applyViewCriteria(vc); */
            }
            executeQuery();
        }
    }
    
    public void setRangeForDetailVwSalesPerMonthAccessorViewObject(String u_name, Date u_dat) {
        Row r = getCurrentRow();
        if (r != null) {
            RowSet rs = (RowSet)r.getAttribute("VwSalesPerMonthView");
            if (rs != null) {
                ViewObject accessorVO = rs.getViewObject();
                accessorVO.ensureVariableManager();
                accessorVO.getVariableManager().setVariableValue("u_name", u_name);
                accessorVO.getVariableManager().setVariableValue("u_dat", u_dat);
                /* ViewCriteriaManager vcm = accessorVO.getViewCriteriaManager();
                ViewCriteria vc = vcm.getViewCriteria("QueryBySalaryRange");
                accessorVO.applyViewCriteria(vc); */
            }
            executeQuery();
        }
    }
    
    public void setRangeForBepAccessorViewObject(Date u_dat) {
        Row r = getCurrentRow();
        if (r != null) {
            RowSet rs = (RowSet)r.getAttribute("VwBepView");
            if (rs != null) {
                ViewObject accessorVO = rs.getViewObject();
                accessorVO.ensureVariableManager();
                accessorVO.getVariableManager().setVariableValue("u_dat", u_dat);
                /* ViewCriteriaManager vcm = accessorVO.getViewCriteriaManager();
                ViewCriteria vc = vcm.getViewCriteria("QueryBySalaryRange");
                accessorVO.applyViewCriteria(vc); */
            }
            executeQuery();
        }
    }
    
    public void setRefreshForAccCurDivAccessorViewObject() {
        Row r = getCurrentRow();
        if (r != null) {
            RowSet rs = (RowSet)r.getAttribute("AccCurDivView");
            if (rs != null) {
                ViewObject accessorVO = rs.getViewObject();
                /* accessorVO.ensureVariableManager();
                accessorVO.getVariableManager().setVariableValue("u_name", u_name);
                accessorVO.getVariableManager().setVariableValue("u_dat", u_dat); */
                /* ViewCriteriaManager vcm = accessorVO.getViewCriteriaManager();
                ViewCriteria vc = vcm.getViewCriteria("QueryBySalaryRange");
                accessorVO.applyViewCriteria(vc); */
            }
            executeQuery();
        }
    }

}

package falcon.view.common;

import oracle.jbo.ViewObject;
import oracle.jbo.domain.Date;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Jan 26 14:59:28 EET 2014
// ---------------------------------------------------------------------
public interface DivisionsView extends ViewObject {
    void setRangeForDetailVwZatratyPerMonthAccessorViewObject(String u_name, Date u_dat);

    void setRangeForDetailVwSalesPerMonthAccessorViewObject(String u_name, Date u_dat);

    void setRefreshForAccCurDivAccessorViewObject();

    void setRangeForBepAccessorViewObject(Date u_dat);
}

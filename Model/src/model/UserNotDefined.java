package model;

import java.math.BigDecimal;

public class UserNotDefined extends Exception {

    @SuppressWarnings("compatibility:-6366111609783283022")
    private static final long serialVersionUID = 1L;
    private BigDecimal userId;
 
    public UserNotDefined(BigDecimal userId){
        this.userId = userId;
    }
 
    public String toString(){
        return "Id cannot be zero" + " " +userId ;
    }
}

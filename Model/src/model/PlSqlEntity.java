package model;
import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import java.sql.Types;

import oracle.adf.share.ADFContext;

import oracle.adf.share.security.SecurityContext;

import oracle.jbo.JboException;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;

public abstract class PlSqlEntity extends EntityImpl {
    public PlSqlEntity() {
        super();
    }
    
    protected abstract void callInsertProcedure( TransactionEvent transactionEvent);
    protected abstract void callUpdateProcedure( TransactionEvent transactionEvent);
    protected abstract void callDeleteProcedure( TransactionEvent transactionEvent);
    
    
    private String getSessionUser(){
        ADFContext adfCtx = ADFContext.getCurrent();  
        SecurityContext secCntx = adfCtx.getSecurityContext();  
        String user = secCntx.getUserPrincipal().getName();  
        //String _user = secCntx.getUserName();  
        /* Map sessionScope = ADFContext.getCurrent().getSessionScope();
        String userName = (String)sessionScope.get("userName"); */
        return user;
    }
    
    protected static int NUMBER = Types.NUMERIC;
   /*  public static int DATE = Types.DATE;
    public static int VARCHAR2 = Types.VARCHAR; */
    
    public BigDecimal getSessionUserId() {
        BigDecimal _id = (BigDecimal)callStoredFunction(NUMBER, "GET_USERID(?)",
                                          new Object[] { getSessionUser() });
        if (_id.intValue()==0)
                                 return new BigDecimal(1);
                                 else
        return _id;
      }
    
    protected void callStoredProcedure(String stmt, Object[] bindVars) {
      PreparedStatement st = null;
      try {
        // 1. Create a JDBC PreparedStatement for
        st = getDBTransaction().createPreparedStatement("begin "+stmt+";end;",0);
        if (bindVars != null) {
          // 2. Loop over values for the bind variables passed in, if any
          for (int z = 0; z < bindVars.length; z++) {
            // 3. Set the value of each bind variable in the statement
            st.setObject(z + 1, bindVars[z]);
          }
        }
        // 4. Execute the statement
        st.executeUpdate();
      }
      catch (SQLException e) {
        throw new JboException(e);
      }
      finally {
        if (st != null) {
          try {
            // 5. Close the statement
            st.close();
          }
          catch (SQLException e) {
              System.out.println(e.getMessage());}
        }
      }
    }
    
    protected Object callStoredFunction(int sqlReturnType, String stmt,
                                          Object[] bindVars) {
        CallableStatement st = null;
        try {
          // 1. Create a JDBC CallabledStatement
          st =
              getDBTransaction().createCallableStatement("begin ? := " + stmt + ";end;",
                                                         0);
          // 2. Register the first bind variable for the return value
          st.registerOutParameter(1, sqlReturnType);
          if (bindVars != null) {
            // 3. Loop over values for the bind variables passed in, if any
            for (int z = 0; z < bindVars.length; z++) {
              // 4. Set the value of user-supplied bind vars in the stmt
              st.setObject(z + 2, bindVars[z]);
            }
          }
          // 5. Set the value of user-supplied bind vars in the stmt
          st.executeUpdate();
          // 6. Return the value of the first bind variable
          return st.getObject(1);
        } catch (SQLException e) {
          throw new JboException(e);
        } finally {
          if (st != null) {
            try {
              // 7. Close the statement
              st.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
          }
        }
      }

    protected void doDML(int i, TransactionEvent transactionEvent) {
        if (i == DML_DELETE) {
           callDeleteProcedure(transactionEvent);
          }
       else if (i == DML_INSERT){
          callInsertProcedure(transactionEvent);
       }
        else if (i == DML_UPDATE){
          callUpdateProcedure(transactionEvent);
        } 
        //super.doDML(i, transactionEvent);
    }

    public void lock() {
        //super.lock();
    }
    
}

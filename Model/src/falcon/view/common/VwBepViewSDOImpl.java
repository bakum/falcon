package falcon.view.common;

import org.eclipse.persistence.sdo.SDODataObject;

public class VwBepViewSDOImpl extends SDODataObject implements VwBepViewSDO {

   public static final int START_PROPERTY_INDEX = 0;

   public static final int END_PROPERTY_INDEX = START_PROPERTY_INDEX + 7;

   public VwBepViewSDOImpl() {}

   public java.math.BigDecimal getId() {
      return getBigDecimal(START_PROPERTY_INDEX + 0);
   }

   public void setId(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 0 , value);
   }

   public java.math.BigDecimal getIdDiv() {
      return getBigDecimal(START_PROPERTY_INDEX + 1);
   }

   public void setIdDiv(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 1 , value);
   }

   public java.math.BigDecimal getDoh() {
      return getBigDecimal(START_PROPERTY_INDEX + 2);
   }

   public void setDoh(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 2 , value);
   }

   public java.math.BigDecimal getPerem() {
      return getBigDecimal(START_PROPERTY_INDEX + 3);
   }

   public void setPerem(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 3 , value);
   }

   public java.math.BigDecimal getPostoyan() {
      return getBigDecimal(START_PROPERTY_INDEX + 4);
   }

   public void setPostoyan(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 4 , value);
   }

   public java.math.BigDecimal getBrEp() {
      return getBigDecimal(START_PROPERTY_INDEX + 5);
   }

   public void setBrEp(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 5 , value);
   }

   public java.math.BigDecimal getPrOch() {
      return getBigDecimal(START_PROPERTY_INDEX + 6);
   }

   public void setPrOch(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 6 , value);
   }

   public java.math.BigDecimal getRyChag() {
      return getBigDecimal(START_PROPERTY_INDEX + 7);
   }

   public void setRyChag(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 7 , value);
   }


}


package falcon.view.common;

import org.eclipse.persistence.sdo.SDODataObject;

public class VwOrderViewSDOImpl extends SDODataObject implements VwOrderViewSDO {

   public static final int START_PROPERTY_INDEX = 0;

   public static final int END_PROPERTY_INDEX = START_PROPERTY_INDEX + 26;

   public VwOrderViewSDOImpl() {}

   public java.math.BigDecimal getId() {
      return getBigDecimal(START_PROPERTY_INDEX + 0);
   }

   public void setId(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 0 , value);
   }

   public java.lang.String getNum() {
      return getString(START_PROPERTY_INDEX + 1);
   }

   public void setNum(java.lang.String value) {
      set(START_PROPERTY_INDEX + 1 , value);
   }

   public java.sql.Timestamp getDat() {
      return (java.sql.Timestamp)get(START_PROPERTY_INDEX + 2);
   }

   public void setDat(java.sql.Timestamp value) {
      set(START_PROPERTY_INDEX + 2 , value);
   }

   public java.lang.String getKontrag() {
      return getString(START_PROPERTY_INDEX + 3);
   }

   public void setKontrag(java.lang.String value) {
      set(START_PROPERTY_INDEX + 3 , value);
   }

   public java.lang.String getUserS() {
      return getString(START_PROPERTY_INDEX + 4);
   }

   public void setUserS(java.lang.String value) {
      set(START_PROPERTY_INDEX + 4 , value);
   }

   public java.lang.String getDivision() {
      return getString(START_PROPERTY_INDEX + 5);
   }

   public void setDivision(java.lang.String value) {
      set(START_PROPERTY_INDEX + 5 , value);
   }

   public java.lang.String getKassa() {
      return getString(START_PROPERTY_INDEX + 6);
   }

   public void setKassa(java.lang.String value) {
      set(START_PROPERTY_INDEX + 6 , value);
   }

   public java.lang.Integer getKredit() {
      return new Integer(getInt(START_PROPERTY_INDEX + 7));
   }

   public void setKredit(java.lang.Integer value) {
      set(START_PROPERTY_INDEX + 7 , value);
   }

   public java.math.BigDecimal getMetrag() {
      return getBigDecimal(START_PROPERTY_INDEX + 8);
   }

   public void setMetrag(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 8 , value);
   }

   public java.math.BigDecimal getSumma() {
      return getBigDecimal(START_PROPERTY_INDEX + 9);
   }

   public void setSumma(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 9 , value);
   }

   public java.math.BigDecimal getZakSumm() {
      return getBigDecimal(START_PROPERTY_INDEX + 10);
   }

   public void setZakSumm(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 10 , value);
   }

   public java.math.BigDecimal getDolgKlienta() {
      return getBigDecimal(START_PROPERTY_INDEX + 11);
   }

   public void setDolgKlienta(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 11 , value);
   }

   public java.math.BigDecimal getZamer() {
      return getBigDecimal(START_PROPERTY_INDEX + 12);
   }

   public void setZamer(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 12 , value);
   }

   public java.math.BigDecimal getKonsult() {
      return getBigDecimal(START_PROPERTY_INDEX + 13);
   }

   public void setKonsult(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 13 , value);
   }

   public java.math.BigDecimal getMontag() {
      return getBigDecimal(START_PROPERTY_INDEX + 14);
   }

   public void setMontag(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 14 , value);
   }

   public java.math.BigDecimal getDostavka() {
      return getBigDecimal(START_PROPERTY_INDEX + 15);
   }

   public void setDostavka(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 15 , value);
   }

   public java.math.BigDecimal getBank() {
      return getBigDecimal(START_PROPERTY_INDEX + 16);
   }

   public void setBank(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 16 , value);
   }

   public java.lang.String getKonsultName() {
      return getString(START_PROPERTY_INDEX + 17);
   }

   public void setKonsultName(java.lang.String value) {
      set(START_PROPERTY_INDEX + 17 , value);
   }

   public java.lang.String getMontagName() {
      return getString(START_PROPERTY_INDEX + 18);
   }

   public void setMontagName(java.lang.String value) {
      set(START_PROPERTY_INDEX + 18 , value);
   }

   public java.lang.String getZamerName() {
      return getString(START_PROPERTY_INDEX + 19);
   }

   public void setZamerName(java.lang.String value) {
      set(START_PROPERTY_INDEX + 19 , value);
   }

   public java.lang.Integer getReturned() {
      return new Integer(getInt(START_PROPERTY_INDEX + 20));
   }

   public void setReturned(java.lang.Integer value) {
      set(START_PROPERTY_INDEX + 20 , value);
   }

   public java.math.BigDecimal getKonsulrId() {
      return getBigDecimal(START_PROPERTY_INDEX + 21);
   }

   public void setKonsulrId(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 21 , value);
   }

   public java.math.BigDecimal getMontagId() {
      return getBigDecimal(START_PROPERTY_INDEX + 22);
   }

   public void setMontagId(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 22 , value);
   }

   public java.math.BigDecimal getZamerId() {
      return getBigDecimal(START_PROPERTY_INDEX + 23);
   }

   public void setZamerId(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 23 , value);
   }

   public java.math.BigDecimal getTotal_Cost() {
      return getBigDecimal(START_PROPERTY_INDEX + 24);
   }

   public void setTotal_Cost(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 24 , value);
   }

   public java.math.BigDecimal getTotal_Summa() {
      return getBigDecimal(START_PROPERTY_INDEX + 25);
   }

   public void setTotal_Summa(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 25 , value);
   }

   public java.lang.Boolean isKreditBoolean() {
      return new Boolean(getBoolean(START_PROPERTY_INDEX + 26));
   }

   public void setKreditBoolean(java.lang.Boolean value) {
      set(START_PROPERTY_INDEX + 26 , value);
   }


}


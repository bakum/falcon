package falcon.entity;

import java.math.BigDecimal;

import java.sql.SQLException;

import java.util.Calendar;

import model.PlSqlEntity;

import model.UserNotDefined;

import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Timestamp;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Nov 19 12:38:47 EET 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class VwOrderImpl extends PlSqlEntity {
    
    public boolean isNegative(BigDecimal b)
        {
            if (b==null) return false;
            return b.signum() == -1;
        }
    @Override
    protected void callInsertProcedure(TransactionEvent transactionEvent) {
        BigDecimal id = getSessionUserId();
        //BigDecimal id = new BigDecimal(1);// for tests
        try {
            if (id.intValue() == 0)

                throw new UserNotDefined(id);

            else
                callStoredProcedure("ORDER_PKG.INSERT_ORDER(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                                    new Object[] { id, getNum(),getKontrag(), getKredit(), getDat(), getMetrag(), getSumma(),
                                                   getZakSumm(), getKonsulrId(), getMontagId(), getZamerId(), 
                                                   getZamer(), getKonsult(), getMontag(), getBank() });
        } catch (UserNotDefined e) {
            System.out.println(e.toString());
        }
    }

    @Override
    protected void callUpdateProcedure(TransactionEvent transactionEvent) {
        BigDecimal zak_s = getZakSumm();
        BigDecimal zamer_s = getZamer();
        BigDecimal konsult_s = getKonsult();
        BigDecimal bank_s = getBank();
        BigDecimal montag_s = getMontag();
        if (isNegative(zak_s)) zak_s = zak_s.multiply(new BigDecimal(-1));
        if (isNegative(zamer_s)) zamer_s = zamer_s.multiply(new BigDecimal(-1));
        if (isNegative(konsult_s)) konsult_s = konsult_s.multiply(new BigDecimal(-1));
        if (isNegative(bank_s)) bank_s = bank_s.multiply(new BigDecimal(-1));
        if (isNegative(montag_s)) montag_s = montag_s.multiply(new BigDecimal(-1));
        callStoredProcedure("ORDER_PKG.update_order_by_params(?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                            new Object[] { getId(), getKontrag(), getKredit(), getDat(), getMetrag(), getSumma(),
                                           zak_s, getKonsulrId(), getMontagId(), getZamerId(),zamer_s, konsult_s, bank_s,  montag_s});
    }

    @Override
    protected void callDeleteProcedure(TransactionEvent transactionEvent) {
        callStoredProcedure("ORDER_PKG.DELETE_ORDER(?)", new Object[] { getId() });
    }

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        Id {
            public Object get(VwOrderImpl obj) {
                return obj.getId();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        Num {
            public Object get(VwOrderImpl obj) {
                return obj.getNum();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setNum((String)value);
            }
        }
        ,
        Dat {
            public Object get(VwOrderImpl obj) {
                return obj.getDat();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setDat((Timestamp)value);
            }
        }
        ,
        Kontrag {
            public Object get(VwOrderImpl obj) {
                return obj.getKontrag();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setKontrag((String)value);
            }
        }
        ,
        UserS {
            public Object get(VwOrderImpl obj) {
                return obj.getUserS();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        Division {
            public Object get(VwOrderImpl obj) {
                return obj.getDivision();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        Kassa {
            public Object get(VwOrderImpl obj) {
                return obj.getKassa();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        Kredit {
            public Object get(VwOrderImpl obj) {
                return obj.getKredit();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setKredit((Integer)value);
            }
        }
        ,
        Metrag {
            public Object get(VwOrderImpl obj) {
                return obj.getMetrag();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setMetrag((BigDecimal)value);
            }
        }
        ,
        Summa {
            public Object get(VwOrderImpl obj) {
                return obj.getSumma();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setSumma((BigDecimal)value);
            }
        }
        ,
        ZakSumm {
            public Object get(VwOrderImpl obj) {
                return obj.getZakSumm();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setZakSumm((BigDecimal)value);
            }
        }
        ,
        DolgKlienta {
            public Object get(VwOrderImpl obj) {
                return obj.getDolgKlienta();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        Zamer {
            public Object get(VwOrderImpl obj) {
                return obj.getZamer();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setZamer((BigDecimal)value);
            }
        }
        ,
        Konsult {
            public Object get(VwOrderImpl obj) {
                return obj.getKonsult();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setKonsult((BigDecimal)value);
            }
        }
        ,
        Montag {
            public Object get(VwOrderImpl obj) {
                return obj.getMontag();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setMontag((BigDecimal)value);
            }
        }
        ,
        Dostavka {
            public Object get(VwOrderImpl obj) {
                return obj.getDostavka();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        Bank {
            public Object get(VwOrderImpl obj) {
                return obj.getBank();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setBank((BigDecimal)value);
            }
        }
        ,
        KonsultName {
            public Object get(VwOrderImpl obj) {
                return obj.getKonsultName();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setKonsultName((String)value);
            }
        }
        ,
        MontagName {
            public Object get(VwOrderImpl obj) {
                return obj.getMontagName();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setMontagName((String)value);
            }
        }
        ,
        ZamerName {
            public Object get(VwOrderImpl obj) {
                return obj.getZamerName();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setZamerName((String)value);
            }
        }
        ,
        Returned {
            public Object get(VwOrderImpl obj) {
                return obj.getReturned();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setReturned((Integer)value);
            }
        }
        ,
        KonsulrId {
            public Object get(VwOrderImpl obj) {
                return obj.getKonsulrId();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setKonsulrId((BigDecimal)value);
            }
        }
        ,
        MontagId {
            public Object get(VwOrderImpl obj) {
                return obj.getMontagId();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setMontagId((BigDecimal)value);
            }
        }
        ,
        ZamerId {
            public Object get(VwOrderImpl obj) {
                return obj.getZamerId();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setZamerId((BigDecimal)value);
            }
        }
        ,
        OrdersTabPartOplaty {
            public Object get(VwOrderImpl obj) {
                return obj.getOrdersTabPartOplaty();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        AccCost {
            public Object get(VwOrderImpl obj) {
                return obj.getAccCost();
            }

            public void put(VwOrderImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(VwOrderImpl object);

        public abstract void put(VwOrderImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int ID = AttributesEnum.Id.index();
    public static final int NUM = AttributesEnum.Num.index();
    public static final int DAT = AttributesEnum.Dat.index();
    public static final int KONTRAG = AttributesEnum.Kontrag.index();
    public static final int USERS = AttributesEnum.UserS.index();
    public static final int DIVISION = AttributesEnum.Division.index();
    public static final int KASSA = AttributesEnum.Kassa.index();
    public static final int KREDIT = AttributesEnum.Kredit.index();
    public static final int METRAG = AttributesEnum.Metrag.index();
    public static final int SUMMA = AttributesEnum.Summa.index();
    public static final int ZAKSUMM = AttributesEnum.ZakSumm.index();
    public static final int DOLGKLIENTA = AttributesEnum.DolgKlienta.index();
    public static final int ZAMER = AttributesEnum.Zamer.index();
    public static final int KONSULT = AttributesEnum.Konsult.index();
    public static final int MONTAG = AttributesEnum.Montag.index();
    public static final int DOSTAVKA = AttributesEnum.Dostavka.index();
    public static final int BANK = AttributesEnum.Bank.index();
    public static final int KONSULTNAME = AttributesEnum.KonsultName.index();
    public static final int MONTAGNAME = AttributesEnum.MontagName.index();
    public static final int ZAMERNAME = AttributesEnum.ZamerName.index();
    public static final int RETURNED = AttributesEnum.Returned.index();
    public static final int KONSULRID = AttributesEnum.KonsulrId.index();
    public static final int MONTAGID = AttributesEnum.MontagId.index();
    public static final int ZAMERID = AttributesEnum.ZamerId.index();
    public static final int ORDERSTABPARTOPLATY = AttributesEnum.OrdersTabPartOplaty.index();
    public static final int ACCCOST = AttributesEnum.AccCost.index();

    /**
     * This is the default constructor (do not remove).
     */
    public VwOrderImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("falcon.entity.VwOrder");
    }

    /**
     * Gets the attribute value for Id, using the alias name Id.
     * @return the value of Id
     */
    public BigDecimal getId() {
        return (BigDecimal)getAttributeInternal(ID);
    }

    /**
     * Gets the attribute value for Num, using the alias name Num.
     * @return the value of Num
     */
    public String getNum() {
        return (String)getAttributeInternal(NUM);
    }

    /**
     * Sets <code>value</code> as the attribute value for Num.
     * @param value value to set the Num
     */
    public void setNum(String value) {
        setAttributeInternal(NUM, value);
    }

    /**
     * Gets the attribute value for Dat, using the alias name Dat.
     * @return the value of Dat
     */
    public Timestamp getDat() {
        return (Timestamp)getAttributeInternal(DAT);
    }

    /**
     * Sets <code>value</code> as the attribute value for Dat.
     * @param value value to set the Dat
     */
    public void setDat(Timestamp value) {
        setAttributeInternal(DAT, value);
    }

    /**
     * Gets the attribute value for Kontrag, using the alias name Kontrag.
     * @return the value of Kontrag
     */
    public String getKontrag() {
        return (String)getAttributeInternal(KONTRAG);
    }

    /**
     * Sets <code>value</code> as the attribute value for Kontrag.
     * @param value value to set the Kontrag
     */
    public void setKontrag(String value) {
        setAttributeInternal(KONTRAG, value);
    }

    /**
     * Gets the attribute value for UserS, using the alias name UserS.
     * @return the value of UserS
     */
    public String getUserS() {
        return (String)getAttributeInternal(USERS);
    }

    /**
     * Gets the attribute value for Division, using the alias name Division.
     * @return the value of Division
     */
    public String getDivision() {
        return (String)getAttributeInternal(DIVISION);
    }

    /**
     * Gets the attribute value for Kassa, using the alias name Kassa.
     * @return the value of Kassa
     */
    public String getKassa() {
        return (String)getAttributeInternal(KASSA);
    }

    /**
     * Gets the attribute value for Kredit, using the alias name Kredit.
     * @return the value of Kredit
     */
    public Integer getKredit() {
        return (Integer)getAttributeInternal(KREDIT);
    }

    /**
     * Sets <code>value</code> as the attribute value for Kredit.
     * @param value value to set the Kredit
     */
    public void setKredit(Integer value) {
        setAttributeInternal(KREDIT, value);
    }

    /**
     * Gets the attribute value for Metrag, using the alias name Metrag.
     * @return the value of Metrag
     */
    public BigDecimal getMetrag() {
        return (BigDecimal)getAttributeInternal(METRAG);
    }

    /**
     * Sets <code>value</code> as the attribute value for Metrag.
     * @param value value to set the Metrag
     */
    public void setMetrag(BigDecimal value) {
        setAttributeInternal(METRAG, value);
    }

    /**
     * Gets the attribute value for Summa, using the alias name Summa.
     * @return the value of Summa
     */
    public BigDecimal getSumma() {
        return (BigDecimal)getAttributeInternal(SUMMA);
    }

    /**
     * Sets <code>value</code> as the attribute value for Summa.
     * @param value value to set the Summa
     */
    public void setSumma(BigDecimal value) {
        setAttributeInternal(SUMMA, value);
    }

    /**
     * Gets the attribute value for ZakSumm, using the alias name ZakSumm.
     * @return the value of ZakSumm
     */
    public BigDecimal getZakSumm() {
        return (BigDecimal)getAttributeInternal(ZAKSUMM);
    }

    /**
     * Sets <code>value</code> as the attribute value for ZakSumm.
     * @param value value to set the ZakSumm
     */
    public void setZakSumm(BigDecimal value) {
        setAttributeInternal(ZAKSUMM, value);
    }

    /**
     * Gets the attribute value for DolgKlienta, using the alias name DolgKlienta.
     * @return the value of DolgKlienta
     */
    public BigDecimal getDolgKlienta() {
        return (BigDecimal)getAttributeInternal(DOLGKLIENTA);
    }

    /**
     * Gets the attribute value for Zamer, using the alias name Zamer.
     * @return the value of Zamer
     */
    public BigDecimal getZamer() {
        return (BigDecimal)getAttributeInternal(ZAMER);
    }

    /**
     * Sets <code>value</code> as the attribute value for Zamer.
     * @param value value to set the Zamer
     */
    public void setZamer(BigDecimal value) {
        setAttributeInternal(ZAMER, value);
    }

    /**
     * Gets the attribute value for Konsult, using the alias name Konsult.
     * @return the value of Konsult
     */
    public BigDecimal getKonsult() {
        return (BigDecimal)getAttributeInternal(KONSULT);
    }

    /**
     * Sets <code>value</code> as the attribute value for Konsult.
     * @param value value to set the Konsult
     */
    public void setKonsult(BigDecimal value) {
        setAttributeInternal(KONSULT, value);
    }

    /**
     * Gets the attribute value for Montag, using the alias name Montag.
     * @return the value of Montag
     */
    public BigDecimal getMontag() {
        return (BigDecimal)getAttributeInternal(MONTAG);
    }

    /**
     * Sets <code>value</code> as the attribute value for Montag.
     * @param value value to set the Montag
     */
    public void setMontag(BigDecimal value) {
        setAttributeInternal(MONTAG, value);
    }

    /**
     * Gets the attribute value for Dostavka, using the alias name Dostavka.
     * @return the value of Dostavka
     */
    public BigDecimal getDostavka() {
        return (BigDecimal)getAttributeInternal(DOSTAVKA);
    }

    /**
     * Gets the attribute value for Bank, using the alias name Bank.
     * @return the value of Bank
     */
    public BigDecimal getBank() {
        return (BigDecimal)getAttributeInternal(BANK);
    }

    /**
     * Sets <code>value</code> as the attribute value for Bank.
     * @param value value to set the Bank
     */
    public void setBank(BigDecimal value) {
        setAttributeInternal(BANK, value);
    }

    /**
     * Gets the attribute value for KonsultName, using the alias name KonsultName.
     * @return the value of KonsultName
     */
    public String getKonsultName() {
        return (String)getAttributeInternal(KONSULTNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for KonsultName.
     * @param value value to set the KonsultName
     */
    public void setKonsultName(String value) {
        setAttributeInternal(KONSULTNAME, value);
    }

    /**
     * Gets the attribute value for MontagName, using the alias name MontagName.
     * @return the value of MontagName
     */
    public String getMontagName() {
        return (String)getAttributeInternal(MONTAGNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for MontagName.
     * @param value value to set the MontagName
     */
    public void setMontagName(String value) {
        setAttributeInternal(MONTAGNAME, value);
    }

    /**
     * Gets the attribute value for ZamerName, using the alias name ZamerName.
     * @return the value of ZamerName
     */
    public String getZamerName() {
        return (String)getAttributeInternal(ZAMERNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for ZamerName.
     * @param value value to set the ZamerName
     */
    public void setZamerName(String value) {
        setAttributeInternal(ZAMERNAME, value);
    }

    /**
     * Gets the attribute value for Returned, using the alias name Returned.
     * @return the value of Returned
     */
    public Integer getReturned() {
        return (Integer)getAttributeInternal(RETURNED);
    }

    /**
     * Sets <code>value</code> as the attribute value for Returned.
     * @param value value to set the Returned
     */
    public void setReturned(Integer value) {
        setAttributeInternal(RETURNED, value);
    }

    /**
     * Gets the attribute value for KonsulrId, using the alias name KonsulrId.
     * @return the value of KonsulrId
     */
    public BigDecimal getKonsulrId() {
        return (BigDecimal)getAttributeInternal(KONSULRID);
    }

    /**
     * Sets <code>value</code> as the attribute value for KonsulrId.
     * @param value value to set the KonsulrId
     */
    public void setKonsulrId(BigDecimal value) {
        setAttributeInternal(KONSULRID, value);
    }

    /**
     * Gets the attribute value for MontagId, using the alias name MontagId.
     * @return the value of MontagId
     */
    public BigDecimal getMontagId() {
        return (BigDecimal)getAttributeInternal(MONTAGID);
    }

    /**
     * Sets <code>value</code> as the attribute value for MontagId.
     * @param value value to set the MontagId
     */
    public void setMontagId(BigDecimal value) {
        setAttributeInternal(MONTAGID, value);
    }

    /**
     * Gets the attribute value for ZamerId, using the alias name ZamerId.
     * @return the value of ZamerId
     */
    public BigDecimal getZamerId() {
        return (BigDecimal)getAttributeInternal(ZAMERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ZamerId.
     * @param value value to set the ZamerId
     */
    public void setZamerId(BigDecimal value) {
        setAttributeInternal(ZAMERID, value);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value, AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getOrdersTabPartOplaty() {
        return (RowIterator)getAttributeInternal(ORDERSTABPARTOPLATY);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getAccCost() {
        return (RowIterator)getAttributeInternal(ACCCOST);
    }

    /**
     * @param id key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal id) {
        return new Key(new Object[]{id});
    }


}

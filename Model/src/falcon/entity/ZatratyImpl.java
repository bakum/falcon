package falcon.entity;

import java.math.BigDecimal;

import model.PlSqlEntity;

import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Timestamp;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Dec 13 13:53:52 EET 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ZatratyImpl extends PlSqlEntity {
    @Override
    protected void callInsertProcedure(TransactionEvent transactionEvent) {
        BigDecimal u_id = getSessionUserId();
        callStoredProcedure("zatraty_pkg.insert_zatraty(?,?,?)", new Object[] { u_id, getParentId(), getFullname() });
    }

    @Override
    protected void callUpdateProcedure(TransactionEvent transactionEvent) {
        callStoredProcedure("zatraty_pkg.update_zatraty(?,?,?)",
                            new Object[] { getId(), getParentId(), getFullname() });
    }

    @Override
    protected void callDeleteProcedure(TransactionEvent transactionEvent) {
        callStoredProcedure("zatraty_pkg.delete_zatraty(?)", new Object[] { getId() });
    }

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        Id {
            public Object get(ZatratyImpl obj) {
                return obj.getId();
            }

            public void put(ZatratyImpl obj, Object value) {
                obj.setId((BigDecimal)value);
            }
        },
        ParentId {
            public Object get(ZatratyImpl obj) {
                return obj.getParentId();
            }

            public void put(ZatratyImpl obj, Object value) {
                obj.setParentId((BigDecimal)value);
            }
        },
        IsGroup {
            public Object get(ZatratyImpl obj) {
                return obj.getIsGroup();
            }

            public void put(ZatratyImpl obj, Object value) {
                obj.setIsGroup((Integer)value);
            }
        },
        Fullname {
            public Object get(ZatratyImpl obj) {
                return obj.getFullname();
            }

            public void put(ZatratyImpl obj, Object value) {
                obj.setFullname((String)value);
            }
        },
        Deleted {
            public Object get(ZatratyImpl obj) {
                return obj.getDeleted();
            }

            public void put(ZatratyImpl obj, Object value) {
                obj.setDeleted((Integer)value);
            }
        },
        Code {
            public Object get(ZatratyImpl obj) {
                return obj.getCode();
            }

            public void put(ZatratyImpl obj, Object value) {
                obj.setCode((String)value);
            }
        },
        KontragentId {
            public Object get(ZatratyImpl obj) {
                return obj.getKontragentId();
            }

            public void put(ZatratyImpl obj, Object value) {
                obj.setKontragentId((BigDecimal)value);
            }
        },
        SyncStr {
            public Object get(ZatratyImpl obj) {
                return obj.getSyncStr();
            }

            public void put(ZatratyImpl obj, Object value) {
                obj.setSyncStr((String)value);
            }
        },
        SyncKey {
            public Object get(ZatratyImpl obj) {
                return obj.getSyncKey();
            }

            public void put(ZatratyImpl obj, Object value) {
                obj.setSyncKey((Integer)value);
            }
        },
        Version {
            public Object get(ZatratyImpl obj) {
                return obj.getVersion();
            }

            public void put(ZatratyImpl obj, Object value) {
                obj.setVersion((Timestamp)value);
            }
        },
        ScalesZatrat {
            public Object get(ZatratyImpl obj) {
                return obj.getScalesZatrat();
            }

            public void put(ZatratyImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        },
        AccZatr {
            public Object get(ZatratyImpl obj) {
                return obj.getAccZatr();
            }

            public void put(ZatratyImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        },
        Zatraty {
            public Object get(ZatratyImpl obj) {
                return obj.getZatraty();
            }

            public void put(ZatratyImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        },
        ParentIdZatraty {
            public Object get(ZatratyImpl obj) {
                return obj.getParentIdZatraty();
            }

            public void put(ZatratyImpl obj, Object value) {
                obj.setParentIdZatraty((ZatratyImpl)value);
            }
        },
        OrdersTabPartZatraty {
            public Object get(ZatratyImpl obj) {
                return obj.getOrdersTabPartZatraty();
            }

            public void put(ZatratyImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        },
        OtherZatratyTabPartZatraty {
            public Object get(ZatratyImpl obj) {
                return obj.getOtherZatratyTabPartZatraty();
            }

            public void put(ZatratyImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        },
        AccCost {
            public Object get(ZatratyImpl obj) {
                return obj.getAccCost();
            }

            public void put(ZatratyImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        },
        Kontragents {
            public Object get(ZatratyImpl obj) {
                return obj.getKontragents();
            }

            public void put(ZatratyImpl obj, Object value) {
                obj.setKontragents((EntityImpl)value);
            }
        };
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(ZatratyImpl object);

        public abstract void put(ZatratyImpl object, Object value);

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
    public static final int PARENTID = AttributesEnum.ParentId.index();
    public static final int ISGROUP = AttributesEnum.IsGroup.index();
    public static final int FULLNAME = AttributesEnum.Fullname.index();
    public static final int DELETED = AttributesEnum.Deleted.index();
    public static final int CODE = AttributesEnum.Code.index();
    public static final int KONTRAGENTID = AttributesEnum.KontragentId.index();
    public static final int SYNCSTR = AttributesEnum.SyncStr.index();
    public static final int SYNCKEY = AttributesEnum.SyncKey.index();
    public static final int VERSION = AttributesEnum.Version.index();
    public static final int SCALESZATRAT = AttributesEnum.ScalesZatrat.index();
    public static final int ACCZATR = AttributesEnum.AccZatr.index();
    public static final int ZATRATY = AttributesEnum.Zatraty.index();
    public static final int PARENTIDZATRATY = AttributesEnum.ParentIdZatraty.index();
    public static final int ORDERSTABPARTZATRATY = AttributesEnum.OrdersTabPartZatraty.index();
    public static final int OTHERZATRATYTABPARTZATRATY = AttributesEnum.OtherZatratyTabPartZatraty.index();
    public static final int ACCCOST = AttributesEnum.AccCost.index();
    public static final int KONTRAGENTS = AttributesEnum.Kontragents.index();

    /**
     * This is the default constructor (do not remove).
     */
    public ZatratyImpl() {
    }

    /**
     * Gets the attribute value for Id, using the alias name Id.
     * @return the value of Id
     */
    public BigDecimal getId() {
        return (BigDecimal)getAttributeInternal(ID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Id.
     * @param value value to set the Id
     */
    public void setId(BigDecimal value) {
        setAttributeInternal(ID, value);
    }

    /**
     * Gets the attribute value for ParentId, using the alias name ParentId.
     * @return the value of ParentId
     */
    public BigDecimal getParentId() {
        return (BigDecimal)getAttributeInternal(PARENTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ParentId.
     * @param value value to set the ParentId
     */
    public void setParentId(BigDecimal value) {
        setAttributeInternal(PARENTID, value);
    }

    /**
     * Gets the attribute value for IsGroup, using the alias name IsGroup.
     * @return the value of IsGroup
     */
    public Integer getIsGroup() {
        return (Integer)getAttributeInternal(ISGROUP);
    }

    /**
     * Sets <code>value</code> as the attribute value for IsGroup.
     * @param value value to set the IsGroup
     */
    public void setIsGroup(Integer value) {
        setAttributeInternal(ISGROUP, value);
    }

    /**
     * Gets the attribute value for Fullname, using the alias name Fullname.
     * @return the value of Fullname
     */
    public String getFullname() {
        return (String)getAttributeInternal(FULLNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for Fullname.
     * @param value value to set the Fullname
     */
    public void setFullname(String value) {
        setAttributeInternal(FULLNAME, value);
    }

    /**
     * Gets the attribute value for Deleted, using the alias name Deleted.
     * @return the value of Deleted
     */
    public Integer getDeleted() {
        return (Integer)getAttributeInternal(DELETED);
    }

    /**
     * Sets <code>value</code> as the attribute value for Deleted.
     * @param value value to set the Deleted
     */
    public void setDeleted(Integer value) {
        setAttributeInternal(DELETED, value);
    }

    /**
     * Gets the attribute value for Code, using the alias name Code.
     * @return the value of Code
     */
    public String getCode() {
        return (String)getAttributeInternal(CODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Code.
     * @param value value to set the Code
     */
    public void setCode(String value) {
        setAttributeInternal(CODE, value);
    }

    /**
     * Gets the attribute value for KontragentId, using the alias name KontragentId.
     * @return the value of KontragentId
     */
    public BigDecimal getKontragentId() {
        return (BigDecimal)getAttributeInternal(KONTRAGENTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for KontragentId.
     * @param value value to set the KontragentId
     */
    public void setKontragentId(BigDecimal value) {
        setAttributeInternal(KONTRAGENTID, value);
    }

    /**
     * Gets the attribute value for SyncStr, using the alias name SyncStr.
     * @return the value of SyncStr
     */
    public String getSyncStr() {
        return (String)getAttributeInternal(SYNCSTR);
    }

    /**
     * Sets <code>value</code> as the attribute value for SyncStr.
     * @param value value to set the SyncStr
     */
    public void setSyncStr(String value) {
        setAttributeInternal(SYNCSTR, value);
    }

    /**
     * Gets the attribute value for SyncKey, using the alias name SyncKey.
     * @return the value of SyncKey
     */
    public Integer getSyncKey() {
        return (Integer)getAttributeInternal(SYNCKEY);
    }

    /**
     * Sets <code>value</code> as the attribute value for SyncKey.
     * @param value value to set the SyncKey
     */
    public void setSyncKey(Integer value) {
        setAttributeInternal(SYNCKEY, value);
    }

    /**
     * Gets the attribute value for Version, using the alias name Version.
     * @return the value of Version
     */
    public Timestamp getVersion() {
        return (Timestamp)getAttributeInternal(VERSION);
    }

    /**
     * Sets <code>value</code> as the attribute value for Version.
     * @param value value to set the Version
     */
    public void setVersion(Timestamp value) {
        setAttributeInternal(VERSION, value);
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
    public RowIterator getScalesZatrat() {
        return (RowIterator)getAttributeInternal(SCALESZATRAT);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getAccZatr() {
        return (RowIterator)getAttributeInternal(ACCZATR);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getZatraty() {
        return (RowIterator)getAttributeInternal(ZATRATY);
    }

    /**
     * @return the associated entity ZatratyImpl.
     */
    public ZatratyImpl getParentIdZatraty() {
        return (ZatratyImpl)getAttributeInternal(PARENTIDZATRATY);
    }

    /**
     * Sets <code>value</code> as the associated entity ZatratyImpl.
     */
    public void setParentIdZatraty(ZatratyImpl value) {
        setAttributeInternal(PARENTIDZATRATY, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getOrdersTabPartZatraty() {
        return (RowIterator)getAttributeInternal(ORDERSTABPARTZATRATY);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getOtherZatratyTabPartZatraty() {
        return (RowIterator)getAttributeInternal(OTHERZATRATYTABPARTZATRATY);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getAccCost() {
        return (RowIterator)getAttributeInternal(ACCCOST);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getKontragents() {
        return (EntityImpl)getAttributeInternal(KONTRAGENTS);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setKontragents(EntityImpl value) {
        setAttributeInternal(KONTRAGENTS, value);
    }

    /**
     * @param id key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal id) {
        return new Key(new Object[] { id });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("falcon.entity.Zatraty");
    }
}

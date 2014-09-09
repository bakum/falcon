package falcon.entity;

import java.math.BigDecimal;

import model.PlSqlEntity;

import model.UserNotDefined;

import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.domain.Timestamp;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Nov 22 13:53:27 EET 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OtherZatratyImpl extends PlSqlEntity {
    @Override
    protected void callInsertProcedure(TransactionEvent transactionEvent) {
        BigDecimal id = getSessionUserId();
        //BigDecimal id = new BigDecimal(1);// for tests
        try {
            if (id.intValue() == 0)

                throw new UserNotDefined(id);

            else
                callStoredProcedure("otherzatr_pkg.insert_otherzatr(?,?,?)",
                                    new Object[] { id, getDat(), getComments() });
        } catch (UserNotDefined e) {
            System.out.println(e.toString());
        }
    }

    @Override
    protected void callUpdateProcedure(TransactionEvent transactionEvent) {
        BigDecimal id = new BigDecimal(getId().getValue());
        callStoredProcedure("otherzatr_pkg.update_otherzatr(?,?,?)",
                            new Object[] { id, getDat(), getComments() });
    }

    @Override
    protected void callDeleteProcedure(TransactionEvent transactionEvent) {
        BigDecimal id = new BigDecimal(getId().getValue());
        callStoredProcedure("otherzatr_pkg.delete_otherzatr(?)",
                            new Object[] { id });
    }

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        Id {
            public Object get(OtherZatratyImpl obj) {
                return obj.getId();
            }

            public void put(OtherZatratyImpl obj, Object value) {
                obj.setId((DBSequence)value);
            }
        }
        ,
        SyncStr {
            public Object get(OtherZatratyImpl obj) {
                return obj.getSyncStr();
            }

            public void put(OtherZatratyImpl obj, Object value) {
                obj.setSyncStr((String)value);
            }
        }
        ,
        Dat {
            public Object get(OtherZatratyImpl obj) {
                return obj.getDat();
            }

            public void put(OtherZatratyImpl obj, Object value) {
                obj.setDat((Timestamp)value);
            }
        }
        ,
        Num {
            public Object get(OtherZatratyImpl obj) {
                return obj.getNum();
            }

            public void put(OtherZatratyImpl obj, Object value) {
                obj.setNum((String)value);
            }
        }
        ,
        SyncKey {
            public Object get(OtherZatratyImpl obj) {
                return obj.getSyncKey();
            }

            public void put(OtherZatratyImpl obj, Object value) {
                obj.setSyncKey((Long)value);
            }
        }
        ,
        Deleted {
            public Object get(OtherZatratyImpl obj) {
                return obj.getDeleted();
            }

            public void put(OtherZatratyImpl obj, Object value) {
                obj.setDeleted((Long)value);
            }
        }
        ,
        Posted {
            public Object get(OtherZatratyImpl obj) {
                return obj.getPosted();
            }

            public void put(OtherZatratyImpl obj, Object value) {
                obj.setPosted((Long)value);
            }
        }
        ,
        OrganisationRef {
            public Object get(OtherZatratyImpl obj) {
                return obj.getOrganisationRef();
            }

            public void put(OtherZatratyImpl obj, Object value) {
                obj.setOrganisationRef((String)value);
            }
        }
        ,
        DivisionId {
            public Object get(OtherZatratyImpl obj) {
                return obj.getDivisionId();
            }

            public void put(OtherZatratyImpl obj, Object value) {
                obj.setDivisionId((Long)value);
            }
        }
        ,
        UserId {
            public Object get(OtherZatratyImpl obj) {
                return obj.getUserId();
            }

            public void put(OtherZatratyImpl obj, Object value) {
                obj.setUserId((Long)value);
            }
        }
        ,
        Comments {
            public Object get(OtherZatratyImpl obj) {
                return obj.getComments();
            }

            public void put(OtherZatratyImpl obj, Object value) {
                obj.setComments((String)value);
            }
        }
        ,
        Version {
            public Object get(OtherZatratyImpl obj) {
                return obj.getVersion();
            }

            public void put(OtherZatratyImpl obj, Object value) {
                obj.setVersion((Timestamp)value);
            }
        }
        ,
        AccZatr {
            public Object get(OtherZatratyImpl obj) {
                return obj.getAccZatr();
            }

            public void put(OtherZatratyImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        Divisions {
            public Object get(OtherZatratyImpl obj) {
                return obj.getDivisions();
            }

            public void put(OtherZatratyImpl obj, Object value) {
                obj.setDivisions((EntityImpl)value);
            }
        }
        ,
        OtherZatratyTabPartZatraty {
            public Object get(OtherZatratyImpl obj) {
                return obj.getOtherZatratyTabPartZatraty();
            }

            public void put(OtherZatratyImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        Users {
            public Object get(OtherZatratyImpl obj) {
                return obj.getUsers();
            }

            public void put(OtherZatratyImpl obj, Object value) {
                obj.setUsers((EntityImpl)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(OtherZatratyImpl object);

        public abstract void put(OtherZatratyImpl object, Object value);

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
    public static final int SYNCSTR = AttributesEnum.SyncStr.index();
    public static final int DAT = AttributesEnum.Dat.index();
    public static final int NUM = AttributesEnum.Num.index();
    public static final int SYNCKEY = AttributesEnum.SyncKey.index();
    public static final int DELETED = AttributesEnum.Deleted.index();
    public static final int POSTED = AttributesEnum.Posted.index();
    public static final int ORGANISATIONREF = AttributesEnum.OrganisationRef.index();
    public static final int DIVISIONID = AttributesEnum.DivisionId.index();
    public static final int USERID = AttributesEnum.UserId.index();
    public static final int COMMENTS = AttributesEnum.Comments.index();
    public static final int VERSION = AttributesEnum.Version.index();
    public static final int ACCZATR = AttributesEnum.AccZatr.index();
    public static final int DIVISIONS = AttributesEnum.Divisions.index();
    public static final int OTHERZATRATYTABPARTZATRATY = AttributesEnum.OtherZatratyTabPartZatraty.index();
    public static final int USERS = AttributesEnum.Users.index();

    /**
     * This is the default constructor (do not remove).
     */
    public OtherZatratyImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("falcon.entity.OtherZatraty");
    }

    /**
     * Gets the attribute value for Id, using the alias name Id.
     * @return the value of Id
     */
    public DBSequence getId() {
        return (DBSequence)getAttributeInternal(ID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Id.
     * @param value value to set the Id
     */
    public void setId(DBSequence value) {
        setAttributeInternal(ID, value);
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
     * Gets the attribute value for SyncKey, using the alias name SyncKey.
     * @return the value of SyncKey
     */
    public Long getSyncKey() {
        return (Long)getAttributeInternal(SYNCKEY);
    }

    /**
     * Sets <code>value</code> as the attribute value for SyncKey.
     * @param value value to set the SyncKey
     */
    public void setSyncKey(Long value) {
        setAttributeInternal(SYNCKEY, value);
    }

    /**
     * Gets the attribute value for Deleted, using the alias name Deleted.
     * @return the value of Deleted
     */
    public Long getDeleted() {
        return (Long)getAttributeInternal(DELETED);
    }

    /**
     * Sets <code>value</code> as the attribute value for Deleted.
     * @param value value to set the Deleted
     */
    public void setDeleted(Long value) {
        setAttributeInternal(DELETED, value);
    }

    /**
     * Gets the attribute value for Posted, using the alias name Posted.
     * @return the value of Posted
     */
    public Long getPosted() {
        return (Long)getAttributeInternal(POSTED);
    }

    /**
     * Sets <code>value</code> as the attribute value for Posted.
     * @param value value to set the Posted
     */
    public void setPosted(Long value) {
        setAttributeInternal(POSTED, value);
    }

    /**
     * Gets the attribute value for OrganisationRef, using the alias name OrganisationRef.
     * @return the value of OrganisationRef
     */
    public String getOrganisationRef() {
        return (String)getAttributeInternal(ORGANISATIONREF);
    }

    /**
     * Sets <code>value</code> as the attribute value for OrganisationRef.
     * @param value value to set the OrganisationRef
     */
    public void setOrganisationRef(String value) {
        setAttributeInternal(ORGANISATIONREF, value);
    }

    /**
     * Gets the attribute value for DivisionId, using the alias name DivisionId.
     * @return the value of DivisionId
     */
    public Long getDivisionId() {
        return (Long)getAttributeInternal(DIVISIONID);
    }

    /**
     * Sets <code>value</code> as the attribute value for DivisionId.
     * @param value value to set the DivisionId
     */
    public void setDivisionId(Long value) {
        setAttributeInternal(DIVISIONID, value);
    }

    /**
     * Gets the attribute value for UserId, using the alias name UserId.
     * @return the value of UserId
     */
    public Long getUserId() {
        return (Long)getAttributeInternal(USERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for UserId.
     * @param value value to set the UserId
     */
    public void setUserId(Long value) {
        setAttributeInternal(USERID, value);
    }

    /**
     * Gets the attribute value for Comments, using the alias name Comments.
     * @return the value of Comments
     */
    public String getComments() {
        return (String)getAttributeInternal(COMMENTS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Comments.
     * @param value value to set the Comments
     */
    public void setComments(String value) {
        setAttributeInternal(COMMENTS, value);
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
    public RowIterator getAccZatr() {
        return (RowIterator)getAttributeInternal(ACCZATR);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getDivisions() {
        return (EntityImpl)getAttributeInternal(DIVISIONS);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setDivisions(EntityImpl value) {
        setAttributeInternal(DIVISIONS, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getOtherZatratyTabPartZatraty() {
        return (RowIterator)getAttributeInternal(OTHERZATRATYTABPARTZATRATY);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getUsers() {
        return (EntityImpl)getAttributeInternal(USERS);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setUsers(EntityImpl value) {
        setAttributeInternal(USERS, value);
    }

    /**
     * @param id key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(DBSequence id) {
        return new Key(new Object[]{id});
    }


}
package falcon.view;

import java.math.BigDecimal;

import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Dec 11 19:41:37 EET 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CatalogMetaTablesViewRowImpl extends ViewRowImpl {


    public static final int ENTITY_CATALOGMETATABLES = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        Id {
            public Object get(CatalogMetaTablesViewRowImpl obj) {
                return obj.getId();
            }

            public void put(CatalogMetaTablesViewRowImpl obj, Object value) {
                obj.setId((BigDecimal)value);
            }
        }
        ,
        MainName {
            public Object get(CatalogMetaTablesViewRowImpl obj) {
                return obj.getMainName();
            }

            public void put(CatalogMetaTablesViewRowImpl obj, Object value) {
                obj.setMainName((String)value);
            }
        }
        ,
        ThisName {
            public Object get(CatalogMetaTablesViewRowImpl obj) {
                return obj.getThisName();
            }

            public void put(CatalogMetaTablesViewRowImpl obj, Object value) {
                obj.setThisName((String)value);
            }
        }
        ,
        Ordr {
            public Object get(CatalogMetaTablesViewRowImpl obj) {
                return obj.getOrdr();
            }

            public void put(CatalogMetaTablesViewRowImpl obj, Object value) {
                obj.setOrdr((BigDecimal)value);
            }
        }
        ,
        XmlStr {
            public Object get(CatalogMetaTablesViewRowImpl obj) {
                return obj.getXmlStr();
            }

            public void put(CatalogMetaTablesViewRowImpl obj, Object value) {
                obj.setXmlStr((String)value);
            }
        }
        ,
        MasterKey {
            public Object get(CatalogMetaTablesViewRowImpl obj) {
                return obj.getMasterKey();
            }

            public void put(CatalogMetaTablesViewRowImpl obj, Object value) {
                obj.setMasterKey((BigDecimal)value);
            }
        }
        ,
        MasterFld {
            public Object get(CatalogMetaTablesViewRowImpl obj) {
                return obj.getMasterFld();
            }

            public void put(CatalogMetaTablesViewRowImpl obj, Object value) {
                obj.setMasterFld((String)value);
            }
        }
        ,
        Category {
            public Object get(CatalogMetaTablesViewRowImpl obj) {
                return obj.getCategory();
            }

            public void put(CatalogMetaTablesViewRowImpl obj, Object value) {
                obj.setCategory((String)value);
            }
        }
        ,
        SqlIns {
            public Object get(CatalogMetaTablesViewRowImpl obj) {
                return obj.getSqlIns();
            }

            public void put(CatalogMetaTablesViewRowImpl obj, Object value) {
                obj.setSqlIns((String)value);
            }
        }
        ,
        CatalogMetaInsTableView {
            public Object get(CatalogMetaTablesViewRowImpl obj) {
                return obj.getCatalogMetaInsTableView();
            }

            public void put(CatalogMetaTablesViewRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        CatalogMetaUpdTableView {
            public Object get(CatalogMetaTablesViewRowImpl obj) {
                return obj.getCatalogMetaUpdTableView();
            }

            public void put(CatalogMetaTablesViewRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        CatalogMetaXmlTableView {
            public Object get(CatalogMetaTablesViewRowImpl obj) {
                return obj.getCatalogMetaXmlTableView();
            }

            public void put(CatalogMetaTablesViewRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(CatalogMetaTablesViewRowImpl object);

        public abstract void put(CatalogMetaTablesViewRowImpl object, Object value);

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
    public static final int MAINNAME = AttributesEnum.MainName.index();
    public static final int THISNAME = AttributesEnum.ThisName.index();
    public static final int ORDR = AttributesEnum.Ordr.index();
    public static final int XMLSTR = AttributesEnum.XmlStr.index();
    public static final int MASTERKEY = AttributesEnum.MasterKey.index();
    public static final int MASTERFLD = AttributesEnum.MasterFld.index();
    public static final int CATEGORY = AttributesEnum.Category.index();
    public static final int SQLINS = AttributesEnum.SqlIns.index();
    public static final int CATALOGMETAINSTABLEVIEW = AttributesEnum.CatalogMetaInsTableView.index();
    public static final int CATALOGMETAUPDTABLEVIEW = AttributesEnum.CatalogMetaUpdTableView.index();
    public static final int CATALOGMETAXMLTABLEVIEW = AttributesEnum.CatalogMetaXmlTableView.index();

    /**
     * This is the default constructor (do not remove).
     */
    public CatalogMetaTablesViewRowImpl() {
    }

    /**
     * Gets CatalogMetaTables entity object.
     * @return the CatalogMetaTables
     */
    public EntityImpl getCatalogMetaTables() {
        return (EntityImpl)getEntity(ENTITY_CATALOGMETATABLES);
    }

    /**
     * Gets the attribute value for ID using the alias name Id.
     * @return the ID
     */
    public BigDecimal getId() {
        return (BigDecimal) getAttributeInternal(ID);
    }

    /**
     * Sets <code>value</code> as attribute value for ID using the alias name Id.
     * @param value value to set the ID
     */
    public void setId(BigDecimal value) {
        setAttributeInternal(ID, value);
    }

    /**
     * Gets the attribute value for MAIN_NAME using the alias name MainName.
     * @return the MAIN_NAME
     */
    public String getMainName() {
        return (String) getAttributeInternal(MAINNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for MAIN_NAME using the alias name MainName.
     * @param value value to set the MAIN_NAME
     */
    public void setMainName(String value) {
        setAttributeInternal(MAINNAME, value);
    }

    /**
     * Gets the attribute value for THIS_NAME using the alias name ThisName.
     * @return the THIS_NAME
     */
    public String getThisName() {
        return (String) getAttributeInternal(THISNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for THIS_NAME using the alias name ThisName.
     * @param value value to set the THIS_NAME
     */
    public void setThisName(String value) {
        setAttributeInternal(THISNAME, value);
    }

    /**
     * Gets the attribute value for ORDR using the alias name Ordr.
     * @return the ORDR
     */
    public BigDecimal getOrdr() {
        return (BigDecimal) getAttributeInternal(ORDR);
    }

    /**
     * Sets <code>value</code> as attribute value for ORDR using the alias name Ordr.
     * @param value value to set the ORDR
     */
    public void setOrdr(BigDecimal value) {
        setAttributeInternal(ORDR, value);
    }

    /**
     * Gets the attribute value for XML_STR using the alias name XmlStr.
     * @return the XML_STR
     */
    public String getXmlStr() {
        return (String) getAttributeInternal(XMLSTR);
    }

    /**
     * Sets <code>value</code> as attribute value for XML_STR using the alias name XmlStr.
     * @param value value to set the XML_STR
     */
    public void setXmlStr(String value) {
        setAttributeInternal(XMLSTR, value);
    }

    /**
     * Gets the attribute value for MASTER_KEY using the alias name MasterKey.
     * @return the MASTER_KEY
     */
    public BigDecimal getMasterKey() {
        return (BigDecimal) getAttributeInternal(MASTERKEY);
    }

    /**
     * Sets <code>value</code> as attribute value for MASTER_KEY using the alias name MasterKey.
     * @param value value to set the MASTER_KEY
     */
    public void setMasterKey(BigDecimal value) {
        setAttributeInternal(MASTERKEY, value);
    }

    /**
     * Gets the attribute value for MASTER_FLD using the alias name MasterFld.
     * @return the MASTER_FLD
     */
    public String getMasterFld() {
        return (String) getAttributeInternal(MASTERFLD);
    }

    /**
     * Sets <code>value</code> as attribute value for MASTER_FLD using the alias name MasterFld.
     * @param value value to set the MASTER_FLD
     */
    public void setMasterFld(String value) {
        setAttributeInternal(MASTERFLD, value);
    }

    /**
     * Gets the attribute value for CATEGORY using the alias name Category.
     * @return the CATEGORY
     */
    public String getCategory() {
        return (String) getAttributeInternal(CATEGORY);
    }

    /**
     * Sets <code>value</code> as attribute value for CATEGORY using the alias name Category.
     * @param value value to set the CATEGORY
     */
    public void setCategory(String value) {
        setAttributeInternal(CATEGORY, value);
    }

    /**
     * Gets the attribute value for SQL_INS using the alias name SqlIns.
     * @return the SQL_INS
     */
    public String getSqlIns() {
        return (String) getAttributeInternal(SQLINS);
    }

    /**
     * Sets <code>value</code> as attribute value for SQL_INS using the alias name SqlIns.
     * @param value value to set the SQL_INS
     */
    public void setSqlIns(String value) {
        setAttributeInternal(SQLINS, value);
    }

    /**
     * Gets the associated <code>Row</code> using master-detail link CatalogMetaInsTableView.
     */
    public Row getCatalogMetaInsTableView() {
        return (Row)getAttributeInternal(CATALOGMETAINSTABLEVIEW);
    }

    /**
     * Sets the master-detail link CatalogMetaInsTableView between this object and <code>value</code>.
     */
    public void setCatalogMetaInsTableView(Row value) {
        setAttributeInternal(CATALOGMETAINSTABLEVIEW, value);
    }

    /**
     * Gets the associated <code>Row</code> using master-detail link CatalogMetaUpdTableView.
     */
    public Row getCatalogMetaUpdTableView() {
        return (Row)getAttributeInternal(CATALOGMETAUPDTABLEVIEW);
    }

    /**
     * Sets the master-detail link CatalogMetaUpdTableView between this object and <code>value</code>.
     */
    public void setCatalogMetaUpdTableView(Row value) {
        setAttributeInternal(CATALOGMETAUPDTABLEVIEW, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link CatalogMetaXmlTableView.
     */
    public RowIterator getCatalogMetaXmlTableView() {
        return (RowIterator)getAttributeInternal(CATALOGMETAXMLTABLEVIEW);
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
}

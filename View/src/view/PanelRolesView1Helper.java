package view;

import com.jgoodies.forms.layout.*;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;

import oracle.adf.model.*;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.*;

import oracle.jbo.uicli.binding.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;

import oracle.jdeveloper.layout.*;

public class PanelRolesView1Helper extends JPanel implements JUPanel {

    //PageDefinition File	
    private JUPanelBinding panelBinding = new JUPanelBinding("view_PanelRolesView1HelperPageDef");
    private JPanel dataPanel = new JPanel();
    private BorderLayout borderLayout = new BorderLayout();

    private FormLayout panelLayout = new FormLayout("3dlu,d:g,3dlu,d:g,3dlu", "3dlu,d,3dlu,d,3dlu");
    private JTextField mFullname = new JTextField();
    private JLabel labelmFullname = new JLabel();
    private JTextField mId = new JTextField();
    private JLabel labelmId = new JLabel();
    private JUNavigationBar navBar = new JUNavigationBar();
    private JScrollPane jScrollPane1 = new JScrollPane();

    /**The default constructor for panel
     */
    public PanelRolesView1Helper() {
    }

    /**the JbInit method
     */
    public void jbInit() throws Exception {
        dataPanel.setLayout(panelLayout);
        dataPanel.setMinimumSize(new Dimension(100, 100));
        jScrollPane1.setMinimumSize(new Dimension(100, 100));
        jScrollPane1.setEnabled(true);
        jScrollPane1.setViewportView(dataPanel);
        this.setLayout(borderLayout);
        //Add the controls to the layout
        dataPanel.add(labelmFullname, new CellConstraints("2 , 2 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(mFullname, new CellConstraints("4, 2 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(labelmId, new CellConstraints("2 , 4 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(mId, new CellConstraints("4, 4 ,1,1,default," + CellConstraints.FILL));

        labelmFullname.setLabelFor(mFullname);
        labelmFullname.setText(panelBinding.findCtrlValueBinding("Fullname").getLabel());
        mFullname.setToolTipText(panelBinding.findCtrlValueBinding("Fullname").getTooltip());
        mFullname.setColumns(15);

        labelmId.setLabelFor(mId);
        labelmId.setText(panelBinding.findCtrlValueBinding("Id").getLabel());
        mId.setToolTipText(panelBinding.findCtrlValueBinding("Id").getTooltip());
        mId.setColumns(15);
        navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "RolesView1", null,
                                                          "RolesView1Iterator"));
        add(navBar, BorderLayout.NORTH);
        add(jScrollPane1, BorderLayout.CENTER);
        //BindingCodes
        mFullname.setToolTipText((panelBinding.findCtrlValueBinding("Fullname")).getTooltip());
        mFullname.setColumns(panelBinding.findCtrlValueBinding("Fullname").getDisplayWidth());
        mFullname.setDocument((Document)panelBinding.bindUIControl("Fullname", mFullname));
        mId.setToolTipText((panelBinding.findCtrlValueBinding("Id")).getTooltip());
        mId.setColumns(panelBinding.findCtrlValueBinding("Id").getDisplayWidth());
        mId.setDocument((Document)panelBinding.bindUIControl("Id", mId));

        if ("Hide".equalsIgnoreCase(panelBinding.getDisplayHint("RolesView1", "Fullname", null))) {
            dataPanel.remove(mFullname);
            dataPanel.remove(labelmFullname);
        }
        if ("Hide".equalsIgnoreCase(panelBinding.getDisplayHint("RolesView1", "Id", null))) {
            dataPanel.remove(mId);
            dataPanel.remove(labelmId);
        }

    }


    /**JUPanel implementation
     */
    public JUPanelBinding getPanelBinding() {
        return panelBinding;
    }

    public void bindNestedContainer(JUPanelBinding ctr) {
        if (panelBinding.getPanel() == null) {
            ctr.setPanel(this);
            panelBinding.release(DCDataControl.REL_VIEW_REFS);
            panelBinding = ctr;
            registerProjectGlobalVariables(panelBinding.getBindingContext());
            try {
                jbInit();
            } catch (Exception ex) {
                ex.printStackTrace();
                ctr.reportException(ex);
            }
        }
    }

    private void registerProjectGlobalVariables(BindingContext bindCtx) {
        JUUtil.registerNavigationBarInterface(panelBinding, bindCtx);
    }

    private void unRegisterProjectGlobalVariables(BindingContext bindCtx) {
        JUUtil.unRegisterNavigationBarInterface(panelBinding, bindCtx);
    }

    public void setBindingContext(BindingContext bindCtx) {
        if (panelBinding.getPanel() == null) {
            panelBinding = panelBinding.setup(bindCtx, this);
            registerProjectGlobalVariables(bindCtx);
            panelBinding.refreshControl();
            try {
                jbInit();
                panelBinding.refreshControl();
            } catch (Exception ex) {
                panelBinding.reportException(ex);
            }
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception exemp) {
            exemp.printStackTrace();
        }

        PanelRolesView1Helper panel = new PanelRolesView1Helper();
        panel.setBindingContext(JUTestFrame.startTestFrame("view.DataBindings.cpx", "null", panel,
                                                           panel.getPanelBinding(), new Dimension(400, 300)));
        panel.revalidate();
    }
}

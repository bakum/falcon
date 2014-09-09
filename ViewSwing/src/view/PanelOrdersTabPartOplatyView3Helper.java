package view;


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

public class PanelOrdersTabPartOplatyView3Helper extends JPanel implements JUPanel {
    //PageDefinition File	
    private JUPanelBinding panelBinding = new JUPanelBinding("view_PanelOrdersTabPartOplatyView3HelperPageDef");
    private JPanel dataPanel = new JPanel();
    private BorderLayout borderLayout = new BorderLayout();
    private GridLayout gridLayout = new GridLayout();
    private JTable tableOrdersTabPartOplatyView3 = new JTable();
    private JScrollPane tableOrdersTabPartOplatyView3ScrollPane = new JScrollPane();
    private JUNavigationBar navBar = new JUNavigationBar();

    /**The default constructor for panel
     */
    public PanelOrdersTabPartOplatyView3Helper() {
    }

    /**the JbInit method
     */
    public void jbInit() throws Exception {
        dataPanel.setLayout(gridLayout);
        dataPanel.setMinimumSize(new Dimension(100, 100));
        this.setLayout(borderLayout);
        dataPanel.add(tableOrdersTabPartOplatyView3ScrollPane);
        tableOrdersTabPartOplatyView3ScrollPane.getViewport().add(tableOrdersTabPartOplatyView3, null);
        navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "OrdersTabPartOplatyView3", null,
                                                          "OrdersTabPartOplatyView3Iterator"));
        add(navBar, BorderLayout.NORTH);
        add(dataPanel, BorderLayout.CENTER);
        //BindingCodes
        tableOrdersTabPartOplatyView3.setModel((TableModel)panelBinding.bindUIControl("OrdersTabPartOplatyView3",
                                                                                      tableOrdersTabPartOplatyView3));
    }


    /**ADF Swing Panel implementation
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

        PanelOrdersTabPartOplatyView3Helper panel = new PanelOrdersTabPartOplatyView3Helper();
        panel.setBindingContext(JUTestFrame.startTestFrame("view.DataBindings.cpx", "null", panel,
                                                           panel.getPanelBinding(), new Dimension(400, 300)));
        panel.revalidate();
    }

}

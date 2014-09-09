package view;

import java.awt.*;

import java.util.ArrayList;

import javax.swing.*;

import oracle.adf.model.*;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.*;

import oracle.jbo.uicli.binding.JUApplication;
import oracle.jbo.uicli.binding.JUUtil;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;

import oracle.jdeveloper.layout.*;

public class PanelDetailsContainerHelper extends JPanel implements JUPanel {
    //PageDefinition File	
    private JUPanelBinding panelBinding = new JUPanelBinding("view_PanelDetailsContainerHelperPageDef");
    private BorderLayout panelLayout = new BorderLayout();

    private PanelOrdersTabPartOplatyView3Helper detailViewPanel1 = new PanelOrdersTabPartOplatyView3Helper();
    private PanelAccCostView7Helper detailViewPanel2 = new PanelAccCostView7Helper();

    private JTabbedPane tabbedPane = new JTabbedPane();

    /**The default constructor for master-detail panel
     */
    public PanelDetailsContainerHelper() {
    }

    /**the JbInit method
     */
    public void jbInit() throws Exception {
        BindingContext _bctx = panelBinding.getBindingContext();
        detailViewPanel1.bindNestedContainer(panelBinding.findNestedPanelBinding("view_PanelOrdersTabPartOplatyView3HelperPageDef"));
        detailViewPanel2.bindNestedContainer(panelBinding.findNestedPanelBinding("view_PanelAccCostView7HelperPageDef"));

        this.setLayout(panelLayout);

        tabbedPane.add(detailViewPanel1, "OrdersTabPartOplatyView3");
        tabbedPane.add(detailViewPanel2, "AccCostView7");

        this.add(tabbedPane, BorderLayout.CENTER);
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

        PanelDetailsContainerHelper panel = new PanelDetailsContainerHelper();
        panel.setBindingContext(JUTestFrame.startTestFrame("view.DataBindings.cpx", "null", panel,
                                                           panel.getPanelBinding(), new Dimension(400, 300)));
        panel.revalidate();
    }

}


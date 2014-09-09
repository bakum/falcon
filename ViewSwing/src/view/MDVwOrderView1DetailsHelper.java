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

public class MDVwOrderView1DetailsHelper extends JPanel implements JUPanel {
    //PageDefinition File	
    private JUPanelBinding panelBinding = new JUPanelBinding("view_MDVwOrderView1DetailsHelperPageDef");
    private BorderLayout panelLayout = new BorderLayout();
    private JScrollPane masterScroller = new JScrollPane();
    private JScrollPane detailScroller = new JScrollPane();
    private PanelVwOrderView1Helper1 masterViewPanel = new PanelVwOrderView1Helper1();
    private PanelDetailsContainerHelper detailViewPanel = new PanelDetailsContainerHelper();

    /**The default constructor for master-detail panel
     */
    public MDVwOrderView1DetailsHelper() {
    }

    /**the JbInit method
     */
    public void jbInit() throws Exception {
        BindingContext _bctx = panelBinding.getBindingContext();
        masterViewPanel.bindNestedContainer(panelBinding.findNestedPanelBinding("view_PanelVwOrderView1Helper1PageDef"));
        detailViewPanel.bindNestedContainer(panelBinding.findNestedPanelBinding("view_PanelDetailsContainerHelperPageDef"));
        this.setLayout(panelLayout);
        masterScroller.getViewport().add(masterViewPanel);
        detailScroller.getViewport().add(detailViewPanel);
        add(masterScroller, BorderLayout.NORTH);
        add(detailScroller, BorderLayout.CENTER);

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

        MDVwOrderView1DetailsHelper panel = new MDVwOrderView1DetailsHelper();
        panel.setBindingContext(JUTestFrame.startTestFrame("view.DataBindings.cpx", "null", panel,
                                                           panel.getPanelBinding(), new Dimension(400, 300)));
        panel.revalidate();
    }

}

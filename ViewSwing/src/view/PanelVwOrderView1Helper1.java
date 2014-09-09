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

public class PanelVwOrderView1Helper1 extends JPanel implements JUPanel {

    //PageDefinition File	
    private JUPanelBinding panelBinding = new JUPanelBinding("view_PanelVwOrderView1Helper1PageDef");
    private JPanel dataPanel = new JPanel();
    private BorderLayout borderLayout = new BorderLayout();

    private FormLayout panelLayout =
        new FormLayout("3dlu,d:g,3dlu,d:g,3dlu", "3dlu,d,3dlu,d,3dlu,d,3dlu,d,3dlu,d,3dlu,d,3dlu,d,3dlu,d,3dlu,d,3dlu,d,3dlu,d,3dlu,d,3dlu,d,3dlu,d,3dlu,d,3dlu,d,3dlu,d,3dlu,d,3dlu");
    private JTextField mBank = new JTextField();
    private JLabel labelmBank = new JLabel();
    private JTextField mDat = new JTextField();
    private JLabel labelmDat = new JLabel();
    private JTextField mDivision = new JTextField();
    private JLabel labelmDivision = new JLabel();
    private JTextField mDolgKlienta = new JTextField();
    private JLabel labelmDolgKlienta = new JLabel();
    private JTextField mDostavka = new JTextField();
    private JLabel labelmDostavka = new JLabel();
    private JTextField mId = new JTextField();
    private JLabel labelmId = new JLabel();
    private JTextField mKassa = new JTextField();
    private JLabel labelmKassa = new JLabel();
    private JTextField mKonsult = new JTextField();
    private JLabel labelmKonsult = new JLabel();
    private JTextField mKontrag = new JTextField();
    private JLabel labelmKontrag = new JLabel();
    private JTextField mKredit = new JTextField();
    private JLabel labelmKredit = new JLabel();
    private JTextField mMetrag = new JTextField();
    private JLabel labelmMetrag = new JLabel();
    private JTextField mMontag = new JTextField();
    private JLabel labelmMontag = new JLabel();
    private JTextField mNum = new JTextField();
    private JLabel labelmNum = new JLabel();
    private JTextField mSumma = new JTextField();
    private JLabel labelmSumma = new JLabel();
    private JTextField mTotal_Cost = new JTextField();
    private JLabel labelmTotal_Cost = new JLabel();
    private JTextField mUserS = new JTextField();
    private JLabel labelmUserS = new JLabel();
    private JTextField mZakSumm = new JTextField();
    private JLabel labelmZakSumm = new JLabel();
    private JTextField mZamer = new JTextField();
    private JLabel labelmZamer = new JLabel();
    private JUNavigationBar navBar = new JUNavigationBar();
    private JScrollPane jScrollPane1 = new JScrollPane();

    /**The default constructor for panel
     */
    public PanelVwOrderView1Helper1() {
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
        dataPanel.add(labelmBank, new CellConstraints("2 , 2 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(mBank, new CellConstraints("4, 2 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(labelmDat, new CellConstraints("2 , 4 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(mDat, new CellConstraints("4, 4 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(labelmDivision, new CellConstraints("2 , 6 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(mDivision, new CellConstraints("4, 6 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(labelmDolgKlienta, new CellConstraints("2 , 8 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(mDolgKlienta, new CellConstraints("4, 8 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(labelmDostavka, new CellConstraints("2 , 10 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(mDostavka, new CellConstraints("4, 10 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(labelmId, new CellConstraints("2 , 12 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(mId, new CellConstraints("4, 12 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(labelmKassa, new CellConstraints("2 , 14 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(mKassa, new CellConstraints("4, 14 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(labelmKonsult, new CellConstraints("2 , 16 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(mKonsult, new CellConstraints("4, 16 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(labelmKontrag, new CellConstraints("2 , 18 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(mKontrag, new CellConstraints("4, 18 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(labelmKredit, new CellConstraints("2 , 20 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(mKredit, new CellConstraints("4, 20 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(labelmMetrag, new CellConstraints("2 , 22 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(mMetrag, new CellConstraints("4, 22 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(labelmMontag, new CellConstraints("2 , 24 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(mMontag, new CellConstraints("4, 24 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(labelmNum, new CellConstraints("2 , 26 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(mNum, new CellConstraints("4, 26 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(labelmSumma, new CellConstraints("2 , 28 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(mSumma, new CellConstraints("4, 28 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(labelmTotal_Cost, new CellConstraints("2 , 30 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(mTotal_Cost, new CellConstraints("4, 30 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(labelmUserS, new CellConstraints("2 , 32 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(mUserS, new CellConstraints("4, 32 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(labelmZakSumm, new CellConstraints("2 , 34 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(mZakSumm, new CellConstraints("4, 34 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(labelmZamer, new CellConstraints("2 , 36 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(mZamer, new CellConstraints("4, 36 ,1,1,default," + CellConstraints.FILL));

        labelmBank.setLabelFor(mBank);
        labelmBank.setText(panelBinding.findCtrlValueBinding("Bank").getLabel());
        mBank.setToolTipText(panelBinding.findCtrlValueBinding("Bank").getTooltip());
        mBank.setColumns(15);

        labelmDat.setLabelFor(mDat);
        labelmDat.setText(panelBinding.findCtrlValueBinding("Dat").getLabel());
        mDat.setToolTipText(panelBinding.findCtrlValueBinding("Dat").getTooltip());
        mDat.setColumns(15);

        labelmDivision.setLabelFor(mDivision);
        labelmDivision.setText(panelBinding.findCtrlValueBinding("Division").getLabel());
        mDivision.setToolTipText(panelBinding.findCtrlValueBinding("Division").getTooltip());
        mDivision.setColumns(15);

        labelmDolgKlienta.setLabelFor(mDolgKlienta);
        labelmDolgKlienta.setText(panelBinding.findCtrlValueBinding("DolgKlienta").getLabel());
        mDolgKlienta.setToolTipText(panelBinding.findCtrlValueBinding("DolgKlienta").getTooltip());
        mDolgKlienta.setColumns(15);

        labelmDostavka.setLabelFor(mDostavka);
        labelmDostavka.setText(panelBinding.findCtrlValueBinding("Dostavka").getLabel());
        mDostavka.setToolTipText(panelBinding.findCtrlValueBinding("Dostavka").getTooltip());
        mDostavka.setColumns(15);

        labelmId.setLabelFor(mId);
        labelmId.setText(panelBinding.findCtrlValueBinding("Id").getLabel());
        mId.setToolTipText(panelBinding.findCtrlValueBinding("Id").getTooltip());
        mId.setColumns(15);

        labelmKassa.setLabelFor(mKassa);
        labelmKassa.setText(panelBinding.findCtrlValueBinding("Kassa").getLabel());
        mKassa.setToolTipText(panelBinding.findCtrlValueBinding("Kassa").getTooltip());
        mKassa.setColumns(15);

        labelmKonsult.setLabelFor(mKonsult);
        labelmKonsult.setText(panelBinding.findCtrlValueBinding("Konsult").getLabel());
        mKonsult.setToolTipText(panelBinding.findCtrlValueBinding("Konsult").getTooltip());
        mKonsult.setColumns(15);

        labelmKontrag.setLabelFor(mKontrag);
        labelmKontrag.setText(panelBinding.findCtrlValueBinding("Kontrag").getLabel());
        mKontrag.setToolTipText(panelBinding.findCtrlValueBinding("Kontrag").getTooltip());
        mKontrag.setColumns(15);

        labelmKredit.setLabelFor(mKredit);
        labelmKredit.setText(panelBinding.findCtrlValueBinding("Kredit").getLabel());
        mKredit.setToolTipText(panelBinding.findCtrlValueBinding("Kredit").getTooltip());
        mKredit.setColumns(15);

        labelmMetrag.setLabelFor(mMetrag);
        labelmMetrag.setText(panelBinding.findCtrlValueBinding("Metrag").getLabel());
        mMetrag.setToolTipText(panelBinding.findCtrlValueBinding("Metrag").getTooltip());
        mMetrag.setColumns(15);

        labelmMontag.setLabelFor(mMontag);
        labelmMontag.setText(panelBinding.findCtrlValueBinding("Montag").getLabel());
        mMontag.setToolTipText(panelBinding.findCtrlValueBinding("Montag").getTooltip());
        mMontag.setColumns(15);

        labelmNum.setLabelFor(mNum);
        labelmNum.setText(panelBinding.findCtrlValueBinding("Num").getLabel());
        mNum.setToolTipText(panelBinding.findCtrlValueBinding("Num").getTooltip());
        mNum.setColumns(15);

        labelmSumma.setLabelFor(mSumma);
        labelmSumma.setText(panelBinding.findCtrlValueBinding("Summa").getLabel());
        mSumma.setToolTipText(panelBinding.findCtrlValueBinding("Summa").getTooltip());
        mSumma.setColumns(15);

        labelmTotal_Cost.setLabelFor(mTotal_Cost);
        labelmTotal_Cost.setText(panelBinding.findCtrlValueBinding("Total_Cost").getLabel());
        mTotal_Cost.setToolTipText(panelBinding.findCtrlValueBinding("Total_Cost").getTooltip());
        mTotal_Cost.setColumns(15);

        labelmUserS.setLabelFor(mUserS);
        labelmUserS.setText(panelBinding.findCtrlValueBinding("UserS").getLabel());
        mUserS.setToolTipText(panelBinding.findCtrlValueBinding("UserS").getTooltip());
        mUserS.setColumns(15);

        labelmZakSumm.setLabelFor(mZakSumm);
        labelmZakSumm.setText(panelBinding.findCtrlValueBinding("ZakSumm").getLabel());
        mZakSumm.setToolTipText(panelBinding.findCtrlValueBinding("ZakSumm").getTooltip());
        mZakSumm.setColumns(15);

        labelmZamer.setLabelFor(mZamer);
        labelmZamer.setText(panelBinding.findCtrlValueBinding("Zamer").getLabel());
        mZamer.setToolTipText(panelBinding.findCtrlValueBinding("Zamer").getTooltip());
        mZamer.setColumns(15);
        navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "VwOrderView1", null,
                                                          "VwOrderView1Iterator"));
        add(navBar, BorderLayout.NORTH);
        add(jScrollPane1, BorderLayout.CENTER);
        //BindingCodes
        mBank.setToolTipText((panelBinding.findCtrlValueBinding("Bank")).getTooltip());
        mBank.setColumns(panelBinding.findCtrlValueBinding("Bank").getDisplayWidth());
        mBank.setDocument((Document)panelBinding.bindUIControl("Bank", mBank));
        mDat.setToolTipText((panelBinding.findCtrlValueBinding("Dat")).getTooltip());
        mDat.setColumns(panelBinding.findCtrlValueBinding("Dat").getDisplayWidth());
        mDat.setDocument((Document)panelBinding.bindUIControl("Dat", mDat));
        mDivision.setToolTipText((panelBinding.findCtrlValueBinding("Division")).getTooltip());
        mDivision.setColumns(panelBinding.findCtrlValueBinding("Division").getDisplayWidth());
        mDivision.setDocument((Document)panelBinding.bindUIControl("Division", mDivision));
        mDolgKlienta.setToolTipText((panelBinding.findCtrlValueBinding("DolgKlienta")).getTooltip());
        mDolgKlienta.setColumns(panelBinding.findCtrlValueBinding("DolgKlienta").getDisplayWidth());
        mDolgKlienta.setDocument((Document)panelBinding.bindUIControl("DolgKlienta", mDolgKlienta));
        mDostavka.setToolTipText((panelBinding.findCtrlValueBinding("Dostavka")).getTooltip());
        mDostavka.setColumns(panelBinding.findCtrlValueBinding("Dostavka").getDisplayWidth());
        mDostavka.setDocument((Document)panelBinding.bindUIControl("Dostavka", mDostavka));
        mId.setToolTipText((panelBinding.findCtrlValueBinding("Id")).getTooltip());
        mId.setColumns(panelBinding.findCtrlValueBinding("Id").getDisplayWidth());
        mId.setDocument((Document)panelBinding.bindUIControl("Id", mId));
        mKassa.setToolTipText((panelBinding.findCtrlValueBinding("Kassa")).getTooltip());
        mKassa.setColumns(panelBinding.findCtrlValueBinding("Kassa").getDisplayWidth());
        mKassa.setDocument((Document)panelBinding.bindUIControl("Kassa", mKassa));
        mKonsult.setToolTipText((panelBinding.findCtrlValueBinding("Konsult")).getTooltip());
        mKonsult.setColumns(panelBinding.findCtrlValueBinding("Konsult").getDisplayWidth());
        mKonsult.setDocument((Document)panelBinding.bindUIControl("Konsult", mKonsult));
        mKontrag.setToolTipText((panelBinding.findCtrlValueBinding("Kontrag")).getTooltip());
        mKontrag.setColumns(panelBinding.findCtrlValueBinding("Kontrag").getDisplayWidth());
        mKontrag.setDocument((Document)panelBinding.bindUIControl("Kontrag", mKontrag));
        mKredit.setToolTipText((panelBinding.findCtrlValueBinding("Kredit")).getTooltip());
        mKredit.setColumns(panelBinding.findCtrlValueBinding("Kredit").getDisplayWidth());
        mKredit.setDocument((Document)panelBinding.bindUIControl("Kredit", mKredit));
        mMetrag.setToolTipText((panelBinding.findCtrlValueBinding("Metrag")).getTooltip());
        mMetrag.setColumns(panelBinding.findCtrlValueBinding("Metrag").getDisplayWidth());
        mMetrag.setDocument((Document)panelBinding.bindUIControl("Metrag", mMetrag));
        mMontag.setToolTipText((panelBinding.findCtrlValueBinding("Montag")).getTooltip());
        mMontag.setColumns(panelBinding.findCtrlValueBinding("Montag").getDisplayWidth());
        mMontag.setDocument((Document)panelBinding.bindUIControl("Montag", mMontag));
        mNum.setToolTipText((panelBinding.findCtrlValueBinding("Num")).getTooltip());
        mNum.setColumns(panelBinding.findCtrlValueBinding("Num").getDisplayWidth());
        mNum.setDocument((Document)panelBinding.bindUIControl("Num", mNum));
        mSumma.setToolTipText((panelBinding.findCtrlValueBinding("Summa")).getTooltip());
        mSumma.setColumns(panelBinding.findCtrlValueBinding("Summa").getDisplayWidth());
        mSumma.setDocument((Document)panelBinding.bindUIControl("Summa", mSumma));
        mTotal_Cost.setToolTipText((panelBinding.findCtrlValueBinding("Total_Cost")).getTooltip());
        mTotal_Cost.setColumns(panelBinding.findCtrlValueBinding("Total_Cost").getDisplayWidth());
        mTotal_Cost.setDocument((Document)panelBinding.bindUIControl("Total_Cost", mTotal_Cost));
        mUserS.setToolTipText((panelBinding.findCtrlValueBinding("UserS")).getTooltip());
        mUserS.setColumns(panelBinding.findCtrlValueBinding("UserS").getDisplayWidth());
        mUserS.setDocument((Document)panelBinding.bindUIControl("UserS", mUserS));
        mZakSumm.setToolTipText((panelBinding.findCtrlValueBinding("ZakSumm")).getTooltip());
        mZakSumm.setColumns(panelBinding.findCtrlValueBinding("ZakSumm").getDisplayWidth());
        mZakSumm.setDocument((Document)panelBinding.bindUIControl("ZakSumm", mZakSumm));
        mZamer.setToolTipText((panelBinding.findCtrlValueBinding("Zamer")).getTooltip());
        mZamer.setColumns(panelBinding.findCtrlValueBinding("Zamer").getDisplayWidth());
        mZamer.setDocument((Document)panelBinding.bindUIControl("Zamer", mZamer));

        if ("Hide".equalsIgnoreCase(panelBinding.getDisplayHint("VwOrderView1", "Bank", null))) {
            dataPanel.remove(mBank);
            dataPanel.remove(labelmBank);
        }
        if ("Hide".equalsIgnoreCase(panelBinding.getDisplayHint("VwOrderView1", "Dat", null))) {
            dataPanel.remove(mDat);
            dataPanel.remove(labelmDat);
        }
        if ("Hide".equalsIgnoreCase(panelBinding.getDisplayHint("VwOrderView1", "Division", null))) {
            dataPanel.remove(mDivision);
            dataPanel.remove(labelmDivision);
        }
        if ("Hide".equalsIgnoreCase(panelBinding.getDisplayHint("VwOrderView1", "DolgKlienta", null))) {
            dataPanel.remove(mDolgKlienta);
            dataPanel.remove(labelmDolgKlienta);
        }
        if ("Hide".equalsIgnoreCase(panelBinding.getDisplayHint("VwOrderView1", "Dostavka", null))) {
            dataPanel.remove(mDostavka);
            dataPanel.remove(labelmDostavka);
        }
        if ("Hide".equalsIgnoreCase(panelBinding.getDisplayHint("VwOrderView1", "Id", null))) {
            dataPanel.remove(mId);
            dataPanel.remove(labelmId);
        }
        if ("Hide".equalsIgnoreCase(panelBinding.getDisplayHint("VwOrderView1", "Kassa", null))) {
            dataPanel.remove(mKassa);
            dataPanel.remove(labelmKassa);
        }
        if ("Hide".equalsIgnoreCase(panelBinding.getDisplayHint("VwOrderView1", "Konsult", null))) {
            dataPanel.remove(mKonsult);
            dataPanel.remove(labelmKonsult);
        }
        if ("Hide".equalsIgnoreCase(panelBinding.getDisplayHint("VwOrderView1", "Kontrag", null))) {
            dataPanel.remove(mKontrag);
            dataPanel.remove(labelmKontrag);
        }
        if ("Hide".equalsIgnoreCase(panelBinding.getDisplayHint("VwOrderView1", "Kredit", null))) {
            dataPanel.remove(mKredit);
            dataPanel.remove(labelmKredit);
        }
        if ("Hide".equalsIgnoreCase(panelBinding.getDisplayHint("VwOrderView1", "Metrag", null))) {
            dataPanel.remove(mMetrag);
            dataPanel.remove(labelmMetrag);
        }
        if ("Hide".equalsIgnoreCase(panelBinding.getDisplayHint("VwOrderView1", "Montag", null))) {
            dataPanel.remove(mMontag);
            dataPanel.remove(labelmMontag);
        }
        if ("Hide".equalsIgnoreCase(panelBinding.getDisplayHint("VwOrderView1", "Num", null))) {
            dataPanel.remove(mNum);
            dataPanel.remove(labelmNum);
        }
        if ("Hide".equalsIgnoreCase(panelBinding.getDisplayHint("VwOrderView1", "Summa", null))) {
            dataPanel.remove(mSumma);
            dataPanel.remove(labelmSumma);
        }
        if ("Hide".equalsIgnoreCase(panelBinding.getDisplayHint("VwOrderView1", "Total_Cost", null))) {
            dataPanel.remove(mTotal_Cost);
            dataPanel.remove(labelmTotal_Cost);
        }
        if ("Hide".equalsIgnoreCase(panelBinding.getDisplayHint("VwOrderView1", "UserS", null))) {
            dataPanel.remove(mUserS);
            dataPanel.remove(labelmUserS);
        }
        if ("Hide".equalsIgnoreCase(panelBinding.getDisplayHint("VwOrderView1", "ZakSumm", null))) {
            dataPanel.remove(mZakSumm);
            dataPanel.remove(labelmZakSumm);
        }
        if ("Hide".equalsIgnoreCase(panelBinding.getDisplayHint("VwOrderView1", "Zamer", null))) {
            dataPanel.remove(mZamer);
            dataPanel.remove(labelmZamer);
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

        PanelVwOrderView1Helper1 panel = new PanelVwOrderView1Helper1();
        panel.setBindingContext(JUTestFrame.startTestFrame("view.DataBindings.cpx", "null", panel,
                                                           panel.getPanelBinding(), new Dimension(400, 300)));
        panel.revalidate();
    }
}

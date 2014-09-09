package client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Frame1 extends JFrame {
    BorderLayout layoutMain = new BorderLayout();
    JPanel panelCenter = new JPanel();
    JMenuBar menuBar = new JMenuBar();
    JMenu menuFile = new JMenu();
    JMenuItem menuFileExit = new JMenuItem();
    JLabel statusBar = new JLabel();

    public Frame1() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setJMenuBar( menuBar );
        this.getContentPane().setLayout( layoutMain );
        panelCenter.setLayout( null );
        this.setSize( new Dimension(400, 300) );
        menuFile.setText( "File" );
        menuFileExit.setText( "Exit" );
        menuFileExit.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent ae ) { fileExit_ActionPerformed( ae ); } } );
        statusBar.setText( "" );
        menuFile.add( menuFileExit );
        menuBar.add( menuFile );
        this.getContentPane().add( statusBar, BorderLayout.SOUTH );
        this.getContentPane().add( panelCenter, BorderLayout.CENTER );
    }

    void fileExit_ActionPerformed(ActionEvent e) {
        System.exit(0);
    }
}

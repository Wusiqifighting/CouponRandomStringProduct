package com.capmi.test;

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;

public class FileChooserDemo extends JFrame {
	
    final static private Dimension SIZE = new Dimension(200, 100);
 
    public String getTitle() {return "FileChooserDemo";}
 
    public Dimension getPreferredSize() {return SIZE;}
 
    public Dimension getMinimumSize() {return SIZE;}
 
    public Dimension getMaximumSize() {return SIZE;}
 
    public Dimension getSize() {return SIZE;}
 
    private JButton saveButton;
    
    public FileChooserDemo() throws HeadlessException {
        init();
        attachListeners();
        doLay();
        setVisible(true);
    }
 
    private void init() {
        saveButton=new JButton(new ChooseAction());
    }
 
    private void attachListeners() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }
 
    private void doLay() {
        getContentPane().add(saveButton,BorderLayout.NORTH);
        pack();
    }
 
    private class ChooseAction extends AbstractAction{
        private JFileChooser fileChooser;
        public ChooseAction() {
            super("Export...");
        }
 
        public void actionPerformed(ActionEvent e) {
            init();
            if(JFileChooser.APPROVE_OPTION==fileChooser.showSaveDialog(null)){
                System.err.println("选择的路径是："+fileChooser.getSelectedFile());
            }
        }
 
        private void init(){
            if (fileChooser==null) {
                fileChooser=new JFileChooser(".");
                FileFilter xmlFilter = new FileNameExtensionFilter("xls file(*.xls)","xls");
                fileChooser.addChoosableFileFilter(xmlFilter);
            }
        }
    }
    
    public void createvalue(){
    	  System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
          SwingUtilities.invokeLater(FileChooserDemo::new);
    }
 
    public static void main(String... args) {
        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        SwingUtilities.invokeLater(FileChooserDemo::new);
    }
}
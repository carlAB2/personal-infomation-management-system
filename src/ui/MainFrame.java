package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame {
   private JFrame mainFrame;
   private JPanel controlPanel;
   private JLabel msglabel;

   public MainFrame(){
      prepareGUI();
   }
   public static void main(String[] args){
	   MainFrame swingLayoutDemo = new MainFrame();  
      swingLayoutDemo.showGroupLayoutDemo();
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Java SWING GroupLayoutDemo(yiibai.com)");
      mainFrame.setSize(400,400);
      mainFrame.getContentPane().setLayout(new GridLayout(3, 1));

      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }
      });    
      controlPanel = new JPanel();
      mainFrame.getContentPane().add(controlPanel);
      controlPanel.setLayout(null);
      mainFrame.setVisible(true);  
   }
   private void showGroupLayoutDemo(){
      mainFrame.setVisible(true);  
   }
}



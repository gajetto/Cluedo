/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ludovic
 */
public class LogView extends JScrollPane  {
    
    private static final long serialVersionUID = 1L;
    
    private  JTable logger;
    private final String [] titre = {"Tour#","Demandeur","Témoin","Arme","Personnage","Pièce"};
    private String [][] journal;
    private Font font = new Font("Helvetica", Font.BOLD, 13);
    private final Border scrollBorderOne = BorderFactory.createBevelBorder(0, Color.black, Color.darkGray);
    private final Border scrollTitleBorderOne = BorderFactory.createTitledBorder(scrollBorderOne, "Panneau principal", 0, 0, null, Color.BLACK);
    
    
    
    public LogView (String [][] journal){
        
        this.setBounds(50, 60, 600, 120);
        
        this.setBorder(scrollBorderOne);
        this.setBorder(scrollTitleBorderOne);
        Image titleIcon = Toolkit.getDefaultToolkit().getImage("C:/Users/Ludovic/Pictures/cluedo/detective.jpg");
        //put = new JButton ("Valider");
        
        
        this.setBackground(new Color(10,0,0));
        this.setLayout(null);
        logger = new JTable (journal,titre);
        //logger.setSelectionBackground(new Color(159,0,0));
        logger.setEnabled(true);
        logger.setFont(font);
        //logger.setGridColor(Color.BLUE);
        logger.setName("LOG CLUEDO");        
        logger.setPreferredScrollableViewportSize(new Dimension (650,300));
        logger.setFillsViewportHeight(false);
        
        this.add(logger);
        this.setOpaque(true);
        this.setVisible(true);
    }
    
    
    public JScrollPane getScrollPane (){
        return this;
    }
      public JTable getLogger (){
          return logger;
      }
      
     
    public void seeScroll (){
        this.setVisible(true);
    }
    public void seeTable (){
        this.logger.setVisible(true);
    }
   
}
   

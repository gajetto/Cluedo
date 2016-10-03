/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import logic.FirstController;
import data.FirstPlayer;
import data.GameData;
import data.GameDataFive;
import data.GameDataFour;
import data.GameDataSix;
import data.GameDataThree;
import data.Player;
import view.Menu.Solve;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import java.awt.Graphics;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.NullPointerException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Ludovic Jframe Setting pour configurer la partie avec le nom des
 * joueurs et le nombre de cartes détenus par chacun des joueurs.
 */
public class FirstView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JOptionPane paneName;
    private JOptionPane panePlayer;

    private JLabel background;
    private BufferedImage image;
    private JLabel pic;
    private BackgroundPane back;
    private JLayeredPane pane;
    private Menu top;
    private FirstPanel main;
    private int status;
    private int index;
    private static int iterator = 0;
    private Container contentPane;
    public List<int[]> recorder;
    //public int[] couple = {1, 15};
    Border bevel = BorderFactory.createBevelBorder(2, Color.lightGray, Color.yellow);
    // Border dashed = BorderFactory.createDashedBorder(null, TOP_ALIGNMENT, TOP_ALIGNMENT, TOP_ALIGNMENT, rootPaneCheckingEnabled);
    //Border etched = BorderFactory.createEtchedBorder(2, Color.lightGray, Color.yellow);
    //Border matte = BorderFactory.createMatteBorder(1, 1, 1, 2, Color.yellow);
    private Color color;
    private String primo;
    private String secondo;
    private String tertio;
    private String quadro;
    private String pento;
    private String name;
    private String[]list;

    public FirstView() throws IOException, InterruptedException {

        super();
       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(1020, 690);
        this.setTitle("CLUEDO : THE GAME");
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setAlwaysOnTop(true);
        Image titleIcon = Toolkit.getDefaultToolkit().getImage("C:/Users/Ludovic/Pictures/cluedo/detective.jpg");
        this.setIconImage(titleIcon);
        this.setLayout(new BorderLayout());

        top = new Menu();
        back = new BackgroundPane();
        pane = this.getLayeredPane();
        this.setContentPane(back);
        this.setJMenuBar(top);
        pane.add(back, new Integer(0));
        pane.add(top, new Integer(100));
        color = new Color(10, 0, 0);
        this.setBackground(color);
        this.setLayeredPane(pane);
        contentPane = this.getContentPane();
        this.setVisible(true);
        iterator++;

        System.out.println("new panel created");
    }

   


    

    public String getName() {
        name = JOptionPane.showInputDialog(this, "Ton prénom ?");
        return name;
    }

    public int getNumber() {
        int num = 0;
        Integer[] list = {3, 4, 5, 6};
        num = (Integer) JOptionPane.showInputDialog(
                this,
                "Combien de joueurs",
                "Nombre de joueurs ?",
                JOptionPane.QUESTION_MESSAGE,
                null,
                list,
                "5");
        return num;
    }
    
    
    
    public String getPrimo (){
        primo = JOptionPane.showInputDialog(this, "Prénom du voisin de gauche");
        return primo;
        
    }
    public String getSecondo (){
        secondo = JOptionPane.showInputDialog(this, "Prénom du voisin à gauche de " + primo);
        
        return secondo;
        
    }
    public String getTertio (){
        tertio = JOptionPane.showInputDialog(this, "Prénom du voisin à gauche de " + secondo);       
        return tertio;
        
    }
    public String getQuadro (){
        quadro = JOptionPane.showInputDialog(this, "Prénom du voisin à gauche de " + tertio);
        return quadro;
        
    }
    public String getPento (){
        pento = JOptionPane.showInputDialog(this, "Prénom du voisin à gauche de " + quadro);
        return pento;
        
    }
      public String getOrder(String[]list) {
        String choix = null;
        choix = (String) JOptionPane.showInputDialog(
                this,
                null,
                "Qui commence la partie ? ",
                JOptionPane.QUESTION_MESSAGE,
                null,
                list,
                "zero");
        return choix;
    }    
    
public BackgroundPane getBackgroundPane() {
        return back;
    }

    public Menu getMenu() {
        return top;
    }
    

}

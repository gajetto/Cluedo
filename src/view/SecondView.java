/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Ludovic
 */
public class SecondView extends JFrame {
    private static final long serialVersionUID = 1L;

    private JOptionPane paneName;
    private JOptionPane panePlayer;
    private JLabel background;
    private BufferedImage image;
    private JLabel pic;
    private BackgroundPane back;
    private JLayeredPane pane;
    private MenuBar top;
    private SecondPanel main;
    private BottomPanel bottom;
    private LogView logon;

    private static int iterator = 0;
    private Container contentPane;
    String primo = null;
    String secondo = null;
    String tertio = null;
    String quadro = null;
    String pento = null;
    String zero = null;
    private Color color;
    private List<String> joueurs;
    private int index;
    private List<Integer> recorder;
    private String card;
    private String joueur;
    private String choix;
    private int pick;
    private String[] titre = {"Tour#", "Demandeur", "Témoin", "Arme", "Personnage", "Pièce"};
    private String[][] journal;
    private JTable logger;
    private JScrollPane scroll;
    private SecondPanel panel;
    private static int instances;

    public SecondView(List<Integer> recorder, List<String> joueurs, int index, String affiche, String[][] log, boolean go) throws IOException, InterruptedException {
        super();
        this.joueurs = joueurs;
        this.index = index;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(1020, 690);
        this.setTitle("CLUEDO : THE GAME");
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setAlwaysOnTop(false);
        Image titleIcon = Toolkit.getDefaultToolkit().getImage("C:/Users/Ludovic/Pictures/cluedo/detective.jpg");
        this.setIconImage(titleIcon);

        top = new MenuBar();

        if (go == false) {
            back = new BackgroundPane(recorder, joueurs, index);
            pane = this.getLayeredPane();
            this.setContentPane(back);
            this.setJMenuBar(top);
            pane.add(back, new Integer(0));
            pane.add(top, new Integer(100));
            color = new Color(10, 0, 0);
            this.setBackground(color);
            this.setLayeredPane(pane);
            contentPane = this.getContentPane();
            bottom = back.getBottomPanel();
            main = back.getSecondPanel();
            // les message en bas de page sont affichés pour aiguiller le joueur
            bottom.setText(affiche);
            this.revalidate();
        } /*Uniquement pour la fonction Journal/log qui permet au joueur de voir ce qui
         a été joué les tours précédents (le booleen vaut True dans ce cas)
         */ else {
            back = new BackgroundPane(recorder, joueurs, index, log);
            pane = this.getLayeredPane();
            this.setContentPane(back);
            this.setJMenuBar(top);
            logon = back.getLog();
            pane.add(back, new Integer(0));
            pane.add(top, new Integer(100));
            //pane.add(logon, new Integer (200));
            color = new Color(10, 0, 0);
            this.setBackground(color);
            this.setLayeredPane(pane);
            color = new Color(10, 0, 0);
            this.setLayeredPane(pane);
            // les message en bas de page sont affichés pour aiguiller le joueur
            bottom = back.getBottomPanel();
            bottom.setText(affiche);
        }

        instances++;
        this.setVisible(true);
    }

    public List<String> getNoms() {
        return joueurs;
    }

    public int getIndex() {
        return index;
    }

    public void gotRemoved(String killed) {
        JOptionPane.showMessageDialog(this, killed + " a été éliminé de la partie","Notice", JOptionPane.INFORMATION_MESSAGE, null);    
    }
    public String getCard() {
        card = JOptionPane.showInputDialog(this, "Quelle carte a été dévoilée ?");
        return card;
    }

    public int getChoice() {
        pick = JOptionPane.showConfirmDialog(this, "Passer au tour suivant ?", "to increment or not to increment ???", YES_NO_OPTION);
        return pick;
    }

    public String getPlayer(int nbre) {
        int num = 0;
        String[] list = {joueurs.get(1), joueurs.get(2), joueurs.get(3), joueurs.get(4)};
        choix = (String) JOptionPane.showInputDialog(
                this,
                "Qui a montré la carte",
                "J'ai pris ma loupe...",
                JOptionPane.QUESTION_MESSAGE,
                null,
                list,
                joueurs.get(1));
        return choix;
    }

    public String killPlayer(String[] joueurs) {
        String killed = null;
        killed = (String) JOptionPane.showInputDialog(
                this,
                "Qui est éliminé ?",
                "Farewell, old friend ...",
                JOptionPane.QUESTION_MESSAGE,
                null,
                joueurs,
                joueurs[0]);
        return killed;
    }

    public String[] convertPlayers(List<String> joueurs) {
        joueurs.remove(0);
        int length = joueurs.size();
        String[] player = new String[joueurs.size()];
        player = joueurs.toArray(player);

        return player;

    }

    public BackgroundPane getBackgroundPane() {
        return back;
    }

    public MenuBar getBar() {
        return top;
    }

}

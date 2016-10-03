/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import view.CluedoException.CardsJComboBoxException;
import view.CluedoException.FirstPlayerNullPointerException;

import view.CluedoException.JComboBoxException;
import view.CluedoException.RoomException;
import view.CluedoException.SuspectException;
import view.CluedoException.WeaponException;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Ludovic
 */
public class FirstPanel extends JPanel {

    private static int nbreJoueurs;
    private static final long serialVersionUID = 1L;
    private String joueur;
    private List<String> myCards = new ArrayList<String>();
    private List<String> myWeapons= new ArrayList<String>();
    private List<String> mySuspects = new ArrayList<String>();
    private List<String> myPlaces = new ArrayList<String>();
    /*private ArrayList<JPanel> paneList = new ArrayList<JPanel>();*/
    // NOTA BENE !!!!!!!!!!!!!!!!!!!!!!!!
    // Bien penser à implémenter un menu ou une fenêtre où il est possible d'ajouter et supprimer manuellement des cartes du jeu
    // directement à partir du tableau principal voire même du tableau des joueurs !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public final String[] arm = {"Poignard", "Revolver", "Matraque", "Chandelier", "Corde", "Clef Anglaise", "Poison", "Fer à Cheval"};
    public final String[] suz = {"Rose", "Moutarde", "Leblanc", "Olive", "Pervenche", "Violet", "Pêche", "Prunelle", "Legris", "Chose"};
    public final String[] pie = {"Cuisine", "Salle à manger", "Billard", "Petit Salon", "Grand Salon", "Veranda", "Fontaine", "Jardin", "Grange", "Bureau", "Bibliothèque", "Kiosque"};
    private String tres = "Coche tes cartes...";
    private static GridBagConstraints constraint = new GridBagConstraints();
    private CluedoException instance;
    private final Border panelBorderOne = BorderFactory.createBevelBorder(0, Color.black, Color.darkGray);
    private final Border titleBorderOne = BorderFactory.createTitledBorder(panelBorderOne, "Panneau principal", 0, 0, null, Color.BLACK);
    private Font fontBig = new Font("Helvetica", Font.BOLD, 16);
    private JLabel carteLabel;
    private JLabel number;
    private List<JTextField> fieldList;
    private ArrayList<Integer> boxList = new ArrayList<Integer>();
    private JRadioButton shown;
    private JRadioButton notShown;

    private static int instances = 0;

    private JRadioButton armBox;
    private JRadioButton suzBox;
    private JRadioButton pieBox;
    private ButtonGroup group;
    private List<JRadioButton> armGroup;
    private List<JRadioButton> suzGroup;
    private List<JRadioButton> pieGroup;

    public FirstPanel() {
        this.setBorder(panelBorderOne);
        this.setBorder(titleBorderOne);
        this.setPreferredSize(new Dimension(700, 530));
        this.setMinimumSize(new Dimension(500, 350));
        this.setMaximumSize(new Dimension(700, 530));

        this.setLayout(new GridBagLayout());
        constraint.insets = new Insets(50, 0, 0, 300);
        constraint.gridy = 0;

        // Première ligne 
        constraint.gridy = 1;
        // nbLabel = new JLabel(uno);
        //this.setLabel(nbLabel);
        constraint.fill = GridBagConstraints.VERTICAL;

        //this.setPlayerBox();
        // Seconde ligne
        constraint.gridy = 2;
      //  prenomLabel = new JLabel(dos);
        // this.setLabel(prenomLabel);
        // field = new JTextField(10);

        //  this.setTextField(field);
        constraint.fill = GridBagConstraints.VERTICAL;

        // Troisième ligne
        constraint.gridy = 5;
        constraint.gridwidth = 1;
        carteLabel = new JLabel(tres);
        this.setLabel(carteLabel);

        int j;
        int i;
        int r;
        armGroup = new ArrayList<JRadioButton>();
        suzGroup = new ArrayList<JRadioButton>();
        pieGroup = new ArrayList<JRadioButton>();

        for (j = 0; j < 3; j++) {
            for (i = 0; i < arm.length; i++) {

                // va défnir le gridY pour tout le tour de boucle en disposant les composants de haut en bas
                r = 8;
                armBox = new JRadioButton(arm[i], false);
                constraint.gridy = i + r;
                this.setCards(armBox, 0);
                constraint.fill = GridBagConstraints.HORIZONTAL;
                armGroup.add(armBox);
                armBox.addItemListener(new Card());
            }

            for (i = 0; i < suz.length; i++) {
                r = 8;
                suzBox = new JRadioButton(suz[i], false);
                constraint.gridy = i + r;
                this.setCards(suzBox, 1);
                constraint.fill = GridBagConstraints.HORIZONTAL;
                suzGroup.add(suzBox);
                suzBox.addItemListener(new Card());

            }
            for (i = 0; i < pie.length; i++) {
                r = 8;
                pieBox = new JRadioButton(pie[i], false);
                constraint.gridy = i + r;
                this.setCards(pieBox, 2);
                constraint.fill = GridBagConstraints.HORIZONTAL;
                pieGroup.add(pieBox);
                pieBox.addItemListener(new Card());
            }
            constraint.insets = new Insets(0, 0, 20, 300);
        }
        this.setOpaque(false);
        instances++;
        instance = new CluedoException();

    }

    // JLabel ligne 1,2 et 3
    public void setLabel(JLabel label) {
        constraint.gridx = 0;
        constraint.gridheight = 1;
        constraint.ipadx = 60;

        constraint.anchor = GridBagConstraints.FIRST_LINE_START;

        label.setFont(fontBig);
        label.setForeground(Color.BLACK);

        if (label.getText().equals(tres)) {
            constraint.insets = new Insets(150, 0, 30, 0);
            label.setToolTipText("Cochez les cases ci-dessous");
        }
        this.add(label, constraint);
    }

    
    
    
    public void setCards(JRadioButton check, int grid) {
        constraint.gridx = grid;
        constraint.gridheight = 1;
        constraint.ipady = 0;
        check.setOpaque(false);
        constraint.insets = new Insets(0, 0, 0, 0);
        constraint.anchor = GridBagConstraints.LINE_START;
        this.add(check, constraint);
    }

    public int getMyNbOfCards() {
        int number = 0;
        int i = 0;
        for (i = 0; i < arm.length; i++) {
            if (armGroup.get(i).isSelected()) {
                number++;
            }
        }
        int j = 0;
        for (j = 0; j < suz.length; j++) {
            if (suzGroup.get(j).isSelected()) {
                number++;
            }
        }
        int k = 0;
        for (k = 0; k < pie.length; k++) {
            if (pieGroup.get(k).isSelected()) {
                number++;
            }
        }
        return number;
    }

    public List<String> getCardsOfFirstPlayer() {
        return myCards;
    }

    public List<String> getWeaponsOfFirstPlayer() {
        return myWeapons;
    }

    public List<String> getSuspectsOfFirstPlayer() {
        return mySuspects;
    }

    public List<String> getPlacesOfFirstPlayer() {
        return myPlaces;
    }

    class Card implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) throws NullPointerException {

            //To change body of generated methods, choose Tools | Templates.
            int i;
 
            

            for (i = 0; i < suz.length; i++) {
                if (e.getSource().equals(suzGroup.get(i)) && e.getStateChange() == ItemEvent.SELECTED) {
                    String name = suzGroup.get(i).getText();
                    mySuspects.add(name);
                    myCards.add(name);
                    System.out.println("tu as selectionné le suspect : " + name);
                } else if (e.getSource().equals(suzGroup.get(i)) && e.getStateChange() == ItemEvent.DESELECTED) {
                    String name = suzGroup.get(i).getText();
                    mySuspects.remove(name);
                    myCards.remove(name);
                    System.out.println("tu as déselectionné le suspect : " + name);
                }
            }
            for (i = 0; i < pie.length; i++) {
                if (e.getSource().equals(pieGroup.get(i)) && e.getStateChange() == ItemEvent.SELECTED) {
                    String name = pieGroup.get(i).getText();                    
                    myPlaces.add(name);
                    myCards.add(name);
                    System.out.println("tu as selectionné la pièce : " + name);
                } else if (e.getSource().equals(pieGroup.get(i)) && e.getStateChange() == ItemEvent.DESELECTED) {
                    String name = pieGroup.get(i).getText();
                    myPlaces.remove(name);
                    myCards.remove(name);
                    System.out.println("tu as déselectionné la pièce : " + name);
                }
            }
            for (i = 0; i < arm.length; i++) {
                if (e.getSource().equals(armGroup.get(i)) && e.getStateChange() == ItemEvent.SELECTED) {
                    String name = armGroup.get(i).getText();
                    myWeapons.add(name);
                    myCards.add(name);
                    System.out.println("tu as selectionné l'arme : " + name);
                } else if (e.getSource().equals(armGroup.get(i)) && e.getStateChange() == ItemEvent.DESELECTED) {
                    String name = armGroup.get(i).getText();
                    myWeapons.remove(name);
                    myCards.remove(name);
                    System.out.println("tu as déselectionné l'arme : " + name);
                }
            }
        }
    }

    public void setNbOfPlayers(int nb) {
        nbreJoueurs = nb;
    }

    public int getNbOfPlayers() {
        return nbreJoueurs;
    }
}

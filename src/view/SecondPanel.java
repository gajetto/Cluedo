/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

/**
 *
 * @author Ludovic
 */
public class SecondPanel extends JPanel implements ItemListener {

    private static int nbreJoueurs;
    private static final long serialVersionUID = 1L;

    /*private ArrayList<JPanel> paneList = new ArrayList<JPanel>();*/
    // NOTA BENE !!!!!!!!!!!!!!!!!!!!!!!!
    // Bien penser à implémenter un menu ou une fenêtre où il est possible d'ajouter et supprimer manuellement des cartes du jeu
    // directement à partir du tableau principal voire même du tableau des joueurs !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public final String[] armes = {"", "Le Poignard", "Le Revolver", "La Matraque", "Le Chandelier", "La Corde", "La Clef Anglaise", "Le Poison", "Le Fer à Cheval"};
    public final String[] suspects = {"","Mademoiselle Rose", "Le colonel Moutarde", "Madame Leblanc", "Le Docteur Olive", "Madame Pervenche", "Le Professeur Violet", "Mademoiselle Pêche", "Monsieur Prunelle", "Le Sergent Legris", "Madame Chose"};
    public final String[] pieces = {"","La Cuisine", "La Salle à manger", "Le Billard", "Le Petit Salon", "Le Grand Salon", "La Veranda", "La Fontaine", "Le Jardin", "La Grange", "Le Bureau", "La Bibliothèque", "Le Kiosque"};
    public final String[] vue = new String[5];
    

    private JLabel soupcon;
    private JLabel avec;
    private JLabel dans;
    private JLabel montree;
    private JLabel decouverte;
    private JLabel par;

    private JComboBox characters;
    private JComboBox weapons;
    private JComboBox rooms;
    private JComboBox players;
    private JComboBox shown;

    // A voir si on garde cette liste d'integer pour les choix de cartes....
    private ArrayList<Integer> boxList = new ArrayList<Integer>();
    private JRadioButton oui;
    private JRadioButton non;
    private ButtonGroup group;

    private static GridBagConstraints constraint = new GridBagConstraints();
    private CluedoException instance;
    private Font fontBig = new Font("Helvetica", Font.BOLD, 15);
    private final Border panelBorderOne = BorderFactory.createBevelBorder(0, Color.black, Color.darkGray);
    private final Border titleBorderOne = BorderFactory.createTitledBorder(panelBorderOne, "Panneau principal", 0, 0, null, Color.BLACK);
    private static int instances = 0;

    private int[] hypothesis = new int[3];
    private int numero;
    private String nom;
    private int askIndex;
    private int answer;
    private int indice;
    private int[]combi = new int [2];
    private GridBagConstraints c;
    List<String> candidat;
    
    
    
    
    
    @SuppressWarnings({"unchecked", "unchecked"})
    
    
    
    
    
    public SecondPanel(List<String> joueurs, int index) {
        candidat = new ArrayList<String>();
        for (int i = 0 ; i < joueurs.size(); i++){
            candidat.add(joueurs.get(i));
        }
        
        askIndex = index;
        this.setBorder(panelBorderOne);
        this.setBorder(titleBorderOne);
        this.setPreferredSize(new Dimension(700, 530));
        this.setMinimumSize(new Dimension(500, 350));
        this.setMaximumSize(new Dimension(700, 530));
        this.setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        group = new ButtonGroup();

        c.insets = new Insets(20, 0, 0, 350);
        c.fill = GridBagConstraints.RELATIVE;
        // c.weightx = 1.0;
        // c.weighty = 1.0;
        c.gridy = 0;

        if (index == 0) {
            JLabel soupcon = new JLabel("Je soupçonne   ");
            this.setLabel(soupcon, 0, 0, 50, 0, 0, 18, false);
        } else {
            JLabel soupcon = new JLabel(joueurs.get(index) + " soupçonne  ");
            this.setLabel(soupcon, 0, 0, 50, 0, 0, 18, false);
        }

        characters = new JComboBox(suspects);
        this.setComboBox(characters, 1, 0, 50, 0, 0, 0);
        characters.addItemListener(this);
        avec = new JLabel("  avec  ");
        this.setLabel(avec, 2, 0, 50, 0, 0, 0, false);
        weapons = new JComboBox(armes);
        this.setComboBox(weapons, 3, 0, 50, 0, 0, 0);
        weapons.addItemListener(this);
        dans = new JLabel("dans  ");
        this.setLabel(dans, 4, 0, 50, 0, 0, 0, false);
        rooms = new JComboBox(pieces);
        this.setComboBox(rooms, 5, 0, 50, 0, 0, 0);
        rooms.addItemListener(this);

        c.anchor = GridBagConstraints.REMAINDER;
        if (index == 0) {
            candidat.remove(0);
            candidat.add(0, "");
            candidat.add("Personne");
            
            players = new JComboBox();
            players.setModel(new DefaultComboBoxModel(candidat.toArray()));
            this.setComboBox(players, 0, 1, 65, 0, 0, 0);
            players.addItemListener(this);

            decouverte = new JLabel(" a montré ");
            this.setLabel(decouverte, 1, 1, 65, 44, 0, 0, false);
            vue[0] = " ";
            vue[1] = "une arme";
            vue[2] = "un personnage";
            vue[3] = "un lieu";
            vue[4] = "Rien";
            shown = new JComboBox(vue);
            this.setComboBox(shown, 3, 1, 65, 0, 0, 0);
            shown.addItemListener(this);

        } else {
            montree = new JLabel("Carte montrée par ?    ");
            this.setLabel(montree, 0, 2, 65, 0, 0, 0, false);

            candidat.remove(index);
            candidat.add(0, "");
            candidat.add("Personne");
            players = new JComboBox();
            players.setModel(new DefaultComboBoxModel(candidat.toArray()));
            this.setComboBox(players, 1, 2, 65, 0, 0, 0);
            players.addItemListener(this);
            System.out.println(candidat.toArray());

        }
        this.setOpaque(false);
        instances++;
        instance = new CluedoException();

    }
    
    
    
    
    
    
    public SecondPanel() {       
        //this.setBorder(panelBorderOne);
        //this.setBorder(titleBorderOne);
        this.setPreferredSize(new Dimension(700, 530));
        this.setMinimumSize(new Dimension(500, 350));
        this.setMaximumSize(new Dimension(700, 530));
        //this.setBackground(new Color(10,0,0));
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
    }
    
    
    
    
    
    
    
 @Override
    public void itemStateChanged(ItemEvent e) throws NullPointerException {
            
        //To change body of generated methods, choose Tools | Templates.
        int i;
        for (i = 0; i < armes.length; i++) {
            if (e.getItem().equals(weapons.getItemAt(i)) && e.getStateChange() == ItemEvent.SELECTED) {
                int ind = i;
                hypothesis[0] = ind;
                
            }
        }
        for (i = 0; i < suspects.length; i++) {
            if (e.getItem().equals(characters.getItemAt(i)) && e.getStateChange() == ItemEvent.SELECTED) {
                int ind = i;
                hypothesis[1] = ind;
               

            }
        }
        for (i = 0; i < pieces.length; i++) {
            if (e.getItem().equals(rooms.getItemAt(i)) && e.getStateChange() == ItemEvent.SELECTED) {
                int ind = i;
                hypothesis[2] = ind;
               

            }
        }

        for (i = 0; i < candidat.size(); i++) {
            if (e.getItem().equals(players.getItemAt(i)) && e.getStateChange() == ItemEvent.SELECTED) {
                numero = i;
                nom = candidat.get(numero);
                
                if (i == 5 && askIndex == 0){
                    shown.setVisible(false);
                }
                else if(i!=5 && askIndex == 0){
                    shown.setVisible(true);
                }
                if (i==1 && askIndex == 0){
                }
            }
        }
        if (askIndex == 0) {
            for (i = 0; i < vue.length; i++) {
                if (e.getItem().equals(shown.getItemAt(i)) && e.getStateChange() == ItemEvent.SELECTED) {
                    if (i == 0) {
                        System.out.println(indice);
                    }
                    if (i == 1) {
                        indice = i;                        
                    }
                    else if (i == 2) {
                        indice = i;                                                      
                    }
                    else if (i == 3) {
                        indice = i;                       
                    } else {                      
                        indice = 4;
                       
                        String rep = "rien";
                    }
                }
            }
        }
    }
    
    
    
    
    

    public int[] getHypothesis() {
        return hypothesis;
    }

    public int getNumero() {
        return numero;
    }
    public String getNom(){
        return nom;
    }

    public int getAskIndex() {
        return askIndex;
    }

    public int getAnswer() {
        return answer;
    }
    public int getIndice (){
        return indice;
    }
  

    public void setNbOfPlayers(int nb) {
        nbreJoueurs = nb;
    }

    public int getNbOfPlayers() {
        return nbreJoueurs;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
 
    private void setComboBox(JComboBox check, int gridx, int gridy, int top, int left, int below, int right) {
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridheight = 1;
        c.ipady = 0;
        check.setOpaque(false);
        c.insets = new Insets(top, left, below, right);
        c.anchor = GridBagConstraints.LINE_START;
        this.add(check, c);
    }

    public void setLabel(JLabel check, int gridx, int gridy, int top, int left, int below, int right, boolean end) {
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridheight = 1;
        c.ipady = 0;
        check.setFont(fontBig);
        check.setForeground(Color.BLACK);
        check.setOpaque(false);
        c.insets = new Insets(top, left, below, right);
        if (end) {
            c.anchor = GridBagConstraints.LINE_END;
        } else {
            c.anchor = GridBagConstraints.LINE_START;
        }
        this.add(check, c);
    }

    public void setRadioButton(JRadioButton check, int gridx, int gridy, boolean end, int top, int left, int below, int right) {
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridheight = 1;
        c.ipady = 0;
        check.setFont(fontBig);
        check.setForeground(Color.BLACK);
        check.setOpaque(false);
        c.insets = new Insets(top, left, below, right);
        if (end) {
            c.anchor = GridBagConstraints.CENTER;
        } else {
            c.anchor = GridBagConstraints.LINE_START;
        }
        this.add(check, c);
    }
}

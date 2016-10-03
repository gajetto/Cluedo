/*  Z+
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import static javax.swing.text.StyleConstants.Background;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Graphics;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ludovic
 */
// JPanel ou toutes les cartes sont représentées avec leur états en temps réel. inconnue, détenue, suspecte, Ultra suspecte, carte solution
public final class LeftPanel extends JPanel {

    private final Border panelBorderOne = BorderFactory.createBevelBorder(0, Color.black, Color.darkGray);
    private final Border titleBorderOne = BorderFactory.createTitledBorder(panelBorderOne, "Carnet du détective", 0, 0, null, Color.BLACK);
    public final String[] arm = {"Poignard", "Revolver", "Matraque", "Chandelier", "Corde", "Clef Anglaise", "Poison", "Fer à Cheval"};
    public final String[] suz = {"Rose", "Moutarde", "Leblanc", "Olive", "Pervenche", "Violet", "Pêche", "Prunelle", "Legris", "Chose"};
    public final String[] pie = {"Cuisine", "Salle à manger", "Billard", "Petit Salon", "Grand Salon", "Veranda", "Fontaine", "Jardin", "Grange", "Bureau", "Bibliothèque", "Kiosque"};
    public final JComponent[] labels = new JComponent[32];
    // Compte le nombre de fois que le panel est créé !!!
    // private static int counter = 0;
    private static int size;
    private static int real;
    private int[] couple = new int[2];
    private Graphics gag;
    private Graphics2D graphLabel;
    private Map attributes;
    public JLabel armLabel;
    public JLabel susLabel;
    public JLabel pieLabel;
    private BufferedImage image;
    private JSeparator sepOne;
    private JSeparator sepTwo;
    private Integer index;
    private Integer status;
    private Font strikeFont;
    private Font fontNormal = new Font("Helvetica", Font.BOLD, 13);
    private final Color sang = new Color (159,0,0);
    private final Color doutage = new Color (255, 40,140);
    private final Color eureka = new Color (50, 137,0);

    public LeftPanel(List<Integer> recorder) throws IOException, InterruptedException {
        setBorder(panelBorderOne);
        setBorder(titleBorderOne);
        this.setPreferredSize(new Dimension(180, 430));
        this.setMinimumSize(new Dimension(180, 430));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        int i;
        // On positionne les armes
        for (i = 0; i < arm.length; i++) {
            armLabel = new JLabel(arm[i]);
            labels[i] = armLabel;
        }
        // On ajoute le premier séparateur
        sepOne = new JSeparator(SwingConstants.HORIZONTAL);
        Dimension dimOne = sepOne.getPreferredSize();
        dimOne.width = sepOne.getMaximumSize().width;
        sepOne.setMaximumSize(dimOne);
        sepOne.setBorder(panelBorderOne);
        labels[8] = sepOne;
        // On positionne les suspects
        for (i = 0; i < suz.length; i++) {
            susLabel = new JLabel(suz[i]);
            labels[i + 9] = susLabel;
        }
        // On ajoute le second séparateur
        sepTwo = new JSeparator();
        Dimension dimTwo = sepTwo.getPreferredSize();
        dimTwo.width = sepOne.getMaximumSize().width;
        sepTwo.setMaximumSize(dimTwo);
        sepTwo.setBorder(panelBorderOne);
        sepTwo.setBorder(panelBorderOne);
        labels[19] = sepTwo;
        // On poistionne les pièces
        for (i = 0; i < pie.length; i++) {
            pieLabel = new JLabel(pie[i]);
            labels[i + 20] = pieLabel;
        }
        //On applique le font standard au JLabel au début du jeu
        for (i = 0; i < 32; i++) {
            this.add(labels[i]);
            this.setToNormal(i);

        }

        for (i = 0; i < recorder.size(); i++) {
            if (i % 2 == 0 && i!=0) {
                status = recorder.get(i);
                continue;
            } else if (i% 2 != 0) {
                index = recorder.get(i);
            }
            else if (i == 0){
                status = recorder.get(i);
                continue;
            }
            switch (status) {
                case 0:
                    this.setToNormal(index);
                    break;
                case 1:
                    this.setToHeld(index);
                    break;
                case 2:
                    this.setToSuspect(index);
                    break;
                case 3:
                    this.setToCulprit(index);
                    break;
                default:
                    for (i = 0; i < 32; i++) {
                        this.add(labels[i]);
                        this.setToNormal(i);
                    }
            }
        }
        // Toute le code ci-dessus appartient au branchement conditionnel (count == 1) après le premier...

        this.setOpaque(false);
        // counter++;

      
    }

    public LeftPanel() {

        setBorder(panelBorderOne);
        setBorder(titleBorderOne);
        this.setPreferredSize(new Dimension(180, 430));
        this.setMinimumSize(new Dimension(180, 430));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        int i;
        for (i = 0; i < arm.length; i++) {
            armLabel = new JLabel(arm[i]);
            labels[i] = armLabel;
        }
        // On ajoute le premier séparateur
        sepOne = new JSeparator(SwingConstants.HORIZONTAL);
        Dimension dimOne = sepOne.getPreferredSize();
        dimOne.width = sepOne.getMaximumSize().width;
        sepOne.setMaximumSize(dimOne);
        sepOne.setBorder(panelBorderOne);
        labels[8] = sepOne;
        for (i = 0; i < suz.length; i++) {
            susLabel = new JLabel(suz[i]);
            labels[i + 9] = susLabel;
        }

        // On ajoute le second séparateur
        sepTwo = new JSeparator();
        Dimension dimTwo = sepTwo.getPreferredSize();
        dimTwo.width = sepOne.getMaximumSize().width;
        sepTwo.setMaximumSize(dimTwo);
        sepTwo.setBorder(panelBorderOne);
        sepTwo.setBorder(panelBorderOne);
        labels[19] = sepTwo;

        for (i = 0; i < pie.length; i++) {
            pieLabel = new JLabel(pie[i]);
            labels[i + 20] = pieLabel;
        }
        for (i = 0; i < 32; i++) {
            this.add(labels[i]);
            this.setToNormal(i);
        }
        this.setOpaque(false);
    }

    public void setToNormal(int index) {
        JComponent label = labels[index];
        label.setFont(new Font("Helvetica", Font.BOLD, 13));
        label.setForeground(Color.BLACK);
        label.setBackground(Color.BLACK);

    }

    
    
    
    @SuppressWarnings("unchecked")
    public void setToHeld(int index) {
        JComponent label = labels[index];
        label.setForeground(sang);
        label.setBackground(sang);
        attributes = fontNormal.getAttributes();
        attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
        strikeFont = new Font(attributes);
        label.setFont(strikeFont);
    }

    public void setToSuspect(int index) {
        JComponent label = labels[index];
        label.setFont(new Font("Helvetica", Font.BOLD, 13));
        label.setForeground(doutage);
        label.setBackground(doutage);

    }

    public void setToCulprit(int index) {
        int i;
        JComponent label = labels[index];
        label.setFont(new Font("Helvetica", Font.BOLD, 13));
        label.setForeground(eureka);
        label.setBackground(eureka);
        
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 *
 * @author Ludovic
 */
// Panel contenant une console où tous les choix, de cartes et de joueurs sont inscrits 
// Ainsi que de messages spéciaux provenant du Controller pour signaler une carte suspecte et à qui la demander ++ ???
public class BottomPanel extends JTextArea {

private final Border panelBorderOne = BorderFactory.createBevelBorder(0, Color.black, Color.darkGray);
    private final Border titleBorderOne = BorderFactory.createTitledBorder(panelBorderOne, "", 0, 0, null, Color.BLACK);

    public BottomPanel() {
       setBorder(panelBorderOne);
        setBorder(titleBorderOne);
        getPreferredSize();
        this.setMinimumSize(new Dimension (800,50));
        this.setEditable(false);

    }

@Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 50);
    }
}

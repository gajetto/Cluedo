/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import data.FirstPlayer;
import data.GameData;
import data.GameDataFive;
import data.GameDataFour;
import data.GameDataSix;
import data.GameDataThree;
import data.Player;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import static javax.imageio.ImageIO.createImageInputStream;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;

/**
 *
 * @author Ludovic
 */
public class BackgroundPane extends JPanel {

    private static final long serialVersionUID = 1L;
    private ImageInputStream stream;
    private File clue;
    private LeftPanel left;
    private BottomPanel bottom;
    private FirstPanel first;
    private SecondPanel second;
    private Object centralBox;
    private BufferedImage image;
    private JLabel pic;
    private Graphics graph;
    private JTextArea console;
    private int status;
    private int index;
    private static int iterator;
    private LogView loggin;
    private SecondPanel base;
    
   public BackgroundPane() throws IOException {
        
        clue = new File("C:\\Users\\Ludovic\\Pictures\\Cluedo\\clue.png");

        stream = createImageInputStream(clue);
        image = ImageIO.read(stream);

        pic = new JLabel(new ImageIcon(image));
        Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));

        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);

        bottom = new BottomPanel();
        first = new FirstPanel();
        console = new JTextArea();
        left = new LeftPanel();

        this.setLayout(new BorderLayout());
        this.add(left, BorderLayout.WEST);
        this.add(bottom, BorderLayout.SOUTH);
        this.add(first, BorderLayout.CENTER);
        bottom.add(console);
        iterator++;
    }

   
    public BackgroundPane(List<Integer> recorder, List <String> joueurs, int index) throws IOException, InterruptedException {
   
        clue = new File("C:\\Users\\Ludovic\\Pictures\\Cluedo\\clue.png");

        stream = createImageInputStream(clue);
        image = ImageIO.read(stream);

        pic = new JLabel(new ImageIcon(image));
        Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));

        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);

        bottom = new BottomPanel();
        second = new SecondPanel(joueurs, index);
        console = new JTextArea();
        left = new LeftPanel(recorder);

        this.setLayout(new BorderLayout());
        this.add(left, BorderLayout.WEST);
        this.add(bottom, BorderLayout.SOUTH);
        this.add(second, BorderLayout.CENTER);
        bottom.add(console);
        iterator++;

    }

    
    
    
    public BackgroundPane(List<Integer> recorder, List <String> joueurs, int index, String [][] journal) throws IOException, InterruptedException {
   
        clue = new File("C:\\Users\\Ludovic\\Pictures\\Cluedo\\clue.png");

        stream = createImageInputStream(clue);
        image = ImageIO.read(stream);

        pic = new JLabel(new ImageIcon(image));
        Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));

        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);

        bottom = new BottomPanel();
        loggin = new LogView (journal);
        console = new JTextArea();
        left = new LeftPanel(recorder);
        base = new SecondPanel();

        this.setLayout(new BorderLayout());
        this.add(left, BorderLayout.WEST);
        this.add(bottom, BorderLayout.SOUTH);
        this.add(base, BorderLayout.CENTER);
        base.add(loggin, BorderLayout.CENTER);
        bottom.add(console);
        iterator++;
    }
    

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }

    public BottomPanel getBottomPanel() {
        return bottom;
    }

    public LeftPanel getLeftPanel() {
        return left;
    }

    public FirstPanel getFirstPanel() {
        return first;
    }

    public SecondPanel getSecondPanel(){
        return second;
    }
    public JTextArea getConsole() {
        return console;
    }

    public ImageInputStream getStream() {
        return stream;
    }

    public BufferedImage getImage() {
        return image;
    }
    
    public LogView getLog (){
        return loggin;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JMenuBar;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

/**
 *
 * @author Ludovic
 */
@SuppressWarnings("serial")
public class MenuBar extends JMenuBar implements MouseListener {
    
    private final Border panelBorderOne = BorderFactory.createBevelBorder(0, Color.DARK_GRAY, Color.DARK_GRAY);
    private final Border titleBorderOne = BorderFactory.createTitledBorder(panelBorderOne, "", 0, 0, null, Color.BLACK);
    private Solve solve;
    private Input input;
    private Log log;
    private Kill kill;
    private File file;
    private static int nbreJoueurs;
    private String joueur;

    // Key size = 35 !  28 ! --->  32 !  ?? !
    // Pen size = 45 ! 35 ! --->  41 ! 32 !
    // Pipe size = 45! 46 !  ----> 41 ! ?? !
    private ImageIcon key = new ImageIcon("C:\\Users\\Ludovic\\Pictures\\Cluedo\\utilities\\a.png");
    private ImageIcon pen = new ImageIcon("C:\\Users\\Ludovic\\Pictures\\Cluedo\\utilities\\b.png");
    private ImageIcon pipe = new ImageIcon("C:\\Users\\Ludovic\\Pictures\\Cluedo\\utilities\\c.png");
    private ImageIcon gun = new ImageIcon("C:\\Users\\Ludovic\\Pictures\\Cluedo\\utilities\\d.png");

    private ImageIcon keyE = new ImageIcon("C:\\Users\\Ludovic\\Pictures\\Cluedo\\utilities\\aa.png");
    private ImageIcon penE = new ImageIcon("C:\\Users\\Ludovic\\Pictures\\Cluedo\\utilities\\bb.png");
    private ImageIcon pipeE = new ImageIcon("C:\\Users\\Ludovic\\Pictures\\Cluedo\\utilities\\cc.png");
    private ImageIcon gunE = new ImageIcon("C:\\Users\\Ludovic\\Pictures\\Cluedo\\utilities\\dd.png");

    private ImageIcon keyP = new ImageIcon("C:\\Users\\Ludovic\\Pictures\\Cluedo\\utilities\\aaa.png");
    private ImageIcon penP = new ImageIcon("C:\\Users\\Ludovic\\Pictures\\Cluedo\\utilities\\bbb.png");
    private ImageIcon pipeP = new ImageIcon("C:\\Users\\Ludovic\\Pictures\\Cluedo\\utilities\\ccc.png");
    private ImageIcon gunP = new ImageIcon("C:\\Users\\Ludovic\\Pictures\\Cluedo\\utilities\\ddd.png");
    

    private JButton random;
    private ImageIcon icon;
    private final GridBagConstraints constraint;
    private Color color;
    
    
    
    public MenuBar()throws IOException{
         //setBorder(panelBorderOne);
        setBorder(titleBorderOne);
        this.setOpaque(false);
        setBorder(panelBorderOne);
        setBorder(titleBorderOne);

        this.setPreferredSize(new Dimension(1120, 40));
        this.setMinimumSize(new Dimension(500, 40));
        this.setMaximumSize(new Dimension(1120, 40));
        this.setOpaque(false);
        this.setLayout(new GridBagLayout());
        constraint = new GridBagConstraints();
        constraint.fill = GridBagConstraints.RELATIVE;
        // va défnir le gridY à la valeur 0 pour tous les composants suivants :
        constraint.gridy = 0;
        constraint.gridx = 0;
       
        
        solve = new Solve();
        this.setBoxConstraints(solve, 0);
        solve.addMouseListener(this);
        

        input = new Input();
        this.setBoxConstraints(input, 1);
        input.addMouseListener(this);
        
        
        
        log = new Log();
        this.setBoxConstraints(log, 2);
        log.addMouseListener(this);
        
        kill = new Kill();
        this.setBoxConstraints(kill, 3);
        kill.addMouseListener(this);
        
    }
    
    
     
    public void setBoxConstraints(JButton button, int type) {
        constraint.gridheight = 1;
        constraint.gridx = 0;
        
        button.setOpaque(false);

        if (type == 0) {
            constraint.insets = new Insets(9, 10, 9, 15);
            constraint.anchor = GridBagConstraints.LINE_START;
            constraint.weightx = 1.0;
            this.add(button, constraint);

        } else if (type == 1) {
            constraint.gridx = 0;
            constraint.insets = new Insets(5, 40, 3, 15);
            constraint.anchor = GridBagConstraints.LINE_START;
            constraint.weightx = 1.0;

            this.add(button, constraint);
        } else if (type == 2) {
            constraint.insets = new Insets(5, 87, 11, 15);
            constraint.anchor = GridBagConstraints.LINE_START;
            constraint.weightx = 1.0;
            this.add(button, constraint);
        }
        else if (type == 3) {
            constraint.insets = new Insets(6, 135, 5, 15);
            constraint.anchor = GridBagConstraints.LINE_START;
            constraint.weightx = 1.0;
            this.add(button, constraint);
        }
    }
 
        public void setMouseEvents(ImageIcon image, int type) throws IOException {

        switch (type) {
            case 0:
                solve.setIcon(key);
                this.setBoxConstraints(solve, 0);               
                input.setIcon(pen);
                this.setBoxConstraints(input, 1);
                log.setIcon(pipe);
                this.setBoxConstraints(log, 2);
                kill.setIcon(gun);
                this.setBoxConstraints(kill, 3);
                break;
                
            case 1:
                solve.setIcon(image);
                this.setBoxConstraints(solve, 0);                
                input.setIcon(pen);
                this.setBoxConstraints(input, 1);
                log.setIcon(pipe);
                this.setBoxConstraints(log, 2);
                kill.setIcon(gun);
                this.setBoxConstraints(kill, 3);                
                break;               
            case 2:         
                solve.setIcon(key);
                this.setBoxConstraints(solve, 0);               
                input.setIcon(image);
                this.setBoxConstraints(input, 1);
                log.setIcon(pipe);
                this.setBoxConstraints(log, 2);
                kill.setIcon(gun);
                this.setBoxConstraints(kill, 3);               
                break;               
            case 3:             
                solve.setIcon(key);
                this.setBoxConstraints(solve, 0);                
                input.setIcon(pen);
                this.setBoxConstraints(input, 1);
                log.setIcon(image);
                this.setBoxConstraints(log, 2);
                kill.setIcon(gun);
                this.setBoxConstraints(kill, 3);               
                break;                
                case 4:             
                solve.setIcon(key);
                this.setBoxConstraints(solve, 0);
                
                input.setIcon(pen);
                this.setBoxConstraints(input, 1);
                log.setIcon(pipe);
                this.setBoxConstraints(log, 2);
                
                kill.setIcon(image);
                this.setBoxConstraints(kill, 3);
                
                break;
        }
    }

    
   

    
    
    
    
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource().equals(solve)) {
            try {
                this.setMouseEvents(null, 0);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().equals(input)) {
            try {
                this.setMouseEvents(null, 0);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().equals(log)) {
            try {
                this.setMouseEvents(null, 0);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        else if (e.getSource().equals(kill)) {
            try {
                this.setMouseEvents(null, 0);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource().equals(solve)) {
            try {
                this.setMouseEvents(keyP, 1);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().equals(input)) {
            try {
                this.setMouseEvents(penP, 2);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().equals(log)) {
            try {
                this.setMouseEvents(pipeP, 3);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        else if (e.getSource().equals(kill)) {
            try {
                this.setMouseEvents(gunP, 4);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if (e.getSource().equals(solve)) {
            try {
                this.setMouseEvents(null, 0);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().equals(input)) {
            try {
                this.setMouseEvents(null, 0);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().equals(log)) {
            try {
                this.setMouseEvents(null, 0);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        else if (e.getSource().equals(kill)) {
            try {
                this.setMouseEvents(null, 0);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if (e.getSource().equals(solve)) {
            try {
                this.setMouseEvents(keyE, 1);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().equals(input)) {
            try {
                this.setMouseEvents(penE, 2);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().equals(log)) {
            try {
                this.setMouseEvents(pipeE, 3);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        else if (e.getSource().equals(kill)) {
            try {
                this.setMouseEvents(gunE, 4);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(solve)) {
            try {
                this.setMouseEvents(null, 0);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().equals(input)) {
            try {
                this.setMouseEvents(null, 0);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().equals(log)) {
            try {
                this.setMouseEvents(null, 0);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        else if (e.getSource().equals(kill)) {
            try {
                this.setMouseEvents(null, 0);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
    }

    public class Solve extends JButton {

        private static final long serialVersionUID = 1L;
        private final Dimension size;
        private Shape shape;
        private Shape base;
        private Double height;
        private Double width;
        private Color clue;
        private File file;

        public Solve() throws IOException {
            BufferedImage imager = ImageIO.read(new File("C:\\Users\\Ludovic\\Pictures\\Cluedo\\utilities\\a.png"));
            this.setIcon(key);
            size = new Dimension(imager.getWidth(null), imager.getHeight(null));
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
            height = this.getSize().getHeight();
            width = this.getSize().getWidth();

// to remove the border
            this.setBorder(null);
            this.setOpaque(false);
            this.setBorder(BorderFactory.createEmptyBorder());
            this.setContentAreaFilled(false);
            this.setBorderPainted(false);
            this.setFocusPainted(false);
            setLayout(null);

        }

    }

    public class Input extends JButton {

        private static final long serialVersionUID = 1L;
        private final Dimension size;
        private Color clue;
        private Shape shape;
        private Shape base;
        private Double height;
        private Double width;
        private File file;

        public Input() throws IOException {
            BufferedImage imagel = ImageIO.read(new File("C:\\Users\\Ludovic\\Pictures\\Cluedo\\utilities\\b.png"));
            this.setIcon(pen);

            size = new Dimension(imagel.getWidth(null), imagel.getHeight(null));
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
            height = this.getSize().getHeight();
            width = this.getSize().getWidth();

// to add a different backgro;und
// to remove the border
            this.setBorder(null);
            this.setOpaque(false);
            this.setBorder(BorderFactory.createEmptyBorder());
            this.setContentAreaFilled(false);
            this.setBorderPainted(false);
            this.setFocusPainted(false);
            setLayout(null);
        }

    }

    /*
     protected void initShape() {
     Dimension s = getPreferredSize();
     base = getBounds();
     shape = new Ellipse2D.Float(0, 0, s.width - 1, s.height - 1);
     }

     @Override
     protected void paintBorder(Graphics g) {
     this.initShape();

     Graphics2D g2 = (Graphics2D) g;
     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
     RenderingHints.VALUE_ANTIALIAS_ON);
     g2.setColor(getBackground());
     g2.setStroke(new BasicStroke(1.0f));
            
     g2.draw(shape);
     }
     
    */
    
    
    
    public class Log extends JButton {

        private static final long serialVersionUID = 1L;
        private final Dimension size;
        private Shape shape;
        private Shape base;
        private Double height;
        private Double width;
        private Color clue;
        private File file;

        public Log() throws IOException {
            this.file = file;
            BufferedImage imagem = ImageIO.read(new File("C:\\Users\\Ludovic\\Pictures\\Cluedo\\utilities\\c.png"));
            this.setIcon(pipe);
            size = new Dimension(imagem.getWidth(null), imagem.getHeight(null));
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
            height = this.getSize().getHeight();
            width = this.getSize().getWidth();

// to remove the border
            this.setBorder(null);
            this.setOpaque(false);
            this.setBorder(BorderFactory.createEmptyBorder());
            this.setContentAreaFilled(false);
            this.setBorderPainted(false);
            this.setFocusPainted(false);
            setLayout(null);

        }
    }
    
    
    public class Kill extends JButton {

        private static final long serialVersionUID = 1L;
        private final Dimension size;
        private Color clue;
        private Shape shape;
        private Shape base;
        private Double height;
        private Double width;
        private File file;

        public Kill() throws IOException {
            BufferedImage imagel = ImageIO.read(new File("C:\\Users\\Ludovic\\Pictures\\Cluedo\\utilities\\d.png"));
            this.setIcon(gun);

            size = new Dimension(imagel.getWidth(null), imagel.getHeight(null));
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
            height = this.getSize().getHeight();
            width = this.getSize().getWidth();

// to add a different backgro;und
// to remove the border
            this.setBorder(null);
            this.setOpaque(false);
            this.setBorder(BorderFactory.createEmptyBorder());
            this.setContentAreaFilled(false);
            this.setBorderPainted(false);
            this.setFocusPainted(false);
            setLayout(null);
        }

    }
    
    public Solve getSolve (){
        return solve;
    }
    
    public Input getInput (){
        return input;
    }
    
    public Log getLog (){
        return log;
    }
    
    public Kill getKill (){
        return kill;
    }
}

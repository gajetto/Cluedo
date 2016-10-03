/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.FirstPlayer;
import data.Player;
import data.OtherPlayer;
import data.GameData;
import data.GameDataFive;
import data.GameDataFour;
import data.GameDataSix;
import data.GameDataThree;
import java.awt.Container;
import view.Menu.Solve;
import view.FirstView;
import view.FirstPanel;
import view.CluedoException;
import java.lang.Exception;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static javax.imageio.ImageIO.createImageInputStream;
import static javax.imageio.ImageIO.getImageReaders;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;
import view.BackgroundPane;
import view.LeftPanel;
import view.SecondView;
import view.Menu;

/*
 * @author Ludovic
 */
// logique du jeu et instanciation des super-classes et sous-classes
public class FirstController implements ActionListener {

    private CluedoException instance;
    private List<GameData> gameFactory = new ArrayList<GameData>();
    private FirstView view;
    private SecondController control;
    private GameData game;
    private FirstView fenetre;
    private SecondView second;
    private FirstPlayer first;
    private OtherPlayer other;
    private LeftPanel left;

    private Solve solve;
    private FirstPanel main;
    private BackgroundPane back;
    private Menu menu;
    private Container contentPane;
    public List<Integer> recorder;
    public int[] couple = new int[2];
    private List<String> cardsList;
    private String myName = new String();
    private List<String> listOfCards;
    private List<String> weapons;
    private List<String> suspects;
    private List<String> places;
    private String[] liste;
    private int myNumber;
    private int it;
    private int count;
    private int event;
    private List<String> namesList = new ArrayList<String>();
    private List<Integer> nbOfCardsList = new ArrayList<Integer>();
    private ImageInputStream stream;
    private BufferedImage image;
    private int index;
    private int num;
    private String name;
    private Player moi;
    private Player premier;
    private Player deuxieme;
    private Player troisieme;
    private Player quatrieme;
    private Player cinquieme;
    private String primo;
    private String secondo;
    private String tertio;
    private String quadro;
    private String pento;
    protected ArrayList<String> noms = new ArrayList<String>();
    private boolean wep;
    private boolean pers;
    private boolean rom;
    private String[] armes;
    private String[] persos;
    private String[] pieces;
    private GameDataFive gameFive;
    private GameDataSix gameSix;
    private GameDataThree gameThree;
    private GameDataFour gameFour;
    private Set<String> obj;
    private Set<String> objet;
    private List<String> objList;
    private List<String> objetList;
    private Set<String> object;
    String[][]journal = new String [30][6];

    public FirstController(FirstView view, GameData game) throws IOException, InterruptedException {
        this.view = view;
        this.game = game;
        
        count = 0;
        // Ordonnez à la vue d'executer les boîtes de dialogues

       // name = view.getName();
        //num = view.getNumber();
        name = "Ludovic";
        num = 5;

        main = view.getBackgroundPane().getFirstPanel();
        menu = view.getMenu();
        solve = menu.getSolve();
        solve.addActionListener(this);
        listOfCards = new ArrayList<String>();
        weapons = new ArrayList<String>();
        suspects = new ArrayList<String>();
        places = new ArrayList<String>();
        myNumber = 0;
        // faire attention avec les valeurs.. suspectes...
        it = 0;
        count++;
    }


    public Player getFirstPlayer() {
        return  moi;
    }

    public Player getSecondPlayer() {
        return premier;
    }

    public Player getThirdPlayer() {
        return deuxieme;
    }

    public Player getFourthPlayer() {
        return troisieme;
    }

    public Player getFifthPlayer() {
        return quatrieme;
    }

    public Player getSixthPlayer() {
        return cinquieme;
    }
    public GameDataThree getGameDataThree (){
        return gameThree;
    }
    public GameDataFour getGameDataFour (){
        return gameFour;
    }
    public GameDataFive getGameDataFive (){
        return gameFive;
    }
    public GameDataSix getGameDataSix (){
        return gameSix;
    }
    

    @SuppressWarnings("empty-statement")
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == solve) {

            gameFactory = new ArrayList<GameData>();
             gameThree = null;
             gameFour = null;
            gameFive = null;
             gameSix = null;

            switch (num) {

                case 3:
                    gameThree = new GameDataThree();
                    gameFactory.add(gameThree);
                    break;
                case 4:
                    gameFour = new GameDataFour();
                    gameFactory.add(gameFour);
                    break;
                case 5:
                    gameFive = new GameDataFive();
                    gameFactory.add(gameFive);
                    break;
                case 6:
                    gameSix = new GameDataSix();
                    gameFactory.add(gameSix);
                    break;
            }
            
            game = gameFactory.get(0);
            //e (weapons == null || places == null || suspects == null || listOfCards == null || myName  == null || nbreJoueurs == 0 || myNumber == 0 )  {
            try {
                game.setNbreJoueurs(num);
            } catch (IndexOutOfBoundsException exc) {
                System.out.println(exc.getMessage());
                JTextArea con = back.getConsole();
                con.setText("IndexOutOfBoundsException");
            }

            listOfCards = main.getCardsOfFirstPlayer();
            
            listOfCards.add("Poignard");
            listOfCards.add("Matraque");
            listOfCards.add("Rose");
            listOfCards.add("Moutarde");
            listOfCards.add("Cuisine");
            listOfCards.add("Fontaine");

            weapons = main.getWeaponsOfFirstPlayer();
            weapons.add("Poignard");
            weapons.add("Matraque");
            suspects = main.getSuspectsOfFirstPlayer();
            suspects.add("Rose");
            suspects.add("Moutarde");
            places = main.getPlacesOfFirstPlayer();
            places.add("Cuisine");
            places.add("Fontaine");
            myNumber = main.getMyNbOfCards();
            // On ajoute le joueur principal au tableau des joueurs
            moi = new Player(name, 6);
            game.addJoueurs(moi);

            
            
            
            
            
            
            
            
            
            
            if (!(weapons.isEmpty() || suspects.isEmpty() || places.isEmpty()) && listOfCards.size() == 6) {

               
                
                
                
                
                
                
                
                
                

                int i;
                
                obj = moi.getHasCard();
                objList = moi.getHasCardList();
                String[] arm = game.getArme();
                String[] suz = game.getSuspect();
                String[] pie = game.getPiece();

                // On remplit les tableaux GameData des cartes détenues par le joueur principal
                for (i = 0; i < listOfCards.size(); i++) {
                    obj.add(listOfCards.get(i));
                    objList.add(listOfCards.get(i));
                    String card = listOfCards.get(i);
                    game.addTotal(card);
                    // WARNINGS

                    recorder = game.updateCouple(1, card);
                    
                    for (int p = 0; p < arm.length; p++) {
                        if (game.isArme(card, p)) {
                            game.addArme(card);
                           }
                        }
                    
                    for (int g = 0; g < suz.length; g++) {
                        if (game.isSuspect(card, g)) {
                            game.addSuspect(card);
                        }
                    }
                    for (int v = 0; v < pie.length; v++) {
                        if (game.isPiece(card, v)) {
                            game.addPiece(card);
                        }
                    }
                }

       
                objet = moi.getHasNotCard();
                objetList = moi.getHasNotCardList();

                // this is just a cast below...
                cardsList = new ArrayList<String>(obj);
                // Puis on remplit un autre tableau des cartes qu'il ne détient pas...
                int j;
                int k;
                for (i = 0; i < 30; i++) {
                        if (!cardsList.contains(game.tabCartes[i])) {
                            objet.add(game.tabCartes[i]);
                            objetList.add(game.tabCartes[i]);
                            
                            }                      
                    }
                }
                
              
                
                // le mettre en commentaire après....pour vérifier si on obtient le même résultat
              //  view.setVisible(false);
                switch (num) {
/*
                        case 3:
                     liste = new String[3];
                     liste[0] = name;
                     String primo = view.getPrimo();
                     liste[1] = primo;
                     premier = new OtherPlayer(primo, 6);
                     game.addJoueurs(premier);
                     String secondo = view.getSecondo();
                     liste[2] = secondo;
                     deuxieme = new OtherPlayer(secondo, 6);
                     game.addJoueurs(deuxieme);
                     break;
                     case 4:
                     liste = new String[4];
                     liste[0] = name;
                     primo = view.getPrimo();
                     liste[1] = primo;
                     premier = new OtherPlayer(primo, 6);
                     game.addJoueurs(premier);
                     secondo = view.getSecondo();
                     liste[2] = secondo;
                     deuxieme = new OtherPlayer(secondo, 6);
                     game.addJoueurs(deuxieme);
                     String tertio = view.getTertio();
                     liste[3] = tertio;
                     troisieme = new OtherPlayer(tertio, 6);
                     game.addJoueurs(troisieme);
                     break;
                    */ 
                    case 5:
                        liste = new String[5];
                        liste[0] = name;
                         primo = "Abdel Kadder";
                        liste[1] = primo;
                        premier = new Player(primo, 6);
                        game.addJoueurs(premier);
                         secondo = "Tomaso";
                        liste[2] = secondo;
                        deuxieme = new Player(secondo, 6);
                        game.addJoueurs(deuxieme);
                         tertio = "Mokthar";
                        liste[3] = tertio;
                        troisieme = new Player(tertio, 6);
                        game.addJoueurs(troisieme);
                        String quadro = "Aurélien";
                        liste[4] = quadro;
                        quatrieme = new Player(quadro, 6);
                        game.addJoueurs(quatrieme);
                        break;
                    /*
                     case 6 :
                     liste = new String[6];
                     liste[0] = name;
                     primo = view.getPrimo();
                     liste[1] = primo;
                     premier = new OtherPlayer(primo, 6);
                     game.addJoueurs(premier);
                     secondo = view.getSecondo();
                     liste[2] = secondo;
                     deuxieme = new OtherPlayer(secondo, 6);
                     game.addJoueurs(deuxieme);
                     tertio = view.getTertio();
                     liste[3] = tertio;
                     troisieme = new OtherPlayer(tertio, 6);
                     game.addJoueurs(troisieme);
                     quadro = view.getQuadro();
                     liste[4] = quadro;
                     quatrieme = new OtherPlayer(quadro, 6);
                     game.addJoueurs(quatrieme);
                     String pento = view.getPento();
                     liste[5] = pento;
                     cinquieme = new OtherPlayer(pento, 6);
                     game.addJoueurs(cinquieme);
                        
                     break;
                     */
                    default:
                        primo = view.getPrimo();
                        premier = new OtherPlayer(primo, 6);
                        game.addJoueurs(premier);
                        secondo = view.getSecondo();
                        deuxieme = new OtherPlayer(secondo, 6);
                        game.addJoueurs(deuxieme);
                        tertio = view.getTertio();
                        troisieme = new OtherPlayer(tertio, 6);
                        game.addJoueurs(troisieme);
                        quadro = view.getQuadro();
                        quatrieme = new OtherPlayer(quadro, 6);
                        game.addJoueurs(quatrieme);
                }

        
                 // String start = view.getOrder(liste);
                for (int o = 0; o < num; o++) {
                    noms.add(liste[o]);
                   // if (noms.get(o).equals(start)) {
                     index = o;
                     }
                
                index = 0;

                view.dispose();
                String print = "";
                
                journal [0][0]="N/A";
                journal [0][1]="N/A";
                journal [0][2]="N/A";
                journal [0][3]="N/A";
                journal [0][4]="N/A";
                journal [0][5]="N/A";
            try {

                second =  new SecondView (recorder,noms,index, print, journal, false);
            } catch (    IOException | InterruptedException ex) {
                Logger.getLogger(FirstController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                //game.notifyObserver(second, noms, index, print, journal, false);
            try {
                control = new SecondController(second, gameFactory, journal);
            } catch (    IOException | InterruptedException ex) {
                Logger.getLogger(FirstController.class.getName()).log(Level.SEVERE, null, ex);
            }
            } 

            else {
                JOptionPane.showMessageDialog(main, "Vous n'avez pas coché toutes vos cartes!!!!");
            }
        }
    }


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.GameData;
import data.Player;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JButton;
import javax.swing.JTable;
import view.BackgroundPane;
import view.BottomPanel;
import view.FirstView;
import view.LeftPanel;
import view.SecondView;
import view.LogView;
import view.MenuBar;
import view.MenuBar.Input;
import view.MenuBar.Kill;
import view.MenuBar.Log;
import view.MenuBar.Solve;
import view.SecondPanel;

/**
 *
 * @author Ludovic
 */
class SecondController implements ActionListener {

    private GameData game;
    private BackgroundPane back;
    private FirstController controller;
    private SecondPanel panel;
    private LeftPanel left;
    private FirstView firstView;
    private SecondView currentView, secondView;
    private LogView login;
    private MenuBar top;
    private Solve solve;
    private Input input;
    private Log log;
    private Kill kill;
    private BottomPanel bottom;
    private Container contentPane;
    private ImageInputStream stream;
    private BufferedImage image;
    private int[][] mega = new int[6][3];
    private int[] hypo = new int[3];
    private int[] show = new int[4];
    private int[] sorter = new int[5];
    private String[] hypothese = new String[3];
    private int jago, event, indice, numero, loupeId, increment, sitios, characteros, armatos, num, tour, motor, fourthIndex, askIndex, firstIndex, first, secondIndex, second, thirdIndex, third, myIndex, other, connues, montree, myNb;
    private String myName, name, nom, card, ar, su, li, sitio, armada, suspeto, print, phrase, phraase, message, messsage, messssage, affichage;
    private List<Player> joueurs;
    private List<Integer> recorder, data;
    private List<GameData> gameFactory;
    // Voir chapitre sur la généricité pour savoir comment faire... pour créer un GameDataFive...
    private Player loupMan, me, premier, deuxieme, troisieme, quatrieme, cinquieme;
    private List<SecondView> viewList;
    private List<String> noms, tempNoms, listOne, listTwo, listThree, listFour, listFive, listNotOne, listNotTwo, listNotThree, listNotFour, listNotFive;
    private JTable loggin;
    private String[][] journal;
    private SecondPanel seconde;
    private JButton bouton;

    public SecondController(SecondView secondViews, List<GameData> gameFactory, String[][] tableau) throws IOException, InterruptedException {
        this.secondView = secondViews;
        // On garde les views dans une liste pour pouvoir les....
        viewList = new ArrayList<SecondView>();
        data = new ArrayList<Integer>();
        journal = tableau;

        viewList.add(secondView);
        back = secondView.getBackgroundPane();
        panel = back.getSecondPanel();
        game = gameFactory.get(0);

        joueurs = game.getJoueurs();
        me = joueurs.get(0);
        premier = joueurs.get(1);
        deuxieme = joueurs.get(2);
        troisieme = joueurs.get(3);
        quatrieme = joueurs.get(4);

        listOne = me.getHasCardList();
        listNotOne = me.getHasNotCardList();

        listTwo = premier.getHasCardList();
        listNotTwo = premier.getHasNotCardList();

        listThree = deuxieme.getHasCardList();
        listNotThree = deuxieme.getHasNotCardList();

        listFour = troisieme.getHasCardList();
        listNotFour = troisieme.getHasNotCardList();

        listFive = quatrieme.getHasCardList();
        listNotFive = quatrieme.getHasNotCardList();

        for (int u = 0; u < listOne.size(); u++) {
            String carte = listOne.get(u);
            listNotTwo.add(carte);
            listNotThree.add(carte);
            listNotFour.add(carte);
            listNotFive.add(carte);
        }

        askIndex = secondView.getIndex();
        noms = secondView.getNoms();
        System.out.println("la valeur de nom est moncul : " + secondView + "\n");
        System.out.println("la valeur de nom est moncul : " + noms + "\n");

        top = secondView.getBar();
        solve = top.getSolve();
        input = top.getInput();
        log = top.getLog();
        kill = top.getKill();

        solve.addActionListener(this);
        input.addActionListener(this);
        log.addActionListener(this);
        kill.addActionListener(this);

        tour = 0;
        motor = 0;
    }
// On veut les joueurs dans l'ordre pour le tour en cours...

    // Ajouter un boutton  tête de mort ou pistoler ancien pour flinguer un joueur éliminé de la partie.
    // Ajouter un boutton pour revenir un tour en arrière.... (penser à une icône pour ce boutton)
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == solve) {

            sorter = this.sortIndex(askIndex);
            // On ne connaît pas les valeurs de chaque index mais il faut faire comme...
            if (askIndex != myIndex) {
                hypo = panel.getHypothesis();
                armatos = hypo[0] - 1;
                characteros = hypo[1] - 1;
                sitios = hypo[2] - 1;
                ar = game.arm[armatos];
                su = game.suz[characteros];
                li = game.pie[sitios];

                nom = panel.getNom();
                jago = this.getJago();// jago ne me sort que la position de la personne ayant montré sa carte sans me dire si c'est un F,S ou T

                show = this.getShow(jago);
                montree = show[0];
                first = show[1];
                second = show[2];
                third = show[3];

                connues = 0;
                connues = this.getMy();

                if (jago == 5 || montree == 1) {
                    other = 0;
                } else {
                    other = 1;
                }
                journal[tour][0] = String.valueOf(tour);
                journal[tour][1] = joueurs.get(askIndex).getName();
                journal[tour][2] = joueurs.get(jago).getName();
                journal[tour][3] = ar;
                journal[tour][4] = su;
                journal[tour][5] = li;

                System.out.println("BIENVENUE DANS LE TOUR NUMERO : " + motor + "\n");

                data.add(motor);
                data.add(armatos);
                data.add(characteros);
                data.add(sitios);
                data.add(other);
                data.add(connues);
                data.add(montree);
                data.add(myIndex);
                data.add(askIndex);
                data.add(firstIndex);
                data.add(first);
                data.add(secondIndex);
                data.add(second);
                data.add(thirdIndex);
                data.add(third);
                data.add(noms.size());

                System.out.println("la valeur de nom est data : " + noms + "\n");

                int d = 0;
                int i = 0;

                while (i < motor) {

                    System.out.println("BIENVENUE DANS La Boucle NUMERO : " + i + "\n");

                    armada = game.arm[data.get(1 + d)];
                    suspeto = game.suz[data.get(2 + d)];
                    sitio = game.pie[data.get(3 + d)];

                    mega = game.treatData(data.get(0 + d), armada, suspeto, sitio, data.get(4 + d), data.get(5 + d), data.get(6 + d), data.get(7 + d), data.get(8 + d), data.get(9 + d), data.get(10 + d), data.get(11 + d), data.get(12 + d), data.get(13 + d), data.get(14 + d), data.get(15 + d));

                    for (int[] el : mega) {
                        System.out.println("\n!!!!!!!!!!!!TOUR SUIVANT LOOP!!!!!!!!!!!!!!!!!!!!!\n");
                        for (int element : el) {
                            System.out.println(element);
                        }
                    }
                    // On met à jour le tableaux des "NOT" pour les joueurs n'ayant pas montré leur cartes...
                    game.takingCareOfBusiness(10 + d, 12 + d, 14 + d);
                    game.initialize(mega[5][0]);
                    game.armaChecker();
                    game.persoChecker();
                    game.siteChecker();

                    i++;
                    d += 16;
                }

                System.out.println("\n -------------------------------------------\n");

                /* Apparemment je dois relancer treatData une seconde fois après avoir mis à jour le tableaux des "NOT" */
                mega = game.treatData(motor, ar, su, li, other, connues, montree, myIndex, askIndex, firstIndex, first, secondIndex, second, thirdIndex, third, noms.size());

                for (int[] el : mega) {
                    System.out.println("\n!!!!!!!!!!!!TOUR SUIVANT REGULAR!!!!!!!!!!!!!!!!!!!!!\n");
                    for (int element : el) {
                        System.out.println(element);
                    }
                }

                game.takingCareOfBusiness(first, second, third);

                affichage = game.initialize(mega[5][0]);

                message = game.armaChecker();
                messsage = game.persoChecker();
                messssage = game.siteChecker();

                print = affichage + " " + message + " " + messsage + " " + messssage;

                if (askIndex == 0 || askIndex == 1 || askIndex == 2 || askIndex == 3) {
                    askIndex++;
                } else if (askIndex == 4) {
                    askIndex = 0;
                }
                recorder = game.getRecorder();
                try {
                    currentView = new SecondView(recorder, noms, askIndex, print, journal, false);
                } catch (IOException | InterruptedException ex) {
                    Logger.getLogger(SecondController.class.getName()).log(Level.SEVERE, null, ex);
                }
                viewList.add(currentView);
                viewList.get(tour).dispose();
                viewList.get(tour).setVisible(false);

                motor++;
                tour++;

            } else {

                hypo = panel.getHypothesis();
                armatos = hypo[0] - 1;
                characteros = hypo[1] - 1;
                sitios = hypo[2] - 1;
                ar = game.arm[armatos];
                su = game.suz[characteros];
                li = game.pie[sitios];
                indice = panel.getIndice();
                switch (indice) {
                    case 1:
                        card = ar;
                        break;
                    case 2:
                        card = su;
                        break;
                    case 3:
                        card = li;
                        break;
                }

                nom = panel.getNom();
                sorter = sortIndex(0);

                journal[tour][0] = String.valueOf(tour);
                journal[tour][1] = joueurs.get(askIndex).getName();
                journal[tour][2] = nom;
                journal[tour][3] = ar;
                journal[tour][4] = su;
                journal[tour][5] = li;
                // 15000000000 fonctions emboîtées dans cette fonction !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

                System.out.println("la valeur de nom est sauce : " + noms + "/n");

                this.atomicSauceAnanas(indice);

                phrase = game.getSuspicious(ar, su, li);
                phraase = game.addSolution(ar, su, li);

                message = game.armaChecker();
                messsage = game.persoChecker();
                messssage = game.siteChecker();

                print = phrase + " " + phraase + "\n" + message + " " + messsage + " " + messssage;

                System.out.println("TOUR DEMANDEUR = LUDOVIC!!!!!!!!!!!!!!!!!!!!! \n");
                System.out.println("Liste de mes cartes \n");
                for (String v : listOne) {
                    System.out.println(v);
                }
                System.out.println("\n");
                for (String v : listNotOne) {
                    System.out.println(v);
                }
                System.out.println("Liste des cartes d'ABDEL KADER \n");
                for (String v : listTwo) {
                    System.out.println(v);
                }
                System.out.println("\n");
                for (String v : listNotTwo) {
                    System.out.println(v);
                }
                System.out.println("Liste des cartes de TOMASO \n");
                for (String v : listThree) {
                    System.out.println(v);
                }
                System.out.println("\n");
                for (String v : listNotThree) {
                    System.out.println(v);
                }
                System.out.println("Liste des cartes de MOKTHAR \n");
                for (String v : listFour) {
                    System.out.println(v);
                }
                System.out.println("\n");
                for (String v : listNotFour) {
                    System.out.println(v);
                }
                System.out.println("Liste des cartes d'AURELIEN \n");
                for (String v : listFive) {
                    System.out.println(v);
                }
                System.out.println("\n");
                for (String v : listNotFive) {
                    System.out.println(v);
                }

                if (askIndex == 0 || askIndex == 1 || askIndex == 2 || askIndex == 3) {
                    askIndex++;
                } else if (askIndex == 4) {
                    askIndex = 0;
                }
                recorder = game.getRecorder();
                try {
                    currentView = new SecondView(recorder, noms, askIndex, print, journal, false);
                } catch (IOException | InterruptedException ex) {
                    Logger.getLogger(SecondController.class.getName()).log(Level.SEVERE, null, ex);
                }

                viewList.add(currentView);
                viewList.get(tour).dispose();
                viewList.get(tour).setVisible(false);

                tour++;
            }

            ///////////////////////////////////////  INPUT  /////////////////////////////////             
        } else if (e.getSource() == input) {

            SecondView aView = viewList.get(tour);
            String choice = aView.getCard(); // showInputDialog function called 
            String playeur = aView.getPlayer(noms.size()); // ShowInputDialog function called 
            int j;
            for (j = 1; j < noms.size(); j++) {
                if (joueurs.get(j).getName().equals(playeur)) {
                    loupeId = j;
                    System.out.println(j);
                }
            }

            for (int i = 0; i < game.tabCartes.length; i++) {
                if (choice.equals(game.tabCartes[i])) {
                    choice = game.tabCartes[i];
                    if (i >= 0 && i < 8) {
                        loupMan = game.getJoueurs().get(loupeId);
                        loupMan.addToWeapon(choice);
                        game.updateCouple(1, choice);
                        game.addTotal(choice);
                        game.addArme(choice);
                    }
                    if (i >= 8 && i < 18) {
                        System.out.println("Oui je suis entré dans suspect");
                        loupMan = game.getJoueurs().get(loupeId);
                        loupMan.addToSuspect(choice);
                        game.updateCouple(1, choice);
                        game.addTotal(choice);
                        game.addSuspect(choice);
                    }
                    if (i >= 18 && i < 30) {
                        loupMan = game.getJoueurs().get(loupeId);
                        loupMan.addToPlace(choice);
                        game.updateCouple(1, choice);
                        game.addTotal(choice);
                        game.addPiece(choice);
                    }
                }
            }
            System.out.println("valeur de loupMan " + loupMan.getName());
            System.out.println("valeur de loupeID : " + loupeId);
            for (int m = 1; m < noms.size(); m++) {
                if (m != loupeId && loupMan.hasWeapon(choice)) {
                    Player etc = game.getJoueurs().get(m);
                    etc.addToNotWeapon(choice);
                } else if (m != loupeId && loupMan.hasSuspect(choice)) {
                    Player etc = game.getJoueurs().get(m);
                    etc.addToNotSuspect(choice);
                } else if (m != loupeId && loupMan.hasPlace(choice)) {
                    Player etc = game.getJoueurs().get(m);
                    etc.addToNotPlace(choice);
                }
            }

            print = "La carte " + choice + " vient d'être ajoutée.";

            increment = aView.getChoice(); // ConfirmedDialogBox
            if (increment == 1) {
                if (askIndex == 0 || askIndex == 1 || askIndex == 2 || askIndex == 3) {
                    askIndex++;
                } else if (askIndex == 4) {
                    askIndex = 0;
                }

                recorder = game.getRecorder();

                try {
                    currentView = new SecondView(recorder, noms, askIndex, print, journal, false);
                } catch (IOException | InterruptedException ex) {
                    Logger.getLogger(SecondController.class.getName()).log(Level.SEVERE, null, ex);
                }

                viewList.add(currentView);
                viewList.get(tour).dispose();
                viewList.get(tour).setVisible(false);

                tour++;
            } else {

                recorder = game.getRecorder();
                try {
                    currentView = new SecondView(recorder, noms, askIndex, print, journal, false);
                } catch (IOException | InterruptedException ex) {
                    Logger.getLogger(SecondController.class.getName()).log(Level.SEVERE, null, ex);
                }
                viewList.add(currentView);
                viewList.get(tour).dispose();
                viewList.get(tour).setVisible(false);
            }
        } ////////////////////////////////////////////// LOG //////////////////////////////////////
        // 1. Faire apparaître le frame du JScrollPane (seul la Jtable apparaît)
        // 2. Faire apparaître la première ligne des titres de la JTable
        // 3. Faire en sorte que les valeurs renvoyées par le Journal[][].. surtout les hypothèses;
        // soient exactes d'un tour à l'autre.
        else if (e.getSource() == log) {

            recorder = game.getRecorder();
            try {
                currentView = new SecondView(recorder, noms, askIndex, print, journal, false);
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(SecondController.class.getName()).log(Level.SEVERE, null, ex);
            }
            viewList.add(currentView);
            viewList.get(tour).dispose();
            viewList.get(tour).setVisible(false);

            // while (!log.isSelected()){}
        } //////////////////////////////////////////////// KILL  ////////////////////////////////////////
        else if (e.getSource() == kill) {
            // Ajouter un boutton  tête de mort ou pistoler ancien pour flinguer un joueur éliminé de la partie.
            // Ajouter un boutton pour revenir un tour en arrière.... (penser à une icône pour ce boutton)  

            SecondView aView = viewList.get(tour);
            tempNoms = new ArrayList<String>(noms);
            
            String[] playerList = aView.convertPlayers(tempNoms);

            System.out.println("C'est fini !!!");

            String killed = aView.killPlayer(playerList);
            
            aView.gotRemoved(killed);
            
            tempNoms.remove(killed);
            noms.remove(killed);
            // faut il obligatoirement supprimer le joueur de la liste des joueurs..
            // On n'accèdera plus aux fonctions du joueurs éliminés (carte détenues, non détenues etc..)
            // si on le retire de la liste..)
            //  for (Player names : joueurs) {
            //      if (names.getName().equals(killed)) {
            //          joueurs.remove(names);
            //      }
            //  }

            for (String names : playerList) {
                System.out.println("Name : " + names);
            }

            for (String name : tempNoms) {
                System.out.println("noms : " + name);
            }

            for (String name : noms) {
                System.out.println("noms again : " + name);
            }

            recorder = game.getRecorder();

            try {
                currentView = new SecondView(recorder, noms, askIndex, print, journal, false);
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(SecondController.class.getName()).log(Level.SEVERE, null, ex);
            }
            viewList.add(currentView);
            viewList.get(tour).dispose();
            viewList.get(tour).setVisible(false);
        }

        if (tour > 0) {
            currentView = viewList.get(tour);

            //back = currentView.getBackgroundPane();
            //panel = back.getSecondPanel();
            top = currentView.getBar();
            solve = top.getSolve();
            input = top.getInput();
            log = top.getLog();
            kill = top.getKill();

            solve.addActionListener(this);
            input.addActionListener(this);
            log.addActionListener(this);
            kill.addActionListener(this);

        }
    }

    public int getJago() {
        int i;
        int index;
        jago = 5;
        for (i = 0; i < noms.size(); i++) {
            if (noms.get(i).equals(nom)) {
                index = i;
                for (int g = 0; g < sorter.length; g++) {
                    if (sorter[g] == index) {
                        jago = g;
                    }
                }
            }
        }
        return jago;
    }

    public int[] sortIndex(Integer askIndex) {

        firstIndex = 0;
        secondIndex = 0;
        thirdIndex = 0;
        fourthIndex = 0;
        myIndex = 0;

// Le premier cas ne nous intéresse pas pour notre segment treatData()...
        if (askIndex == 0) {
            myIndex = 0;
            firstIndex = 1;
            secondIndex = 2;
            thirdIndex = 3;
            fourthIndex = 4;
            sorter[0] = askIndex;
            sorter[1] = firstIndex;
            sorter[2] = secondIndex;
            sorter[3] = thirdIndex;
            sorter[4] = fourthIndex;
        } // Il faut systématiquement se référer à la position de myIndex dans sorter.. ici sorter.get(4)
        else if (askIndex == 1) {
            firstIndex = 2;
            secondIndex = 3;
            thirdIndex = 4;
            myIndex = 0;
            sorter[0] = askIndex;
            sorter[1] = firstIndex;
            sorter[2] = secondIndex;
            sorter[3] = thirdIndex;
            sorter[4] = myIndex;

        } // Il faut systématiquement se référer à la position de myIndex dans sorter.. ici sorter.get(3)
        else if (askIndex == 2) {
            firstIndex = 3;
            secondIndex = 4;
            myIndex = 0;
            thirdIndex = 1;
            sorter[0] = askIndex;
            sorter[1] = firstIndex;
            sorter[2] = secondIndex;
            sorter[3] = myIndex;
            sorter[4] = thirdIndex;
        } // Il faut systématiquement se référer à la position de myIndex dans sorter.. ici sorter.get(2)
        else if (askIndex == 3) {
            firstIndex = 4;
            myIndex = 0;
            secondIndex = 1;
            thirdIndex = 2;
            sorter[0] = askIndex;
            sorter[1] = firstIndex;
            sorter[2] = myIndex;
            sorter[3] = secondIndex;
            sorter[4] = thirdIndex;
        } // Il faut systématiquement se référer à la position de myIndex dans sorter.. ici sorter.get(1)
        else if (askIndex == 4) {
            myIndex = 0;
            firstIndex = 1;
            secondIndex = 2;
            thirdIndex = 3;
            sorter[0] = askIndex;
            sorter[1] = myIndex;
            sorter[2] = firstIndex;
            sorter[3] = secondIndex;
            sorter[4] = thirdIndex;
        }
        return sorter;
    }

    public int[] getShow(int jago) {
        if (jago == 5) {
            montree = 0;
            first = 0;
            second = 0;
            third = 0;
        } else if (jago == 1 && sorter[jago] == 0) {
            montree = 1;
            first = 2;
            second = 2;
            third = 2;

        } else if (jago == 1 && ((sorter[jago] == 2) || (sorter[jago] == 3) || (sorter[jago] == 4))) {
            montree = 2;
            first = 1;
            second = 2;
            third = 2;
        } else if (jago == 4 && sorter[jago] == 0) {
            montree = 1;
            first = 0;
            second = 0;
            third = 0;
        } else if (jago == 4 && ((sorter[jago] == 1) || (sorter[jago] == 2) || (sorter[jago] == 3))) {
            montree = 0;
            first = 0;
            second = 0;
            third = 1;
        } else if (jago == 3 && sorter[jago] == 4) {
            montree = 2;
            first = 0;
            second = 0;
            third = 1;
        } else if (jago == 3 && sorter[jago] == 0) {
            montree = 1;
            first = 0;
            second = 0;
            third = 2;

        } // A tester rapidement
        else if (jago == 3 && (sorter[jago] == 1 || sorter[jago] == 2)) {
            montree = 0;
            first = 0;
            second = 1;
            third = 2;
        } else if (jago == 2 && (sorter[jago] == 3 || sorter[jago] == 4)) {
            montree = 2;
            first = 0;
            second = 1;
            third = 2;
        }
        if (jago == 2 && sorter[jago] == 0) {
            montree = 1;
            first = 0;
            second = 2;
            third = 2;
        } else if (jago == 2 && sorter[jago] == 1) {
            montree = 0;
            first = 1;
            second = 2;
            third = 2;
        }
        show[0] = montree;
        show[1] = first;
        show[2] = second;
        show[3] = third;
        return show;
    }

    public int getMy() {
        connues = 0;

        if (me.getHasCard().contains(ar)) {
            connues++;
        }
        if (me.getHasCard().contains(su)) {
            connues++;
        }
        if (me.getHasCard().contains(li)) {
            connues++;
        }

        return connues;
    }

    public void mesatsu() {
        premier.addToNotWeapon(ar);
        premier.addToNotSuspect(su);
        premier.addToNotPlace(li);
        deuxieme.addToNotWeapon(ar);
        deuxieme.addToNotSuspect(su);
        deuxieme.addToNotPlace(li);
        troisieme.addToNotWeapon(ar);
        troisieme.addToNotSuspect(su);
        troisieme.addToNotPlace(li);
        quatrieme.addToNotWeapon(ar);
        quatrieme.addToNotSuspect(su);
        quatrieme.addToNotPlace(li);
    }

    public void ifOne(String any) {

        if (any.equals(li)) {
            deuxieme.addToNotPlace(li);
            troisieme.addToNotPlace(li);
            quatrieme.addToNotPlace(li);
        } 
        else if (any.equals(ar)) {
            deuxieme.addToNotWeapon(ar);
            troisieme.addToNotWeapon(ar);
            quatrieme.addToNotWeapon(ar);
        } 
        else if (any.equals(su)) {
            deuxieme.addToNotSuspect(su);
            troisieme.addToNotSuspect(su);
            quatrieme.addToNotSuspect(su);
        }
    }

    public void ifTwo(String any) {

        Player un = game.getJoueurs().get(1);
        Player trois = game.getJoueurs().get(3);
        Player quatre = game.getJoueurs().get(4);
        if (any.equals(li)) {
            premier.addToNotSuspect(su);
            premier.addToNotWeapon(ar);
            premier.addToNotPlace(li);

            troisieme.addToNotPlace(li);

            quatrieme.addToNotPlace(li);
        } 
        else if (any.equals(ar)) {
            premier.addToNotSuspect(su);
            premier.addToNotWeapon(ar);
            premier.addToNotPlace(li);

            troisieme.addToNotWeapon(ar);

            quatrieme.addToNotWeapon(ar);
        } 
        else if (any.equals(su)) {
            premier.addToNotSuspect(su);
            premier.addToNotWeapon(ar);
            premier.addToNotPlace(li);

            troisieme.addToNotSuspect(su);

            quatrieme.addToNotSuspect(su);
        }
    }

    public void ifThree(String any) {

        if (any.equals(li)) {
            premier.addToNotSuspect(su);
            premier.addToNotWeapon(ar);
            premier.addToNotPlace(li);

            deuxieme.addToNotSuspect(su);
            deuxieme.addToNotWeapon(ar);
            deuxieme.addToNotPlace(li);

            quatrieme.addToNotPlace(li);
        } 
        else if (any.equals(ar)) {
            premier.addToNotSuspect(su);
            premier.addToNotWeapon(ar);
            premier.addToNotPlace(li);

            deuxieme.addToNotSuspect(su);
            deuxieme.addToNotWeapon(ar);
            deuxieme.addToNotPlace(li);

            quatrieme.addToNotWeapon(ar);
        } 
        else if (any.equals(su)) {
            premier.addToNotSuspect(su);
            premier.addToNotWeapon(ar);
            premier.addToNotPlace(li);

            deuxieme.addToNotSuspect(su);
            deuxieme.addToNotWeapon(ar);
            deuxieme.addToNotPlace(li);

            quatrieme.addToNotSuspect(su);
        }
    }

    public void ifFour() {

        premier.addToNotSuspect(su);
        premier.addToNotWeapon(ar);
        premier.addToNotPlace(li);
        deuxieme.addToNotSuspect(su);
        deuxieme.addToNotWeapon(ar);
        deuxieme.addToNotPlace(li);
        troisieme.addToNotSuspect(su);
        troisieme.addToNotWeapon(ar);
        troisieme.addToNotPlace(li);
    }

    public void atomicSauceAnanas(int indice) {
        noms.add("imaginaire numéro 5");
        for (int i = 1; i < noms.size(); i++) {
            if (indice == 1 && noms.get(i).equals(nom)) {
                game.addArme(ar);
                game.addTotal(ar);
                game.updateCouple(1, ar);

                if (i == 1) {
                    premier.addToWeapon(ar);
                    premier.addCardsKnown();
                    this.ifOne(ar);
                } 
                else if (i == 2) {
                    deuxieme.addToWeapon(ar);
                    deuxieme.addCardsKnown();
                    this.ifTwo(ar);
                } 
                else if (i == 3) {
                    this.ifThree(ar);
                    troisieme.addToWeapon(ar);
                    troisieme.addCardsKnown();
                } 
                else if (i == 4) {
                    quatrieme.addToWeapon(ar);
                    quatrieme.addCardsKnown();
                    this.ifFour();
                }
            } 
            else if (indice == 2 && noms.get(i).equals(nom)) {
                game.addSuspect(su);
                game.addTotal(su);
                game.updateCouple(1, su);

                if (i == 1) {

                    this.ifOne(su);
                    premier.addToSuspect(su);
                    premier.addCardsKnown();
                } 
                else if (i == 2) {
                    this.ifTwo(su);
                    deuxieme.addToSuspect(su);
                    deuxieme.addCardsKnown();
                } 
                else if (i == 3) {
                    this.ifThree(su);
                    troisieme.addToSuspect(su);
                    troisieme.addCardsKnown();
                } 
                else if (i == 4) {
                    this.ifFour();
                    quatrieme.addToSuspect(su);
                    quatrieme.addCardsKnown();
                }
            } 
            else if (indice == 3 && noms.get(i).equals(nom)) {
                game.addPiece(li);
                game.addTotal(li);
                game.updateCouple(1, li);

                if (i == 1) {
                    this.ifOne(li);
                    premier.addToPlace(li);
                    premier.addCardsKnown();
                } 
                else if (i == 2) {
                    this.ifTwo(li);
                    deuxieme.addToPlace(li);
                    deuxieme.addCardsKnown();
                } 
                else if (i == 3) {
                    this.ifThree(li);
                    troisieme.addToPlace(li);
                    troisieme.addCardsKnown();
                } 
                else if (i == 4) {
                    this.ifFour();
                    quatrieme.addToPlace(li);
                    quatrieme.addCardsKnown();
                }
            } 
            else if (i == 5 && indice == 0) {
                this.mesatsu();
            }
        }
        noms.remove(5);
    }

}

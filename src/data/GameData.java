/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.HashSet;
import data.Player;
import java.util.List;
/**
 *
 * @author Ludovic
 */

public class GameData {

    int nbreJoueurs;
    GameData game;
    // besoin de créér un objet shitty pour le passer aux classes filles
    public final String[] listeCartes = {"Le Poignard", "Le Revolver", "La Matraque", "Le Chandelier", "La Corde", "La Clef Anglaise", "Le Poison", "Le Fer à Cheval", "Mademoiselle Rose", "Le colonel Moutarde", "Madame Leblanc", "Le Docteur Olive", "Madame Pervenche", "Le Professeur Violet", "Mademoiselle Pêche", "Monsieur Prunelle", "Le Sergent Legris", "Madame Chose", "La Cuisine", "La Salle à manger", "Le Billard", "Le Petit Salon", "Le Grand Salon", "La Veranda", "La Fontaine", "Le Jardin", "La Grange", "Le Bureau", "La Bibliothèque", "Le Kiosque"};
    public final String[] tabCartes = {"Poignard", "Revolver", "Matraque", "Chandelier", "Corde", "Clef Anglaise", "Poison", "Fer à Cheval", "Rose", "Moutarde", "Leblanc", "Olive", "Pervenche", "Violet", "Pêche", "Prunelle", "Legris", "Chose", "Cuisine", "Salle à manger", "Le Billard", "Petit Salon", "Grand Salon", "Veranda", "Fontaine", "Jardin", "Grange", "Bureau", "Bibliothèque", "Kiosque"};
    public ArrayList computation = new ArrayList();
    public final String[] arm = {"Poignard", "Revolver", "Matraque", "Chandelier", "Corde", "Clef Anglaise", "Poison", "Fer à Cheval"};
    public final String[] suz = {"Rose", "Moutarde", "Leblanc", "Olive", "Pervenche", "Violet", "Pêche", "Prunelle", "Legris", "Chose"};
    public final String[] pie = {"Cuisine", "Salle à manger", "Billard", "Petit Salon", "Grand Salon", "Veranda", "Fontaine", "Jardin", "Grange", "Bureau", "Bibliothèque", "Kiosque"};

    protected ArrayList<Player> joueurs = new ArrayList<Player>();
    protected ArrayList<String> noms = new ArrayList<String>();
    /*ArrayList comprenant la liste de la solution*/

    // C'est une liste de Cartes alors que dans GAMEDATA c'est une liste de String
    protected HashSet<String> solution = new HashSet<String>();
    protected String[] solutioner = {"Z","Z","Z"};

    /*ArrayList comprenant la liste des armes, suspect et lieux*/
    protected HashSet<String> suspectListe = new HashSet<String>();
    protected HashSet<String> armeListe = new HashSet<String>();
    protected HashSet<String> pieceListe = new HashSet<String>();

    /*ArrayList comprenant la liste de toutes les cartes découvertes */
    protected HashSet<String> totalRecall = new HashSet<String>();
    protected List<String> totalRecaller = new ArrayList<String>();

    protected int[][] tab;
    protected String[] hypothesis = new String [3];
    protected String sentence;
    protected int[] listKiller = new int[6];
    protected int[] trio = new int[3];
    protected String ar, su, li;
    // A voir comment on va l'utiliser dans le controller...
    protected int motor;
    protected int no, connues, other, montree, myIndex, askIndex, firstIndex, first, secondIndex, second, thirdIndex, third;
    protected int totalKnown, totalShown, ask;
    protected int jago, tatsu, tatsuma, tatsuHadoken, tatsumaHadoken;
    protected int limit = 6;
    protected String [][]log;
    protected boolean go;
    protected List<Integer> recorder = new ArrayList<Integer>();
    protected Integer status;
    protected Integer cardIndex;

    public GameData() {
    }


    public void setNbreJoueurs(int nbreJoueurs) {
        this.nbreJoueurs = nbreJoueurs;
    }
    public int getNbreJoueurs(){
        return nbreJoueurs;
    }

    
    
    public List<Integer> updateCouple(Integer status, String cards) {
        int i;
        for (i = 0; i < tabCartes.length; i++) {
            if (cards.equals(tabCartes[i]) && i < 8) {
                cardIndex = i;               
            } else if (cards.equals(tabCartes[i]) && i > 7 && i < 18) {
                i += 1;
                cardIndex = i;             
            } else if (cards.equals(tabCartes[i]) && i > 17) {
                i += 2;
                cardIndex = i;              
            }           
        }
        recorder.add(status);
        recorder.add(cardIndex);
        return recorder;
    }

    
    
    
    public int[][] treatData(int motor, String ar, String su, String li,int other, int connues, int montree, int myIndex, int askIndex, int firstIndex, int first, int secondIndex, int second, int thirdIndex, int third, int nbreJoueurs) {
        
        this.motor = motor;
        this.ar = ar;
        this.su = su;
        this.li = li;
        this.other = other;
        this.connues = connues;
        this.montree = montree;
        this.myIndex = myIndex;
        this.askIndex = askIndex;
        this.firstIndex = firstIndex;
        this.first = first;
        this.secondIndex = secondIndex;
        this.second = second;
        this.thirdIndex = thirdIndex;
        this.third = third;
        this.nbreJoueurs = nbreJoueurs;
        
        tab = new int[6][3];
        int[] myTab = new int[3];
        int[] askTab = new int[3];
        int[] firsTab = new int[3];
        int[] secondTab = new int[3];
        int[] thirdTab = new int[3];
        int[] special = new int[3];
        String[] hypothesis = new String[3];
        // L'indice "0" de askTab[0] ou firstTab[0] nous donne le nombre de cartes[ar,su,li] possédé par le joueur
        // L'indice "1" correspond toujours à la place de l'indice. Par ex : l'indice de myTab[1] est toujours "0"
        // L'indice "2" nous indique le nombre de cartes montrée par le joueurs (uniquement égale à 0 ou 1)...
        myTab[0] = connues;
        myTab[1] = 0;
        myTab[2] = montree;
        
        askTab[1] = askIndex;
        askTab[2] = 0;
        firsTab[1] = firstIndex;
        firsTab[2] = first;
        secondTab[1] = secondIndex;
        secondTab[2] = second;
        thirdTab[1] = thirdIndex;
        thirdTab[2] = third;
        
        hypothesis[0] = ar;
        hypothesis[1] = su;
        hypothesis[2] = li;
        // J'ai pas trouvé mieux à faire ....
        // first, second, third
        
       
        
        int i;
        for (i = 1; i < joueurs.size(); i++) {
            if (joueurs.get(i).hasNoCard(ar, su, li)) {
                if (i == askIndex) {
                    askTab[0] = 0;
                }  if (i == firstIndex) {
                    firsTab[0] = 0;
                }  if (i == secondIndex) {
                    secondTab[0] = 0;
                }  if (i == thirdIndex) {
                    thirdTab[0] = 0;
                }
            } else if (joueurs.get(i).hasOneCard(ar, su, li)) {
               if (i == askIndex) {
                    askTab[0] = 1;
                }  if (i == firstIndex) {
                    firsTab[0] = 1;
                }  if (i == secondIndex) {
                    secondTab[0] = 1;
                }  if (i == thirdIndex) {
                    thirdTab[0] = 1;
                }
            } else if (joueurs.get(i).hasTwoCards(ar, su, li)) {
                
               
                if (i == askIndex) {
                    askTab[0] = 2;
                } else if (i == firstIndex) {
                    firsTab[0] = 2;
                } else if (i == secondIndex) {
                    secondTab[0] = 2;
                } else if (i == thirdIndex) {
                    thirdTab[0] = 2;
                }
            } else if (joueurs.get(i).hasAllCards(ar, su, li)) {
                if (i == askIndex) {
                    askTab[0] = 3;
                } else if (i == firstIndex) {
                    firsTab[0] = 3;
                } else if (i == secondIndex) {
                    secondTab[0] = 3;
                } else if (i == thirdIndex) {
                    thirdTab[0] = 3;
                }
            }
        }
        
       
// tab contient toutes les informations nécessaires au traitement des données !!!
        
        
        int j;
        for (j = 0; j < 3; j++) {
            tab[0][j] = myTab[j];
            tab[1][j] = askTab[j];
            tab[2][j] = firsTab[j];
            tab[3][j] = secondTab[j];
            tab[4][j] = thirdTab[j];
            
        }
        int k;
        totalKnown = 0;
        // val est le nombre de cartes que l'on connait ?
        // val est le nombre de cartes montrées ?
        for (k = 0; k < nbreJoueurs; k++) {
            totalKnown+=tab[k][0];
        }
        ask = askTab[0]; 
        
        tab[5][0] = totalKnown;
        tab[5][1] = ask;
        tab[5][2] = 0;
        
        
        listKiller = this.getListKiller(tab);
        
        return tab;
    }
    
    
    
    
    
    
    public String initialize(int totalKnown) {
        String retour = null;
        if (totalKnown == 0) {
            retour = this.launchNone();
        } 
        else if (totalKnown == 1) {
            retour = this.launchSingle();
        } 
        else if (totalKnown == 2) {
            retour = this.launchDouble();
        }
        return retour;
    }

    
    
    protected String launchNone() {
        return null;

    }

    protected String launchSingle() {
        return null;

    }

    protected String launchDouble() {
        return null;

    }
    
    
    
    
    
    
    
    // fonction qui nous donne un tableau contenant Jago (premier joueur a montré une carte sans qu'on la connaisse)
    // spinal (second.....) et fulgore
    // ainsi que Spinal, Fulgore, et tatsumaki respectivement des joueurs qui ont montré leurs cartes et dont on connaît les cartes

    // !!!!!!! EST CE QU'IL FAUT DONNER UN NOM AU JOUEURS QUI POSSEDENT DES CARTES HYPOTHESE MAIS QUI NE LES A PAS MONTRER

    // permet d'indentifier le joueur auquel l'on va associer le nombre de cartes dont on le sait posséder.
    
    
    
    
    
    
    
    
    
    
    
    
// Dans le controller on est capable d'identifier immédiatement qui est Jago... c'est celui qui montre sa carte... DUH...
        
// Permet de définir les indices de Jago, Spinal, Fulgore et hadoken
    
    
    
    
    
    
    public int[] getListKiller(int[][] tab) {

        jago = 5;
        tatsu = 5;
        tatsuma = 5;
        tatsuHadoken = 5;
        tatsumaHadoken = 5;

        // On définit l"indice pour Jago
        if (tab[2][0] == 0 && tab[2][2] == 1) {
            jago = firstIndex;
        } 
        else if (tab[3][0] == 0 && tab[3][2] == 1) {
            jago = secondIndex;
        } 
        else if (tab[4][0] == 0 && tab[4][2] == 1) {
            jago = thirdIndex;
        }

        // On définit l'indice pour Spinal (premier joueur à ne pas montrer et dont on connaît une carte hypothèses)
        if (tab[3][0] == 1 && tab[3][2] == 0 && jago < 5) {
            tatsu = secondIndex;
        } 
        else if (tab[4][0] == 1 && tab[4][2] == 0 && jago < 5) {
            tatsuma = thirdIndex;
        }

        // On définit l'indice pour Fulgore (second joueur à ne pas montrer et dont on connaît une carte hypothèses)
        if (tab[4][0] == 1 && tab[4][2] == 0 && tatsu == secondIndex && jago < firstIndex) {
            tatsuma = thirdIndex;
        }

        // On définit l'indice pour hadoken (premier joueur à ne pas montrer et dont on connaît deux cartes hypothèses)
        if (tab[3][0] == 2 && tab[3][2] == 0 && jago < 5 && tatsu == 5 && tatsuma == 5) {
            tatsuHadoken = secondIndex;
        } 
        else if (tab[4][0] == 2 && tab[4][2] == 0 && jago < 5 && tatsu == 5 && tatsuma == 5) {
            tatsumaHadoken = thirdIndex;
        }

        listKiller[0] = jago;
        listKiller[1] = tatsu;
        listKiller[2] = tatsuma;
        listKiller[3] = tatsuHadoken;
        listKiller[4] = tatsumaHadoken;

        return listKiller;
    }

    
    
    
    
    
    // Permet de trouver les indices des joueurs à qui il faut demander la carte au prochain tour..(car on est certains 
    // que les autres joueurs n'ont pas la carte en question.
    
    
    
    // Vérifier cette fonction.. c'est peut être là que ça coince....
    
    
    
    // Comme trio[] et getSuspicious sauf que le but ici est de vérifier si toutes les cartes du jeux sont dans ce cas là
    // à savoir : Une carte arme que personne ne possède sauf un joueur PLUS le fait que la carte arme du crime
    // ait été découverte.
    
    
    
    
    public int[] getTrioIndex(String ar, String su, String li) {
        int i;
        int weaponCounter = 0;
        int suspectCounter = 0;
        int placeCounter = 0;
        int weaponId = limit;
        int suspectId = limit;
        int placeId = limit;

        for (i = 0; i < joueurs.size(); i++) {
            if (joueurs.get(i).hasNotWeapon(ar)) {
                weaponCounter++;
            } 
            else if (!(joueurs.get(i).hasWeapon(ar))) {
                weaponId = i;
            }
            if (joueurs.get(i).hasNotSuspect(su)) {
                suspectCounter++;
            } 
            else if (!(joueurs.get(i).hasSuspect(su))) {
                suspectId = i;
            }
            if (joueurs.get(i).hasNotPlace(li)) {
                placeCounter++;
            } 
            else if (!(joueurs.get(i).hasPlace(li))) {
                placeId = i;
            }
        }
        if (weaponCounter == joueurs.size() - 1 && weaponId != limit) {
            trio[0] = weaponId;
        } else {
            trio[0] = limit;
        }
        if (suspectCounter == joueurs.size() - 1 && suspectId != limit) {
            trio[1] = suspectId;
        } else {
            trio[1] = limit;
        }
        if (placeCounter == joueurs.size() - 1 && placeId != limit) {
            trio[2] = placeId;
        } else {
            trio[2] = limit;
        }                       
        return trio;
    }

    
    
    
    
    
    // This is apparently  the only function where Trio[] is used, this correlating it with the above function !!!
    public String getSuspicious(String ar, String su, String li) {

        String sentence = "";
        int i;
        trio = this.getTrioIndex(ar, su, li);
        hypothesis[0]=ar;
        hypothesis[1]=su;
        hypothesis[2]=li;
        
        for (i = 0; i < 3; i++) {
            if (trio[i] < limit && solutioner[i].charAt(0)=='Z') {
                System.out.println("\n trio[0] = "+trio[0]);
                System.out.println("trio[1] = "+trio[1]);
                System.out.println("trio[2] = "+trio[2]);
                System.out.println("hypo[0] = "+ar);
                System.out.println("hypo[1] = "+su);
                System.out.println("hypo[2] = "+li + "\n");
                sentence = "Au prochain tour, demandez l'élément " + hypothesis[i] + " à " + joueurs.get(trio[i]).getName() + "///////";
                this.updateCouple(2, hypothesis[i]);
            }
            else if (trio[i] < limit && !solutioner[i].isEmpty()){
                sentence = "Au prochain tour, demandez l'élément " + hypothesis[i] + " à " + joueurs.get(trio[i]).getName() + "////////";
                switch (i){
                  case 0 : joueurs.get(trio[i]).addToWeapon(ar);
                           this.addArme(ar); this.addTotal(ar);
                           this.updateCouple(1, ar);
                  break;
                  case 1 : joueurs.get(trio[i]).addToSuspect(su);
                           this.addSuspect(su); this.addTotal(su);
                           this.updateCouple(1, su);
                  break;
                  case 2 : joueurs.get(trio[i]).addToPlace(li);
                           this.addPiece(li); this.addTotal(li);
                           this.updateCouple(1, li);
                  break;
            }
           }
        }
        return sentence;
    }

    
    
    
    
    //!!!!!!!! créer une fonction qui permet de remplir le tableau NotHasCard quand le joueur ne montre pas ses cartes
    // ou quand on attribue à un 'Jago' une carte (logiquement il faut ajouter cette carte à la liste des cartes non détenue
    // par les autres joueurs (sauf moi...)
    
    
    
    
    public String addSolution(String ar, String su, String li) {
        String sentence = "";
        String suite = "";
        String sequel = "";
        String niet = null;
        boolean one = this.addSolutionWeapon(ar);
        boolean two = this.addSolutionSuspect(su);
        boolean three = this.addSolutionPlace(li);
        
        if (one) {
            sentence = ar + " a été ajouté à la solution \n";
            this.updateCouple(3, ar);
        }
        if (two) {
            sequel = su + " a été ajouté à la solution \n";
            this.updateCouple(3, su);
        }
        if (three) {
            suite = li + " a été ajouté à la solution \n";
            this.updateCouple(3, li);
        } 
        return sentence + suite + sequel ;
    }

    
    
    
    
    
    
    
    
    
    
   
    
    
    public boolean addSolutionWeapon(String ar) {
        boolean result = false;
        int i;
        int weaponCounter = 0;

        for (i = 0; i < joueurs.size(); i++) {
            if (joueurs.get(i).hasNotWeapon(ar)) {
                
            
                
                weaponCounter++;
            }
        }
        if (weaponCounter == joueurs.size()) {
            this.addWeaponToSoluce(ar);
            result = true;
        }
        return result;
    }

    
    
    
    
    
    public boolean addSolutionSuspect(String su) {
        int i;
        boolean result = false;

        int suspectCounter = 0;

        for (i = 0; i < joueurs.size(); i++) {
            if (joueurs.get(i).hasNotSuspect(su)) {
                suspectCounter++;
            }
        }
        if (suspectCounter == joueurs.size()) {
            this.addSuspectToSoluce(su);
            result = true;
        }
        return result;
    }

    
    
    
    
    
    public boolean addSolutionPlace(String li) {
        int i;
        boolean result = false;

        int placeCounter = 0;

        for (i = 0; i < joueurs.size(); i++) {
            if (joueurs.get(i).hasNotPlace(li)) {
                placeCounter++;
            }
        }
        if (placeCounter == joueurs.size()) {
            this.addPlaceToSoluce(li);
            
            result = true;
        }
        return result;
    }

    
    
    
    
    public void addJoueurs(Player player) {
        joueurs.add(player);
    }

    
    
    public void removeJoueurs(Player player) {
        joueurs.remove(player);
    }
    
    
    
    
    public List<Player> getJoueurs (){
        return joueurs;
                }

    
    
    
    
    public boolean isSuspect(String card, int index) {
        boolean var = false;
        if (suz[index].contains(card)) {
            var = true;
        } else {
            var = false;
        }
        return var;
    }

    public boolean isArme(String card, int index) {
        boolean var = false;
        if (arm[index].contains(card)) {
            var = true;
        } else {
            var = false;
        }
        return var;
    }

    public boolean isPiece(String card, int index) {
        boolean var = false;
        if (pie[index].contains(card)) {
            var = true;
        } else {
            var = false;
        }
        return var;
    }
    // arm , suz, pie

    public void addSuspect(String suspect) {
        suspectListe.add(suspect);
    }

    public void removeSuspect(String suspect) {
        suspectListe.remove(suspect);
    }

    public void addArme(String arme) {
        armeListe.add(arme);
    }

    public void removeArme(String arme) {
        armeListe.remove(arme);
    }

    public void addPiece(String piece) {
        pieceListe.add(piece);
    }

    public void removePiece(String piece) {
        pieceListe.remove(piece);
    }

    
    
    
    
    
    
    
    
    
    
    
    public void addWeaponToSoluce(String ar) {
        solutioner[0]=ar;
    }
    public void addSuspectToSoluce(String su) {
        solutioner[1]=su;
    }
    public void addPlaceToSoluce(String li) {
        solutioner[2]=li;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
   

    public boolean isSolution(String anyCard) {
        boolean result = false;
        if (this.solution.contains(anyCard)) {
            result = true;
        }
        return result;
    }
    
    
    
    public String[] getSuspect() {
        return suz;
    }

    public String[] getArme() {
        return arm;
    }

    public String[] getPiece() {
        return pie;
    }

    
    
    
    public String getSoluce(int indice) {
        String soluce = solutioner[indice];
        return soluce;
    }

    
    
    
    
    public void addTotal(String total) {
        totalRecall.add(total);
        totalRecaller.add(total);
    }

    
    
    
    public void removeTotal(String total) {
        totalRecall.remove(total);
        totalRecaller.remove(total);
    }

    
    
    
    public String getTotal(int indice) {
        String total = totalRecaller.get(indice);
        return total;
    }

    
    
    public List<String> getTotalRecaller() {
        return totalRecaller;
    }

    protected String addingSentence(String element, int index) {
        String sentence;
        sentence = "L'élément " + element + " appartenant à " + joueurs.get(index).getName() + " a été ajouté au tableau.";
        return sentence;
    }

    public List<Integer> getRecorder() {
        return recorder;
    }

    
// Il manque le fait que quand on ajoute la carte au joueur 'Jago' on n'omet de remplir le tableaux de cartes non détenues 
// par les autres joueurs...
// Dans l'ancien système cela était aisé car on pouvait collecter toutes les réponses "non" des 'autres' joueurs
// et automatiquement remplir le tableau de cartes non détenues.
// La différence notable ici, est que dès qu'une personne montre sa carte, les joueurs à gauche sont dispensés de montrer
// leur cartes.. 
// Le seul moyen sûr qu'il nous reste sera de updater le tableau (hasNotCard) des joueurs à la gauche du joueur 'Jago'
// dès que la carte que possède ce dernier est identifiée...

        // TOUR REVOIR ASAP !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        public String addingPlace(Player Jago, Player Asker, int jago) {
            
            String sentence = null;
// écrire un algorithme qui fait le boulot de définir si oui ou non il faut remplir le tableau de tel ou tel joueur...
            Jago.addToPlace(li);
            Jago.addCardsKnown();
            this.addPiece(li);
            this.addTotal(li);
            Asker.addToNotPlace(li);

            if (jago == firstIndex) {
                Player second = joueurs.get(secondIndex);
                Player third = joueurs.get(thirdIndex);
                second.addToNotPlace(li);
                third.addToNotPlace(li);
            } else if (jago == secondIndex) {
                Player third = joueurs.get(thirdIndex);
                third.addToNotPlace(li);
            }
            sentence = this.addingSentence(li, jago);
            this.updateCouple(1, li);
            return sentence;
        }

        
        
        
        
        public String addingSuspect(Player Jago, Player Asker, int jago) {
            
            String sentence = null;
// écrire un algorithme qui fait le boulot de définir si oui ou non il faut remplir le tableau de tel ou tel joueur...
            Jago.addToSuspect(su);
            Jago.addCardsKnown();
            this.addSuspect(su);
            this.addTotal(su);
            Asker.addToNotSuspect(su);

            if (jago == firstIndex) {
                Player second = joueurs.get(secondIndex);
                Player third = joueurs.get(thirdIndex);
                second.addToNotSuspect(su);
                third.addToNotSuspect(su);
            } else if (jago == secondIndex) {
                Player third = joueurs.get(thirdIndex);
                third.addToNotSuspect(su);
            }
            sentence = this.addingSentence(su, jago);
            this.updateCouple(1, su);
            return sentence;
        }

        
        
        
        
        public String addingWeapon(Player Jago, Player Asker, int jago) {
            
            String sentence = null;
// écrire un algorithme qui fait le boulot de définir si oui ou non il faut remplir le tableau de tel ou tel joueur...
            Jago.addToWeapon(ar);
            Jago.addCardsKnown();
            this.addArme(ar);
            this.addTotal(ar);
            Asker.addToNotWeapon(ar);

            if (jago == firstIndex) {
                Player second = joueurs.get(secondIndex);
                Player third = joueurs.get(thirdIndex);
                second.addToNotWeapon(ar);
                third.addToNotWeapon(ar);
            } else if (jago == secondIndex) {
                Player third = joueurs.get(thirdIndex);
                third.addToNotWeapon(ar);
            }
            sentence = this.addingSentence(ar, jago);
            this.updateCouple(1, ar);
            return sentence;
        }

        // what is this ???
        public void addingJago() {

        }
        
        
        
        
        
        public String armaChecker (){
            int id = 0;
            sentence = "";
            for (int i = 0 ; i < arm.length; i++){
                id = this.getArmorIndex(arm[i]);
                if (solutioner[0].charAt(0)!='Z' && id < 6){
                    this.getJoueurs().get(id).addToWeapon(arm[i]);
                    this.addArme(arm[i]);
                    this.addTotal(arm[i]);
                    this.updateCouple(1, arm[i]);
                    sentence = this.addingSentence(arm[i], id);
                }
            }
            return sentence;
        }
        
        public String persoChecker (){
            int id = 0;
            sentence = "";
            for (int i = 0 ; i < suz.length; i++){
                id = this.getCharacIndex(suz[i]);
                if (solutioner[1].charAt(0)!='Z'&& id < 6){
                    this.getJoueurs().get(id).addToSuspect(suz[i]);
                    this.addSuspect(suz[i]);
                    this.addTotal(suz[i]);
                    this.updateCouple(1, suz[i]);
                    sentence = this.addingSentence(suz[i], id);
                }
            }
            return sentence;
        }
        
        public String siteChecker (){
            int id = 0;
            sentence = "";
            for (int i = 0 ; i < pie.length; i++){
                id = this.getSiteIndex(pie[i]);
                if (solutioner[2].charAt(0)!='Z' && id < 6){
                    this.getJoueurs().get(id).addToPlace(pie[i]);
                    this.addPiece(pie[i]);
                    this.addTotal(pie[i]);
                    this.updateCouple(1, pie[i]);
                    sentence = this.addingSentence(pie[i], id);
                }
            }
            return sentence;
        }
        
        public int getArmorIndex (String ar){
     int i;
     int armorId = limit;
     int armor = 0;
     int armorIt = 0;
     for (i = 0; i < joueurs.size(); i++) {
         if (joueurs.get(i).hasNotWeapon(ar)) {
                armorIt++;
            } 
            else if (!(joueurs.get(i).hasWeapon(ar))) {
                armorId = i;
            }
         
     }
     if (armorIt == joueurs.size() - 1 && armorId != limit) {
            armor= armorId;
        } else {
            armor = limit;
        }
        return armor;
     
    }
    
    
    public int getCharacIndex (String su){
     int i;
     int characId = limit;
     int charac = 0;
     int characIt = 0;
     for (i = 0; i < joueurs.size(); i++) {
         if (joueurs.get(i).hasNotSuspect(su)) {
                characIt++;
            } 
            else if (!(joueurs.get(i).hasSuspect(su))) {
                characId = i;
            }
         
     }
     if (characIt == joueurs.size() - 1 && characId != limit) {
            charac= characId;
        } else {
            charac = limit;
        }
        return charac;
     
    }
    
    public int getSiteIndex (String li){
     int i;
     int siteId = limit;
     int site = 0;
     int siteIt = 0;
     for (i = 0; i < joueurs.size(); i++) {
         if (joueurs.get(i).hasNotPlace(li)) {
                siteIt++;
            } 
            else if (!(joueurs.get(i).hasPlace(li))) {
                siteId = i;
            }
         
     }
     if (siteIt == joueurs.size() - 1 && siteId != limit) {
            site= siteId;
        } else {
            site = limit;
        }
        return site;
     
    }
        
        
        
        
        
        
        
        public void destruction (String ar, String su, String li,  int prims){
        Player prim = this.getJoueurs().get(firstIndex);
        prim.addToNotPlace(li);
        prim.addToNotSuspect(su);
        prim.addToNotWeapon(ar);
    }
    public void extinction (String ar, String su, String li,  int prims, int dems){
        Player prim = this.getJoueurs().get(firstIndex);
        Player deum = this.getJoueurs().get(secondIndex);
        prim.addToNotPlace(li);
        prim.addToNotSuspect(su);
        prim.addToNotWeapon(ar);
        deum.addToNotPlace(li);
        deum.addToNotSuspect(su);
        deum.addToNotWeapon(ar);
    }
    public void annihilation (String ar, String su, String li,  int prims, int dems, int trems){
        Player prim = this.getJoueurs().get(firstIndex);
        Player deum = this.getJoueurs().get(secondIndex);
        Player trem = this.getJoueurs().get(thirdIndex);
        prim.addToNotPlace(li);
        prim.addToNotSuspect(su);
        prim.addToNotWeapon(ar);
        deum.addToNotPlace(li);
        deum.addToNotSuspect(su);
        deum.addToNotWeapon(ar);
        trem.addToNotPlace(li);
        trem.addToNotSuspect(su);
        trem.addToNotWeapon(ar);
    }
    
        public void takingCareOfBusiness (int first, int second, int third){
        if(first == 0 && second==0 && third ==1){
            this.extinction(ar, su, li, first, second);
        }
        else if(first == 0 && second==0 && third ==2){
            this.extinction(ar, su, li, first, second);
        }
        
        else if (first == 0 && second==1 && third ==2){
            this.destruction(ar, su, li, first);
        }
        // j'ai montré ma carte....
        else if (first == 0 && second==2 && third ==2){
            this.destruction(ar, su, li, first);
        }
        else if (first == 0 && second==0 && third ==0){
            this.annihilation(ar, su, li, first, second, third);
        }
    }




}


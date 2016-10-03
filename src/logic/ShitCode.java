/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

/**
 *
 * @author Ludovic
 */
public class ShitCode {
    /**
        
        int Hypothese[][] = new int[2][3];
        
        ArrayList<String> solution = new ArrayList<String>();
        
        Set<String> soluce = new HashSet<String>();

        Scanner myScan = new Scanner(System.in);

        ArrayList<Integer> matrix[] = new ArrayList[50];
        int t = 0;

        ArrayList<Integer> killerId = new ArrayList<Integer>();

        ArrayList<String> mainTab = new ArrayList<String>();

        char response = ' ';

        /**
         * *******************************************************VARIABLES
         * JOUEURS **********************************************************
         */
        ArrayList<String> nomJoueurs = new ArrayList<String>();

        String moi;
        String joueurTemp = null;
        int nbreJoueur;

        int tempDemandeur;
        String demandeur;

        char choixTemoin;
        int tempTemoin;
        int temoin;
        String nomTemoin = null;

        /**
         ***********************************************************VARIABLES-ARMES
         * ***********************************************************
         */
        Set<String> ArmeSet = new HashSet<String>();
        ArrayList<String> Armes = new ArrayList<String>();
        String armesTemp;
        int nbreArmes;
        int intArmes;
        String chararme;
        String nomArme = null;
        int arme = 0;
        String armeDuCrime = null;

        ArrayList<String> indiceLettre = new ArrayList<String>();

        indiceLettre.add("a");
        indiceLettre.add("b");
        indiceLettre.add("c");
        indiceLettre.add("d");
        indiceLettre.add("e");
        indiceLettre.add("f");
        indiceLettre.add("g");
        indiceLettre.add("h");
        indiceLettre.add("i");
        indiceLettre.add("j");
        indiceLettre.add("k");
        indiceLettre.add("l");
        /**
         *********************************************************VARIABLES-SUSPECTS
         * **********************************************************
         */
        Set<String> SuspectSet = new HashSet<String>();
        ArrayList<String> Suspects = new ArrayList<String>();
        String suspectTemp;
        int nbreSuspects;
        int intSuspects;
        String charsuspect;
        String nomSuspect = null;
        int suspect = 0;
        String coupable = null;

        /**
         ***********************************************************VARABLES-LIEUX
         * ***************************************************************
         */
        Set<String> LieuSet = new HashSet<String>();
        ArrayList<String> Lieux = new ArrayList<String>();
        String lieuxTemp;
        int nbreLieux;
        int intLieux;
        String charlieu;
        String nomLieu = null;
        int lieu = 0;
        String lieuDuCrime = null;

        /* Première interface : Entrer le nombre de joueurs !!!
         Création des objets PARTIES 3, 4, 5, 6 joueurs...
         */
        System.out.println("Entre le nombre de joueurs (y compris toi-même) compris entre 3 et 6... \n");

        do {
            nbreJoueur = 0;
            try {
                nbreJoueur = myScan.nextInt();
                myScan.nextLine();
                if (nbreJoueur < 2) {
                    System.out.println("Tu ne vas pas jouer tout seul QUAND MEME!!!!... \n");
                    System.out.println("Entrez à nouveau le nombre de joueurs \n");
                } else if (nbreJoueur > 6) {
                    System.out.println("Vous êtes trop nombreux!!!!!\n");
                    System.out.println("Entrez à nouveau le nombre de joueurs \n");
                } else if (nbreJoueur == 2) {
                    System.out.println("Vous êtes trop peu nombreux pour jouer...\n");
                    System.out.println("Entrez à nouveau le nombre de joueurs \n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer un chiffre svp... \n");
            }
        } while (nbreJoueur < 2 || nbreJoueur > 6 || nbreJoueur == 2);

        //*************************************************************************************************************************
        //  Deuxième interface/fenêtre : Création et instanciation de l'objet FirstPlayer..
        //*************************************************************************************************************************
        System.out.println("Pour commencer, entre ton prénom sur la console ??? \n");

        moi = myScan.nextLine();
        // On vide la ligne...

        System.out.println("Sois le bienvenu " + moi + "!!!!! \n");

        nomJoueurs.add(moi);

        /**
         * *************************************************************************************************************
         * /
         * // Très important pour la création de la classe collection contenant
         * les joueurs et les cartes qu'ils possèdent!!! //
         * **************************************************************************************************************
         */
        System.out.println("Maintenant entre le nom de tes adversaires");

        for (int i = 0; i < nbreJoueur - 1; ++i) {
            try {
                joueurTemp = myScan.nextLine();

            } catch (InputMismatchException e) {
                System.out.print(e.toString());
                System.out.println("Veuillez entrer une chaîne de caractères svp !!!!");
            }
            nomJoueurs.add(joueurTemp);
        }


        /*
         ************************************************************************************************************************
         // Déclaration du tableaux contenant les noms des joueurs et les éléments qu'ils possèdent...
         // Déclaration du tableaux contenant les noms des joueurs et les éléments qu'ils ne possèdent pas...
         *******************************************************************************************************************
         */
        ArrayList<String>[] hasCard = new ArrayList[nomJoueurs.size() + 1];

        for (int base = 0; base < nomJoueurs.size() + 1; base++) {
            hasCard[base] = new ArrayList<String>();

        }
        Set<String>[] hasCardSet = new HashSet[nomJoueurs.size() + 1];
        for (int base = 0; base < nomJoueurs.size() + 1; base++) {
            hasCardSet[base] = new <String> HashSet();
        }

        Set<String>[] hasNotCard = new HashSet[nomJoueurs.size()];

        for (int base = 0; base < nomJoueurs.size(); base++) {
            hasNotCard[base] = new <String> HashSet();
        }

        /**
         * **************************************************************************************************************
         */
        //* On déduit les suspects, armes et lieux de la listes des éléments suspects en demandant au joueur de les cocher.
        /**
         ********************************************** LES ARMES *
         * ***********************************************************************
         */
        nbreArmes = 0;
        System.out.println("Combien d'armes as-tu reçu dans ton jeu  ? \n");
        do {
            System.out.println("Veuillez choisir un chiffre entre 1 et " + arm.length);

            nbreArmes = myScan.nextInt();
            // On vide la ligne...
            myScan.nextLine();
            // Déclaration des variables..
        } while (nbreArmes < 1 && nbreArmes > 8);

        int choixArmes[] = new int[nbreArmes];

        System.out.println("Tape le(s)numéro(s) correspondant aux cartes 'armes' contenues dans ton jeu stp ...");

        for (int j = 0; j < arm.length; j++) {
            System.out.println((j + 1) + " : " + arm[j]);
        }

        System.out.println("Entrez le numéro de l'arme stp.");
        for (int a = 0; a < nbreArmes; a++) {
            do {
                System.out.println("Veuillez taper un chiffre comrpris entre 1 et " + arm.length + " svp !!! \n");
                choixArmes[a] = 0;
                try {
                    choixArmes[a] = myScan.nextInt();
                    myScan.nextLine();
                } catch (InputMismatchException v) {
                    System.out.println(v.getMessage());
                }
            } while (choixArmes[a] > arm.length || choixArmes[a] < 1);
        }

        for (int n = 0; n < nbreArmes; n++) {
            armesTemp = arm[choixArmes[n] - 1];
            Armes.add(armesTemp);
            mainTab.add(armesTemp);
        }

        System.out.println(Armes.toString());

        /**
         ********************************************** LES SUSPECTS
         * ***********************************************************************
         */
        nbreSuspects = 0;

        System.out.println("Combien de cartes 'Suspects' as-tu reçu dans ton jeu  ?\n");
        do {

            System.out.println("Veuillez choisir un chiffre entre 1 et " + suz.length);
            nbreSuspects = myScan.nextInt();
            // On vide la ligne...
            myScan.nextLine();
            // Déclaration des variables..
        } while (nbreSuspects < 1 && nbreSuspects > 10);

        int choixSuspects[] = new int[nbreSuspects];

        System.out.println("Tape le(s)numéro(s) correspondant aux cartes 'suspects' contenues dans ton jeu stp ...");

        for (int j = 0; j < suz.length; j++) {
            System.out.println((j + 1) + " : " + suz[j]);
        }

        System.out.println("Entrez le numéro du suspect stp.");

        for (int a = 0; a < nbreSuspects; a++) {
            do {
                System.out.println("Veuillez taper un chiffre comrpris entre 1 et " + suz.length + " svp !!! \n");

                choixSuspects[a] = 0;
                try {
                    choixSuspects[a] = myScan.nextInt();
                    myScan.nextLine();
                } catch (InputMismatchException v) {
                    System.out.println(v.getMessage());
                }
            } while (choixSuspects[a] > suz.length || choixSuspects[a] < 1);
        }

        for (int n = 0; n < nbreSuspects; ++n) {
            suspectTemp = suz[choixSuspects[n] - 1];
            Suspects.add(suspectTemp);
            mainTab.add(suspectTemp);
        }

        System.out.println(Suspects.toString());

        /**
         ********************************************** LES LIEUX
         * *************************************************************************
         */
        nbreLieux = 0;
        System.out.println("Combien de cartes 'lieux' as-tu reçu dans ton jeu  ?\n");
        do {
            System.out.println("Veuillez choisir un chiffre entre 1 et " + pie.length);

            nbreLieux = myScan.nextInt();
            // On vide la ligne...
            myScan.nextLine();
        } while (nbreLieux < 1 && nbreLieux > 12);

        // Déclaration des variables..
        int choixLieux[] = new int[nbreLieux];

        System.out.println("Tape le(s)numéro(s) correspondant aux cartes 'lieux' contenues dans ton jeu stp ...");

        for (int j = 0; j < pie.length; j++) {
            System.out.println((j + 1) + " : " + pie[j]);
        }

        System.out.println("Entrez le numéro du lieu stp. \n");

        for (int a = 0; a < nbreLieux; a++) {
            do {
                System.out.println("Veuillez taper un chiffre comrpris entre 1 et " + pie.length + " svp !!! \n");
                choixLieux[a] = 0;
                try {
                    choixLieux[a] = myScan.nextInt();
                    myScan.nextLine();
                } catch (InputMismatchException v) {
                    System.out.println(v.getMessage());
                }
            } while (choixLieux[a] > pie.length || choixLieux[a] < 1);
        }
        for (int n = 0; n < nbreLieux; ++n) {
            lieuxTemp = pie[choixLieux[n] - 1];
            Lieux.add(lieuxTemp);
            mainTab.add(lieuxTemp);

        }

        System.out.println(Lieux.toString());

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }

        System.out.println("LA PARTIE PEUT COMMENCER !!!! Bonne chance " + moi + "\n");

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }

        System.out.println("C'EST PARTI !!!!!!!!!!!!!!!!!!!!!!!\n");

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }

// C'est un tableaux FIXE [] qui contient des tableaux DYNAMIQUES ArrayList () !!!        
// Avant d'entrer dans la boucle principale nous remplissons tableauxCartes [0] qui correspond à la personne utilisant le programme
        for (int i = 0; i < Armes.size(); i++) {
            hasCard[0].add(Armes.get(i));
            ArmeSet.add(Armes.get(i));
        }
        for (int j = 0; j < Suspects.size(); j++) {
            hasCard[0].add(Suspects.get(j));
            SuspectSet.add(Suspects.get(j));
        }
        for (int k = 0; k < Lieux.size(); k++) {
            hasCard[0].add(Lieux.get(k));
            LieuSet.add(Lieux.get(k));
        }

        System.out.println(hasCard[0]);

        for (String listeArme : arm) {
            if (!Armes.contains(listeArme)) {
                hasNotCard[0].add(listeArme);
            }
        }
        for (String listeSuspect : suz) {
            if (!Suspects.contains(listeSuspect)) {
                hasNotCard[0].add(listeSuspect);
            }
        }
        for (String listeLieu : pie) {
            if (!Lieux.contains(listeLieu)) {
                hasNotCard[0].add(listeLieu);
            }
        }

        System.out.println(hasNotCard[0]);

        /*
         ********************************************************DEBUT DU JEU***********************************************************
         *******                                                                                                                 ****************
         **********                                                                                      ***************
         **************                                                            ***********
         **************************¨^^^^^^^^^^^^^^^^***************
         *****************************************************************************************************************************************
         Tant qu' on a pas éliminé 8 armes, 10 suspects et 12 lieux de la liste, on a pas la combinaison gagnante...
         Et donc la boucle continue d'effectuer ses tours */
        // CONTROLLER !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        while (soluce.size() < 3) {
            /* Ici nous allons coder le coeur même de la partie. 
             *La boucle "while" est censée contenir le déroulement d'une partie
             */
            //CONTROLLER
            System.out.println("Maintenant... Quels sont les éléments demandés héhé... ? \n");

            char rep = ' ';
            boolean oui = (rep == 'o');
            boolean non = (rep == 'n');

            boolean cartePresente = (response == 'o');
            boolean carteAbsente = (response == 'n');

            /**
             * *************************************************-A-R-M-E-S-**************************************************************************
             */
            //CONTROLLER
            System.out.println("L'arme... ??? \n ");

            for (int j = 0; j < arm.length; j++) {
                System.out.println(indiceLettre.get(j) + " : " + arm[j]);

            }
            do {
                System.out.println("Veuilez entrer une lettre !!!\n");
                chararme = myScan.nextLine();
            } while (chararme.length() != 1 && !indiceLettre.subList(0, 8).contains(chararme));
            //CONTROLLER

            /*   chararme = "a";
             if (t == 0){
             chararme = "a";
             }
             if (t == 1){
             chararme = "d";
             }
             if (t == 2){
             chararme = "e";
             }
             if (t == 3){
             chararme = "f";
             }
             if (t == 4){
             chararme = "f";
             }
             if (t == 5){
             chararme = "e";
             }
             if ( t == 6){
             chararme = "d";
             }
             if ( t == 7){
             chararme = "f";
             }
             if (t > 7){
             chararme = myScan.nextLine();
             }*/
            for (int id = 0; id < arm.length; id++) {
                boolean isEqual = indiceLettre.get(id).equals(chararme);
                // on vérifie l'égalité des caractère au sein d'une boucle for en déclarant un booléen..
                if (isEqual) {
                    Hypothese[1][0] = id;
                    // MODEL
                    arme = Hypothese[1][0];
                    nomArme = arm[arme];
                }
            }

            /**
             * **********************************************************S-U-S-P-E-C-T-S*********************************************************************
             */
            //CONTROLLER
            System.out.println("Le suspect... ??? \n ");

            for (int j = 0; j < suz.length; j++) {
                System.out.println(indiceLettre.get(j) + " : " + suz[j]);
            }
            charsuspect = " ";
            do {
                System.out.println("Veuilez entrer une lettre !!!\n");
                charsuspect = myScan.nextLine();
            } while (charsuspect.length() != 1 && !indiceLettre.subList(0, 10).contains(charsuspect));
            //CONTROLLER

            /*charsuspect = "a";
            
             if (t == 0){
             charsuspect = "a";
             }
             if (t == 1){
             charsuspect = "a";
             }
             if (t == 2){
             charsuspect = "e";
             }
             if (t == 3){
             charsuspect = "e";
             }
             if (t == 4){
             charsuspect = "g";
             }
             if (t == 5){
             charsuspect = "a";
             }
             if ( t == 6){
             charsuspect = "f";
             }
             if ( t == 7){
             charsuspect = "a";
             }
             if ( t > 7){
             charsuspect = myScan.nextLine();
             }*/
            for (int id = 0; id < suz.length; id++) {
                boolean isEqual = indiceLettre.get(id).equals(charsuspect);

                if (isEqual) {
                    Hypothese[1][1] = id;

                    suspect = Hypothese[1][1];
                    nomSuspect = suz[suspect];
                }
            }

            /**
             * *************************************************************L-I-E-U-X************************************************************************
             */
            //CONTROLLER
            System.out.println("Le lieu... ??? \n ");

            for (int j = 0; j < pie.length; j++) {
                System.out.println(indiceLettre.get(j) + " : " + pie[j]);
            }
            do {
                System.out.println("Veuilez entrer une lettre !!!\n");
                charlieu = myScan.nextLine();
            } while (charlieu.length() != 1 && !indiceLettre.subList(0, 12).contains(charlieu));


            /*charlieu = "b";
            
             if ( t == 0){
             charlieu = "b";
             }
             if ( t == 1){
             charlieu = "b";
             }
             if ( t == 2){
             charlieu = "e";
             }
             if ( t == 3){
             charlieu = "f";
             }
             if ( t == 4){
             charlieu = "k";
             }
             if ( t == 5){
             charlieu = "d";
             }
             if ( t == 6){
             charlieu = "f";
             }
             if ( t == 7){
             charlieu = "j";
             }
             if ( t > 7){
             charlieu = myScan.nextLine();
             }*/
            for (int ouechx2 = 0; ouechx2 < pie.length; ouechx2++) {
                boolean isEqual = indiceLettre.get(ouechx2).equals(charlieu);

                if (isEqual) {
                    Hypothese[1][2] = ouechx2;

                    lieu = Hypothese[1][2];
                    nomLieu = pie[lieu];
                }
            }

            /**
             * *****************************************************-D-E-M-A-N-D-E-U-R-**************************************************************************
             */
            System.out.println("Tapez le chiffre correspondant au joueur qui a formulé l'hypothèse  \n");

            for (int i = 0; i < nomJoueurs.size(); i++) {
                System.out.println((i + 1) + " : " + nomJoueurs.get(i));
            }
            tempDemandeur = 0;
            do {
                try {
                    tempDemandeur = myScan.nextInt();
                    myScan.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                }
            } while (tempDemandeur < 1 && tempDemandeur > nomJoueurs.size());
            /*choixDemandeur = '2';
             if ( t == 0){
             choixDemandeur ='2';
             }
             if ( t == 1){
             choixDemandeur ='4';
             }

             if ( t == 2){
             choixDemandeur ='1';
             }

             if ( t == 3){
             choixDemandeur ='3';
             }
             if ( t == 4){
             choixDemandeur ='5';
             }

             if ( t == 5){
             choixDemandeur ='2';
             }
             if ( t == 6){
             choixDemandeur = '2';
             }
             if ( t == 7){
             choixDemandeur = '5';
             }
             if ( t > 7){
             choixDemandeur = myScan.nextLine().charAt(0);
             }*/
            tempDemandeur--;

            demandeur = nomJoueurs.get(tempDemandeur);

            // CHAUD !!!!!!!!!!!!!!!!!!!!!////////////////////////////////////////////////////////////////
            Hypothese[0][0] = tempDemandeur;

            // *****************************************TEMOINS + ALGORITHME DE RESOLUTION************************************************
            //****************************************************************************************************************************/
            int i = 0;
            int h = 1;

            int hadoken = 5;   // Special       killer identifier !!!!!!!!!!
            int tatsumaki = 5; // Rare  special killer identifier !!!!!!!!!!
            int shoryuken = 5; // Ultra special killer identifier !!!!!!!!!!
            int shoryukenId = 0;// shoryuken counter
            int shoryukenOne = 5;        // shoryuken identifier
            int shoryukenBis = 5;     // shoryuken identifier
            int shoryukenTer = 5;       // shoryuken identifier
            int tatsumakiId = 0; // tatsumaki counter
            int tatsumakii = 5;  // tatsumaki identifier
            int tatsumakiii = 5; // tatsumaki identifier
            int tatsumakiiii = 5; // tatsumaki identifier
            int tatsumako = 5; // tatsumaki identifier

            int noCard = 0;    // valeurs possibles : { 0 , 1 , 2 , 3 , 4 }   
            int otherCard = 0; // valeurs possibles : { 0 , 1 , 2 , 3 }
            int myCard = 0;    // valeurs possibles : { 0 , 1 }

            String varArme = null;
            String varSuspect = null;
            String varLieu = null;
            String armeTab = null;
            String suspectTab = null;
            String lieuTab = null;
            String armeAdd = null;
            String suspectAdd = null;
            String lieuAdd = null;

            if (moi.equals(demandeur)) {

                int it = 1;

                // On incrémente à chaque fois qu'on entre dans cette boucle : Joueur [0] montre une de ses cartes.
                while (it < nomJoueurs.size()) {
                    do {
                        System.out.println("Est ce que " + nomJoueurs.get(it) + " vous a montrez une de ses cartes ? \n "
                                + " (O/N) ?");

                        rep = myScan.nextLine().charAt(0);

                    } while (rep != 'o' && rep != 'n');
                    // Si la carte est mon
                    if (rep == 'o') {
                        otherCard++;

                        System.out.println("Entrez le chiffre correspondant à la carte que " + nomJoueurs.get(it) + " vient de vous montrer. \n");
                        System.out.println("1 : " + nomArme + " ou 2 : " + nomSuspect + " ou 3 " + nomLieu);
                        int choixCartes = 0;
                        do {
                            System.out.println("Votre choix est incorrect !!! ");

                            choixCartes = myScan.nextInt();
                            myScan.nextLine();
                        } while (choixCartes < 1 && choixCartes > 3);
                        // On ajoute la carte dévoilée dans le tableauxCartes correspondant au joueur. Cf ci-dessous
                        choixCartes--;
                        int variableLocale = Hypothese[1][choixCartes];

                        String var = null;

                        switch (choixCartes) {

                            case 0:
                                var = arm[variableLocale];
                                varArme = var;
                                Armes.add(var);
                                ArmeSet.add(var);
                                mainTab.add(var);
                                hasCard[it].add(varArme);
                                break;
                            case 1:
                                var = suz[variableLocale];
                                varSuspect = var;
                                Suspects.add(var);
                                SuspectSet.add(var);
                                mainTab.add(var);
                                hasCard[it].add(varSuspect);
                                break;
                            case 2:
                                var = pie[variableLocale];
                                varLieu = var;
                                Lieux.add(var);
                                LieuSet.add(var);
                                mainTab.add(var);
                                hasCard[it].add(varLieu);
                                break;
                        }

                        if (hasCard[it].contains(nomArme)
                                || hasCard[it].contains(nomSuspect)
                                || hasCard[it].contains(nomLieu)) {

                            tatsumaki = it; // The player showed a card and has one card known to us
                            tatsumakiId++;
                        }
                        
                    // on veut savoir si le joueur "other" à une carte, deux cartes, ou 3 cartes qu'on connaît
                        
                        if (tatsumakiId == 1) {
                            tatsumakii = tatsumaki;
                        } else if (tatsumakiId == 2) {
                            tatsumakiii = tatsumaki;
                        } else if (tatsumakiId == 3) {
                            tatsumakiiii = tatsumaki;
                        }
                    // On rajoute au tableau "has Not the Card" toutes les cartes car le joueur n'a pas montré de cartes.
                    } else if (rep == 'n') {

                        noCard += 1;
                        hasNotCard[it].add(nomArme);
                        hasNotCard[it].add(nomSuspect);
                        hasNotCard[it].add(nomLieu);
                    }
                    it++;

                    myCard = 0;    // valeurs possibles : { 0 , 1 }
                }
                it--;
                
                //  if (param[] == {4,0,0,1,1,5,5,5)
                //  if (param[] == {4,0,0,2,2,5,5,5)
               //   if (param[] == {4,0,0,3,3,5,5,5)
                
                if (otherCard ==0 && noCard == 4 && myCard == 0 && 
                        (hasCard[0].contains(nomArme)) 
                        || hasCard[0].contains(nomSuspect)
                        ||hasCard[0].contains(nomLieu)){
                    
                      int Ar = 0;
                      int Su = 0;
                      int Li = 0;
                    if (hasNotCard[0].contains(nomArme)) {
                        Ar++;
                    }
                    else if (hasNotCard[0].contains(nomSuspect)) {
                        Su++;
                    }
                    else if (hasNotCard[0].contains(nomLieu)) {
                        Li++;
                    }

                    
                    if (Ar == 1 && Su == 1 && Li == 0) {
                    solution.add(nomLieu);
                    soluce.add(nomLieu);
                }
                    
                    else if (Ar == 0 && Su == 1 && Li == 1){
                    solution.add(nomArme);
                    soluce.add(nomArme);
                        
                    }
                    else if (Ar == 1 && Su == 0 && Li == 1){
                    solution.add(nomSuspect);
                    soluce.add(nomSuspect);
                        
                    }
                  
                    else if (Ar == 1 && Su == 0 && Li == 0){
                        solution.add(nomSuspect);
                    soluce.add(nomSuspect);
                    solution.add(nomLieu);
                    soluce.add(nomLieu);
                    }
                    else if (Ar == 0 && Su == 1 && Li == 0){
                        solution.add(nomArme);
                    soluce.add(nomArme);
                    solution.add(nomLieu);
                    soluce.add(nomLieu);
                    }
                    else if (Ar == 0 && Su == 0 && Li == 1){
                    solution.add(nomSuspect);
                    soluce.add(nomSuspect);
                    solution.add(nomArme);
                    soluce.add(nomArme);
                    }
            }

                
                
      // Permet de cibler un joueur qui vient de nous montrer une cartes. On veut savoir s'il possède une autre carte (s'il s'avère 
      // qu'il n'a pas cette carte alors c'est une carte soluce !!!
                
                
                 if (otherCard == 1 && (varLieu == null && varSuspect == null) && hasCard[0].contains(nomLieu) && hasNotCard[0].contains(nomSuspect)) {
                    System.out.println("Demandez à " + nomJoueurs.get(tatsumakii) + " la carte " + nomSuspect + " au prochain tour !!!");
                } else if (otherCard == 1 && (varLieu == null && varSuspect == null) && hasCard[0].contains(nomSuspect) && hasNotCard[0].contains(nomLieu)) {
                    System.out.println("Demandez à " + nomJoueurs.get(tatsumakii) + " la carte " + nomLieu + " au prochain tour !!!");
                } else if (otherCard == 1 && (varLieu == null && varArme == null) && hasCard[0].contains(nomLieu) && hasNotCard[0].contains(nomArme)) {
                    System.out.println("Demandez à " + nomJoueurs.get(tatsumakii) + " la carte " + nomArme + " au prochain tour !!!");
                } else if (otherCard == 1 && (varLieu == null && varArme == null) && hasCard[0].contains(nomArme) && hasNotCard[0].contains(nomLieu)) {
                    System.out.println("Demandez à " + nomJoueurs.get(tatsumakii) + " la carte " + nomLieu + " au prochain tour !!!");
                } else if (otherCard == 1 && (varArme == null && varSuspect == null) && hasCard[0].contains(nomArme) && hasNotCard[0].contains(nomSuspect)) {
                    System.out.println("Demandez à " + nomJoueurs.get(tatsumakii) + " la carte " + nomSuspect + " au prochain tour !!!");
                } else if (otherCard == 1 && (varArme == null && varSuspect == null) && hasCard[0].contains(nomSuspect) && hasNotCard[0].contains(nomArme)) {
                    System.out.println("Demandez à " + nomJoueurs.get(tatsumakii) + " la carte " + nomArme + " au prochain tour !!!");
                } 
                
      // ne veut rien dire !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!          
                /*
                else if (otherCard == 2 && varLieu == null && (hasNotCard[0].contains(nomLieu) && hasNotCard[tatsumakii].contains(nomLieu) && hasNotCard[tatsumakiii].contains(nomLieu))) {
                    solution.add(2, nomLieu);
                } else if (otherCard == 2 && varSuspect == null && (hasNotCard[0].contains(nomSuspect) && hasNotCard[tatsumakii].contains(nomSuspect) && hasNotCard[tatsumakiii].contains(nomSuspect))) {
                    solution.add(1, nomSuspect);
                } else if (otherCard == 2 && varArme == null && (hasNotCard[0].contains(nomArme) && hasNotCard[tatsumakii].contains(nomArme) && hasNotCard[tatsumakiii].contains(nomArme))) {
                    solution.add(0, nomArme);
                } 
                */
                
                else if (otherCard == 2 && varLieu == null && (hasNotCard[0].contains(nomLieu) && hasNotCard[tatsumakii].contains(nomLieu) && !hasNotCard[tatsumakiii].contains(nomLieu))) {
                    System.out.println("Demandez à " + nomJoueurs.get(tatsumakiii) + " la carte " + nomLieu + " au prochain tour !!!");
                } else if (otherCard == 2 && varLieu == null && (hasNotCard[0].contains(nomLieu) && hasNotCard[tatsumakiii].contains(nomLieu) && !hasNotCard[tatsumakii].contains(nomLieu))) {
                    System.out.println("Demandez à " + nomJoueurs.get(tatsumakii) + " la carte " + nomLieu + " au prochain tour !!!");
                } 
                
                else if (otherCard == 2 && varSuspect == null && (hasNotCard[0].contains(nomSuspect) && hasNotCard[tatsumakii].contains(nomSuspect) && !hasNotCard[tatsumakiii].contains(nomSuspect))) {
                    System.out.println("Demandez à " + nomJoueurs.get(tatsumakiii) + " la carte " + nomSuspect + " au prochain tour !!!");
                } else if (otherCard == 2 && varSuspect == null && (hasNotCard[0].contains(nomSuspect) && hasNotCard[tatsumakiii].contains(nomSuspect) && !hasNotCard[tatsumakii].contains(nomSuspect))) {
                    System.out.println("Demandez à " + nomJoueurs.get(tatsumakii) + " la carte " + nomSuspect + " au prochain tour !!!");
                } 
                
                else if (otherCard == 2 && varArme == null && (hasNotCard[0].contains(nomArme) && hasNotCard[tatsumakii].contains(nomArme) && !hasNotCard[tatsumakiii].contains(nomArme))) {
                    System.out.println("Demandez à " + nomJoueurs.get(tatsumakiii) + " la carte " + nomArme + " au prochain tour !!!");
                } else if (otherCard == 2 && varArme == null && (hasNotCard[0].contains(nomArme) && hasNotCard[tatsumakiii].contains(nomArme) && !hasNotCard[tatsumakii].contains(nomArme))) {
                    System.out.println("Demandez à " + nomJoueurs.get(tatsumakii) + " la carte " + nomArme + " au prochain tour !!!");
                } 
            } //**********************************************************************************************
            // Pour pas que le demandeur se demande à LUI MEME !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            //**********************************************************************************************
            else {

                while (i < nomJoueurs.size()) {

                    Hypothese[0][1] = i;
                    temoin = Hypothese[0][1];
                    nomTemoin = nomJoueurs.get(temoin);

                    if (!(i == tempDemandeur)) {

                        //******************************************************************************************
                        //*Si le demandeur est une autre personne et uniquement quand la carte est montrée par témoins [i]...
                        //******************************************************************************************
                        System.out.println("Pour chaque témoins, veuillez taper si Oui ou Non le témoin montre une de ses cartes : \n ");

                        do {
                            if (temoin != 0) {
                                System.out.println("Est-ce que : " + nomTemoin + "  a montré une carte à " + demandeur + " ? \n Tapez (O/N) \n ");
                                response = myScan.nextLine().charAt(0);

                            } else {
                                System.out.println("Est-ce que vous avez montré une de vos cartes à " + demandeur + " ? \n Tapez (O/N) \n ");
                                response = myScan.nextLine().charAt(0);
                            }

                        } while (!(response == 'o' || response == 'n'));

                        System.out.println(response);

                        if (response == 'o' && temoin != 0) {

                            // Même principe, on incrémente à chaque fois q'un joueur montre sa carte à un autre joueur.
                            otherCard += 1;
                            // Les hypothèses sont enregistrées dans un fichier txt avec le booléen cartePrestente.

                            if (!(hasCard[i].contains(nomArme)
                                    || hasCard[i].contains(nomSuspect)
                                    || hasCard[i].contains(nomLieu))) {

                                shoryuken = i; // The player showed a card but has none known to us
                                shoryukenId++;
                            }

                            if ((hasCard[i].contains(nomArme) && hasCard[i].contains(nomSuspect))
                                    || (hasCard[i].contains(nomLieu) && hasCard[i].contains(nomSuspect))
                                    || (hasCard[i].contains(nomArme) && hasCard[i].contains(nomLieu))) {

                                hadoken = i; // The player showed a card and has two cards known to us
                            }

                            if (hasCard[i].contains(nomArme)
                                    || hasCard[i].contains(nomSuspect)
                                    || hasCard[i].contains(nomLieu)) {

                                tatsumaki = i; // The player showed a card and has one card known to us
                                tatsumakiId++;
                            }

                            if (tatsumakiId == 1) {
                                tatsumakii = tatsumaki;
                            } else if (tatsumakiId == 2) {
                                tatsumakiii = tatsumaki;
                            } else if (tatsumakiId == 3) {
                                tatsumakiiii = tatsumaki;
                            }

                            if (shoryukenId == 1) {
                                shoryukenOne = shoryuken;
                            } else if (shoryukenId == 2) {
                                shoryukenBis = shoryuken;
                            } else if (shoryukenId == 3) {
                                shoryukenTer = shoryuken;
                            }

                        } else if (response == 'o' && temoin == 0) {
                            // Même principe, on incrémente à chaque fois q'un joueur montre sa carte à un autre joueur.
                            myCard += 1;

                            if (hasCard[0].contains(nomArme)
                                    || hasCard[0].contains(nomSuspect)
                                    || hasCard[0].contains(nomLieu)) {

                                tatsumako = 0; // The player showed a card and has one card known to us
                            }

                            if ((hasCard[0].contains(nomArme) && hasCard[0].contains(nomSuspect))
                                    || (hasCard[0].contains(nomLieu) && hasCard[0].contains(nomSuspect))
                                    || (hasCard[0].contains(nomArme) && hasCard[0].contains(nomLieu))) {

                                hadoken = 0; // The player showed a card and has two cards known to us
                            }

                        } else {

                            // Même principe, on incrémente à chaque fois q'un joueur n'a aucune des cartes suspectées.
                            noCard += 1;
                            // Les hypothèses sont enregistrées dans un fichier txt avec le booléen carteAbsente.
                            hasNotCard[i].add(nomArme);
                            hasNotCard[i].add(nomSuspect);
                            hasNotCard[i].add(nomLieu);
                        }

                        // On remplit le tableaux des éléments absentes dans le jeux du témoin !!!!!!!!!!!!!!!!!!
                        i++;
                        h++;

                        // On saute le demandeur dans l'enumération des témoins !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                    } else {
                        i++;
                    }
                }
            }
            // le tableau hasnotcard est rempli en fonction des cartes présentes dans hasCard

            for (int o = 0; o < hasCard[0].size(); o++) {

                hasNotCard[1].add(hasCard[0].get(o));
                hasNotCard[2].add(hasCard[0].get(o));
                hasNotCard[3].add(hasCard[0].get(o));
                hasNotCard[4].add(hasCard[0].get(o));
            }
            for (int o = 0; o < hasCard[1].size(); o++) {

                hasNotCard[0].add(hasCard[1].get(o));
                hasNotCard[2].add(hasCard[1].get(o));
                hasNotCard[3].add(hasCard[1].get(o));
                hasNotCard[4].add(hasCard[1].get(o));
            }
            for (int o = 0; o < hasCard[2].size(); o++) {

                hasNotCard[0].add(hasCard[2].get(o));
                hasNotCard[1].add(hasCard[2].get(o));
                hasNotCard[3].add(hasCard[2].get(o));
                hasNotCard[4].add(hasCard[2].get(o));
            }
            for (int o = 0; o < hasCard[3].size(); o++) {

                hasNotCard[0].add(hasCard[3].get(o));
                hasNotCard[1].add(hasCard[3].get(o));
                hasNotCard[2].add(hasCard[3].get(o));
                hasNotCard[4].add(hasCard[3].get(o));
            }
            for (int o = 0; o < hasCard[4].size(); o++) {

                hasNotCard[0].add(hasCard[4].get(o));
                hasNotCard[1].add(hasCard[4].get(o));
                hasNotCard[2].add(hasCard[4].get(o));
                hasNotCard[3].add(hasCard[4].get(o));
            }

            if (t == 0) {
                killerId.add(myCard);
                killerId.add(otherCard);
                killerId.add(noCard);
                killerId.add(tatsumakii);
                killerId.add(tatsumakiii);
                killerId.add(tatsumako);
                killerId.add(hadoken);
                killerId.add(tempDemandeur);
                killerId.add(shoryukenOne);
                killerId.add(shoryukenBis);
                killerId.add(shoryukenTer);
                killerId.add(arme);
                killerId.add(suspect);
                killerId.add(lieu);
            }

            if (t > 0) {
                killerId.add(0, myCard);
                killerId.add(1, otherCard);
                killerId.add(2, noCard);
                killerId.add(3, tatsumakii);
                killerId.add(4, tatsumakiii);
                killerId.add(5, tatsumako);
                killerId.add(6, hadoken);
                killerId.add(7, tempDemandeur);
                killerId.add(8, shoryukenOne);
                killerId.add(9, shoryukenBis);
                killerId.add(10, shoryukenTer);
                killerId.add(11, arme);
                killerId.add(12, suspect);
                killerId.add(13, lieu);
            }

            int pi = 14;
            while (killerId.size() > 14) {
                killerId.remove(pi);
            }

            matrix[t] = new ArrayList<Integer>();

            for (int iter = 0; iter < 14; iter++) {
                matrix[t].add(killerId.get(iter));
            }

            /*BOUCLE DE TRAITEMENT*/
            for (int z = 0; z <= t; z++) {

                /* 0 */
                // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                // A chaque fois qu'on revient faire un traitement sur un des tours précédents il va falloir REDEFINIR les SPECIAL IDENTIFIERS !!!!!
                // A savoir : tatsumakii / shoryuken / 
                // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                int my = matrix[z].get(0);
                int other = matrix[z].get(1);
                int no = matrix[z].get(2);
                int tatsu = matrix[z].get(3);
                int tatsuma = matrix[z].get(4);
                int tatsumy = matrix[z].get(5);
                int hado = matrix[z].get(6);
                int td = matrix[z].get(7);
                int jago = matrix[z].get(8);
                int spinal = matrix[z].get(9);
                int fulgore = matrix[z].get(10);
                int anda = matrix[z].get(11);
                int anne = matrix[z].get(12);
                int rre = matrix[z].get(13);

                // de Tatsumakii à Hadoken            
                if (tatsu < 5 && (hasCard[tatsu].contains(arm[anda]) && hasCard[tatsu].contains(suz[anne])
                        || hasCard[tatsu].contains(pie[rre]) && hasCard[tatsu].contains(suz[anne])
                        || hasCard[tatsu].contains(pie[rre]) && hasCard[tatsu].contains(arm[anda]))) {

                    hado = tatsu;
                    tatsu = 5;
                }

                // de Shoryuken à tatsumakiii
                if (tatsu < 5 && jago < 5 && (hasCard[jago].contains(arm[anda])
                        || hasCard[jago].contains(suz[anne])
                        || hasCard[jago].contains(pie[rre]))) {
                    tatsuma = jago;
                    jago = 5;// The player showed a card and has one card known to us
                } else if (tatsu < 5 && spinal < 5 && (hasCard[spinal].contains(arm[anda])
                        || hasCard[spinal].contains(suz[anne])
                        || hasCard[spinal].contains(pie[rre]))) {
                    tatsuma = spinal;
                    spinal = 5;
                }

                // de Shoryuken à Tatsumakii           
                if (tatsuma == 5 && jago < 5 && (hasCard[jago].contains(arm[anda])
                        || hasCard[jago].contains(suz[anne])
                        || hasCard[jago].contains(pie[rre]))) {
                    tatsu = jago;
                    jago = 5;

                } else if (tatsuma == 5 && spinal < 5 && (hasCard[spinal].contains(arm[anda])
                        || hasCard[spinal].contains(suz[anne])
                        || hasCard[spinal].contains(pie[rre]))) {
                    tatsu = spinal;
                    spinal = 5;
                }

                int contain = 0;
                int containBis = 0;
                int containTer = 0;
                int containAr = 0;
                int containSu = 0;
                int containLi = 0;
                int containBisAr = 0;
                int containBisSu = 0;
                int containBisLi = 0;
                int id = 0;

                String hasWeapon = null;
                String hasCulprit = null;
                String hasRoom = null;
                String hasNotWeapon = null;
                String hasNotCulprit = null;
                String hasNotRoom = null;
                String ajout = null;
                String ajoutMin = null;
                String ajoutMax = null;
                /*   System.out.println(" ");
                 System.out.println("myCard : " + my);
                 System.out.println("otherCard : " + other);
                 System.out.println("noCard : " + no);
                 System.out.println("tatsu : " + tatsu);
                 System.out.println("tatsuma : " + tatsuma);
                 System.out.println("tatsumy : " + tatsumy);
                 System.out.println("hadoken : " + hado);
                 System.out.println("demandeur : " + td);
                 System.out.println("jago : " + jago);
                 System.out.println("spinal : " + spinal);
                 System.out.println("fulgore : " + fulgore);
                 System.out.println("arme : " + anda);
                 System.out.println("suspect : " + anne);
                 System.out.println("lieu : " + rre);
                 */
                // S. 0.0 est inorrect et incomplet et CHHHAAAAAAAAAAAAAAAAAAAAUUUUUUUUUUUUUDDDDDDD !!!!!!!!!!!//

               // S 0.0m 
              /* public String solution0.0 () {
                 if (game.getWitnessPlayer().hasWeapon(true))
                 ar++;
                 else  if (game.getWitnessPlayer().hasSuspect(true))
                 su++;
                 else if (game.getWitnessPlayer().hasPlace(true))
                 li++;
                      
                 game.adderNone(ar,su,li);
                 }
                
                
                
                
                 public String adderNone (int ar, int su, int li){
                 if (ar == 1)
                 game.addArmeSolution ();
                 else if (su == 1)
                 game.addSuspectSolution ();
                 else if (li == 1)
                 game.addLieuxSolution ();
                 else if (ar+su+li == 3){
                 game.addFinalSolution ();
                 }
                 }
                
                
                 public String addArmeSolution(){
                
                 }
                
                
                
                 public String addFinalSolution (){
                
                 game.addArmeSolution();
                 game.addSuspectSolution();
                 game.addLieuSolution();
                 String message = ("fzdgk,r+ zrgt r + fzeafgzergfdgf + + feffdq");
                 return message;
                 }
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                 ////if (param[] == {4,0,0,5,1,5,5,5,   0,td,jago,spinal,ND)
                ////if (param[] ==  {4,0,0,5,2,5,5,5,   0, td, tatsu, spinal, ND)
                ////if (param[] ==  {4,0,0,5,3,5,5,5,   0, td, jago, tatsu, ND)
                RULE#1 : TATSU can NEVER be inferior to JAGO
                RULE#2 : TATSU can NEVER be superior to FULGORE
                
                
                 */
                if (no == 4 && other == 0 && my == 0 && td != 0 && (hasCard[td].contains(arm[anda]))
                        || (hasCard[td].contains(suz[anne]))
                        || (hasCard[td].contains(pie[rre]))) {

                    System.out.println(" BIENVENU DANS LE BRANCHEMENT S 0.0,1,2,3 !!!!!! \n");

                    if (hasNotCard[td].contains(arm[anda])) {
                        nomArme = arm[anda];
                        containBisAr++;
                    }

                    if (hasNotCard[td].contains(suz[anne])) {
                        nomSuspect = suz[anne];
                        containBisSu++;
                    }

                    if (hasNotCard[td].contains(pie[rre])) {
                        nomLieu = pie[rre];
                        containBisLi++;
                    }

                    if (containBisAr == 1) {
                        solution.add(nomArme);

                        int r = 0;

                        while (r < arm.length - 1) {
                            if (!(ArmeSet.contains(arm[r]) && arm[r].equals(nomArme))) {
                                Armes.add(arm[r]);
                                ArmeSet.add(arm[r]);
                                r++;
                            } else {
                                r++;
                            }
                        }
                    }
                    if (containBisSu == 1) {

                        solution.add(nomSuspect);

                        int r = 0;

                        while (r < suz.length - 1) {
                            if (!(SuspectSet.contains(suz[r]) && suz[r].equals(nomSuspect))) {
                                Suspects.add(suz[r]);
                                SuspectSet.add(suz[r]);
                                r++;
                            } else {
                                r++;
                            }
                        }
                    } else if (containBisLi == 1) {

                        solution.add(nomLieu);

                        int r = 0;

                        while (r < pie.length - 1) {
                            if (!(LieuSet.contains(pie[r]) && pie[r].equals(nomLieu))) {
                                Lieux.add(pie[r]);
                                LieuSet.add(pie[r]);
                                r++;
                            } else {
                                r++;
                            }
                        }

                    } else if (containBisAr == 1 && containBisSu == 1 && containBisLi == 1) {
                        solution.add(nomArme);
                        solution.add(nomSuspect);
                        solution.add(nomLieu);
                        System.out.println("C'est terminé !!!! " + coupable + " a tué Leblanc avec le/la " + armeDuCrime + " dans le/la " + lieuDuCrime + "!!!!!!!!! \n");
                    }
                }

                 //if (param[] == {4,0,0,5,2,5,5,5)
                 // Jago and spinal index have to be known beforehand
               
                
                
                
                
                
                
                if (other == 0 && my == 0
                        && no == 4 && td != 0) {

                    System.out.println(" BIENVENU DANS LE BRANCHEMENT S 0.2 !!!!!! \n");
                    contain = 0;

                    if (hasCard[td].contains(arm[anda])) {
                        contain++;
                    } else {
                        id = 0;
                        ajout = arm[anda];
                    }

                    if (hasCard[td].contains(suz[anne])) {
                        contain++;
                    } else {
                        id = 1;
                        ajout = suz[anne];
                    }

                    if (hasCard[td].contains(pie[rre])) {
                        contain++;
                    } else {
                        id = 2;
                        ajout = pie[rre];
                    }

                    if (contain == 2 && mainTab.contains(ajout)) {

                        hasCard[td].add(ajout);
                        System.out.println(ajout + "a été ajouté au tableau du demandeur" + nomJoueurs.get(td) + "\n");
                    } else if (contain == 2 && !hasNotCard[td].contains(ajout) && !hasCard[td].contains(ajout)) {

                        System.out.println("Demandez " + ajout + " à " + nomJoueurs.get(td) + "\n");
                    } 
                    else if ( contain == 2 && hasNotCard[td].contains(ajout)){
                        
                    }
                    else if (contain == 3) {
                        System.out.println("Tous les éléments dans ce tour sont connus, le tableaux 'matrix' du présent tout va être supprimé ");

                    }
                } 


                        //if (param[] == {3,1,0,2,0,5,5,5)
                
                else if (other == 0 && my == 1
                        && hado == 0 && !(hasCard[td].contains(arm[anda])
                        && hasCard[td].contains(suz[anne])
                        && hasCard[td].contains(pie[rre]))) {

                    System.out.println(" BIENVENU DANS LE BRANCHEMENT S 1.2? v1 !!!!!! \n");

                    String indice = null;

                    if (hasCard[0].contains(arm[anda])) {
                        contain++;
                    } else {
                        indice = arm[anda];
                    }

                    if (hasCard[0].contains(suz[anne])) {
                        contain++;
                    } else {
                        indice = suz[anne];
                    }

                    if (hasCard[0].contains(pie[rre])) {
                        contain++;
                    } else {
                        indice = pie[rre];
                    }

                    if (contain == 2 && !mainTab.contains(indice)) {
                        System.out.println("Au tour suivant, essayez de demander " + indice + " à " + nomJoueurs.get(td) + " avec 2 cartes appartenant à un autre joueur !!! \n ");
                    } else if (contain == 3) {
                        System.out.println("Tous les éléments dans ce tour sont connus, le tableaux 'matrix' du présent tout va être supprimé ");

                    }
                } 


                //if (param[] == {3,1,0,1,1,5,5,5)
                /*S 1.2 v2*/ 
                
                
                else if (other == 0 && my == 1
                        && tatsumako == 0 && (hasCard[td].contains(arm[anda])
                        || hasCard[td].contains(suz[anne])
                        || hasCard[td].contains(pie[rre]))) {

                    System.out.println(" BIENVENU DANS LE BRANCHEMENT S 1.2? v2 !!!!!! \n");
                    contain = 0;
                    containBis = 0;

                    String indice = null;

                    if (hasCard[td].contains(arm[anda])) {
                        contain++;
                    } else if (hasCard[0].contains(arm[anda])) {
                        containBis++;
                    } else {
                        indice = arm[anda];
                    }

                    if (hasCard[td].contains(suz[anne])) {
                        contain++;
                    } else if (hasCard[0].contains(suz[anne])) {
                        containBis++;
                    } else {
                        indice = suz[anne];
                    }

                    if (hasCard[td].contains(pie[rre])) {
                        contain++;
                    } else if (hasCard[0].contains(pie[rre])) {
                        containBis++;
                    } else {
                        indice = pie[rre];
                    }

                    if (contain == 1 && containBis == 1 && !mainTab.contains(indice)) {
                        System.out.println("Au tour suivant, essayez de demander " + indice + " à " + nomJoueurs.get(td) + " avec 2 cartes appartenant à un autre joueur !!! \n ");
                    }
                    if ((contain == 1 && containBis == 2) || (contain == 2 && containBis == 1)) {
                        System.out.println("Tous les éléments dans ce tour sont connus, le tableaux 'matrix' du présent tour va être supprimé ");
                    }
                } //if (param[] == {3,0,1,5,1,0,5,5)
                else if (other == 1 && my == 0
                        && td != 0 && jago < 5
                        && (hasCard[td].contains(arm[anda])
                        || hasCard[td].contains(suz[anne])
                        || hasCard[td].contains(pie[rre]))) {

                    System.out.println(" BIENVENU DANS LE BRANCHEMENT S 1.2 td && #not v1 !!!!!! \n");
                    contain = 0;
                    id = 0;

                    if (hasCard[td].contains(arm[anda])) {
                        hasNotCard[jago].add(arm[anda]);
                        contain++;
                    }
                    if (hasCard[td].contains(suz[anne])) {
                        hasNotCard[jago].add(suz[anne]);
                        contain++;
                    }
                    if (hasCard[td].contains(pie[rre])) {
                        hasNotCard[jago].add(pie[rre]);
                        contain++;
                    }

                    if (hasNotCard[jago].contains(arm[anda])) {
                        containBis++;
                    } else {
                        ajout = arm[anda];
                        id = 0;
                    }
                    if (hasNotCard[jago].contains(suz[anne])) {
                        containBis++;
                    } else {
                        ajout = suz[anne];
                        id = 1;
                    }

                    if (hasNotCard[jago].contains(pie[rre])) {
                        containBis++;
                    } else {
                        ajout = pie[rre];
                        id = 2;
                    }

                    if (contain == 1 && containBis == 2) {
                        hasCard[jago].add(ajout);
                        // addCard(ajout);
                        System.out.println(ajout + " a été ajouté au tableaux 'carte indice' de " + nomJoueurs.get(jago) + "\n");
                        switch (id) {

                            case 0:
                                Armes.add(ajout);
                                ArmeSet.add(ajout);

                                System.out.println(ajout + " a été ajouté au tableau 'Armes' \n");
                                break;
                            case 1:
                                Suspects.add(ajout);
                                SuspectSet.add(ajout);

                                System.out.println(ajout + " a été ajouté au tableau 'Suspects' \n");
                                break;
                            case 2:
                                Lieux.add(ajout);
                                LieuSet.add(ajout);

                                System.out.println(ajout + " a été ajouté au tableau 'Lieux' \n");
                                break;
                            default:
                                System.out.println("Une exception dans l'ajout de l'élément dans le tableau principal a été levée");
                        }
                    } else if (containBis == 1) {
                        System.out.println("il est impossible d'identifier la carte qui appartient à " + nomJoueurs.get(jago) + "\n");

                    } else if (contain == 3) {
                        System.out.println("Tous les éléments dans ce tour sont connus, le tableaux 'matrix' du présent tout va être supprimé ");
                    }

                } 
                
                
                
                // Par exemple dans ce cas là on appelle précis
                    //if (param[] == {2,1,1,1,0,0,5,5)
                
                
                
                else if (other == 1 && my == 1
                        && tatsu == 0 && jago < 5
                        && tatsuma == 5 && td != 0
                        && (hasNotCard[td].contains(arm[anda])
                        || hasNotCard[td].contains(suz[anne])
                        || hasNotCard[td].contains(pie[rre]))) {

                    // Logic
                    System.out.println(" BIENVENU DANS LE BRANCHEMENT S 2.1# my !!!!!! \n");
                    contain = 0;
                    id = 0;

                    if (hasCard[0].contains(arm[anda])) {
                        hasNotCard[jago].add(arm[anda]);
                    } else if (hasCard[0].contains(suz[anne])) {
                        hasNotCard[jago].add(suz[anne]);
                    } else if (hasCard[0].contains(pie[rre])) {
                        hasNotCard[jago].add(pie[rre]);
                    }

                    if (hasNotCard[jago].contains(arm[anda])) {
                        contain++;
                    } else {
                        ajout = arm[anda];
                        id = 0;
                    }

                    if (hasNotCard[jago].contains(suz[anne])) {
                        contain++;

                    } else {
                        ajout = suz[anne];
                        id = 1;
                    }

                    if (hasNotCard[jago].contains(pie[rre])) {
                        contain++;

                    } else {
                        ajout = pie[rre];
                        id = 2;
                    }

                    if (contain == 2) {

                        // addCard(ajout) {....
                        hasCard[jago].add(ajout);
                        switch (id) {
                            case 0:
                                Armes.add(ajout);
                                ArmeSet.add(ajout);
                                hasNotCard[jago].add(suz[anne]);
                                hasNotCard[jago].add(pie[rre]);
                                System.out.println(ajout + " a été ajouté au tableau 'Armes' \n");
                                break;
                            case 1:
                                Suspects.add(ajout);
                                SuspectSet.add(ajout);
                                hasNotCard[jago].add(arm[anda]);
                                hasNotCard[jago].add(pie[rre]);
                                System.out.println(ajout + " a été ajouté au tableau 'Suspects' \n");
                                break;
                            case 2:
                                Lieux.add(ajout);
                                LieuSet.add(ajout);
                                hasNotCard[jago].add(suz[anne]);
                                hasNotCard[jago].add(arm[anda]);
                                System.out.println(ajout + " a été ajouté au tableau 'Lieux' \n");
                                break;
                            default:
                                System.out.println("Une exception dans l'ajout de l'élément dans le tableau principal a été levée");
                        }
                        System.out.println(ajout + " a été ajouté au tableau 'carte indice' de " + nomJoueurs.get(jago) + "\n");
                    } else if ((contain == 1 && containBis == 2) || (contain == 2 && containBis == 1)) {
                        System.out.println("Tous les éléments dans ce tour sont connus, le tableau 'matrix' du tout numéro : " + (t + 1) + " présent tout va être supprimé ");

                    }
                } 


// Par exemple dans ce cas là on appelle précis
                //if (param[] == {2,0,2,5,1,0,0,5)
                // if the four last digits == 3 --> print "vous connaissez toutes les cartes"
               
                
                else if (other == 2 && my == 0
                        && tatsu == 5 && jago < 5
                        && spinal < 5 && (hasCard[td].contains(arm[anda])
                        || hasCard[td].contains(suz[anne])
                        || hasCard[td].contains(pie[rre]))) {

                    System.out.println(" BIENVENU DANS LE BRANCHEMENT S 2.1 USING not technique td !!!!!! \n");

                    if (hasCard[td].contains(arm[anda])) {
                        hasNotCard[td].add(suz[anne]);
                        hasNotCard[td].add(pie[rre]);
                    } else if (hasCard[td].contains(suz[anda])) {
                        hasNotCard[td].add(arm[anda]);
                        hasNotCard[td].add(pie[rre]);
                    } else if (hasCard[td].contains(pie[rre])) {
                        hasNotCard[td].add(suz[anne]);
                        hasNotCard[td].add(arm[anda]);
                    }

                    if (hasNotCard[td].contains(arm[anda]) && hasNotCard[jago].contains(arm[anda])) {
                        hasCard[spinal].add(arm[anda]);
                        System.out.println(arm[anda] + " a été ajouté au tableau de " + nomJoueurs.get(spinal) + "\n");
                        id = 0;
                    } else if (hasNotCard[td].contains(arm[anda]) && hasNotCard[spinal].contains(arm[anda])) {
                        hasCard[jago].add(arm[anda]);
                        System.out.println(arm[anda] + " a été ajouté au tableau de " + nomJoueurs.get(jago) + "\n");
                        id = 0;
                    } else if (hasNotCard[td].contains(arm[anda]) && !Armes.contains(arm[anda])) {
                        Armes.add(arm[anda]);
                        ArmeSet.add(arm[anda]);
                        System.out.println(arm[anda] + " a été ajouté au tableau 'Armes' \n");
                    }

                    if (hasNotCard[td].contains(suz[anne]) && hasNotCard[jago].contains(suz[anne])) {
                        hasCard[spinal].add(suz[anne]);
                        System.out.println(suz[anne] + " a été ajouté au tableau de " + nomJoueurs.get(spinal) + "\n");
                    } else if (hasNotCard[td].contains(suz[anne]) && hasNotCard[spinal].contains(suz[anne])) {
                        hasCard[jago].add(suz[anne]);
                        System.out.println(suz[anne] + " a été ajouté au tableau de " + nomJoueurs.get(jago) + "\n");
                    } else if (hasNotCard[td].contains(suz[anne]) && !Suspects.contains(suz[anne])) {
                        Suspects.add(suz[anne]);
                        SuspectSet.add(suz[anne]);
                        System.out.println(suz[anne] + " a été ajouté au tableau 'Suspects' \n");
                    }

                    if (hasNotCard[td].contains(pie[rre]) && hasNotCard[jago].contains(pie[rre])) {
                        hasCard[spinal].add(pie[rre]);
                        System.out.println(pie[rre] + " a été ajouté au tableau de " + nomJoueurs.get(spinal) + "\n");
                    } else if (hasNotCard[td].contains(pie[rre]) && hasNotCard[spinal].contains(pie[rre])) {
                        hasCard[jago].add(pie[rre]);
                        System.out.println(pie[rre] + " a été ajouté au tableau de " + nomJoueurs.get(jago) + "\n");
                    } else if (hasNotCard[td].contains(pie[rre]) && !Lieux.contains(pie[rre])) {
                        Lieux.add(pie[rre]);
                        LieuSet.add(pie[rre]);
                        System.out.println(pie[rre] + " a été ajouté au tableau 'Lieux' \n");
                    }
                } 

// Par exemple dans ce cas là on appelle précis
                //if (param[] == {2,1,1,    1,1,0,5,5)
                
                
                
                /*S 2.2 v2*/ else if (other == 1 && my == 1
                        && tatsu == 0 && tatsuma == 5
                        && jago < 5 && (hasCard[td].contains(arm[anda])
                        || hasCard[td].contains(suz[anne])
                        || hasCard[td].contains(pie[rre]))) {

                    System.out.println(" BIENVENU DANS LE BRANCHEMENT S 2.2  my + td !!!!!! \n");
                    contain = 0;
                    containBis = 0;
                    id = 0;

                    if (hasCard[0].contains(arm[anda])) {
                        contain++;
                    } else if (hasCard[td].contains(arm[anda])) {
                        containBis++;
                    } else {
                        ajout = arm[anda];
                        id = 0;
                    }

                    if (hasCard[0].contains(suz[anne])) {
                        contain++;
                    } else if (hasCard[td].contains(suz[anne])) {
                        containBis++;
                    } else {
                        ajout = suz[anne];
                        id = 1;
                    }
                    if (hasCard[0].contains(pie[rre])) {
                        contain++;
                    } else if (hasCard[td].contains(pie[rre])) {
                        containBis++;
                    } else {
                        ajout = arm[anda];
                        id = 2;
                    }

                    if (contain == 1 && containBis == 1) {
                        hasCard[jago].add(ajout);
                        switch (id) {
                            case 0:
                                Armes.add(ajout);
                                ArmeSet.add(ajout);
                                hasNotCard[jago].add(suz[anne]);
                                hasNotCard[jago].add(pie[rre]);
                                System.out.println(ajout + " a été ajouté au tableau 'Armes' \n");
                                break;
                            case 1:
                                Suspects.add(ajout);
                                SuspectSet.add(ajout);
                                hasNotCard[jago].add(arm[anda]);
                                hasNotCard[jago].add(pie[rre]);
                                System.out.println(ajout + " a été ajouté au tableau 'Suspects' \n");
                                break;
                            case 2:
                                Lieux.add(ajout);
                                LieuSet.add(ajout);
                                hasNotCard[jago].add(arm[anda]);
                                hasNotCard[jago].add(suz[anne]);
                                System.out.println(ajout + " a été ajouté au tableau 'Lieux' \n");
                                break;
                            default:
                                System.out.println("Une exception dans l'ajout de l'élément dans le tableau principal a été levée");
                        }
                        System.out.println("l'indice " + ajout + " a été ajouté au tableau 'carte indice' de " + nomJoueurs.get(jago) + "\n");
                    }
                }
                

// Par exemple dans ce cas là on appelle précis
                //if (param[] == {2,1,1,2,0,0,5,5)
                
                
                
                /*easy S 2.2*/ 
                else if (other == 1 && my == 1
                        && hado == 0 && jago < 5) {

                    System.out.println(" BIENVENU DANS LE BRANCHEMENT easy S 2.2 other + my  !!!!!! \n");

                    contain = 0;
                    id = 0;

                    if (hasCard[0].contains(arm[anda])) {
                        contain++;
                    } else {
                        ajout = arm[anda];
                        id = 0;
                    }

                    if (hasCard[0].contains(suz[anne])) {
                        contain++;
                    } else {
                        ajout = suz[anne];
                        id = 1;
                    }

                    if (hasCard[0].contains(pie[rre])) {
                        contain++;
                    } else {
                        ajout = pie[rre];
                        id = 2;
                    }

                    if (contain == 2) {
                        hasCard[jago].add(ajout);
                        hasNotCard[td].add(ajout);
                        switch (id) {

                            case 0:
                                Armes.add(ajout);
                                hasNotCard[jago].add(suz[anne]);
                                hasNotCard[jago].add(pie[rre]);
                                System.out.println(ajout + " a été ajouté au tableau 'Armes' \n");
                                break;
                            case 1:
                                Suspects.add(ajout);
                                hasNotCard[jago].add(arm[anda]);
                                hasNotCard[jago].add(pie[rre]);
                                System.out.println(ajout + " a été ajouté au tableau 'Suspects' \n");
                                break;
                            case 2:
                                Lieux.add(ajout);
                                hasNotCard[jago].add(suz[anne]);
                                hasNotCard[jago].add(arm[anda]);
                                System.out.println(ajout + " a été ajouté au tableau 'Lieux' \n");
                                break;
                            default:
                                System.out.println("Une exception dans l'ajout de l'élément dans le tableau principal a été levée");
                        }
                        System.out.println(ajout + " a été ajouté au tableaux 'carte indice' de " + nomJoueurs.get(jago) + "\n");
                    } else if (contain == 3) {
                        System.out.println("Tous les éléments dans ce tour sont connus, le tableaux 'matrix' du tout numéro : " + (t + 1) + " présent tout va être supprimé ");

                    }
                } 



// Par exemple dans ce cas là on appelle précis
                //if (param[] == {2,0,2,5,1,1,0,5) SPINAL VERSION
                //if (param[] == {2,0,2,5,1,0,1,5) JAGO VERSION
                /*S 2.2v3*/ 
                
                
                else if (other == 2 && my == 0
                        && tatsu < 5 && tatsuma == 5
                        && hado == 5 && ((jago < 5 && spinal == 5) || (spinal < 5 && jago == 5))
                        && (hasCard[td].contains(arm[anda])
                        || hasCard[td].contains(suz[anne])
                        || hasCard[td].contains(pie[rre]))) {

                    System.out.println(" BIENVENU DANS LE BRANCHEMENT S 2.2 td + other !!!!!! \n");
                    contain = 0;
                    containBis = 0;
                    id = 0;

                    if (hasCard[td].contains(arm[anda])) {
                        contain++;
                    } else if (hasCard[tatsu].contains(arm[anda])) {
                        containBis++;
                    } else {
                        ajout = arm[anda];
                        id = 0;
                    }

                    if (hasCard[td].contains(suz[anne])) {
                        contain++;
                    } else if (hasCard[tatsu].contains(suz[anne])) {
                        containBis++;
                    } else {
                        ajout = suz[anne];
                        id = 1;
                    }

                    if (hasCard[td].contains(pie[rre])) {
                        contain++;
                    } else if (hasCard[tatsu].contains(pie[rre])) {
                        containBis++;
                    } else {
                        ajout = pie[rre];
                        id = 2;
                    }

                    if (contain == 1 && containBis == 1 && jago < 5) {
                        hasCard[jago].add(ajout);
                        hasNotCard[td].add(ajout);
                        switch (id) {

                            case 0:
                                Armes.add(ajout);
                                hasNotCard[jago].add(suz[anne]);
                                hasNotCard[jago].add(pie[rre]);
                                System.out.println(ajout + " a été ajouté au tableau 'Armes' \n");
                                break;
                            case 1:
                                Suspects.add(ajout);
                                hasNotCard[jago].add(arm[anda]);
                                hasNotCard[jago].add(pie[rre]);
                                System.out.println(ajout + " a été ajouté au tableau 'Suspects' \n");
                                break;
                            case 2:
                                Lieux.add(ajout);
                                hasNotCard[jago].add(suz[anne]);
                                hasNotCard[jago].add(arm[anda]);
                                System.out.println(ajout + " a été ajouté au tableau 'Lieux' \n");
                                break;
                            default:
                                System.out.println("Une exception dans l'ajout de l'élément dans le tableau principal a été levée");
                        }
                        System.out.println(ajout + " a été ajouté au tableaux 'carte indice' de " + nomJoueurs.get(jago) + "\n");
                    }
                    if (contain == 1 && containBis == 1 && spinal < 5) {
                        hasCard[spinal].add(ajout);
                        hasNotCard[td].add(ajout);

                        switch (id) {

                            case 0:
                                Armes.add(ajout);
                                hasNotCard[spinal].add(suz[anne]);
                                hasNotCard[spinal].add(pie[rre]);
                                System.out.println(ajout + " a été ajouté au tableau 'Armes' \n");
                                break;
                            case 1:
                                Suspects.add(ajout);
                                hasNotCard[spinal].add(arm[anda]);
                                hasNotCard[spinal].add(pie[rre]);
                                System.out.println(ajout + " a été ajouté au tableau 'Suspects' \n");
                                break;
                            case 2:
                                Lieux.add(ajout);
                                hasNotCard[spinal].add(suz[anne]);
                                hasNotCard[spinal].add(arm[anda]);
                                System.out.println(ajout + " a été ajouté au tableau 'Lieux' \n");
                                break;
                            default:
                                System.out.println("Une exception dans l'ajout de l'élément dans le tableau principal a été levée");
                        }
                        System.out.println(ajout + " a été ajouté au tableaux 'carte indice' de " + nomJoueurs.get(spinal) + "\n");
                    }
                } 



// Par exemple dans ce cas là on appelle précis
                
                //if (param[] == {2,0,2,5,0,1,"0",5, index td, 0, index tatsu, index jago, index == nbJoueurs 
                //
                //paramMe[2]= {1,0}
                //paramAsker[2] = {0,3}
                //paramFirstInList = {5,1}
                //paraSecondInList = {1,2}
                //paramThirdInList = {5,4}
               // return param [5][2];
                //paramGeneral = {No[i],Me[i],Other[i],pMe[0], pAsker[0], pFirst[0],pSecond[0],pThrid[0]}//
               // {
             // if blablablablablablablabla { joueur.get(pAsker[1]).addWeapon(arme[i]);)
              //  else if blablablablablabla{ joueur.get(pSecond[1]).addSuspect(suspect[i]);}
           // }
                
                // Ordre d'apparition des index des joueurs "other" en respectant l'ordre croissant
                // Ici l'indice Spinal est PLUS GRAND que l'indice tatsu
                // @ param (2 , 0 , 2  0, 0, 
                else if (other == 2 && my == 0
                        && (spinal < 5 && jago == 5)
                        && tatsu < 5 && tatsu != 0
                        && !(hasCard[td].contains(arm[anda])
                        && hasCard[td].contains(suz[anne])
                        && hasCard[td].contains(pie[rre]))) {

                    System.out.println(" BIENVENU DANS LE BRANCHEMENT S 2.2# Spinal !!!!!! \n");

                    if (hasCard[tatsu].contains(arme[i])) {
                        hasNotCard[td].add(arm[anda]);
                        hasNotCard[spinal].add(arm[anda]);

                    } else if (hasCard[tatsu].contains(suz[anne])) {
                        hasNotCard[td].add(suz[anne]);
                        hasNotCard[spinal].add(suz[anne]);

                    } else if (hasCard[tatsu].contains(pie[rre])) {
                        hasNotCard[td].add(pie[rre]);
                        hasNotCard[spinal].add(pie[rre]);
                    }

                    if (hasNotCard[spinal].contains(suz[anne]) && hasNotCard[spinal].contains(arm[anda])) {
                        ajoutMax = pie[rre];
                        hasCard[spinal].add(pie[rre]);
                        Lieux.add(pie[rre]);
                        LieuSet.add(pie[rre]);
                        System.out.println(ajoutMax + " a été ajouté au tableaux 'carte indice' de " + nomJoueurs.get(spinal) + "\n");

                    } else if (hasNotCard[spinal].contains(pie[rre]) && hasNotCard[spinal].contains(arm[anda])) {
                        ajoutMax = suz[anne];
                        hasCard[spinal].add(suz[anne]);
                        Suspects.add(suz[anne]);
                        SuspectSet.add(suz[anne]);
                        System.out.println(ajoutMax + " a été ajouté au tableaux 'carte indice' de " + nomJoueurs.get(spinal) + "\n");

                    } else if (hasNotCard[spinal].contains(pie[rre]) && hasNotCard[spinal].contains(suz[anne])) {
                        ajoutMax = arm[anda];
                        hasCard[spinal].add(arm[anda]);
                        Armes.add(arm[anda]);
                        ArmeSet.add(arm[anda]);
                        System.out.println(ajoutMax + " a été ajouté au tableaux 'carte indice' de " + nomJoueurs.get(spinal) + "\n");

                    }
                }
                


// Par exemple dans ce cas là on appelle précis
                //if (param[] == {2,0,2,   5,0,"0",1,5)
                // Ici l'indice Jago est toujours PLUS PETIT que l'indice tatsu
                
                
                else if (other == 2 && my == 0
                        && (jago < 5 && spinal == 5)
                        && tatsu < 5 && tatsu != 0
                        && !(hasCard[td].contains(arm[anda])
                        && hasCard[td].contains(suz[anne])
                        && hasCard[td].contains(pie[rre]))) {

                    System.out.println(" BIENVENU DANS LE BRANCHEMENT S 2.2# Jago !!!!!! \n");

                    if (hasCard[tatsu].contains(arm[anda])) {
                        hasNotCard[td].add(arm[anda]);
                        hasNotCard[jago].add(arm[anda]);

                    } else if (hasCard[tatsu].contains(suz[anne])) {
                        hasNotCard[td].add(suz[anne]);
                        hasNotCard[jago].add(suz[anne]);

                    } else if (hasCard[tatsu].contains(pie[rre])) {
                        hasNotCard[td].add(pie[rre]);
                        hasNotCard[jago].add(pie[rre]);
                    } else // AJOUTER AU TABLEAUX ARMES !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                    if (hasNotCard[jago].contains(suz[anne]) && hasNotCard[jago].contains(arm[anda])) {
                        ajoutMin = pie[rre];
                        hasCard[jago].add(pie[rre]);
                        Lieux.add(pie[rre]);
                        LieuSet.add(pie[rre]);
                        System.out.println(ajoutMin + " a été ajouté au tableaux 'carte indice' de " + nomJoueurs.get(jago) + "\n");

                    } else if (hasNotCard[jago].contains(pie[rre]) && hasNotCard[jago].contains(arm[anda])) {
                        ajoutMin = suz[anne];
                        hasCard[jago].add(suz[anne]);
                        Suspects.add(suz[anne]);
                        SuspectSet.add(suz[anne]);
                        System.out.println(ajoutMin + " a été ajouté au tableaux 'carte indice' de " + nomJoueurs.get(jago) + "\n");

                    } else if (hasNotCard[jago].contains(pie[rre]) && hasNotCard[jago].contains(suz[anne])) {
                        ajoutMin = arm[anda];
                        hasCard[jago].add(arm[anda]);
                        Lieux.add(arm[anda]);
                        LieuSet.add(arm[anda]);
                        System.out.println(ajoutMin + " a été ajouté au tableaux 'carte indice' de " + nomJoueurs.get(jago) + "\n");
                    }
                }
                

// Par exemple dans ce cas là on appelle précis
                //if (param[] == {2,0,2,       5,0,2,0,5)
                // if (param[] == {2,0,2,       5,0,0,2,5)
                // the spinal bit is missing here !!!!!!!!!!!!!!!!!!!!!!!!!!
                
                
                
                else if (other == 2 && my == 0
                        && hado < 5 && tatsu == 5
                        && tatsuma == 5 && jago < 5 && !(hasCard[td].contains(arm[anda])
                        && hasCard[td].contains(suz[anne])
                        && hasCard[td].contains(pie[rre]))) {

                    System.out.println(" BIENVENU DANS LE BRANCHEMENT S 2.2 classique !!!!!! \n");
                    contain = 0;
                    id = 0;

                    if (hasCard[hadoken].contains(arm[anda])) {
                        contain++;
                    } else {
                        ajout = arm[anda];
                        id = 0;
                    }

                    if (hasCard[hadoken].contains(suz[anne])) {
                        contain++;
                    } else {
                        ajout = suz[anne];
                        id = 1;
                    }

                    if (hasCard[hadoken].contains(pie[rre])) {
                        contain++;
                    } else {
                        ajout = pie[rre];
                        id = 2;
                    }

                    if (contain == 2) {
                        hasCard[jago].add(ajout);
                        hasNotCard[td].add(ajout);

                        switch (id) {

                            case 0:
                                Armes.add(ajout);
                                ArmeSet.add(ajout);
                                hasNotCard[jago].add(suz[anne]);
                                hasNotCard[jago].add(pie[rre]);
                                System.out.println(ajout + " a été ajouté au tableau 'Armes' !!! \n");
                                break;
                            case 1:
                                Suspects.add(ajout);
                                SuspectSet.add(ajout);
                                hasNotCard[jago].add(arm[anda]);
                                hasNotCard[jago].add(pie[rre]);
                                System.out.println(ajout + " a été ajouté au tableau 'Suspects' !!! \n");
                                break;
                            case 2:
                                Lieux.add(ajout);
                                LieuSet.add(ajout);
                                hasNotCard[jago].add(suz[anne]);
                                hasNotCard[jago].add(arm[anda]);
                                System.out.println(ajout + " a été ajouté au tableau 'Lieux' !!! \n");
                                break;
                            default:
                                System.out.println("Une exception dans l'ajout de l'élément dans le tableau principal a été levée");
                        }
                        System.out.println(ajout + " a été ajouté au tableaux 'carte indice' de " + nomJoueurs.get(shoryuken) + "\n");
                    }
                } 


                // if (param[] == {1,0,3,       5,0,0,0,0)   
                else if (other == 3 && jago < 5
                        && !nomJoueurs.get(td).equals(nomJoueurs.get(0))
                        && spinal < 5
                        && fulgore < 5) {

                    System.out.println(" BIENVENU DANS LE BRANCHEMENT S 3.0  !!!!!! \n");

                    Armes.add(arm[anda]);
                    ArmeSet.add(arm[anda]);
                    Suspects.add(suz[anne]);
                    SuspectSet.add(suz[anne]);
                    Lieux.add(pie[rre]);
                    LieuSet.add(pie[rre]);
                    hasNotCard[td].add(arm[anda]);
                    hasNotCard[td].add(suz[anne]);
                    hasNotCard[td].add(pie[rre]);
                    // jago actived, spinal actived, fulgore activated
                    System.out.println(armPimp[anda] + ", " + suzPimp[anne] + " et " + piePimp[rre] + " ont été ajouté au tableau principal!!! ");
                } 



                // if (param[] == {1,0,3,       5,0,1,0,0) 
                // if (param[] == {1,0,3,       5,0,0,1,0)
                // if (param[] == {1,0,3,       5,0,0,0,1)
                else if (other == 3
                        && tatsu < 5
                        && spinal < 5
                        && jago < 5
                        && !(hasCard[0].contains(arm[anda])
                        && hasCard[0].contains(suz[anne])
                        && hasCard[0].contains(pie[rre]))) {

                    System.out.println(" BIENVENU DANS LE BRANCHEMENT S 3.1  !!!!!! \n");

                    if (hasCard[tatsu].contains(arm[anda])) {

                        if (hasNotCard[spinal].contains(suz[anne])) {
                            hasCard[jago].add(suz[anne]);
                            System.out.println("la carte" + suzPimp[anne] + " a été ajoutée au tableau de " + nomJoueurs.get(jago) + " \n");
                            Suspects.add(suz[anne]);
                            SuspectSet.add(suz[anne]);

                        } else if (hasNotCard[spinal].contains(pie[rre])) {
                            hasCard[jago].add(pie[rre]);
                            System.out.println("la carte" + piePimp[rre] + " a été ajoutée au tableau de " + nomJoueurs.get(jago) + " \n");
                            Lieux.add(pie[rre]);
                            LieuSet.add(pie[rre]);

                        } else if (hasNotCard[jago].contains(suz[anne])) {
                            hasCard[spinal].add(suz[anne]);
                            System.out.println("la carte" + suzPimp[anne] + " a été ajoutée au tableau de " + nomJoueurs.get(spinal) + " \n");
                            Suspects.add(suz[anne]);
                            SuspectSet.add(suz[anne]);

                        } else if (hasNotCard[jago].contains(pie[rre])) {
                            hasCard[spinal].add(pie[rre]);
                            System.out.println("la carte" + piePimp[rre] + " a été ajoutée au tableau de " + nomJoueurs.get(spinal) + " \n");
                            Lieux.add(pie[rre]);
                            LieuSet.add(pie[rre]);
                        }
                    }

                    if (hasCard[tatsu].contains(suz[anne])) {

                        if (hasNotCard[spinal].contains(arm[anda])) {
                            hasCard[jago].add(arm[anda]);
                            System.out.println("la carte" + armPimp[anda] + " a été ajoutée au tableau de " + nomJoueurs.get(jago) + " \n");
                            Armes.add(arm[anda]);
                            ArmeSet.add(arm[anda]);

                        } else if (hasNotCard[spinal].contains(pie[rre])) {
                            hasCard[jago].add(pie[rre]);
                            System.out.println("la carte" + piePimp[rre] + " a été ajoutée au tableau de " + nomJoueurs.get(jago) + " \n");
                            Lieux.add(pie[rre]);
                            LieuSet.add(pie[rre]);

                        } else if (hasNotCard[jago].contains(arm[anda])) {
                            hasCard[spinal].add(arm[anda]);
                            System.out.println("la carte" + armPimp[anda] + " a été ajoutée au tableau de " + nomJoueurs.get(spinal) + " \n");
                            Armes.add(arm[anda]);
                            ArmeSet.add(arm[anda]);

                        } else if (hasNotCard[jago].contains(pie[rre])) {
                            hasCard[spinal].add(pie[rre]);
                            System.out.println("la carte" + piePimp[rre] + " a été ajoutée au tableau de " + nomJoueurs.get(spinal) + " \n");
                            Lieux.add(pie[rre]);
                            LieuSet.add(pie[rre]);
                        }
                    }

                    if (hasCard[tatsu].contains(pie[rre])) {

                        if (hasNotCard[spinal].contains(arm[anda])) {
                            hasCard[jago].add(arm[anda]);
                            System.out.println("la carte" + armPimp[anda] + " a été ajoutée au tableau de " + nomJoueurs.get(jago) + " \n");
                            Armes.add(arm[anda]);
                            ArmeSet.add(arm[anda]);

                        } else if (hasNotCard[spinal].contains(suz[anne])) {
                            hasCard[jago].add(suz[anne]);
                            System.out.println("la carte" + suzPimp[anne] + " a été ajoutée au tableau de " + nomJoueurs.get(jago) + " \n");
                            Suspects.add(suz[anne]);
                            SuspectSet.add(suz[anne]);

                        } else if (hasNotCard[jago].contains(arm[anda])) {
                            hasCard[spinal].add(arm[anda]);
                            System.out.println("la carte" + armPimp[anda] + " a été ajoutée au tableau de " + nomJoueurs.get(spinal) + " \n");
                            Armes.add(arm[anda]);
                            ArmeSet.add(arm[anda]);

                        } else if (hasNotCard[jago].contains(suz[anne])) {
                            hasCard[spinal].add(suz[anne]);
                            System.out.println("la carte" + suzPimp[anne] + " a été ajoutée au tableau de " + nomJoueurs.get(spinal) + " \n");
                            Suspects.add(suz[anne]);
                            SuspectSet.add(suz[anne]);
                        }
                    }
                } 

                // if (param[] == {1,1,2,       1,0,1,0,5)
                // if (param[] == {1,1,2,       1,0,0,1,5)
                
                else if (other == 2 && my == 1
                        && tatsu < 5 && tatsumy == 0
                        && tatsuma == 5 && jago < 5) {

                    System.out.println(" BIENVENU DANS LE BRANCHEMENT S 3.2 perso !!!!!! \n");

                    contain = 0;
                    containBis = 0;
                    id = 0;

                    if (hasCard[tatsu].contains(arm[anda])) {
                        hasNotCard[tatsu].add(pie[rre]);
                        hasNotCard[tatsu].add(suz[anne]);

                    } else if (hasCard[tatsumy].contains(arm[anda])) {
                        hasNotCard[tatsumy].add(pie[rre]);
                        hasNotCard[tatsumy].add(suz[anne]);

                    } else {
                        ajout = arm[anda];
                        hasCard[jago].add(arm[anda]);
                        id = 0;
                    }

                    if (hasCard[tatsu].contains(suz[anne])) {
                        hasNotCard[tatsu].add(pie[rre]);
                        hasNotCard[tatsu].add(arm[anda]);

                    } else if (hasCard[tatsumy].contains(suz[anne])) {
                        hasNotCard[tatsumy].add(pie[rre]);
                        hasNotCard[tatsumy].add(arm[anda]);

                    } else {
                        ajout = suz[anne];
                        hasCard[jago].add(suz[anne]);
                        id = 1;
                    }

                    if (hasCard[tatsu].contains(pie[rre])) {
                        hasNotCard[tatsu].add(arm[anda]);
                        hasNotCard[tatsu].add(suz[anne]);

                    } else if (hasCard[tatsumy].contains(pie[rre])) {
                        hasNotCard[tatsumy].add(arm[anda]);
                        hasNotCard[tatsumy].add(suz[anne]);
                    } else {
                        ajout = pie[rre];
                        hasCard[jago].add(pie[rre]);
                        id = 2;
                    }

                    switch (id) {

                        case 0:
                            Armes.add(ajout);
                            ArmeSet.add(ajout);
                            System.out.println(ajout + " a été ajouté au tableau 'Armes' !!! \n");
                            hasNotCard[jago].contains(pie[rre]);
                            hasNotCard[jago].contains(suz[anne]);
                            break;
                        case 1:
                            Suspects.add(ajout);
                            SuspectSet.add(ajout);
                            System.out.println(ajout + " a été ajouté au tableau 'Suspects' !!! \n");
                            hasNotCard[jago].contains(pie[rre]);
                            hasNotCard[jago].contains(arm[anda]);
                            break;
                        case 2:
                            Lieux.add(ajout);
                            LieuSet.add(ajout);
                            System.out.println(ajout + " a été ajouté au tableau 'Lieux' !!! \n");
                            hasNotCard[jago].contains(suz[anne]);
                            hasNotCard[jago].contains(arm[anda]);
                            break;
                        default:
                            System.out.println("Une exception dans l'ajout de l'élément dans le tableau principal a été levée");
                    }
                    System.out.println(ajout + " a été ajouté au tableaux 'carte indice' de " + nomJoueurs.get(jago) + "\n");
                } 


                
                
                
                // if (param[] == {1,0,3,       5,0,1,1,0)
                else if (other == 3 && tatsu < 5 && tatsuma < 5 && jago < 5) {

                    System.out.println(" BIENVENU DANS LE BRANCHEMENT S 3.2 classique  !!!!!! \n");

                    contain = 0;
                    containBis = 0;
                    id = 0;

                    if (hasCard[tatsu].contains(arm[anda])) {
                        hasNotCard[tatsu].add(pie[rre]);
                        hasNotCard[tatsu].add(suz[anne]);
                    } else if (hasCard[tatsuma].contains(arm[anda])) {
                        hasNotCard[tatsuma].add(pie[rre]);
                        hasNotCard[tatsuma].add(suz[anne]);
                    } else {
                        ajout = arm[anda];
                        hasCard[jago].add(arm[anda]);
                        id = 0;
                    }
                    if (hasCard[tatsu].contains(suz[anne])) {
                        hasNotCard[tatsu].add(pie[rre]);
                        hasNotCard[tatsu].add(arm[anda]);
                    } else if (hasCard[tatsuma].contains(suz[anne])) {
                        hasNotCard[tatsuma].add(pie[rre]);
                        hasNotCard[tatsuma].add(arm[anda]);
                    } else {
                        ajout = suz[anne];
                        hasCard[jago].add(suz[anne]);
                        id = 1;
                    }
                    if (hasCard[tatsu].contains(pie[rre])) {
                        hasNotCard[tatsu].add(arm[anda]);
                        hasNotCard[tatsu].add(suz[anne]);

                    } else if (hasCard[tatsuma].contains(pie[rre])) {
                        hasNotCard[tatsuma].add(arm[anda]);
                        hasNotCard[tatsuma].add(suz[anne]);
                    } else {
                        ajout = pie[rre];
                        hasCard[jago].add(pie[rre]);
                        id = 2;
                    }

                    switch (id) {

                        case 0:
                            Armes.add(ajout);
                            ArmeSet.add(ajout);
                            System.out.println(ajout + " a été ajouté au tableau 'Armes' !!! \n");
                            hasNotCard[jago].add(pie[rre]);
                            hasNotCard[jago].add(suz[anne]);
                            break;
                        case 1:
                            Suspects.add(ajout);
                            SuspectSet.add(ajout);
                            System.out.println(ajout + " a été ajouté au tableau 'Suspects' !!! \n");
                            hasNotCard[jago].add(pie[rre]);
                            hasNotCard[jago].add(arm[anda]);
                            break;
                        case 2:
                            Lieux.add(ajout);
                            LieuSet.add(ajout);
                            System.out.println(ajout + " a été ajouté au tableau 'Lieux' !!! \n");
                            hasNotCard[jago].add(suz[anne]);
                            hasNotCard[jago].add(arm[anda]);
                            break;
                        default:
                            System.out.println("Une exception dans l'ajout de l'élément dans le tableau principal a été levée");
                    }
                    System.out.println(ajout + " a été ajouté au tableaux 'carte indice' de " + nomJoueurs.get(jago) + "\n");
                } else {

                    System.out.println("aucune carte n'a été ajoutée au tableau !!!!! \n");
                }

            }
            t++;     // BOUCLE PRINCIPALE REPRESENTANT UN TOUR DE TABLE : DEMANDEUR, TEMOINS, ARMES, SUSPECTS, LIEUX, REPONSE.    

            for (int o = 1; o < hasCard[0].size(); o++) {

                hasNotCard[1].add(hasCard[0].get(o));
                hasNotCard[2].add(hasCard[0].get(o));
                hasNotCard[3].add(hasCard[0].get(o));
                hasNotCard[4].add(hasCard[0].get(o));
            }
            for (int o = 1; o < hasCard[1].size(); o++) {

                hasNotCard[0].add(hasCard[1].get(o));
                hasNotCard[2].add(hasCard[1].get(o));
                hasNotCard[3].add(hasCard[1].get(o));
                hasNotCard[4].add(hasCard[1].get(o));
            }
            for (int o = 1; o < hasCard[2].size(); o++) {

                hasNotCard[0].add(hasCard[2].get(o));
                hasNotCard[1].add(hasCard[2].get(o));
                hasNotCard[3].add(hasCard[2].get(o));
                hasNotCard[4].add(hasCard[2].get(o));
            }
            for (int o = 1; o < hasCard[3].size(); o++) {

                hasNotCard[0].add(hasCard[3].get(o));
                hasNotCard[1].add(hasCard[3].get(o));
                hasNotCard[2].add(hasCard[3].get(o));
                hasNotCard[4].add(hasCard[3].get(o));
            }
            for (int o = 1; o < hasCard[4].size(); o++) {

                hasNotCard[0].add(hasCard[4].get(o));
                hasNotCard[1].add(hasCard[4].get(o));
                hasNotCard[2].add(hasCard[4].get(o));
                hasNotCard[3].add(hasCard[4].get(o));
            }

            for (int u = 0; u < hasCard[0].size(); u++) {
                hasCardSet[0].add(hasCard[0].get(u));
            }
            for (int u = 0; u < hasCard[1].size(); u++) {
                hasCardSet[0].add(hasCard[1].get(u));
            }
            for (int u = 0; u < hasCard[2].size(); u++) {
                hasCardSet[0].add(hasCard[2].get(u));
            }
            for (int u = 0; u < hasCard[3].size(); u++) {
                hasCardSet[0].add(hasCard[3].get(u));
            }
            for (int u = 0; u < hasCard[4].size(); u++) {
                hasCardSet[0].add(hasCard[4].get(u));
            }

            System.out.println(nomJoueurs.get(1) + " n'a pas : " + hasNotCard[1]);
            System.out.println(nomJoueurs.get(2) + " n'a pas : " + hasNotCard[2]);
            System.out.println(nomJoueurs.get(3) + " n'a pas : " + hasNotCard[3]);
            System.out.println(nomJoueurs.get(4) + " n'a pas : " + hasNotCard[4]);
            System.out.println(" ");

            System.out.println(nomJoueurs.get(1) + " a  : " + hasCard[1]);
            System.out.println(nomJoueurs.get(2) + " a  : " + hasCard[2]);
            System.out.println(nomJoueurs.get(3) + " a  : " + hasCard[3]);
            System.out.println(nomJoueurs.get(4) + " a  : " + hasCard[4]);

            System.out.println("Voici les cartes Armes : " + ArmeSet.toString());
            System.out.println("Voici les cartes Suspects : " + SuspectSet.toString());
            System.out.println("Voici les cartes Lieux : " + LieuSet.toString());

            int g;
            int magic = 12;
            for (g = 0; g < arm.length; g++) {
                int enumerator = 0;
                for (int p = 0; p < nomJoueurs.size(); p++) {

                    if (hasNotCard[p].contains(arm[g])) {
                        enumerator++;
                    }
                    //5 enumerator 'true' veut dire que 5 personnes n'ont effectivement pas la carte en Question..
                    // Donc cette carte fait partie de la solution
                }
                if (enumerator == 5 && !solution.contains(arm[g])) {
                    System.out.println("YOUPI CA MARCHE, mais en fait ca marche pas cette m..... WEAPON!!!!!");
                    solution.add(arm[g]);
                    soluce.add(arm[g]);
                    magic = g;
                }
            }

            // on connait l'arme du crime donc on peut maintenant remplir le tabeau des armes en omettant l'arme du crime
            int r = 0;
            if (magic != 12) {
                while (r < arm.length) {
                    if (!arm[r].equals(arm[magic])) {
                        Armes.add(arm[r]);
                        ArmeSet.add(arm[r]);
                        r++;
                    } else {
                        r++;
                    }
                }
            }

            magic = 12;
            for (g = 0; g < suz.length; g++) {
                int enumerator = 0;
                for (int p = 0; p < nomJoueurs.size(); p++) {

                    if (hasNotCard[p].contains(suz[g])) {
                        enumerator++;

                    }
                }
                if (enumerator == 5 && !solution.contains(suz[g])) {
                    System.out.println("YOUPI CA MARCHE, mais en fait ca marche pas cette m..... SUSPECT!!!!!");
                    solution.add(suz[g]);
                    soluce.add(suz[g]);
                    magic = g;
                }
            }

            r = 0;
            if (magic != 12) {
                while (r < suz.length) {
                    if (!suz[r].equals(suz[magic])) {
                        Suspects.add(suz[r]);
                        SuspectSet.add(suz[r]);
                        r++;
                    } else {
                        r++;
                    }
                }
            }

            magic = 12;
            for (g = 0; g < pie.length; g++) {
                int enumerator = 0;
                for (int p = 0; p < nomJoueurs.size(); p++) {

                    if (hasNotCard[p].contains(pie[g])) {
                        enumerator++;
                    }
                }
                if (enumerator == 5 && !solution.contains(pie[g])) {
                    System.out.println("YOUPI CA MARCHE, mais en fait ca marche pas cette m..... ROOM!!!!!");
                    solution.add(pie[g]);
                    soluce.add(pie[g]);
                    magic = g;
                } else {

                }
            }

            r = 0;
            if (magic != 12) {
                while (r < pie.length) {
                    if (!pie[r].equals(pie[magic])) {
                        Lieux.add(pie[r]);
                        LieuSet.add(pie[r]);
                        r++;

                    } else {

                        r++;
                    }
                }
            }

            for (int n = 0; (ArmeSet.size() == Armes.size() && ArmeSet.size() == arm.length - 1 && n < arm.length - 1); n++) {
                armeTab = Armes.get(n);

                for (int s = 0; s < arm.length && !arm[s].equals(armeTab) && solution.contains(armeTab); s++) {
                    solution.add(armeTab);
                }
            }
            for (int n = 0; (SuspectSet.size() == Suspects.size() && SuspectSet.size() == suz.length - 1 && n < suz.length - 1); n++) {
                suspectTab = Suspects.get(n);

                for (int s = 0; s < suz.length && !suz[s].equals(suspectTab); s++) {
                    solution.add(suspectTab);
                }
            }
            for (int n = 0; (LieuSet.size() == Lieux.size() && LieuSet.size() == pie.length - 1 && n < pie.length - 1); n++) {
                lieuTab = Lieux.get(n);

                for (int s = 0; s < pie.length && !pie[s].equals(lieuTab); s++) {
                    solution.add(lieuTab);
                }
            }

            System.out.println(nomJoueurs.get(1) + " n'a pas : " + hasNotCard[1]);
            System.out.println(nomJoueurs.get(2) + " n'a pas : " + hasNotCard[2]);
            System.out.println(nomJoueurs.get(3) + " n'a pas : " + hasNotCard[3]);
            System.out.println(nomJoueurs.get(4) + " n'a pas : " + hasNotCard[4]);
            System.out.println(" ");

            System.out.println(nomJoueurs.get(1) + " a  : " + hasCard[1]);
            System.out.println(nomJoueurs.get(2) + " a  : " + hasCard[2]);
            System.out.println(nomJoueurs.get(3) + " a  : " + hasCard[3]);
            System.out.println(nomJoueurs.get(4) + " a  : " + hasCard[4]);

            System.out.println("Voici les cartes Armes : " + ArmeSet.toString());
            System.out.println("Voici les cartes Suspects : " + SuspectSet.toString());
            System.out.println("Voici les cartes Lieux : " + LieuSet.toString());

        }

        System.out.println("La solution a été trouvée !!!! \n le coupable est " + solution.get(1) + "\n l'arme du crime est le/la " + solution.get(0) + "\n Le lieux du crime est " + solution.get(2) + "\n]");

        System.out.println("Est-ce que vous souhaitez quitter le jeu ? (O/N)) \n");
        myScan.nextLine().charAt(0);
        myScan.nextLine();
        if (response == 'o') {
            Runtime.getRuntime().exit(0);
        }

*/
// JComboBox ligne 1
    /* public void setPlayers(JRadioButton check, int grid, boolean end, int insets) {
     constraint.gridx = grid;
     constraint.gridheight = 1;
     constraint.insets = new Insets(150, 0, 20, insets);

     check.setOpaque(false);
     if (end == true) {
     constraint.anchor = GridBagConstraints.LINE_START;
     constraint.insets = new Insets(150, 0, 20, insets);
     } else {
     constraint.anchor = GridBagConstraints.LINE_END;
     constraint.insets = new Insets(150, 0, 20, insets);
     }
     this.add(check, constraint);
     }
     */
    // JComboBox ligne 1
    /*
     public void setPlayerBox() {

     three = new JRadioButton("3", false);
     four = new JRadioButton("4", false);
     five = new JRadioButton("5", false);
     six = new JRadioButton("6", false);
     constraint.gridwidth = 1;
     this.setPlayers(three, 1, true, 0);
     this.setPlayers(four, 1, false, 0);
     this.setPlayers(five, 2, false, 0 );
     this.setPlayers(six, 3, false, 50);
     group = new ButtonGroup();
     group.add(three);
     group.add(four);
     group.add(five);
     group.add(six);
        
     }
     */
     // JTextField ligne 2
    /*
     public void setTextField(JTextField field) {
     constraint.gridheight = 1;
     constraint.gridx = 1;
     constraint.anchor = GridBagConstraints.LINE_START;
     constraint.insets = new Insets(0, 0, 23, 0);
     this.add(this.field, constraint);
     }
     */
   // JComboBox ligne 3 * 3 colonnes




    /* 
     public int getNumberOfPlayers() throws NullPointerException {
     int nbOfCards = 0;
     if (four.isSelected()) {
     String nb = four.getText();
     nbreJoueurs = Integer.parseInt(nb);
     } else if (five != null && five.isSelected()) {
     String nb = five.getText();
     nbreJoueurs = Integer.parseInt(nb);
     } else if (six != null && six.isSelected()) {
     String nb = six.getText();
     nbreJoueurs = Integer.parseInt(nb);
     } else if (three != null && three.isSelected()) {
     String nb = three.getText();
     nbreJoueurs = Integer.parseInt(nb);
     } else {
     throw new NullPointerException();
     }
     return nbreJoueurs;
     }
     */
    /*
     public String getFirstPlayerName() throws NullPointerException {
     joueur = field.getText();
     if (joueur == null) {
     throw new NullPointerException();
     } else {
     return joueur;
     }
     }
     */

/* SECOND VIEW CODE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!





// Pour le boutton Log : hypo[i] + joueurs.get(index) + joueurs.get(jago)
                // Pour le boutton Log en cas de index == 0 : hypo[i] + moi + joueurs.get(jago+1) +getAnswer();
                System.out.println("tour est egal à : " + tour);
                System.out.println("arme est egal à : " + ar);
                System.out.println("suspect est egal à : " + su);
                System.out.println("lieu est egal à : " + li);
                System.out.println("j'ai montré : " + montree + " cartes");
                System.out.println("Je possède " + connues + " cartes hypothèses");
                System.out.println("Mon index est le " + myIndex);
                System.out.println("l'indice demandeur est : " + askIndex);
                System.out.println("l'indice first est : " + firstIndex);
                System.out.println("le joueur 1 a montré : " + first + " carte");
                System.out.println("L'indice second est : " + secondIndex);
                System.out.println("le joueur 2 a montré : " + second + " carte");
                System.out.println("l'indice third est : " + thirdIndex);
                System.out.println("la personne qui a montré sa carte est : " + nom);
                System.out.println("Jago a le numéro : " + jago);
                System.out.println("le joueur 3 a montré : " + third + " carte");
                // ENORME ERREUR A PARTIR D'ICI !!!!!!!!!!!!!!!
                System.out.println(show[0]);
                System.out.println(show[1]);
                System.out.println(show[2]);
                System.out.println(show[3]);
                System.out.println(noms.get(0));
                System.out.println(noms.get(1));
                System.out.println(noms.get(2));
                System.out.println(noms.get(3));
                System.out.println(noms.get(4));
                System.out.println(noms.get(1).equals(nom));
                // n'oubli pas que game est un gameData et pas le gameDataFive que tu n'as  initialiser nulle part

                System.out.println(joueurs.get(0));
                System.out.println(joueurs.get(1));
                System.out.println(joueurs.get(2));
                System.out.println(joueurs.get(3));
                System.out.println(joueurs.get(4));
}
*/



/*
public int getNbOccurences(int i, int ask, int first, int second, int third) {
        int val = i;

        if (i == ask) {
            val = i++;
        } else if (i == first) {
            val = i += 2;
        } else if (i == second) {
            val = i += 3;
        } else if (i == third) {
            val = i += 4;
        }
        return val;
    }
*/

/*
                System.out.println("tour est egal à : " + motor);
                System.out.println("arme est egal à : " + ar);
                System.out.println("suspect est egal à : " + su);
                System.out.println("lieu est egal à : " + li);
                System.out.println("j'ai montré : " + montree + " cartes");
                System.out.println("Je possède " + connues + " cartes hypothèses");
                System.out.println("Mon index est le " + myIndex);
                System.out.println("l'indice demandeur est : " + askIndex);
                System.out.println("l'indice first est : " + firstIndex);
                System.out.println("le joueur 1 a montré : " + first + " carte");
                System.out.println("L'indice second est : " + secondIndex);
                System.out.println("le joueur 2 a montré : " + second + " carte");
                System.out.println("l'indice third est : " + thirdIndex);
                System.out.println("la personne qui a montré sa carte est : " + nom);
                System.out.println("Jago a le numéro : " + jago);
                System.out.println("le joueur 3 a montré : " + third + " carte");
                System.out.println("L'indice other est egal à : "+ other);
                // ENORME ERREUR A PARTIR D'ICI !!!!!!!!!!!!!!!
                System.out.println(show[0]);
                System.out.println(show[1]);
                System.out.println(show[2]);
                System.out.println(show[3]+"\n");
 */  


 /*    
                System.out.println("!!!!!!!!!!!!!!!!!!!APRES LA BOUCLE !!!!!!!!!!!!!!!!!!!!\n");
                System.out.println("Liste de mes cartes \n");
                          
                System.out.println("Liste des cartes d'ABDEL KADER \n");
                for (String v : listTwo){
                    System.out.println(v);
                }
                System.out.println("\n");
                for (String v : listNotTwo){
                    System.out.println(v);
                }               
                System.out.println("Liste des cartes de TOMASO \n");
                for (String v : listThree){
                    System.out.println(v);
                }
                System.out.println("\n");
                for (String v : listNotThree){
                    System.out.println(v);
                }
                System.out.println("Liste des cartes de MOKTHAR \n");              
                for (String v : listFour){
                    System.out.println(v);
                }
                System.out.println("\n");
                for (String v : listNotFour){
                    System.out.println(v);
                }   
                System.out.println("Liste des cartes d'AURELIEN \n");               
                for (String v : listFive){
                    System.out.println(v);
                }
                System.out.println("\n");
                for (String v : listNotFive){
                    System.out.println(v);
                }   
              */
                
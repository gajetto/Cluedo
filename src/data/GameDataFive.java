/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Ludovic
 */
public class GameDataFive extends GameData {

    private int nbreJoueurs;
    private GameData game;
    private String sentence;

    public GameDataFive() {
        super();
    }

 
// neinNein (2 cartes non détenues par "Jago"), ultra ( 2 solution), miFigue (1 solution et une carte non détenue)
// remonter le String jusqu'à Initialize;
    @Override
    public String launchNone() {
        System.out.println("J'entre dans Aucune carte connue");
        String retour  = null;
        Player Jago = null;
        if (jago < 5){
        Jago = this.joueurs.get(jago);
        }
        Player Me =  this.joueurs.get(0);
        Player Asker = this.joueurs.get(askIndex);
       
        if (other == 0 && ask == 0 && connues == 0) {
            retour = this.noPainNoGain();
        } 
        else if (other == 1 && Jago.hasNotTwoCards(ar, su, li)) {
            retour = this.neinNein(Jago, Asker);
        } 
        else if (other == 1 && Jago.hasNotOneCard(ar, su, li) && solution.size() == 1) {
            retour = this.miFigue(Jago, Asker);

        } 
        else if (other == 1 && solution.size() == 2) {
            retour = this.okiDoki(Jago, Asker);
        }
        else{
            retour = this.noPainNoGain();
        }
        return retour;

    }

        
    public String noPainNoGain() {
        trio = this.getTrioIndex(ar, su, li);
        String suite = this.getSuspicious(ar, su , li);
        String phrase = this.addSolution(ar, su, li);
        return   phrase  + suite;
    }

    public String neinNein(Player Jago, Player Asker) {
        String sentence = null;
        String phrase = null;
        if (Jago.hasNotWeapon(ar) && Jago.hasNotSuspect(su)) {
            phrase = this.addingPlace(Jago, Asker,jago);
        } else if (Jago.hasNotWeapon(ar) && Jago.hasNotPlace(li)) {
            phrase = this.addingSuspect(Jago, Asker,jago);
        } else if (Jago.hasNotSuspect(su) && Jago.hasNotPlace(li)) {
            phrase = this.addingWeapon(Jago, Asker, jago);
        }
        sentence = this.noPainNoGain();
        System.out.println(sentence + phrase);
        return sentence + phrase;
    }

    public String miFigue(Player Jago, Player Asker) {
        String sentence = null;
        String phrase = null;
        if (Jago.hasNotWeapon(ar) && this.isSolution(su)) {
            phrase = this.addingPlace(Jago, Asker,jago);
        } else if (Jago.hasNotWeapon(ar) && this.isSolution(li)) {
            phrase = this.addingSuspect(Jago, Asker,jago);
        } else if (Jago.hasNotSuspect(su) && this.isSolution(li)) {
            phrase = this.addingWeapon(Jago, Asker, jago);
        } else if (Jago.hasNotSuspect(su) && this.isSolution(ar)) {
            phrase = this.addingPlace(Jago, Asker,jago);
        } else if (Jago.hasNotPlace(li) && this.isSolution(ar)) {
            phrase = this.addingSuspect(Jago, Asker,jago);
        } else if (Jago.hasNotPlace(li) && this.isSolution(su)) {
            phrase = this.addingWeapon(Jago, Asker, jago);
        }       
        sentence = this.noPainNoGain();
        // System.out.println(sentence + phrase);
        return sentence + phrase;
    }

    public String okiDoki(Player Jago, Player Asker) {
        String sentence = null;
        String phrase = null;
        if (this.isSolution(ar) && this.isSolution(su)) {
            phrase = this.addingPlace(Jago, Asker,jago);
        } else if (this.isSolution(ar) && this.isSolution(li)) {
            phrase = this.addingSuspect(Jago, Asker,jago);
        } else if (this.isSolution(su) && this.isSolution(li)) {
            phrase = this.addingWeapon(Jago, Asker, jago);
        }        
        sentence = this.noPainNoGain();
       // System.out.println(sentence + phrase);
        return sentence + phrase;

    }

    // reserver pour searchForTriune else if (my == 3 && other == 0){
    // this.oneToAll(tab, hypo);
    //}
    // Définir et initialiser la variable ' Fulgore' dans gameData !!!!!
    
    public String launchSingle() {       
        System.out.println("J'entre dans Une carte connue");
        Player Jago = null;
        Player Spinal = null;
        Player Fulgore = null;
        System.out.println("valeur de l'indice jago : " + jago + "\n");
        if (jago < 5){
        Jago = this.joueurs.get(jago);
        }
        Player Me =  this.joueurs.get(0);
        Player Asker = this.joueurs.get(askIndex);
        
        if (tatsu < 5){
        Spinal = this.joueurs.get(tatsu);
        }
        if (tatsuma < 5){
        Fulgore = this.joueurs.get(tatsuma);
        }
        String retour = null;
        
        if ((other == 0 && ask == 1 && connues == 0)
                || (other == 0 && connues == 1 && ask == 0)) {
            retour = this.noPainNoGain();
        } // 
        else if (connues == 0 && other == 1 && ask == 1 && solution.size() == 0) {
             retour = this.accuserMinus(Asker, Jago, jago);
             
        } else if (connues == 1 && other == 1 && ask == 0 && solution.size() == 0) {
             retour = this.selfMinus(Me,Asker, Jago, jago);
             
        } else if (connues == 0 && other == 1 && ask == 0 && tatsu < 5 && solution.size() == 0) {
             retour = this.tatsuMinus(Asker, Spinal, Jago, jago);
             
        } else if (connues == 0 && other == 1 && ask == 0 && tatsuma < 5 && solution.size() == 0) {
             retour = this.tatsumaMinus(Asker,Fulgore, Jago, jago);
             
        } else if (connues == 0 && other == 1 && ask == 1 && solution.size() == 1) {
             retour = this.accuserPlus(Asker, Jago, jago);
             
        } else if (connues == 1 && other == 1 && ask == 0 && solution.size() == 1) {
             retour = this.selfPlus(Me, Asker, Jago, jago);
             
        } else if (connues == 0 && other == 1 && ask == 0 && tatsu < 5 && solution.size() == 1) {
             retour = this.tatsuPlus(Asker,Spinal, Jago, jago);
             
        } else if (connues == 0 && other == 1 && ask == 0 && tatsuma < 5 && solution.size() == 1) {
             retour = this.tatsumaPlus(Asker, Fulgore, Jago, jago);
             
        }
        else{
            retour = this.noPainNoGain();
            System.out.println(retour);
        }
        return retour;
    }

    public String accuserMinus(Player Asker, Player Jago, int jago) {
        String phrase = null;
         System.out.println("Entered accuserMinus...");
        if (Asker.hasWeapon(ar) && Jago.hasNotSuspect(su)) {
            phrase = this.addingPlace(Jago, Asker,jago);           
        } else if (Asker.hasSuspect(su) && Jago.hasNotWeapon(ar)) {
            phrase = this.addingPlace(Jago, Asker,jago);         
        } else if (Asker.hasSuspect(su) && Jago.hasNotPlace(li)) {
            phrase = this.addingWeapon(Jago, Asker, jago);                    
        } else if (Asker.hasPlace(li) && Jago.hasNotSuspect(su)) {
            phrase = this.addingWeapon(Jago, Asker, jago);
        } else if (Asker.hasPlace(li) && Jago.hasNotWeapon(ar)) {
            phrase = this.addingSuspect(Jago, Asker,jago);                       
        } else if (Asker.hasWeapon(ar) && Jago.hasNotPlace(li)) {
            phrase = this.addingSuspect(Jago, Asker,jago);            
        }        
        sentence = this.noPainNoGain();
        //System.out.println(sentence + phrase);
        return sentence + phrase;
    }

    
    public String selfMinus(Player Me, Player Asker, Player Jago, int jago) {
        String phrase = null;
        
        System.out.println("you entered selfMinus");
        
        if (Me.hasWeapon(ar) && Jago.hasNotSuspect(su)) {
            phrase = this.addingPlace(Jago, Asker,jago);           
        } else if (Me.hasSuspect(su) && Jago.hasNotWeapon(ar)) {
            phrase = this.addingPlace(Jago, Asker,jago);         
        } else if (Me.hasSuspect(su) && Jago.hasNotPlace(li)) {
            phrase = this.addingWeapon(Jago, Asker, jago);                    
        } else if (Me.hasPlace(li) && Jago.hasNotSuspect(su)) {
            phrase = this.addingWeapon(Jago, Asker, jago);
        } else if (Me.hasPlace(li) && Jago.hasNotWeapon(ar)) {
            phrase = this.addingSuspect(Jago, Asker,jago);                       
        } else if (Me.hasWeapon(ar) && Jago.hasNotPlace(li)) {
            phrase = this.addingSuspect(Jago, Asker,jago);            
        } 
        sentence = this.noPainNoGain();
        return sentence + phrase;
    }

    
    
    
    public String tatsuMinus(Player Asker, Player Spinal, Player Jago, int jago) {
        String phrase = null;               
        System.out.println("You entered tatsuMinus");
        if (Spinal.hasWeapon(ar) && Jago.hasNotSuspect(su)) {
            phrase = this.addingPlace(Jago, Asker, jago);         
        } else if (Spinal.hasSuspect(su) && Jago.hasNotWeapon(ar)) {
            phrase = this.addingPlace(Jago, Asker, jago);     
        } else if (Spinal.hasSuspect(su) && Jago.hasNotPlace(li)) {
            phrase = this.addingWeapon(Jago, Asker, jago);       
        } else if (Spinal.hasPlace(li) && Jago.hasNotSuspect(su)) {
            phrase = this.addingWeapon(Jago, Asker,jago);
        } else if (Spinal.hasPlace(li) && Jago.hasNotWeapon(ar)) {
            phrase = this.addingSuspect(Jago, Asker,jago);       
        } else if (Spinal.hasWeapon(ar) && Jago.hasNotPlace(li)) {
            phrase = this.addingSuspect(Jago, Asker,jago);       
        } 
        sentence = this.noPainNoGain();
        return sentence + phrase;
    }
    
    

    public String tatsumaMinus(Player Asker,Player Fulgore, Player Jago, int jago) {
        String phrase = null;
        System.out.println("you entered tatsumaMinus");
        if (Fulgore.hasWeapon(ar) && Jago.hasNotSuspect(su)) {
            phrase = this.addingPlace(Jago, Asker, jago);         
        } else if (Fulgore.hasSuspect(su) && Jago.hasNotWeapon(ar)) {
            phrase = this.addingPlace(Jago, Asker, jago);     
        } else if (Fulgore.hasSuspect(su) && Jago.hasNotPlace(li)) {
            phrase = this.addingWeapon(Jago, Asker, jago);       
        } else if (Fulgore.hasPlace(li) && Jago.hasNotSuspect(su)) {
            phrase = this.addingWeapon(Jago, Asker,jago);
        } else if (Fulgore.hasPlace(li) && Jago.hasNotWeapon(ar)) {
            phrase = this.addingSuspect(Jago, Asker,jago);       
        } else if (Fulgore.hasWeapon(ar) && Jago.hasNotPlace(li)) {
            phrase = this.addingSuspect(Jago, Asker,jago);       
        }          
        sentence = this.noPainNoGain();
        return sentence + phrase;
    }

    public String accuserPlus(Player Asker, Player Jago, int jago) {
        String phrase = null;
        
        System.out.println("you entered AccuserPlus");
        if (Asker.hasWeapon(ar) && isSolution(su)) {
            phrase = this.addingPlace(Jago, Asker,jago);
        } else if (Asker.hasSuspect(su) && isSolution(ar)) {
        phrase = this.addingPlace(Jago, Asker,jago);     
        } else if (Asker.hasPlace(li) && isSolution(su)) {
            phrase = this.addingWeapon(Jago, Asker, jago);                      
        } else if (Asker.hasSuspect(su) && isSolution(li)) {
            phrase = this.addingWeapon(Jago, Asker, jago);                        
        } else if (Asker.hasPlace(li) && isSolution(ar)) {
            phrase = this.addingSuspect(Jago, Asker,jago);                      
        } else if (Asker.hasWeapon(ar) && isSolution(li)) {
            phrase = this.addingSuspect(Jago, Asker,jago);
            
            
        }
        sentence = this.noPainNoGain();
        return sentence + phrase;
    }

    
    
    
    public String selfPlus(Player Me, Player Asker, Player Jago, int jago) {
        String phrase = null;
        
        System.out.println("you entered SelfPlus");
        if (Me.hasWeapon(ar) && isSolution(su)) {
            phrase = this.addingPlace(Jago, Asker,jago);
        } else if (Me.hasSuspect(su) && isSolution(ar)) {
            phrase = this.addingPlace(Jago, Asker,jago);
        } else if (Me.hasPlace(li) && isSolution(su)) {
            phrase = this.addingWeapon(Jago, Asker, jago);
        } else if (Me.hasSuspect(su) && isSolution(li)) {
            phrase = this.addingWeapon(Jago, Asker, jago);
        }  else if (Me.hasPlace(li) && isSolution(ar)) {
            phrase = this.addingSuspect(Jago, Asker,jago);
        } else if (Me.hasWeapon(ar) && isSolution(li)) {
            phrase = this.addingSuspect(Jago, Asker,jago);
        }
        sentence = this.noPainNoGain();
        return sentence + phrase;
    }

    public String tatsuPlus(Player Asker,Player Spinal, Player Jago, int jago) {
        String phrase = null;
        
        System.out.println("you entered OtherPlus Method");
        if (Spinal.hasWeapon(ar) && isSolution(su)) {
            phrase = this.addingPlace(Jago, Asker,jago);
        } else if (Spinal.hasSuspect(su) && isSolution(ar)) {
            phrase = this.addingPlace(Jago, Asker,jago);
        } else if (Spinal.hasPlace(li) && isSolution(su)) {
            phrase = this.addingWeapon(Jago, Asker, jago);
        } else if (Spinal.hasSuspect(su) && isSolution(li)) {
            phrase = this.addingWeapon(Jago, Asker, jago);
        }  else if (Spinal.hasPlace(li) && isSolution(ar)) {
            phrase = this.addingSuspect(Jago, Asker,jago);
        } else if (Spinal.hasWeapon(ar) && isSolution(li)) {
            phrase = this.addingSuspect(Jago, Asker,jago);
        }
        sentence = this.noPainNoGain();
        return sentence + phrase;
    }

    public String tatsumaPlus( Player Asker,Player Fulgore, Player Jago, int jago) {
        String phrase = null;
        
        System.out.println("you entered OtherPlus Method");
        if (Fulgore.hasWeapon(ar) && isSolution(su)) {
            phrase = this.addingPlace(Jago, Asker,jago);
        } else if (Fulgore.hasSuspect(su) && isSolution(ar)) {
            phrase = this.addingPlace(Jago, Asker,jago);
        } else if (Fulgore.hasPlace(li) && isSolution(su)) {
            phrase = this.addingWeapon(Jago, Asker, jago);
        } else if (Fulgore.hasSuspect(su) && isSolution(li)) {
            phrase = this.addingWeapon(Jago, Asker, jago);
        }  else if (Fulgore.hasPlace(li) && isSolution(ar)) {
            phrase = this.addingSuspect(Jago, Asker,jago);
        } else if (Fulgore.hasWeapon(ar) && isSolution(li)) {
            phrase = this.addingSuspect(Jago, Asker,jago);
        }
        sentence = this.noPainNoGain();
        return sentence + phrase;
    }

    // accusers (2 cartes accusateurs) accuserSelf ( accusateur + moi)  selves (2 cartes m'appartenant)7
    // accuserOthers others selfOther
    // !!!!!!! CREER UNE VARIABLE TATSUMAKI QUI CORRESPOND A UNE PERSONNE QUI NE MONTRE PAS SA CARTE
    // MAIS QUI POSSEDE UNE OU PLUSIEURS DES CARTES HYPOTHESES ( CELA ETAIT IMPOSSIBLE DANS LA DISPOSITION DE JEU
    // ANTERIEURE OU CHACUN ETAIT TENU DE SORTIR LA CARTE HYPOTHESE DE SON JEU.
    
    
    
    public String launchDouble() {
        System.out.println("J'entre dans 2 cartes connues");
        listKiller = this.getListKiller(tab);
        String retour = null;
        Player Jago = null;
        Player Spinal = null;
        Player Fulgore = null;
        if (jago < 5){
        Jago = this.joueurs.get(jago);
        }
        Player Me =  this.joueurs.get(0);
        Player Asker = this.joueurs.get(askIndex);
        
        if (tatsu < 5){
        Spinal = this.joueurs.get(tatsu);
        }
        if (tatsuma < 5){
        Fulgore = this.joueurs.get(tatsuma);
        }
        
        
        
        if ((other == 0 && ask == 2)
                || (other == 0 && connues == 1 && ask == 1)
                || (other == 0 && connues == 2 && ask == 0)) {
            System.out.println("noPainNoGain");
             retour = this.noPainNoGain();
        } 
        else if (other == 1 && connues == 0 && ask == 2) {
             retour = this.accusers(Asker, Jago, jago);
             System.out.println("accusers");
        } else if (other == 1 && connues == 1 && ask == 1) {
             retour = this.accuserSelf(Me,Asker, Jago, jago);
             System.out.println("accuserSelf");
        } else if (other == 1 && connues == 0 && ask == 1 && tatsu < 5 && tatsuma == 5) {
             retour = this.accuserTatsu(Asker, Spinal, Jago, jago);
             System.out.println("accuserTatsu");
        } else if (other == 1 && connues == 0 && ask == 1 && tatsu == 5 && tatsuma < 5) {
             retour = this.accuserTatsuma(Asker,Fulgore, Jago, jago);
             System.out.println("accuserTatsuma");
        } else if (other == 1 && connues == 2 && ask == 0) {
             retour = this.selves(Me,Asker, Jago, jago);
             System.out.println("selves");
             System.out.println("l'indice jago devrait être égal à 3 et il est égal à : " + jago);
        } else if (other == 1 && connues == 1 && ask == 0 && tatsu <5 && tatsuma == 5) {
             retour = this.selfTatsu(Me,Asker, Spinal, Jago, jago);
             System.out.println("selfTatsu");
        } else if (other == 1 && connues == 1 && ask == 0 && tatsu == 5 && tatsuma < 5) {
             retour = this.selfTatsuma(Me,Asker,Fulgore, Jago, jago);
             System.out.println("selfTatsuma");
        } else if (other == 1 && connues == 0 && ask == 0 && tatsuHadoken < 5) {
             retour = this.tatsuHadoken(Asker,Spinal, Jago, jago);
             System.out.println("tatsuHadoken");
        } else if (other == 1 && connues == 0 && ask == 0 && tatsumaHadoken < 5) {
             retour = this.tatsumaHadoken(Asker,Fulgore, Jago, jago);
             System.out.println("tatsumaHadoken");
        } else if (other == 1 && connues == 0 && ask == 0 && tatsu < 5 && tatsuma < 5) {
             retour = this.splitHadoken(Asker,Spinal,Fulgore, Jago, jago);
             System.out.println("splitHadoken");
        }
        else{
            retour = this.noPainNoGain();
            System.out.println(retour);
        }
        return retour;
    }

    public String accusers(Player Asker, Player Jago, int jago) {
         
        String phrase = null;
        if (Asker.hasWeapon(ar) && Asker.hasSuspect(su)) {
            phrase = this.addingPlace(Jago, Asker, jago);
        } else if (Asker.hasWeapon(ar) && Asker.hasPlace(li)) {
            phrase = this.addingSuspect(Jago, Asker, jago);
        } else if (Asker.hasPlace(li) && Asker.hasSuspect(su)) {
            phrase = this.addingWeapon(Jago, Asker, jago);
        }
        sentence = this.noPainNoGain();
         System.out.println(sentence + phrase);
        return sentence + phrase;
    }

    public String accuserSelf(Player Me, Player Asker, Player Jago, int jago) {
       
       
        String phrase = null;

        if (Asker.hasWeapon(ar) && Me.hasSuspect(su)) {
            phrase = this.addingPlace(Jago, Asker, jago);
        } else if (Me.hasWeapon(ar) && Asker.hasSuspect(su)) {
            phrase = this.addingPlace(Jago, Asker, jago);
        } else if (Me.hasWeapon(ar) && Asker.hasPlace(li)) {
            phrase = this.addingSuspect(Jago, Asker, jago);
        } else if (Asker.hasWeapon(ar) && Me.hasPlace(li)) {
            phrase = this.addingSuspect(Jago, Asker, jago);
        } else if (Asker.hasSuspect(su) && Me.hasPlace(li)) {
            phrase = this.addingWeapon(Jago, Asker, jago);
        } else if (Me.hasSuspect(su) && Asker.hasPlace(li)) {
            phrase = this.addingWeapon(Jago, Asker, jago);
        }
        sentence = this.noPainNoGain();
         System.out.println(sentence + phrase);
        return sentence + phrase;
    }

    public String accuserTatsu(Player Asker, Player Spinal, Player Jago , int jago) {
        
        String phrase = null;
        if (Asker.hasWeapon(ar) && Spinal.hasSuspect(su)) {
            phrase = this.addingPlace(Jago, Asker, jago);
        } else if (Spinal.hasWeapon(ar) && Asker.hasSuspect(su)) {
            phrase = this.addingPlace(Jago, Asker, jago);
        } else if (Spinal.hasWeapon(ar) && Asker.hasPlace(li)) {
            phrase = this.addingSuspect(Jago, Asker, jago);
        } else if (Asker.hasWeapon(ar) && Spinal.hasPlace(li)) {
            phrase = this.addingSuspect(Jago, Asker, jago);
        } else if (Asker.hasSuspect(su) && Spinal.hasPlace(li)) {
            phrase = this.addingWeapon(Jago, Asker, jago);
        } else if (Spinal.hasSuspect(su) && Asker.hasPlace(li)) {
            phrase = this.addingWeapon(Jago, Asker, jago);
        }
        sentence = this.noPainNoGain();
         System.out.println(sentence + phrase);
        return sentence + phrase;
    }

    public String accuserTatsuma(Player Asker, Player Fulgore, Player Jago, int jago) {
        
        String phrase = null;
        if (Asker.hasWeapon(ar) && Fulgore.hasSuspect(su)) {
            phrase = this.addingPlace(Jago, Asker, jago);
        } else if (Fulgore.hasWeapon(ar) && Asker.hasSuspect(su)) {
            phrase = this.addingPlace(Jago, Asker, jago);
        } else if (Fulgore.hasWeapon(ar) && Asker.hasPlace(li)) {
            phrase = this.addingSuspect(Jago, Asker, jago);
        } else if (Asker.hasWeapon(ar) && Fulgore.hasPlace(li)) {
            phrase = this.addingSuspect(Jago, Asker, jago);
        } else if (Asker.hasSuspect(su) && Fulgore.hasPlace(li)) {
            phrase = this.addingWeapon(Jago, Asker, jago);
        } else if (Fulgore.hasSuspect(su) && Asker.hasPlace(li)) {
            phrase = this.addingWeapon(Jago, Asker, jago);
        }
        sentence = this.noPainNoGain();
         System.out.println(sentence + phrase);
        return sentence + phrase;
    }

    // already
    public String selves(Player Me,Player Asker, Player Jago, int jago) {
        
      
        String phrase = null;
        if (Me.hasWeapon(ar) && Me.hasSuspect(su)) {
            phrase = this.addingPlace(Jago, Asker, jago);
        } else if (Me.hasWeapon(ar) && Me.hasPlace(li)) {
            phrase = this.addingSuspect(Jago, Asker, jago);
            System.out.println("Ca te dirait d'entrer dans ce branchement fieffé connard ??!!!!");
        } else if (Me.hasPlace(li) && Me.hasSuspect(su)) {
            phrase = this.addingWeapon(Jago, Asker, jago);
        }
        sentence = this.noPainNoGain();
         System.out.println(sentence + phrase);
        return sentence + phrase;
    }

    public String selfTatsu(Player Me,Player Asker, Player Spinal, Player Jago, int jago) {
       
        String phrase = null;
        if (Me.hasWeapon(ar) && Spinal.hasSuspect(su)) {
            phrase = this.addingPlace(Jago, Asker, jago);           
        } else if (Spinal.hasWeapon(ar) && Me.hasSuspect(su)) {
            phrase = this.addingPlace(Jago, Asker, jago);            
        } else if (Spinal.hasWeapon(ar) && Me.hasPlace(li)) {
            phrase = this.addingSuspect(Jago, Asker, jago);           
        } else if (Me.hasWeapon(ar) && Spinal.hasPlace(li)) {
            phrase = this.addingSuspect(Jago, Asker, jago);            
        } else if (Me.hasSuspect(su) && Spinal.hasPlace(li)) {
            phrase = this.addingWeapon(Jago, Asker, jago);            
        } else if (Spinal.hasSuspect(su) && Me.hasPlace(li)) {
            phrase = this.addingWeapon(Jago, Asker, jago);            
        }
        sentence = this.noPainNoGain();
         System.out.println(sentence + phrase);
        return sentence + phrase;
    }

    public String selfTatsuma(Player Me,Player Asker,Player Fulgore, Player Jago, int jago) {
        String phrase = null;
        if (Me.hasWeapon(ar) && Fulgore.hasSuspect(su)) {
            phrase = this.addingPlace(Jago, Asker, jago);           
        } else if (Fulgore.hasWeapon(ar) && Me.hasSuspect(su)) {
            phrase = this.addingPlace(Jago, Asker, jago);            
        } else if (Fulgore.hasWeapon(ar) && Me.hasPlace(li)) {
            phrase = this.addingSuspect(Jago, Asker, jago);           
        } else if (Me.hasWeapon(ar) && Fulgore.hasPlace(li)) {
            phrase = this.addingSuspect(Jago, Asker, jago);            
        } else if (Me.hasSuspect(su) && Fulgore.hasPlace(li)) {
            phrase = this.addingWeapon(Jago, Asker, jago);            
        } else if (Fulgore.hasSuspect(su) && Me.hasPlace(li)) {
            phrase = this.addingWeapon(Jago, Asker, jago);            
        }
        sentence = this.noPainNoGain();
         System.out.println(sentence + phrase);
        return sentence + phrase;
    }

    public String tatsuHadoken(Player Spinal,Player Asker, Player Jago, int jago) {
        
        String phrase = null;
        if (Spinal.hasWeapon(ar) && Spinal.hasSuspect(su)) {
            phrase = this.addingPlace(Jago, Asker, jago);
        } else if (Spinal.hasWeapon(ar) && Spinal.hasPlace(li)) {
            phrase = this.addingSuspect(Jago, Asker, jago);
        } else if (Spinal.hasPlace(li) && Spinal.hasSuspect(su)) {
            phrase = this.addingWeapon(Jago, Asker, jago);
        }
        sentence = this.noPainNoGain();
         System.out.println(sentence + phrase);
        return sentence + phrase;
    }
    
    public String tatsumaHadoken(Player Asker, Player Fulgore, Player Jago, int jago) {
        
        String phrase = null;
        if (Fulgore.hasWeapon(ar) && Fulgore.hasSuspect(su)) {
            phrase = this.addingPlace(Jago, Asker, jago);
        } else if (Fulgore.hasWeapon(ar) && Fulgore.hasPlace(li)) {
            phrase = this.addingSuspect(Jago, Asker, jago);
        } else if (Fulgore.hasPlace(li) && Fulgore.hasSuspect(su)) {
            phrase = this.addingWeapon(Jago, Asker, jago);
        }
        sentence = this.noPainNoGain();
         System.out.println(sentence + phrase);
        return sentence + phrase;
    }

    public String splitHadoken(Player Asker, Player Spinal, Player Fulgore, Player Jago, int jago) {
        
        String phrase = null;
        if (Spinal.hasWeapon(ar) && Fulgore.hasSuspect(su)) {
            phrase = this.addingPlace(Jago, Asker, jago);
        } 
        else if (Fulgore.hasWeapon(ar) && Spinal.hasSuspect(su)) {
            phrase = this.addingPlace(Jago, Asker, jago);                               
        } else if (Spinal.hasPlace(li) && Fulgore.hasWeapon(ar)) {
            phrase = this.addingSuspect(Jago, Asker, jago);            
        } else if (Fulgore.hasPlace(li) && Spinal.hasWeapon(ar)) {
            phrase = this.addingSuspect(Jago, Asker, jago);            
        } else if (Fulgore.hasPlace(li) && Spinal.hasSuspect(su)) {
            phrase = this.addingWeapon(Jago, Asker, jago);            
        } else if (Spinal.hasPlace(li) && Fulgore.hasSuspect(su)) {
            phrase = this.addingWeapon(Jago, Asker, jago);            
        }
        sentence = this.noPainNoGain();
         System.out.println(sentence + phrase);
        return sentence + phrase;
    }

    //jagoNein (accusateur + non detenue) fulgoreNein (moi + non detenue)  spinalNein (les autres + non detenue)  
    // jagoOk (accusateur + solution) fulgoreOk (moi + solution) spinalOk ( les autres + solution)
   

    /*
     else if (my == 1 && other == 2 && ask == 0) {
     this.oneToDoubleShoryuken(Me, Jago, spinal);
     } else if (my == 0 && other == 2 && ask == 1) {
     this.oneToDoubleShoryuken(Asker, Jago, spinal);
     } else if (my == 0 && other == 2 && ask == 0) {
     this.oneToDouble(Jago, Spinal);
     this.oneToDouble(spinal, Spinal);
     } else if (my == 0 && other == 3 && ask == 0) {
     this.oneToDoubleShoryuken(Spinal, Jago, spinal);
     }
     */

    /*
     public String oneToDoubleShoryuken(int any, int Jago, int spinal) {

     Player player = joueurs.get(any);
     Player jagoPlayer = joueurs.get(Jago);
     Player spinalPlayer = joueurs.get(spinal);
     String phrase = null;
     String suite = null;
     if (player.hasWeapon(ar) && jagoPlayer.hasNotSuspect(su)) {
     phrase = basic.addingPlace(Jago, any);
     suite = basic.addingSuspect(spinal, any);
     } else if (player.hasWeapon(ar) && spinalPlayer.hasNotSuspect(su)) {
     phrase = basic.addingPlace(spinal, any);
     suite = basic.addingSuspect(Jago, any);
     } else if (player.hasPlace(li) && jagoPlayer.hasNotSuspect(su)) {
     phrase = basic.addingWeapon(Jago, any);
     suite = basic.addingSuspect(spinal, any);
     } else if (player.hasPlace(li) && spinalPlayer.hasNotSuspect(su)) {
     phrase = basic.addingWeapon(spinal, any);
     suite = basic.addingSuspect(Jago, any);
     } else if (player.hasSuspect(su) && jagoPlayer.hasNotPlace(li)) {
     phrase = basic.addingWeapon(Jago, any);
     suite = basic.addingPlace(spinal, any);
     } else if (player.hasSuspect(su) && spinalPlayer.hasNotPlace(li)) {
     phrase = basic.addingWeapon(spinal, any);
     suite = basic.addingPlace(Jago, any);
     } else if (player.hasSuspect(su) && jagoPlayer.hasNotWeapon(ar)) {
     phrase = basic.addingPlace(Jago, any);
     suite = basic.addingWeapon(spinal, any);
     } else if (player.hasSuspect(su) && spinalPlayer.hasNotWeapon(ar)) {
     phrase = basic.addingPlace(spinal, any);
     suite = basic.addingWeapon(Jago, any);
     } else if (player.hasPlace(li) && jagoPlayer.hasNotWeapon(ar)) {
     phrase = basic.addingSuspect(Jago, any);
     suite = basic.addingWeapon(spinal, any);
     } else if (player.hasPlace(li) && spinalPlayer.hasNotWeapon(ar)) {
     phrase = basic.addingSuspect(spinal, any);
     suite = basic.addingWeapon(Jago, any);
     } else if (player.hasWeapon(ar) && jagoPlayer.hasNotPlace(li)) {
     phrase = basic.addingSuspect(Jago, any);
     suite = basic.addingPlace(spinal, any);
     } else if (player.hasWeapon(ar) && spinalPlayer.hasNotPlace(li)) {
     phrase = basic.addingSuspect(spinal, any);
     suite = basic.addingPlace(Jago, any);
     }
     sentence = this.xToNoneAsker();
     return sentence + phrase + suite;
     }

     public String oneToDouble(int shoryuken, int Spinal) {
     Player player = joueurs.get(Spinal);
     Player jagoPlayer = joueurs.get(shoryuken);
     String phrase = null;
     if (player.hasWeapon(ar) && jagoPlayer.hasNotSuspect(su)) {
     phrase = basic.addingPlace(shoryuken, Spinal);
     } else if (player.hasPlace(li) && jagoPlayer.hasNotSuspect(su)) {
     phrase = basic.addingWeapon(shoryuken, Spinal);
     } else if (player.hasSuspect(su) && jagoPlayer.hasNotPlace(li)) {
     phrase = basic.addingWeapon(shoryuken, Spinal);
     } else if (player.hasSuspect(su) && jagoPlayer.hasNotWeapon(ar)) {
     phrase = basic.addingPlace(shoryuken, Spinal);
     } else if (player.hasPlace(li) && jagoPlayer.hasNotWeapon(ar)) {
     phrase = basic.addingSuspect(shoryuken, Spinal);
     } else if (player.hasWeapon(ar) && jagoPlayer.hasNotPlace(li)) {
     phrase = basic.addingSuspect(shoryuken, Spinal);
     }
     sentence = this.xToNoneAsker();
     return sentence + phrase;
     }
     */
    /*
     // 6 variantes ( 1,1,0   1,0,1   0,1,1  
     // 3 hadoken variantes : 2,0,0  0,2,0  0,0,2  )
     else if (other == 3 && my == 0 && ask == 0 && listKiller[5] < 6) {
     this.twoToAnyHadoken(hadoken, Asker, Jago);
     } else if (other == 3 && my == 0 && ask == 0 && listKiller[3] < 6 && listKiller[4] < 6 && listKiller[0] < 6) {
     this.twoToAnyShoryuken(Spinal, Fulgore, Jago, Asker);
     } else if (other == 3 && my == 0 && ask == 0 && listKiller[3] < 6 && listKiller[4] < 6 && listKiller[1] < 6) {
     this.twoToAnyShoryuken(Spinal, Fulgore, spinal, Asker);
     } else if (other == 3 && my == 0 && ask == 0 && listKiller[3] < 6 && listKiller[4] < 6 && listKiller[2] < 6) {
     this.twoToAnyShoryuken(Spinal, Fulgore, fulgore, Asker);
     }  else if (other == 2 && my == 1 && ask == 0) {
     }
     */
    /*
     else if (other == 2 && !(joueurs.get(Jago).hasNotTwoCards(ar, su, li) || joueurs.get(spinal).hasNotTwoCards(ar, su, li))) {
     this.noneToCoupleMain();
     } 
     else if (other == 2 && joueurs.get(Jago).hasNotTwoCards(ar, su, li)) {
     this.noneToCoupleShoryuken(Jago, spinal);
     } 
     else if (other == 2 && joueurs.get(spinal).hasNotTwoCards(ar, su, li)) {
     this.noneToCoupleShoryuken(spinal, Jago);
     } // QUESTION : est ce que le spinal passé en valeur comme argument va modifier la valeur int de Jago ????
     else if (other == 3 && (joueurs.get(Jago).hasNotTwoCards(ar, su, li) || (joueurs.get(spinal).hasNotOneCard(ar, su, li) && (joueurs.get(fulgore).hasNotOneCard(ar, su, li))))) {
     this.noneToAllShoryuken(Jago, spinal, fulgore);
     } 
     else if (other == 3 && (joueurs.get(spinal).hasNotTwoCards(ar, su, li) || (joueurs.get(Jago).hasNotOneCard(ar, su, li) && (joueurs.get(fulgore).hasNotOneCard(ar, su, li))))) {
     this.noneToAllShoryuken(spinal, Jago, fulgore);
     } 
     else if (other == 3 && (joueurs.get(fulgore).hasNotTwoCards(ar, su, li) || (joueurs.get(Jago).hasNotOneCard(ar, su, li) && (joueurs.get(spinal).hasNotOneCard(ar, su, li))))) {
     this.noneToAllShoryuken(fulgore, Jago, spinal);
     }
     */

    /*
     public String noneToCoupleShoryuken(int Jago, int spinal) {

     Player player = joueurs.get(Jago);
     Player benefactor = joueurs.get(spinal);
     Player Asker = joueurs.get(Asker);
     String phrase = null;

     sentence = "";

     if (player.hasNotWeapon(ar) && player.hasNotSuspect(su)) {
     phrase = basic.addingPlace(Jago, spinal, Asker);

     } else if (player.hasNotWeapon(ar) && player.hasNotPlace(li)) {
     phrase = basic.addingSuspect(Jago, spinal, Asker);

     } else if (player.hasNotSuspect(su) && player.hasNotPlace(li)) {
     phrase = basic.addingWeapon(Jago, spinal, Asker);

     }
     sentence = this.xToNoneAsker();
     return sentence + phrase;
     }

     public String noneToCoupleMain() {
     Player jagoPlayer = joueurs.get(Jago);
     Player spinalPlayer = joueurs.get(spinal);
     Player Asker = joueurs.get(Asker);

     String sentence = "";
     String phrase = null;

     if (jagoPlayer.hasNotWeapon(ar) && spinalPlayer.hasNotWeapon(ar)) {
     this.addSuspect(su);
     this.addPiece(li);
     Asker.addToNotSuspect(su);
     Asker.addToNotPlace(li);
     } else if (jagoPlayer.hasNotSuspect(su) && spinalPlayer.hasNotSuspect(su)) {
     this.addArme(ar);
     this.addPiece(li);
     Asker.addToNotWeapon(ar);
     Asker.addToNotPlace(li);
     } else if (jagoPlayer.hasNotPlace(li) && spinalPlayer.hasNotPlace(li)) {
     this.addSuspect(su);
     this.addPiece(li);
     Asker.addToNotSuspect(su);
     Asker.addToNotPlace(li);
     }
     sentence = this.xToNoneAsker();
     return sentence + phrase;
     }

     public String noneToAllMain() {

     Player Asker = joueurs.get(Asker);
     String phrase = null;
     String sentence = "";
     this.addArme(ar);
     this.addSuspect(su);
     this.addPiece(li);
     Asker.addToNotWeapon(ar);
     Asker.addToNotSuspect(su);
     Asker.addToNotPlace(li);

     sentence = this.xToNoneAsker();
     return sentence + phrase;
     }

     public String noneToAllShoryuken(int Jago, int spinal, int fulgore) {
     Player jagoPlayer = joueurs.get(Jago);
     Player spinalPlayer = joueurs.get(spinal);
     Player fulgorePlayer = joueurs.get(fulgore);
     Player Asker = joueurs.get(Asker);

     String phrase = null;
     String sentence = "";

     if (jagoPlayer.hasNotWeapon(ar) && jagoPlayer.hasNotSuspect(su)) {
     phrase = basic.addingPlace(Jago, spinal, fulgore, Asker);
     } else if (jagoPlayer.hasNotWeapon(ar) && jagoPlayer.hasNotPlace(li)) {
     phrase = basic.addingSuspect(Jago, spinal, fulgore, Asker);
     } else if (jagoPlayer.hasNotPlace(li) && jagoPlayer.hasNotSuspect(su)) {
     phrase = basic.addingWeapon(Jago, spinal, fulgore, Asker);
     } else if (spinalPlayer.hasNotWeapon(ar) && fulgorePlayer.hasNotWeapon(ar)) {
     phrase = basic.addingWeapon(Jago, Asker);
     } else if (spinalPlayer.hasNotSuspect(su) && fulgorePlayer.hasNotSuspect(su)) {
     phrase = basic.addingSuspect(Jago, Asker);
     } else if (spinalPlayer.hasNotPlace(li) && fulgorePlayer.hasNotPlace(li)) {
     phrase = basic.addingPlace(Jago, Asker);
     } else {
     // bizzare.. danger possible...
     this.noneToAllMain();
     }
     sentence = this.xToNoneAsker();
     return sentence + phrase;
     }
     */
    
}


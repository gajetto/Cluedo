/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.GameData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Ludovic
 */
public class Player {

    protected GameData game;
    protected String name;
    protected int NumberOfCards;
    protected int indice;
    // C'est une liste de Cartes alors que dans GAMEDATA c'est une liste de String
    protected HashSet<String> hasCard = new HashSet<String>();
    protected HashSet<String> hasNotCard = new HashSet<String>();
    protected List<String> hasCardList = new ArrayList<String>();
    protected List<String> hasNotCardList = new ArrayList<String>();

    protected int nbOfCards;
    protected int cardsKnown = 0;
    protected boolean full;

    protected boolean shown;

    protected static boolean isFirstPlayer;
    protected boolean accuser;
// { Arme, Suspect, Lieu} {boolean Demandeur, boolean témoin1, boolean témoin2, boolean témoin3, boolean témoin4} { 

    public Player(String prenom, int nbreCartes) {

        name = prenom;
        nbOfCards = nbreCartes;
    }

    public Set<String> getHasCard (){
        return hasCard;
    }
     public Set<String> getHasNotCard (){
        return hasNotCard;
    }
     public List<String> getHasCardList (){
        return hasCardList;
    }
     public List<String> getHasNotCardList (){
        return hasNotCardList;
    }
    
   
    public int addCardsKnown() {
        cardsKnown++;
        return cardsKnown;
    }
    
    public int getNbCardsKnown (){
        return cardsKnown;
    }

    public boolean isFull() {
        full = false;
        if (cardsKnown == nbOfCards) {
            full = true;
        }
        return full;
    }

    public String getName() {
        return name;
    }

    public void setName(String prenom) {
        prenom = name;
    }

    public void setShown(boolean shown) {
        this.shown = shown;
    }

    public boolean getShown() {
        return shown;
    }
    // utiliser ces méthodes!!!!!
    public void setAccuser(boolean accuser) {
        if (accuser == true) {
            this.accuser = true;
            int i = 0;

        } else if (accuser == false) {
            this.accuser = false;
        } else {
            this.accuser = false;
        }
    }

    public boolean isAccuser() {
        return accuser;
    }

    public boolean isFirstPlayer() {
        return isFirstPlayer;
    }

    // Si hasCard est vrai on ajoute au premier tableau, sinon on ajoute au second tableau
    
// le joueur

    public boolean hasWeapon(String ar) {
        boolean result = false;

        if (this.hasCardList.contains(ar)) {
            result = true;
        }
        return result;
    }

    public boolean hasSuspect(String su) {
        boolean result = false;
        if (this.hasCardList.contains(su)) {
            result = true;
        }
        return result;
    }

    public boolean hasPlace(String li) {
        boolean result = false;
        if (this.hasCardList.contains(li)) {
            result = true;
        }
        return result;
    }

    

    public boolean hasNotWeapon(String ar) {
        boolean result = false;
        if (this.hasNotCardList.contains(ar)) {
            result = true;
        }
        return result;
    }

    public boolean hasNotSuspect(String su) {
        boolean result = false;
        if (this.hasNotCardList.contains(su)) {
            result = true;
        }
        return result;
    }

    public boolean hasNotPlace(String li) {
        boolean result = false;
        if (this.hasNotCardList.contains(li)) {
            result = true;
        }
        return result;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public boolean hasNoCard(String ar, String su, String li) {
        boolean result = false;
        if      (!(this.hasCardList.contains(ar)
                || this.hasCardList.contains(su)
                || this.hasCardList.contains(li))) {
            result = true;
        }
        return result;
    }
    
  
    public boolean hasOneCard(String ar, String su, String li) {
        boolean result = false;
        int counter = 0;
        if (this.hasCardList.contains(ar)) {
            counter++;
        } if (this.hasCardList.contains(su)) {
            counter++;
        }  if (this.hasCardList.contains(li)) {
            counter++;
        }
        if (counter == 1) {
            result = true;
        }

        return result;
    }

    public boolean hasTwoCards(String ar, String su, String li) {
        boolean result = false;
        int counter = 0;
        if (this.hasCardList.contains(ar)) {
            counter++;
        }  if (this.hasCardList.contains(su)) {
            counter++;
        }  if (this.hasCardList.contains(li)) {
            counter++;
        }
        if (counter == 2) {
            result = true;
        }

        return result;
    }

    public boolean hasAllCards(String ar, String su, String li) {
        boolean result = false;
        int counter = 0;
        if (this.hasCardList.contains(ar)) {
            counter++;
        }  if (this.hasCardList.contains(su)) {
            counter++;
        }  if (this.hasCardList.contains(li)) {
            counter++;
        }
        if (counter == 3) {
            result = true;
        }

        return result;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    // SITUATION cf tab  ar : ?  su : ?  li : ?
    public boolean hasNotNoCard(String ar, String su, String li) {
        boolean result = false;
        if (!(this.hasNotCardList.contains(ar)
                && this.hasNotCardList.contains(su)
                && this.hasNotCardList.contains(li))) {
            result = true;
        }
        return result;
    }

    // SITUATION cf tab ex : ar : NOT(X)   su : ?   li  :  ?
    public boolean hasNotOneCard(String ar, String su, String li) {
        boolean result = false;
        int counter = 0;
        if (this.hasNotCardList.contains(ar)) {
            counter++;
        }  if (this.hasNotCardList.contains(su)) {
            counter++;
        }  if (this.hasNotCardList.contains(li)) {
            counter++;
        }
        if (counter == 1) {
            result = true;
        }
        return result;
    }

    // SITUATION cf tab ex : ar : NOT(X)   su : ?   li  :  NOT(X)
    public boolean hasNotTwoCards(String ar, String su, String li) {
        boolean result = false;
        int counter = 0;
        if (this.hasNotCardList.contains(ar)) {
            counter++;
        }  if (this.hasNotCardList.contains(su)) {
            counter++;
        }  if (this.hasNotCardList.contains(li)) {
            counter++;
        }
        if (counter == 2) {
            result = true;
        }
        return result;
    }

    public boolean hasNotAllCards(String ar, String su, String li) {
        boolean result = false;
        int counter = 0;
        if (this.hasNotCardList.contains(ar)) {
            counter++;
        }  if (this.hasNotCardList.contains(su)) {
            counter++;
        }  if (this.hasNotCardList.contains(li)) {
            counter++;
        }
        if (counter == 3) {
            result = true;
        }
        return result;
    }

    public boolean hasNoUnknown(String ar, String su, String li) {
        boolean result = false;
        if ((hasAllCards(ar, su, li) || hasNotAllCards(ar, su, li))
                || (hasTwoCards(ar, su, li) && hasNotOneCard(ar, su, li))
                || (hasOneCard(ar, su, li) && hasNotTwoCards(ar, su, li))) {
            result = true;
        }
        return result;
    }

    public boolean hasOneUnknown(String ar, String su, String li) {
        boolean result = false;
        if ((hasOneCard(ar, su, li) && hasNotOneCard(ar, su, li))
                || (hasTwoCards(ar, su, li) && hasNotNoCard(ar, su, li))
                || (hasNotTwoCards(ar, su, li) && hasNoCard(ar, su, li))) {
            result = true;
        }
        return result;
    }

    public boolean hasTwoUnknown(String ar, String su, String li) {
        boolean result = false;
        if ((hasNoCard(ar, su, li) && hasNotOneCard(ar, su, li))
                || (hasOneCard(ar, su, li) && hasNotNoCard(ar, su, li))) {
            result = true;
        }
        return result;
    }

    public boolean hasAllUnknown(String ar, String su, String li) {
        boolean result = false;
        if (hasNoCard(ar, su, li) && hasNotNoCard(ar, su, li)) {
            result = true;
        }
        return result;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void addToWeapon(String ar) {
        this.hasCard.add(ar);
        this.hasCardList.add(ar);
    }

    public void addToNotWeapon(String ar) {
        this.hasNotCard.add(ar);
        this.hasNotCardList.add(ar);
    }

    public void removeFromWeapon(int index, String[] ar) {
        for (String element : hasCard) {
            if (element.equals(ar[index])) {
                this.hasCard.remove(element);
                
            }
        }
    }

    public void removeFromNotWeapon(int index, String[] ar) {
        for (String element : hasNotCard) {
            if (element.equals(ar[index])) {
                this.hasNotCard.remove(element);
            }
        }
    }

    public void addToSuspect(String su) {
        this.hasCard.add(su);
        this.hasCardList.add(su);
    }

    public void addToNotSuspect(String su) {
        this.hasNotCard.add(su);
        this.hasNotCardList.add(su);
    }

    public void removeFromSuspect(int index, String[] su) {
        for (String element : hasCard) {
            if (element.equals(su[index])) {
                this.hasCard.remove(element);
            }
        }
    }

    public void removeFromNotSuspect(int index, String[] su) {
        for (String element : hasNotCard) {
            if (element.equals(su[index])) {
                this.hasNotCard.remove(element);
            }
        }
    }

    public void addToPlace(String li) {
        this.hasCard.add(li);
        this.hasCardList.add(li);
    }

    public void addToNotPlace(String li) {
        this.hasNotCard.add(li);
        this.hasNotCardList.add(li);
    }

    public void removeFromPlace(int index, String[] li) {
        for (String element : hasCard) {
            if (element.equals(li[index])) {
                this.hasCard.remove(element);
            }
        }
    }

    public void removeFromNotPlace(int index, String[] li) {
        for (String element : hasNotCard) {
            if (element.equals(li[index])) {
                this.hasNotCard.remove(element);
            }
        }
    }


// It is actually find and set card index !!!!!!!!!!
    /*public void findCardIndex(Cards card, boolean isHasCard) {
        int i = 0;
        int temp = i;
        List <String>  list;
        list = new ArrayList<String> (hasCard);
        if (isHasCard) {
            while ((!list.get(i).equals(card.getName()))) {
                temp = i;
                i++;
            }
            indice = temp;
        } else if (!isHasCard) {
            i = 0;
            temp = i;

            while (isHasCard && (!list.get(i).equals(card.getName()))) {
                temp = i;
                i++;
            }
            indice = temp;
        } else {
            System.out.println("On ne peut pas affecter d'indice à cette carte");
        }

    }
*/
  

    public void setNumberOfCards(int NumberOfCards) {
        this.NumberOfCards = NumberOfCards;

    }

    public int getNumberOfCards() {
        return NumberOfCards;
    }

}

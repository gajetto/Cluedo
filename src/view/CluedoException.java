/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Ludovic
 */
public class CluedoException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public CluedoException (){
    }
    
    

   public static class NumberJComboBoxException extends NullPointerException {
        private static final long serialVersionUID = 1L;

        public NumberJComboBoxException() {
            System.out.println("Erreur \n Le nombre de cartes doit être égale à 27");
        }
    }

    public static class JComboBoxException extends NullPointerException {

        private static final long serialVersionUID = 1L;

        public JComboBoxException() {
            System.out.println("Erreur \n Entrer le nombre de joueurs dans la partie");
        }
    }

    public static class FirstPlayerNullPointerException extends NullPointerException {

        private static final long serialVersionUID = 1L;

        FirstPlayerNullPointerException() {
            System.out.println("Veuillez remplir le champ du joueur principal");
        }
    }

    public static class OtherPlayerNullPointerException extends NullPointerException {
        private static final long serialVersionUID = 1L;

        OtherPlayerNullPointerException() {
            System.out.println("L'un ou plusieurs de champs joueurs ne sont pas remplis");
        }
    }

    public static class CardsJComboBoxException extends NullPointerException {
        private static final long serialVersionUID = 1L;
        
        CardsJComboBoxException (){
            System.out.println("Veuillez cocher vos cartes");
        }
        
    }
    public static class WeaponException extends NullPointerException {
        private static final long serialVersionUID = 1L;
        
        WeaponException (){
            System.out.println("Veuillez cocher vos cartes \"armes\" ");
        }
        
    }
    public static class SuspectException extends NullPointerException {
        private static final long serialVersionUID = 1L;
        
        SuspectException (){
            System.out.println("Veuillez cocher vos cartes \"suspects\" ");
        }
        
    }
    public static class RoomException extends NullPointerException {
        private static final long serialVersionUID = 1L;
        
        RoomException (){
            System.out.println("Veuillez cocher vos cartes \"lieux\" ");
        }
        
    }
    
    public  static class StringInputMismatchException extends Exception {
        private static final long serialVersionUID = 1L;

        StringInputMismatchException() {
            System.out.println("Veuillez entrer un nom");
        }

    }

    public  static class IntegerInputMismatchException extends Exception {
        private static final long serialVersionUID = 1L;

        IntegerInputMismatchException() {
            System.out.println("Veuillez entrer un chiffre");
        }

    }

}

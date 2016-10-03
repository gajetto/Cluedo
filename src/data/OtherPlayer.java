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
public class OtherPlayer extends Player{
    
    private final static boolean isFirstPlayer = false;
    static int instances = 1;
    
    public OtherPlayer (String Prenom, int nbreCartes){
        super (Prenom, nbreCartes);
        indice = instances;
        instances++;
      }    
} 


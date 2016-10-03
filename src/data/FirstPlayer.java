/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.GameData;
import data.Player;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;


/**
 *
 * @author Ludovic
 */
public  class FirstPlayer extends Player {

    private final static boolean isFirstPlayer = true;
    private final static int indice = 0;

    public FirstPlayer(String Prenom, int nbreCartes ) {
        super(Prenom, nbreCartes);
            }
}

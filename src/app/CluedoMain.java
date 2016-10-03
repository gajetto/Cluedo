/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import view.FirstView;
import java.nio.channels.FileChannel;
import java.nio.charset.*;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import javax.swing.JOptionPane;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.lang.RuntimeException;

import java.util.HashSet;
import java.util.Set;

import data.FirstPlayer;
import data.Player;
import data.OtherPlayer;
import data.GameData;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

import javax.swing.border.Border;
import logic.FirstController;
import view.SecondView;

/**
 *
 *
 * @author Ludovic
 */
public class CluedoMain {
    


    public static void main(String[] args) throws InputMismatchException, IOException, InterruptedException {
     
     javax.swing.SwingUtilities.invokeLater(new Runnable() {
        @Override public void run() {} });
        GameData game = new GameData ();
        FirstController first = new FirstController(new FirstView(), new GameData());
    }
}
        
       



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tammi;

import java.util.Scanner;

/**
 *
 * @author Matias
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tammi");

        Tammi tammi = new Tammi();
        tammi.Print();
        tammi.moveRight(5, 6);
        tammi.moveLeft(6, 3);
        tammi.moveRight(3, 6);
        tammi.moveRight(5, 2);

        tammi.moveLeft(4, 5);

        tammi.moveRight(2, 3);
        System.out.println("");
        tammi.Print();
        tammi.whoseTurn();
    }

}

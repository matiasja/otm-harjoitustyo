/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tammi;

import java.util.Scanner;
import java.util.regex.Pattern;

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

        System.out.println("");
        System.out.println(tammi.toString());
        while (true) {
            System.out.println("Mitä nappulaa haluat siirtää?");
            String input = scanner.nextLine();
            if (input.equals("q")) {
                break;
            }
            if (Pattern.matches("\\d{2}$", input.trim())) {
                System.out.println("Mihin suuntaan?");
                String input2 = scanner.nextLine();
                if (input2.equals("v")) {
                    tammi.moveLeft(Character.getNumericValue(input.charAt(0)), Character.getNumericValue(input.charAt(1)));
                }
                if (input2.equals("o")) {
                    tammi.moveRight(Character.getNumericValue(input.charAt(0)), Character.getNumericValue(input.charAt(1)));
                }
            }
            System.out.println(tammi);
            System.out.println("Pelaajan " + tammi.whoseTurn() + " vuoro");
        }

    }
}

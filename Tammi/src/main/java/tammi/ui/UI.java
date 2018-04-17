/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tammi.ui;

import java.util.Scanner;
import java.util.regex.Pattern;
import tammi.Tammi;
import tammi.Tammi;

/**
 *
 * @author Matias
 */
public class UI {

    private Scanner scanner;
    private Tammi tammi;

    public UI(Scanner scanner) {
        this.scanner = scanner;
        this.tammi = new Tammi();
    }

    public void start() {

        System.out.println("Uusi peli:");
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

package tammi;

import java.util.Scanner;
import tammi.game.Tammi;
import tammi.ui.UI;

/**
 *
 * @author Matias
 */
public class Main {

    public static void main(final String[] args) {

        Scanner scanner = new Scanner(System.in);
        UI ui = new UI(scanner);
        ui.start();
        Tammi tammi = new Tammi();

    }
}

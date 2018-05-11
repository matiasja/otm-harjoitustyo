package tammi;

import tammi.game.Tammi;
import tammi.ui.GUI;

public class Game {

    public static void main(final String[] args) {
        GUI gui = new GUI(new Tammi());
        gui.draw();
    }
}

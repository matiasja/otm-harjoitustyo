package tammi.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import tammi.game.Square;

public class SquarePanel extends JPanel {

    private final Square square;
    private final Color color;

    SquarePanel(final Color color, final Square square) {
        setBackground(color);
        setLayout(new BorderLayout());
        this.square = square;
        this.color = color;
    }

    public final Square getSquare() {
        return square;
    }

    public final void changeColor() {
        setBackground(Color.CYAN);

    }

    public final void changeColorBack() {
        setBackground(color);
    }

}

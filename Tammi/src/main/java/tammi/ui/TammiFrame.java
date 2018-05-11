package tammi.ui;

import java.awt.GridLayout;
import javax.swing.JFrame;

public class TammiFrame extends JFrame {

    final static int SIZE = 800;
    final static int ROW_SQUARES = 8;

    public TammiFrame(final String title) {
        super(title);
        setSize(SIZE, SIZE);
        setLayout(new GridLayout(ROW_SQUARES, ROW_SQUARES));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

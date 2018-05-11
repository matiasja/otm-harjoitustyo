/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tammi.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import tammi.game.Piece;
import tammi.game.Square;
import tammi.game.Tammi;

public class GUI {

    private final int size = 8;
    private Tammi tammi;
    private SquarePanel[][] boardPanels = new SquarePanel[size][size];
    private JFrame tammiFrame = new TammiFrame("tammi");
    private SquarePanel startSquarePanel = null;

    public GUI(final Tammi tammi) {
        this.tammi = tammi;
    }

    public final void draw() {
        for (int i = 0; i < size; i++) {
            Color temp;
            if (i % 2 == 0) {
                temp = Color.WHITE;
            } else {
                temp = Color.BLACK;
            }
            for (int j = 0; j < size; j++) {
                Square square = tammi.getBoard()[j][i];
                SquarePanel squarePanel = new SquarePanel(temp, square);
                boardPanels[j][i] = squarePanel;
                final Piece piece = square.getPiece();
                final int i2 = tammi.getBoard()[j][i].getX();
                final int j2 = tammi.getBoard()[j][i].getY();
                squarePanel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(final MouseEvent e) {
                        if (startSquarePanel == null) {
                            startSquarePanel = squarePanel;
                            squarePanel.changeColor();
                        } else {
                            startSquarePanel.changeColorBack();
                            if (tammi.move(startSquarePanel.getSquare(),
                                    square)) {

                                Component pieceComponent
                                        = startSquarePanel.getComponent(0);
                                startSquarePanel.remove(pieceComponent);
                                squarePanel.add(pieceComponent);
                                if (Math.abs(square.getY()
                                        - startSquarePanel.getSquare().getY())
                                        == 2) {
                                    boardPanels[(square.getX()
                                            + startSquarePanel
                                            .getSquare().getX())
                                            / 2][(square.getY()
                                            + startSquarePanel
                                            .getSquare().getY())
                                            / 2].remove(0);

                                }

                            }
                            if (tammi.canContinue(square)) {
                                startSquarePanel
                                        = boardPanels[square
                                        .getX()][square.getY()];
                                startSquarePanel.changeColor();
                            } else {
                                startSquarePanel = null;
                            }
                            tammiFrame.repaint();
                        }
                    }
                });

                if (piece == Piece.WHITE) {
                    squarePanel.add(new PiecePanel(Color.LIGHT_GRAY));
                } else if (piece == Piece.BLACK) {
                    squarePanel.add(new PiecePanel(Color.RED));
                }

                if (temp.equals(Color.BLACK)) {
                    temp = Color.WHITE;
                } else {
                    temp = Color.BLACK;
                }

                tammiFrame.getContentPane()
                        .add(squarePanel);
            }
        }
    }

}

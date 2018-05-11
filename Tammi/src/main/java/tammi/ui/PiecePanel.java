/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tammi.ui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Matias
 */
public class PiecePanel extends JPanel {

    private Color color;

    PiecePanel(final Color color) {
        this.color = color;
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillOval(getWidth() / 4, getHeight() / 4,
                getWidth() / 2, getHeight() / 2);
        setOpaque(false);
        setBackground(new Color(255, 0, 0, 80));
    }
}

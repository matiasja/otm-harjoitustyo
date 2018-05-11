package tammi.game;

public class Tammi {

    private final int size = 8;
    private final Square[][] board = new Square[size][size];
    private int turn = -1;

    /**
     * Muodostaa laudan, jossa nappulat ovat paikoillaan.
     */
    public Tammi() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Square(i, j);
            }
        }

        int offset1 = 0;
        int offset2 = 3;

        for (int i = 0; i < size; i++) {
            for (int j = offset1; j < offset2; j++) {
                if (j % 2 == 1) {
                    if (i % 2 == 0) {
                        board[i][j].setPiece(Piece.WHITE);
                    }
                } else if (i % 2 == 1) {
                    board[i][j].setPiece(Piece.WHITE);
                }
            }
        }

        offset1 = 5;
        offset2 = 8;

        for (int i = 0; i < size; i++) {
            for (int j = offset1; j < offset2; j++) {
                if (j % 2 == 1) {
                    if (i % 2 == 0) {
                        board[i][j].setPiece(Piece.BLACK);
                    }
                } else if (i % 2 == 1) {
                    board[i][j].setPiece(Piece.BLACK);
                }
            }
        }

    }

    /**
     * Nappulan liikkuminen. Haluttu lähtöruutu ja maaliruutu. Testaa siirron
     * laillisuuden, tekee siirron, ja tarvittaessa vaihtaa vuoron
     * vastustajalle.
     *
     * @param start Liikutettavan nappulan ruutu.
     * @param end Haluttu maaliruutu.
     *
     * @return kertoo onko siirto tehty.
     */
    public final boolean move(final Square start, final Square end) {
        if (!isValidMove(start, end)) {
            return false;
        }
        performMove(start, end);
        if (Math.abs(end.getY() - start.getY()) == 2) {
            if (end.getX() + 2 < size && end.getY() + 2 * turn < size
                    && end.getX() + 2 > -1 && end.getY() + 2 * turn > -1) {
                if (isValidMove(end, board[end.getX() + 2][end.getY()
                        + 2 * turn])) {
                    return true;
                }
            }
            if (end.getX() - 2 < size && end.getY() + 2 * turn < size
                    && end.getX() - 2 > -1 && end.getY() + 2 * turn > -1) {
                if (isValidMove(end, board[end.getX() - 2][end.getY()
                        + 2 * turn])) {
                    return true;
                }
            }
        }
        turn = -turn;

        return true;
    }

    public final Square[][] getBoard() {
        return board;
    }

    /**
     * Testaa onko siirto laillinen.
     *
     * @param start Liikutettavan nappulan ruutu.
     * @param end Haluttu pääteruutu.
     *
     * @return kertoo onko siirto laillinen.
     */
    private boolean isValidMove(final Square start, final Square end) {
        if (!start.hasPiece()) {
            return false;
        }
        if (end.hasPiece()) {
            return false;
        }
        Piece pieceToMove = start.getPiece();
        if (pieceToMove.getyDirection() != turn) {
            return false;
        }
        if (Math.abs(end.getX() - start.getX()) == 1
                && end.getY() - start.getY() == turn) {
            return true;
        }
        int captureDirectionX = (end.getX() - start.getX()) / 2;
        if (isValidCapture(start, end, captureDirectionX)) {
            return true;
        }
        return false;
    }

    /**
     * Testaa onko syönti laillinen.
     *
     * @param start Liikutettavan nappulan ruutu.
     * @param end Haluttu pääteruutu.
     * @param captureDirectionX Kertoo syödäänkö oikealle vai vasemmalle.
     *
     * @return Kertoo onko syönti laillinen.
     */
    private boolean isValidCapture(final Square start, final Square end,
            final int captureDirectionX) {
        if (Math.abs(captureDirectionX) != 1) {
            return false;
        }
        if (end.getX() - start.getX() == 2 * captureDirectionX
                && end.getY() - start.getY() == turn * 2) {

            if (board[start.getX() + captureDirectionX][start.getY()
                    + turn].hasPiece()) {
                if (board[start.getX() + captureDirectionX][start.getY()
                        + turn].getPiece().getyDirection() == -turn) {

                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Tekee siirtää nappulan maaliruutuun ja tarvittaessa poistaa syödyn
     * nappulan.
     *
     * @param start Liikutettavan nappulan ruutu.
     * @param end Haluttu pääteruutu.
     */
    private void performMove(final Square start, final Square end) {
        if (Math.abs(end.getY() - start.getY()) == 2) {
            board[(end.getX() - start.getX()) / 2 + start.getX()][(end.getY()
                    - start.getY()) / 2 + start.getY()].removePiece();
        }
        end.setPiece(start.getPiece());
        start.removePiece();

    }

    /**
     * Testaa onko mahdollista jatkaa syömistä.
     *
     * @param square Syönnin jälkeinen ruutu.
     *
     * @return Kertoo voidaanko jatkaa syömistä.
     */
    public final boolean canContinue(final Square square) {
        if (square.getX() + 2 < size) {
            if (square.getY() + 2 * turn < size && square.getY()
                    + 2 * turn > -1) {
                if (!board[square.getX() + 2][square.getY()
                        + 2 * turn].hasPiece()) {
                    if (board[square.getX() + 1][square.getY()
                            + turn].hasPiece()) {
                        if (board[square.getX() + 1][square.getY()
                                + turn].getPiece().getyDirection() == -turn) {
                            return true;
                        }
                    }
                }
            }
        }
        if (square.getX() - 2 > -1) {
            if (square.getY() + 2 * turn < size
                    && square.getY() + 2 * turn > -1) {
                if (!board[square.getX() - 2][square.getY()
                        + 2 * turn].hasPiece()) {
                    if (board[square.getX() - 1][square.getY()
                            + turn].hasPiece()) {
                        if (board[square.getX() - 1][square.getY()
                                + turn].getPiece().getyDirection() == -turn) {
                            return true;
                        }
                    }
                }
            }

        }
        return false;
    }

    public final int getSize() {
        return size;
    }

    @Override
    public final String toString() {
        String print = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                print = print + board[j][i].getPiece();

            }
            print = print + "\n";
        }
        return print;
    }
}

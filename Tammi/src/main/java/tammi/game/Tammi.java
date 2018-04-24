package tammi.game;

/**
 *
 * @author Matias
 */
public class Tammi {

    private final int size = 9;
    private Piece[][] board = new Piece[size][size];
    private Piece turn;

    public Tammi() {
        this.turn = Piece.BLACK;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || j == 0) {
                    board[i][j] = Piece.OUT;
                } else {
                    board[i][j] = Piece.NONE;
                }
            }
        }
        final int white1 = 1;
        final int white2 = 4;
        for (int i = 1; i < size; i++) {
            for (int j = white1; j < white2; j++) {
                if (j % 2 == 1) {
                    if (i % 2 == 0) {
                        board[i][j] = Piece.WHITE;
                    }
                } else if (i % 2 == 1) {
                    board[i][j] = Piece.WHITE;
                }

            }
        }
        final int black1 = 6;
        final int black2 = 9;
        for (int i = 1; i < size; i++) {
            for (int j = black1; j < black2; j++) {
                if (j % 2 == 1) {
                    if (i % 2 == 0) {
                        board[i][j] = Piece.BLACK;
                    }
                } else if (i % 2 == 1) {
                    board[i][j] = Piece.BLACK;
                }

            }
        }

    }

    private enum Piece {
        WHITE(1),
        BLACK(2),
        NONE(0),
        OUT(-1);

        private int number;

        Piece(final int num) {
            this.number = num;
        }

        @Override
        public final String toString() {
            return number + "";
        }
    }

    @Override
    public final String toString() {
        int num = 1;
        String y = "";
        for (num = 1; num < size; num++) {

            String x = "";

            for (int i = 1; i < size; i++) {
                if (board[i][num] == Piece.WHITE
                        || board[i][num] == Piece.BLACK) {
                    x = x + board[i][num] + "";
                } else {
                    x = x + "0";
                }
            }
            y = y + x + "\n";

        }
        return y;
    }

    public final void moveLeft(final int x, final int y) {
        if (x >= size || x < 1) {
            System.out.println("Pysythän laudalla.");
            return;
        }

        if (y >= size || y < 1) {
            System.out.println("Pysythän laudalla.");
            return;
        }

        if (board[x][y] != turn) {
            System.out.println("Siinä ei ole sinun nappula!");
            return;
        }

        if (turn == Piece.WHITE) {
            if (board[x - 1][y + 1] == Piece.WHITE) {
                System.out.println("Ruudussa on jo oma nappula!");
                return;
            }
            if (board[x - 1][y + 1] == Piece.NONE) {
                board[x][y] = Piece.NONE;
                board[x - 1][y + 1] = Piece.WHITE;
            }

            if (board[x - 1][y + 1] == Piece.BLACK) {

                if (board[x - 2][y + 2] != Piece.NONE) {

                    System.out.println("Laiton siirto.");
                    return;

                }

                board[x][y] = Piece.NONE;
                board[x - 1][y + 1] = Piece.NONE;
                board[x - 2][y + 2] = turn;

                if (canYou(x - 2, y + 2) > 1) {
                    System.out.println("syötkö vasemmalle vai oikealle?");
                    return;
                }

            }
            if (board[x - 1][y + 1] != Piece.NONE
                    && board[x - 1][y + 1] != Piece.WHITE
                    && board[x - 1][y + 1] != Piece.BLACK) {
                System.out.println("Keskity!");
                return;
            }
            this.turn = Piece.BLACK;
            return;

        }

        if (turn == Piece.BLACK) {
            if (board[x - 1][y - 1] == Piece.BLACK) {
                System.out.println("Ruudussa on jo oma nappula!");
                return;
            }
            if (board[x - 1][y - 1] == Piece.NONE) {
                board[x][y] = Piece.NONE;

                board[x - 1][y - 1] = turn;
            }

            if (board[x - 1][y - 1] == Piece.WHITE) {

                if (board[x - 2][y - 2] != Piece.NONE) {

                    System.out.println("Laiton siirto.");
                    return;

                }

                board[x][y] = Piece.NONE;
                board[x - 1][y - 1] = Piece.NONE;
                board[x - 2][y - 2] = turn;

                if (canYou(x - 2, y - 2) > 1) {

                    System.out.println("syötkö vasemmalle vai oikealle?");
                    return;
                }

            }
            if (board[x - 1][y - 1] != Piece.NONE
                    && board[x - 1][y - 1] != Piece.WHITE
                    && board[x - 1][y - 1] != Piece.BLACK) {
                System.out.println("Keskity!");
                return;
            }
            this.turn = Piece.WHITE;
            return;
        }
    }

    public final void moveRight(final int x, final int y) {
        if (x >= size || x < 1) {
            System.out.println("Pysythän laudalla.");
            return;
        }

        if (y >= size || y < 1) {
            System.out.println("Pysythän laudalla.");
            return;
        }
        if (board[x][y] != turn) {
            System.out.println("Siinä ei ole sinun nappula!");
            return;
        }

        if (turn == Piece.WHITE) {
            if (board[x + 1][y + 1] == Piece.WHITE) {
                System.out.println("Ruudussa on jo oma nappula!");
                return;
            }
            if (board[x + 1][y + 1] == Piece.NONE) {
                board[x][y] = Piece.NONE;
                board[x + 1][y + 1] = Piece.WHITE;
            }

            if (board[x + 1][y + 1] == Piece.BLACK) {

                if (board[x + 2][y + 2] != Piece.NONE) {

                    System.out.println("Laiton siirto.");
                    return;

                }

                board[x][y] = Piece.NONE;
                board[x + 1][y + 1] = Piece.NONE;
                board[x + 2][y + 2] = turn;

                if (canYou(x + 2, y + 2) > 1) {

                    System.out.println("syötkö vasemmalle vai oikealle?");
                    return;
                }

            }
            if (board[x + 1][y + 1] != Piece.NONE
                    && board[x + 1][y + 1] != Piece.WHITE
                    && board[x + 1][y + 1] != Piece.BLACK) {
                System.out.println("Keskity!");
                return;
            }
            this.turn = Piece.BLACK;
            return;

        }

        if (turn == Piece.BLACK) {

            if (board[x + 1][y - 1] == Piece.BLACK) {
                System.out.println("Ruudussa on jo oma nappula!");
                return;
            }
            if (board[x + 1][y - 1] == Piece.NONE) {
                board[x][y] = Piece.NONE;
                board[x + 1][y - 1] = Piece.BLACK;

            }

            if (board[x + 1][y - 1] == Piece.WHITE) {

                if (board[x + 2][y - 2] != Piece.NONE) {

                    System.out.println("Laiton siirto.");
                    return;

                }

                board[x][y] = Piece.NONE;
                board[x + 1][y - 1] = Piece.NONE;
                board[x + 2][y - 2] = turn;

                if (canYou(x + 2, y - 2) > 1) {

                    System.out.println("syötkö vasemmalle vai oikealle?");
                    return;
                }

            }
            if (board[x + 1][y - 1] != Piece.NONE
                    && board[x + 1][y - 1] != Piece.WHITE
                    && board[x + 1][y - 1] != Piece.BLACK) {
                System.out.println("Keskity!");
                return;
            }
            this.turn = Piece.WHITE;
            return;
        }
    }

    public final int canYou(final int x, final int y) {
        int ways = 0;
        if (turn == Piece.WHITE) {
        }

        return ways;
    }

    public final Piece whoseTurn() {
        return turn;
    }
}

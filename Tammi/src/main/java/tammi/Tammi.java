/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tammi;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matias
 */
public class Tammi {

    private int[][] board;
    private int turn;

    public Tammi() {
        this.turn = 2;
        int[][] board = new int[9][9];
        board[2][1] = 1;
        board[4][1] = 1;
        board[6][1] = 1;
        board[8][1] = 1;
        board[1][2] = 1;
        board[3][2] = 1;
        board[5][2] = 1;
        board[7][2] = 1;
        board[2][3] = 1;
        board[4][3] = 1;
        board[6][3] = 1;
        board[8][3] = 1;

        board[1][6] = 2;
        board[3][6] = 2;
        board[5][6] = 2;
        board[7][6] = 2;
        board[2][7] = 2;
        board[4][7] = 2;
        board[6][7] = 2;
        board[8][7] = 2;
        board[1][8] = 2;
        board[3][8] = 2;
        board[5][8] = 2;
        board[7][8] = 2;

        board[0][0] = 9;
        board[0][1] = 9;
        board[0][2] = 9;
        board[0][3] = 9;
        board[0][4] = 9;
        board[0][5] = 9;
        board[0][6] = 9;
        board[0][7] = 9;
        board[0][8] = 9;
 


        board[1][0] = 9;
        board[2][0] = 9;
        board[3][0] = 9;
        board[4][0] = 9;
        board[5][0] = 9;
        board[6][0] = 9;
        board[7][0] = 9;
        board[8][0] = 9;


        this.board = board;

    }

    @Override
    public String toString() {
        int num = 1;
        String y = "";
        for (num = 1; num < 9; num++) {

            String x = "";

            for (int i = 1; i < 9; i++) {
                if (board[i][num] == 1 || board[i][num] == 2) {
                    x = x + board[i][num] + "";
                } else {
                    x = x + "0";
                }
            }
            y = y + x + "\n";

        }
        return y;
    }

    public void moveLeft(int x, int y) {
        if (x > 8 || x < 1) {
            System.out.println("Pysythän laudalla.");
            return;
        }

        if (y > 8 || y < 1) {
            System.out.println("Pysythän laudalla.");
            return;
        }

        if (board[x][y] != turn) {
            System.out.println("Siinä ei ole sinun nappula!");
            return;
        }

        if (turn == 1) {
            if (board[x - 1][y + 1] == 1) {
                System.out.println("Ruudussa on jo oma nappula!");
                return;
            }
            if (board[x - 1][y + 1] == 0) {
                board[x][y] = 0;
                board[x - 1][y + 1] = 1;
            }

            if (board[x - 1][y + 1] == 2) {

                if (board[x - 2][y + 2] != 0) {
                    if (board[x][y + 2] != 0) {
                        System.out.println("Laiton siirto.");
                        return;
                    }
                }

                board[x][y] = 0;
                board[x - 1][y + 1] = 0;
                board[x - 2][y + 2] = 0;

                if (canYou(x, y)) {
                    System.out.println("syötkö vasemmalle vai oikealle?");
                    return;
                }

            }
            if (board[x - 1][y + 1] != 0 && board[x - 1][y + 1] != 1 && board[x - 1][y + 1] != 2) {
                System.out.println("Keskity!");
                return;
            }
            this.turn = 2;
            return;

        }

        if (turn == 2) {
            if (board[x - 1][y - 1] == 2) {
                System.out.println("Ruudussa on jo oma nappula!");
                return;
            }
            if (board[x - 1][y - 1] == 0) {
                board[x][y] = 0;

                board[x - 1][y - 1] = turn;
            }

            if (board[x - 1][y - 1] == 1) {

                if (board[x - 2][y - 2] != 0) {
                    if (board[x][y - 2] != 0) {
                        System.out.println("Laiton siirto.");
                        return;
                    }
                }

                board[x][y] = 0;
                board[x - 1][y - 1] = 0;
                board[x - 2][y - 2] = turn;

                if (canYou(x, y)) {
                    System.out.println("syötkö vasemmalle vai oikealle?");
                    return;
                }

            }
            if (board[x - 1][y - 1] != 0 && board[x - 1][y - 1] != 1 && board[x - 1][y - 1] != 2) {
                System.out.println("Keskity!");
                return;
            }
            this.turn = 1;
            return;
        }
    }

    public void moveRight(int x, int y) {
        if (x > 8 || x < 1) {
            System.out.println("Pysythän laudalla.");
            return;
        }

        if (y > 8 || y < 1) {
            System.out.println("Pysythän laudalla.");
            return;
        }
        if (board[x][y] != turn) {
            System.out.println("Siinä ei ole sinun nappula!");
            return;
        }

        if (turn == 1) {
            if (board[x + 1][y + 1] == 1) {
                System.out.println("Ruudussa on jo oma nappula!");
                return;
            }
            if (board[x + 1][y + 1] == 0) {
                board[x][y] = 0;
                board[x + 1][y + 1] = 1;
            }

            if (board[x + 1][y + 1] == 2) {

                if (board[x + 2][y + 2] != 0) {
                    if (board[x][y + 2] != 0) {
                        System.out.println("Laiton siirto.");
                        return;
                    }
                }

                board[x][y] = 0;
                board[x + 1][y + 1] = 0;
                board[x + 2][y + 2] = turn;

                if (canYou(x + 2, y + 2)) {
                    System.out.println("syötkö vasemmalle vai oikealle?");
                    return;
                }

            }
            if (board[x + 1][y + 1] != 0 && board[x + 1][y + 1] != 1 && board[x + 1][y + 1] != 2) {
                System.out.println("Keskity!");
                return;
            }
            this.turn = 2;
            return;

        }

        if (turn == 2) {

            if (board[x + 1][y - 1] == 2) {
                System.out.println("Ruudussa on jo oma nappula!");
                return;
            }
            if (board[x + 1][y - 1] == 0) {
                board[x][y] = 0;
                board[x + 1][y - 1] = 2;
            }

            if (board[x + 1][y - 1] == 1) {

                if (board[x + 2][y - 2] != 0) {
                    if (board[x][y - 2] != 0) {
                        System.out.println("Laiton siirto.");
                        return;
                    }
                }

                board[x][y] = 0;
                board[x + 1][y - 1] = 0;
                board[x + 2][y - 2] = turn;

                if (canYou(x + 2, y - 2)) {
                    System.out.println("syötkö vasemmalle vai oikealle?");
                    return;
                }

            }
            if (board[x + 1][y - 1] != 0 && board[x + 1][y - 1] != 1 && board[x + 1][y - 1] != 2) {
                System.out.println("Keskity!");
                return;
            }
            this.turn = 1;
            return;
        }
    }

    public boolean canYou(int x, int y) {
        if (turn == 1) {
            if (board[x + 1][y + 1] == 0) {
                return true;
            }

            if (board[x - 1][y + 1] == 0) {
                return true;
            }
            if (board[x + 1][y + 1] == 2) {
                if (board[x + 2][y + 2] == 0) {
                    return true;
                }
                if (board[x][y + 2] == 0) {
                    return true;
                }
            }
            return false;
        }
        if (turn == 2) {
            if (board[x + 1][y - 1] == 0) {
                return true;
            }

            if (board[x - 1][y - 1] == 0) {
                return true;
            }
            if (board[x + 1][y - 1] == 1) {
                if (board[x + 2][y - 2] == 0) {
                    return true;
                }
                if (board[x][y - 2] == 0) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public int whoseTurn() {

        return turn;
    }
}

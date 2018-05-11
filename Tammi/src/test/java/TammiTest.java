
import tammi.game.Tammi;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import tammi.game.Square;

/**
 *
 * @author Matias
 */
public class TammiTest {

    Tammi tammi;
    Square[][] board;

    @Before
    public void setUp() {
        this.tammi = new Tammi();
        this.board = tammi.getBoard();
    }

    @Test
    public void tammiStart() {

        assertEquals("nullWHITEnullWHITEnullWHITEnullWHITE\n"
                + "WHITEnullWHITEnullWHITEnullWHITEnull\n"
                + "nullWHITEnullWHITEnullWHITEnullWHITE\n"
                + "nullnullnullnullnullnullnullnull\n"
                + "nullnullnullnullnullnullnullnull\n"
                + "BLACKnullBLACKnullBLACKnullBLACKnull\n"
                + "nullBLACKnullBLACKnullBLACKnullBLACK\n"
                + "BLACKnullBLACKnullBLACKnullBLACKnull\n", tammi.toString());

    }

    @Test
    public void canContinue1() {
        assertEquals(tammi.canContinue(board[0][5]), false);
    }

    @Test
    public void canContinue2() {
        tammi.move(board[0][5], board[1][4]);
        tammi.move(board[7][2], board[6][3]);
        tammi.move(board[1][4], board[2][3]);
        tammi.move(board[6][3], board[5][4]);
        tammi.move(board[4][5], board[6][3]);
        tammi.move(board[6][1], board[7][2]);
        tammi.move(board[3][6], board[4][5]);

        assertEquals(tammi.canContinue(board[1][4]), true);
    }

    @Test
    public void canContinue3() {
        tammi.move(board[4][5], board[5][4]);
        tammi.move(board[5][2], board[4][3]);

        assertEquals(tammi.canContinue(board[3][4]), true);
    }

    @Test
    public void getSize() {
        assertEquals(tammi.getSize(), 8);
    }

    @Test
    public void move1() {
        tammi.move(board[4][5], board[5][4]);
        tammi.move(board[5][2], board[4][3]);
        tammi.move(board[2][5], board[3][4]);

        assertEquals(tammi.canContinue(board[2][5]), false);
    }

    @Test
    public void move2() {
        assertEquals(tammi.move(board[0][0], board[5][5]), false);
    }

    @Test
    public void move3() {
        tammi.move(board[4][5], board[5][4]);
        tammi.move(board[5][2], board[4][3]);
        tammi.move(board[2][5], board[3][4]);
        tammi.move(board[4][3], board[2][5]);
        tammi.move(board[3][6], board[1][4]);

        assertEquals(tammi.canContinue(board[1][4]), false);
    }

    @Test
    public void move4() {
        tammi.move(board[4][5], board[5][4]);
        tammi.move(board[5][2], board[4][3]);
        tammi.move(board[2][5], board[3][4]);
        tammi.move(board[4][3], board[2][5]);
        tammi.move(board[3][6], board[1][4]);
        tammi.move(board[1][2], board[0][3]);

        tammi.move(board[2][7], board[3][6]);
        tammi.move(board[7][2], board[6][3]);
        tammi.move(board[1][6], board[2][5]);

        assertEquals(tammi.canContinue(board[6][3]), true);
    }

}

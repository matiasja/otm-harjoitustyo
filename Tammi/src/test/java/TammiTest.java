
import tammi.game.Tammi;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Matias
 */
public class TammiTest {

    Tammi tammi;

    @Before
    public void setUp() {
        this.tammi = new Tammi();
    }

    @Test
    public void tammiStart() {

        assertEquals("01010101\n"
                + "10101010\n"
                + "01010101\n"
                + "00000000\n"
                + "00000000\n"
                + "20202020\n"
                + "02020202\n"
                + "20202020\n", tammi.toString());

    }

    @Test
    public void tammiMove1() {
        tammi.moveRight(1, 6);

        assertEquals("01010101\n"
                + "10101010\n"
                + "01010101\n"
                + "00000000\n"
                + "02000000\n"
                + "00202020\n"
                + "02020202\n"
                + "20202020\n", tammi.toString());

    }
    
        @Test
    public void tammiMove2() {
        tammi.moveLeft(1, 6);

        assertEquals("01010101\n"
                + "10101010\n"
                + "01010101\n"
                + "00000000\n"
                + "00000000\n"
                + "20202020\n"
                + "02020202\n"
                + "20202020\n", tammi.toString());

    }

}


import Tammi.Tammi;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    public void tammiSiirtoja() {
        tammi.moveRight(5, 6);

        tammi.moveRight(3, 6);
        tammi.moveRight(5, 2);

        tammi.moveLeft(4, 5);

        tammi.moveRight(2, 3);

        assertEquals("01010100\n"
                + "10101011\n"
                + "00010101\n"
                + "00100000\n"
                + "00000200\n"
                + "20200020\n"
                + "02020202\n"
                + "20202020\n", tammi.Print());
        
    }

}


import tammi.Tammi;
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

}

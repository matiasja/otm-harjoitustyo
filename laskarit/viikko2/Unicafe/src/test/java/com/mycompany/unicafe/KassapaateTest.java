package com.mycompany.unicafe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.unicafe.Kassapaate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matias
 */
public class KassapaateTest {

    Kassapaate kassa;

    public KassapaateTest() {
    }

    @Before
    public void setUp() {
        kassa = new Kassapaate();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void rahaa() {

        assertTrue(kassa.kassassaRahaa() == 1000);
    }

    @Test
    public void maukkauta() {

        assertTrue(kassa.maukkaitaLounaitaMyyty() == 0);
    }

    @Test
    public void edullisia() {

        assertTrue(kassa.edullisiaLounaitaMyyty() == 0);
    }

    @Test
    public void ostomaukas() {
        kassa.syoMaukkaasti(1000);

        assertTrue(kassa.kassassaRahaa() == 1400 && kassa.maukkaitaLounaitaMyyty() == 1);
    }

    @Test
    public void ostomaukas2() {
        assertTrue(kassa.syoMaukkaasti(1000) == 600);

    }

    @Test
    public void ostoedullinen() {
        kassa.syoEdullisesti(1000);

        assertTrue(kassa.kassassaRahaa() == 1240 && kassa.edullisiaLounaitaMyyty() == 1);
    }

    @Test
    public void ostoedullinen2() {

        assertTrue(kassa.syoEdullisesti(1000) == 760);

    }

    @Test
    public void saldo() {
        kassa.syoMaukkaasti(400);
        assertTrue(kassa.kassassaRahaa() == 1400 && kassa.maukkaitaLounaitaMyyty() == 1);
    }

    @Test
    public void saldo2() {
        kassa.syoMaukkaasti(300);
        assertTrue(kassa.kassassaRahaa() == 1000 && kassa.maukkaitaLounaitaMyyty() == 0);
    }

    @Test
    public void saldo3() {
        kassa.syoEdullisesti(200);
        assertTrue(kassa.kassassaRahaa() == 1000 && kassa.edullisiaLounaitaMyyty() == 0);
    }

    @Test
    public void korttiosto() {
        Maksukortti kortti = new Maksukortti(1000);

        boolean x = kassa.syoEdullisesti(kortti);
        boolean y = kassa.syoMaukkaasti(kortti);

        assertTrue(kortti.saldo() == 360 && x == true && y == true);
    }

    @Test
    public void korttiosto2() {
        Maksukortti kortti = new Maksukortti(1000);

        boolean x = kassa.syoEdullisesti(kortti);
        boolean y = kassa.syoMaukkaasti(kortti);

        assertTrue(kassa.edullisiaLounaitaMyyty() == 1 && kassa.maukkaitaLounaitaMyyty() == 1);
    }

    @Test
    public void korttiosto3() {
        Maksukortti kortti = new Maksukortti(200);

        boolean x = kassa.syoEdullisesti(kortti);
        boolean y = kassa.syoMaukkaasti(kortti);

        assertTrue(kassa.edullisiaLounaitaMyyty() == 0 && kassa.maukkaitaLounaitaMyyty() == 0 && x == false && y == false);
    }

        @Test
    public void korttiosto4() {
        Maksukortti kortti = new Maksukortti(1000);

        boolean x = kassa.syoEdullisesti(kortti);
        boolean y = kassa.syoMaukkaasti(kortti);
      
        assertTrue(kassa.kassassaRahaa() == 1000);
    }
    
    @Test
    public void korttilataus() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.lataaRahaaKortille(kortti, 1000);
        assertTrue(kassa.kassassaRahaa() == 2000 && kortti.saldo() == 2000);
    }
    
        @Test
    public void korttilataus2() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.lataaRahaaKortille(kortti, -1);
        assertTrue(kassa.kassassaRahaa() == 1000 && kortti.saldo() == 1000);
    }
}

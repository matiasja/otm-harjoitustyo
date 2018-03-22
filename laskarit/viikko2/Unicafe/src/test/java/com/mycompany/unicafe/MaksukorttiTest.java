package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void saldoOikea() {
        assertTrue(10 == kortti.saldo());
    }

    @Test
    public void uusiSaldoOikea() {
        kortti.lataaRahaa(10);
        assertTrue(20 == kortti.saldo());
    }

    @Test
    public void uusiSaldoOikea2() {
        kortti.otaRahaa(2);
        assertTrue(8 == kortti.saldo());
    }

    @Test
    public void uusiSaldoOikea3() {
        kortti.otaRahaa(12);
        assertTrue(10 == kortti.saldo());
    }

    @Test
    public void truu() {
        assertTrue(true == kortti.otaRahaa(1));
    }

    @Test
    public void faalse() {
        assertTrue(!kortti.otaRahaa(11));
    }

    @Test
    public void testi() {
        assertEquals("saldo: 0.10", kortti.toString());
    }

}

# Arkkitehtuurikuvaus



## Rakenne



Ohjelma koostuu pelin logiikasta luokassa Tammi ja graafisesta käyttöliittymästä GUI.

Luokka Tammi käyttää olioita Square ja Piece, joista lauta ja nappulat muodostuvat.

graafinen käyttöliittymä GUIlle on omat luokat PiecePanel, SquarePanel, TammiFrame, joiden avulla GUI piirtää laudan ja nappulat.


<img src="https://github.com/matiasja/otm-harjoitustyo/blob/master/dokumentointi/kuvat/luokkakaavio.png" width="600">

## Ominaisuudet

Tammi luokalla ominaisuudet:

Tammi() joka muodostaa laudan.

move(-), isValidMove(-), isValidCapture(-), performMove(-), canContinue(-), jotka toteuttavat liikkumisen sääntöjen mukaisesti.


## Ohjelman puutteet ja jatko

Peliin ei ole vielä lisätty kuninkaita, eikä peliä voi voittaa tai lopettaa muutakuin sulkemalla pelin.
Nämä on kuitenkin helppo lisätä, esim. tekemällä Piece luokkaan kuninkaat Piece.WHITEKING, Piece.BLACKKING.
ja peli lopetus esim tekemällä vuoron päätteeksi Piece laskurin, joka lopettaa pelin jos yhden värisiä nappuloita on 0.

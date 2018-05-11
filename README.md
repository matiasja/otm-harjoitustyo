**OTM 2018 harjoitustyö**

# Tammi

Tammi peli, jolla on graafinen käyttöliittymä.

## Dokumentaatio

[Alustava määrittelydokumentti](https://github.com/matiasja/otm-harjoitustyo/blob/master/dokumentointi/alustava%20m%C3%A4%C3%A4rittelydokumentti.md)

[Työaikakirjanpito](https://github.com/matiasja/otm-harjoitustyo/blob/master/dokumentointi/tuntikirjanpito.md)

[Arkkitehtuuri](https://github.com/matiasja/otm-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

## Releaset

[Release viikko5](https://github.com/matiasja/otm-harjoitustyo/releases/download/viikko5/Tammi1.0.jar)

[Release palautus](https://github.com/matiasja/otm-harjoitustyo/releases/download/Palautus/Tammi-1.0-SNAPSHOT.jar)

## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _Tammi-1.0-SNAPSHOT.jar_

### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella avaamalla selaimella tiedosto _target/site/apidocs/index.html_

### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/matiasja/otm-harjoitustyo/blob/master/Tammi/checkstyle/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_

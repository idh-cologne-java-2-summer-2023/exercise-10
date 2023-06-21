Fortgeschrittene Programmierung (Java 2)


# Übung 10


Klonen Sie dieses Repository direkt in Eclipse und importieren Sie das Maven-Projekt. Legen Sie einen neuen Branch an, den Sie nach Ihrem GitHub-Benutzernamen benennen.


## Aufgabe 1
Im Unterverzeichnis `src/main/resources` finden Sie eine Datei `wine.csv`, und in der `pom.xml` ist die Bibliothek `commons-csv` bereits hinzugefügt. Bei der Datei handelt es sich um eine Sammlung von Weißweinen, die neben diversen chemischen Eigenschaften (Restsüße, Alkoholgehalt etc.) auch eine Qualitätsstufe enthält. Eine CSV-Datei ist im Kern eine Tabelle, in der die einzelnen Spalten durch Komma und die Zeilen durch einen Zeilenumbruch getrennt sind. Die Bibliothek `commons-csv` ist dazu gedacht, solche Dateien zu verarbeiten ([Hier](https://commons.apache.org/proper/commons-csv/user-guide.html) geht es zum User guide, die API Dokumentation gibt es [hier](https://commons.apache.org/proper/commons-csv/apidocs/index.html)). 

Verwenden Sie die Bibliothek, um für jede Spalte den Durchschnitt zu berechnen. Im Gegensatz zu früheren Aufgaben gibt es nun keine Rumpfimplementierung mehr. Sie müssen also eine neue Klasse anlegen, die eine `main`-Methode enthält, und dann eben den Durchschnitt der Spalten berechnet. Es handelt sich dabei um eine Aufgabe, die sich regelmäßig stellt, wenn man mit Daten arbeitet (auch wenn man nicht mit Weinen arbeitet ...).

Hinweis: In der vorliegenden Datei enthalten alle Spalten Dezimalzahlen, d.h. sie können in einen passenden numerischen Datentyp konvertiert werden. Im echten Leben müsste man natürlich noch berücksichtigen, dass manche  Spalten auch Text- oder andere Daten beinhalten können (für die man natürlich auch keinen Durchschnitt berechnen kann).

## Aufgabe 2 (optional)

Sie finden (mal wieder) die Klasse `Document` im aktuellen Projekt. Die kennen Sie bereits aus früheren Projekten, und sie kann benutzt werden um eine Daten einzulesen und zu tokenisieren. Als Übungsmaterial gibt es außerdem mal wieder Bram Stoker's Dracula. Implementieren Sie die Methode `printStats(File f)`. Diese soll eine neue CSV-Datei anlegen, die die folgenden basalen statistischen Daten über den Text enthält:

- Anzahl der Wörter
- Anzahl der Types (also verschiedener Wörter)
- Anzahl der Wörter die kürzer sind als 5 Zeichen
- Häufigkeit des Wortes "blood"
- Das am häufigsten vorkommende Wort
- Das am häufigsten vorkommende großgeschriebene Wort

Diese Informationen sollen in der CSV-Datei jeweils in Spalten stehen, also ungefähr so:

```
Anzahl der Wörter,Anzahl Types,...
17,10,...
```

Verwenden Sie zur Berechnung der einzelnen Daten die Stream-API!

----

Wenn Sie fertig sind, committen Sie alle Ihre Änderungen, und pushen Sie den neuen Branch auf das remote namens `origin` (= GitHub). 
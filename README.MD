**Ny++5 - Ein Schritt weiter**
=======

----------------------

####**Dieses Tutorial beinhaltet folgendes:**
* 0.1 Der Interpreter
	* 0.1.1 Eine Datei ausführen
* 0.2 Der Compiler
	* 0.2.1 Eine Datei kompilieren
	* 0.2.1 Kompilierte Dateien ausführen
* 0.3 Ausgabe
	* 0.3.1 Say
	* 0.3.2 Prv
* 0.4 Variablen
	* 0.3.1 Strings
	* 0.3.2 Integer
* 0.5 Eingabe
* 0.6 Werte verändern
	* 0.4.1 Add
	* 0.4.2 Rem
	* 0.4.3 Div
	* 0.4.4 Mul
	* 0.4.5 Del
* 0.7 Sprungmarken
	* 0.7.1 Deklaration
	* 0.7.2 Aufrufen
	* 0.7.3 Return
* 0.8 Werte vergleichen
	* 0.8.1 Eq
	* 0.8.2 Neq
	* 0.8.3 Geq
	* 0.8.4 Leq
* 0.9 Werte löschen
	* 0.9.1 Sprungmarken löschen
	* 0.9.2 Variablen löschen
* 1.0 Beispiele
	* 1.1 Fibonacci Zahlenfolge
	* 1.2 Fakultaet einer Zahl berechnen
	* 1.3 Taschenrechner
	* 1.4 Kleines Text Adventure

-----------

###0.1 Der Interpreter
####0.1.1 Eine Datei ausführen

------------------------
###0.2 Der Compiler
####0.2.1 Eine Datei kompilieren
####0.2.2 Eine kompilierte Datei ausführen

----------------------
###0.3 Ausgabe
####0.3.1 Say
####0.3.2 Prv

-----------------------
###0.4 Variablen
####0.4.1 Strings
####0.4.2 Integer

-----------------------
###0.5 Eingabe

--------------------
###0.6 Werte verändern
####0.4.1 Add
####0.4.2 Rem
####0.4.3 Div
####0.4.4 Mul
####0.4.5 Del

---------------------

###0.7 Sprungmarken
#### 0.7.1 Deklaration
#### 0.7.2 Aufrufen
#### 0.7.3 Return

----------------------
###0.8 Werte vergleichen
####0.8.1 Eq
####0.8.2 Neq
####0.8.3 Geq
####0.8.4 Leq

---------------------
###0.9 Werte löschen
####0.9.1 Sprungmarken löschen
####0.9.2 Variablen löschen

--------------------
###1.0 Beispiele
####1.1 Fibonacci Zahlenfolge

	{init}
	  defi  zahl1, 1;
	  defi  zahl2, 1;

	  defi  zwi1, [n];
	  defi  zwi2, [n];

	  defi  null, 0;
	{initE}

	{main}
	  prv   zahl1;@
	  mov   zahl2, zwi2;

	  add   zahl1, zahl2;
	  mov   zahl1, zahl2;

	  mov   zwi2, zahl1;
	  geq   zahl2,null,main;
	{mainE}


####1.2 Fakultaet einer Zahl berechnen
####1.3 Taschenrechner
####1.4 Kleines Text Adventure

	{main}
	  defi  cmd, [n];
	  defi  a1,1;

	  defi  a2,2;
	  defi  a3,3;
	  gt    p1;

	{p1}
	  say   "Du stehst in einem Wald";@
	  say   "1. Graben";@
	  say   "2. Norden";@
	  say   "3. Süden";@

	  gt    incmd;
	  eq    cmd,a1,p2a;

	  eq    cmd,a2,p2b;
	  eq    cmd,a3,p2c;

	  neq   cmd,a1,err;
	  neq   cmd,a2,err;
	  neq   cmd,a3,err;

	{p2a}
	  say   "Du gräbst tiefer und tiefer und stößt";@
	  say   "auf eine Truhe Gold!";@
	  say   "Du gehst nach Hause.";@
	  gt    bend;

	{p2b}
	  say   "Du gehst nach Norden und siehst eine tiefe Schlucht.";@
	  say   "Doch leider stolperst du über einen Stein und fällst";@
	  say   "den Abhang hinunter.";@
	  gt    p3b;

	{p2c}
	  say   "Du gehst nach Süden und erblickst Leere. Was tust du?";@
	  say   "1. Du gehst nach Norden";@
	  say   "2. Du gehst nach Hause";@

	  gt    incmd;
	  eq    cmd,a1,p2b;
	  eq    cmd,a2,p3a;

	  neq   cmd,a1,err;
	  neq   cmd,a2,err;

	{p3a}
	  say   "Zuhause angekommen legst du dich hin";@
	  say   "und schläfst ein...";@
	  gt    bend;

	{p3b}
	  @say  "Du wachst in einem Krankenhaus auf,";@
	  say   "wie hat man dich hierherbekommen?";@
	  say   "Im Grunde war dir dies egal, du warst sicher.";@
	  gt    bend;

	{incmd}
	  say   "> ";
	  inp   cmd;
	  return;

	{err}
	  say   "Falsche eingabe! Spiel beendet.";@
	  end;

	{bend}
	  say   "ENDE";@

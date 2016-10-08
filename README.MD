**Ny++5 - Ein Schritt weiter**
=======

----------------------

####**Dieses Tutorial beinhaltet folgendes:**
* 0.0.1 Changelog
* 0.1 Der Interpreter
	* 0.1.1 Eine Datei ausführen
* 0.2 Der Compiler
	* 0.2.1 Eine Datei verschlüsseln
	* 0.2.2 Verschlüsselte Dateien ausführen
* 0.2.2.1 C++ Compiler
	* 0.2.2.1.1 Eine Datei kompilieren
	* 0.2.2.1.2 Eine Datei in Binärcode umwandeln
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
###0.0.1 Changelog

####**Version 16107e**

* **Hinzugefügt** >> Autokompilierer >> `-sys -cc [file]`

###0.1 Der Interpreter
Der Interpreter besteht aus der Datei nypp.bat (Windows) und nypp (Linux/MacOS). Diese Dateien greifen auf die ny++.jar zurück.

Um den Interpreter zu starten einfach den Befehlsprozessor für das jeweilige System starten und dann die Datei nypp.bat/nypp mit der jeweiligen Datei auszuführen:

Mac/Linux:

	./nypp	<Datei>
Windows:

	nypp.bat <Datei>

####**0.1.1 Eine Datei ausführen**
Um eine Datei auszuführen, geben wir sie einfach als erstes Argument an:
Mac/Linux:

	./nypp	trpg.ny5
Windows:

	nypp.bat trpg.ny5
Hier als Beispiel wird die Datei trpg.ny5 ausgewählt.


------------------------
###0.2 Der Obfuscator
Der Obfuscator ist im Interpreter erhalten. Wir führen ihn aus wenn wir mit dem Argument `-c` oder `--compile` arbeiten:

Mac/Linux:

	./nypp	-c <EingabeDatei> <AusgabeDatei>.nct5
Windows:

	nypp.bat -c <EingabeDatei> <AusgabeDatei>.nct5
Der Obfuscator wandelt dann die Eingabedatei, in die Ausgabedatei um. Am Ende hat man dann zwei Dateien, wobei die kompilierte Version mit `.nct5` enden sollte. In der Kompilierten Datei entsteht dann ein bytecodeartiger Text, der sehr unverständlich ist.

####**0.2.1 Eine Datei verschlüsseln**
Wir geben als Argument 1 das Test Text Adventure und als Argument 2 die Ausgabedatei an:
Mac/Linux:

	./nypp	-c trpg.ny5 compiled_trpg.nct5
Windows:

	nypp.bat -c trpg.ny5 compiled_trpg.nct5
####**0.2.2 Eine verschlüsselte Datei ausführen**
Um eine verschlüsselte Datei auszuführen, geben wir sie einfach als erstes Argument an, so als wäre sie gar nicht kompiliert worden:
Mac/Linux:

	./nypp	compiled_trpg.nct5
Windows:

	nypp.bat compiled_trpg.nct5
Hier als Beispiel wird die Datei `compiled_trpg.nct5` ausgewählt.

###0.2.2.1 C++ Compiler

####**0.2.2.1.1 Eine Datei kompilieren**
Es ist möglich, den Ny++ Code bis auf die Befehle `ddv`, `ddm` und `return` in C++ zu übersetzen.
Dies geht folgendermaßen:

Mac/Linux:

	./nypp -cc test.ny5
Windows:

	nypp.bat -cc test.ny5
Die neue C++-Datei heißt dann `test.cpp`

####**0.2.2.1.2 Eine Datei in Binärcode umwandeln**

Es ist möglich, unter Linux und Mac OS, mit dem G++-Compiler von GNU eine Datei sofort zu übersetzen:

	./nypp -sys -cc test.ny5
Damit wird die entstandene C++-Datei sofort kompiliert und danach gelöscht. Übrig bleibt die Binärdatei.

Unter Windows müsste es auch möglich sein, wenn G++ zu `%PATH%` hinzugefügt wurde.

----------------------
###0.3 Ausgabe
In Ny++5 ist es genau wie in Ny++, Werte und Strings auszugeben. Da gibt es zwei Funktionen für:

* `say` für Ausgaben ohne Werte
* `prv` für Werte
####**0.3.1 Say**
Say gibt nur Sätze aus, dies ist einfach umzusetzen:

	say "Hallo Welt";
Das bewirkt, dass `Hallo Welt` auf der Konsole erscheint, ohne Zeilenumbruch. Für einen Zeilenumbruch muss nur ein `@` an das Ende des Befehls angehengt werden:

	say "Hallo Welt";@
Dies gibt dann auch `Hallo Welt` mit Zelenumbruch aus.
####**0.3.2 Prv**
Der `prv`-Befehl gibt nur Werte von Variablen aus:

	prv Variablen_Name;
Dabei wird der Wert der Variable `Variablen_Name` ausgegeben, wie man Variablen erstellt, siehst du in

> 0.4 Variablen

dort wird alles erklärt.
Um auch hier einen Zeileunumbruch zu erzeugen, wieder ein `@` ans Ende des Befehls:

	prv Variablen_Name;@

-----------------------
###0.4 Variablen
Es ist nun endlich möglich, Variablen! Es sind zwei Typen verfügbar: Zum Einen der Integer, zum Anderen der String.
####**0.4.1 Strings**

Strings werden deklariter, indem wir das Schlüsselwort `defs` verwenden:

	defs [Name_der_Variable], [Wert];
Beispiel:

	defs s, "Hallo Welt!";
Damit wird eine Varibale `s` mit dem Wert `Hallo Welt` erstellt.

####**0.4.2 Integer**

Integer, werden genau wie Strings deklariert, bloß dass wir statt `defs`, `defi` verwenden:

	defi i, 7;
Hier wurde die Variable `i` mit dem Wert `7` erstellt.

####**0.4.3 Leere Variablen**

Manchmal brauchen wir auch leere Variablen, diese deklarierenb wir so:

String

	defs s, [n];
Integer:

	defi i, [n];
Dabei steht `[n]` für `null`, was das bedeutet, ist wohl selbsterklärend.

-----------------------
###0.5 Eingabe

Ja, auch Input ist hier möglich, von String und Integer. Dies bewirken wir indem wir das Schlüsselwort `inp` verwenden:

	inp [Variable];
Ein Beispiel:

	defi i,[n];
	inp  i;

	say  "Wert von I: ";
	prv  i;@
Zuerst wird die Variable `i` deklariert, die dann mit `inp` eingegeben wird, und dann ausgegeben wird.
So würde das dann auf der Konsole aussehen:

	3
	Wert von I: 3
Wobei die erste `3` die Eingabe ist.

--------------------
###0.6 Werte verändern

Na klar muss man in jeder Programmiersprache mit Werten arbeiten, sie verändern usw. Also ist das hier auch möglich!

####**0.6.1 Add**

####bei Strings

Bei Strings wird der jeweilige String einfach zur Varibale hinzuadiert, aus `s` = `Hallo ` in ...

	defs s, "Hallo ";
	defs w, "Welt!";

	add s,w;
	prv s;@
... wird `s` = `Hallo Welt!`, dabei wird `w` nicht gelöscht.

####bei Integern

Bei Integern wird dann eine einfache Addition ausgeführt:

	defi i, 8;
	defi i2, 2;

	add i, i2;
	say  "I: ";
	prv i;@
`i` = `10`
`i2` wird nicht gelöscht!

####**0.6.2 Rem**

####bei Strings

Bei Strings könnte dies eine sehr nützliche Funktion sein, denn es ist möglich, Strings in Strings zu löschen:

	defs s, "Hallo Welt mal wieder!";
	defs r, " mal wieder";

	rem s, r;
	prv s;@
Aus `s` wird `r` gelöscht, das bedeutet aus `Hallo Welt mal wieder!`(s) wird `Hallo Welt!`(r gelöscht).

####bei Integern

Bei Integern wird dann eine einfache Subtraktion ausgeführt:

	defi i, 8;
	defi i2, 2;

	rem i, i2;
	say  "I: ";
	prv i;@
`i` = `6`
`i2` wird nicht auf `0` gesetzt!

####**0.6.3 Div**
**!!! => Nicht bei Strings möglich**

Es ist möglich, Integer zu dividieren:

	div [Variable1], [Variable2];

In Ny++5 wird keiner der beiden Variablen gelöscht, es wird lediglich zur Variable1 Variable2 multipliziert.
Beispiel dazu:

	defi i, 8;
	defi a, 2;

	div i, a;
	say "I: ";
	prv i;@

`I: 4`, ist doch logisch, oder?

####**0.6.4 Mul**
**!!! => Nicht bei Strings möglich**

Es ist möglich, Integer zu multiplizieren:

	mul [Variable1], [Variable2];

In Ny++5 wird keiner der beiden Variablen gelöscht, es wird lediglich zur Variable1 Variable2 multipliziert.
Beispiel dazu:

	defi i, 8;
	defi a, 2;

	mul i, a;
	say "I: ";
	prv i;@

`I: 16`, ist doch logisch, oder?

####**0.6.5 Del**

Eine genaue Del-Funktion gibt es nicht, es ist jedoch möglich mit der Rem-Funktion eine Variable zurückzusetzen:

	defs a, "Hallo Welt!";
	rem a, a;

	say "A: ";
`rem a, a;` löscht `a` aus `a`, das ist dann `NICHTS`.

---------------------

###0.7 Sprungmarken

Auch hier werden Sprungmarken nicht ausgelassen.

#### **0.7.1 Deklaration**

Wir deklariern Sprungmarken wie in Ny++, mit Klammer-Auf und Klammer-Zu:

	{marke}

#### **0.7.2 Aufrufen**

Wenn eine Sprungmarke deklariert wurde, ist es möglich von jeder Stelle des Codes zu dieser Marke zu springen:

	gt marke;

#### **0.7.3 Return**

Es hier etwas ganz tolles möglich, das der Sprache noch viele Male das Leben retten wird. Der Befehl `return` springt zum letzten aufgerufenen Sprung:

	{main}
		say	"Hallo ";
		gt  marke;
		say	"!";
		end;

	{marke}
		say "Welt";
		return;

Return springt zum letzten `gt` und führt von da aus die nächsten Befehle aus.


----------------------
###0.8 Werte vergleichen

In Ny++5 kann man genauso wie in Ny++ Werte vergleichen. Die Funktionen sind komplett gleich, außer dass statt Zellen Variablen verglichen werden.

Dabei ist es immer so aufgebaut:

		[?]eq [Variable], [Vatiable2], [Sprungmarke];

####**0.8.1 Eq**

Wir vergleichen zwei Variablen und prüfen auf Gleichheit, wenn dies so ist, springen wir zur Marke `marke`

		defs	h, "Hallo";
		defs  h2, "Hallo";

		eq		h,h2,marke;
		say		"Variablen sind ungleich!";
		end;

		{marke}
			say		"Variablen sind gleich!";
			end;

####**0.8.2 Neq**

Wir vergleichen zwei Variablen und prüfen auf Ungleichheit `neq`, wenn dies so ist, springen wir zur Marke `marke`

		defs	h, "Hallo";
		defs  h2, "Hallo";

		neq		h,h2,marke;
		say		"Variablen sind gleich!";
		end;

		{marke}
			say		"Variablen sind ungleich!";
			end;

####**0.8.3 Geq**

Wenn wir zwei Variablen vergleichen, die wir prüfen wollen ob sie einen Größenunterschied haben (h>h2), dann nutzen wir `geq`:

		defi	h, 9;
		defi 	h2, 3;

		geq		h,h2,marke;
		say		"H2 ist größer!";
		end;

		{marke}
			say		"H ist größer!";
			end;

####**0.8.4 Leq**

Wenn wir zwei Variablen vergleichen, die wir prüfen wollen ob sie einen Größenunterschied haben (h<h2), dann nutzen wir `geq`:

		defi	h, 3;
		defi 	h2, 9;

		geq		h,h2,marke;
		say		"H2 ist kleiner!";
		end;

		{marke}
			say		"H ist kleiner!";
			end;
---------------------
###0.9 Werte löschen
####**0.9.1 Sprungmarken löschen**

Es ist auch möglich Sprungmarken zu löschen:

	ddm		[Name_der_Sprungmarke];

####**0.9.2 Variablen löschen**

So können wir auch Variablen löschen:

	ddv		[Name_der_Variable];

**Danach sind diese Werte komplett WEG! Sie sind NICHT wiederherstellbar.**

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

	{init}
	  defi  input, [n];
	  defi  ctr, [n];

	  defi  null, [n];
	  defi  tmp, [n];

	  defi  ctrm, [n];
	  defi  a1, 1;

	  say   "> ";
	  inp   input;

	  mov   input, tmp;
	  rem   input, a1;

	  mov   input, ctrm;
	{initE}

	{main}
	  add   ctr, a1;
	  mul   tmp, ctr;

	  leq    ctr,ctrm,main;
	  prv    tmp;@
	{mainE}


####1.3 Taschenrechner

	{init}
	  {vinit}
	    defi  a11, 2;
	    defi  a2, [n];
	    defi  a1, [n];

	    defi  a3, [n];
	    defi  a0, [n];
	    defi  a12, 0;

	    defi  a13, 1;
	    defi  a14, 2;
	    defi  a4, [n];

	    say   "0 > ";
	    inp   a0;
	    say   "1 > ";
	    inp   a1;

	    mov   a0, a2;
	    mov   a1, a3;
	{initE}

	{main}
	  gt    dz;
	  {gz}
	    say   "Die eingegebene Zahl ist gerade!";@
	    gt    dze;
	  {ngz}
	    say   "Die eingegebene Zahl ist nicht gerade!";@
	    gt    dze;
	  {dz}
	    mod   a1, a11;

	    eq    a1,a12,gz;
	    neq   a1,a12,ngz;

	    gt    backup;
	    {dze}

	  {addition}
	    gt    backup;

	    add   a0, a1;
	    say   "Addition: ";
	    prv   a0;@

	    gt    backup;

	  {subtraktion}
	    rem   a0, a1;
	    say   "Subtraktion: ";
	    prv   a0;@

	    gt    backup;

	  {multiplikation}
	    mul   a0, a1;
	    say   "Multiplikation: ";
	    prv   a0;@

	    gt    backup;

	  {division}
	    div   a0, a1;
	    say   "Division: ";
	    prv   a0;@

	    gt    backup;

	  say   "Berechnung beendet!";@@
	  {endcalc}
	    say   "1. Wiederholen";@
	    say   "2. Ende";@

	    say   "> ";
	    inp   a4;
	    eq    a4,a13,init;
	    eq    a4,a14,mainE;

	    neq   a4,a13,err;
	    neq   a4,a14,err;

	  {err}
	    say  "Die Eingabe war nicht korrekt!";@
	    gt   endcalc;

	  {backup}
	    mov   a2, a0;
	    mov   a3, a1;
	    return;

	{mainE}
	end


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

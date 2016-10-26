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
	* 0.4.1 Strings
		* 0.4.1.1 Weiteres zu Strings
	* 0.4.2 Integer
		* 0.4.2.1 Random
		* 0.4.2.2 FOS - Das Betriebssystem ermitteln
		* 0.4.2.3 Integer in ASCII Zeichen umwandeln
* 0.5 Eingabe
* 0.6 Werte verändern
	* 0.6.0.1 Mov
	* 0.6.0.2 Moi
	* 0.6.0.3 Mos
	* 0.6.1 Add
	* 0.6.2 Rem
	* 0.6.3 Div
	* 0.6.4 Mul
	* 0.6.5 Del
* 0.7 Sprungmarken
	* 0.7.1 Deklaration
	* 0.7.2 Aufrufen
* 0.8 Werte vergleichen
	* 0.8.1 Eq
	* 0.8.2 Neq
	* 0.8.3 Geq
	* 0.8.4 Leq
* 2.0 Dateien einbinden (inludieren)

-----------
###0.0.1 Changelog

####**Version 161026i**

*	**Hinzugefügt** >> Moi >> Integer Werte in Variablen verschieben >> 0.6.0.2 Moi
* **Hinzugefügt** >> Mos >> String Werte in Variablen verschieben >> 0.6.0.3 Mos
* **Hinzugefügt** >> Sti >> Integer in ASCII-Zeichen umwandeln >>

####**Version 161023i**

* **Hinzugefügt** >> Include >> Eine Datei includieren >> 2.1 Include
* **BugFix** >> Semikolon Bugfix >> Semikolon wird nun am Ende eines Befehls erwartet

####**Version 16109h**

* **Entfernt** >> Return >> Zum letzten Sprung zurückkehren
* **Verbessert** >> Error Ausgabe zeigt Zeilennummer an >> [ (Zeile):(Stelle) ] [ ERR ]:[ ... ]
* **Hinzugefügt** >> System-Variable >> FOS >> 0.4.2.2


####**Version 16108h**

* **Hinzugefügt** >> Interpreter >> neue Parameter
* **BugFix** >> Variable >> Falscher-Typ-Error
* **Hinzugefügt** >> System-Variable >> Random >> 0.4.2.1

####**Version 16108g**

* **BugFix** >> Compiler >> `-sys` Parameter gefixt, danke an NetLamp :)!

####**Version 16108e**

* **Entfernt** >> DDM >> Sprungmarken löschen
* **Entfernt** >> DDV >> Variablen löschen

####**Version 16107e**

* **Hinzugefügt** >> Autokompilierer >> `-sys -cc [file]`

####**Version 16103**

* **Hinzugefügt** >> String >> Verbotene Zeichen schreiben >> 0.4.1.1 Weiteres zu Strings

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

	./nypp -r	trpg.ny5
Windows:

	nypp.bat -r trpg.ny5
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

	./nypp -r compiled_trpg.nct5
Windows:

	nypp.bat -r compiled_trpg.nct5
Hier als Beispiel wird die Datei `compiled_trpg.nct5` ausgewählt.

###0.2.2.1 C++ Compiler

####**0.2.2.1.1 Eine Datei kompilieren**
Es ist möglich, den Ny++5 Code in C++ zu übersetzen.
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

**0.4.1.1 Weiteres zu Strings**

Es gibt verschiedene Zeichen die in Strings ersetzt werden:

* `%aX` >> `"`
* `%eX` >> `'`
* `%tX` >> `\t`
*	`%nX` >> `\n`

Das heißt aus `%aXHallo Welt%aX` wird `"Hallo Welt"`. Praktisch.

####**0.4.2 Integer**

Integer, werden genau wie Strings deklariert, bloß dass wir statt `defs`, `defi` verwenden:

	defi i, 7;
Hier wurde die Variable `i` mit dem Wert `7` erstellt.

**0.4.2.1 Random**

Es ist auch möglich in Ny++5 zufällig generierte Zahlen zu erzeugen. Diese Zufallszahlen, sind in der Variable `_rnd` gespeichert und können von da aus abgerufen werden.

**0.4.2.2 FOS - Das Betriebssystem ermitteln**

Ny++5 bietet eine Möglichkeit das Betriebssystem zu ermitteln. Dies geht mit der System-Variable `_fos`, die auch im Compiler funktioniert. Sie beinhaltet eine Zahl, wo jede Zahl für ein Betriebssystem steht:

* `1` >> Windows
* `2` >> MacOS und FreeBSD
* `3` >> Linux/Unix
* `4` >> Anderes

**NOTIZ: System-Variablen sind nicht beschreibbar!**

**0.4.2.3 Integer in ASCII-Zeichen umwandeln**

Um einen Integer Wert in ein ASCII-Zeichen umzuwandeln,
gibt es folgenden Befehl:

	sti [Quelle], [Ziel];

In Sti, wird der Integer-Wert der Quelle, als ASCII-Zeichen in Ziel gespeichert.
So würden wir ein "A" ausgegeben:

	defi ASCII_NUMBER_A, 65;
	defs ASCII_A, [n];        		  ? [n] wird im nächsten Kapitel beschrieben ?
													  		  ? Alles was in Fragezeichen steht, ist ein ?
	sti ASCII_NUMBER_A, ASCII_A;	  ? Kommentar und wird Ignoriert.            ?
	prv ASCII_A;

Durch Sti wird der Wert der Variable `ASCII_NUMBER_A` in ein ASCII-Zeichen umgewandelt und in die String-Variable `ASCII_A` gespeichert. Die Variablen müssen dabei nicht mit `ASCII_` oder `ASCII_NUMBER_` beginnen. Dies war hier nur ein Beispiel.


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

####**0.6.0.1 Mov**

####Mov

In Ny++5 kann man Werte mit anderen Werten überschreiben, also Variablen setzen und deren Wert mit einem anderen ersetzen:

	mov [Quelle], [Ziel];
Das würde dann mit diesem Code...

	defs s, "Hallo 1";
	defs s2, "Hallo 2";

	mov s2, s;
	prv s;@
... aus `Hallo 1` in `s`, ein `Hallo 2` machen. Der Wert von s wird mit dem aus s2 überschrieben. Mit Mov ist es jedoch nur möglich, Variablen in Variablen zu verschieben.

####Moi

Damit wir jedoch auch Werte in Variablen verschieben können, gibt es `moi`:

	defi s, 78;
	moi 97, s;
Moi verschiebt einen Zahlenwert in eine Variable vom Typen Integer. Es sind bei Moi nur Integer möglich!

####Mos

Um dann auch die Strings abzudecken, haben wir `mos`:

	defs s, "Hallo 1";
	mos "Hallo 2", s;
Damit wird der Wert von `s` mit `Hallo 2` überschrieben.


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


----------------------
###0.8 Werte vergleichen

In Ny++5 kann man genauso wie in Ny++ Werte vergleichen. Die Funktionen sind komplett gleich, außer dass statt Zellen Variablen verglichen werden.

Dabei ist es immer so aufgebaut:

		[?]eq [Variable], [Variable2], [Sprungmarke];

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

----------------------

###2.0 Dateien einbinden (inludieren)

Es ist möglich, die Werte, den Code und die Variablen anderer Dateien zu übernehmen.
Dies geht mit einem Präprozessorbefehl (Dieser Befehl wird noch vor dem eigentlichen Ausführen des Codes ausgeführt) names `inc`:

	#inc Pfad/Zur/Datei.ny5

Damit fügen wir den ganzen Code einer Datei an dieser Stelle ein.

Bei Windows sieht das dann so aus:

	#inc Pfad\Zur\Datei.ny5

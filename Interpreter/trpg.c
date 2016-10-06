#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string.h>
using namespace std;

int main()
{

main:
int cmd = 0;
int a1 = 1;
int a2 = 2;
int a3 = 3;
goto p1;
p1:
printf("Du stehst in einem Wald");
printf("\n");
printf("1. Graben");
printf("\n");
printf("2. Norden");
printf("\n");
printf("3. Süden");
printf("\n");
printf("> ");
cin >> cmd;
if (cmd == a1)
	goto p2a;
if (cmd == a2)
	goto p2b;
if (cmd == a3)
	goto p2c;
if (cmd != a1)
	goto err;
if (cmd != a2)
	goto err;
if (cmd != a3)
	goto err;
p2a:
printf("Du gräbst tiefer und tiefer und stößt");
printf("\n");
printf("auf eine Truhe Gold!");
printf("\n");
printf("Du gehst nach Hause.");
printf("\n");
goto bend;
p2b:
printf("Du gehst nach Norden und siehst eine tiefe Schlucht.");
printf("\n");
printf("Doch leider stolperst du über einen Stein und fällst");
printf("\n");
printf("den Abhang hinunter.");
printf("\n");
goto p3b;
p2c:
printf("Du gehst nach Süden und erblickst Leere. Was tust du?");
printf("\n");
printf("1. Du gehst nach Norden");
printf("\n");
printf("2. Du gehst nach Hause");
printf("\n");
printf("> ");
cin >> cmd;
if (cmd == a1)
	goto p2b;
if (cmd == a2)
	goto p3a;
if (cmd != a1)
	goto err;
if (cmd != a2)
	goto err;
p3a:
printf("Zuhause angekommen legst du dich hin");
printf("\n");
printf("und schläfst ein...");
printf("\n");
goto bend;
p3b:
printf("\n");
printf("Du wachst in einem Krankenhaus auf,");
printf("\n");
printf("wie hat man dich hierherbekommen?");
printf("\n");
printf("Im Grunde war dir dies egal, du warst sicher.");
printf("\n");
goto bend;
err:
printf("Falsche eingabe! Spiel beendet.");
printf("\n");
exit(0);
bend:
printf("ENDE");
printf("\n");

return 0;

}

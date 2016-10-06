#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string.h>
using namespace std;

int main()
{

main:
string inpf = "";
string inpf2 = "";
printf("Inp: ");
getline(cin, inpf);
printf("Inp2: ");
getline(cin, inpf2);
inpf = inpf+inpf2;
printf("TOG: ");
cout << inpf;
printf("\n");
exit(0);

return 0;

}

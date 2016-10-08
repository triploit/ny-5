#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <iostream>
#include <string.h>
using namespace std;

int main()
{
	srand(time(NULL));
	int _rnd = rand() % 10000;

main:
	int i = 0;
	i = _rnd;

output:
	printf("Random: ");
	cout << i;
	cout << endl;

return 0;

}

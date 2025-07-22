#include<stdio.h>
int main()
{
	int N, flag, cnt = 0;
	char letter[101];
	scanf("%d", &N);
	while (N--)
	{
		scanf("%s", letter);
		for (int i = 0; i < strlen(letter); i++){
			flag = 0;
			for (int j = 0; j < strlen(letter); j++){
				if (letter[i] == letter[j]){
					if (letter[i] != letter[j + 1])
						flag = 1;
				}
				else if (letter[i] != letter[j] && flag == 1){
					if (letter[i] == letter[j + 1]){
						flag = 2;
						break;
					}
				}
			}
			if (flag == 2)
				break;
		}
		if (flag != 2)
			cnt++;
	}
	printf("%d", cnt);
 }
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
typedef struct math
{
	char data;
	struct math* next;
}math;
typedef struct linked_list
{
	math* top;
}LK;
LK* init()
{
	LK* lk = (LK*)malloc(sizeof(LK));
	lk->top = (math*)malloc(sizeof(math));
	lk->top->next = NULL;
	return lk;
}
int open(char data)
{
	if (data == '[')
	{
		return 1;
	}
	else if (data == '{')
	{
		return 1;
	}
	else if (data == '(')
	{
		return 1;
	}

	//위는 열린 괄호 체크, 아래는 닫힌 괄호 체크

	else if (data == ']')
	{
		return -1;
	}
	else if (data == '}')
	{
		return -1;
	}
	else if (data == ')')
	{
		return -1;
	}
	else
		return 0;
}
char pop(LK* lk)
{
	math* p;
	char data;
	p = lk->top->next;
	data = p->data;
	lk->top->next = p->next;
	free(p);
	return data;
}
void push(LK* lk, char mathexp)
{
	math* newnode = (math*)malloc(sizeof(math));
	newnode->data = mathexp;
	if (lk->top == NULL)
	{
		newnode->next = NULL;
		lk->top->next = newnode;
	}
	else
	{
		newnode->next = lk->top->next;
		lk->top->next = newnode;
	}
}
int isCounterpart(char opened, char closed)
{
	if ((opened == '(') && (closed == ')'))
	{
		return 1;
	}
	else
		return 0;
}
int isEmpty(LK* lk)
{
	if (lk->top->next != NULL)
	{
		math* p = lk->top->next;
		math* erase;
		while (p != NULL)
		{
			erase = p->next;
			free(p);
			p = erase;
		}
		free(lk->top);
		free(lk);
		return 0;
	}
	else
	{
		free(lk->top);
		free(lk);
		return 1;
	}
}
int isBalanced(char mathexp[]) //open에서 1이면 열린 괄호, -1이면 닫힌 괄호
{
	int ch;
	int isit = 1; // 0 = 틀림, 1 = 맞음
	char data, tmp;
	LK* exp = init();
	for (int i = 0; mathexp[i] != NULL; i++)
	{
		tmp = mathexp[i];
		ch = open(mathexp[i]);
		if (ch == 1)
		{
			push(exp, mathexp[i]);
		}
		else if (ch == -1)
		{
			if (exp->top->next == NULL)
			{
				return 0;
			}
			else
			{
				data = pop(exp);
				if (isCounterpart(data, tmp) == 0)//괄호가 서로 짝이 아니라면
				{
					return 0;
				}
			}
		}
	}
	isit = isEmpty(exp);
	return isit;
}
int main()
{
	int isit, N = 0, k;
	char mathexp[1001];
	scanf("%d", &k);
	getchar();
	for (int j = 0; j < k; j++)
	{
		gets(mathexp);
		isit = isBalanced(mathexp);
		for (int i = 0; mathexp[i] != NULL; i++)
		{
			if ((mathexp[i] == '(') || (mathexp[i] == ')'))
			{
				N++;
			}
		}
		if (isit == 1)
		{
			printf("YES\n");
		}
		else
			printf("NO\n");
	}
}
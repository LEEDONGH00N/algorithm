#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<iostream>
#include <algorithm>
using namespace std;
int arr[11];
int main()
{
	int n, num;
	arr[1] = 1;
	arr[2] = 2;
	arr[3] = 4;
	for (int i = 4; i <= 11; i++)
	{
		arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
	}
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> num;
		cout << arr[num] << "\n";
	}
}
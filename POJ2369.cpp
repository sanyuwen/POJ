// cppTest.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include "pch.h"
#include <iostream>
#include <vector>
#include <map>
#include <numeric>
using namespace std;

int gcd(int m, int n) {
	int t;
	if (m > n) {
		t = m;
		m = n;
		n = t;
	}
	while (n%m != 0) {
		t = m;
		m = n % m;
		n = t;
	}
	return m;
}

int lcm(int m, int n) {
	return int(m*n / gcd(m, n));
}

int lcm_list(vector<int>& values) {
	return accumulate(values.begin(), values.end(), 1, lcm);
}

int single_order(int n, map<int, int>& p) {
	int ans = 1, m=n;
	while (p[m]!=n) {
		m = p[m];
		ans++;
	}
	return ans;
}

int main()
{
	int n, a;
	cin >> n;
	map<int, int> p;
	for (int i = 1; i <= n; i++) {
		cin >> a;
		p[i] = a;
	}
	vector<int> orders;
	for (int i = 1; i <= n; i++) {
		orders.push_back(single_order(i, p));
	}
	printf("%d", lcm_list(orders));
	return 0;
}
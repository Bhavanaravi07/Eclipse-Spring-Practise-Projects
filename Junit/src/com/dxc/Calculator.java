package com.dxc;

public class Calculator {
	
	public static int add(int n1, int n2) {
		int res;
		res = n1 + n2;
		return res;
	}
	
	public static int sub(int n1, int n2) {
		int res;
		res = n1 - n2;
		return res;
	}
	
	public static int mul(int n1, int n2) {
		int res;
		res = n1 * n2;
		return res;
	}
	
	public static double div(double n1, double n2) {
		double res;
		if(n2 == 0) {
			throw new IllegalArgumentException("Number can not be divided by 0!");
		}
		res = n1 / n2;
		return res;
	}

}

package com;

import javax.jws.WebService;

@WebService
public class Demo {
	/*public String hello() {
		return "hello world";
	}*/
	public int add(int a, int b) {
		return a+b;
	}
	/*public int sub(int a,int b) {
		return a-b;
	}
	public int mul(int a,int b) {
		return a*b;
	}*/
}

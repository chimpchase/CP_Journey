package com.codeforce.practice._800;

import java.util.Scanner;

public class LineTrip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		accept();
	}
	static void accept() {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1;i<=t;i++) {
			int a = sc.nextInt();
			int x = sc.nextInt();
			int ar[] = new int[a];
			for(int j=0;j<a;j++) {
				ar[j]=sc.nextInt();
			}
			System.out.println(solve(ar, x));
		}
		
	}
	static int solve(int ar[],int x) {
		int max = 0;
		int current =0;
		for(int i:ar) {
			int v = i-current;
			if(v>max) {
				max=v;
			}
			current = i;
		}
		int t = 2*(x-ar[ar.length-1]);
		if(t>max) {
			max=t;
		}
		return max;
	}

}

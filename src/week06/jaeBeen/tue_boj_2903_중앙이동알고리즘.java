package boj_2903_중앙이동알고리즘;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int start = 2;
		for(int i=0; i<n; i++) {
			start += Math.pow(2, i);
		}
		System.out.println((int)Math.pow(start, 2));
	}
}

package boj_21920_서로소평균;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int x = sc.nextInt();
		
		long sum = 0;
		int count = 0;
		
		for(int i=0; i<n; i++) {
			if(gcd(arr[i], x) == 1) {
				sum += arr[i];
				count++;
			}
		}
		System.out.println(sum/count);
		
		
		
	}
	static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a%b);
	}
}

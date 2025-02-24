package boj_5347_LCM;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			long a = sc.nextInt();
			long b = sc.nextInt();
			long gcd = gcd(a, b);
			long multi = a * b;
			System.out.println(multi / gcd);
		}
	}
	static long gcd(long a, long b) {
		if(b == 0) {
			return a;
		}
		return gcd(b,a%b);
	}
}

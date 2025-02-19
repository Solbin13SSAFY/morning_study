package boj13305주유소;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] d = new long[n-1];
		long[] city = new long[n];
		for(int i=0; i<n-1; i++) {
			d[i] = sc.nextLong();
		}
		long cost = 0;
		long min = Long.MAX_VALUE;
		for(int i=0; i<n; i++) {
			if(i > 0) {
				cost += (d[i-1]*min);
			}
			city[i] = sc.nextLong();
			if(min > city[i]) {
				min = city[i];
			}
		}
//		for(int i=1; i<n; i++) {
//			long min = Long.MAX_VALUE;
//			for(int j=0; j<i; j++) {
//				if(min > city[j]) {
//					min = city[j];
//				}
//			}
//			cost += (min*d[i-1]);
//		}
		System.out.println(cost);
	}
}

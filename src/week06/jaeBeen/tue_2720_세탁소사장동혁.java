package boj_2720_세탁소사장동혁;

import java.util.Scanner;

public class Main {
	
	static int[] coins = {25,10,5,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int n = sc.nextInt();
			
			for(int j=0; j<4; j++) {
				if(n != 0) {
					System.out.print(n/coins[j] + " ");
					n = n % coins[j];
				} else {
					System.out.print(0 + " ");
				}
			}
			
			System.out.println();
		}
	}
}

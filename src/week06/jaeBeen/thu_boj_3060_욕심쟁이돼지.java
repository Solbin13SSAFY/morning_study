package boj_3060_욕심쟁이돼지;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			int n = sc.nextInt();
			long sum = 0;
			for(int i=0; i<6; i++) {
				sum += sc.nextInt();
			}
			int count = 1;
			while(n >= sum) {
				count++;
				sum *= 4;
			}
			System.out.println(count);
		}
	}
}

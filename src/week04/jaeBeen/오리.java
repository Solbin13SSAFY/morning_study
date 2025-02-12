package boj12933오리;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int min = 0;
		if(str.length() % 5 != 0) {
			System.out.println(-1);
		} else {
			int[] count = new int[5];
			loop :
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				if(c == 'q') {
					count[0]++;
				} else if(c == 'u') {
					count[1]++;
				} else if(c == 'a') {
					count[2]++;
				} else if(c == 'c') {
					count[3]++;
				} else if(c == 'k') {
					count[4]++;
				}
				for(int j=count.length-1; j>0; j--) {
					if(count[j]-count[j-1] > 0) {
						System.out.println(-1);
						return;
					}
				}
				if(count[0] - count[4] > min) {
					min = count[0] - count[4];
				}
			}
			System.out.println(min);
		}
	}
}

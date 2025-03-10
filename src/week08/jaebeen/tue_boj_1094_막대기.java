package boj_1094_막대기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int len = 64;
		int count = 0;
		// 남은 길이가 1까지는 돌려준다
		while(len>=1) {
			// 지금 자른 막대기 길이만큼 빼도 남은게 있니 
			if(n-len >= 0) {
				n -= len;
				count++;
			}
			// 남은게 없으면 끝
			if(n == 0) {
				break;
			}
			// 반으로 갈라 준다
			len = len >> 1;
		}
		System.out.println(count);
	}
}

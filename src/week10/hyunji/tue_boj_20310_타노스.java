package week10.hyunji;

import java.util.Scanner;

public class tue_boj_20310_타노스 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();

		int zeroCnt = 0;
		int oneCnt = 0;

		for(int i=0; i<S.length(); i++) {
			if (S.charAt(i) == '0') zeroCnt++;
			else oneCnt++;
		}

		zeroCnt = zeroCnt/2;
		oneCnt = oneCnt/2;

		StringBuilder sb = new StringBuilder(S);

		for(int i=0; i<sb.length(); i++) {
			if(sb.charAt(i) == '1') {
				sb.setCharAt(i, '#');
				oneCnt--;
			}
			if(oneCnt == 0) break;
		}

		for (int i=sb.length()-1; i>=0; i--) {
			if (sb.charAt(i) == '0') {
				sb.setCharAt(i, '#');
				zeroCnt--;
			}
			if (zeroCnt == 0) break;
		}

		for (int i=0; i<sb.length(); i++) {
			if (sb.charAt(i) == '0' || sb.charAt(i) == '1') {
				System.out.print(sb.charAt(i));
			}
		}
		System.out.println();
	}
}

package boj_3048_개미;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int left = sc.nextInt();
		int right = sc.nextInt();
		int total = left + right;
		char[][] arr = new char[left+right][2];
		
		String str = sc.next();
		for(int i=left-1; i>=0; i--) {
			arr[i][0] = str.charAt(left-i-1);
			arr[i][1] = 'L';
		}
		str = sc.next();
		for(int i=0; i<right; i++) {
			arr[i+left][0] = str.charAt(i);
			arr[i+left][1] = 'R';
		}
		int turn = sc.nextInt();
		
		for(int i=0; i<turn; i++) {
			for(int j=0; j<total-1; j++) {
				if(arr[j][1] == 'L' && arr[j+1][1] == 'R') {
					char[] tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
					j++;
				}
			}
		}
		for(int i=0; i<total; i++) {
			System.out.print(arr[i][0]);
		}
	}
}

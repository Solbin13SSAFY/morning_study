package boj_15721_번데기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int t = sc.nextInt();
		int m = sc.nextInt();
		
		// 01010011 0101000111 0      8 10 12  456
		// 몇번 째 문장에 나오는지 찾기
		int count = 0;
		int per = 4;
		int tmp = t;
		while(true) {
			int minus = per + count;
			if(tmp - minus <= 0) {
				break;
			}
			tmp -= minus;
			count++;
		}
		
		int size = 0;
		for(int i=0; i<count; i++) {
			size += (8 + (i*2));
		}
		
		
		if(tmp <= 2) {
			if(m == 0) {
				size += ((tmp-1)*2) + 1;
			} else {
				size += tmp*2;
			}
			
		} else {
			size += 4+(tmp-2);
			if(m == 1) {
				size += count+2;
			}
		}
		System.out.println((size-1+n)%n);
	}
}

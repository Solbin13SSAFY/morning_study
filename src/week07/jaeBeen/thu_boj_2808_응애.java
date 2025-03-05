package boj_28088_응애_EASY;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static boolean[] now;
	static boolean[] next;
	static boolean[] tmp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		long K = sc.nextLong();
		
		now = new boolean[N];
		next = new boolean[N];
		
		for(int i=0; i<M; i++) {
			int num = sc.nextInt();
			now[num] = true;
		}
		
		for(int i=0; i<K; i++) {
			Arrays.fill(next, false);
			for(int j=0; j<N; j++) {
				boolean flag = now[j];
				if(flag) {
					next[(j-1+N)%N] = !next[(j-1+N)%N];
					next[(j+1)%N] = !next[(j+1)%N];
				}
			}
			tmp = now;
			now = next;
			next = tmp;
		}
		int count = 0;
		for(int i=0; i<N; i++) {
			if(now[i]) {
				count++;
			}
		}
		System.out.println(count);
	}
}

package week05.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class thu_boj_5347_LCM {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// LCM은 두 수의 곱에 GCD를 나눈 것
			sb.append((long)a*b/gcd(a,b)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	// 유클리드 호제법
	static long gcd(long x,long y) {
		return y==0?x:gcd(y,x%y);
	}
}



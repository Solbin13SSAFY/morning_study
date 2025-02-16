package week05.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class thu_boj_21920_서로소평균 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		long sum = 0;
		
		for (int i=0;i<n;i++) {
			// GCD가 1인 수가 서로소임
			if (gcd(arr[i],x)==1) {
				// 서로소만 카운트 하여 평균을 구한다
				sum+=arr[i];
				cnt++;
			}
		}
		System.out.println(sum/(double)cnt);
	}
	
	// 유클리드 호제법
	static long gcd(long x,long y) {
		return y==0?x:gcd(y,x%y);
	}
}



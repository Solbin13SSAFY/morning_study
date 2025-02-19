package week05.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class thu_boj_9613_GCD합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine().trim());
			int n = Integer.parseInt(st.nextToken());
			long[] arr= new long[n];
			long sum = 0;
			
			for (int i=0;i<n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 모든 쌍에 대해서 최대공약수를 구한다.
			for (int i=0;i<n-1;i++) {
				for (int j=i+1;j<n;j++) {
					sum+=gcd(arr[i],arr[j]);
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
	
	
	// 유클리드 호제법
	static long gcd(long x,long y) {
		return y==0?x:gcd(y,x%y);
	}
}

package week07.solbin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static boolean[] baby;
	static boolean[] before;
	
	static int n;
	
	public static void main(String args[]) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		baby = new boolean[n];
		before = new boolean[n];
		
		// 초기세팅
		for (int i=0;i<m;i++) {
			int idx = Integer.parseInt(br.readLine());
			baby[idx] = true;
		}
		for (int i=0;i<k;i++) {
			before = Arrays.copyOf(baby, n);
			for (int j=0;j<n;j++) {
				baby[j] = before[b(j-1)]^before[b(j+1)];
			}
		}
		int sum = 0;
		for (int i=0;i<n;i++) {
			sum+=baby[i]?1:0;
		}
		sb.append(sum);
		System.out.println(sb);
	}
	
	static int b(int x) {
		return (x+n)%n;
	}
}
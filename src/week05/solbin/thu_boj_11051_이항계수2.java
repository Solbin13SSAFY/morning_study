package week05.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class thu_boj_11051_이항계수2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	final static int p = 10007;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// 파스칼의 삼각형을 이용함
		// nCr = n-1Cr + n-1Cr-1
		int[][] dp = new int[n+1][n+1];
		dp[0][0] = 1;
		for (int i=1;i<=n;i++) {
			dp[i][0] = 1;
			dp[i][i] = 1;
			for (int j=1;j<i;j++) {
				dp[i][j] = (dp[i-1][j-1]+dp[i-1][j])%p;
			}
		}
		sb.append(dp[n][m]);
		System.out.println(sb);
	}
}
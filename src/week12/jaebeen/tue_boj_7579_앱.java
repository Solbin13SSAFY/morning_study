package boj_7579_앱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] memory = new int[N];
		int[] cost = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		// 앱 최대 100개, 앱 재시작 비용 최대 100
		int[][] dp = new int[N][10001];
		int ans = Integer.MAX_VALUE;
		// 모든 앱에 대해 반복
		for (int i = 0; i < N; i++) {
			// 현재 앱의 비용과 메모리
			int c = cost[i];
			int m = memory[i];

			// 가능한 모든 비용에 대해 반복
			for (int j = 0; j <= 10000; j++) {
				// 첫 번째 앱일 때의 처리
				if (i == 0) {
					// 비용이 현재 앱을 비활성화할 수 있다면 메모리 저장
					if (j >= c) dp[i][j] = m;
				} else {
					// 현재 비용으로 앱을 비활성화할 수 있는 경우
					if (j >= c) {
						// 이전 상태와 현재 앱을 비활성화했을 때를 비교해 더 큰 메모리 저장
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c] + m);
					} else {
						// 현재 앱을 비활성화할 수 없는 경우 이전 값 그대로 유지
						dp[i][j] = dp[i - 1][j];
					}
				}
				// 현재까지 확보한 메모리가 필요한 메모리 이상인 경우
				if (dp[i][j] >= M) {
					// 최소 비용을 갱신
					ans = Math.min(ans, j);
				}
			}
		}
		System.out.println(ans);	
	}
}

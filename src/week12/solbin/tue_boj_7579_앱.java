import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int wholeCost = 0;
		int[] memory = new int[n+1];
		int[] cost = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=n;i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=n;i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			wholeCost += cost[i];
			if (cost[i]==0) m-=memory[i];
		}
		
		
		/*
		 *  배낭의 크기를 메모리(무게)로 잡으면 메모리 초과가 남.
		 *  비용으로 잡을 수는 없을까? 그러면 최대 크기가 10000*100밖에 안되므로 메모리 초과가 나진 않을듯
		 *  주어진 코스트로 줄일 수 있는 최대의 메모리(무게)를 구하면 될듯
		 */

		// 가방 문제에서 무게와 비용을 서로 뒤바꿔서, 최소의 비용으로 최대의 무게(메모리)를 담게 하는 가방문제로 변형시킴
		long[][] dp = new long[n+1][wholeCost+1];
		for (int i=1;i<=n;i++) {
			for (int j=1;j<=wholeCost;j++) {
				int p = memory[i];
				int c = cost[i];
				if (j>=c&&c!=0) {
					// 더 적은 비용으로 더 많은 무게(메모리)를 담을 수 있는지
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-c]+p);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		// 주어진 메모리를 확보할 수 있는 배치중에서 최소비용을 찾음
		for (int i=0;i<=wholeCost;i++) {
			if (dp[n][i]>=m) {
				System.out.println(i);
				return;
			}
		}
//		System.out.println(wholeCost-dp[n][wholeMemory-m]);
	}
}

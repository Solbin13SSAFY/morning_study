package boj_1051_이항계수2;

import java.util.Scanner;
// https://st-lab.tistory.com/162
// 위의 글을 주로 참고하였음
public class Main {
	// n,k의 조합에 대해 발생했던 값을 기록해 두기 위한 2차원 배열
	static int[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		dp = new int[n+1][k+1];
		
//		System.out.println((factorial(n) / factorial(n-k) / factorial(k))%10007);
		System.out.println(combi(n,k));
		
	}
	// n,k가 커지니까 답이 없었다.
	static long factorial(int n) {
		long result = 1;
		for(int i=2; i<=n; i++) {
			result *=i;
		}
		return result;
	}
	// dp 적용이전에는 시간 초과가 있었음, 도저히 떠오르지 않아 블로그 글을 참고하여 진행
	static int combi(int n, int k) {
		// 이전에 만들어 진 적 있는 값이면 해당값을 return
		if(dp[n][k] > 0) {
			return dp[n][k];
		}
		// n개에서 n개를 고르는 경우, n개에서 아무것도 고르지 않는 경우는 1가지뿐
		if(n == k || k == 0) {
			return dp[n][k] = 1;
		}
		// 모드 연산의 덧셈 법칙, n과 k가 아무리 커도 파스칼 법칙에 의해 다른 수의 합으로 표현 될 수 있고
		// 두 수의 합에 모드한 값 = 각 수에 모드한 값의 합에 모드한 값이기 때문에  
		return dp[n][k] = (combi(n-1, k) + combi(n-1, k-1)) % 10007;
	}
}

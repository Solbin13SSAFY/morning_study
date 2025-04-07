package boj_2629_양팔저울;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] dp;
    static int[] weights;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        weights = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0; // 모든 추 무게
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
            sum += weights[i];
        }

        dp = new boolean[N + 1][sum+1]; 

        check(0, 0); // 추 사용 없이 0부터 시작해서 가능한 무게 탐색

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int ball = Integer.parseInt(st.nextToken());

            if (ball > sum) { // 범위를 벗어나는 무게는 측정 불가
                sb.append("N ");
            } else {
                // 마지막 추까지 사용해서 해당 무게 측정 가능하면 'Y', 아니면 'N'
                sb.append(dp[N][ball] ? "Y " : "N ");
            }
        }

        System.out.println(sb); // 결과 출력
    }

    // 가능한 무게 조합 탐색하는 재귀 함수
    static void check(int index, int weight) {
        if (index > N || dp[index][weight]) {
        	return;
        }
        // index번까지 추를 썼을 때 특정 무게가 만들어 질 수 있음?
        dp[index][weight] = true; 

        if (index == N) {
        	return;
        } 

        // 사용 안함
        check(index + 1, weight);
        // 비교대상 무게에 추가
        check(index + 1, weight + weights[index]);
        // 구슬이 있는 곳에 추가
        check(index + 1, Math.abs(weight - weights[index]));
    }
}

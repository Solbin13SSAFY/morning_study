import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int m = sc.nextInt(); //구해야 하는 메모리 크기

        int[] memory = new int[n]; //비활성화 전환시 확보되는 메모리
        int[] cost = new int[n];   //비활성화 전환시 필요한 비용

        int sumCost = 0; //총 비용 => dp배열 크기 결정

        for (int i = 0; i < n; i++) {
            memory[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
            sumCost += cost[i];
        }

        //dp[j]: 비용 j를 사용했을 때 얻을 수 있는 최대 메모리
        int[] dp = new int[sumCost + 1];

        for (int i = 0; i < n; i++) { //i번째 앱을 볼껀데 
            for (int j = sumCost; j >= cost[i]; j--) { //역순으로 순회 -> 중복방지
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
                //i를 선택하지 않는 경우, i를 선택하는 경우
            }
        }

        //최소비용 찾기
        int answer = Integer.MAX_VALUE;
        for (int j = 0; j <= sumCost; j++) {
            if (dp[j] >= m) {
                answer = Math.min(answer, j);
            }
        }

        System.out.println(answer);
    }
}

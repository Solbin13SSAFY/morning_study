package week10.hyunji;

import java.util.*;

public class tue_boj_2212_센서 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        List<Integer> sensors = new ArrayList<>(); //센서 위치

        for (int i = 0; i < N; i++) {
            sensors.add(sc.nextInt());
        }

        Collections.sort(sensors);

        List<Integer> intervals = new ArrayList<>(); //인접 센서 위치 사이 간격
        for (int i = 0; i < N - 1; i++) {
            intervals.add(sensors.get(i + 1) - sensors.get(i));
        }

        Collections.sort(intervals); //센서 사이 간격도 정렬

        int ans = 0;
        for (int i = 0; i < N - K; i++) {
            ans += intervals.get(i); //간격들 작은거부터 (N-K)개 더하기
        }
        System.out.println(ans);
    }
}

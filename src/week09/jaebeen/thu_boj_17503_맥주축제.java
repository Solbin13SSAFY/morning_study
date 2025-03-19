package boj_17503_맥주축제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        long m = Long.parseLong(input[1]);
        int k = Integer.parseInt(input[2]);
        Beer[] beers = new Beer[k];

        for (int i = 0; i < k; i++) {
            input = br.readLine().split(" ");
            int prefer = Integer.parseInt(input[0]);
            int alchol = Integer.parseInt(input[1]);

            Beer beer = new Beer(prefer, alchol);
            beers[i] = beer;
        }
        // 맥주들을 도수 오름차순으로 정렬시킨다.
        Arrays.sort(beers); 
        // 마신 맥주의 선호도 정보를 관리하기 위한 pq
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        
        long total = 0;
        int result = -1;
        for (int i = 0; i < beers.length; i++) {
        	// 맥주 도수 낮은거 순서대로 마신다.
            pq.offer(beers[i].prefer);
            // 마신 맥주의 선호도를 더해준다.
            total += beers[i].prefer;
            // n개 이상 마셨으면 선호도 제일 낮은 맥주 컷
            if (pq.size() > n) {
                total -= pq.poll();
            }
            // n개만큼 마셨는데 선호도 합도 충족했을 때
            if (pq.size() == n && total >= m) {
            	// 지금 마신 맥주의 도수를 가져오자 -> 마셔나갈 수로 도수가 높아짐 
            	// -> 선호도 조건이 충족되는 때에 마신 맥주 도수가 가장 높음이 보장된다
                result = beers[i].level;
                break;
            }
        }
        System.out.println(result);
    }
}

class Beer implements Comparable<Beer> {
    int prefer;
    int level;

    public Beer(int prefer, int alchol) {
        this.prefer = prefer;
        this.level = alchol;
    }
    // 도수의 최솟값을 구하는 문제 -> 낮은 도수로 N개만큼 먹다가보면 언젠가는 선호도 총합이 만족될것임
    @Override
    public int compareTo(Beer arg0) {
        return this.level - arg0.level;
    }
}
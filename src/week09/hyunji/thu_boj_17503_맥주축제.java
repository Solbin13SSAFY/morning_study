// 시간초과 - 문제이해X - 다시풀기

package week09.hyunji;

import java.io.*;
import java.util.*;

class Beer {
    int like; // 선호도
    int level; // 도수

    public Beer(int like, int level) {
        this.like = like;
        this.level = level;
    }
}

// 도수 기준 내림차순
class BeerComparator implements Comparator<Beer> {
    @Override
    public int compare(Beer beer1, Beer beer2) {
        return Integer.compare(beer2.level, beer1.level);  
    }
}

public class thu_boj_17503_맥주축제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  // 맥주 개수
        int m = Integer.parseInt(st.nextToken());  // 선호도 합
        int k = Integer.parseInt(st.nextToken());  // 맥주 종류 

        Beer[] beers = new Beer[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int like = Integer.parseInt(st.nextToken());  
            int level = Integer.parseInt(st.nextToken());   
            beers[i] = new Beer(like, level);
        }

        Arrays.sort(beers, new BeerComparator());

        // 이진 탐색 - 다시 풀기
        int l = 1;
        int r = Integer.MAX_VALUE;
        int answer = -1;

        while (l <= r) {
            int mid = (l + r) / 2;  

            int sumOfLike = 0;        
            int drink = 0;          

            for (int i = 0; i < k; i++) {
                if (beers[i].level <= mid) {  // 도수 <= mid 
                    sumOfLike += beers[i].like;
                    drink++;
                }
                if (drink == n) {  
                    break;
                }
            }

            if (sumOfLike >= m && drink == n) {
                answer = mid;
                r = mid - 1; 
            } else {
                l = mid + 1; 
            }
        }

        System.out.println(answer);
    }
}
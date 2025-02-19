package week05.hyunji;

import java.util.Scanner;

public class thu_boj_11051_이항계수2 {
    static int[][] cache = new int [1001][1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int k = Integer.parseInt(sc.next());
        
        for (int i=0; i<=n; i++) {
            cache[i][0] = 1; //파스칼 삼각형 왼쪽: y축
            cache[i][i] = 1; //파스칼 삼각형 오른쪽: 대각선
        }

        //파스칼 삼각형 참고
        for(int y=2; y<=n; y++) {
            for(int x=1; x<y; x++) { 
                cache[y][x] = cache[y-1][x-1] % 10007 + cache[y-1][x] % 10007;
            }
        }
        
        System.out.println(cache[n][k] % 10007);

    }
}

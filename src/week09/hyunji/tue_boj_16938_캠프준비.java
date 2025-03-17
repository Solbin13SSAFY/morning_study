package week09.hyunji;

import java.util.Arrays;
import java.util.Scanner;

class tue_boj_16938_캠프준비 {
    static int N, L, R, X;
    static int[] arr;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);
        X = Integer.parseInt(input[3]);

        arr = new int[N];
        String[] inputs = sc.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(arr); 

        comb(0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        System.out.println(cnt);
    }

    static void comb(int idx, int sum, int easy, int hard, int pickCnt) {
        if (pickCnt >= 2) { // 최소 2개 선택
            if (L <= sum && sum <= R && (hard - easy) >= X) {
                cnt++;
            }
        }

        for(int i=idx; i<N; i++) {
            comb(i+1, sum+arr[i], Math.min(easy, arr[i]), Math.max(hard, arr[i]), pickCnt+1);
        }
    }
}

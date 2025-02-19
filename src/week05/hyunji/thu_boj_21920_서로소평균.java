package week05.hyunji;

import java.util.*;

public class thu_boj_21920_서로소평균 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.nextLine();

        int x = Integer.parseInt(sc.nextLine());

        long sum = 0; 
        int cnt = 0;
        for(int i=0; i<n; i++) {
            if(gcd(x, arr[i]) == 1) { //서로소: 최대공약수가 1
                sum += arr[i];
                cnt++;
            }
        }

        System.out.println(sum / (double) cnt); //평균
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a%b);
    }
}
package week05.hyunji;

import java.util.Scanner;

public class thu_boj_9613_GCD합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());
        for(int tc=1; tc<=T; tc++) {
            int n = Integer.parseInt(sc.next());
            int[] arr = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
            }
            long sum = 0;
            for(int i=0; i<arr.length-1; i++) {
                for(int j=i+1; j<arr.length; j++) {
                    if(i<j) sum += gcd(arr[i], arr[j]);
                }
            }

            System.out.println(sum);
        }
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a%b);
    }
}

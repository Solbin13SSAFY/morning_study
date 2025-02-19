package week05.hyunji;

import java.util.Scanner;

public class thu_boj_5347_LCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for(int tc=1; tc<=T; tc++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            //최소공배수
            long lcm = (long) a * b / gcd(a,b);

            System.out.println(lcm);
        }
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a%b);
    }
}
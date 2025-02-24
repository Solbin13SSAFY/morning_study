package week06.hyunji;

import java.util.Scanner;

public class tue_boj_2903_중앙이동알고리즘 {
    public static void main(String[] args) {
        //제곱의 규칙 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tmp = ((int) Math.pow(2, n))+1;
        int ans = (int) Math.pow(tmp, 2);
        System.out.println(ans);
    }
}
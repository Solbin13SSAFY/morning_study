package week06.hyunji;

import java.util.Scanner;

public class tue_boj_2720_세탁소사장동혁 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] changes = new int[]{25, 10, 5, 1};

        for(int i=0; i<n; i++) {
            int price = sc.nextInt();

            for(int j=0; j<4; j++) {
                int ans = price/changes[j];
                System.out.print(ans + " ");
                price = price%changes[j];
            }
            
            System.out.println();
        }
    }
}
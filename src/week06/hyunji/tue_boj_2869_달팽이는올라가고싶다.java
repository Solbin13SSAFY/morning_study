package week06.hyunji;

import java.util.Scanner;

public class tue_boj_2869_달팽이는올라가고싶다 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt();

        int needToDays = (V-A) / (A-B) + 1;
        int remainder = (V-A) % (A-B);
        
        if(remainder == 0) {
            System.out.println(needToDays);
        } 
        else System.out.println(needToDays+1);
    }
}
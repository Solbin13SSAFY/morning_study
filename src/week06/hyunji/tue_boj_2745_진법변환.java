package week06.hyunji;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class tue_boj_2745_진법변환 {
    public static void main(String[] args) {
        //10이 넘어가는건 k:v로 밸류*(B^자릿수(--))

        Scanner sc = new Scanner(System.in);
        String N = sc.next(); 
        int B = sc.nextInt();
        sc.nextLine();
        //입력

        Map<Character, Integer> dict = new HashMap<>();//A:10
        for(char c='0'; c<='9'; c++) {
            dict.put(c, c - '0');
        }
        for(char c='A'; c<='Z'; c++) { //아스키코드++
            dict.put(c, c - 'A' + 10);
        } //초기화

        int sum = 0;
        int tmp = N.length()-1;
        for(int i=0; i<N.length(); i++) {
            char pointer = N.charAt(i);
            sum += dict.get(pointer) * ((int) Math.pow(B, tmp));
            tmp--;
        }

        System.out.println(sum);
    }
}
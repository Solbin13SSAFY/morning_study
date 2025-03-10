package week08.hyunji;

import java.util.Scanner;

public class tue_boj_1094_막대기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        int stick = 64;
        int i = 1;

        int cnt = 1; //몇번의 연산인지 => 막대기 계속 줄여가며 더할때 카운트
        if(64%X==0) { //X가 64의 약수면 막대기 붙이는 연산 안해도 되니까 cnt는 1
            cnt = 1;
        }
        else {
            while(stick > X) {
                stick = stick >> i;
            } //stick 작아진 채로 나오기
            
            int j = 1; //비트를 오른쪽으로 얼마나 밀건지에 대한 인덱스
            int tmp = stick; //stick을 기준으로 비트연산 => 변수 tmp에 업데이트
    
            while(tmp < X) { //tmp를 X보다 작게 만들어서 X가 될때까지 더하기
                // int a = tmp + (stick >> j);
                if(tmp + (stick >> j) > X) j++;
                else { //tmp + (stick >> j) => 계속해서 막대기 붙이기
                    cnt++; //16+4+2+1 => cnt는 막대기 붙일때 쓰는 변수 
                    tmp = tmp + (stick >> j);
                    j++;
                }
            }
        }

        System.out.println(cnt);
    }
}

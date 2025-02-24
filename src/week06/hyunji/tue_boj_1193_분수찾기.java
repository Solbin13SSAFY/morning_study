import java.util.Scanner;

public class tue_boj_1193_분수찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        //몇번째 줄에 있는지 구하기
        int pSumBefore = 0;
        int pSum = 0;
        int range = 0; 
        int seq = 0;
        for(int i=1; i<=x; i++) {
            pSumBefore += (i-1);
            pSum += i;

            if(pSumBefore<x && x<=pSum) {
                range = i;
                seq = x-pSumBefore;
                break;
            }
        }

        int front = range + 1 - seq;
        int back = seq;
        
        if(range%2 != 0) System.out.println(front + "/" + back);
        else System.out.println(back + "/" + front);
    }
}
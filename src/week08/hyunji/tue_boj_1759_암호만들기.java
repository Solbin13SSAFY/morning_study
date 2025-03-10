//길이L, 사전순, (최소)모음1+자음2 - 백트래킹 - 재귀로 조합 만들고 조건 충족하는지?
package week08.hyunji;

import java.util.Arrays;
import java.util.Scanner;

public class tue_boj_1759_암호만들기 {
    static char[] moeum = {'a', 'e', 'i', 'o', 'u'}; //모음
    static int L, C;
    static char[] charr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        L = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        //C개만큼 입력받아서 char에 넣기
        String[] inputs = sc.nextLine().split(" ");
        charr = new char[C];
        for(int i=0; i<C; i++) {
            charr[i] = inputs[i].charAt(0);
        } //초기화

        //사전순
        Arrays.sort(charr);

        backtracking(0, new StringBuilder(), 0, 0);
    }

    static void backtracking(int idx, StringBuilder pw, int moeumCnt, int jaeumCnt) {
        //종료조건 
        if(pw.length() == L) { //암호 길이 == L이라면 (최소) 모음1 && 자음2 이상인지 확인 
            if(moeumCnt >= 1 && jaeumCnt >= 2) {
                System.out.println(pw);
            }
            return;
        }

        //재귀부분
        for(int i=idx; i<C; i++) { //idx: 이 다음부터 조합(중복X)
            char ch = charr[i];

            //암호 만들기
            pw.append(ch);

            if(isMoeum(ch)) backtracking(i+1, pw, moeumCnt+1, jaeumCnt);
            else backtracking(i+1, pw, moeumCnt, jaeumCnt+1);

            pw.deleteCharAt(pw.length()-1); 
        }
    }

    //모음인지 확인하는 함수
    static boolean isMoeum(char ch) {
        for(char mo : moeum) {
            if(ch == mo) return true;
        }
        return false;
    }
}
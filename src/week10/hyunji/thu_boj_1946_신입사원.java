package week10.hyunji;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Emp {
    int paper;
    int interview;
    
    Emp(int paper, int interview) {
        this.paper = paper;
        this.interview = interview;
    }
}

class EmpComparator implements Comparator<Emp> {

    @Override
    public int compare(Emp o1, Emp o2) {
        return o1.paper - o2.paper; //서류전형 오름차순
    }
    
}

public class tue_boj_1946_신입사원 {
    public static void main(String[] args) {
        //emp클래스 만들어서 서류로 오름차순 - 이중for문 만들고 뒤에서부터 돌면서 면접이 나보다 작으면 break하고 카운트 올려주기
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        
        for(int tc=1; tc<=T; tc++) {
            int N = Integer.parseInt(sc.nextLine());
            
            List<Emp> empList = new ArrayList<>();
            for(int i=0; i<N; i++) {
                String[] input = sc.nextLine().split(" ");
                int paper = Integer.parseInt(input[0]);
                int interview = Integer.parseInt(input[1]);
                
                Emp emp = new Emp(paper, interview);
                empList.add(emp);
            } //초기화
            
            //입력 다 받으면 서류를 기준으로 정렬하고 
            Collections.sort(empList, new EmpComparator());
             
            int now = empList.get(0).interview;
            
            int cnt = 1;
            for(int i=1; i<N; i++) {
                if(empList.get(i).interview < now) {
                	now = empList.get(i).interview;
                	cnt++;
                }
            }
            
            System.out.println(cnt);
        }
    }
}
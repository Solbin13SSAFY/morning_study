import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int n;
    static List<Integer>[] company; 
    static int[] compliment;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();

        company = new ArrayList[n+1];
        compliment = new int[n+1];

        for(int i=1; i<=n; i++) {
            company[i] = new ArrayList<>(); 
        } //배열 원소들 ArrayList로 초기화하기

        for(int i=1; i<=n; i++) {
            int senior = sc.nextInt();
            if(senior!=-1) company[senior].add(i); //사장제외
        } 

        for(int i=0; i<m; i++) { 
            int junior = sc.nextInt(); //직속상사로부터 칭찬받은 직원번호
            int amount = sc.nextInt(); //칭찬의 수치
            compliment[junior] += amount;
        }

        dfs(1); 

        for(int i=1; i<=n; i++) {
            System.out.print(compliment[i]+" ");
        }

        System.out.println();
    }

    static void dfs(int cur) {
        for(int el : company[cur]) {
            compliment[el] += compliment[cur]; //누적합
            dfs(el); //아래로 이동해서 또 누적시키기
        }
    }
}

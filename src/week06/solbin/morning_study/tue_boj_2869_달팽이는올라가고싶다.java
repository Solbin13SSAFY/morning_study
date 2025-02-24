package week06.solbin.morning_study;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class tue_boj_2869_달팽이는올라가고싶다 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) throws Exception {
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int a = Integer.parseInt(st.nextToken());
    	int b = Integer.parseInt(st.nextToken());
    	int v = Integer.parseInt(st.nextToken())-a;
    	// 일단 하루 더하고 시작함
    	int day = 1;
    	// 나무 직전 또는 정확히 나무까지 올라오는 시간
    	day+=v/(a-b);
    	// 하루 남았으면 그만큼 이동한다
    	if (v%(a-b)>=0) day++; 
    	System.out.println(day);
    }
}

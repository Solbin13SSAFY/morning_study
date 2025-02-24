package week06.solbin.morning_study;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class tue_boj_1193_분수찾기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) throws Exception {
    	int x = Integer.parseInt(br.readLine());
    	int sum = 1;
    	int n = 1;
    	// 몇번째줄인지 찾음
    	while (sum<x) {
    		sum+=++n;
    	}
    	
    	// 홀수일떄랑 짝수일때랑 다른 방향으로 찾음
    	if (n%2==1) {
    		int i = sum-x;
    		sb.append((i+1)+"/"+(n-i));
    	} else {
    		int i = sum-x;
    		sb.append((n-i)+"/"+(i+1));
    	}
    	System.out.println(sb);
    }
}

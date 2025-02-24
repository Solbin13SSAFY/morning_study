package week06.solbin.morning_study;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class tue_boj_11005_진법변환2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) throws Exception {
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int input = Integer.parseInt(st.nextToken());
    	int num = Integer.parseInt(st.nextToken());
    	while (input>0) {
    		// 나머지를 구한다
    		int mod = input%num;
    		input/=num;
    		
    		// 나머지만큼 sb에 추가한다
    		if (mod<10) {
    			sb.append(mod);
    		} else {
    			char c = (char) ('A'+mod-10);
    			sb.append(c);
    		}
    	}
    	sb.reverse();
    	System.out.println(sb);
    }
}


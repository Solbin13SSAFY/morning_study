package week06.solbin.morning_study;
import java.io.BufferedReader;
import java.io.InputStreamReader;


class tue_boj_2720_세탁소사장동혁 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) throws Exception {
    	int T = Integer.parseInt(br.readLine());
    	for (int t=1;t<=T;t++) {
    		int n = Integer.parseInt(br.readLine());
    		int Quarter = n/25;
    		n%=25;
    		int Dime = n/10;
    		n%=10;
    		int Nickel = n/5;
    		n%=5;
    		int Penny = n;
    		sb.append(Quarter+" "+Dime+" "+Nickel+" "+Penny+"\n");
    	}
    	System.out.println(sb);
    }
}


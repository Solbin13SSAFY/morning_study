package week06.solbin.morning_study;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class tue_boj_2903_중앙이동알고리즘 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) throws Exception {
    	int n = Integer.parseInt(br.readLine());
    	int p = pow(n)+1;
    	sb.append(p*p);
    	System.out.println(sb);
    }
    
    static int pow(int n) {
    	if (n==1) return 2;
    	return 2*pow(n-1);
    }
}


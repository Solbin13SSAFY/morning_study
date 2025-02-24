package week06.solbin;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class tue_boj_2745_진법변환 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) throws Exception {
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	char[] input = st.nextToken().toCharArray();
    	int num = Integer.parseInt(st.nextToken());
    	long sum = 0;
    	for (int i=0;i<input.length;i++) {
    		// 몇번째 자리인지
    		int p = input.length-i-1;
    		char c = input[i];
    		int n;
    		// 숫자는 그대로 변환
    		if (Character.isDigit(c)) {
    			n = Character.getNumericValue(c);
    		} else {
    			n = c-'A'+10;
    		}
    		// 자리수만큼 곱해서 더함
    		sum+=n*pow(num,p);
    	}
    	sb.append(sum);
    	System.out.println(sb);
    }
    
    static long pow(int x, int n) {
    	if (n==0) return 1;
    	return (long)x*pow(x,n-1);
    }
}


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static int L;
    static int R;
    static int X;
    static int cnt = 0;
    static int[] arr;
    
    public static void main(String args[]) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        // idx, first, sum
        back(0, -1, 0);
        
        System.out.println(cnt);
    }
    
    static void back(int idx, int first, int sum) {
    	// arr[first]!=sum -> 이 부분은 원소가 두개 이상인지 세는 조건문
    	// arr[idx-1]-arr[first]>=X -> 이 부분은 차이가 X 이상인지 확인하는 조건문 
    	if (sum>=L&&sum<=R&&first!=-1&&arr[first]!=sum&&arr[idx-1]-arr[first]>=X) {
    		cnt++;
    	}
    	if (idx==N) {
    		return;
    	}
    	
    	for (int i=idx;i<N;i++) {
    		back(i+1,first==-1?i:first,sum+arr[i]);
    	}
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static char[] buffer;
	static char[] arr;
	
	static int d;
	static int n;
	
	static Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u'));
	
	public static void main(String args[]) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		d = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		arr = new char[n];
		buffer = new char[d];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		back(0,0);
		
		System.out.println(sb);
	}
	
	static void back(int idx,int depth) {
		if (depth==d) {
			// check
			int aeiou = 0;
			int other = 0;
			for (int i=0;i<d;i++) {
				if (set.contains(buffer[i])) {
					aeiou++;
				} else {
					other++;
				}
			}
			if (aeiou<1||other<2) {
				return;
			}
			for (int i=0;i<d;i++) {
				sb.append(buffer[i]);
			}
			sb.append("\n");
			return;
		}
		for (int i=idx;i<n-d+depth+1;i++) {
			buffer[depth] = arr[i];
			back(i+1,depth+1);
		}
	}
}

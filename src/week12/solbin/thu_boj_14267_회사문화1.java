import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static List<List<Integer>> edge;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		
		edge = new ArrayList<>();
		for (int i=0;i<=n;i++) {
			edge.add(new ArrayList<>());
		}
		st = new StringTokenizer(br.readLine());
		// 간선 생성
		st.nextToken();
		for (int i=2;i<=n;i++) {
			edge.get(Integer.parseInt(st.nextToken())).add(i);
		}
		
		for (int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			// 직원번호
			int k = Integer.parseInt(st.nextToken());
			// 칭찬수
			int p = Integer.parseInt(st.nextToken());
			arr[k] += p;
		}
		
		dfs(1);
		
		for (int i=1;i<=n;i++,sb.append(" ")) {
			sb.append(arr[i]);
		}
		System.out.println(sb);
	}
	
	static void dfs(int x) {
		for (int c : edge.get(x)) {
			arr[c] += arr[x];
			dfs(c);
		}
	}
}

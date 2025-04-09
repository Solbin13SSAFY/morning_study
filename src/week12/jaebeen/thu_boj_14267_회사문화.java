package boj_14267_회사문화;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, start, good;
	static int[] count;
	static List<Integer>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		count = new int[n+1];
		
		graph = new ArrayList[n+1];
		for(int i=0; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		for(int i=2; i<=n; i++) {
			int p = Integer.parseInt(st.nextToken());
			
			graph[p].add(i);
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			good = Integer.parseInt(st.nextToken());
			
			count[start] += good;
		}
		
		dfs(1);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++, sb.append(' ')) {
			sb.append(count[i]);
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int start) {
		for(int a : graph[start]) {
			count[a] += count[start];
			dfs(a);
		}
	}
}

package week04.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class tue_boj_24444_너비우선탐색1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int[] order = new int[n+1];
		boolean[] visited = new boolean[n+1];
		List<Integer>[] link = new ArrayList[n+1];
		for (int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if (link[s]==null) link[s] = new ArrayList<>();
			if (link[e]==null) link[e] = new ArrayList<>();
			link[s].add(e);
			link[e].add(s);
		}
		queue.add(r);
		visited[r] = true;
		int cnt = 1;
		while (!queue.isEmpty()) {
			int node = queue.poll();
			order[node] = cnt++;
			Collections.sort(link[node]);
			for (int i:link[node]) {
				if (!visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
		
		for (int i=1;i<=n;i++) {
			sb.append(order[i]).append("\n");
		}
		
		System.out.println(sb);
	}
}

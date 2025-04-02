package boj_2887_행성터널;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] p, rank;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		p = new int[N];
		for(int i=0; i<N; i++) {
			p[i] = i;
		}
		rank = new int[N];
		int[][] loc = new int[N][3];
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int ii=0; ii<3; ii++) {
				loc[i][ii] = Integer.parseInt(st.nextToken());
			}
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
		
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				int x = Math.abs(loc[i][0] - loc[j][0]); 
				int y = Math.abs(loc[i][1] - loc[j][1]); 
				int z = Math.abs(loc[i][2] - loc[j][2]);
				if(x*y*z == 0) {
					union(i, j);
				} else {
					pq.add(new int[] {i, j, Math.min(z, Math.min(x, y))});
				}
			}
		}
		
		int count = 0;
		int ans = 0;
		
		while(count<N-1) {
			int[] info = pq.poll();
			int s = info[0];
			int e = info[1];
			int cost = info[2];
			int ps = find(s);
			int pe = find(e);
			if(ps != pe) {
				union(ps, pe);
				ans += cost;
				count++;
			}
		}
		System.out.println(ans);
	}
	
	static int find(int x) {
		if(x != p[x]) {
			p[x] = find(p[x]);
		}
		return p[x];
	}
	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px != py) {
			if(rank[px] > rank[py]) {
				p[py] = px;
			} else if(rank[px] < rank[py]) {
				p[px] = py;
			} else {
				p[py] = px;
				rank[px]++;
			}
		}
	}
}


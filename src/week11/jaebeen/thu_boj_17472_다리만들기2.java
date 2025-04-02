package boj_17472_다리만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, number;
	static int[][] map;
	static boolean[][] visited;
	static List<int[]> xy;
	static PriorityQueue<int[]> pq;
	static int[] p,rank;
	
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		number = 0;
		map = new int[N][M];
		visited = new boolean[N][M];
		xy = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int ii=0; ii<M; ii++) {
				map[i][ii] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int ii=0; ii<M; ii++) {
				if(!visited[i][ii] && map[i][ii] != 0) {
					visited[i][ii] = true;
					++number;
					map[i][ii] = number;
					xy.add(new int[] {number, ii, i});
					setNumber(ii, i);
				}
			}
		}// map에서 섬 별로 이름 부여 완료
		
		// 간선 정보를 담아 둘 pq
		pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		p = new int[number+1];
		for(int i=0; i<p.length; i++) {
			p[i] = i;
		}
		rank = new int[number+1];
		
		for(int i=0; i<xy.size(); i++) {
			int[] info = xy.get(i);
			int num = info[0];
			int x = info[1];
			int y = info[2];
			visited = new boolean[N][M];
			visited[y][x] = true;
			findDist(num,x,y);
		} // 간선 정보 큐에 담아 줌
		
		
		int ans = 0;
		while(!pq.isEmpty()) {
			int[] info = pq.poll();
			int s = info[0];
			int e = info[1];
			int cost = info[2];
			int ps = find(s);
			int pe = find(e);
			if(ps != pe) {
				union(ps, pe);
				ans += cost;
			}
		}
		int tmp = find(1);
		for(int i=2; i<=number; i++) {
			if(tmp != find(i)) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(ans);
	}
	static void findDist(int num, int x, int y) {
		for(int i=0; i<4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			int count = 0;
			if(bound(xx, yy) && isSame(x,y,xx,yy) && !visited[yy][xx]) {
				visited[yy][xx] = true;
				findDist(num, xx, yy);
			}
			while(bound(xx, yy) && !isSame(x,y,xx,yy)) {
				// 섬의 일부가 아니고, 바다가아니면 -> 다른 섬
				if(map[yy][xx] != 0) {
					if(count >= 2) {
						pq.add(new int[] {num, map[yy][xx], count});
					}
					break;
				}
				xx += dx[i];
				yy += dy[i];
				count++;
			}
		}
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
	
	static void setNumber(int x, int y) {
		for(int i=0; i<4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if(bound(xx,yy) && !visited[yy][xx] && map[yy][xx] != 0) {
				visited[yy][xx] = true;
				map[yy][xx] = number;
				setNumber(xx, yy);
			}
		}
	}
	
	static boolean bound(int x, int y) {
		return x>=0&&y>=0&&x<M&&y<N;
	}
	static boolean isSame(int x, int y, int xx, int yy) {
		return map[y][x] == map[yy][xx];
	}
}

package boj_1486_등산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Info implements Comparable<Info> {
		int x, y, time, top;

		public Info(int x, int y, int time, int top) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
			this.top = top;
		}

		@Override
		public int compareTo(Info o) {
			return this.time - o.time;
		}
	}

	static int n, m, t, d;
	static int[][] map;
	static int[][] dist;
	static int ans;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		dist = new int[n][m];
		for (int i = 0; i < n; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				int num = arr[j] - 'A';
				if (num > 25) {
					num -= 6;
				}
				map[i][j] = num;
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.offer(new Info(0, 0, 0, map[0][0]));

		while (!pq.isEmpty()) {
			Info info = pq.poll();
			int x = info.x;
			int y = info.y;
			int time = info.time;
			int top = info.top;
			for (int i = 0; i < 4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				if (bound(xx, yy)) {
					// 높이 차이
					int dh = Math.abs(map[y][x] - map[yy][xx]);
					if (dh <= t) {
                        int newTime = 0;
                        if (map[y][x] >= map[yy][xx]) {
                            newTime = time + 1;
                        } else {
                            newTime = time + (int) Math.pow(dh, 2);
                        }
                        if (newTime <= d && dist[yy][xx] > newTime) {
                            dist[yy][xx] = newTime;
                            int newTop = Math.max(top, map[yy][xx]);
                            System.out.println(newTime + " : " + xx + " / " + yy + " -> " + newTop);
                            ans = Math.max(ans, newTop);
                            pq.offer(new Info(xx, yy, newTime, newTop));
                        }
                    }
				}
			}

		}
		System.out.println(ans);
	}

	static boolean bound(int x, int y) {
		return x >= 0 && y >= 0 && x < m && y < n;
	}
}

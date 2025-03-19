package boj_15683_감시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[][] map;
	static List<int[]> cctv;
	static int cctvCnt;
	static boolean[][] origin;
	static int blindMin;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		origin = new boolean[N][M];
		cctv = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if(num != 0 && num != 6) {
					cctv.add(new int[] {num, j, i});
					cctvCnt++;
				}
				if(num == 6) {
					origin[i][j] = true;
				}
			}
		}
		blindMin = Integer.MAX_VALUE;
		comb(0,new ArrayList<Integer>());
		System.out.println(blindMin);
	}
	
	static void comb(int cctvIdx, ArrayList<Integer> directions) {
		if(directions.size() == cctvCnt) {
			// cctv들의 방향을 다 정했다면 각 방향을 방문처리
			// 사각지대의 최소값과 비교해서 최소값 초기화
			boolean[][] visited = new boolean[N][M];
			for(int i=0; i<N; i++) {
				visited[i] = Arrays.copyOf(origin[i], M);
			}
			
//			System.out.println(directions);
			for(int i=0; i<cctvCnt; i++) {
				chk(visited, cctv.get(i), directions.get(i));
			}
			blindMin = Math.min(blindMin, blindCnt(visited));
			return;
		}
			int type = cctv.get(cctvIdx)[0];
			switch(type) {
			case 1 : {
				for(int i=0; i<4; i++) {
					directions.add(i);
					comb(cctvIdx+1, directions);
					directions.remove(directions.size()-1);
				}
				break;
			}
			case 2 : {
				for(int i=0; i<2; i++) {
					directions.add(i);
					comb(cctvIdx+1, directions);
					directions.remove(directions.size()-1);
				}		
				break;
			}
			case 3 : {
				for(int i=0; i<4; i++) {
					directions.add(i);
					comb(cctvIdx+1, directions);
					directions.remove(directions.size()-1);
				}
				break;
			}
			case 4 : {
				for(int i=0; i<4; i++) {
					directions.add(i);
					comb(cctvIdx+1, directions);
					directions.remove(directions.size()-1);
				}
				break;
			}
			case 5 : 
				directions.add(5);
				comb(cctvIdx+1, directions);
				directions.remove(directions.size()-1);
				break;
		}
	}
	static void chk(boolean[][] map, int[] info, int dir) {
		int type = info[0];
		int x = info[1];
		int y = info[2];
		switch(type) {
			case 1 : {
				while(bound(x, y)) {
					map[y][x] = true;
					y+=dy[dir];
					x+=dx[dir];
				}
				break;
			}
			case 2 : {
				for(int i=0; i<2; i++) {
					int xx = x;
					int yy = y;
					while(bound(xx, yy)) {
						map[yy][xx] = true;
						yy+=dy[dir+(i*2)];
						xx+=dx[dir+(i*2)];
					}
				}
				break;
			}
			case 3 : {
				for(int i=0; i<2; i++) {
					int xx = x;
					int yy = y;
					while(bound(xx, yy)) {
						map[yy][xx] = true;
						yy+=dy[(dir+i)%4];
						xx+=dx[(dir+i)%4];
					}
				}
				break;
			}
			case 4 : {
				for(int i=0; i<4; i++) {
					if(dir != i) {
						int xx = x;
						int yy = y;
						while(bound(xx, yy)) {
							map[yy][xx] = true;
							yy+=dy[i];
							xx+=dx[i];
						}
					}
				}
				break;
			}
			case 5 : {
				for(int i=0; i<4; i++) {
					int xx = x;
					int yy = y;
					while(bound(xx, yy)) {
						map[yy][xx] = true;
						yy+=dy[i];
						xx+=dx[i];
					}
				}
				break;
			}
		}
	}
	static int blindCnt(boolean[][] map) {
//		System.out.println("~~~~~~~~~~~~");
		int cnt = 0;
		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(map[i]));
			for(int j=0; j<M; j++) {
				if(!map[i][j]) {
					cnt++;
				}
			}
		}
//		System.out.println(cnt);
//		System.out.println("~~~~~~~~~~~~");
		return cnt;
	}
	static boolean bound(int x, int y) {
		return x>=0&&x<M&&y>=0&&y<N&&map[y][x]!=6;
	}
}

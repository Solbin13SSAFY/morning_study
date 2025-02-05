package swea;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Swea_4193_수영대회 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int n = sc.nextInt();
			
			
			boolean[][] visited = new boolean[n][n];
			int[][] mapInfo = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					mapInfo[i][j] = sc.nextInt();
				}
			}
			
			int startX = sc.nextInt();
			int startY = sc.nextInt();
			int endX = sc.nextInt();
			int endY = sc.nextInt();
			
			int[] dx = {0, 0, 1, -1};
			int[] dy = {1, -1, 0, 0};
			
			// startX,Y에서 endX,Y로 갈 수 있는 최단시간...은 모르겠고 거리는 구해지는데
			int time = 0;
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] {startX,startY,0});
			visited[startX][startY] = true;
			while(!q.isEmpty()) {
				// 큐에 있는 요소를 꺼내서 동서남북 중 이동할 수 있는 곳의 좌표 정보를 큐에 넣어줌
				int[] arr = q.poll();
				System.out.println(Arrays.toString(arr));
				int nowX = arr[0];
				int nowY = arr[1];
				int nowT = arr[2];
				// 꺼낸놈의 위치에 따라 어떻게 해줄지 -> 끝, 소용돌이, 일반칸
				if(nowX == endX && nowY == endY) {
					time = nowT;
					break;
				} else if(mapInfo[nowX][nowY] == 2 && nowT % 3 != 2){
					q.offer(new int[] {nowX, nowY, ++nowT});
				} else {
					visited[nowX][nowY] = true;
					for(int i=0; i<4; i++) {
						int x = nowX + dx[i];
						int y = nowY + dy[i];
						int t = nowT;
						if(x >=0 && x<n && y>=0 && y<n && mapInfo[x][y] != 1 && !visited[x][y]) {
							q.offer(new int[] {x,y,++t});
						}
					}
				}
				
			}
			
			System.out.println("Time : "+time);
		}
	}
}

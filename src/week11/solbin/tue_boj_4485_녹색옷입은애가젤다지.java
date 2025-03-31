import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[][] arr,cost;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int n;
	static boolean[][] visited;
	static Queue<int[]> queue;
	public static void main(String args[]) throws Exception {
		StringTokenizer st;
		tc:
		// 테케 증가, 무한루프, 개행삽입
		for (int t=1;true;t++,sb.append("\n")) {
			n=Integer.parseInt(br.readLine());
			if (n==0) break;
			arr = new int[n][n];
			visited = new boolean[n][n];
			for (int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<n;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 다익스트라 돌리기
			queue = new PriorityQueue<>((a,b)->a[2]-b[2]);
			queue.add(new int[] {0,0,arr[0][0]});
			while (!queue.isEmpty()) {
				int[] item = queue.poll();
				int x = item[0];
				int y = item[1];
				int c = item[2];
				// 다익스트라는 bfs랑 다르게 visited 체크를 노드 삽입 시점이 아닌 큐에서 꺼낸 시점에 해야함
				if (visited[x][y]) continue;
				// 목표지점에 도달했으면 컨티뉴
				if (x==n-1&&y==n-1) {
					sb.append("Problem "+t+": "+c);
					continue tc;
				}
				visited[x][y] = true;
				for (int i=0;i<4;i++) {
					int xx = x+dx[i];
					int yy = y+dy[i];
					if (bound(xx,yy)) {
						queue.add(new int[] {xx,yy,c+arr[xx][yy]});
					}
				}
			}
		}
		System.out.println(sb);
	}
	
	static boolean bound(int x,int y) {
		return x>=0&&x<n&&y>=0&&y<n&&!visited[x][y];
	}
}

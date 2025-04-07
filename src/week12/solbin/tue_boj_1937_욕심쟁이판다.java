import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int n;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int max = 0;
		StringTokenizer st;
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

        	// pq는 높이 순으로, 같은 높이면 경로 긴 순으로 정렬
		Queue<int[]> queue = new PriorityQueue<>((a,b)->{
			if (a[3]==b[3]) {
				return b[2]-a[2];
			} else {
				return a[3]-b[3];
			}
		});
		boolean[][] visited = new boolean[n][n];

        	// 가장 낮은 지점을 pq에 다 넣음
		for (int i=0;i<n;i++) {
			loop:
			for (int j=0;j<n;j++) {
				for (int d=0;d<4;d++) {
					int x = i+dx[d];
					int y = j+dy[d];
					if (bound(x,y)&&arr[x][y]<arr[i][j]) continue loop;
				}
				queue.add(new int[] {i,j,1,arr[i][j]});
			}
		}

        	// pq 순회
		while (!queue.isEmpty()) {
			int[] item = queue.poll();
			int x = item[0];
			int y = item[1];
			int c = item[2];
			if (visited[x][y]) continue;
			visited[x][y] = true;
			max = Math.max(c, max);
			for (int d=0;d<4;d++) {
				int xx = x+dx[d];
				int yy = y+dy[d];
				if (bound(xx,yy)&&!visited[xx][yy]&&arr[xx][yy]>arr[x][y]) {
					queue.add(new int[] {xx,yy,c+1,arr[xx][yy]});
				}
			}
		}
		
		System.out.println(max);
	}
	
	static boolean bound(int x,int y) {
		return x>=0&&x<n&&y>=0&&y<n;
	}
}

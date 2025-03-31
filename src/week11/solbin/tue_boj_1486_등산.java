import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n,m,t,d;
	static int[][] arr,up,down;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	public static void main(String args[]) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		up = new int[n][m];
		down = new int[n][m];
		for (int i=0;i<n;i++) {
			Arrays.fill(up[i], Integer.MAX_VALUE/2);
			Arrays.fill(down[i], Integer.MAX_VALUE/2);
			char[] input = br.readLine().toCharArray();
			for (int j=0;j<m;j++) {
				char c = input[j];
				arr[i][j] = c>='A'&&c<='Z'?c-'A':c-'a'+26;
			}
		}
		
		// 하산하는 시간 측정
		Queue<int[]> queue = new PriorityQueue<>((a,b)->a[2]-b[2]);
		visited = new boolean[n][m];
		queue.add(new int[] {0,0,0});
		while (!queue.isEmpty()) {
			int[] item = queue.poll();
			int x = item[0];
			int y = item[1];
			if (visited[x][y]) continue;
			visited[x][y] = true;
			int h = arr[x][y];
			int time = item[2];
			down[x][y] = time;
			for (int i=0;i<4;i++) {
				int xx = x+dx[i];
				int yy = y+dy[i];
				if (bound(xx,yy,h)) {
					// 시간 측정함
					queue.add(new int[] {xx,yy,time+dist(arr[xx][yy],h)});
				}
			}
		}
		
		// 위에꺼 그대로 카피해서 등산하는 시간 측정
		queue = new PriorityQueue<>((a,b)->a[2]-b[2]);
		visited = new boolean[n][m];
		queue.add(new int[] {0,0,0});
		while (!queue.isEmpty()) {
			int[] item = queue.poll();
			int x = item[0];
			int y = item[1];
			if (visited[x][y]) continue;
			visited[x][y] = true;
			int h = arr[x][y];
			int time = item[2];
			up[x][y] = time;
			for (int i=0;i<4;i++) {
				int xx = x+dx[i];
				int yy = y+dy[i];
				if (bound(xx,yy,h)) {
					// 다른점은 여기 dist 인자의 순서가 다름!!
					// -> 시간이 달라지므로 다익스트라에서 하산과 다른 경로가 나옴
					queue.add(new int[] {xx,yy,time+dist(h,arr[xx][yy])});
				}
			}
		}
		
		// 가장 높이 올라간 높이 구하기
		int max = arr[0][0];
		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				max = down[i][j]+up[i][j]<=d?Math.max(max, arr[i][j]):max;
			}
		}
		
		System.out.println(max);
	}
	
	// 경계조건에 한번에 오를 수 있는 높이 추가함
	static boolean bound(int x,int y,int h) {
		return x>=0&&x<n&&y>=0&&y<m&&!visited[x][y]&&arr[x][y]<=h+t&&arr[x][y]>=h-t;
	}
	
	// 올라갈때랑 내려갈 때의 시간이 다름
	static int dist(int from,int to) {
		return from>=to?1:(int)(Math.pow(from-to, 2));
	}
}

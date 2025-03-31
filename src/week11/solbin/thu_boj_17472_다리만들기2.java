import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int n,m,v;
	
	static int[] dx = new int[] {-1,1,0,0};
	static int[] dy = new int[] {0,0,-1,1};
	
	static int[][] arr,e;
	static boolean[][] visited;
	static int[] parent;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = 0;
		arr = new int[n][m];
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<m;j++) {
				arr[i][j] = -Integer.parseInt(st.nextToken());
			}
		}// 입력부분 종료
		
		
		// 배열 순회하면서 DFS로 섬에 번호를 할당함
		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				if (arr[i][j]==-1) {
					boolean[][] visited = new boolean[n][m];
					v++;
					dfs(i,j,visited);
				}
			}
		}
		
		// v는 섬의 개수
		visited = new boolean[v+1][v+1];
		// 섬 사이의 인접배열
		e = new int[v+1][v+1];
		// 서로소집합을 위한 부모배열
		parent = new int[v+1];
		
		for (int i=0;i<=v;i++) {
			Arrays.fill(e[i],Integer.MAX_VALUE);
			parent[i] = i;
		}
		
		// 세로 스캔
		for (int i=0;i<n;i++) {
			int s = -1;
			int len = 0;
			for (int j=0;j<m-1;j++) {
				boolean chk1 = arr[i][j]==0;
				boolean chk2 = arr[i][j+1]==0;
				if (!chk1&&chk2) {
					s = arr[i][j];
					len++;
				} else if (chk1&&!chk2&&s!=-1) {
					if (len>1) {
						// 연결 정보 저장
						int d = arr[i][j+1];
						e[s][d] = Math.min(len, e[s][d]);
						e[d][s] = Math.min(len, e[d][s]);
					}
					len = 0;
					s = -1;
				} else if (chk1&&chk2&&s!=-1) {
					len++;
				}
			}
		}
		// 가로 스캔
		for (int i=0;i<m;i++) {
			int s = -1;
			int len = 0;
			for (int j=0;j<n-1;j++) {
				boolean chk1 = arr[j][i]==0;
				boolean chk2 = arr[j+1][i]==0;
				if (!chk1&&chk2) {
					s = arr[j][i];
					len++;
				} else if (chk1&&!chk2&&s!=-1) {
					if (len>1) {
						// 연결 정보 저장
						int d = arr[j+1][i];
						e[s][d] = Math.min(len, e[s][d]);
						e[d][s] = Math.min(len, e[d][s]);
					}
					len = 0;
					s = -1;
				} else if (chk1&&chk2&&s!=-1) {
					len++;
				}
			}
		}
		
		// 크루스칼로 최소스패닝트리를 구함
		int sum = 0; 
		int cnt = 0;
		Queue<int[]> queue = new PriorityQueue<>((a,b)->a[2]-b[2]);
		for (int i=1;i<=v-1;i++) {
			for (int j=i+1;j<=v;j++) {
				if (e[i][j]!=Integer.MAX_VALUE) {
					queue.add(new int[] {i,j,e[i][j]});
				}
			}
		}
		while (!queue.isEmpty()&&cnt!=v-1) {
			int[] item = queue.poll();
			int s = item[0];
			int e = item[1];
			int c = item[2];
			// 정상적으로 유니온 됐으면 스패닝트리에 추가된거임
			if (union(s,e)) {
				cnt++;
				sum+=c;
			}
		}
		
		System.out.println(cnt!=v-1?-1:sum);
	}
	
	static void dfs(int x,int y,boolean[][] visited) {
		visited[x][y] = true;
		arr[x][y] = v;
		for (int i=0;i<4;i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if (bound(xx,yy)&&!visited[xx][yy]&&arr[xx][yy]!=0) {
				dfs(xx,yy,visited);
			}
		}
	}
	
	static boolean bound(int x, int y) {
		return x>=0&&x<n&&y>=0&&y<m;
	}
	
	static int find(int x) {
		return parent[x]==x?x:(parent[x]=find(parent[x]));
	}
	
	static boolean union(int x,int y) {
		int px,py;
		return (px=find(x))==(py=find(y))?false:px==(parent[py]=px);
	}
}

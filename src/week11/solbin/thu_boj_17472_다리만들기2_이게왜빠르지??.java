import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int n;
	static int m;
	
	static int node = 0;
	
	static int[] dx = new int[] {-1,1,0,0};
	static int[] dy = new int[] {0,0,-1,1};
	
	static int[][] arr;
	static boolean[][] visited;
	static int[] parent;
	static int[][] e;
	static int v;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<m;j++) {
				arr[i][j] = -Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				if (arr[i][j]==-1) {
					boolean[][] visited = new boolean[n][m];
					node++;
					dfs(i,j,visited);
				}
			}
		}
		
		v = node;
		
		visited = new boolean[v+1][v+1];
		e = new int[v+1][v+1];
		parent = new int[v+1];
		
		for (int i=0;i<=v;i++) {
			Arrays.fill(e[i],Integer.MAX_VALUE);
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
		
		int sum = 0; 
		int cnt = 0;
		for (int i=0;i<v*v-v;i++) {
			int len = next();
			if (len==Integer.MIN_VALUE) {
				break;
			} else if (len==Integer.MAX_VALUE) {
				continue;
			} else {
				sum+= len;
				cnt++;
			}
			if (cnt==v-1) break;
		}
		if (cnt!=v-1) {
			sb.append(-1);
		} else {			
			sb.append(sum);
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int x,int y,boolean[][] visited) {
		visited[x][y] = true;
		arr[x][y] = node;
		for (int i=0;i<4;i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if (bound(xx,yy)&&!visited[xx][yy]&&arr[xx][yy]!=0) {
				dfs(xx,yy,visited);
			}
		}
	}
	
	static boolean bound(int x, int y) {
		if (x<0||x>=n||y<0||y>=m) {
			return false;
		} else {
			return true;
		}
	}
	
	static int next() {
		int min = Integer.MAX_VALUE;
		int s = -1;
		int d = -1;
		for (int i=1;i<=v;i++) {
			for (int j=i+1;j<=v;j++) {
				if (!visited[i][j]&&e[i][j]<min) {
					min = e[i][j];
					s = i;
					d = j;
				}
			}
		}
		if (min==Integer.MAX_VALUE) {
			return Integer.MIN_VALUE; 
		}
		visited[s][d] = true;
		int ps = parent[s];
		int pd = parent[d];
		if (ps!=0&&pd!=0) {
			if (ps==pd) return Integer.MAX_VALUE;
			for (int k=1;k<=v;k++) {
				if (parent[k]==pd) {
					parent[k] = ps;
				}
			}
		} else if (ps!=0) {
			parent[d] = ps;
		} else if (pd!=0) {
			parent[s] = pd;
		} else {
			parent[s] = s;
			parent[d] = s;
		}
		return min;
	}
}

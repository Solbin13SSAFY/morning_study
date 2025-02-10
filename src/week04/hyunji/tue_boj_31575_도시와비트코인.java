import java.util.Scanner;

public class tue_boj_31575_도시와비트코인 {
	
	static int M;
	static int N;
	static int[][] graph;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		graph = new int[M][N];
		visited = new boolean[M][N];
		
		for (int y=0; y<M; y++) {
			for (int x=0; x<N; x++) {
				graph[y][x] = sc.nextInt();
			}
		}
	
		boolean res = dfs(0, 0);
		
		if (res) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}
	
	public static boolean dfs(int y, int x) {
		//현재 위치가 거래소인 경우 => return Yes;
		if (y == M-1 && x == N-1) {
			return true;
		}
		
		visited[y][x] = true;
		
		if (!(y+1<0 || y+1>=M || x<0 || x>=N || graph[y+1][x] == 0 || visited[y+1][x])) {
			if (dfs(y+1, x)) {
				return true;
			}
		}
		
		if (!(y<0 || y>=M || x+1<0 || x+1>=N || graph[y][x+1] == 0 || visited[y][x+1])) {
			if (dfs(y, x+1)) {
				return true;
			}
		}
		
		
		return false;
		
	}
}

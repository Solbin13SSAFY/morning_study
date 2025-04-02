package week11.hyunji;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//델타 탐색해서 당장 갈 수 있는 다음 원소랑 지금까지의 원소를 더했을때 더 작은 원소로 가기 - 반복
class Main {
	static int[] dy = {-1, 1, 0, 0}; //상하좌우
	static int[] dx = {0, 0, -1, 1}; //상하좌우
	
	static int N; //정점의 개수
	static int[][] map;
	static int[][] dist;
	static boolean[][] visited;
	static int INF = Integer.MAX_VALUE;
	
	static class Node {
		int y, x, cost;
		
		Node(int y, int x, int cost) {
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
	}
	
	static class NodeComparator implements Comparator<Node> {
		@Override
		public int compare(Node o1, Node o2) {
			return o1.cost - o2.cost;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int problemNum = 1;
		while(true) {
			N = Integer.parseInt(sc.nextLine());
			if(N==0) break; 
			
			map = new int[N][N];
			for(int y=0; y<N; y++) {
				String[] input = sc.nextLine().split(" ");
				for(int x=0; x<N; x++) {
					map[y][x] = Integer.parseInt(input[x]);
				}
			} //2차원배열 초기화
			
			int res = dijkstra(map[0][0], 0, 0); //최상단 좌측 원소부터 시작
			
			System.out.println("Problem " + problemNum + ": " + res);
			problemNum++;
		}
	}
	
	static int dijkstra(int start, int y, int x) { 
		PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
		visited = new boolean[N][N];
		dist = new int[N][N];
		
		//dist 초기화부터 - 무한대
		for(int i=0; i<N; i++) {
			Arrays.fill(dist[i], INF);
		}
		dist[0][0] = start; //시작점만 start의 값으로 초기화
		
		pq.add(new Node(0, 0, start)); //pq에 시작점부터 넣기 
				
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.y][cur.x]) continue; 
			if(cur.y == N-1 && cur.x == N-1) break;
			
			//델타 탐색
			for(int i=0; i<4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if(isValid(ny, nx)) {
					
					int newCost = dist[cur.y][cur.x] + map[ny][nx];
					
					if(newCost < dist[ny][nx]) {
						dist[ny][nx] = newCost;
						pq.add(new Node(ny, nx, newCost));
					}
				}	
			}
		}
		
		return dist[N-1][N-1];
		
	}
	
	static boolean isValid(int y, int x) {
		if(y>=0 && y<N && x>=0 && x<N) return true;
		return false;
	}
}
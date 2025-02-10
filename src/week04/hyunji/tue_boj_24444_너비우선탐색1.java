import java.util.*;

public class tue_boj_24444_너비우선탐색1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();
		
		//각 노드 들어가는 그래프 
		List<Integer>[] graph = new ArrayList[N+1];
		for (int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>(); //노드i와 인접한 노드들의 리스트 저장 
		}
		
		for (int i=0; i<M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph[u].add(v);
			graph[v].add(u); //양방향 
		}
		
		bfs(N, M, R, graph);
		
		sc.close();
	}
	
	public static void bfs(int N, int M, int R, List<Integer>[] graph) {
		//방문 여부 
		boolean[] visited = new boolean[N+1];
		
		//방문 순서 
		int[] order = new int[N+1];
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(R); //시작노드 넣기 
		visited[R] = true; //시작노드 방문처리
		
		int cnt = 1; //방문 순서 번호 
		while (!q.isEmpty()) {
			int node = q.poll(); //node는 실제로 탐색할 노드 
			order[node] = cnt++; //방문순서 기록 
			
			//인접리스트 오름차순 탐색
			List<Integer> neighbors = graph[node]; //탐색할 노드(node)와 인접한 원소들(인접리스트로 묶인 애들)
			Collections.sort(neighbors); //오름차순 
			
			//들어온거 나가면 - 인접한 애들 오름차순으로 정리해서 q에 넣어주기
			for (int neighbor : neighbors) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					q.offer(neighbor);
				}
			}
		}
		
		for (int i=1; i<=N; i++) {
			System.out.println(order[i]);
		}
		
	}
}

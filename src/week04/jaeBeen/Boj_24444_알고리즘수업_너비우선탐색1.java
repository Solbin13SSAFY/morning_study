

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_24444_알고리즘수업_너비우선탐색1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    // 시간초과 3번 
    // 출력방식 변경 --> 입력방식 변경 --> visited boolean >> int 
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int M = sc.nextInt();
//		int R = sc.nextInt();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		// 노드간 연결정보를 담아줌
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		// boolean으로 방문여부만 확인했는데 int로 0아니면 방문, 방문순번까지..
		int[] visited = new int[N+1]; 
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			graph.get(node1).add(node2);
			graph.get(node2).add(node1);
		}
		
		
		// 오름차순으로 방문 -> 정렬시켜줌
		for(int i=0; i<graph.size(); i++) {
			Collections.sort(graph.get(i));
		}
		br.close();
		
		
		// BFS
		Queue<Integer> q = new LinkedList<>();
		int count = 1;
		// 시작지점 순번 초기화
		visited[R] = count;
		// 큐에 넣어줌
		q.offer(R);
		// 큐가 빌때까지 반복
		// 연결된 노드들이 전부 방문처리(순번을 가짐)되면 큐에 새로운 요소가 안들어가서 끝남
		while(!q.isEmpty()) {
			// 큐에서 꺼내서
			int node = q.poll();
			// 꺼낸 노드가 연결된 다른 노드 수만큼 돌면서
			for(int i=0; i<graph.get(node).size(); i++) {
				int tmp = graph.get(node).get(i);
				// 꺼낸 노드 방문한적 있는지
				if(visited[tmp] == 0) {
					// 첫방문 순번기록 == 방문처리
					visited[tmp] = ++count;
					// 큐에 넣어줌
					q.offer(tmp);
				}
			}
		}
		
		for(int i=1; i<visited.length; i++) {
			System.out.println(visited[i]);
		}
	}
}
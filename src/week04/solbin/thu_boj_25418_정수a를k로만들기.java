package week04.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class thu_boj_25418_����a��k�θ���� {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// �̹� ������� ���� �ٽ� ������ �ʴ´�
		boolean[] visited = new boolean[k+1];
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {a,0});
		visited[a] = true;
		int res = 0;
		while (!queue.isEmpty()) {
			int[] item = queue.poll();
			int x = item[0];
			int t = item[1];
			if (x==k) {
				res = t;
				break;
			}
			// 1�� ���Ѵ�
			if (x+1<=k&&!visited[x+1]) {
				queue.add(new int[] {x+1,t+1});
				visited[x+1] = true;
			}
			
			// 2�� ���Ѵ�
			if (x*2<=k&&!visited[x*2]) {
				queue.add(new int[] {x*2,t+1});
				visited[x*2] = true;
			}
		}
		
		sb.append(res);
		
		System.out.println(sb);
	}
}

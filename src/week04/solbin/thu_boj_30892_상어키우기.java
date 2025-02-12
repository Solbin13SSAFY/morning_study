package week04.solbin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
public class thu_boj_30892_상어키우기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> queue = new PriorityQueue<>();
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long t = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		// 일단 PQ에 집어넣어서 정렬을 함
		for (int i=0;i<n;i++) {
			queue.add(Integer.parseInt(st.nextToken()));
		}
		
		while (k>0) {
			// 더이상 먹을 수 없을 때 까지 작은거부터 꺼내서 일단 스택에다가 치워놓음
			while (!queue.isEmpty()&&queue.peek()<t) {
				stack.add(queue.poll());
			}
			
			// 치워놓은 스택에서 하나를 꺼내면 그게 상어가 먹을 수 있는 가장 큰 상어임.
			if (stack.isEmpty()) break;
			// 하나만 먹고 다음 반복으로 넘어감
			t+=stack.pop();
			k--;
		}
		System.out.println(t);
	}
}

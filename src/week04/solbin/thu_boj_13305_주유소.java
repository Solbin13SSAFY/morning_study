package week04.solbin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
public class thu_boj_13305_������ {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> queue = new PriorityQueue<>();
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int[] dist = new int[n];
		int[] cost = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0;i<n-1;i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		int min = cost[0];
		long sum = 0;
		// �Ÿ��� ���� �̵��ϸ� ���ݱ����� �ּڰ��� ���Ѵ�
		for (int i=0;i<n;i++) {
			min = Math.min(cost[i], min);
			sum+=(long)min*dist[i];
		}
		System.out.println(sum);
	}
}
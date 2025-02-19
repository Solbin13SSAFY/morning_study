package week04.solbin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
public class thu_boj_30892_���Ű��� {
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
		// �ϴ� PQ�� ����־ ������ ��
		for (int i=0;i<n;i++) {
			queue.add(Integer.parseInt(st.nextToken()));
		}
		
		while (k>0) {
			// ���̻� ���� �� ���� �� ���� �����ź��� ������ �ϴ� ���ÿ��ٰ� ġ������
			while (!queue.isEmpty()&&queue.peek()<t) {
				stack.add(queue.poll());
			}
			
			// ġ������ ���ÿ��� �ϳ��� ������ �װ� �� ���� �� �ִ� ���� ū �����.
			if (stack.isEmpty()) break;
			// �ϳ��� �԰� ���� �ݺ����� �Ѿ
			t+=stack.pop();
			k--;
		}
		System.out.println(t);
	}
}

package week04.solbin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class thu_boj_12933_���� {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
		@Override
		public int compare(int[] a, int[] b) {
			if (a[0]==b[0]) {
				return a[1]-b[1];
			}
			return a[0]-b[0];
		}
	});
	public static void main(String[] args) throws NumberFormatException, IOException {
		char[] quack = br.readLine().toCharArray();
		int sum=0;
		
		// char �迭���� quack�� ������ ��� X�� ġȯ��
		while (true) {
			char check = 'q';
			int start = -1;
			int end = -1;
			innerLoop:
			for (int i=0;i<quack.length;i++) {
				char sound = quack[i];
				if (sound==check) {
					quack[i] = 'X';
					switch (check) {
					case 'q':
						start = i;
						check='u';
						break;
					case 'u':
						check='a';
						break;
					case 'a':
						check='c';
						break;
					case 'c':
						check='k';
						break;
					case 'k':
						end = i;
						break innerLoop;
					}
				}
			}
			// quack�� �ϳ� ġȯ�� ������ �ټ��� �����ٰ� ī��Ʈ �Ѵ�
			if (start!=-1&&end!=-1) {
				// pq�� quack�� �����ϴ� ������ �����ϴ� ������ �߰��Ѵ�.
				queue.add(new int[] {start,1});
				queue.add(new int[] {end, -1});
				sum+=5;
			} else {
				break;
			}
		}
		
		int max=-1;
		int cnt=0;
		
		// quack�� �ִ� � ��ġ���� üũ��
		// ������ quack�� ���̰� �� ���̿� ��ġ���� ������ ��ȿ���� ���� quack��
		if (sum==quack.length) {
			while (!queue.isEmpty()) {
				int[] item = queue.poll();
				if (item[1]==1) {
					cnt++;
				} else {
					cnt--;
				}
				max = Math.max(max, cnt);
			}
		}
		
		sb.append(max);
		System.out.println(sb);
	}
}

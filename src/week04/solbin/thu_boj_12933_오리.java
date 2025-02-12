package week04.solbin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class thu_boj_12933_오리 {
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
		
		// char 배열에서 quack이 있으면 모두 X로 치환함
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
			// quack를 하나 치환할 때마다 다섯개 지웠다고 카운트 한다
			if (start!=-1&&end!=-1) {
				// pq에 quack이 시작하는 지점과 종료하는 지점을 추가한다.
				queue.add(new int[] {start,1});
				queue.add(new int[] {end, -1});
				sum+=5;
			} else {
				break;
			}
		}
		
		int max=-1;
		int cnt=0;
		
		// quack가 최대 몇개 겹치는지 체크함
		// 제거한 quack의 길이가 총 길이와 일치하지 않으면 유효하지 않은 quack임
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

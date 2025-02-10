import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Boj_25418_정수A를K로2 {
	static int min = 0;
	static int a;
	static int k;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		k = sc.nextInt();
		
		int[] info = {a,0};
		
		bfs(info);
		
		System.out.println(min);
	}
	// visited 처리를 어떻게 해주지
	public static void bfs(int[] info) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(info);
		// 한번 만들어 진적있는 수에서 +1. *2 할 필요 없음 / 중복 허용X
		Set<Integer> visited = new HashSet<>();
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			// 현재 수
			int now = arr[0];
			// 연산횟수
			int count = arr[1];
			// 목표값이면 현재 연산 횟수 담아주고 끝
			if(now == k) {
				min = count;
				break;
			// 아직 목표값 보다 작고, 현재 수가 이전에 만들어 진적이 없으면
			} else if(now < k && !visited.contains(now)) {
				// 현재 수를 담아주고
				visited.add(now);
				// 연산 결과 조건 검사 후 큐에 담아 줌
				if(now+1 <= k) {
					q.offer(new int[] {now+1, count+1});
				}
				if(now*2 <= k) {
					q.offer(new int[] {now*2, count+1});
				}
			}
		}
	}
}

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Boj_25418_정수A를K로 {
	static int min = 0;
	static int a;
	static int k;
	static Set<Integer> visited = new HashSet<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		k = sc.nextInt();
		
		int[] info = {a,0};
		
		dfs(info);
		
		System.out.println(min);
	}
	// dfs로 풀면 stackoverflow
	public static void dfs(int[] info) {
		int now = info[0];
		System.out.println(now);
		int count = info[1];
		if(now == k) {
			if(min == 0 || min > count) {
				min = count;
			}
		} else if(now < k && !visited.contains(now)) {
			dfs(new int[] {now+1, count+1});
			dfs(new int[] {now*2, count+1});
		}
	}
}

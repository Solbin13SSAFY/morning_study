import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int q = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<q;i++,sb.append(" ")) {
			int m = Integer.parseInt(st.nextToken());
			Set<Integer> set = new HashSet<>();
			// 일단 초기 무게를 셋에 집어넣음
			set.add(m);
			for (int j=0;j<n;j++) {
				List<Integer> list = new ArrayList<>(set);
				int size = list.size();
				for (int k=0;k<size;k++) {
                    			// 셋에 플마 무게를 집어넣음
					set.add(list.get(k)+arr[j]);
					set.add(list.get(k)-arr[j]);
				}
			}
			// 0이 존재하면 가능, 존재하지않으면 불가능
			// DP로 풀려고 했는데 못풀겠음...
			sb.append(set.contains(0)?"Y":"N");
		}
		System.out.println(sb);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final StringBuilder sb = new StringBuilder();
	
	static int[][] emp;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t=1;t<=T;t++,sb.append("\n")) {
			int n = Integer.parseInt(br.readLine());
			emp = new int[n][2];
			for (int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				emp[i][0] = Integer.parseInt(st.nextToken());
				emp[i][1] = Integer.parseInt(st.nextToken());
			}
			int cnt = 0;
      // 일단정렬
			Arrays.sort(emp,(a,b)->(a[0]-b[0]));
			int h = Integer.MAX_VALUE;
      // 서류심사 높은 순서대로 순회
			for (int i=0;i<n;i++) {
        // 지금까지 나왔던 면접 성적의 최솟값보다는 커야 함
				if (emp[i][1]<h) {
					h = emp[i][1];
					cnt++;
				}
			}
			sb.append(cnt);
		}
		System.out.println(sb);
	}
}

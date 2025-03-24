import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final StringBuilder sb = new StringBuilder();
	
	static PriorityQueue<Long> pq;
	
	final static int p = 1000000007;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t=1;t<=T;t++,sb.append("\n")) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			pq = new PriorityQueue<>();
      // 일단 pq에 넣음
			for (int i=0;i<n;i++) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			long res = 1;
			while (pq.size()>1) {
        // pq에서 첫번째, 두번째 원소를 꺼내서 곱함
				long fst = pq.poll();
				long snd = pq.poll();
				long mp = fst*snd;
				// 모듈러연산 분배법칙은 꼭 지키기
				res = (res*(mp%p))%p;
        // 다시 pq에 넣음
				pq.add(mp);
			}
			sb.append(res);
		}
		System.out.println(sb);
	}
}

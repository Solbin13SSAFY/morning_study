package boj_14698_전생슬연_Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static final long MOD = 1000000007;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			N = Integer.parseInt(br.readLine());
			// 슬라임을 담아주는 pq, 에너지가 낮은 슬라임부터 오름차순으로 정렬된다.
			PriorityQueue<Long> pq = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			// 모든 에너지 곱
			long cost = 1;
			// 현재 슬라임 합성에 필요한 에너지
			long multi = 0;
	        while(pq.size() > 1) {
	        	// 슬라임 에너지가 낮은 놈 2마리를 꺼내서 곱해준다. -> 현재 슬라임 합성에 필요한 에너지
	            multi = pq.poll() * pq.poll();
	            // 합성에 필요한 에너지, 모든 에너지 곱을 MOD로 나눈 나머지로 연산
	            cost = (cost * (multi % MOD)) % MOD;
	            // 생성된 슬라임을 큐에 넣어준다.
	            pq.add(multi);
	        }
			
			System.out.println(cost);
		}
		
	}
}

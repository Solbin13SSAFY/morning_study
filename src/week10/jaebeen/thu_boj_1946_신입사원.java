package boj_1946_신입사원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static class Ranks implements Comparable<Ranks>{
		int rank1;
		int rank2;
		public Ranks(int rank1, int rank2) {
			this.rank1 = rank1;
			this.rank2 = rank2;
		}

		@Override
		public int compareTo(Ranks o) {
			return this.rank1-o.rank1;
		}

		@Override
		public String toString() {
			return "Ranks [rank1=" + rank1 + ", rank2=" + rank2 + "]";
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			N = Integer.parseInt(br.readLine());
			Ranks[] arr = new Ranks[N];
			
			for(int ii=0; ii<N; ii++) {
				st = new StringTokenizer(br.readLine());
				arr[ii] = new Ranks(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			//첫번째 등수로 정렬
			Arrays.sort(arr);
			int nowHighest = arr[0].rank2;
			int count = 1;
			// 첫번째 등수로 정렬 시킨 뒤 두번째 등수를 비교
			for(int ii=1; ii<N; ii++) {
				Ranks now = arr[ii];
				// 최고 등수보다 낮다면 첫, 두번째 등수 모두 낮은 경우 == 최종불합
				if(now.rank2 < nowHighest) {
					count++;
					// 두번째 등수 중 최고 등수를 유지하면서 순회
					nowHighest = now.rank2;
				}
			}
			
			System.out.println(count);
		}
	}
}

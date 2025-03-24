package boj_20310_타노스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nums = br.readLine();
		
		Queue<Integer> q = new LinkedList<>();
		
		int cnt0 = 0;
		int cnt1 = 0;
		int numsLen = nums.length();
		// 큐에 담아두고 결과 문자열을 만들건데 문자 하나씩 돌면서 0,1의 갯수를 세어줄거다
		for(int i=0; i<numsLen; i++) {
			int num = Character.getNumericValue(nums.charAt(i));
			if(num == 0) {
				cnt0++;
			} else {
				cnt1++;
			}
			q.add(num);
		}
		// 문자열에 0이 몇개 들어갔는지, 입력받은 문자열에 1이 몇개 남았는지 확인하기 위한 변수
		int now0 = 0;
		int now1 = cnt1;
		StringBuilder sb = new StringBuilder();
		// 목표 문자열의 길이가 입력받은 문자열의 길이 절반만큼 되면 끝
		while(sb.length() != (numsLen / 2)) {
			int num = q.poll();
			// 꺼낸 숫자가 0이고 입력받은 0의 갯수 절반 만큼 채워지지 않았으면
			// 0갯수 추가해주고 결과문자에 추가
			if(num == 0 && now0 < (cnt0/2)) {
				now0++;
				sb.append(num);
			}
			// 꺼낸 숫자가 1일때
			if(num == 1) {
				// 남은 1의 갯수가 입력받은 1의 수 절반보다 작다면 결과 문자열에 추가
				if(now1 <= (cnt1/2)) {
					sb.append(num);
				}
				now1--;
			}
		}
		// 출력
		System.out.println(sb);
	}
}

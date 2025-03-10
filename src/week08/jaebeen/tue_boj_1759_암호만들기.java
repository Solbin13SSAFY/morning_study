package boj_1759_암호만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int L;
	static int C;
	static String[] arr;
	
	static String[] sel;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = br.readLine().split(" ");
		sel = new String[L];
		
		Arrays.sort(arr);
		
		comb(0,new ArrayList<String>());
//		comb2(0,0);
		
	}
	
	static void comb(int idx, ArrayList<String> curr) {
		// 지금 만들어 둔 암호길이가 목표한 길이만큼 되면 검사
		if(curr.size() == L) {
			int count = 0;
			// 모음의 수를 구하자
			for(int i=0; i<L; i++) {
				String tmp = curr.get(i);
				if(tmp.equals("a") || tmp.equals("e") || tmp.equals("i") || tmp.equals("o") || tmp.equals("u")) {
					count++;
				}
			}
			// 자음, 모음의 최소 갯수를 충족하면 출력하자
			if(count != 0 && L - count >= 2) {
				for(int i=0; i<curr.size(); i++) {
					System.out.print(curr.get(i));
				}
				System.out.println();
			}
			return;
		}
		// 중복해서 뽑을 수 없으니 반복문을 시작할 인덱스를 받아와서 돌려주자
		for(int i=idx; i<C; i++) {
			// 하나 넣고
			curr.add(arr[i]);
			// 다음 암호문 글자 찾으러 보내고
			comb(i+1, curr);
			// 갔다오면 최근에 추가한 글자 하나 빼
			curr.remove(curr.size()-1);
		}
	}
	
	static void comb2(int idx, int sidx) {
		
		if(sidx == L) {
			int count = 0;
			for(int i=0; i<L; i++) {
				String str = sel[i];
				if(str.equals("a") || str.equals("e") || str.equals("i") || str.equals("o") || str.equals("u")) {
					count++;
				}
			}
			if(count != 0 && L - count >= 2) {
				for(int i=0; i<L; i++) {
					System.out.print(sel[i]);
				}
				System.out.println();
			}
			return;
		}
		
		for(int i=idx; i<=C-L+sidx; i++) {
			sel[sidx] = arr[i];
			comb2(i+1, sidx+1);
		}
		
	}
	
	
}

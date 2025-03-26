package week10.hyunji;

import java.util.Scanner;

class thu_boj_14715_전생했더니슬라임연구자였던건에대하여 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = Integer.parseInt(sc.nextLine());

		//소인수분해 개수 구하기
		int cnt=0;
		for(int i=2; i<=K; i++) {
			while(K%i==0) {
				K/=i;
				cnt++;
			}
		}

		int ans = log2(cnt);
		System.out.println(ans);
	}

	//밑이2인 로그함수 없는거 같아서 만들어서 씀
	static int log2(int N) {
		if(N==0) return 0; 

		double res = (Math.log(N) / Math.log(2));
		return (int)Math.ceil(res);
	}
}
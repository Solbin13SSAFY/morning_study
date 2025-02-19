package week04.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class thu_boj_27961_고양이는많을수록좋다 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		long ret;
		long n = Long.parseLong(br.readLine());
		
		// method 1 : 이진수의 가장 높은 비트 뒤쪽에 있는 0의 갯수를 카운트
		if (n>1) {
			ret = Long.numberOfTrailingZeros(Long.highestOneBit(n-1))+2;
		} else {
			ret = n;
		}
		
		// method 2 : 밑이 2인 log 이용
		if (n>1) {
			ret = (long)(Math.log(n-1)/Math.log(2))+2;
		} else {
			ret = n;
		}
		
		// method 3 : Binary String 으로 변환
		if (n>1) {
			ret = Long.toBinaryString(n-1).length()+1;
		} else {
			ret = n;
		}

		// method 4 : 비트이동
		ret= 1;
		long tmp = n-1;
		if (n>1) {
			while (tmp>0) {
				tmp>>=1;
				ret++;
			}
		} else {
			ret = n;
		}
		
		// method 5 : 나눗셈
		ret= 1;
		tmp = n-1;
		if (n>1) {
			while (tmp>0) {
				tmp/=2;
				ret++;
			}
		} else {
			ret = n;
		}
		
		System.out.println(ret);
	}
}

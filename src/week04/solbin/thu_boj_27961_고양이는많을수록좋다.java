package week04.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class thu_boj_27961_����̴¸����������� {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		long ret;
		long n = Long.parseLong(br.readLine());
		
		// method 1 : �������� ���� ���� ��Ʈ ���ʿ� �ִ� 0�� ������ ī��Ʈ
		if (n>1) {
			ret = Long.numberOfTrailingZeros(Long.highestOneBit(n-1))+2;
		} else {
			ret = n;
		}
		
		// method 2 : ���� 2�� log �̿�
		if (n>1) {
			ret = (long)(Math.log(n-1)/Math.log(2))+2;
		} else {
			ret = n;
		}
		
		// method 3 : Binary String ���� ��ȯ
		if (n>1) {
			ret = Long.toBinaryString(n-1).length()+1;
		} else {
			ret = n;
		}
		
		System.out.println(ret);
	}
}

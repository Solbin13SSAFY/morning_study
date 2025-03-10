package week07.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class thu_boj_9663_NQueen {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int sum = 0;
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		back(0,new int[n]);
		System.out.println(sum);
	}
	
	static void back(int i, int[] subarr) {
		if (i==n) {
			sum++;
			return;
		}
		loop:
		for (int j=0;j<n;j++) {
			for (int k=1;k<=i;k++) {
				if ((j+k<n&&(subarr[i-k]&1<<j+k)!=0)||(j-k>=0&&(subarr[i-k]&1<<j-k)!=0)||(subarr[i-k]&1<<j)!=0) {
					continue loop;
				}
			}
			subarr[i] = 1<<j;
			back(i+1,subarr);
			subarr[i] = 0;
		}
	}
}
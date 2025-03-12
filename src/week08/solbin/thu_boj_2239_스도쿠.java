import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] vChk = new int[9];
	static int[] hChk = new int[9];
	static int[] bChk = new int[9];
	static int[][] arr = new int[9][9];
	static boolean isFound = false;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		for (int i=0;i<9;i++) {
			char[] input = br.readLine().toCharArray();
			for (int j=0;j<9;j++) {
				int num = Character.getNumericValue(input[j]);
				if (num!=0) {					
					vChk[j]+=1<<num;
					hChk[i]+=1<<num;
					bChk[b(i,j)]+=1<<num;
				}
				arr[i][j] = num;
			}
		}
		back(0);
		System.out.println(sb);
	}
	
	static void back(int i) {
		int j = -1;
		for (int k=0;k<9;k++) {
			if (arr[i][k]==0) {
				j=k;
				break;
			}
		}
		if (j==-1) {
			if (i==8) {
				for (int x=0;x<9;x++) {
					for (int y=0;y<9;y++) {
						sb.append(arr[x][y]);
					}
					sb.append("\n");
				}
				isFound = true;
			} else {				
				back(i+1);
			}
			return;
		} else {
			for (int k=1;k<=9;k++) {
				int num = (1<<k);
				boolean chk1 = (hChk[i]&num)==0;
				boolean chk2 = (vChk[j]&num)==0;
				boolean chk3 = (bChk[b(i,j)]&num)==0;
				if (chk1&&chk2&&chk3) {
					hChk[i]+=num;
					vChk[j]+=num;
					bChk[b(i,j)]+=num;
					arr[i][j] = k;
					back(i);
					if (isFound) return;
					hChk[i]-=num;
					vChk[j]-=num;
					bChk[b(i,j)]-=num;
					arr[i][j] = 0;
				}
			}
		}
	}
	
	static int b(int x, int y) {
		return x/3+(y/3)*3;
	}
}


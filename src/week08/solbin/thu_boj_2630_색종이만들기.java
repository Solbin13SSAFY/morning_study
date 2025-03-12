import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int wCnt = 0;
	static int bCnt = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		boolean[][] arr= new boolean[n][n];
		StringTokenizer st;
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<n;j++) {
				arr[i][j] = st.nextToken().equals("1")?true:false;
			}
		}
		cut(arr);
		
		sb.append(wCnt+"\n");
		sb.append(bCnt+"\n");
		
		System.out.println(sb);
	}
	
	static void cut(boolean[][] arr) {
		int size = arr.length;
		boolean[] fRef = new boolean[size];
		boolean[] tRef = new boolean[size];
		boolean isBlue = true;
		boolean isWhite = true;
		Arrays.fill(tRef, true);
		for (int i=0;i<size;i++) {
			if (Arrays.mismatch(arr[i], fRef)!=-1) {
				isWhite = false;
				break;
			}
		}
		for (int i=0;i<size;i++) {
			if (Arrays.mismatch(arr[i], tRef)!=-1) {
				isBlue = false;
				break;
			}
		}
		if (isBlue) {
			bCnt++;
		} else if (isWhite) {
			wCnt++;
		} else {
			boolean[][] arr1 = new boolean[size/2][size/2];
			boolean[][] arr2 = new boolean[size/2][size/2];
			boolean[][] arr3 = new boolean[size/2][size/2];
			boolean[][] arr4 = new boolean[size/2][size/2];
			for (int i=0;i<size/2;i++) {
				for (int j=0;j<size/2;j++) {
					arr1[i][j] = arr[i][j];
					arr2[i][j] = arr[i+size/2][j];
					arr3[i][j] = arr[i][j+size/2];
					arr4[i][j] = arr[i+size/2][j+size/2];
				}
			}
			cut(arr1);
			cut(arr2);
			cut(arr3);
			cut(arr4);
		}
	}
	
	static int getSize(int n) {
		return Integer.numberOfTrailingZeros(n);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static List<List<Integer>> set = new ArrayList<>();
	static List<List<Integer>> house = new ArrayList<>();
	
	static int n;
	static int m;
	static int[][] arr;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<n;j++) {
				int input = Integer.parseInt(st.nextToken());
				arr[i][j] = input;
				if (input==2) {
					set.add(Arrays.asList(i,j));
				} else if (input==1) {
					house.add(Arrays.asList(i,j));
				}
			}
		}
		
		comb(0,m,new ArrayList<>());
		
		sb.append(min);
		
		System.out.println(sb);
	}
	
	static void comb(int start, int count, List<List<Integer>> subset) {
		if (count>0) {
			for (int i=start;i<set.size()-count+1;i++) {
				subset.add(set.get(i));
				comb(i+1,count-1,subset);
				subset.remove(subset.size()-1);
			}
		} else {
			int sum=0;
//			for (int i=0;i<n;i++) {
//				for (int j=0;j<n;j++) {
//					if (arr[i][j]==1) {
//						sum+=getChickenDist(i,j,subset);
//					}
//				}
//			}
			for (List<Integer> item:house) {
				sum+=getChickenDist(item.get(0),item.get(1),subset);
			}
			min = Math.min(min, sum);
		}
	}
	
	static int getChickenDist(int x, int y, List<List<Integer>> store) {
		int min = Integer.MAX_VALUE;
		for (List<Integer> item : store) {
			min = Math.min(min,Math.abs(item.get(0)-x)+Math.abs(item.get(1)-y));
		}
		return min;
	}
}


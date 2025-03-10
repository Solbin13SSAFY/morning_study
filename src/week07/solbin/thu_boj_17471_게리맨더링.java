package week07.solbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class thu_boj_17471_게리맨더링 {
		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static StringBuilder sb = new StringBuilder();
		static boolean tVisited[];
		static boolean fVisited[];
		static boolean color[];
		static int n;
		static int[] arr;
		static List<List<Integer>> link = new ArrayList<>();
		public static void main(String[] args) throws NumberFormatException, IOException {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringTokenizer st2;
			int min = -1;
			arr = new int[n+1];
			link.add(new ArrayList<>());
			for (int i=0;i<n;i++) {
				arr[i+1] = Integer.parseInt(st.nextToken());
				st2 = new StringTokenizer(br.readLine());
				Integer[] tmp = new Integer[Integer.parseInt(st2.nextToken())];
				for (int j=0;j<tmp.length;j++) {
					tmp[j] = Integer.parseInt(st2.nextToken());
				}
				link.add(Arrays.asList(tmp));
			}
			int Case = 1<<n;
			for (int i=1;i<Case-1;i++) {
				tVisited= new boolean[n+1];
				fVisited= new boolean[n+1];
				color = new boolean[n+1];
				int tCnt = 0;
				int fCnt = 0;
				for (int j=0;j<n;j++) {
					if ((i&(1<<j))!=0) {
						color[j+1] = true;
					}
				}
				for (int j=1;j<=n;j++) {
					if (color[j]&&!tVisited[j]) {
						tDfs(j);
						tCnt++;
					}
				}
				for (int j=1;j<=n;j++) {
					if (!color[j]&&!fVisited[j]) {
						fDfs(j);
						fCnt++;
					}
				}
				if (tCnt==1&&fCnt==1) {
					int tSum = 0;
					int fSum = 0;
					for (int j=1;j<=n;j++) {
						if (color[j]) {
							tSum+=arr[j];
						} else {
							fSum+=arr[j];
						}
					}
					if (min==-1) {
						min = Math.abs(tSum-fSum);
					} else {
						min = Math.min(min, Math.abs(tSum-fSum));
					}
				}
			}
			sb.append(min);
			System.out.println(sb);
		}
		static void tDfs(int x) {
			tVisited[x] = true;
			List<Integer> list = link.get(x);
			for (int i:list) {
				if (!tVisited[i]&&color[i]) {
					tDfs(i);
				}
			}
		}
		
		static void fDfs(int x) {
			fVisited[x] = true;
			List<Integer> list = link.get(x);
			for (int i:list) {
				if (!fVisited[i]&&!color[i]) {
					fDfs(i);
				}
			}
		}
	}
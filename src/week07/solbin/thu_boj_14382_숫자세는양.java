package week07.solbin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class thu_boj_14382_숫자세는양 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) throws Exception {
    	int T = Integer.parseInt(br.readLine());
    	for (int t=1;t<=T;t++) {
    		int n = Integer.parseInt(br.readLine());
    		Set<Integer> set = new HashSet<>();
    		int tmp = n;
    		for (int i=1;i<=100;i++) {
    			tmp=n*i;
    			while (tmp>0) {
    				set.add(tmp%10);
    				tmp/=10;
    			}
    			if (set.size()==10) {
    				tmp=n*i;
    				break;
    			}
    		}
    		sb.append("Case #"+t+": ");
    		if (set.size()==10) {
    			sb.append(tmp).append("\n");
    		} else {
    			sb.append("INSOMNIA\n");
    		}
    	}
    	System.out.println(sb);
    }
}

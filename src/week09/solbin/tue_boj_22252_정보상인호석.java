import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) throws Exception {
        StringTokenizer st;
        // 각 고릴라의 정보를 담을 해시맵
        Map<String,Queue<Integer>> gorilla = new HashMap<>();
        // 쿼리의 개수
        int q = Integer.parseInt(br.readLine());
        long sum = 0;
        for (int i=0;i<q;i++) {
        	st = new StringTokenizer(br.readLine());
        	// 1 : 고릴라가 정보 수집, 2 : 호석이가 정보 구매 
        	int query = Integer.parseInt(st.nextToken()); 
        	String name = st.nextToken();
        	int n = Integer.parseInt(st.nextToken());
        	// 해당 이름을 가진 고릴라의 정보 목록 내림차순
        	Queue<Integer> info = gorilla.computeIfAbsent(name, k -> new PriorityQueue<Integer>(Comparator.reverseOrder()));
        	if (query==1) {
        		for (int j=0;j<n;j++) {
        			info.add(Integer.parseInt(st.nextToken()));
        		}
        	} else {
        		for (int j=0;j<n&&!info.isEmpty();j++) {
        			sum += info.poll();
        		}
        	}
        }
        System.out.println(sum);
    }
}

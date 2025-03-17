package boj_22252_정보상인호석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static Map<String, PriorityQueue<Integer>> map;
	static PriorityQueue<Integer> queue;
	static long price;
	
	static int cmd;
	static String name;
	static int num;
	static int size;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int Q = Integer.parseInt(st.nextToken());
		
		map = new HashMap<>();
		
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			cmd = Integer.parseInt(st.nextToken());
			name = st.nextToken();
			num = Integer.parseInt(st.nextToken());
			// 명령어가 1일 때 고릴라에 정보 추가
			if(cmd == 1) {
				// 해당 이름의 고릴라가 없다면 고릴라를 추가해주고
				if(!map.containsKey(name)) {
					// 내림차순으로 정렬하는 PQ를 만들어 준다 -> 가치가 큰거부터 구매
					map.put(name, new PriorityQueue<>(Collections.reverseOrder()));
				} 
				// 해당 이름의 고릴라가 가진 정보에 입력된 정보를 추가해준다.
				for(int j=0; j<num; j++) {
					map.get(name).add(Integer.parseInt(st.nextToken()));
				}
			} else {
				// 명령어가 2일 때 정보 구매
				// 해당 고릴라가 있을 때만 구매 가능
				if(map.containsKey(name)) {
					queue = map.get(name); 
					size = queue.size();
					// 고릴라가 가진 정보가 구매하는 정보의 수보다 크면 구매하는 수 만큼 꺼내서 비용에 추가 
					if(size >= num) {
						for(int j=0; j<num; j++) {
							price += queue.poll();
						}
					} else {
						// 가진 정보가 적다면 큐를 비우고 다 더해준다.
						while(!queue.isEmpty()) {
							price += queue.poll();
						}
					}
				}
			}
//			if (cmd == 1) {
//                map.putIfAbsent(name, new PriorityQueue<>(Collections.reverseOrder()));
//                PriorityQueue<Integer> queue = map.get(name);
//                for (int j = 0; j < num; j++) {
//                    queue.add(Integer.parseInt(st.nextToken()));
//                }
//            } else {
//                PriorityQueue<Integer> queue = map.getOrDefault(name, new PriorityQueue<>());
//                for (int j = 0; j < Math.min(queue.size(), num); j++) {
//                    price += queue.poll();
//                }
//            }
		}
		System.out.println(price);
	}
}

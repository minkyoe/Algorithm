import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main_2204_도비의난독증테스트 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			int N = Integer.parseInt(bf.readLine());
			
			if (N == 0) break;
			
			PriorityQueue<String> pq = new PriorityQueue<>();
			HashMap<String, String> map = new HashMap<>();
			
			for (int i = 0; i < N; i++) {
				String origin = bf.readLine();
				String lowered = origin.toLowerCase();
				map.put(lowered, origin);
				pq.offer(lowered);
			}
			
			System.out.println(map.get(pq.poll()));
		}

	} // end of main

} // end of class

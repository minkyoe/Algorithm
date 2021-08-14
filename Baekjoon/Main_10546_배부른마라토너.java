import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main_10546_배부른마라토너 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(bf.readLine());
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String name = bf.readLine();
			if (map.containsKey(name)) {
				map.put(name, map.get(name) + 1);
			} else {
				map.put(name, 1);
			}
		}
		
		for (int i = 0; i < N-1; i++) {
			String name = bf.readLine();
			map.put(name, map.get(name) - 1);
		}
		
		for (Entry<String, Integer> e : map.entrySet()) {
			if (e.getValue() >= 1) {
				sb.append(e.getKey()).append("\n");
			}
		}
		
		System.out.println(sb);
	} // end of main

} // end of class

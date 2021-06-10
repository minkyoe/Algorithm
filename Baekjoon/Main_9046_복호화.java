import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Main_9046_복호화 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		for (int i = 1; i <= N; i++) {
			String s = bf.readLine();
			HashMap<Character, Integer> map = new HashMap<>();
			
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if (c == ' ') continue;
				if (map.get(c) == null) map.put(c, 1);
				else map.put(c, map.get(c) + 1);
			}
			
			Set<Entry<Character, Integer>> entrySet = map.entrySet();
			char maxChar = 0;
			int maxCnt = 0;
			boolean hasSameCase = false;
			
			for (Entry<Character, Integer> entry : entrySet) {
				if (maxCnt < entry.getValue()) {
					maxCnt = entry.getValue();
					maxChar = entry.getKey();
					if (hasSameCase) hasSameCase = false;
				}
				else if (maxCnt == entry.getValue()) {
					hasSameCase = true;
				}
			}
			
			if (hasSameCase) System.out.println("?");
			else System.out.println(maxChar);
		} // end of testCase
	} // end of main

} // end of class

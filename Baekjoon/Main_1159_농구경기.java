import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main_1159_농구경기 {

	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			char c = s.charAt(0);
			
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		
		String ans = "";
		for (Entry<Character, Integer> e : map.entrySet()) {
			if (e.getValue() >= 5) ans += e.getKey(); 
		}
		
		if (ans.length() == 0) System.out.println("PREDAJA");
		else System.out.println(ans);
	}

}

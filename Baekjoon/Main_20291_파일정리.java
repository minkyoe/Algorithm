import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main_20291_파일정리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		HashMap<String, Integer> map = new HashMap<>();
		ArrayList<String> strings = new ArrayList<>();
		
		for (int i = 0; i < N; i ++) {
			String s = bf.readLine();
			int idx = s.indexOf(".");
			String str = s.substring(idx+1);
			
			if (map.get(str) != null) {
				map.put(str, map.get(str) + 1);
			} else {
				strings.add(str);
				map.put(str, 1);
			}
		}
		
		Collections.sort(strings);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strings.size(); i++) {
			sb.append(strings.get(i)).append(" ").append(map.get(strings.get(i))).append("\n");
		}
		System.out.println(sb);
		
	} // end of main

} // end of class

package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main_1157_단어공부 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		
		HashMap<String, Integer> hm = new HashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			String c = String.valueOf(s.charAt(i)).toUpperCase();
			
			if (hm.containsKey(c)) hm.put(c, hm.get(c) + 1);
			else hm.put(c, 1);
		}
		
		int max = 0;
		String ans = "";
		
		for (Entry<String, Integer> entry : hm.entrySet()) {
			String c = entry.getKey();
			int cnt = entry.getValue();
			if (cnt > max) {
				max = cnt;
				ans = c;
			} else if (cnt == max) {
				ans = "?";
			}
		}
		
		System.out.println(ans);
	}

}

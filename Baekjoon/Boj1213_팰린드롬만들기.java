package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main_1213_팰린드롬만들기 {

	private static HashMap<Character, Integer> map;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		
		if (s.length() == 1) System.out.println(s);
		else {
			map = new HashMap<Character, Integer>();
			
			for (int i = 0; i < s.length(); i++) {
				char now = s.charAt(i);
				if (map.containsKey(now)) map.put(now, map.get(now)+1);
				else map.put(now, 1);
				
			}
			
			Object[] sortedKey = map.keySet().toArray();
			Arrays.sort(sortedKey);
			
			int oddCnt = 0;
			for(Object o : sortedKey) {
				if (map.get(o) % 2 == 1) ++oddCnt;
			}
			
			String ans = "";
			if (oddCnt > 1) System.out.println("I'm Sorry Hansoo");
			else {
				for(Object o : sortedKey) {
					int cnt = map.get(o);
					
					if (cnt == 1) {
						continue;
					}
					for (int i = 0; i < cnt/2; i++) {
						ans += o;
					}
				}
				
				for(Object o : sortedKey) {
					int cnt = map.get(o);
					
					if (cnt % 2 != 0) {
						ans += o;
					} 
				}
				
				for (int i = ans.length()-1-oddCnt; i >= 0; i--) {
					ans += ans.charAt(i);
				}
				
				System.out.println(ans);
			}
		}
		

	} // end of main

} // end of class

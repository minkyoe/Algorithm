package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_2941_크로아티아알파벳 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		
		HashSet<String> hs = new HashSet<>();
		hs.add("c=");
		hs.add("c-");
		hs.add("dz=");
		hs.add("d-");
		hs.add("lj");
		hs.add("nj");
		hs.add("s=");
		hs.add("z=");
		
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i == s.length() - 1) {
				++ans;
				break;
			}
			String now = String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i+1));
			if (now.equals("dz") && i+2 < s.length()) {
				if (String.valueOf(s.charAt(i+2)).equals("=")) {
					++ans;
					i += 2;
					continue;
				}
			}
			if(hs.contains(now)) ++i;
			++ans;
		}
		System.out.println(ans);

	} // end of main

} // end of class

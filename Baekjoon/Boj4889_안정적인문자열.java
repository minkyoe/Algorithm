package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_4889_안정적인문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		int tc = 0;
		while(true) {
			String s = bf.readLine();
			if (s.charAt(0) == '-') break;
			tc++;
			ans = 0;
			Stack<Character> st = new Stack<>();
			
			for (int i = 0; i < s.length(); i++) {
				char now = s.charAt(i);
				if (now == '{') st.push(now);
				else {
					if (st.isEmpty()) st.push(now);
					else {
						if (st.peek() == '}') st.push(now);
						else {
							st.pop();
						}
					}
				}
			} // end of for
			
			while(!st.isEmpty()) {
				String tmp = "";
				for (int i = 0; i < 2; i++) {
					tmp = st.pop() + tmp;
				}
				
				for (int i = 0; i < 2; i++) {
					if (i == 0 && tmp.charAt(i) == '}') ans++;
					else if (i == 1 && tmp.charAt(i) == '{') ans++;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append(tc).append(". ").append(ans);
			System.out.println(sb);
		}

	}

}

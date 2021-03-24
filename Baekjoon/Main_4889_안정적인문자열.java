import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_4889_안정적인문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		
		while (true) {
			String s = bf.readLine();
			if (s.charAt(0) == '-') break;
			
			Stack<Character> st = new Stack<>();
			int ans = 0;
			
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				
				if (st.isEmpty()) {
					st.push(c);
				} else {
					char top = st.peek();
					if (c == '}' && top == '{') st.pop();
					else st.push(c);
				}
			}
			
			while (!st.isEmpty()) {
				int a = st.pop();
				int b = st.pop();
				
				if (a == b) ans += 1;
				else if (a == '{' && b == '}') ans += 2;
			}
			
			System.out.println(tc + ". " + ans);
			tc++;
		} // end of while
	} // end of main

} // end of class

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_4949_균형잡힌세상 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String s = bf.readLine();
			if (s.equals(".")) break;
			Stack<Character> st = new Stack<>();
			boolean flag = true;
			boolean noGwalho = true;
			
			for (int i = 0; i < s.length(); i++) {
				char now = s.charAt(i);
				if (now == '(' || now == '[' || now == ']' || now == ')') noGwalho = false;
				
				if (now == '(' || now == '[') st.push(now);
				else if (now == ')') {
					if (st.isEmpty()) {
						flag = false;
						break;
					}
					char top = st.peek();
					if (top == '(') st.pop();
					else {
						flag = false;
						break;
					}
				}
				else if (now == ']') {
					if (st.isEmpty()) {
						flag = false;
						break;
					}
					char top = st.peek();
					if (top == '[') st.pop();
					else {
						flag = false;
						break;
					}
				}
				else continue;
			}
			
			if (noGwalho) System.out.println("yes");
			else {
				if (!flag) System.out.println("no");
				else if (!st.isEmpty()) System.out.println("no");
				else System.out.println("yes");
			}
		}

	} // end of main

}

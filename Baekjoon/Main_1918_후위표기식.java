import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
// (A+B)*C-D == AB+C*D-
// (A+(B*C))-(D/E) == ABC*+DE/-
// A*(B+C) == ABC+*
// A+B*C*((D-E)*G) == ABC*DE-G**+
// A*B/C*D/E == AB*C/D*E/
// A+B*C+D*E+G == ABC*+DE*+G+
// A*B+C+D+E*F*G+E == AB*C+D+EF*G*+E+
// A+(B*C)*D*E+F == ABC*D*E*+F+

public class Main_1918_후위표기식 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		String ans = "";
		Stack<Character> st = new Stack<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			char now = s.charAt(i);
			
			if (now == '(') {
				st.push(now);
			} else if (now == ')') {
				while (!st.isEmpty()) {
					if (st.peek() == '(') { // '(' 를 만나면 거기까지만 pop
						st.pop();
						break;
					}
					else 
						ans += st.pop();
				}
			} else if (now == '*' || now == '/') {
				if (!st.isEmpty() && (st.peek() == '*' || st.peek() == '/')) 
					ans += st.pop();
				st.push(now);
			} else if (now == '+' || now == '-') {
				while (!st.isEmpty() && (st.peek() != '(')) { // '+', '-' 우선순위 가장 낮으므로 '(' 만날때까지 pop
						ans += st.pop();
				}
				st.push(now);
			} else { // 대문자인 경우
				ans += now;
			}
			
		}
		
		while (!st.isEmpty()) {
			ans += st.pop();
		}
		
		System.out.println(ans);

	} // end of main

} // end of class

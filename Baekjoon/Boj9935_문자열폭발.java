import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9935_문자열폭발 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static String origin, bomb;
	static Stack<Character> st = new Stack<Character>();
	private static int size;
	private static String str;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		origin = bf.readLine();
		bomb = bf.readLine();

		ex: for (int i = 0; i < origin.length(); i++) {

			char c = origin.charAt(i);
			st.push(c);
			if (c == bomb.charAt(bomb.length() - 1)) {
				// bomb길이만큼 빼서
				size = bomb.length();
				str = "";
				while (size > 0) {
					size--;
					if (st.empty()) { // 스택이 비어있으면 다시 넣고 continue
						for (int j = 0; j < str.length(); j++) {
							st.push(str.charAt(j));
						}
						continue ex;
					} else {
						str = st.pop() + str;
					}
				}
				size = 0;
				// 비교
				// 같으면 컨티뉴,
				// 다르면 bomb길이만큼 다시 push
				if (!bomb.equals(str)) {
					while (size < bomb.length()) {
						st.push(str.charAt(size));
						size++;
					}
				}

			}
		}

		while (!st.empty()) {
			sb.append(st.pop());
		}

		String ans = sb.reverse().toString();

		ans = ans.length() == 0 ? "FRULA" : ans;

		System.out.println(ans);

	} // end of main
} // end of class

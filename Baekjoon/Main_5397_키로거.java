import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_5397_키로거 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		
		for (int t=1; t<=tc; t++) {
			String s = bf.readLine();
			StringBuilder sb = new StringBuilder();
			Stack<Character> pre = new Stack<>();
			Stack<Character> post = new Stack<>();
			
			for (int i = 0; i < s.length(); i++) {
				char now = s.charAt(i);
				
				if (now == '<') {
					if (!pre.isEmpty()) post.push(pre.pop());
				}
				else if (now == '>') {
					if (!post.isEmpty()) pre.push(post.pop());
 				}
				else if (now == '-') {
					if (!pre.isEmpty()) pre.pop();
				}
				else {
					pre.push(now);
				}
			}
			
			while (!post.isEmpty()) {
				pre.push(post.pop());
			}
			
			for (int i = 0; i < pre.size(); i++) {
				sb.append(pre.elementAt(i));
			}
			System.out.println(sb);
		} // end of tc
		
	} // end of main

} // end of class

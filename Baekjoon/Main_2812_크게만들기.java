import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2812_크게만들기 {

	private static int N;
	private static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(stz.nextToken());
		K = Integer.parseInt(stz.nextToken());
		String s = bf.readLine();
		
		Stack<Integer> st = new Stack<>();	
		int popCnt = 0;
		
		for (int i = 0; i < s.length(); i++) {
			int now = s.charAt(i) - '0';
			
			if (st.isEmpty()) st.push(now);
			else {
				while (!st.isEmpty() && st.peek() < now && popCnt < K) {
					st.pop();
					++popCnt;
				}
				st.push(now);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while (!st.isEmpty()) {
			sb.append(String.valueOf(st.pop()));
		}
		sb.reverse();
		System.out.println(sb.substring(0, s.length()-K));
 	} // end of main

} // end of class

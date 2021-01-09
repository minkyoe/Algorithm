package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1662_압축 {

	private static boolean[] visited;
	private static String str;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		str = bf.readLine();
		visited = new boolean[str.length()];
		System.out.println(recur(0));
	} // end of main

	private static int recur(int idx) {
		int cnt = 0;
		for (int i = idx; i < str.length(); i++) {
			if (visited[i]) continue;

			if (str.charAt(i) == '(') { // 여는 괄호
				visited[i] = true;
				cnt--;
				cnt += (str.charAt(i - 1) - '0') * recur(i + 1);
			} else if (str.charAt(i) == ')') { // 닫는 괄호
				visited[i] = true;
				return cnt;
			} else { // 숫자
				visited[i] = true;
				cnt++;
			}
		}
		
		return cnt;
	}

}

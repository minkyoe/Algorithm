import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16719_ZOAC {

	private static String s;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		s = bf.readLine();
		visited = new boolean[s.length()];
		go (0, s.length()-1);

	} // end of main

	private static void go(int left, int right) {
		int min = Integer.MAX_VALUE;
		int minIdx = -1;
		for (int i = left; i <= right; i++) {
			if (s.charAt(i) < min && !visited[i]) {
				min = s.charAt(i);
				minIdx = i;
			}
		}
		if (minIdx == -1) return;
		visited[minIdx] = true;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (visited[i]) sb.append(s.charAt(i));
		}
		System.out.println(sb);
		
		go(minIdx+1, right);
		go(left, minIdx-1);
	}

} // end of class

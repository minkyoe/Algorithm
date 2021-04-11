import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

public class Main_1342_행운의문자열 {

	private static char[] arr;
	private static boolean[] visited;
	private static int ans;
	private static HashMap<Character, Integer> alpha;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		arr = new char[s.length()];
		visited = new boolean[s.length()];
		ans = 0;
		alpha = new HashMap<Character, Integer>();
		
		for (int i = 0; i < s.length(); i++) {
			arr[i] = s.charAt(i);
			alpha.put(arr[i], alpha.getOrDefault(arr[i], 0) + 1);
		}
		
		dfs("");
		
		Iterator<Character> it = alpha.keySet().iterator();
		while (it.hasNext()) {
			ans /= factorial(alpha.get(it.next()));
		}
		System.out.println(ans);
	} // end of main

	private static int factorial(int n) {
		if (n == 1) return 1;
		return n * factorial(n-1);
	}

	private static void dfs(String s) {
		if (s.length() == arr.length) {
			++ans;
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (visited[i] || (s.length() > 0 && s.charAt(s.length()-1) == arr[i])) continue;
			visited[i] = true;
			dfs(s + arr[i]);
			visited[i] = false;
		}
	}

} // end of class

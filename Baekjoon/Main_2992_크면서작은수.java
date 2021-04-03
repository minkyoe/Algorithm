import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2992_크면서작은수 {

	private static int num, ans;
	private static int[] arr, selected;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		num = 0;
		arr = new int[s.length()];
		selected = new int[s.length()];
		visited = new boolean[s.length()];
		ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < s.length(); i++) {
			int n = s.charAt(i) - '0';
			num += n * Math.pow(10, (s.length() - i - 1));
			arr[i] = n;
		}
		go(0, 0);
		if (ans == Integer.MAX_VALUE) System.out.println("0");
		else System.out.println(ans);
	} // end of main

	private static void go(int idx, int cnt) {
		if (cnt == arr.length) {
			int tmp = 0;
			for (int i = 0; i < selected.length; i++) {
				tmp += selected[i] * Math.pow(10, (selected.length - i - 1));
			}
			if (tmp > num) ans = Math.min(ans, tmp);
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			selected[cnt] = arr[i];
			go(idx, cnt+1);
			visited[i] = false;
		}
		
	}

} // end of class

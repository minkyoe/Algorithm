import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15663_N과M9 {

	private static int N, M;
	private static int[] arr;
	private static int[] selected;
	private static ArrayList<Integer> visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		selected = new int[M];
		visited = new ArrayList<Integer>();
		
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		go(0, "");
	} // end of main

	private static void go(int cnt, String s) {
		if (cnt == M) {
			System.out.println(s);
			return;
		}
		
		int before = -1;
		for (int i = 0; i < N; i++) {
			if (visited.contains(i) || before == arr[i]) continue;
			selected[cnt] = arr[i];
			before = arr[i];
			visited.add(i);
			go(cnt+1, s + arr[i] + " ");
			visited.remove(visited.size()-1);
		}
		
	}

} // end of class

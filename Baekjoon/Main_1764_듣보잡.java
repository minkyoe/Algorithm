import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_1764_듣보잡 {

	private static int N;
	private static int M;
	private static HashMap<String, Integer> map;
	private static ArrayList<String> ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new HashMap<String, Integer>();
		ans = new ArrayList<String>();
		
		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			map.put(str, 1);
		}
		
		for (int i = 0; i < M; i++) {
			String str = bf.readLine();
			if (map.containsKey(str)) {
				if (ans.contains(str)) continue;
				ans.add(str);
			}
		}
		
		Collections.sort(ans);
		
		StringBuilder sb = new StringBuilder();
		sb.append(ans.size()).append("\n");
		
		for (int i = 0; i < ans.size(); i++) {
			sb.append(ans.get(i)).append("\n");
		}

		System.out.println(sb);
	} // end of main

} // end of class

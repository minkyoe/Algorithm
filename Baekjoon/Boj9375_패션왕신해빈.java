package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_9375_패션왕신해빈 {
	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		
		for (int i = 1; i <= tc; i++) {
			N = Integer.parseInt(bf.readLine()); // 혜빈이가 가진 의상 수
			StringTokenizer st;
			HashMap<String, Integer> map = new HashMap<>();
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(bf.readLine(), " ");
				String name = st.nextToken();
				String kind = st.nextToken();
				if (map.containsKey(kind)) {
					map.put(kind, map.get(kind)+1);
				} else {
					map.put(kind, 1);
				}
			}
			
			int answer = 1;
			for(String s : map.keySet()) {
				int cnt = map.get(s);
				answer *= (cnt+1);
			}
			System.out.println(answer-1);
		} // end of testCase
	} // end of main
}

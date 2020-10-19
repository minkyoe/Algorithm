package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_3273_두수의합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		Map<Integer, Integer> map = new HashMap<>();
		int ans = 0;
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			map.put(Integer.parseInt(st.nextToken()), i); // value, index
		}
		
		int sum = Integer.parseInt(bf.readLine());
		
		boolean[] visited = new boolean[n];
		for (Integer key : map.keySet()) {
			if (visited[map.get(key)]) continue;
			
			int target = sum - key;
			if (target == key) continue; // 서로 다른 숫자들이 주어지기 때문에 10=5+5인 경우는 성립할 수 없음 
			if (map.containsKey(target)) {
				ans++;
				visited[map.get(key)] = true;
				visited[map.get(target)] = true;
			}
		}
		System.out.println(ans);
		
	} // end of main
} // end of class

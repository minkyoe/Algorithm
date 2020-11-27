package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14909_양수개수세기 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int ans = 0;
		while(st.hasMoreTokens()) {
			int n = Integer.parseInt(st.nextToken());
			if (n > 0) ans++;
		}
		
		System.out.println(ans);

	}

}

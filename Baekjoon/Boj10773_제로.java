package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10773_제로 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(bf.readLine());
		int ans = 0;
		
		Stack<Integer> st = new Stack<>();
		
		for (int i = 0; i < k; i++) {
			int num = Integer.parseInt(bf.readLine());
			
			if (num == 0 && st.size() != 0) st.pop();
			else st.push(num);
		}
		
		while(st.size() > 0) {
			ans += st.pop();
		}
		
		System.out.println(ans);
	}

}

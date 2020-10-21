package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
3 6
antarctica
antahellotica
antacartica
*/
public class Main_1062_가르침 {
	private static int N;
	private static int K;
	private static ArrayList<String> words;
	private static ArrayList<Character> selected;
	private static ArrayList<Character> list;
	private static int ans;
	private static ArrayList<Character> already;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 단어의 개수
		K = Integer.parseInt(st.nextToken()); // 가르칠수 있는 철자 개수
		K -= 5;
		ans = 0;
		
		words = new ArrayList<String>();
		selected = new ArrayList<Character>();
		list = new ArrayList<Character>();
		already = new ArrayList<Character>();
		already.add('a');
		already.add('n');
		already.add('t');
		already.add('i');
		already.add('c');
		
		for (int i = 0; i < N; i++) {
			String now = bf.readLine();
			
			now = now.substring(4);
			now = now.substring(0, now.length()-4);
			words.add(now);
			
			for (int j = 0; j < now.length(); j++) {
				if (already.contains(now.charAt(j))) continue;
				if (list.contains(now.charAt(j))) continue;
				list.add(now.charAt(j));
			}
		}
		
		if (list.size() <= K) System.out.println(N);
		else {
			comb(0, 0);
			System.out.println(ans);
		}
		
		
	} // end of main

	private static void comb(int idx, int cnt) {
		if (cnt == K) {
			int canRead = 0;
ex:			for (int i = 0; i < words.size(); i++) {
				String word = words.get(i);
				
				for (int j = 0; j < word.length(); j++) {
					char c = word.charAt(j);
					if (already.contains(c)) continue;
					if (selected.contains(c)) continue;
					else continue ex;
				}
				canRead++;
			}
			
			ans = ans < canRead ? canRead : ans;
			return;
		}
		
		for (int i = idx; i < list.size(); i++) {
			if (selected.contains(list.get(i))) continue;
			selected.add(list.get(i));
			comb(i+1, cnt+1);
			selected.remove(selected.size()-1);
			
		}
	}
}

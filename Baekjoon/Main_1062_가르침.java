import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1062_가르침 {

	private static int N, K, ans;
	private static ArrayList<Character> existed;
	private static ArrayList<Character> alpha;
	private static ArrayList<Character> selected;
	private static ArrayList<String> words;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()) - 5;
		ans = Integer.MIN_VALUE;
		
		existed = new ArrayList<Character>();
		existed.add('a');
		existed.add('n');
		existed.add('t');
		existed.add('i');
		existed.add('c');
		
		alpha = new ArrayList<Character>();
		words = new ArrayList<String>();
		
		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			String subStr = str.substring(4, str.length()-4);
			words.add(subStr);
			
			for (int j = 0; j < subStr.length(); j++) {
				char c = subStr.charAt(j);
				if (existed.contains(c) || alpha.contains(c)) continue;
				alpha.add(c);
			}
		}
		
		if (alpha.size() <= K) System.out.println(N);
		else {
			selected = new ArrayList<Character>();
			comb(0, 0);
			
			if (ans == Integer.MIN_VALUE) ans = 0;
			System.out.println(ans);
		}
	} // end of main

	private static void comb(int idx, int cnt) {
		if (cnt == K) {
			int count = 0;
			for (int i = 0; i < words.size(); i++) {
				boolean flag = true;
				for (int j = 0; j < words.get(i).length(); j++) {
					if (!selected.contains(words.get(i).charAt(j)) && !existed.contains(words.get(i).charAt(j))) {
						flag = false;
						break;
					}
				}
				if (flag) ++count;
			}
			ans = Math.max(ans, count);
			return;
		}
		
		for (int i = idx; i < alpha.size(); i++) {
			selected.add(alpha.get(i));
			comb(i+1, cnt+1);
			selected.remove(selected.size()-1);
		}
	}

} // end of class

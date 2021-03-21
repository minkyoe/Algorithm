import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main_1181_단어정렬 {

	private static int N;
	static class Str implements Comparable<Str>{
		String s;
		
		Str (String s) {
			this.s = s;
		}

		@Override
		public int compareTo(Str o) {
			if (o.s.length() == this.s.length()) {
				if (this.s.compareTo(o.s) > 0) 
					return 1;
				else
					return -1;
			}
			return this.s.length() - o.s.length();
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		PriorityQueue<Str> pq = new PriorityQueue<>();
		ArrayList<String> ans = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			pq.offer(new Str(bf.readLine()));
		}
		
		while (!pq.isEmpty()) {
			String s = pq.poll().s;
			if (ans.contains(s)) continue;
			ans.add(s);
		}
		
		for (String s : ans) {
			System.out.println(s);
		}
	} // end of main

} // end of class

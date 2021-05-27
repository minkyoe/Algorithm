import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10775_공항 {

	private static int G, P, ans;
	private static int[] info;
	private static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		G = Integer.parseInt(bf.readLine());
		P = Integer.parseInt(bf.readLine());
		ans = 0;
		info = new int[P+1];
		parents = new int[G+1];
		
		for (int i = 1; i <= P; i++) {
			info[i] = Integer.parseInt(bf.readLine());
		}
		
		for (int i = 1; i <= G; i++) {
			parents[i] = i;
		}
		
		
		for (int i = 1; i <= P; i++) {
			int now = find(info[i]);
			if (now == 0) {
				break;
			}
			
			union(now, now-1);
			++ans;
		}
		
		System.out.println(ans);
	} // end of main

	private static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		parents[pa] = pb;
	}

} // end of class
 
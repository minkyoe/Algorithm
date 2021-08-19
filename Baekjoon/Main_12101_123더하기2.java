import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_12101_123더하기2 {

	private static int N;
	private static int K;
	private static ArrayList<Integer> selected;
	private static int ansCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		ansCnt = 0;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		selected = new ArrayList<Integer>();
		
		if (!go(0, 0)) System.out.println("-1");;
	} // end of main

	private static boolean go(int cnt, int sum) {
		if (sum == N && ++ansCnt == K) {
			for (int i = 0; i < selected.size(); i++) {
				if (i == selected.size() - 1) System.out.print(selected.get(i));
				else System.out.print(selected.get(i) + "+");
			}
			return true;
		}
		
		for (int i = 1; i <= 3; i++) {
			if (sum + i > N) break;
			selected.add(i);
			if (go(cnt+1, sum+i)) return true;
			selected.remove(selected.size()-1);
		}
		
		return false;
	}

} // end of class

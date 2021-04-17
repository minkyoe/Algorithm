import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_2217_로프 {

	private static int N, ans;
	private static ArrayList<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		list = new ArrayList<Integer>();
		ans = 0;
		
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(bf.readLine());
			list.add(n);
		}
		Collections.sort(list);
		
		for (int i = list.size()-1; i >= 0; i--) {
			int weight = list.get(i);
			ans = Math.max(ans, (N-i)*weight);
		}
		
		System.out.println(ans);
	} // end of main

} // end of class

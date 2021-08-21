import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_1620_나는야포켓몬마스터이다솜 {

	private static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		HashMap<String,Integer> nameNum = new HashMap<>();
		HashMap<Integer,String> numName = new HashMap<>();
		
		for (int i = 1; i <= N; i++) {
			String s = bf.readLine();
			nameNum.put(s, i);
			numName.put(i, s);
		}
		
		for (int i = 0; i < M; i++) {
			String q = bf.readLine();
			int tmp = q.charAt(0) - '0';
			
			if ( 1 <= tmp && tmp <= 9 ) {
				System.out.println(numName.get(Integer.parseInt(q)));
			} else {
				System.out.println(nameNum.get(q));
			}
		}

	} // end of main

} // end of class

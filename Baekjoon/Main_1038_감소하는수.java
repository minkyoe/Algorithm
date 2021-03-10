import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1038_감소하는수 {

	private static long ans;
	private static int order;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		order = Integer.parseInt(bf.readLine()); // 순서
		
		if (order < 10) System.out.println(order);
		else {
			Queue<Long> q = new LinkedList<>();
			int cnt = 9;
			for (long i = 1; i < 10; i++) {
				q.offer(i);
			}
			
ex:			while (cnt < order) {
				long now = q.poll();
				
				for (int i = 0; i < now % 10; i++) {
					long n = Long.parseLong(String.valueOf(now) + String.valueOf(i));

					q.offer(n);
					++cnt;
					ans = n;

					if (cnt == order) {
						break ex;
					}

					if ((String.valueOf(now) + String.valueOf(i)).contentEquals("9876543210")) {
						break ex;
					}
				}
				
			}
			
			if (cnt < order) System.out.println("-1");
			else System.out.println(ans);
		}
		
	} // end of main
} // end of class

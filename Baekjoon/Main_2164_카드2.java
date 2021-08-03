import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main_2164_카드2 {

	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		Deque<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		while (true) {
			if (q.size() == 1) {
				break;
			}
			
			q.pollFirst();
			int tmp = q.pollFirst();
			q.offerLast(tmp);
		}

		System.out.println(q.poll());
	} // end of main

} // end of class

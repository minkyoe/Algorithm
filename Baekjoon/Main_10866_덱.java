import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_10866_덱 {

	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		Deque<Integer> dq = new LinkedList<>();
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			
			String order = st.nextToken();
			
			if (order.equals("push_back")) {
				int num = Integer.parseInt(st.nextToken());
				dq.offerLast(num);
			}
			else if (order.equals("push_front")) {
				int num = Integer.parseInt(st.nextToken());
				dq.offerFirst(num);
			}
			else if (order.equals("pop_front")) {
				if (dq.isEmpty()) System.out.println("-1");
				else System.out.println(dq.pollFirst());
			}
			else if (order.equals("pop_back")) {
				if (dq.isEmpty()) System.out.println("-1");
				else System.out.println(dq.pollLast());
			}
			else if (order.equals("size")) {
				System.out.println(dq.size());
			}
			else if (order.equals("empty")) {
				if (dq.isEmpty()) System.out.println("1");
				else System.out.println("0");
			}
			else if (order.equals("front")) {
				if (dq.isEmpty()) System.out.println("-1");
				else System.out.println(dq.peekFirst().toString());
			}
			else if (order.equals("back")) {
				if (dq.isEmpty()) System.out.println("-1");
				else System.out.println(dq.peekLast().toString());
			}
			
		}
		
	} // end of main

} // end of class

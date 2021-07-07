import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_11286_절댓값힙 {
	public static class Number implements Comparable<Number>{
		int num = 0;
		
		Number(int num) {
			this.num = num;
		}

		@Override
		public int compareTo(Number o) {
			int a = this.num;
			int b = o.num;
			if (Math.abs(a) == Math.abs(b)) {
				return this.num - o.num;
			}
			return Math.abs(a) - Math.abs(b);
		}
	}
	private static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		PriorityQueue<Number> pq = new PriorityQueue<Number>();
		
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(bf.readLine());
			if (n == 0) {
				if (pq.size() == 0) System.out.println("0");
				else System.out.println(pq.poll().num);
			}
			else pq.offer(new Number(n));
		} // end of for

	} // end of main

} // end of class

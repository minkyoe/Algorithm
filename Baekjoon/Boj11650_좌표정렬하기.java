import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11650_좌표정렬하기 {

	private static int N;
	private static class Point implements Comparable<Point>{
		int x;
		int y;
		
		Point (int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int compareTo(Point o) {
			if (this.x == o.x) {
				return this.y - o.y;
			}
			return this.x - o.x;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			pq.offer(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))); 
		}
		
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			sb.append(p.x).append(" ").append(p.y).append("\n");
		}
		System.out.println(sb);
	} // end of main

} // end of class

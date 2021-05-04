import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11000_강의실배정 {

	private static int N;
	private static PriorityQueue<Integer> pq;
	private static ArrayList<Time> list;
	private static class Time implements Comparable<Time>{
		int start;
		int end;
		
		Time (int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		public int compareTo(Time o) {
			if (this.start == o.start) 
				return this.end - o.end;
			return this.start - o.start;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		pq = new PriorityQueue<Integer>();
		list = new ArrayList<Time>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new Time(a, b));
		}
		Collections.sort(list);
		pq.offer(list.get(0).end);
		
		for (int i = 1; i < list.size(); i++) {
			if (!pq.isEmpty() && pq.peek() <= list.get(i).start) {
				pq.poll();
			}
			pq.offer(list.get(i).end);
		}
		System.out.println(pq.size());

	} // end of main

} // end of class

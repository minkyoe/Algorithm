import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_20115_에너지드링크 {

	private static int N;
	private static PriorityQueue<Double> pq;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		pq = new PriorityQueue<Double>(Collections.reverseOrder());
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			pq.offer(Double.parseDouble(st.nextToken()));
		}
		
		while (pq.size() > 1) {
			double bigger = pq.poll();
			double smaller = pq.poll();
			
			pq.offer(bigger + (smaller/2));
		}
		
		/**
		 Integer로 변환할 때 코드 (근데 변환 안해줘도 AC)
			double ans = pq.poll();
			
			String s = String.valueOf(ans);
			int n = (int) (Math.pow(10, s.length()-s.indexOf('.')-1) * ans);
			
			String ss = String.valueOf(n);
			
			if (ss.charAt(ss.length()-1) == '0') System.out.println((int)(ans));
			else System.out.println(ans);
		* 
		*/
		
		System.out.println(pq.poll());
	} // end of main

} // end of class

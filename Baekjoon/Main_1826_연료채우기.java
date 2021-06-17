import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1826_연료채우기 {

	private static int N;
	private static class Spot implements Comparable<Spot>{
		int idx;
		int fuel;
		
		Spot (int idx, int fuel) {
			this.idx = idx;
			this.fuel = fuel;
		}
		
		public int compareTo(Spot o) {
			return o.fuel - this.fuel;
		}
	}
	private static int L;
	private static int P;
	private static int stopCnt;
	private static HashMap<Integer, Integer> map;
	private static ArrayList<Integer> dist;
	private static PriorityQueue<Spot> availableSpot;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine()); // 주유소 개수
		
		stopCnt = 0;
		map = new HashMap<Integer,Integer>();
		dist = new ArrayList<Integer>();
		availableSpot = new PriorityQueue<Spot>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dist.add(a);
			map.put(a, b);
		}

		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		L = Integer.parseInt(st.nextToken()); // 도착 지점
		P = Integer.parseInt(st.nextToken()); // 현재 연료 양
		int now = 0; // 현재 성경이 위치
		int remainFuel = P; // 성경이에게 남은 연료
		int spotIdx = 0;
		
		Collections.sort(dist); // 가장 가까운 거리부터 접근
		
		while ((now + remainFuel) < L) {
			while (spotIdx < N && (now + remainFuel) >= dist.get(spotIdx)) {
				// 접근 가능한 주유소 다 탐색해서 저장
				availableSpot.offer(new Spot (dist.get(spotIdx), map.get(dist.get(spotIdx))));
				spotIdx++;
			}
			
			if (availableSpot.isEmpty()) {
				stopCnt = -1;
				break;
			}
			
			// 연료 가장 많은 주유소부터 접근
			Spot spot = availableSpot.poll();
			remainFuel -= (spot.idx - now);
			remainFuel += spot.fuel;
			now = spot.idx;
			stopCnt++;
		} // end of while
		
		System.out.println(stopCnt);
	} // end of main

} // end of class

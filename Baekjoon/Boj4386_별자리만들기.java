import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_백준_4386_별자리만들기 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N; // 별의 개수
	static ArrayList<double[]> list = new ArrayList<>(); // 좌표 담은 리스트
	static ArrayList<Star> stars = new ArrayList<>();
	static int[] parents;
	
	static class Star implements Comparable<Star>{
		int n1; // 리스트에 있는 별자리 인덱스 
		int n2; // 리스트에 있는 별자리 인덱스
		double weight;
		
		public Star() {
		}

		public Star(int n1, int n2, double weight) {
			super();
			this.n1 = n1;
			this.n2 = n2;
			this.weight = weight;
		}

		@Override
		public int compareTo(Star o) {
			return Double.compare(this.weight, o.weight);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(bf.readLine());
		parents = new int[N+1]; // 0번안씀
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			list.add(new double[] {Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())});
		}
		
		// 각 좌표 사이 거리 구하기
		for (int i = 0; i < list.size()-1; i++) {
			for (int j = i+1; j < list.size(); j++) {
				double x1 = list.get(i)[0];
				double y1 = list.get(i)[1];
				
				double x2 = list.get(j)[0];
				double y2 = list.get(j)[1];
				
				double dist = Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
				stars.add(new Star(i+1, j+1, dist));
			}
		}
		
		Collections.sort(stars);
		
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		int cnt = 0;
		double sum = 0;
		for (Star s : stars) {
			if (cnt == N-1) break;
			if (union(s.n1, s.n2)) {
				++cnt;
				sum += s.weight;
			}
		}
		System.out.println(Math.round(sum*100)/100.0);
		
		
	} // end of main

	private static boolean union(int n1, int n2) {
		int a = find(n1);
		int b = find(n2);
		if (a == b) return false;
		parents[b] = a;
		return true;
	}

	private static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}

} // end of class

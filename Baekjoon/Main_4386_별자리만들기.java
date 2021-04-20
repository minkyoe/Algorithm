import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_4386_별자리만들기 {

	private static int N;
	private static int[] parents;
	private static ArrayList<Star> stars;
	private static ArrayList<Vertex> vertex;
	
	static class Star {
		double y;
		double x;
		
		Star (double y, double x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static class Vertex implements Comparable<Vertex>{
		int idx1;
		int idx2;
		double weight;
		
		Vertex(int idx1, int idx2, double weight) {
			this.idx1 = idx1;
			this.idx2 = idx2;
			this.weight = weight;
		}
		
		public int compareTo(Vertex o) {
			return (int) (this.weight - o.weight);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		parents = new int[N];
		stars = new ArrayList<Star>();
		vertex = new ArrayList<Vertex>();
		
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			stars.add(new Star(x, y));
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				double dist = Math.sqrt(Math.pow(stars.get(i).x-stars.get(j).x, 2) + Math.pow(stars.get(i).y-stars.get(j).y, 2));
				vertex.add(new Vertex(i, j, dist));
			}
		}
		
		Collections.sort(vertex);
		double ans = 0;
		for (int i = 0; i < vertex.size(); i++) {
			if (!merge(vertex.get(i).idx1, vertex.get(i).idx2)) continue;
			ans += vertex.get(i).weight;
		}
		
		System.out.println(Math.round(ans * 100) / 100.0);
		
	} // end of main
	
	public static boolean merge(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) return false;
		parents[b] = a;
		return true;
	}
	
	public static int find(int a) {
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}

} // end of class

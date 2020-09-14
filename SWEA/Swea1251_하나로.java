import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_1251_하나로 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static int tc;
	static int N; // 섬의 개수
	static Point[] island;
	static int[] parents;
	static double e; // 세율
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		tc = Integer.parseInt(bf.readLine());
		for (int testCase = 1; testCase <= tc; testCase++) {
			N = Integer.parseInt(bf.readLine());
			island = new Point[N];
			ArrayList<Edge> edgeList = new ArrayList<>();
			parents = new int[N];
			
			for (int i = 0; i < N; i++) {
				island[i] = new Point();
			}
			
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			StringTokenizer st2 = new StringTokenizer(bf.readLine(), " ");
			for (int i = 0; i < N; i++) {
				island[i].x = Integer.parseInt(st.nextToken());
				island[i].y = Integer.parseInt(st2.nextToken());
			}
			
			double e = Double.parseDouble(bf.readLine());
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					long dist = (long) (Math.pow(island[i].x-island[j].x, 2) + Math.pow(island[i].y-island[j].y, 2));
					edgeList.add(new Edge(i,j,dist));
				}
			}
			
			Collections.sort(edgeList);
			make();
			
			long sum = 0;
			int cnt = 0;
            for (Edge edge : edgeList) {
                if (union(edge.from, edge.to)) {
                	cnt++;
                	sum += edge.weight;
                }
                if (cnt == N-1) break;

            }
            
            System.out.println("#" + testCase + " " + Math.round(sum*e));
			
			
		} // end of testCase

	} // end of main
	
	private static void make() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	private static int find(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
		
	}

} // end of class
class Edge implements Comparable<Edge>{
	int from;
	int to;
	long weight;

	public Edge() {
	}
	
	public Edge(int from, int to, long weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return Long.compare(this.weight, o.weight);
	}
}

class Point {
	int y;
	int x;
	public Point() {
	}
	public Point(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
}
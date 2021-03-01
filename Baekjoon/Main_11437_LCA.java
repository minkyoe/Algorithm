import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11437_LCA {

	private static int N;
	private static int[] depth;
	private static int[] parent;
	private static ArrayList<Integer>[] tree;
	private static int M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		depth = new int[N+1];
		parent = new int[N+1];
		tree = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			tree[a].add(b);
			tree[b].add(a);
		}
		
		dfs(1, 1, 0);

		M = Integer.parseInt(bf.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(lca(a,b));
		}
	} // end of main

	private static int lca(int a, int b) {
		int ad = depth[a];
		int bd = depth[b];
		
		while (ad > bd) {
			a = parent[a];
			ad -= 1;
		}
		
		while (ad < bd) {
			b = parent[b];
			bd -= 1;
		}
		
		while (a != b) {
			a = parent[a];
			b = parent[b];
		}
		
		return a;
	}

	private static void dfs(int cur, int dep, int par) {
		depth[cur] = dep;
		parent[cur] = par;
		
		for (int i = 0; i < tree[cur].size(); i++) {
			int now = tree[cur].get(i);
			if (now != par) {
				dfs(now, dep+1, cur);
			}
		}
	}

} // end of class

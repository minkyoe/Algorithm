import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_3584_가장가까운공통조상 {

	private static int N;
	private static ArrayList<Integer>[] tree;
	private static int[] depth;
	private static int[] parent;
	private static int root;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		
		for (int testCase = 1; testCase <= tc; testCase++) {
			N = Integer.parseInt(bf.readLine());
			tree = new ArrayList[N+1];
			depth = new int[N+1];
			parent = new int[N+1];
			
			for (int i = 1; i <= N; i++) {
				tree[i] = new ArrayList<Integer>();
			}
			
			for (int i = 0; i < N-1; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				tree[a].add(b);
				parent[b] = a;
			}
			
			root = 0;
			for (int i = 1; i <= N; i++) {
				if (parent[i] == 0)
					root = i;
			}
			
			dfs(root, 1, 0);
			
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(lca(a, b));
		} // end of tc

	} // end of main

	private static int lca(int a, int b) {
		int ad = depth[a];
		int bd = depth[b];
		
		while (ad > bd) {
			a = parent[a];
			ad--;
		}
		
		while(ad < bd) {
			b = parent[b];
			bd--;
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
			dfs(tree[cur].get(i), dep+1, cur);
		}
	}

} // end of class
 
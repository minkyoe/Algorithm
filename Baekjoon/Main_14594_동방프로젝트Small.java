import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 직접 생각해본 반례
/*
 4
 3
 1 2
 3 4
 2 3
 */

public class Main_14594_동방프로젝트Small {

	private static int N, M;
	private static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		M = Integer.parseInt(bf.readLine());
		
		parents = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for (int j = a; j < b; j++) {
				union(j, j+1);
			}
		}
		
		HashSet<Integer> ans = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			ans.add(find(i)); // 부모 노드의 부모가 갱신될 수 있기 때문에 parents[i]로 카운트하면 안됨
		}
		System.out.println(ans.size());
	} // end of main

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a == b) return;
		parents[b] = find(a);
	}

	private static int find(int a) {
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}

} // end of class

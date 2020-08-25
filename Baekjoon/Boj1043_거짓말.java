import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_Boj_1043_거짓말 {
	static HashSet<Integer>[] list;
	static ArrayList<Integer>[] partyInfo;

	static int N, M; // 사람수, 파티수
	static boolean[] mustTruth; // 진실만 말해야하는지 
	static ArrayList<Integer> mustTruthPP = new ArrayList<Integer>(); // 진실을 알고있는 사람 인덱스
	static int mustCnt = 0; // 진실을 알고 있는 사람들 세기
							// 0이라면 정답은 파티수 (전체 사람수와 같다면 정답은 0 ==> 아님!! 아무도 안오는 파티가 있을 수도 있음)
	static int ans = 0;
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean[] visited;
	private static int partyInfoIdx;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = M;
		
		list = new HashSet[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new HashSet<>();
		}
		partyInfo = new ArrayList[M];
		partyInfoIdx = 0;
		
		mustTruth = new boolean[N+1]; // 0번 인덱스 안씀
		visited = new boolean[N+1]; // 0번 인덱스 안씀
	
		st = new StringTokenizer(bf.readLine(), " ");
		int knowCnt = Integer.parseInt(st.nextToken());
		for (int i = 0; i < knowCnt; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			mustTruth[tmp] = true; 
			mustTruthPP.add(tmp);
		}
		
		for (int i = 0; i < M; i++) { // 파티 수 만큼
			st = new StringTokenizer(bf.readLine(), " ");
			int pp = Integer.parseInt(st.nextToken()); // 파티 참여 인원 수 
			

			ArrayList<Integer> tmp = new ArrayList<Integer>();
			for (int j = 0; j < pp; j++) {
				tmp.add(Integer.parseInt(st.nextToken()));
			}
			
			if (tmp.size()==0) {
				tmp.add(0);
			}
			partyInfo[partyInfoIdx++] = tmp;
		}
		
		// 인접 리스트 만들기
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < partyInfo[i].size(); j++) {
				int idx = partyInfo[i].get(j);
				if (idx == 0) break;
				
				for (int k = 0; k < partyInfo[i].size(); k++) {
					int other = partyInfo[i].get(k);
					
					if (idx == other) continue;
					list[idx].add(other);
				}
			}
		}
		
		// 진실 아는 사람부터 돌면서 진실만 말해야하는지 체크
		for (int i = 0; i < mustTruthPP.size(); i++) {
			checkMustTruth(mustTruthPP.get(i));
		}
		
		
		// 진실을 알고있는사람이 한명도 없다면 
		if (mustCnt == 0) {
			System.out.println(M);
		} else {
			// partyInfo 돌면서 한명이라도 mustTruth가 false라면 ans--
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < partyInfo[i].size(); j++) {
					int idx = partyInfo[i].get(j);
					if (mustTruth[idx]) {
						ans--;
						break;
					}
				}
			}
			
			System.out.println(ans);
		}
		
		

	} // end of main

	private static void checkMustTruth(int curIdx) {
		if (list[curIdx].size() == 0) mustCnt++;
		
		for (int idx : list[curIdx]) {
			if (visited[idx]) continue;
			visited[idx] = true;
			mustTruth[idx] = true;
			mustCnt++;
			checkMustTruth(idx);
		}
	}

} // end of class

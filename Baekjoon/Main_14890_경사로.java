import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14890_경사로 {
	private static int N; // 지형 크기
	private static int X; // 활주로 길이
	private static int[][] map;
	private static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		ans = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		process();
		System.out.println(ans);
			
	} // end of main
	
	private static void process() {
		for (int i = 0; i < N; i++) {
			if (makeRoadByRow(i)) ++ans;
			if (makeRoadByCol(i)) ++ans;
		}
		
	}

	private static boolean makeRoadByRow(int i) {
		int beforeHeight, size; // 이전칸의 높이, 평탄한 지형의길이
		beforeHeight = map[i][0];
		size = 1;
		
		for (int j = 1; j < N; j++) {
			if(beforeHeight == map[i][j]) {
				++size;
			} else if (beforeHeight+1 == map[i][j]) {
				if(size < X) return false;
				beforeHeight++;
				size = 1;
			} else if (beforeHeight-1 == map[i][j]) {
				int count = 0;
				for (int k =j; k < N; k++) {
					if(map[i][k] != beforeHeight-1) break;
					count++;
				}
				if(count < X) return false;
				j += X-1;
				beforeHeight--;
				size = 0;
			} else {
				return false;
			}
		}
		return true;
	}
	private static boolean makeRoadByCol(int i) {
		int beforeHeight, size; // 이전칸의 높이, 평탄한 지형의길이
		beforeHeight = map[0][i];
		size = 1;
		
		for (int j = 1; j < N; j++) {
			if(beforeHeight == map[j][i]) {
				++size;
			} else if (beforeHeight+1 == map[j][i]) {
				if(size < X) return false;
				beforeHeight++;
				size = 1;
			} else if (beforeHeight-1 == map[j][i]) {
				int count = 0;
				for (int k =j; k < N; k++) {
					if(map[k][i] != beforeHeight-1) break;
					count++;
				}
				if(count < X) return false;
				j += X-1;
				beforeHeight--;
				size = 0;
			} else {
				return false;
			}
		}
		return true;
	}
}

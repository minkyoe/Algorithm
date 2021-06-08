import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_21918_전구 {

	private static int N, M;
	private static int[] lights;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lights = new int[N+1];
		
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			lights[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (a == 1) {
				lights[b] = c;
			}
			else if (a == 2) {
				for (int j = b; j <= c; j++) {
					lights[j] = (lights[j] + 1) % 2;
				}
			}
			else if (a == 3) {
				for (int j = b; j <= c; j++) {
					lights[j] = 0;
				}
			}
			else {
				for (int j = b; j <= c; j++) {
					lights[j] = 1;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(lights[i] + " ");
		}

	} // end of main

} // end of class

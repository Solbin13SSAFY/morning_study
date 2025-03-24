import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		char[] str = br.readLine().toCharArray();
		int zero = 0;
		for (int i=0;i<str.length;i++) {
			if (str[i]=='0') zero++;
		}
		int one = str.length-zero;
		one/=2;
		zero/=2;
		for (int i=0;i<str.length;i++) {
      // 0은 앞쪽부터 절반을 채워넣고 나머지를 무시함
			if (str[i]=='0'&&zero>0) {
				sb.append('0');
				zero--;
			} else if (str[i]=='1') {
        // 1은 앞쪽부터 절반을 무시하고 나머지를 채워넣음
				if (one>0) {
					one--;
				} else {
					sb.append('1');
				}
			}
		}
		System.out.println(sb);
	}
}

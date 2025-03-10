import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) throws Exception {
    	int x = Integer.parseInt(br.readLine());
    	System.out.println(Integer.bitCount(x));
    }
}

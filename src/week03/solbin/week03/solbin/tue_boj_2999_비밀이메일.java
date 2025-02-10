package week03.solbin;

import java.util.*;
class Main
{
    final static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) throws Exception
    {
    	String str = sc.next();
    	
    	int n = str.length();
    	int r = 1;
    	int c = n;
    	// R<=C�씠怨� R*C=N�씠誘�濡� sqrt(n)�뿉�꽌 李⑤���濡� �븯�굹�뵫 以꾩뿬�굹媛꾨떎.
    	for (int i=(int) Math.sqrt(n);i>0;i--) {
    		if (n%i==0) {
    			r=i;
    			c/=r;
    			break;
    		}
    	}
    	String res = "";
    	for (int i=0;i<r;i++) {
    		for (int j=0;j<c;j++) {
    			res+=str.charAt(r*j+i);
    		}
    	}
    	System.out.println(res);
    }
} 
package week03.solbin;

import java.util.*;
class Main
{
    final static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) throws Exception
    {
        int n = sc.nextInt();
        char[] arr = sc.next().toCharArray();
        boolean isFliped = false;
        int sum = n;
        for (int i=0;i<n-1;i++) {
        	if (arr[i]=='L'&&arr[i+1]=='L') {
        		if (isFliped) {
                    // 而ㅽ뵆�꽍 留뚮궇�븣留덈떎 而� 媛쒖닔瑜� 以꾩엫
        			sum--;
                    // �씠誘� 吏��굹�삩 湲몄� �떛湲��씠�씪怨� �몴�떆�븿
        			arr[i]='S';
        			arr[i+1]='S';
        		} else {
                    // 而ㅽ뵆�꽍�씠 泥섏쓬 �굹�삤�뒗 怨녹뿉�꽌 而듯��뜑 諛⑺뼢�쓣 �뮘吏묒쓬.
        			isFliped=true;
        			arr[i]='S';
        			arr[i+1]='S';
        		}
        	}
        }
        System.out.println(sum);
    }
} 
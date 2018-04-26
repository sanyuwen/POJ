package Main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int R = 0;
        int n = 0;
        while(R!=-1) {
        	R = in.nextInt();
        	n = in.nextInt();
        	if(R==-1) {
        		break;
        	}
        	int[] a = new int[n];
        	int i = 0;
        	while(i<n) {
        		a[i++]=in.nextInt();
        	}
        	Arrays.sort(a);
        	int result = 0;
        	int bound = -1;
        	for(int j=0;j<a.length;j++) {
        		if(a[j]>bound) { //find a new that not included
        			bound=a[j]+R;
        			
        			//go as far as you can
        			int t=j;
        			for(;t<a.length;t++) {
        				if(a[t]>bound) {
        					bound = a[t-1] + R;
        					result++;
        					break;
        				}
        			}
        			if(t==a.length) {
        				result++;
        				break;
        			}
        			
        		}
        	}
        	System.out.println(result);
        }
        in.close();
    }
}
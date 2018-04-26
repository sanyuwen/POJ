package Main;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int result = 0;
        int num = in.nextInt();
        int[] oil = new int[num];
        int[] dis = new int[num];
        for(int i=0;i<num;i++) {
        	dis[i] = in.nextInt();
        	oil[i] = in.nextInt();
        	int t=i;
        	while(t>0&&dis[t]<dis[t-1]) {
        		int temp = dis[t];
        		dis[t] = dis[t-1];
        		dis[t-1] = temp;
        		
        		temp = oil[t];
        		oil[t] = oil[t-1];
        		oil[t-1] = temp;
        		t--;
        	}
        }
        int L = in.nextInt();
        int P = in.nextInt();
        int j=num-1;
        while(dis[j]>L) {
        	j--;
        }
        L = L - P;
        PriorityQueue<Integer> stations = new PriorityQueue<Integer>(10, Collections.reverseOrder());
        
        while(L>0) {
        		
            	while(j>=0&&dis[j]>=L) {
            		stations.add(oil[j]);
            		j--;
            	}
            	if(stations.isEmpty()==true) {
            		result = -1;
            		break;
            	}else {
            		L-=stations.poll();
            		result++;
            	}
            }        
        System.out.println(result);
        in.close();
    }
}
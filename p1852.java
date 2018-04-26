import java.io.*;
import java.util.*;


public class Main
{
    static String ReadLn (int maxLg)  // utility function to read from stdin
    {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;

        try
        {
            while (lg < maxLg)
            {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin [lg++] += car;
            }
        }
        catch (IOException e)
        {
            return (null);
        }

        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String (lin, 0, lg-1));   // for online judge
    }

    public static void main (String args[])  // entry point from OS
    {
        Main myWork = new Main();  // create a dinamic instance
        myWork.Begin();            // the true entry point
    }

    void Begin()
    {
        String input;
        int casenum = 0;
        if((input = Main.ReadLn (255)) != null) {
        	casenum = Integer.parseInt(input);
        }
        for(int i=0;i<casenum;i++) {
        	input = Main.ReadLn (255);
			if(input==null){
				break;
			}
				
        	String[] r1 = input.split(" ");
        	int totallen = Integer.parseInt(r1[0]);
        	int n = Integer.parseInt(r1[1]);
        	input = Main.ReadLn (255);
			if(input==null){
				break;
			}
        	String[] r2 = input.split(" ");
        	int[] dis = new int[n];
        	for(int t=0;t<n;t++) {
        		dis[t] = Integer.parseInt(r2[t]);
        	}
        	int min=0,max=0;
        	for(int j=0;j<n;j++) {
        		min = Math.max(min, Math.min(dis[j], totallen-dis[j]));
        		max = Math.max(max, Math.max(dis[j], totallen-dis[j]));
        	}
        	System.out.println(String.valueOf(min)+" "+String.valueOf(max));
        }
    }
}

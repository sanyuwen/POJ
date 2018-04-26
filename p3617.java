package Main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int l=len;
        StringBuilder s = new StringBuilder();
        StringBuilder r = new StringBuilder();
        while(l>0) {
        	s.append(in.next());
        	l--;
        }
        while(s.length()>0) {
        	String reverse = s.reverse().toString();
        	s.reverse();
        	if(s.toString().compareTo(reverse)<0) {
        		r.append(s.charAt(0));
        		s.deleteCharAt(0);
        	}else {
        		int last = s.length()-1;
        		r.append(s.charAt(last));
        		s.deleteCharAt(last);
        	}
        }
        
        System.out.print(r.toString());
        in.close();
    }
}
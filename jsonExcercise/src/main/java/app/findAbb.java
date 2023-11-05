package app;

import entity.State;
import util.StateUtil;

public class findAbb {
	public static void main(String[] args) {
		State state = StateUtil.findAB("AK");
		if(state == null) 
			System.out.println("k thay");
		
		else
			System.out.println(state);
		}
	

}

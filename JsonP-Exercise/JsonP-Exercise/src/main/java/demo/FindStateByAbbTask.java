package demo;

import entity.State;
import mapper.StateUtil;

public class FindStateByAbbTask {
	public static void main(String[] args) {
		StateUtil stateUtil = new StateUtil();
		State state = stateUtil.findByAb("al");
		if(state == null)
			System.out.println("Not found!");
		else
			System.out.println(state);
	}
}

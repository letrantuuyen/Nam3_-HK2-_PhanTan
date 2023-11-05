package demo;

import entity.State;
import mapper.StateUtilObjectModel;

public class FindStateByAbbTask2 {
	public static void main(String[] args) {
		StateUtilObjectModel stateUtil = new StateUtilObjectModel();
		State state = stateUtil.findByAb("alds");
		if(state == null)
			System.out.println("Not found!");
		else
			System.out.println(state);
	}
}

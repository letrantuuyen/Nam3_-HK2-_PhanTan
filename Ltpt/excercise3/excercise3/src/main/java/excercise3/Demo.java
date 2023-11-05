package excercise3;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        // Find state by abbreviation
        State state = StateUtil.findByAb("AK");
        if (state == null)
            System.out.println("Not found!");
        else
            System.out.println(state);

        // Find states by statehood year
        ArrayList<State> states = StateUtil.findByYear(1837);
        if (states.isEmpty()) {
            System.out.println("No states found!");
        } else {
        	System.out.println("Found:");
            for (State state1 : states) {
                System.out.println(state1);
            }
        }
    }
}

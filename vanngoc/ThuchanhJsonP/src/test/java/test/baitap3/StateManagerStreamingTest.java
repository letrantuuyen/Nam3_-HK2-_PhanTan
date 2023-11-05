package test.baitap3;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import baitap3.State;
import baitap3.StateManagerStreaming;

class StateManagerStreamingTest {

	private static final String FILE_NAME = "data/states.json";
	private StateManagerStreaming manager;

	@BeforeEach
	void setUp() throws Exception {
		manager = new StateManagerStreaming(FILE_NAME);
	}

	@Test
	void testFindByAb() throws FileNotFoundException {
		State state = manager.findByAb("ak");
		assertEquals(2, state.getId());
	}

}

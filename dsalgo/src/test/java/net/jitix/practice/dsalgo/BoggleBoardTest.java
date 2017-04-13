package net.jitix.practice.dsalgo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import net.jitix.practice.dsalgo.BooggleBoard.Position;

public class BoggleBoardTest {

	@Test
	public void testGetAdjacentPositions() {
		Set<Position> adjPos = new BooggleBoard().getAdjacentPositions(new Position(0, 0), new HashSet<Position>());

		System.out.println(Arrays.toString(adjPos.toArray(new Position[adjPos.size()])));

	}

	@Test
	public void testGetWords() {
		System.out.println(Arrays.toString(new BooggleBoard().getWords()));
	}

}

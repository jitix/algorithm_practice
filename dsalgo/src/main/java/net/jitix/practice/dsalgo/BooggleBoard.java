package net.jitix.practice.dsalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BooggleBoard {

	public static class Position {
		private int i;
		private int j;

		public Position(int i, int j) {
			this.i = i;
			this.j = j;
		}

		public int getI() {
			return i;
		}

		public int getJ() {
			return j;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + i;
			result = prime * result + j;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Position other = (Position) obj;
			if (i != other.i)
				return false;
			if (j != other.j)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Position [i=" + i + ", j=" + j + "]";
		}

	}

	private String[] dictionary = {"GEEK", "GEEKS", "FOR", "QUIZ", "GO" };
	private char[][] board = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' }, { 'Q', 'S', 'E' } };

	private boolean isWord(String word) {
		System.out.println("Checking string "+word);
		return Arrays.asList(dictionary).contains(word);
	}

	public String[] getWords() {
		List<String> results = new ArrayList<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				Set<Position> visitedSet = new HashSet<>();
				System.out.println("Visiting "+i+"-"+j+": "+board[i][j]);
				List<String> posResults = findWordFromPosition(board[i][j]+"", new Position(i, j), visitedSet);
				results.addAll(posResults);
			}
		}

		return results.toArray(new String[results.size()]);
	}

	private List<String> findWordFromPosition(String currentString, Position pos, Set<Position> visitedSet) {
		visitedSet.add(pos);

		List<String> posResults = new ArrayList<>();
		// find all adjacent positions which have not been traversed
		Set<Position> adjacentPositions = getAdjacentPositions(pos, visitedSet);

		for (Position adjacentPosition : adjacentPositions) {
			// check if the word formed by appending the adjacent position's
			// char to the current String is valid
			String str = currentString + board[adjacentPosition.getI()][adjacentPosition.getJ()];
			if (isWord(str)) {
				posResults.add(str);
			}

			posResults.addAll(findWordFromPosition(str, adjacentPosition, new HashSet<Position>(visitedSet)));
		}

		return posResults;
	}

	Set<Position> getAdjacentPositions(Position pos, Set<Position> visitedSet) {
		Set<Position> adjacentPositions = new HashSet<>();

		addValidPosition(pos.getI() - 1, pos.getJ() - 1, adjacentPositions,visitedSet);
		addValidPosition(pos.getI() - 1, pos.getJ(), adjacentPositions,visitedSet);
		addValidPosition(pos.getI() - 1, pos.getJ() + 1, adjacentPositions,visitedSet);
		addValidPosition(pos.getI(), pos.getJ() - 1, adjacentPositions,visitedSet);
		addValidPosition(pos.getI(), pos.getJ() + 1, adjacentPositions,visitedSet);
		addValidPosition(pos.getI() + 1, pos.getJ() - 1, adjacentPositions,visitedSet);
		addValidPosition(pos.getI() + 1, pos.getJ(), adjacentPositions,visitedSet);
		addValidPosition(pos.getI() + 1, pos.getJ() + 1, adjacentPositions,visitedSet);

		return adjacentPositions;
	}

	private void addValidPosition(int i, int j, Set<Position> adjacentPositions, Set<Position> visitedSet) {
		if (i < 0 || j < 0 || i >= board.length || j >= board.length) {
			return;
		} else {
			Position pos=new Position(i, j);
			if(!visitedSet.contains(pos)){
				adjacentPositions.add(new Position(i, j));
			}
		}
	}

}

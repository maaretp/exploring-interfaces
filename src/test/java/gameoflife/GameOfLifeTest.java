package gameoflife;

import java.awt.Point;
import java.util.List;

import org.approvaltests.Approvals;
import org.junit.Test;

public class GameOfLifeTest {

	@Test
	public void test0Neighbors() throws Exception {
		verifyGameOfLife(0);
	}

	@Test
	public void test1Neighbors() throws Exception {
		verifyGameOfLife(1);
	}

	@Test
	public void test2Neighbors() throws Exception {
		verifyGameOfLife(2);
	}

	@Test
	public void test3Neighbors() throws Exception {
		verifyGameOfLife(3);
	}

	@Test
	public void test4Neighbors() throws Exception {
		verifyGameOfLife(4);
	}

	@Test
	public void test8Neighbors() throws Exception {
		verifyGameOfLife(8);
	}

	@Test
	public void testGameOfLifeGui() throws Exception {
		GameOfLife game = new GameOfLife(10, 9);
		for (Point point : GameOfLife.getNeighbors(new Point(2, 2))) {
			game.placeCell(point);
		}
		for (Point point : GameOfLife.getNeighbors(new Point(2, 5))) {
			game.placeCell(point);
		}
		Approvals.verify(new GameOfLifeGui(game));
	}

	private void verifyGameOfLife(int number) throws Exception {
		GameOfLife game = new GameOfLife(10, 9);
		game.placeCell(2, 2);
		List<Point> neighbors = GameOfLife.getNeighbors(new Point(2, 2));
		for (int i = 0; i < number; i++) {
			Point point = neighbors.get(i);
			game.placeCell(point.x, point.y);
			}
		String output = "1) \n" + game;
		game.advanceTurn();
		output += "2) \n" + game;
		Approvals.verify(output);
	}

}
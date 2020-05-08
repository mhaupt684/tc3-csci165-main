import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Hobbit_Test {
	
	//testing to make sure the hobbit runs away in the right direction

	int rows = 5;
	int columns = 5;
	
	//5x5 grid forcing a hobbit to move to 4,4
	Hobbit hobbit1 = new Hobbit(new Coordinate(0,0));
	Nazgul n1 = new Nazgul(new Coordinate(1,1));
	Nazgul n2 = new Nazgul(new Coordinate(1,4));
	Nazgul n3 = new Nazgul(new Coordinate(4,1));
	ArrayList<Creature> testHobbit = new ArrayList<Creature>();
	ArrayList<Creature> deadhobbit = new ArrayList<Creature>();
	Food f1 = new Food(new Coordinate(4,3));
	ArrayList<Item> food = new ArrayList<Item>();
	ArrayList<Item> takenFood = new ArrayList<Item>();
	ArrayList<Coordinate> moves = null;
	Coordinate bestMove = null;
	String answer = "";
	
	
	@Test
	void testHobbitCornerMove() {
		
		//add creatures to the field
		testHobbit.add(hobbit1);
		testHobbit.add(n1);
		testHobbit.add(n2);
		testHobbit.add(n3);
			
		//add food to items list
		food.add(f1);
		
		//add moves to arraylist
		moves = new ArrayList<Coordinate>(hobbit1.scanNeighborhood(rows, columns));
		
		//save best move
		bestMove = new Coordinate(hobbit1.determineMove(moves, testHobbit, food, rows, columns));
		
		//save the answer
		answer = bestMove.toString();
		
		//test that the hobbit picked the best move
		assertTrue(answer.equals("Coords (4,4)"));
		
		//test that the hobbit move function works
		hobbit1.move(bestMove);
		hobbit1.countDown();
		
		//save answer
		answer = hobbit1.getCoordinate().toString();
		
		//test move
		assertTrue(answer.equals("Coords (4,4)"));
		
		//test counter
		assertTrue(hobbit1.getFoodCounter() == 2);
		
	}

	
	@Test
	void testMoveFood() {
		//**setup from previous test
		
		//add creatures to the field
		testHobbit.add(hobbit1);
		testHobbit.add(n1);
		testHobbit.add(n2);
		testHobbit.add(n3);
			
		//add food to items list
		food.add(f1);
		
		hobbit1.move(new Coordinate(4,4));
		hobbit1.countDown();
		
		//**
		
		//test next move where there is a food choice
		moves = new ArrayList<Coordinate>(hobbit1.scanNeighborhood(rows, columns));
		bestMove = new Coordinate(hobbit1.determineMove(moves, testHobbit, food, rows, columns));
		hobbit1.move(bestMove);
		hobbit1.countDown();
		answer = hobbit1.getCoordinate().toString();
		
		assertTrue(answer.equals("Coords (4,3)"));
		
		//test the action method -- ie does the hobbit take the food
		hobbit1.action(testHobbit, deadhobbit, food, takenFood);
		food.removeAll(takenFood);
		
		//test food arraylist is empty
		assertTrue(food.size() == 0);
		
		//save answer
		answer = hobbit1.getCoordinate().toString();
		
		//test move
		assertTrue(answer.equals("Coords (4,3)"));
		
		//test counter
		assertTrue(hobbit1.getFoodCounter() == 3);
				
	}
	
	//impossible to predict the random move, just printing out to see it not the same every time
	@Test
	void testMoveRandom() {
		//add creatures to the field
		testHobbit.add(hobbit1);
		testHobbit.add(n1);
		testHobbit.add(n2);
		testHobbit.add(n3);
		
		hobbit1.move(new Coordinate(4,3));
		
		//test next move, should be farthest away from nazgul (3,2)
		moves = new ArrayList<Coordinate>(hobbit1.scanNeighborhood(rows, columns));
		bestMove = new Coordinate(hobbit1.determineMove(moves, testHobbit, food, rows, columns));
		hobbit1.move(bestMove);
		hobbit1.countDown();
		answer = hobbit1.getCoordinate().toString();
		
		//print the random movement
		System.out.println(answer);
		
		
		
	}
	
	

}

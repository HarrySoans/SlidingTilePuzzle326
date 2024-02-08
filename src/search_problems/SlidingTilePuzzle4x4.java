package search_problems;

import core_search.Problem;
import core_search.Tuple;

import java.util.ArrayList;
import java.util.List;

public class SlidingTilePuzzle4x4 implements Problem<List<Integer>, String> {

    //empty cell is 0
    private final List<Integer> INITIAL_STATE =
            new ArrayList<>(List.of(12,1,2,15,11,6,5,8,7,10,9,4,0,13,14,3));

    private final List<Integer> GOAL_STATE =
            new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0));

    //size of the board, e.g.,
    //SIZE = 3 means 3x3 board
    private final int SIZE;

    public SlidingTilePuzzle4x4() {
        SIZE = (int) Math.sqrt(INITIAL_STATE.size());

    }
    public SlidingTilePuzzle4x4(List<Integer> estimates) {
        SIZE = (int) Math.sqrt(INITIAL_STATE.size());

    }

    public List<Tuple<List<Integer>, String>> execution(List<Integer> s) {
        int emptyCellPosition = -1;
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i) == 0) {
                emptyCellPosition = i;
                break;
            }
        }

        //Calculate column and row
        int r = emptyCellPosition / SIZE;
        int c = emptyCellPosition % SIZE;

        List<Tuple<List<Integer>, String>> newStates = new ArrayList<>();


        if (r > 0) {
            List<Integer> newState = new ArrayList<>(s);
            // Swap empty cell with the cell above it
            int newIndex = emptyCellPosition - SIZE;
            newState.set(emptyCellPosition, s.get(newIndex));
            newState.set(newIndex, 0);
            // Add new state and corresponding action to the list
            newStates.add(new Tuple<>(newState, "UP", 1));
        }

        //can we move the empty cell down?
        if (r < SIZE - 1) {
            List<Integer> newState = new ArrayList<>(s);
            // Swap empty cell with the cell below it
            int newIndex = emptyCellPosition + SIZE;
            newState.set(emptyCellPosition, s.get(newIndex));
            newState.set(newIndex, 0);
            // Add new state and corresponding action to the list
            newStates.add(new Tuple<>(newState, "DOWN", 1));
        }

        // Can we move the empty cell to the left?
        if (c > 0) {
            List<Integer> newState = new ArrayList<>(s);
            // Swap empty cell with the cell to the left of it
            int newIndex = emptyCellPosition - 1;
            newState.set(emptyCellPosition, s.get(newIndex));
            newState.set(newIndex, 0);
            // Add new state and corresponding action to the list
            newStates.add(new Tuple<>(newState, "LEFT", 1));
        }

        // Can we move the empty cell to the right?
        if (c < SIZE - 1) {
            List<Integer> newState = new ArrayList<>(s);
            // Swap empty cell with the cell to the right of it
            int newIndex = emptyCellPosition + 1;
            newState.set(emptyCellPosition, s.get(newIndex));
            newState.set(newIndex, 0);
            // Add new state and corresponding action to the list
            newStates.add(new Tuple<>(newState, "RIGHT", 1));
        }

        return newStates;
    }

    public List<Integer> initialSate() {
        return INITIAL_STATE;
    }

    @Override
    public List<Integer> initialState() {
        return initialSate();
    }

    public List<Integer> goalState() {
        return GOAL_STATE;
    }

    public void printState(List<Integer> state) {
        for (int i = 0; i < state.size(); i++) {
            if (state.get(i) != 0) {
                System.out.printf("%3s", state.get(i) + " ");
            } else {
                System.out.print("   ");
            }
            if (i % SIZE == SIZE - 1) {
                System.out.println();
            }
        }
    }

    public int misplacedTiles(List<Integer> s) {
        int count = 0;

        for (int i = 0; i < s.size(); i++) {
            if (s.get(i) == 0) {
                continue;
            } else {
                if (s.get(i) != GOAL_STATE.get(i)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int sumOfDistances(List<Integer> s) {
        int sum = 0;

        for (int i = 0; i < s.size(); i++) {
            int tile = s.get(i);
            if (tile != 0) { // Skip the blank tile
                int rowCurr = i / SIZE; // Current row of the tile
                int colCurr = i % SIZE; // Current column of the tile

                int rowGoal = tile / SIZE; // Goal row of the tile
                int colGoal = tile % SIZE; // Goal column of the tile

                int distance = Math.abs(rowCurr - rowGoal) + Math.abs(colCurr - colGoal);
                sum += distance;
            }
        }
        return sum;
    }
}
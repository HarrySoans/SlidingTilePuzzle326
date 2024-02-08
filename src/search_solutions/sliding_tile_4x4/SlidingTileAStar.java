package search_solutions.sliding_tile_4x4;

import core_search.BaseSearch;
import core_search.Node;
import core_search.SortedQueue;
import search_problems.SlidingTilePuzzle4x4;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SlidingTileAStar extends BaseSearch<List<Integer>, String> {

    public SlidingTileAStar(List<Integer> initialState) {
        super(new SlidingTilePuzzle4x4(initialState), new SortedQueue<>(new CompareSum()));
    }

    public static void main(String[] args) {
        List<Integer> initialState = new ArrayList<>(List.of(12,1,2,15,11,6,5,8,7,10,9,4,0,13,14,3));
        SlidingTileAStar agent = new SlidingTileAStar(initialState);
        agent.search();
    }

    public static class CompareSum implements Comparator<Node<List<Integer>, String>> {
        @Override
        public int compare(Node<List<Integer>, String> o1, Node<List<Integer>, String> o2) {
            int sumAndCost1 = o1.getPathCost() + heuristic(o1.getState());
            int sumAndCost2 = o2.getPathCost() + heuristic(o2.getState());

            return Integer.compare(sumAndCost1, sumAndCost2);
        }
    }

    private static int heuristic(List<Integer> state) {

        return new SlidingTilePuzzle4x4().sumOfDistances(state);
    }
}
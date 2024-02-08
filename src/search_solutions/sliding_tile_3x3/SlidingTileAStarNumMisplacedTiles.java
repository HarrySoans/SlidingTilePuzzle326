package search_solutions.sliding_tile_3x3;

import core_search.BaseSearch;
import core_search.Node;
import core_search.SortedQueue;
import search_problems.SlidingTilePuzzle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SlidingTileAStarNumMisplacedTiles extends BaseSearch<List<Integer>, String> {

    public SlidingTileAStarNumMisplacedTiles(List<Integer> initialState) {
        super(new SlidingTilePuzzle(initialState), new SortedQueue<>(new CompareSum()));
    }

    public static void main(String[] args) {
        List<Integer> initialState = new ArrayList<>(List.of(7, 2, 4, 5, 0, 6, 8, 3, 1));
        SlidingTileAStarNumMisplacedTiles agent = new SlidingTileAStarNumMisplacedTiles(initialState);
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

        return new SlidingTilePuzzle().misplacedTiles(state);
    }
}
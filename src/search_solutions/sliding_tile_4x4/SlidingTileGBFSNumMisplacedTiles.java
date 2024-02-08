package search_solutions.sliding_tile_4x4;

import core_search.BaseSearch;
import core_search.Node;
import core_search.SortedQueue;
import search_problems.SlidingTilePuzzle4x4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SlidingTileGBFSNumMisplacedTiles extends BaseSearch<List<Integer>, String> {

    public SlidingTileGBFSNumMisplacedTiles(List<Integer> initialState) {
        super(new SlidingTilePuzzle4x4(initialState), new SortedQueue<>(new CompareEstimates()));
    }

    public static void main(String[] args) {
        List<Integer> initialState = new ArrayList<>(List.of(12,1,2,15,11,6,5,8,7,10,9,4,0,13,14,3));
        SlidingTileGBFSNumMisplacedTiles agent = new SlidingTileGBFSNumMisplacedTiles(initialState);
        agent.search();
    }

    public static class CompareEstimates implements Comparator<Node<List<Integer>, String>> {
        @Override
        public int compare(Node<List<Integer>, String> o1, Node<List<Integer>, String> o2) {
            int estimate1 = heuristic(o1.getState());
            int estimate2 = heuristic(o2.getState());

            return Integer.compare(estimate1, estimate2);
        }
    }

    private static int heuristic(List<Integer> state) {

        return new SlidingTilePuzzle4x4().misplacedTiles(state);
    }
}


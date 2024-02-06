package search_solutions;

import core_search.BaseSearch;
import core_search.Node;
import core_search.SortedQueue;
import search_problems.SlidingTilePuzzle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SlidingTileGBFS extends BaseSearch<List<Integer>, String> {

    public SlidingTileGBFS(List<Integer> initialState) {
        super(new SlidingTilePuzzle(initialState), new SortedQueue<>(new CompareEstimates()));
    }

    public static void main(String[] args) {
        List<Integer> initialState = new ArrayList<>(List.of(7, 2, 4, 5, 0, 6, 8, 3, 1));
        SlidingTileGBFS agent = new SlidingTileGBFS(initialState);
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

        return new SlidingTilePuzzle().sumOfDistances(state);
    }
}


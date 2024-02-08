package search_solutions.sliding_tile_4x4;

import core_search.BaseSearch;
import core_search.FIFOQueue;
import search_problems.SlidingTilePuzzle4x4;

import java.util.List;

public class SlidingTileBFS extends BaseSearch<List<Integer>,String> {
    public SlidingTileBFS() {
        super(new SlidingTilePuzzle4x4(), new FIFOQueue<>());
    }


    public static void main(String[] args) {
        SlidingTileBFS t = new SlidingTileBFS();
        t.search();
    }
}


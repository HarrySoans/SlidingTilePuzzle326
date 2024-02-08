package search_solutions.sliding_tile_3x3;

import core_search.BaseSearch;
import core_search.LIFOQueue;
import search_problems.SlidingTilePuzzle;

import java.util.List;

public class SlidingTileDFS extends BaseSearch<List<Integer>, String> {
    public SlidingTileDFS (){
        super (new SlidingTilePuzzle(), new LIFOQueue<>());
    }

    public static void main(String[] args){
        SlidingTileDFS t = new SlidingTileDFS();
        t.search();
    }


}

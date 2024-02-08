package search_solutions.sliding_tile_4x4;

import core_search.BaseSearch;
import core_search.LIFOQueue;
import search_problems.SlidingTilePuzzle4x4;

import java.util.List;

public class SlidingTileDFS extends BaseSearch<List<Integer>, String> {
    public SlidingTileDFS (){
        super (new SlidingTilePuzzle4x4(), new LIFOQueue<>());
    }

    public static void main(String[] args){
        SlidingTileDFS t = new SlidingTileDFS();
        t.search();
    }


}

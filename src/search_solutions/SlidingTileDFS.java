package search_solutions;

import core_search.BaseSearch;
import core_search.LIFOQueue;
import search_problems.SlidingTilePuzzle;

public class SlidingTileDFS extends BaseSearch<String, String> {
    public SlidingTileDFS (){
        super (new SlidingTilePuzzle(), new LIFOQueue<>());
    }

    public static void main(String[] args){
        SlidingTileDFS t = new SlidingTileDFS();
        t.search();
    }


}

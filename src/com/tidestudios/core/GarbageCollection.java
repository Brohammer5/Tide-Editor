package com.tidestudios.core;

public class GarbageCollection {
    public Boolean collectGarbage;
    public GarbageCollection(Boolean collectGarbage){
        this.collectGarbage = collectGarbage;
    }
    public void CollectGarbage(){
        if(collectGarbage){
            System.gc();

        }
    }
}

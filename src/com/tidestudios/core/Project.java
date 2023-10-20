package com.tidestudios.core;

public class Project {
    /*
    1 - Lua
    2 - CPP
    3 - Python
     */
    public int LangType = 0;
    public static float [] backgroundColor = new float[10000];
    public String ProjectName;
    public Project(int Language, String ProjectName){
        this.LangType = Language;
        this.ProjectName = ProjectName;
    }

    public int getLangType() {
        return LangType;
    }
}

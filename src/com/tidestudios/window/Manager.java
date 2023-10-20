package com.tidestudios.window;

import com.tidestudios.lang.Processor;
import imgui.type.ImBoolean;

public class Manager {

    public void Run(){
        EditorWindow.show(new ImBoolean(true));
        ProjectWindow.show(new ImBoolean(true));
        ConsoleWindow.show(new ImBoolean(true));
    }
}

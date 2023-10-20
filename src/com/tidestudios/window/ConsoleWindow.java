package com.tidestudios.window;

import com.tidestudios.util.Logger;
import imgui.ImGui;
import imgui.type.ImBoolean;
import org.python.jline.internal.Log;

public class ConsoleWindow {
    public static void show(ImBoolean imBoolean){
        ImGui.begin("Console",imBoolean);

        for(int i=0;i<Logger.consoleLogged;i++){
            if(Logger.previousLogsType.get(i) == "TRACE"){
                ImGui.text(Logger.previousLogs.get(i).toString());
            }else if(Logger.previousLogsType.get(i) == "DEBUG"){
                ImGui.textColored(0,82,22,255,Logger.previousLogs.get(i).toString());
            }


        }
        ImGui.end();
    }
}

package com.tidestudios.window;

import com.tidestudios.lang.Processor;
import com.tidestudios.util.Logger;
import imgui.ImGui;
import imgui.type.ImBoolean;
import imgui.type.ImString;
import org.python.jline.internal.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleWindow {
    public static void show(ImBoolean imBoolean){
        ImGui.begin("Console",imBoolean);
        if(ImGui.button("Clear")){
            Logger.previousLogs.clear();
            Logger.previousLogsType.clear();
            Logger.consoleLogged=0;
        }
        ImString input = new ImString();
       // if(ImGui.inputText("Command Line",input)){
        if(ImGui.button("Test")) {
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "echo hello");
            builder.redirectErrorStream(true);
            Process p = null;
            try {
                p = builder.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Logger logger = new Logger("Command Line");
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while (true) {
                try {
                    line = r.readLine();

                } catch (IOException e) {
                    e.printStackTrace();
                    logger.consoleLog(e.getMessage(),4);
                }
                if (line == null) { break; }
                logger.consoleLog(line,1);
            }
        }

      //  }
        ImGui.separator();
        if(Logger.previousLogs.size() >=1 && Logger.previousLogsType.size() >= 1){
            for(int i=0;i<Logger.consoleLogged;i++){
                if(Logger.previousLogsType.get(i) == "TRACE"){
                    ImGui.text(Logger.previousLogs.get(i).toString());
                    ImGui.separator();
                }else if(Logger.previousLogsType.get(i) == "DEBUG"){
                    ImGui.textColored(0,82,22,255,Logger.previousLogs.get(i).toString());
                    ImGui.separator();
                }


            }
        }

        ImGui.end();
    }
}

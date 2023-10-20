package com.tidestudios.util;


import java.util.ArrayList;
import java.util.Map;

public class Logger {

    public static ArrayList previousLogs = new ArrayList();
    public static ArrayList previousLogsType = new ArrayList();
    public static int consoleLogged = 0;
    public static int logs;
    public String name;

    public Time time = new Time();
    /*Types
    1 = Trace
    2 = Debug
    3 = Info
    4 = Error
    5 = Fatal
    */
    public Logger(String name){
        this.name = name;
    }

    public void consoleLog(String content, int type){

        if(type == 1){
            previousLogs.add(content);
            previousLogsType.add("TRACE");
        }
        if(type == 2){
            previousLogs.add(content);
            previousLogsType.add("DEBUG");

        }
        consoleLogged++;

    }

    public void log(String content, int type){

        if(type ==  1){
            System.out.println(LoggerColors.WHITE+"["+name+"] "+"[TRACE] "+content+LoggerColors.RESET);
        }
        if(type == 2){
            System.out.println(LoggerColors.GREEN+"["+name+"] "+"[DEBUG] "+content+LoggerColors.RESET);
        }
        if(type == 3){
            System.out.println(LoggerColors.BLUE+"["+name+"]"+" [INFO] "+content+LoggerColors.RESET);
        }
        if(type == 4){
            System.out.println(LoggerColors.RED+"["+name+"]"+" [ERROR] "+content+LoggerColors.RESET);
        }
        if(type == 5){
            System.out.println(LoggerColors.RED+LoggerColors.RED_BACKGROUND+"["+name+"] "+"[FATAL] "+content+LoggerColors.RESET);
        }
    }
}

package com.tidestudios.lang;

import com.tidestudios.core.GarbageCollection;
import com.tidestudios.util.Logger;
import com.tidestudios.window.EditorWindow;
import imgui.ImGui;
import imgui.extension.texteditor.TextEditor;
import org.luaj.vm2.Globals;
import org.luaj.vm2.Lua;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.ast.Exp;
import org.luaj.vm2.ast.Str;
import org.luaj.vm2.lib.jse.JsePlatform;
import org.python.antlr.PythonErrorNode;
import org.python.core.Console;
import org.python.core.PythonCompiler;
import org.python.util.PythonInterpreter;

public class Processor {
    public String type;
    public float CurrentProgess = 0;
    public String content;
    public Logger logger = new Logger("Processor");
    public GarbageCollection garbageCollection;
    public Processor(String type, Boolean gc, String content){
        this.type = type;
        this.content = content;
        this.garbageCollection = new GarbageCollection(gc);
    }
    public void Compile(){
        if(type == "Lua"){
            Globals globals = JsePlatform.standardGlobals();
            LuaValue chunk = globals.load(content);
            chunk.call();
            garbageCollection.CollectGarbage();


        }
        if(type == "Python"){
            try(PythonInterpreter pythonInterpreter = new PythonInterpreter()){
                pythonInterpreter.exec(content);
            }catch(Throwable e){
                logger.log(e.getMessage(),4);
                logger.consoleLog(e.getMessage(),2);
            }
        }
    }
}

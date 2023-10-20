package com.tidestudios.window;

import com.tidestudios.core.Project;
import com.tidestudios.lang.Processor;
import imgui.ImGui;
import imgui.type.ImBoolean;

import java.util.concurrent.TimeUnit;

public class ProjectWindow {

    public static void show(ImBoolean imBoolean) {
        ImGui.begin("Project",imBoolean);
        ImGui.colorEdit4("Background Color",Project.backgroundColor);
        ImGui.showDemoWindow();


        ImGui.end();
    }
}

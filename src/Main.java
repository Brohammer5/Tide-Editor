import com.tidestudios.core.Project;
import com.tidestudios.window.Manager;
import com.tidestudios.window.ProjectWindow;
import imgui.app.Application;
import imgui.app.Configuration;

public class Main extends Application {

    public static void main(String args[]){

        launch(new Main());


    }
    @Override
    public void process() {
       Manager manager = new Manager();
       manager.Run();
       Project project = new Project(1,"Test");
       colorBg.set(Project.backgroundColor);
    }

    @Override
    protected void configure(Configuration config) {

        config.setTitle("Tide Editor");
        super.configure(config);
    }
}

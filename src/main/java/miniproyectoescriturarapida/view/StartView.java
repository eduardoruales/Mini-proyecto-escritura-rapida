package miniproyectoescriturarapida.view;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class StartView extends Stage{
    public StartView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass(). getResource("/miniproyectoescriturarapida/view/start-view.fxml"));
        Scene scene = new Scene(loader.load());
        this.setScene(scene);
        this.setTitle("Escritura Rápida");
    }
}

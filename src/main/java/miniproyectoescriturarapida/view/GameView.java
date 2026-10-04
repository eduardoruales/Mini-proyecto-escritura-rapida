package miniproyectoescriturarapida.view;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class GameView extends Stage{
    public GameView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass(). getResource("/miniproyectoescriturarapida/view/game-view.fxml"));
        Scene scene = new Scene(loader.load());
        this.setScene(scene);
        this.setTitle("Escritura Rápida");
    }
}

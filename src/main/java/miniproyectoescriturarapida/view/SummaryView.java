package miniproyectoescriturarapida.view;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SummaryView extends Stage{
    public SummaryView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass(). getResource("/miniproyectoescriturarapida/view/summary-view.fxml"));
        Scene scene = new Scene(loader.load());
        this.setScene(scene);
        this.setTitle("Escritura Rápida");
    }
}

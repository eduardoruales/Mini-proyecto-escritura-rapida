package miniproyectoescriturarapida.view;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class InstructionsView extends Stage{
    public InstructionsView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass(). getResource("/miniproyectoescriturarapida/view/instructions-view.fxml"));
        Scene scene = new Scene(loader.load());
        this.setTitle("Instrucciones");
        this.initModality(Modality.APPLICATION_MODAL);
        this.setScene(scene);
    }
}

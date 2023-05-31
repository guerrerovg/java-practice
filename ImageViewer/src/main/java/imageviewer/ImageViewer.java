package imageviewer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.JFileChooser;

public class ImageViewer extends Application {

    private final int WIDTH = 300;
    private final int HEIGHT = 400;

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        pane.setPrefSize(WIDTH, HEIGHT);

        Label imgLabel = new Label();

        Menu file = new Menu("File");
        MenuItem open = new MenuItem("Open");
        MenuItem exit = new MenuItem("Exit");

        file.getItems().add(open);
        file.getItems().add(exit);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(file);

        pane.setTop(menuBar);
        pane.setCenter(imgLabel);

        open.setOnAction(event -> {
            String imgPath = openFile();
            if (imgPath == null) {
                return;
            }

            Image img = new Image(imgPath);
            ImageView imgView = new ImageView(img);
            imgView.setFitWidth(WIDTH);
            imgView.setFitHeight(HEIGHT);
            imgView.setPreserveRatio(true);

            imgLabel.setGraphic(imgView);
        });
        exit.setOnAction(event -> stage.close());

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("ImageViewer");
        stage.show();
    }

    private String openFile() {
        JFileChooser chooser = new JFileChooser(".");
        String path = "";
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            path = chooser.getSelectedFile().getPath();
        } else {
            return null;
        }

        return path;
    }
}

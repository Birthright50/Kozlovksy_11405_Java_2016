package controllers;

import entity.Information;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import org.jsoup.Jsoup;

/**
 * Created by birthright on 27.05.16.
 */
public class InformationController {


    public AnchorPane information;
    public TitledPane titlePane;
    public TextArea textArea;

    @FXML
    public void initialize() {

    }

    public void initData(Information information) {
        titlePane.setText(information.getName());
        textArea.setText(Jsoup.parse(information.getPageText()).text() + "\n" + information.getfDate());
        textArea.setMaxWidth(700);
    }
}

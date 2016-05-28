package controllers;

import entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.apache.commons.codec.binary.Base64;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static controllers.LoginRegController.user;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static sample.Constants.*;

/**
 * Created by birthright on 27.05.16.
 */
public class MainController {
    public ListView<String> listview;
    public ListView<String> news;
    public AnchorPane main;
    public TabPane tabs;
    public DatePicker time;
    public TextArea text;
    public TextField auot;
    public TextField telephone;
    public TextField name;
    public Button send;
    public TextField ed_lastname;
    public TextField ed_name;
    public TextField ed_second_name;
    public TextField ed_telephone;
    public TextField ed_auto;
    public TextField ed_email;
    public PasswordField ed_old;
    public PasswordField ed_new;
    public PasswordField ed_new_p;
    public Button ed_go;
    public Label success;
    public Label ok;
    public TextArea info;
    public TableView table;
    public TableColumn id;
    public TableColumn vid;
    public TableColumn status;
    public TableColumn data;
    public TableColumn response;
    public TableColumn sum;
    private Client client;
    private List<Information> informations;
    private Users users;

    @FXML
    public void initialize() {

        client = ClientBuilder.newClient();
        List<String> stringList = Arrays.asList(NEWS, ARTICLES, SPEC);
        listview.setBackground(Background.EMPTY);
        listview.setItems(FXCollections.observableArrayList(stringList));
        Response response = client.target(TARGET_URL).path("/personal_cabinet/get").request().header("Authorization", "Basic " + user).accept(APPLICATION_JSON).get();
        users = response.readEntity(Users.class);
        name.setText(users.getName() + " " + users.getLastname());
        auot.setText(users.getAutomobile());
        telephone.setText(users.getTelephone());

    }

    @FXML
    public void handleMouseClick() {
        Response response = client.target(TARGET_URL).path("/information/get").queryParam("type", listview.getSelectionModel().getSelectedIndex() + 1).request(APPLICATION_JSON).get();
        ListInfo information = response.readEntity(ListInfo.class);
        informations = information.getInformationList();
        List<String> strings = informations.stream().map(information1 -> information1.getName() + "\n" + information1.getPreviewText() + "\n" + information1.getfDate()).collect(Collectors.toList());
        news.setItems(FXCollections.observableArrayList(strings));
    }

    @FXML
    public void newsClick() throws IOException {
        Information information = informations.get(news.getSelectionModel().getSelectedIndex());
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/information.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle(information.getName());
        stage.setScene(new Scene(root));
        InformationController controller = loader.getController();
        controller.initData(information);
        stage.show();
    }

    public void tab_click() {
        switch (tabs.getSelectionModel().getSelectedIndex()) {
            case 0:
                initClaim();
                break;
            case 1:
                initProfile();
                break;
            case 2:
                break;
            case 3:
                initInfo();
                break;
            case 4:
                init();
                break;

        }

    }

    private void init() {
        Response response = client.target(TARGET_URL).path("/personal_cabinet/get_claims").request().header("Authorization", "Basic " + user).accept(APPLICATION_JSON).get();
        ClaimsList list = response.readEntity(ClaimsList.class);
        ObservableList<Claim> claims = FXCollections.observableArrayList(list.getClaimList());
        id.setCellValueFactory(new PropertyValueFactory<Claim, Long>("id"));
        vid.setCellValueFactory(new PropertyValueFactory<Claim, String>("reason"));
        status.setCellValueFactory(new PropertyValueFactory<Claim, String>("status"));
        this.response.setCellValueFactory(new PropertyValueFactory<Claim, String>("response"));
        sum.setCellValueFactory(new PropertyValueFactory<Claim, String>("sum"));
        data.setCellValueFactory(new PropertyValueFactory<Claim, Timestamp>("fDate"));
        table.setItems(claims);
    }

    private void initInfo() {
        Response response = client.target(TARGET_URL).path("/info").request().get();
        String inf = response.readEntity(String.class);
        info.setText(inf);

    }

    private void initClaim() {
        Response response = client.target(TARGET_URL).path("/personal_cabinet/get").request().header("Authorization", "Basic " + user).accept(APPLICATION_JSON).get();
        users = response.readEntity(Users.class);
        name.setText(users.getName() + " " + users.getLastname());
        telephone.setText(users.getTelephone());
        auot.setText(users.getAutomobile());
    }

    private void initProfile() {
        success.setText("");
        Response response = client.target(TARGET_URL).path("/personal_cabinet/get").request().header("Authorization", "Basic " + user).accept(APPLICATION_JSON).get();
        users = response.readEntity(Users.class);
        ed_name.setText(users.getName());
        ed_lastname.setText(users.getLastname());
        ed_email.setText(users.getEmail());
        String s;
        if (((s = users.getSecondName()) != null) && s.length() != 0) ed_second_name.setText(s);
        if (((s = users.getAutomobile()) != null) && s.length() != 0) ed_auto.setText(s);
        if (((s = users.getTelephone()) != null) && s.length() != 0) ed_telephone.setText(s);

    }

    public void setUser() {
        if (ed_lastname.getLength() == 0 || ed_name.getLength() == 0) {
            success.setTextFill(Color.RED);
            success.setText("Заполните нужные поля");
            return;
        }
        boolean check = false;
        if (ed_old.getText().length() != 0) {
            if (Objects.equals(ed_new.getText(), ed_new_p.getText()) && ed_new.getText().length() > 5) {
                check = true;
            } else {
                success.setTextFill(Color.RED);
                success.setText("Неверное подтверждение/пароли меньше 6 символов");
                return;
            }
        } else {
            if (ed_new.getText().length() != 0 || ed_new_p.getText().length() != 0) {
                success.setTextFill(Color.RED);
                success.setText("Введите старый пароль");
                return;
            }
        }
        if (check || ed_old.getText().length() == 0) {
            System.out.println("Отправляем");
            MultivaluedMap<String, String> multivaluedMap = new MultivaluedHashMap<>();
            multivaluedMap.add("NAME", ed_name.getText());
            multivaluedMap.add("LAST_NAME", ed_lastname.getText());
            multivaluedMap.add("SECOND_NAME", ed_second_name.getText());
            multivaluedMap.add("PERSONAL_PHONE", ed_telephone.getText());
            multivaluedMap.add("OLD_PASSWORD", ed_old.getText());
            multivaluedMap.add("NEW_PASSWORD", ed_new.getText());
            multivaluedMap.add("AUTO", ed_auto.getText());
            Response response = client.target(TARGET_URL).path("/personal_cabinet/configuration/set").request().header("Authorization", "Basic " + user).accept(APPLICATION_JSON).post(Entity.form(multivaluedMap));
            users = response.readEntity(Users.class);
            if (users == null) {
                success.setTextFill(Color.RED);
                success.setText("Неверный старый пас");
            } else {
                if (ed_old.getText().length() != 0) {
                    String authorization = users.getEmail() + ":" + ed_new.getText();
                    System.out.println(authorization);
                    user = new String(Base64.encodeBase64(authorization.getBytes(Charset.forName("US-ASCII"))));
                }
                success.setTextFill(Color.GREEN);
                success.setText("Успешно");
            }
        }
    }

    public void sendClaim(ActionEvent actionEvent) {
        if (auot.getText().length() != 0 && telephone.getText().length() != 0 && text.getText().length() > 15 && time.getValue() != null) {
            MultivaluedMap<String, String> multivaluedMap = new MultivaluedHashMap<>();
            multivaluedMap.add("DESIRE_DATE", time.getValue().atTime(15, 0).toString());
            multivaluedMap.add("REASON", text.getText());
            client.target(TARGET_URL).path("/personal_cabinet/claim").request().header("Authorization", "Basic " + user).accept(APPLICATION_JSON).post(Entity.form(multivaluedMap));
            ok.setTextFill(Color.GREEN);
            ok.setText("Успешно");
        } else {
            ok.setTextFill(Color.RED);
            ok.setText("Что-то не заполнено");
        }
    }
}

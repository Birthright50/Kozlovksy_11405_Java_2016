package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.apache.commons.codec.binary.Base64;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.nio.charset.Charset;

import static sample.Constants.TARGET_URL;

/**
 * Created by birthright on 27.05.16.
 */
public class LoginRegController {

    public Button button;
    public Label label;
    public TextField email;
    public PasswordField password;
    public TextField reg_email;
    public PasswordField reg_pwd;
    public PasswordField reg_p_pwd;
    public TextField name;
    public TextField lastname;
    private static Client client;
    public static String user;
    static {
        client = ClientBuilder.newClient();
    }

    public Label error;
    public AnchorPane archor;

    public void login() throws IOException {
        String email = this.email.getText();
        String password = this.password.getText();
        String authorization = email + ":" + password;
        user = new String(Base64.encodeBase64(authorization.getBytes(Charset.forName("US-ASCII"))));

        javax.ws.rs.core.Response response = client.target(TARGET_URL).request().header("Authorization", "Basic " + user).accept(MediaType.APPLICATION_JSON).get();
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            Stage stage = (Stage) archor.getScene().getWindow();
            stage.close();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/main.fxml"));
            Parent root =  loader.load();
            stage.setTitle("Auto Service");
            stage.setScene(new Scene(root));
            stage.show();
        } else {
            label.setText("Неверный логин или пароль");
            label.setTextFill(Color.RED);
        }
    }

    public void reg() {

        String email = reg_email.getText();
        String password = reg_pwd.getText();
        String password_p = reg_p_pwd.getText();
        String name = this.name.getText();
        String lastname = this.lastname.getText();
        boolean check = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException e) {
            check = false;
        }
        if (!check) {
            error.setText("Невалидный email");
            return;
        }
        if (password.length() < 6) {
            error.setText("Пароль меньше 6 символов");
            return;
        }
        if (!password.equals(password_p)) {
            error.setText("Пароли не совпадают");
            return;
        }
        if (name.length() < 3 || lastname.length() < 3) {
            error.setText("Введите имя/фамилию");
            return;
        }
        Response response = client.target(TARGET_URL).path("/check_email").queryParam("email", email).request().get();
        sample.Response an = response.readEntity(sample.Response.class);
        if (an.getText() == null) {
            error.setText("Данный email занят");
            return;
        }
        MultivaluedMap<String, String> formData = new MultivaluedHashMap<>();
        formData.add("email", email);
        formData.add("password", password);
        formData.add("name", name);
        formData.add("lastname", lastname);
        client.target(TARGET_URL).path("/registration").request().post(Entity.form(formData));
        error.setTextFill(Color.GREEN);
        error.setText("Регистрация успешна");

    }
}

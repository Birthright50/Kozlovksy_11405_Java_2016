package sample;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public Label email;
    @FXML
    public Label password;
    @FXML
    public Button button;

    public void login() {

    }

    public static void main(String[] args) throws IOException {

        Client client = ClientBuilder.newClient();
        MultivaluedMap<String, String> formData = new MultivaluedHashMap<>();
        MultivaluedMap<String, String> formData1 = new MultivaluedHashMap<>();
        formData.add("email", "los@mail.ru");
        formData.add("password", "jpo5w1");
        formData.add("name", "qyqy");
        formData.add("lastname", "qyqyqy");
        formData1.add("email", "birthright5050@gmail.com");
        Response response1 = client.target("http://localhost:8080/check_email").queryParam("email", "birthright5050@gmail.com").request().accept(MediaType.APPLICATION_JSON).get();
        System.out.println(response1.readEntity(String.class));

//        String authorization = "serendipity@mail.ru" + ":" + "h27dgfhasq4";
//        String basic = new String(Base64.encodeBase64(authorization.getBytes(Charset.forName("US-ASCII"))));
//        Response response = client.target("http://localhost:8080/personal_cabinet/get").request().header("Authorization", "Basic " + basic).accept(MediaType.APPLICATION_JSON).get();
//
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        System.out.println(objectMapper.readValue(response.readEntity(String.class), Users.class));
//        // System.out.println(client.target("http://localhost:8080/personal_cabinet/").request().header("Authorization", "Basic " + basic).accept(MediaType.APPLICATION_JSON).get(String.class));

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

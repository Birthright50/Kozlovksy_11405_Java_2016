package sample;

/**
 * Created by Birthright on 01.05.2016.
 */
public class Response {
    private String text;

    public Response() {
    }

    public Response(String text) {

        this.text = text;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}


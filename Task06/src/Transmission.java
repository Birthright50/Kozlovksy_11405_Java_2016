/**
 * Created by Peter on 08.02.2016.
 */
public interface Transmission {
    void upshift(byte toWhatExtent);
    void downshift(byte toWhatExtent);
    void reverseGear();
}

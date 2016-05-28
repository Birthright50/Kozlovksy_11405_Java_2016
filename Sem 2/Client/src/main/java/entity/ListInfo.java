package entity;

import java.util.List;

/**
 * Created by birthright on 27.05.16.
 */
public class ListInfo {
    private List<Information> informationList;

    public ListInfo(List<Information> informationList) {
        this.informationList = informationList;
    }

    public List<Information> getInformationList() {

        return informationList;
    }

    public ListInfo() {
    }

    public void setInformationList(List<Information> informationList) {
        this.informationList = informationList;
    }
}

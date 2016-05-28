package com.birthright.helpers;

import com.birthright.entity.Information;

import java.io.Serializable;
import java.util.List;

/**
 * Created by birthright on 27.05.16.
 */
public class ListInfo implements Serializable {
    private List<Information> informationList;

    public ListInfo() {
    }

    public ListInfo(List<Information> informationList) {
        this.informationList = informationList;
    }

    public List<Information> getInformationList() {

        return informationList;
    }

    public void setInformationList(List<Information> informationList) {
        this.informationList = informationList;
    }
}

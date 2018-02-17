/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 17 Feb 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/Jackson-Test/
 **/
package com;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class PendingChallanList {

    @JsonProperty("PENDING_CHALLANS")
    private List<PendingChallan> pendingChallanList = new ArrayList<PendingChallan>();

    public List<PendingChallan> getPendingChallanList() {
        return pendingChallanList;
    }

    public void setPendingChallanList(List<PendingChallan> pendingChallanList) {
        this.pendingChallanList = pendingChallanList;
    }

    @Override
    public String toString() {
        return "PendingChallanList{" +
                "pendingChallanList=" + pendingChallanList +
                '}';
    }

}

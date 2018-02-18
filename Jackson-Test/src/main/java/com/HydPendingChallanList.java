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


public class HydPendingChallanList {

    @JsonProperty("PENDING_CHALLANS")
    private List<HydPendingChallan> hydPendingChallanList = new ArrayList<HydPendingChallan>();

    public List<HydPendingChallan> getHydPendingChallanList() {
        return hydPendingChallanList;
    }

    public void setHydPendingChallanList(List<HydPendingChallan> hydPendingChallanList) {
        this.hydPendingChallanList = hydPendingChallanList;
    }

    @Override
    public String toString() {
        return "HydPendingChallanList{" +
                "hydPendingChallanList=" + hydPendingChallanList +
                '}';
    }

}

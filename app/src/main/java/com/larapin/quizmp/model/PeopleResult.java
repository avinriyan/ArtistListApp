package com.larapin.quizmp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Avin on 06/06/2018.
 *
 */

public class PeopleResult {
    @SerializedName("results")
    @Expose
    private List<People> peoples = null;

    public List<People> getPeoples() {
        return peoples;
    }

}

package com.larapin.quizmp.network;

import com.larapin.quizmp.model.PeopleResult;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Avin on 06/06/2018.
 *
 */

public interface PeopleService {
    @GET("person/popular?api_key=f73858c31df1e31d864b861e357f66d7&language=en-US&page=1")
    Call<PeopleResult> getPeople();

}
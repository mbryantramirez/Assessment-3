package org.pursuit.unit_03_assessment.Network;

import org.pursuit.unit_03_assessment.Model.ArrayList_Planets;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service_Planet {


    @GET("JDVila/storybook/master/planets.json")
    Call<ArrayList_Planets> getPlanet();
}

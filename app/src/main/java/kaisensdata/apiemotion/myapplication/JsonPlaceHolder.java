package kaisensdata.apiemotion.myapplication;

import kaisensdata.apiemotion.myapplication.Request;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface JsonPlaceHolder {

    @POST("fr/")
    Call<Reponse> submit(@Body Request request);
}


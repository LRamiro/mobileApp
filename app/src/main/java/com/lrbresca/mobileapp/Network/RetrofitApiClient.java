package com.lrbresca.mobileapp.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApiClient {

    public static final String BASE_URL = "https://api.mercadolibre.com/";
    private static Retrofit retrofit = null;
    //public static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w200/";
    //public static final String BACKDROP_BASE_URL = "https://image.tmdb.org/t/p/w780/";
     /**
     * This method returns retrofit client instance
     *
     * @return Retrofit object
     */
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

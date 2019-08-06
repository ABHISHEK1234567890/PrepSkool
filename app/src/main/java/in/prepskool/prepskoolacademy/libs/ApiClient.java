package in.prepskool.prepskoolacademy.libs;


import in.prepskool.prepskoolacademy.interfaces.ApiInterface;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;
    private static ApiInterface apiInterface;
    private static ApiClient apiClient;

    private ApiClient(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel( HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://prepskool.in/app/public/api/")
                .addConverterFactory( GsonConverterFactory.create())
                .client(client)
                .build();

        apiInterface = retrofit.create( ApiInterface.class );

    }

    static ApiClient getInstance() {

        if (apiClient == null) {
            apiClient = new ApiClient();
        }
        return apiClient;
    }


}
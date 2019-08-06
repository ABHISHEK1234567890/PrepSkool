package in.prepskool.prepskoolacademy.libs;


import android.app.Application;

public class MyRetrofitSingleton extends Application {

    public static ApiClient apiClient;

    @Override
    public void onCreate() {
        super.onCreate();
        apiClient = ApiClient.getInstance();
    }
}
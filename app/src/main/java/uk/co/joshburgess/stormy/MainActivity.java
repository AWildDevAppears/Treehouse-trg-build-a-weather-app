package uk.co.joshburgess.stormy;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final String API_KEY = "8088206ec0e9762b47d101ba8ccc6124";
    private static final String TAG = MainActivity.class.getSimpleName();
    private double lati = 37.8267;
    private double longi = -122.423;

    private OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String forecastURL = "https://api.forecast.io/forecast/" + API_KEY + "/" + lati + "," + longi;

        client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(forecastURL)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    if (response.isSuccessful()) {
                    }
                } catch (IOException e) {
                    alertUserOfError();
                }
            }
        });
    }

    private void alertUserOfError() {
        AlertDialogFragment dialog = new AlertDialogFragment();

        dialog.show(getFragmentManager(), "error_dialog");
    }
}

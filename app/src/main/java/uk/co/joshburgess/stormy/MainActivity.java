package uk.co.joshburgess.stormy;

import android.app.DownloadManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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
    private String forecastURL = "https://api.forecast.io/forecast/" + API_KEY + "/" + lati + "," + longi;


    private OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isNetworkAvaiable()) {
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
                        Log.v(TAG, response.body().string());
                        if (response.isSuccessful()) {
                        } else {
                            alertUserOfError();
                        }
                    } catch (IOException e) {
                        Log.e(TAG, "Error: ", e);
                    }
                }
            });
        } else {
            Toast.makeText(this, getString(R.string.network_unavailable_text), Toast.LENGTH_LONG).show();
        }
    }

    private boolean isNetworkAvaiable() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        return (networkInfo != null && networkInfo.isConnected());
    }

    private void alertUserOfError() {
        AlertDialogFragment dialog = new AlertDialogFragment();

        dialog.show(getFragmentManager(), "error_dialog");
    }
}

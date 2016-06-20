package se.liu.student.frejo105.beerapp.activities;

import android.os.Bundle;

import cz.msebera.android.httpclient.client.HttpResponseException;
import se.liu.student.frejo105.beerapp.api.HttpCallback;
import se.liu.student.frejo105.beerapp.api.HttpClient;
import se.liu.student.frejo105.beerapp.api.model.Point;
import se.liu.student.frejo105.beerapp.api.model.Pub;
import se.liu.student.frejo105.beerapp.R;

public class MainActivity extends DrawerMenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Point p = new Point();
        p.latitude = 55.41125954;
        p.longitude = 15.60224700000;
        HttpClient.getClosest(p, new HttpCallback<Pub>() {

            @Override
            public void onSuccess(Pub result) {
                System.out.println(result.name);
            }

            @Override
            public void onFailure(HttpResponseException hre) {
                System.out.println(hre.getMessage());
            }
        });
    }
}

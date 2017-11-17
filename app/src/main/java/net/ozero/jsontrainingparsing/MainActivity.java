package net.ozero.jsontrainingparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    String JSON_STRING = "{\"employee\":{\"name\":\"Abhishek Saini\",\"salary\":65000}}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public String loadJSONFrommAsset() {
        String json = null;
        try {
            InputStream inputStream = getAssets().open();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }
}

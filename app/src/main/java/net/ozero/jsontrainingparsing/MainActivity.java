package net.ozero.jsontrainingparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            ListView listView = findViewById(R.id.list_view);
            List<String> items = new ArrayList<>();
            JSONArray root = new JSONArray(loadJSONFrommAsset("arraylist.json"));

            JSONObject rootTitle = new JSONObject(loadJSONFrommAsset("list.json"));
            setTitle(rootTitle.getString("title"));
//            JSONArray jsonArray = root.getJSONArray("array");
//
//
//
            for (int i = 0; i < root.length(); i++) {
                items.add(root.getJSONObject(i).getString("company"));
            }
//
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

            if (listView != null) {
                listView.setAdapter(adapter);
            }
//
//
//
//            JSONObject nested = root.getJSONObject("nested");
//            Log.d("TAG","flag value " + nested.getBoolean("flag"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFrommAsset(String fileName) {
        String json = null;
        try {
            InputStream inputStream = getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return json;
    }
}

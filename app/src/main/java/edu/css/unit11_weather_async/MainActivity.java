package edu.css.unit11_weather_async;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText etLoc;
    EditText etTemp;
    EditText etWind;
    EditText etVis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set up our edit text variables
        etLoc =  (EditText) findViewById(R.id.textLoc);
        etTemp =  (EditText) findViewById(R.id.textTemp);
        etWind =  (EditText) findViewById(R.id.textWind);
        etVis =  (EditText) findViewById(R.id.textVis);
    }

    public void btnClick (View v) throws XmlPullParserException, URISyntaxException, IOException {

        URL weatherURL =  new URL("http://w1.weather.gov/xml/current_obs/KDLH.xml");
        String  weatherStrURL =  "http://w1.weather.gov/xml/current_obs/KDLH.xml";

        // AsyncTask subclass
        //new AsyncDownloadXML().execute(weatherStrURL);
        new AsyncDownloadXML().execute(this);

    }

    public void setTemp(String newTemp) {
        etTemp.setText(newTemp);
    }

    public void setWind(String newWind) {
        etWind.setText(newWind);
    }


    public void setStatus(String newStatus) {
        Toast toast=Toast.makeText(getApplicationContext(), newStatus,Toast.LENGTH_LONG );
        toast.show();
    }

}
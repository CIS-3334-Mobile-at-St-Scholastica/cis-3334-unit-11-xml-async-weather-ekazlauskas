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

/**
 * runs commands when the application is run and when the user pushes the button
 * Sets text to string that was given from the second class. 
 */
public class MainActivity extends AppCompatActivity {
    EditText etLoc;
    EditText etTemp;
    EditText etWind;
    EditText etVis;

    AsyncDownloadXML AsyncWeatherDownloader = new AsyncDownloadXML();

    /**
     * OnCreate creates an instance where it enables text variables
     * for the following application
     * @param savedInstanceState
     */
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

    /**
     * btnClick, when the button is pressed, the application looks for errors within the
     * application and notifies the user. Certain errors include: XMLPullParser, URISyntax
     * and the IO methods. Executes the second java class fo the application, which gathers the
     * current temperature of the city the user entered. The class also sends a snackbar notification
     * to the user when the temperature is successfully added to the main application.
     * @param v
     * @throws XmlPullParserException
     * @throws URISyntaxException
     * @throws IOException
     */
    public void btnClick (View v) throws XmlPullParserException, URISyntaxException, IOException {
        // Download the weather asynchronously
        AsyncWeatherDownloader.execute(this);
    }

    /**
     * setTemp enables the application to set the temperature of the city
     * the user entered within the application. The temperature was already set to the string "uppdating"
     * by the second activity when the button was clicked.
     * @param newTemp
     */
    public void setTemp(String newTemp) {
        etTemp.setText(newTemp);
    }

    /**
     * setWind, enables the application to set the current wind speed of the city the
     * user entered within the application. The wind speed was already set tot he string "updating"
     * by the second activity when the button was clicked.
     * @param newWind
     */
    public void setWind(String newWind) {
        etWind.setText(newWind);
    }

    /**
     * getLocation, gets the location of the city (zip code) that the user entered within the
     * application and returns it as a string value.
     * @return
     */
    public String getLocation() {
        return etLoc.getText().toString();
    }

    /**
     * setStatus, creates a toast message for the user when they enter in a city within the application.
     * This message could display "successfully updated weather, successfully updated wind, etc.).
     * @param newStatus
     */
    public void setStatus(String newStatus) {
        Toast toast=Toast.makeText(getApplicationContext(), newStatus,Toast.LENGTH_LONG );
        toast.show();
    }

}

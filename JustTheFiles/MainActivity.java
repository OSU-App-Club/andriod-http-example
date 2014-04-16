package com.uphouseworks.android_http_example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text_view1);
        //Find our button and set a listener to it
        button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    /**
     * ReadJson now calls to an Async process, keeps the main thread free!
     * We listen for the reply to our request through the onResponseReceived callback
     * When the asynctask is done this will be called, and we will see the results on screen!
     * @param url --Target url where our json will be coming from
     */
    public void retrieveAndShowJson(String url) {
        if(url != null)
        {
            RetrieveJson rt = new RetrieveJson()
            {
                @Override
                public void onResponseReceived(String result)
                {
                    textView.setText(result);
                    button.setText("Get your Data");
                }
            };
            button.setText("working...");
            rt.execute(url);
        }
    }

    @Override
    public void onClick(View v){
        //Find our Input (edit text) and double check for a null case
        EditText editText = (EditText) findViewById(R.id.edit_text1);
        if(editText.getText() != null)
        {
            //Alright! it's good! Now let's get the input
            String ourURL = editText.getText().toString();
            //Send our url to to our Async Process and set our text view to the result
            retrieveAndShowJson(ourURL);
        }
    }
}

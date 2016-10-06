package com.mlabs.bbm.firstandroidapp_morningclass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by AL on 8/4/2016.
 */
public class NextScreen extends Activity {
   @Override
    protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.next_screen);

       Button ontouch = (Button) findViewById(R.id.OnTouch);

       ontouch.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {
               Intent i = new Intent(NextScreen.this, OnTouch.class);
               startActivity(i);
           }

       });

   }
    protected void onPause() {
        super.onPause();
        finish();
    }



}

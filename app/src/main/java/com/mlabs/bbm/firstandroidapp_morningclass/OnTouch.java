package com.mlabs.bbm.firstandroidapp_morningclass;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by THEL on 10/6/2016.
 */
public class OnTouch extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.on_touch);

        ImageView image = (ImageView) findViewById(R.id.splash);
        final TextView X1 = (TextView) findViewById(R.id.X1) ;
        final TextView X2 = (TextView) findViewById(R.id.X2) ;
        final TextView Y1 = (TextView) findViewById(R.id.Y1) ;
        final TextView Y2 = (TextView) findViewById(R.id.Y2) ;
        final TextView Diff = (TextView) findViewById(R.id.Diff) ;
        final TextView Quadrant = (TextView) findViewById(R.id.Quad) ;
        final TextView Motion = (TextView) findViewById(R.id.Motion) ;

        image.setOnTouchListener(new View.OnTouchListener() {
            float X_init,X_fin,Y_init,Y_fin,differ;
            @Override


            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        X_init = motionEvent.getX();
                        Y_init = motionEvent.getY();

                        X1.setText(Float.toString(X_init));
                        X2.setText(Float.toString(X_fin));
                        Y1.setText(Float.toString(Y_init));
                        Y2.setText(Float.toString(Y_fin));
                    }
                    case MotionEvent.ACTION_UP: {
                        X_fin = motionEvent.getX();
                        Y_fin = motionEvent.getY();

                        float a;
                        a=X_init - X_fin;
                        Diff.setText(String.valueOf(a));

                        float b;
                        b=Y_init - Y_fin;
                        Diff.setText(String.valueOf(b));


                        if(X_init < X_fin ){
                            if (Y_init > Y_fin){
                                Motion.setText("Left-Right and Up");
                                Quadrant.setText("Q1");
                            }
                        }

                        if(X_init < X_fin ){
                            if (Y_init < Y_fin){
                                Motion.setText("Left-Right and Down");
                                Quadrant.setText("Q4");
                            }
                        }
                        if(X_init > X_fin ){
                            if (Y_init > Y_fin){
                                Motion.setText("Right-Left and Up");
                                Quadrant.setText("Q2");
                            }
                        }
                        if(X_init > X_fin ){
                            if (Y_init < Y_fin){
                                Motion.setText("Right-Left and Down");
                                Quadrant.setText("Q3");
                            }
                        }
                        return true;

                    }

                }

                return false;

            }

        });
    }
}


package com.example.handledemo;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.R.integer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Build;



public class MainActivity extends ActionBarActivity {
	private TextView tv1;
	private Handler handler=new Handler();
	private ImageView imageView;
	private int images[] ={R.drawable.image1,R.drawable.image2,R.drawable.image1};
	private int index=0;
	private MyRunnable myRunnable=new MyRunnable();
	class MyRunnable implements Runnable{

		@Override
		public void run() {
			index++;
			index=index%3;
			imageView.setImageResource(images[index]);
			handler.postDelayed(myRunnable, 1000);
		}
		
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        tv1=(TextView)findViewById(R.id.textview1);
        imageView=(ImageView)findViewById(R.id.imageView1);
        handler.postDelayed(myRunnable, 1000);
       /* new Thread(){
        	public void run(){
        		try {
        			handler.post(new Runnable() {
						@Override
						public void run() {
							tv1.setText("update thread");
							
						}
					});
        			
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }.start();
*/
       
    }


}

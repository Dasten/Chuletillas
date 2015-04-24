package com.carlosb.chuletillas;

/**
 * @author Carlos Belmonte Ceniza
 * Chuletillas App for Android
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity {
	
	private final int SPLASH_DISPLAY_LENGTH = 5000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {

				Intent mainIntent = new Intent(SplashScreen.this, Inicio.class);
				SplashScreen.this.startActivity(mainIntent);
				SplashScreen.this.finish();
			}
		}, SPLASH_DISPLAY_LENGTH);
	}

	@Override
	public void onBackPressed() {
	   finish();
	}
}

package com.carlosb.chuletillas;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ServiceActivity extends Activity {
	
	Intent intentService;
	private String respawn;
	private Chuleta chulletaToNotificate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service);
		
		Bundle extras = getIntent().getExtras();
		if(extras != null){
			respawn = extras.getString("RESPAWN_PARAMETRO");
			chulletaToNotificate = (Chuleta) extras.getSerializable("CHULETA_PARAMETRO");
		}
		
		System.out.println(chulletaToNotificate.getTitulo());
		
		intentService = new Intent(ServiceActivity.this, NotificationService.class);
		ServiceActivity.this.startService(intentService);
		
	}
	
    public void onClickButtonStartStop(View v) {
    	
    	
        if(!NotificationService.isRunning()){
        	ServiceActivity.this.startService(intentService);
        }else{
        	ServiceActivity.this.stopService(intentService);
        }
            
    }


}

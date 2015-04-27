package com.carlosb.chuletillas;

/**
 * @author Carlos Belmonte Ceniza
 * Chuletillas App for Android
 */

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ServiceActivity extends Activity {
	
	private int respawn;
	private Chuleta chulletaToNotify;
	private PendingIntent pendingIntent;
	private AlarmManager manager;
	private boolean isAlarmRunning;
	
	ImageView logo_servicio;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service);
		
		Bundle extras = getIntent().getExtras();
		if(extras != null){
			respawn = extras.getInt("RESPAWN_PARAMETRO");
			chulletaToNotify = (Chuleta) extras.getSerializable("CHULETA_PARAMETRO");
		}
		
		 logo_servicio = (ImageView) findViewById(R.id.logo_servicio);
		
			
		Intent alarmIntent = new Intent(this, AlarmReceiver.class);
		
		alarmIntent.putExtra("CHULETA_PARAMETRO", chulletaToNotify);
	    pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0);
	    
	    isAlarmRunning = false;
	}
	
	
	public void startAlarm() {
	    manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

	    manager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), (respawn  * 60 * 1000), pendingIntent);
	    Toast.makeText(this, "Iniciando Chuletillas, ya puedes guardar el movil ;)", Toast.LENGTH_SHORT).show();
	}
	
    public void onClickButtonStartStop(View v) {
    	
    	if(isAlarmRunning){
    		if (manager != null) {
                manager.cancel(pendingIntent);
                logo_servicio.setImageResource(R.drawable.logo_servicio_off);
                Toast.makeText(this, "Chuletillas detenido, seguro que has aprobado :D", Toast.LENGTH_SHORT).show();
                isAlarmRunning = false;
            }
    	}else{
    		startAlarm();
    		logo_servicio.setImageResource(R.drawable.logo_servicio_on);
    		isAlarmRunning = true;
    	}    
    }

}

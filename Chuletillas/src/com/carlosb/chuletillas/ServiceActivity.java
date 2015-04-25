package com.carlosb.chuletillas;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ServiceActivity extends Activity {
	
	
	private int respawn;
	private Chuleta chulletaToNotify;
	private PendingIntent pendingIntent;
	private AlarmManager manager;
	private boolean isAlarmRunning;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service);
		
		Bundle extras = getIntent().getExtras();
		if(extras != null){
			respawn = Integer.parseInt(extras.getString("RESPAWN_PARAMETRO"));
			chulletaToNotify = (Chuleta) extras.getSerializable("CHULETA_PARAMETRO");
		}
		
		System.out.println(chulletaToNotify.getTitulo());
			
		Intent alarmIntent = new Intent(this, AlarmReceiver.class);
		
		alarmIntent.putExtra("CHULETA_PARAMETRO", chulletaToNotify);
	    pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0);
	    		
	    // ##########################
	    respawn = 10000;
	    // ##########################
	    
	    isAlarmRunning = false;
	}
	
	
	public void startAlarm() {
	    manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

	    manager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), respawn, pendingIntent);
	    Toast.makeText(this, "Iniciando Chuletillas, ya puedes guardar el movil ;)", Toast.LENGTH_SHORT).show();
	}
	
    public void onClickButtonStartStop(View v) {
    	
    	if(isAlarmRunning){
    		if (manager != null) {
                manager.cancel(pendingIntent);
                Toast.makeText(this, "Chuletillas detenido, seguro que has aprobado :D", Toast.LENGTH_SHORT).show();
                isAlarmRunning = false;
            }
    	}else{
    		startAlarm();
    		isAlarmRunning = true;
    	}    
    }


}

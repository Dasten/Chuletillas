package com.carlosb.chuletillas;

/**
 * @author Carlos Belmonte Ceniza
 * Chuletillas App for Android
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
	
	private Chuleta chuletilla;

    @Override
    public void onReceive(Context arg0, Intent arg1) {
    	
    	chuletilla = (Chuleta) arg1.getExtras().getSerializable("CHULETA_PARAMETRO");
	
        Toast.makeText(arg0, "Generando chuleta... " + chuletilla.getTitulo(), Toast.LENGTH_SHORT).show();
        crearNotificacion(arg0);
    }
    
    
	public void crearNotificacion(Context context){
		
		int notificationId = 001;
		
        NotificationCompat.BigTextStyle bigStyle = new NotificationCompat.BigTextStyle();
        bigStyle.bigText(chuletilla.getContenido());

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context)
        						.setSmallIcon(R.drawable.ic_launcher)
        						//.setLargeIcon(BitmapFactory.decodeResource(
        								//getResources(), R.drawable.ic_launcher))
                        .setContentTitle(chuletilla.getTitulo())
                        .setStyle(bigStyle);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        notificationManager.notify(notificationId, notificationBuilder.build());

	}
	
	
	

}
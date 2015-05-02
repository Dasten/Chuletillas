package com.carlosb.chuletillas;

/**
 * @author Carlos Belmonte Ceniza
 * Chuletillas App for Android
 */

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;


public class AlarmReceiver extends BroadcastReceiver {
	
	private Chuleta chuletilla;

    @Override
    public void onReceive(Context arg0, Intent arg1) {
    	
    	chuletilla = (Chuleta) arg1.getExtras().getSerializable("CHULETA_PARAMETRO");
	
        //Toast.makeText(arg0, "Generando chuleta... " + chuletilla.getTitulo(), Toast.LENGTH_SHORT).show();
        crearNotificacion(arg0);
    }
    
	public void crearNotificacion(Context context){
		
		int notificationId = 001;
		
		// ############# - Intent que lanzara la Notificacion cuando le "clikeamos" - La Activity a donde vamos
		Intent notificationIntent = new Intent(context, ServiceActivity.class);
		notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
	            | Intent.FLAG_ACTIVITY_SINGLE_TOP);
		PendingIntent intent = PendingIntent.getActivity(context, 0,
	            notificationIntent, 0);
		// #############
		
        NotificationCompat.BigTextStyle bigStyle = new NotificationCompat.BigTextStyle();
        bigStyle.bigText(chuletilla.getContenido());

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context)
        						.setSmallIcon(R.drawable.ic_launcher)
        						/*.setLargeIcon(BitmapFactory.decodeResource(
        								context.getResources(), R.drawable.logo_trans))*/
                        .setContentTitle(chuletilla.getTitulo())
                        // ############# - Aqui añadimos el intent a la notificacion
                        .setContentIntent(intent)
                        // #############
                        .setStyle(bigStyle);
                        

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        notificationManager.notify(notificationId, notificationBuilder.build());

	}

}
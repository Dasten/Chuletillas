package com.carlosb.chuletillas;

import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

public class NotificationService extends Service{
	
	private static NotificationService instance  = null;
	
	public static boolean isRunning() { 
	      return instance != null; 
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
 
	@Override
	public void onCreate() {
		Toast.makeText(getApplicationContext(), "Servicio de notificaciones creado", Toast.LENGTH_LONG).show();
		System.out.println( "Servicio NotificationService creado");
		instance=this;
	}
 
	@Override
	public void onDestroy() {
		Toast.makeText(getApplicationContext(), "Servicio de notificaciones destruido", Toast.LENGTH_LONG).show();
		System.out.println( "Servicio NotificationService destruido");
		instance = null;
	}
 
	@Override
	public void onStart(Intent intent, int startid) {
		Toast.makeText(getApplicationContext(), "Servicio de notificaciones iniciado!!", Toast.LENGTH_LONG).show();
		System.out.println( "Servicio NotificationService iniciado");
		lanzarNotificacion();
 
	}
	
	
 
	 void lanzarNotificacion(){

			int notificationId = 001;
			
	        NotificationCompat.BigTextStyle bigStyle = new NotificationCompat.BigTextStyle();
	        bigStyle.bigText("Contenido de la notificacion");

	        NotificationCompat.Builder notificationBuilder =
	                new NotificationCompat.Builder(this)
	        						.setSmallIcon(R.drawable.ic_launcher)
	        						.setLargeIcon(BitmapFactory.decodeResource(
	        								getResources(), R.drawable.ic_launcher))
	                        .setContentTitle("Titulo de la notificacion")
	                        .setStyle(bigStyle);



	        // Get an instance of the NotificationManager service
	        NotificationManagerCompat notificationManager =
	                NotificationManagerCompat.from(this);

	        // Build the notification and issues it with notification manager.
	        notificationManager.notify(notificationId, notificationBuilder.build());
	        
	 }

}

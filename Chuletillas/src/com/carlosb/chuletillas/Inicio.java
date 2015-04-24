package com.carlosb.chuletillas;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Path;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.View;
import android.widget.Toast;


public class Inicio extends Activity {
	
	private static final int ABRIRFICHERO_RESULT_CODE = 1;
	private static final String EXTENSION_TYPE_1 = "txt";
	 
	Chuleta chuletaCargada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        
        
    }

    
    public void onClickButtonExaminar(View v) {
    	Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
    	Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath()
    	    + "/Chuletillas/");
    	intent.setDataAndType(uri, "file/txt");
        startActivityForResult(intent, ABRIRFICHERO_RESULT_CODE);
    }

 
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
        case ABRIRFICHERO_RESULT_CODE:
            if (resultCode == RESULT_OK) {
 
                String ruta = data.getData().getPath();
				Toast.makeText(this, "Ruta del fichero: " + ruta,Toast.LENGTH_LONG).show();
				//System.out.println(ruta);
				
				if(isChuletaExtensionValid(ruta, EXTENSION_TYPE_1)){
					chuletaCargada = crearChuleta(ruta);
					
					// #####################  Notificacion de prueba  ###############
					//crearNotificacion(chuletaCargada);
					// #####################
					
				}else{
					Toast.makeText(this, "Chuleta no valida, comprueba que la extension es " + EXTENSION_TYPE_1,Toast.LENGTH_LONG).show();
				}
				
				
				
            }
        }
    }
    
    private boolean isChuletaExtensionValid(String path, String extensionType){
		String extension = path.substring(path.lastIndexOf('.') + 1);
		
    	if(extension.equals(extensionType)){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    private Chuleta crearChuleta(String pathChuleta){
    	
    	String nombreFichero;
    	String tituloChuleta;
    	String contenido = "Error al leer la chuleta";
    	
    	nombreFichero = pathChuleta.substring(pathChuleta.lastIndexOf('/') + 1);
    	nombreFichero = nombreFichero.substring(0, nombreFichero.lastIndexOf(".txt"));  	
    	tituloChuleta = nombreFichero;
    	
    	try{
    		contenido = leerChuleta(pathChuleta);
    		//contenido = leerTextoArchivo(pathChuleta);
    		System.out.println(contenido);
    	}catch (Exception e){
    		System.out.println("Error en la lectura de la chuleta: " + e);
    	}
    	 
    	Chuleta miChuleta = new Chuleta(pathChuleta, nombreFichero, tituloChuleta, contenido);
    	
    	return miChuleta;
    }
    
    
	public static String leerChuleta(String path) throws IOException{
		
	    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
	    
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        
	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	        //return (new String(sb.toString().getBytes("UTF-8"), "UTF-8"));
	    } finally {
	        br.close();
	    }
	};
	
	
	
	public void crearNotificacion(){
		
		int notificationId = 001;
		
        NotificationCompat.BigTextStyle bigStyle = new NotificationCompat.BigTextStyle();
        bigStyle.bigText(chuletaCargada.getContenido());

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this)
        						.setSmallIcon(R.drawable.ic_launcher)
        						.setLargeIcon(BitmapFactory.decodeResource(
        								getResources(), R.drawable.ic_launcher))
                        .setContentTitle(chuletaCargada.getTitulo())
                        .setStyle(bigStyle);



        // Get an instance of the NotificationManager service
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);

        // Build the notification and issues it with notification manager.
        notificationManager.notify(notificationId, notificationBuilder.build());
		

	}
	
	public void onClickButtonTestNot (View v){
		
		crearNotificacion();
		
	}
    
    
    
}

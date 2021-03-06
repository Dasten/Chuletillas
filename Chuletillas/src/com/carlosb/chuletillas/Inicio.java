package com.carlosb.chuletillas;

/**
 * @author Carlos Belmonte Ceniza
 * Chuletillas App for Android
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

public class Inicio extends Activity {
	
	private static final int ABRIRFICHERO_RESULT_CODE = 1;
	private static final String EXTENSION_TYPE_1 = "txt";
	 
	String ruta; 
	boolean isChuletaCargada = false;
	Chuleta chuletaCargada;
	int respawn = 10;
	
	EditText widgetIntervalo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        
        widgetIntervalo = (EditText)findViewById(R.id.box_intervalo_notificacion);
        
    }
    
    public void onClickButtonExaminar(View v) {
    	Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
    	Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath() + "/Chuletillas/");
    	intent.setDataAndType(uri, "file/txt");
        startActivityForResult(intent, ABRIRFICHERO_RESULT_CODE);
    }
 
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
        case ABRIRFICHERO_RESULT_CODE:
            if (resultCode == RESULT_OK) {
 
                ruta = data.getData().getPath();
                
				//Toast.makeText(this, "Ruta del fichero: " + ruta,Toast.LENGTH_LONG).show();
				
				if(isChuletaExtensionValid(ruta, EXTENSION_TYPE_1)){
					chuletaCargada = crearChuleta(ruta);					
					isChuletaCargada = true;
					Toast.makeText(this, "Chuleta cargada correctamente.", Toast.LENGTH_LONG).show();
				}else{
					Toast.makeText(this, "Chuleta no valida, comprueba que la extensi�n es ." + EXTENSION_TYPE_1,Toast.LENGTH_LONG).show();
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
    	}catch (Exception e){
    		System.out.println("Error en la lectura de la chuleta: " + e);
    		Toast.makeText(this, "Error en la lectura de la chuleta, int�ntalo de nuevo o prueba con otro archivo.",Toast.LENGTH_LONG).show();
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
	    } finally {
	        br.close();
	    }
	}
	
	public void onClickButtonCont (View v){
		
		respawn =  Integer.parseInt(widgetIntervalo.getText().toString());
		
		if(respawn > 1 && respawn < 60){
			if(isChuletaCargada){
				Intent intentActivityService = new Intent(Inicio.this,
						ServiceActivity.class);
				
				intentActivityService.putExtra("CHULETA_PARAMETRO", chuletaCargada);
				intentActivityService.putExtra("RESPAWN_PARAMETRO", respawn);
				startActivity(intentActivityService);
				
			}else{
				Toast.makeText(this, "Selecciona una Chuleta en la memoria primero para continuar.",Toast.LENGTH_LONG).show();
			}
		}else{
			Toast.makeText(this, "El intervalo de tiempo tiene que ser mayor a 1 min y menor a 60 min.",Toast.LENGTH_LONG).show();
		}
		
	}
	
	@SuppressLint("InflateParams") 
	public void onClickButtonHelp(View v){
		Dialog settingsDialog = new Dialog(this);
		settingsDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		settingsDialog.setContentView(getLayoutInflater().inflate(R.layout.image_layout, null));
		settingsDialog.show();
	}
    
}

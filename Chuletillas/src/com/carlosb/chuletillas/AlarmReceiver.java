package com.carlosb.chuletillas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
	
	private Chuleta chuletilla;

    @Override
    public void onReceive(Context arg0, Intent arg1) {
    	
    	chuletilla = (Chuleta) arg1.getExtras().getSerializable("CHULETA_PARAMETRO");
    	
    	/*
    	Bundle extras = arg1.getExtras();
		if(extras != null){
			chuletilla = (Chuleta) extras.getSerializable("CHULETA_PARAMETRO");
		}
		*/
    	
    	
    	
        // For our recurring task, we'll just display a message
        Toast.makeText(arg0, "I'm running || " + chuletilla.getTitulo(), Toast.LENGTH_SHORT).show();

    }

}
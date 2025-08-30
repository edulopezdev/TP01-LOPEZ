package com.ejemplo.tp01_lopez;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class ReceiverModoAvion extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
            boolean estaModoAvionActivado = intent.getBooleanExtra("state", false);

            if (estaModoAvionActivado) {
                Toast.makeText(context, "Se activo el Modo Avión", Toast.LENGTH_SHORT).show();
                Log.d("ReceiverModoAvion", "Se desactivó el Modo Avión");
            } else {
                Toast.makeText(context, "Modo avión DESACTIVADO", Toast.LENGTH_SHORT).show();
                Log.d("ReceiverModoAvion", "Modo avión desactivado");

                // este es el intent para llamar a un número
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:2664553747"));//siempre colocar la etiqueta tel: si no no funciona
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//esta bandera es para hacer que funcione desde el broadcast receiver
                context.startActivity(callIntent);
            }
        }
    }



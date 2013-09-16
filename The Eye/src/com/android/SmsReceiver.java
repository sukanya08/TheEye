package com.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
       
		// TODO Auto-generated method stub
		Bundle bundle= intent.getExtras();
		SmsMessage[] msgs= null;
		String str="";
		String strb="";
		String stra="";
		if(bundle != null)
		{
			Object[] pdus= (Object[]) bundle.get("pdus");
			msgs= new SmsMessage[pdus.length];
			for(int i=0; i<msgs.length;i++)
			{
				msgs[i]= SmsMessage.createFromPdu((byte[]) pdus[i]);
				str += "Sms from "+ msgs[i].getOriginatingAddress();
				str += " :";
				str += msgs[i].getMessageBody().toString();
				str += "\n";
			
			}
			for(int i=0; i<msgs.length;i++)
				strb=msgs[i].getMessageBody().toString();
			for(int i=0; i<msgs.length;i++)
				stra=msgs[i].getOriginatingAddress();
				
			//Toast.makeText(context, str, Toast.LENGTH_LONG).show();
			
			Intent broadcastIntent= new Intent();
			broadcastIntent.setAction("SMS_RECEIVED_ACTION");
			broadcastIntent.putExtra("sms", str);
			broadcastIntent.putExtra("msgb", strb);
			broadcastIntent.putExtra("msga", stra);
			context.sendBroadcast(broadcastIntent);
		
			
		}
	}

}

package com.android;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TheEyeMk14Activity extends Activity{
	
	Button bgps,bexit, bsms= null;
	String sr="kring";
	String sg="kgps";
	String msgb, msga;
	GPSTracker gps;
	Ringtone r;
	Uri notification;
	
	IntentFilter intentFilter;
	private BroadcastReceiver intentReceiver = new BroadcastReceiver() {
		
		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			msgb= intent.getExtras().getString("msgb");
			msga= intent.getExtras().getString("msga");
			
			if(sr.trim().equalsIgnoreCase(msgb.trim())){
				ringPh();
	        }
			if(sg.trim().equalsIgnoreCase(msgb.trim())){
				gpsTrack();
			}
		}
	};
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        intentFilter= new IntentFilter();
        intentFilter.addAction("SMS_RECEIVED_ACTION");
        
      //To Exit the Application
        bexit=(Button)findViewById(R.id.bt_exitmain);
        bexit.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
				System.exit(0);
			}
        });
	}
	
	private void ringPh()
	{
		final AudioManager mAudio = (AudioManager) getSystemService(Activity.AUDIO_SERVICE);
		mAudio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        r = RingtoneManager.getRingtone(getApplicationContext(), notification);
        r.play();
    	sendSMS(msga,"Your Phone is ringing!");
        showPopUpr();
	}
	private void showPopUpr() {

		AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);
		 helpBuilder.setTitle("TheEye Ringer Alert");
		 helpBuilder.setMessage("Yo buddy!! This is your phone ringing. Can you hear yet??");
		 helpBuilder.setPositiveButton("Found My Phone",
		   new DialogInterface.OnClickListener() {

		    public void onClick(DialogInterface dialog, int which) {
		     // Do nothing but close the dialog
		    	r.stop();
				sendSMS(msga,"ringing stopped by someone !!!");
		    }
		   });

		 // Remember, create doesn't show the dialog
		 AlertDialog helpDialog = helpBuilder.create();
		 helpDialog.show();

   	}
	@Override
	protected void onResume(){
		registerReceiver(intentReceiver, intentFilter);
		super.onResume();
	}
	
	@Override
	protected void onPause(){
		unregisterReceiver(intentReceiver);
		super.onPause();
	}
	
	private void sendSMS(String phoneNumber, String message)
    {
		SmsManager sms = SmsManager.getDefault();
		sms.sendTextMessage(phoneNumber, null, message, null, null);
		//Toast.makeText(getApplicationContext(), "Sms Sent", Toast.LENGTH_LONG).show();
    }
	private void gpsTrack(){
		gps = new GPSTracker(TheEyeMk14Activity.this);
		
        // check if GPS enabled     
        if(gps.canGetLocation()){
             
            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();
            
            // \n is for new line
            //Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
            sendSMS(msga, "Your Location is - \nLat: " + latitude + "\nLong: " + longitude);
        }else{
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
        }
	}
}

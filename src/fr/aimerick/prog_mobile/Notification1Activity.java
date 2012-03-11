package fr.aimerick.prog_mobile;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Notification1Activity extends Activity {
	
	protected static final int NOTIFICATION_STATUS_BAR = 1;
	
	protected NotificationManager _manager = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.notification_1);
        
        _manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        
        Button toast = (Button) findViewById(R.id.notification_1_toast);
        toast.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast notification = Toast.makeText(Notification1Activity.this, "Notification Toast", Toast.LENGTH_LONG);
				notification.show();
			}
		});
        
        Button status = (Button) findViewById(R.id.notification_1_status_bar);
        status.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		Intent i = new Intent(Notification1Activity.this, Notification1Activity.class);
        		PendingIntent contentIntent = PendingIntent.getActivity(Notification1Activity.this, 0, i, 0);

        		Notification notification = new Notification(R.drawable.arrow_refresh, "Il y a une notification", System.currentTimeMillis());
                notification.setLatestEventInfo(Notification1Activity.this, "Titre de la notification", "Contenu de la notification", contentIntent);
                
                notification.flags = Notification.FLAG_AUTO_CANCEL;
                // _manager.cancel(NOTIFICATION_STATUS_BAR);
                
                _manager.notify(NOTIFICATION_STATUS_BAR, notification);
        	}
        });
    }
    
}
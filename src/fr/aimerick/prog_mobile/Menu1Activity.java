package fr.aimerick.prog_mobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Menu1Activity extends Activity {
	
	protected static final int ACTION_NEW_ACTIVITY = 1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	super.onCreateOptionsMenu(menu);

    	menu.add(0, ACTION_NEW_ACTIVITY, 0, "Nouvelle activité").setIcon(R.drawable.add);

    	return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	super.onOptionsItemSelected(item);
    	
    	switch (item.getItemId()) {
    		case ACTION_NEW_ACTIVITY:
    			Intent i = new Intent(this, Liste1TexteActivity.class);
    			startActivity(i);
    			break;
    	}
    	
    	return false;
    }
    
}
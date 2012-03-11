package fr.aimerick.prog_mobile;

import android.view.Menu;
import android.view.MenuItem;

public class Liste2MenuActivity extends Liste2Activity {

	protected static final int ACTION_NEW_ITEM = 1;
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	super.onCreateOptionsMenu(menu);

    	menu.add(0, ACTION_NEW_ITEM, 0, "Nouvelle ligne").setIcon(R.drawable.add);

    	return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	super.onOptionsItemSelected(item);
    	
    	switch (item.getItemId()) {
    		case ACTION_NEW_ITEM:
    			_strings.add("#" + (_strings.size() + 1));
    			ArrayListAdapater adapter = (ArrayListAdapater) getListAdapter();
    			adapter.notifyDataSetChanged();
    			break;
    	}
    	
    	return false;
    }
    
}

package fr.aimerick.prog_mobile;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

public class Liste2MenuActivity extends Liste2Activity {

	protected static final int ACTION_NEW_ITEM = 1;
	protected static final int ACTION_DESTROY_ITEM = 2;
	protected static final int ACTION_DUPLICATE_ITEM = 3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        registerForContextMenu(getListView());
    }
	
    // options menu
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	super.onCreateOptionsMenu(menu);

    	menu.add(0, ACTION_NEW_ITEM, 0, "Nouvelle ligne").setIcon(R.drawable.add);

    	return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	super.onOptionsItemSelected(item);
    	
    	ArrayListAdapater adapter = (ArrayListAdapater) getListAdapter();
    	
    	switch (item.getItemId()) {
    		case ACTION_NEW_ITEM:
    			_strings.add("#" + (_strings.size() + 1));
    			adapter.notifyDataSetChanged();
    			break;
    	}
    	
    	return false;
    }
    
    // context menu

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);

		menu.add(0, ACTION_DESTROY_ITEM, 0, "Supprimer");
		menu.add(0, ACTION_DUPLICATE_ITEM, 0, "Dupliquer");
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		super.onContextItemSelected(item);
		
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
		ArrayListAdapater adapter = (ArrayListAdapater) getListAdapter();

		switch (item.getItemId()) {
			case ACTION_DUPLICATE_ITEM:
				String text = (String) adapter.getItem(info.position);
				_strings.add(text);
    			adapter.notifyDataSetChanged();
    			break;
			case ACTION_DESTROY_ITEM:
				_strings.remove(info.position);
    			adapter.notifyDataSetChanged();
				break;
		}

		return true;
	}
    
}

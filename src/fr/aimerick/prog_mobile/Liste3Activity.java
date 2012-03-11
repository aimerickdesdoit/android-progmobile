package fr.aimerick.prog_mobile;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Liste3Activity extends ListActivity {
	
	protected static final int ACTION_NEW_ITEM = 1;
	
	protected SQLiteDatabase _db;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        DbOpenHelper openHelper = new DbOpenHelper(this, "Liste3ActivityDb", null, 1);
        _db = openHelper.getWritableDatabase();
        
        setListAdapter(new DbAdapter());
    }
	
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
    			DbAdapter adapter = (DbAdapter) getListAdapter();
    			
    			ContentValues values = new ContentValues();
    			values.put("label", "#" + (adapter.getCount() + 1));
    		    _db.insert("liste", null, values);
    					
    			adapter.notifyDataSetChanged();
    			break;
    	}
    	
    	return false;
    }
	
	public void onDestroy(){
		super.onDestroy();
		_db.close();
	}
    
	protected class DbObject {
		
		public long id = 0;
		public String label;
		
	}
	
    protected class DbAdapter extends BaseAdapter {

    	ArrayList<DbObject> _objects = new ArrayList<DbObject>();
    	
    	public DbAdapter() {
    		_refresh();
    	}
    	
    	protected void _refresh(){
    		_objects = new ArrayList<DbObject>();
    		DbObject object;
    		
			Cursor cursor = _db.query("liste", new String[] {"id", "label"}, null, null, null, null, null);
			if (cursor.moveToFirst()) {
				do {
					object = new DbObject();
					object.id = cursor.getLong(0);
					object.label = cursor.getString(1);
					_objects.add(object);
				} while (cursor.moveToNext());
			}
			cursor.close();
    	}
    	
    	public void notifyDataSetChanged() {
    		_refresh();
    		super.notifyDataSetChanged();
    	}
    	
		@Override
		public int getCount() {
			return _objects.size();
		}

		@Override
		public Object getItem(int position) {
			if (_objects.size() > position) {
				return _objects.get(position);
			}
			return null;
		}

		@Override
		public long getItemId(int position) {
			DbObject object = (DbObject) getItem(position);
			if (object != null) {
				return object.id;
			}
			return 0;
		}
	    
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewGroup layout = (ViewGroup) getLayoutInflater().inflate(R.layout.liste_2_item, parent, false);
			TextView view = (TextView) layout.findViewById(R.id.liste_2_texte);
			
			DbObject object = (DbObject) getItem(position);
			if (object != null) {
				view.setText(object.label);
			}
			
			return layout;
		}
    	
    }
    
    protected class DbOpenHelper extends SQLiteOpenHelper {

		public DbOpenHelper(Context context, String name, CursorFactory factory, int version) {
    		super(context, name, factory, version);
    	}

    	@Override
    	public void onCreate(SQLiteDatabase db) {
    		String query = "CREATE TABLE IF NOT EXISTS `liste` (" +
    			"`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
    			"`label` VARCHAR" +
    		");";
    		db.execSQL(query);
    	}

    	@Override
    	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    	}

    }

}

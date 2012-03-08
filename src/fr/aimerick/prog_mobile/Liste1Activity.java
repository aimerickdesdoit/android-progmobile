package fr.aimerick.prog_mobile;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Liste1Activity extends ListActivity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, _mStrings));
    }
    
    @Override
    protected void onListItemClick (ListView l, View v, int position, long id) {
    	super.onListItemClick(l, v, position, id);
    	Log.d("debug", _mStrings[position]);
    }
    
    protected String[] _mStrings = {
    	"#1", "#2", "#3"
    };

}

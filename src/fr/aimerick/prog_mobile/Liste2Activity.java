package fr.aimerick.prog_mobile;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Liste2Activity extends ListActivity {
	
	protected ArrayList<String> _strings = new ArrayList<String>();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.liste_2);
        
        _strings.add("#1");
        _strings.add("#2");
        _strings.add("#3");
        
        setListAdapter(new ArrayListAdapater());
    }
    
    protected class ArrayListAdapater extends BaseAdapter {
    	
		@Override
		public int getCount() {
			return _strings.size();
		}

		@Override
		public Object getItem(int position) {
			if (_strings.size() > position) {
				return _strings.get(position);
			}
			return null;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewGroup layout = (ViewGroup) getLayoutInflater().inflate(R.layout.liste_2_item, parent, false);
			TextView view = (TextView) layout.findViewById(R.id.liste_2_texte);
			
			String text = (String) getItem(position);
			if (text != null) {
				view.setText(text);
			}
			
			return layout;
		}
    	
    }

}

package fr.aimerick.prog_mobile;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class Onglets1Activity extends TabActivity implements TabHost.TabContentFactory {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		TabHost tabHost = getTabHost();
//		TabSpec spec = tabHost.newTabSpec("tab_tag");
		
		tabHost.addTab(tabHost.newTabSpec("tab1")
			.setIndicator("Onglet 1")
			.setContent(this));
		
		tabHost.addTab(tabHost.newTabSpec("tab2")
			.setIndicator("Onglet 2")
			.setContent(this));
		
		tabHost.addTab(tabHost.newTabSpec("tab3")
			.setIndicator("Onglet 3")
			.setContent(this));
	}
	
	public View createTabContent(String tag) {
		final TextView tv = new TextView(this);
		tv.setText("Content for tab with tag " + tag);
		return tv;
	}
	
}

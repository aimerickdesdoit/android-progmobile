package fr.aimerick.prog_mobile;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

public class Onglet2Activity extends TabActivity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TabHost tabHost = getTabHost();
//		TabSpec spec = tabHost.newTabSpec("tab_tag");
        
        LayoutInflater.from(this).inflate(R.layout.onglet2, tabHost.getTabContentView(), true);
        
		
		tabHost.addTab(tabHost.newTabSpec("tab1")
			.setIndicator("Onglet 1")
			.setContent(R.id.onglet1));
		
		tabHost.addTab(tabHost.newTabSpec("tab2")
			.setIndicator("Onglet 2")
			.setContent(R.id.onglet2));
		
		tabHost.addTab(tabHost.newTabSpec("tab3")
			.setIndicator("Onglet 3")
			.setContent(R.id.onglet3));
    }
    
}

package fr.aimerick.prog_mobile;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Liste1TexteActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_1_texte);
        
        String texte = null;
        if (getIntent().getExtras() != null) {
        	texte = (String) getIntent().getExtras().get("from_list");
        }
        else {
        	texte = "aucun texte";
        }
        
        TextView view = (TextView) findViewById(R.id.liste_1_texte);
        view.setText(texte);
    }
    
}
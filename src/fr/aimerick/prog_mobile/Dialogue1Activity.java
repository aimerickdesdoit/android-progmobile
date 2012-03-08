package fr.aimerick.prog_mobile;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Dialogue1Activity extends Activity {
	
	protected static final int DIALOG_CONFIRM = 1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialogue_1);
        
        Button button = (Button) findViewById(R.id.dialogue_1_button);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                showDialog(DIALOG_CONFIRM);
            }
        });
    }
    
    protected Dialog onCreateDialog(int id) {
    	AlertDialog.Builder builder = null;
        switch (id) {
        	case DIALOG_CONFIRM:
            	builder = new AlertDialog.Builder(this)
	        		.setTitle("Boîte de dialogue")
	        		.setPositiveButton("OK", new DialogInterface.OnClickListener() {
	    				@Override
	    				public void onClick(DialogInterface dialog, int which) {
	    					_result("ok");
	    				}
	        			
	        		})
	        		.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
	    				@Override
	    				public void onClick(DialogInterface arg0, int arg1) {
	    			    	_result("annuler");
	    				}
	    			});
        		break;
        }
        if (builder != null) {
        	return builder.create();
        }
        return null;
    }
    
    protected void _result(String texte) {
    	TextView view = (TextView) findViewById(R.id.dialogue_1_result);
    	view.setText(texte);
    }
    
}
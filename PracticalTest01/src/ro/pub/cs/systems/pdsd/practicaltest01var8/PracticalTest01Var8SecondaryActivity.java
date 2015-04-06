package ro.pub.cs.systems.pdsd.practicaltest01var8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;


public class PracticalTest01Var8SecondaryActivity extends Activity {
	private ButtonClickListener buttonClickListener = new ButtonClickListener();

	private class ButtonClickListener implements View.OnClickListener {

		@Override
		public void onClick(View view) {
			switch(view.getId()) {
			case R.id.verify_button:
				setResult(RESULT_OK, new Intent());
				finish();
				break;
			case R.id.cancel_button:
				setResult(RESULT_CANCELED, new Intent());
				finish();
				break;
			}
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var8_secondary);
		
		 TextView numberOfClicksTextView = (TextView)findViewById(R.id.sablon);

		    Intent intent = getIntent();
		    if (intent != null) {
		    	String numberOfClicks = intent.getStringExtra("sablon");
		    	if (numberOfClicks != null) {
		    		numberOfClicksTextView.setText(numberOfClicks);
		    	}
		    }
		    
	        Button verify = (Button)findViewById(R.id.verify_button);
	        verify.setOnClickListener(buttonClickListener);

	        Button cancel = (Button)findViewById(R.id.cancel_button);
	        cancel.setOnClickListener(buttonClickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var8_secondary, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

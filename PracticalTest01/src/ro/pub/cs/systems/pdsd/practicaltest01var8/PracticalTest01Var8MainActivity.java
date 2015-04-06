package ro.pub.cs.systems.pdsd.practicaltest01var8;


import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;


public class PracticalTest01Var8MainActivity extends Activity {
	public Integer countCenter = 0;
	private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

	private ButtonClickListener buttonClickListener = new ButtonClickListener();
	private class ButtonClickListener implements View.OnClickListener {
		

		@Override
		public void onClick(View v) {
			EditText textField = (EditText)findViewById(R.id.textField);
	        

			if (v instanceof Button) {
				switch(((Button)v).getId()) {
					case R.id.top_left:
						textField.setText(String.valueOf(textField.getText().toString()) + "Top Left,");
						break;
					case R.id.top_right:
						textField.setText(String.valueOf(textField.getText().toString()) + "Top Right,");
						break;
					case R.id.center:
						countCenter++;
						Toast.makeText(getApplicationContext(), "CountCenter =  "+Integer.toString(countCenter), Toast.LENGTH_LONG).show();
						textField.setText(String.valueOf(textField.getText().toString()) + "Center,");
						break;
					case R.id.bottom_left:
						textField.setText(String.valueOf(textField.getText().toString()) + "Bottom Left,");
						break;
					case R.id.bottom_right:
						textField.setText(String.valueOf(textField.getText().toString()) + "Bottom Right,");
						break;
					case R.id.navigate_activity:
						Intent intent = new Intent("ro.pub.cs.systems.pdsd.intent.action.PracticalTest01SecondaryActivity");
				          intent.putExtra("sablon",
				            String.valueOf(
				              Integer.parseInt(countCenter.toString())
				            ));
				          startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);

						break;
					default:
						break;
				}
			}
		}

	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var8_main);
        
        if (savedInstanceState != null) {
            String counter = savedInstanceState.getString("counter");
            if (counter != null) {
            	countCenter = Integer.parseInt(counter);
            } else {
            	countCenter = 0;
            }
	    } else {
	    	countCenter = 0;
	    }
        
        
        Button topLeft = (Button)findViewById(R.id.top_left);
        topLeft.setOnClickListener(buttonClickListener);

        Button topRight = (Button)findViewById(R.id.top_right);
        topRight.setOnClickListener(buttonClickListener);
        
        Button center = (Button)findViewById(R.id.center);
        center.setOnClickListener(buttonClickListener);

        Button bottomRight = (Button)findViewById(R.id.bottom_right);
        bottomRight.setOnClickListener(buttonClickListener);
        
        Button bottomLeft = (Button)findViewById(R.id.bottom_left);
        bottomLeft.setOnClickListener(buttonClickListener);

        Button navigateButton = (Button)findViewById(R.id.navigate_activity);
        navigateButton.setOnClickListener(buttonClickListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_var8_main, menu);
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
    
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("counter", Integer.toString(countCenter));
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
      Toast.makeText(this, "The activity returned with result "+resultCode, Toast.LENGTH_LONG).show();
      EditText textField = (EditText)findViewById(R.id.textField);
      countCenter = 0;
      textField.setText("");
      
    }
}

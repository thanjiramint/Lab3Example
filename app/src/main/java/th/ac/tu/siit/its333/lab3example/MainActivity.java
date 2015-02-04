package th.ac.tu.siit.its333.lab3example;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void act2Clicked(View v) {
        Intent i = new Intent(this, Activity2.class); //Intent > create new activity ,Activity2.class
        startActivity(i);
    }

    public void act3Clicked(View v) {
        Intent i = new Intent(this, Activity3.class);

        //attach input
        EditText etInput = (EditText)findViewById(R.id.etInput);
        i.putExtra("toAct3", etInput.getText().toString()); //attach text that I type with name of 'toAct3'

        startActivityForResult(i, 88); //Send result, 88 = int
    }

    @Override
    //Come back from Activity3
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView tvResult = (TextView)findViewById(R.id.tvResult);

        if (requestCode == 88)
        {
            if (resultCode == RESULT_OK) //We already set result OK
            {
                String result = data.getStringExtra("toAct1");
                tvResult.setText(result); //Set text to be display
            }
            else if (resultCode == RESULT_CANCELED) //Click back button (at the bottom), result is not ok
            {
                tvResult.setText("CANCELED");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

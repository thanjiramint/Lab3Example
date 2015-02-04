package th.ac.tu.siit.its333.lab3example;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Activity3 extends ActionBarActivity {

    String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);

        Intent i = this.getIntent(); // get current activity
        input = i.getStringExtra("toAct3"); //Receive input(name should match 'toAct3')
        TextView tvInput = (TextView)findViewById(R.id.tvInput); //send to text input
        tvInput.setText(input);
    }

    public void retClicked(View v) {

        Intent res = new Intent();
        EditText etRet = (EditText)findViewById(R.id.etRet);
        res.putExtra("toAct1", etRet.getText().toString()); //Attach value, name toAct1
        setResult(RESULT_OK, res); //Need to set Result is ok
        finish(); //this.finish() = finish ()
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity3, menu);
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

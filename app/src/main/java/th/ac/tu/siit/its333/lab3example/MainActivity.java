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
        Intent i = new Intent(this, Activity2.class);
        startActivity(i);
    }

    public void act3Clicked(View v) {
        Intent i = new Intent(this, Activity3.class);
        EditText etInput = (EditText)findViewById(R.id.etInput);
        i.putExtra("toAct3", etInput.getText().toString());
        startActivityForResult(i, 88);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView tvResult = (TextView)findViewById(R.id.tvResult);

        if (requestCode == 88) {
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("toAct1");
                tvResult.setText(result);
            }
            else if (resultCode == RESULT_CANCELED) {
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

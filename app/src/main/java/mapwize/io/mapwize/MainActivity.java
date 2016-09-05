package mapwize.io.mapwize;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String MAP_FRAG_TAG = "mapfragmenttag";
    private TextView toolbar_tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MainActivity", "onCreate");
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("MainActivity", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("MainActivity", "onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("MainActivity", "onSaveInstanceState");
    }

    @Override
    public void onRestoreInstanceState(Bundle outState) {
        super.onRestoreInstanceState(outState);
        Log.i("MainActivity", "onRestoreInstanceState");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("MainActivity", "onStop");
    }

}

package mapwize.io.mapwize;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;

public class MainActivity extends AppCompatActivity {

    private String MAP_FRAG_TAG = "mapfragmenttag";
    private Toolbar toolbar;
    private Drawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MainActivity", "onCreate");
        setContentView(R.layout.activity_main_solution_1);
        //setContentView(R.layout.activity_main_solution_2);

        toolbar = (Toolbar) findViewById(R.id.activity_toolbar);
        drawer = new DrawerBuilder().withActivity(this).withToolbar(toolbar).build();

        //we have to make the StatusBar of the coordinatorLayout transparent as it will drawer over our background otherwise
        ((CoordinatorLayout)findViewById(R.id.coordinatorLayout)).setStatusBarBackgroundColor(Color.TRANSPARENT);
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

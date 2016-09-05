package mapwize.io.mapwize;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class SearchActivity  extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView toolbar_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MapActivity", "onCreate");
        setContentView(R.layout.activity_search);

        toolbar = (Toolbar) findViewById(R.id.activity_toolbar);

        toolbar_textView = (TextView) findViewById(R.id.toolbar_textView);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getWindow().setEnterTransition(makeEnterTransition());
        getWindow().setExitTransition(makeExitTransition());

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("MapActivity", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("MapActivity", "onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("MapActivity", "onSaveInstanceState");
    }

    @Override
    public void onRestoreInstanceState(Bundle outState) {
        super.onRestoreInstanceState(outState);
        Log.i("MapActivity", "onRestoreInstanceState");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("MapActivity", "onStop");
    }

    public void startSearchActivity() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                supportFinishAfterTransition();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static Transition makeEnterTransition() {
        Transition fade = new Fade();
        fade.excludeTarget(android.R.id.navigationBarBackground, true);
        fade.excludeTarget(android.R.id.statusBarBackground, true);
        return fade;
    }

    public static Transition makeExitTransition() {
        Transition fade = new Fade();
        fade.excludeTarget(android.R.id.navigationBarBackground, true);
        fade.excludeTarget(android.R.id.statusBarBackground, true);
        return fade;
    }

}

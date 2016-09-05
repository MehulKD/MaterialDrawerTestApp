package mapwize.io.mapwize;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;

public class MapActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Drawer drawer;
    private TextView toolbar_textView;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MapActivity", "onCreate");
        setContentView(R.layout.activity_map);

        toolbar = (Toolbar) findViewById(R.id.activity_toolbar);
        drawer = new DrawerBuilder().withActivity(this).withToolbar(toolbar).build();
        //drawer.getDrawerLayout().setFitsSystemWindows(false);

        toolbar_textView = (TextView) findViewById(R.id.toolbar_textView);
        toolbar_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleHideyBar();
            }
        });

        linearLayout = (LinearLayout) findViewById(R.id.toolbar_layout);
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
        Intent intent = new Intent(this, SearchActivity.class);
        ActivityOptions options = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            options = ActivityOptions
                    .makeSceneTransitionAnimation(this, linearLayout, "transition");
            startActivity(intent, options.toBundle());
        }

        // start the new activity
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

    public void toggleHideyBar() {

        // The UI options currently enabled are represented by a bitfield.
        // getSystemUiVisibility() gives us that bitfield.
        int uiOptions = getWindow().getDecorView().getSystemUiVisibility();
        int newUiOptions = uiOptions;
        boolean isImmersiveModeEnabled =
                ((uiOptions | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) == uiOptions);
        if (isImmersiveModeEnabled) {
            Log.i("bit", "Turning immersive mode mode off. ");
        } else {
            Log.i("bit", "Turning immersive mode mode on.");
        }

        // Navigation bar hiding:  Backwards compatible to ICS.
        if (Build.VERSION.SDK_INT >= 14) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }

        // Status bar hiding: Backwards compatible to Jellybean
        if (Build.VERSION.SDK_INT >= 16) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_FULLSCREEN;
        }

        // Immersive mode: Backward compatible to KitKat.
        // Note that this flag doesn't do anything by itself, it only augments the behavior
        // of HIDE_NAVIGATION and FLAG_FULLSCREEN.  For the purposes of this sample
        // all three flags are being toggled together.
        // Note that there are two immersive mode UI flags, one of which is referred to as "sticky".
        // Sticky immersive mode differs in that it makes the navigation and status bars
        // semi-transparent, and the UI flag does not get cleared when the user interacts with
        // the screen.
        if (Build.VERSION.SDK_INT >= 18) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        }

        getWindow().getDecorView().setSystemUiVisibility(newUiOptions);
    }

}

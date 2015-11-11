package com.example.autoadjustmentlayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.compoundview.autoadjustmentlayout.AutoAdjustmentLayout;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        AutoAdjustmentLayout autoAdjustmentView = (AutoAdjustmentLayout) findViewById(R.id.autoAdjustmentView);
        autoAdjustmentView.setElementList(getRandomItems(20));
        autoAdjustmentView.isRemovable(true);
        autoAdjustmentView.setAutoAdjustmentLayoutListener(new AutoAdjustmentLayout.IOnAutoAdjustmentLayoutListener() {
            @Override
            public void onLastItemRemoved(View view) {
                Snackbar.make(view, "That's all !!!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }

            @Override
            public void onItemRemoved(View view) {
                Snackbar.make(view, "Removed view: " + ((TextView) view).getText(), Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

//        autoAdjustmentView.addElement(getTextView(156, new Random(), 2));
    }


    @NonNull
    private ArrayList<Object> getRandomItems(int count) {
        int prevTextViewId = 0;
        Random rnd = new Random();
        ArrayList<Object> items = new ArrayList<>();
        for (int i = 0; i < count; i++) {
//            final TextView textView = getTextView(prevTextViewId, rnd, i);
            TextView textView = getTextView(i);
            items.add(textView);
        }
        return items;
    }

//    @NonNull
//    private TextView getTextView(int prevTextViewId, Random rnd, int i) {
//        final TextView textView = new TextView(this);
//        textView.setPadding(5, 5, 5, 5);
//        textView.setText("Text " + i);
//        textView.setTextColor(rnd.nextInt() | 0xff000000);
//        int curTextViewId = prevTextViewId + 1;
//        textView.setId(curTextViewId);
//        return textView;
//    }

    @NonNull
    private TextView getTextView(int viewId) {
        final TextView textView = new TextView(this);
        int sdk = android.os.Build.VERSION.SDK_INT;
        if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            textView.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.tv_background));
        } else {
            textView.setBackground(ContextCompat.getDrawable(this, R.drawable.tv_background));
        }
        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        llp.setMargins(5, 5, 5, 5); // llp.setMargins(left, top, right, bottom);
        textView.setLayoutParams(llp);

        textView.setId(viewId);
        if (viewId == 1) {
            textView.setText("test");
        } else if (viewId == 2) {
            textView.setText("testtest");
        } else if (viewId == 3) {
            textView.setText("te");
        } else if (viewId == 4) {
            textView.setText("test");
        } else if (viewId == 5) {
            textView.setText("testtesttest");
        } else if (viewId == 6) {
            textView.setText("test");
        } else if (viewId == 7) {
            textView.setText("testte");
        } else if (viewId == 8) {
            textView.setText("testtesttesttest");
        } else {
            textView.setText("test");
        }

        textView.setTextSize(12);

        return textView;
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

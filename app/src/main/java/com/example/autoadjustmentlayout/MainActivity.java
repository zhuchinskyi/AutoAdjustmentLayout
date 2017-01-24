package com.example.autoadjustmentlayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.compoundview.autoadjustmentlayout.AutoAdjustmentLayout;
import com.compoundview.autoadjustmentlayout.Util;

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

        autoAdjustmentView.addElement(getTextView(156, new Random(), 2));
    }


    @NonNull
    private ArrayList<Object> getRandomItems(int count) {
        int prevTextViewId = 0;
        Random rnd = new Random();
        ArrayList<Object> items = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            TextView textView = getTextView(prevTextViewId, rnd, i);
            items.add(textView);
        }
        return items;
    }

    @NonNull
    private TextView getTextView(int prevTextViewId, Random rnd, int i) {
        final TextView textView = new TextView(this);
        int inPxPadding = Util.dpToPx(5);
        textView.setPadding(inPxPadding, inPxPadding, inPxPadding, inPxPadding);
        textView.setText("Text " + i);
        textView.setTextColor(rnd.nextInt() | 0xff000000);
        int curTextViewId = prevTextViewId + 1;
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, Util.dpToPx(50)));
        textView.setLayoutParams(lp);
        textView.setId(curTextViewId);
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

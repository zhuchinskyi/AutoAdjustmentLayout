package com.compoundview.autoadjustmentlayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Compound view to build views with auto adjustment according to views parent layout width
 * <p/>
 * Created by d.zhuchinskiy on 11/6/15.
 */
public class AutoAdjustmentLayout extends LinearLayout {

    private String TAG = "AutoAdjustmentLayout";

    int mWidth;
    int mHeight;

    LinearLayout mTmpLayout;

    Context mContext;

    ArrayList<Object> mElementList;

    boolean mIsRemovable = false;

    private IOnAutoAdjustmentLayoutListener mAutoAdjustmentLayoutListener;


    public AutoAdjustmentLayout(Context context) {
        super(context);
        initializeViews(context);
    }

    public AutoAdjustmentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }


    /**
     * Set orientation, etc.
     *
     * @param context the current mContext for the view.
     */
    private void initializeViews(Context context) {
        setOrientation(VERTICAL);
        this.mContext = context;
    }


    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        Log.i(TAG, "onWindowFocusChanged");

        updateSizeInfo();

        if (mElementList != null)
            buildView(mElementList);


    }

    /**
     * @ Recalculate width and height of view.
     */
    private void updateSizeInfo() {
        mWidth = getWidth();
        mHeight = getHeight();
        Log.v(TAG, mWidth + "-" + mHeight);
    }

    /**
     * @ Building current view according to input and layout params.
     */
    private void buildView(final ArrayList<Object> items) {
        removeAllViews();

        int currentTextViewSizeInLine = 0;

        mTmpLayout = getLinearLayout();

        addView(mTmpLayout);

        for (int i = 0; i < items.size(); i++) {
            TextView textView = (TextView) items.get(i);

            if (mIsRemovable) {
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ArrayList newArrayList = (ArrayList) items.clone();

                        newArrayList.remove(v);

                        if (newArrayList.size() > 0) {
                            mAutoAdjustmentLayoutListener.onItemRemoved(v);
                        } else {
                            mAutoAdjustmentLayoutListener.onLastItemRemoved(v);
                        }

                        buildView(newArrayList);

                    }
                });
            }

            textView.measure(0, 0);       //must call measure!
            int currTvWidth = textView.getMeasuredWidth();  //get mHeight
            int tvHeight = textView.getMeasuredHeight(); //get mWidth

            LinearLayout ll = (LinearLayout) textView.getParent();
            if (ll != null)
                ll.removeView(textView);

            if ((currentTextViewSizeInLine + currTvWidth) >= mWidth) {
                Log.i(TAG, "NEW LINE i: " + i);
                mTmpLayout = getLinearLayout();
                addView(mTmpLayout);
                currentTextViewSizeInLine = 0;
            }

            mTmpLayout.addView(textView);
            currentTextViewSizeInLine += currTvWidth;

            Log.i(TAG, "currentTextViewSizeInLine: " + currentTextViewSizeInLine + ", mWidth: " + mWidth);
        }
    }


    /**
     * @param elementList ArrayList of Object type to render with auto adjustment. Throws NullPointerException if null passed.
     */
    public void setElementList(ArrayList<Object> elementList) throws NullPointerException {
        if (elementList == null)
            throw new NullPointerException("You can't set null");
        this.mElementList = elementList;
    }

    /**
     * @param element Singe Object that will be added to the end.
     */
    public void addElement(Object element) {
        if (element != null) {
            mElementList.add(element);
            buildView(mElementList);
        }
    }

    /**
     * @param element Singe Object that will be added to the end.
     * @return true if item has been removed, false otherwise
     * @throws NullPointerException if you pass null object
     */
    public boolean removeElement(Object element) throws NullPointerException {
        if (element != null) {
            if (mElementList.remove(element)) {
                buildView(mElementList);
                return true;
            }
        } else {
            throw new NullPointerException("Null object not allowed");
        }
        return false;
    }

    /**
     * @param elementList ArrayList of Object type that will be added to the end.
     */
    public void addElementList(ArrayList<Object> elementList) {
        if (mElementList == null) {
            mElementList = new ArrayList<>();

        }

        if (elementList != null) {
            mElementList.addAll(elementList);
            buildView(mElementList);
        }
    }

    /**
     * @return ArrayList of Object that currently displays, null otherwise.
     */
    public ArrayList<Object> getmElementList() {
        return mElementList;
    }


    @NonNull
    private LinearLayout getLinearLayout() {
        LinearLayout tmpLayout = new LinearLayout(mContext);
        tmpLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        tmpLayout.setOrientation(LinearLayout.HORIZONTAL);
        tmpLayout.setId(new Random().nextInt());
        return tmpLayout;
    }


    public interface IOnAutoAdjustmentLayoutListener {
        /**
         * @ @param view which was removed
         */
        void onItemRemoved(View view);

        /**
         * @param view last view which was removed
         */
        void onLastItemRemoved(View view);
    }

    public void setAutoAdjustmentLayoutListener(IOnAutoAdjustmentLayoutListener autoAdjustmentLayoutListener) {
        this.mAutoAdjustmentLayoutListener = autoAdjustmentLayoutListener;
    }

    /**
     * @param isRemovable detect if elements are removable onClick. Default false.
     */
    public void isRemovable(boolean isRemovable) {
        this.mIsRemovable = isRemovable;
    }
}

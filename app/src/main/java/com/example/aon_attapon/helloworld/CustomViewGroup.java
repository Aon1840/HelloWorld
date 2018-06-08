package com.example.aon_attapon.helloworld;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.Button;
import android.widget.FrameLayout;

public class CustomViewGroup extends FrameLayout{

    private Button btnHello;

    public CustomViewGroup(@NonNull Context context) {
        super(context);
        initInflate();
        initInstance();
    }

    public CustomViewGroup(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstance();
    }

    public CustomViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstance();
    }

    public CustomViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstance();
    }

    private void initInflate() {
        inflate(getContext(), R.layout.sample_layout, this);
    }

    private void initInstance(){
        //findViewById
        btnHello = (Button) findViewById(R.id.btnCustomeViewGroupHello);
    }

    public void setButtonText(String text){
        btnHello.setText(text);
    }

    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) { //call this method before call onSaveInstanceState
        dispatchFreezeSelfOnly(container); //save only your self(CustomViewGroup) do not find any view inside
    }

    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dispatchThawSelfOnly(container); // restore only your self(CustomViewGroup) do not restore any view inside
    }

    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        //Save Children's state as a Bundle
        Bundle childrenStates = new Bundle();
        for(int i = 0; i < getChildCount(); i++){
            int id = getChildAt(i).getId();
            if(id != 0){
                SparseArray childrenState = new SparseArray();
                getChildAt(i).saveHierarchyState(childrenState);
                childrenStates.putSparseParcelableArray(String.valueOf(id),childrenState);
            }
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("childrenStates",childrenStates);

        //Save it to Parcelable
        BundleSavedState ss = new BundleSavedState(superState);
        ss.setBundle(bundle);

        return ss;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        BundleSavedState ss = (BundleSavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        //Restore sparseArray
        Bundle childrenStates = ss.getBundle().getBundle("childrenStates");

        //Restore Children's state
        for (int i = 0; i < getChildCount(); i++){
            int id = getChildAt(i).getId();
            if(id != 0){
                if(childrenStates.containsKey(String.valueOf(id))){
                    SparseArray childrenState = childrenStates.getSparseParcelableArray(String.valueOf(id));
                    getChildAt(i).restoreHierarchyState(childrenState);
                }
            }
        }
    }
}

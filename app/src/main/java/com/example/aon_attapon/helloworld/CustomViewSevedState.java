package com.example.aon_attapon.helloworld;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

public class CustomViewSevedState extends View.BaseSavedState {

    private boolean blue;

    public boolean isBlue() {
        return blue;
    }

    public void setBlue(boolean blue) {
        this.blue = blue;
    }

    public CustomViewSevedState(Parcel source) {
        super(source);
        //read back
        blue = source.readInt() == 1;
    }

    public CustomViewSevedState(Parcelable superState) { //method like a create big box for put the parcelable box
        super(superState);
    }

    @Override
    public void writeToParcel(Parcel out, int flags) { //method for put anything to this big box
        super.writeToParcel(out, flags);
        //write var here
        out.writeInt(blue ? 1 : 0);

    }

    public static final Creator CREATOR = new Creator() {
        @Override
        public Object createFromParcel(Parcel source) {
            return new CustomViewSevedState(source);
        }

        @Override
        public Object[] newArray(int size) {
            return new CustomViewSevedState[size];
        }
    };
}

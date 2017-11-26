package com.Amr.android.miwok;

import android.util.Log;

/**
 * Created by Amrh on 7/24/2017.
 */

public class word {
    private static final String TAG = "word.activity" ;
    //  كلاس اسمه word عشان يستخدم الكونستراكتور بتاعه في انه يدخل القيم بسرعه لما يجي يستعدي الكلاس
//وعلي فكره هو مربوط ب arraylist
    private String mDafaulttranslation;
    private String mMiwoktranslation;
    private int mMiwokimage = NO_IMAGE_PROVIDED;
    private int mAudio;
    private static final int NO_IMAGE_PROVIDED = -1;




    @Override
    public String toString() {
        return "word{" +"mDafaulttranslation='" + mDafaulttranslation + '\'' + ", mMiwoktranslation='" + mMiwoktranslation + '\'' +
                ", mMiwokimage=" + mMiwokimage +
                ", mAudio=" + mAudio + '}';
    }

    public word(String Dafaulttranslation, String Miwoktranslation, int Miwokimage , int audio) {
        mDafaulttranslation = Dafaulttranslation;
        mMiwoktranslation = Miwoktranslation;
        mMiwokimage = Miwokimage;
        mAudio = audio ;
    }
//  كونستراكتور تاني بقيمتين بس عشان يستخدمه في خانه حاجه تانيه يبقي مش 3
// يعني وممكن نعمل عدد لا نهائي يعني بس يكون في تغيير في عدد القيم او انواعها

    public word(String mDafaulttranslation, String sMiwoktranslation , int audio) {
        this.mDafaulttranslation = mDafaulttranslation;
        //why this? i think @this@ here called
        // puplic varaibl mDafaulttranslation = local variable beta3 constractor 3ashan el 2 zy ba3d
        // عملت مره كدا ومره كدا عشان اجرب لما غيرت الاسم بتاع الاوكال عادي هي هي
        mMiwoktranslation = sMiwoktranslation;
        mAudio = audio;
    }

    public String getmDafaulttranslation() {
        return mDafaulttranslation;
    }

    public String getmMiwoktranslation() {
        return mMiwoktranslation;
    }

    public int getmMiwokimage()
    {
    //    Log.d("myTAG", "Value: " + Float.toString(mMiwokimage) );
        return mMiwokimage;
    }

    public int getmMiwokAudio()
    {

        return mAudio;
    }

    public boolean hasImage() {



        return mMiwokimage != NO_IMAGE_PROVIDED;
    }
    public void test(){ // هنا كنت بجرب بس اللوج
    int s = 2625;
    Log.d("myTAG", "Value: " + Double.toString(mMiwokimage) );}





}


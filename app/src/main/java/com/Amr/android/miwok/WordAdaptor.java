package com.Amr.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Amrh on 7/25/2017.
 * UDACITY Course android multi 2.26
 */

public class WordAdaptor extends ArrayAdapter<word> {

    //لو عايز تتعمق اكتر في الليست فيو شوف الفيديو دة
    // https://www.youtube.com/watch?v=wDBM6wVEO70


    int mColorResourceId;

    public WordAdaptor(@NonNull Activity context, @NonNull List<word> objects , int ColorResourceId ) {
        super(context,0, objects);
        mColorResourceId= ColorResourceId;;
    }
    //getview sha3'ala enha teb3at el view lel list be belshakel el matlob ele how 2 text with 1 image for exp
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //ميثود اللي هعدل فيها عشان يبقي في كذا view بدل ان الميثود بتتعامل مع singleView

        // Check if the existing view is being reused, otherwise inflate the view
        //View listItemView = convertView;
        if (convertView == null) { //احنا المفروض هنرجع الفيو فاضي عشان هو هيرجع تيكست واحدة فلو هو فاضي متظهروش حاجة كدا (وهو في الاصل فاضي لان احنا مرجعين فوق 0 او null
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false); //بينفخ شكل الitem في الليست
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        word currentWord = getItem(position); //بيساوي اوبجيكت من كلاس بقيمه ميثود من كلاس تاني تقريبا???????
        // Find the TextView in the list_item.xml layout with the ID version_name
        Log.e("Amr" , currentWord.toString());
        TextView upperTextView = (TextView) convertView.findViewById(R.id.first_text); //تقريبا بنكتب convertview)(dot)عشان انا محتاج ارجعها للattr اللي اسمها View فوق
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        upperTextView.setText(currentWord.getmMiwoktranslation());

        TextView nameTextView = (TextView) convertView.findViewById(R.id.second_text);  /////////////////////////////////
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentWord.getmDafaulttranslation());

        ImageView image = (ImageView) convertView.findViewById(R.id.imageView);


        if (currentWord.hasImage()){

            image.setImageResource(currentWord.getmMiwokimage());
            image.setVisibility(View.VISIBLE);
        } else {

            // Otherwise hide the ImageView (set visibility to GONE)
            image.setVisibility(View.GONE);
        }
        View textContainer = convertView.findViewById(R.id.text_container); // لون لكل اكتيفتي
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return convertView;
    }
}
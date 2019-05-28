package kr.co.retailtech.mybecon;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.zechassault.zonemap.view.NoteImageView;
/**
 * TODO: document your custom view class.
 */
public class MyView extends FrameLayout {
    public MyView(Context context) {
        super(context);
        init(null, 0);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    ImageView iv;
    private void init(AttributeSet attrs, int defStyle) {
        // Update TextPaint and text measurements from attributes
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(infService);
        View v = li.inflate(R.layout.sample_my_view, this, false);
        addView(v);

        NoteImageView mapView = v.findViewById(R.id.imageMap);



        iv = v.findViewById(R.id.imageMapPosition);
        iv.setX(300);
        iv.setY(600);


    }


}

package com.dynamitechetan.fogviewlibrary;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class FogView extends View {

    private boolean isMove = false;
    private Bitmap bitmap = null;
    private Bitmap frontBitmap = null;
    private Path path;
    private Canvas mCanvas;
    private Paint paint;
    private int mIcon;
    private int Stroke_width;

    public FogView(Context context, AttributeSet attrs) {
        super(context, attrs);


        TypedArray a = getContext().obtainStyledAttributes(attrs,R.styleable.fog,0, 0);

        mIcon = a.getResourceId(R.styleable.fog_fog_image, R.drawable.fog);
        Stroke_width = a.getInt(R.styleable.fog_stroke_width,75);

    }
    @Override
    protected void onDraw(Canvas canvas) {

        if (mCanvas == null) {
            EraseBitmp();
        }
        canvas.drawBitmap(bitmap, 0, 0, null);
        mCanvas.drawPath(path, paint);//Draw a path
        super.onDraw(canvas);
    }

    public void EraseBitmp() {

        bitmap = Bitmap.createBitmap(getWidth(),getHeight(), Bitmap.Config.ARGB_4444);

//        frontBitmap = CreateBitmap(Color.GRAY,getWidth(),getHeight());//The production of grey.
            frontBitmap = BitmapFactory.decodeResource(getResources(), mIcon).copy(Bitmap.Config.ARGB_8888, true);
        //Set the brush style
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);//Set the brush style: Hollow
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));//Display mode settings when photo cross
        paint.setAntiAlias(true);//Anti according to tooth
        paint.setDither(true);//Anti jitter
        paint.setStrokeJoin(Paint.Join.ROUND);//Set the joint appearance, ROUND arc
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(Stroke_width);//Set the stroke width

        path = new Path();

        mCanvas = new Canvas(bitmap);//Set up a band picture of canvas
        mCanvas.drawBitmap(frontBitmap, 0, 0,null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub

        float ax = event.getX();
        float ay = event.getY();

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            isMove = false;
            path.reset();
            path.moveTo(ax, ay);
            invalidate();
            return true;
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            isMove = true;
            path.lineTo(ax,ay);
            invalidate();
            return true;
        }
        return super.onTouchEvent(event);
    }

    public  Bitmap CreateBitmap(int color,int width, int height) {
        int[] rgb = new int [width * height];

        for (int i=0;i<rgb.length;i++) {
            rgb[i] = color;
        }
        return Bitmap.createBitmap(rgb, width, height, Bitmap.Config.ARGB_8888);
    }

}
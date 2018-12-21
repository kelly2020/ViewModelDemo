package viewmodel.wondersgroup.com.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomDrawableView extends View {
  private ShapeDrawable mDrawable;

  public CustomDrawableView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  public CustomDrawableView(Context context, @Nullable AttributeSet attrs) {
    this(context, attrs,0);
    int x = 10;
    int y = 10;
    int width = 300;
    int height = 50;

    mDrawable = new ShapeDrawable(new OvalShape());
    // If the color isn't set, the shape uses black as the default.
    mDrawable.getPaint().setColor(0xff74AC23);
    // If the bounds aren't set, the shape can't be drawn.
    mDrawable.setBounds(x, y, x + width, y + height);
  }

//
  public CustomDrawableView(Context context) {
    this(context,null);
  }

  protected void onDraw(Canvas canvas) {
    mDrawable.draw(canvas);
  }
}
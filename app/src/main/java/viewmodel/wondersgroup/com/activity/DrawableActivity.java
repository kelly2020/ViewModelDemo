package viewmodel.wondersgroup.com.activity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import viewmodel.wondersgroup.com.R;
import viewmodel.wondersgroup.com.view.MyDrawable;

public class DrawableActivity extends AppCompatActivity {
    @BindView(R.id.image_insert)
    ImageView imageInsert;
    @BindView(R.id.image_clip)
    ImageView imageClip;
    @BindView(R.id.image_transition)
    ImageView imageTranstion;
    @BindView(R.id.image_view4)
    ImageView imageView4;
    @BindView(R.id.image_level)
    ImageView levelImg;

    private int count = 0;

    private boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_drawable);
        ButterKnife.bind(this);

//        imageInsert.setImageResource(R.drawable.ic_launcher_background);
        imageInsert.setAdjustViewBounds(getResources().getBoolean(R.bool.adjust_view_bounds));


//        Drawable drawable = ResourcesCompat.getDrawable(this.getResources(), R.drawable.clip, null);
        ClipDrawable drawable = (ClipDrawable) imageClip.getDrawable();
        drawable.setLevel(drawable.getLevel() + 5000);


//        imageClip.setImageDrawable(drawable);

//        final TransitionDrawable transition = (TransitionDrawable) ResourcesCompat.getDrawable(this.getResources(), R.drawable.transition, null);
         final TransitionDrawable transition = (TransitionDrawable) imageTranstion.getDrawable();

        imageTranstion.setImageDrawable(transition);

//        transition.startTransition(500);

        flag = getResources().getBoolean(R.bool.bool_true);
        imageTranstion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (flag){
                    transition.reverseTransition(200);
                    flag = false;
                } else {
                    transition.startTransition(200);
                    flag = true;
                }

            }
        });

        MyDrawable mydrawing = new MyDrawable();
        imageView4.setImageDrawable(mydrawing);


        AnimatorSet animator = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.property_animator);
        animator.setTarget(imageView4);
        animator.start();


        levelImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;

                if (count == 1) {
                    levelImg.setImageLevel(1);
                } else if (count == 2) {
                    levelImg.setImageLevel(2);
                } else if (count == 3) {
                    levelImg.setImageLevel(3);
                }
            }
        });

    }
}

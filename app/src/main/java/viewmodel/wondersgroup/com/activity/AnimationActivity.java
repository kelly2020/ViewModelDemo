package viewmodel.wondersgroup.com.activity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import viewmodel.wondersgroup.com.R;

public class AnimationActivity extends AppCompatActivity {
    @BindView(R.id.button_animation)
    Button animBtn;
    @BindView(R.id.image_animation_list)
    ImageView animationImg;
    @BindView(R.id.button_anim_mix)
    Button animMixBtn;
    @BindView(R.id.text_view_string)
    TextView stringView;
    @BindView(R.id.text_view_string1)
    TextView string1View;
    @BindView(R.id.text_view_string2)
    TextView string2View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        ButterKnife.bind(this);

        stringView.setText(Html.fromHtml(getResources().getString(R.string.welcome1)));
        string1View.setText(String.format(getResources().getString(R.string.welcome_messages_normal),"张三",10));
        String text = String.format(getResources().getString(R.string.welcome_messages), "李思", 3);
        CharSequence styledText = Html.fromHtml(text);
        string2View.setText(styledText);


    }

    @OnClick({R.id.button_animation, R.id.image_animation_list, R.id.button_anim_mix})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_animation:
                Animation animation = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.hyperspace_jump);

                animBtn.startAnimation(animation);

                break;
            case R.id.image_animation_list:
                AnimationDrawable animatable = (AnimationDrawable) animationImg.getBackground();
                animatable.start();

                break;
            case R.id.button_anim_mix:
//                Animation viewAnim = AnimationUtils.loadAnimation(this, R.anim.view_anim);
//                animMixBtn.startAnimation(viewAnim);
//                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(animMixBtn, "translationX", 40);
//                objectAnimator.setDuration(300);
//                objectAnimator.start();


                AnimatorSet animator1 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.property_animator);

                animator1.setTarget(animMixBtn);

                animator1.start();
//                AnimatorSet animator = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.property_animator);
//                animator.setTarget(animMixBtn);
//                animator.start();

                break;
        }
    }
}

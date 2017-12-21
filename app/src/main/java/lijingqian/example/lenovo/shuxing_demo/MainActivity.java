package lijingqian.example.lenovo.shuxing_demo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Handler handler;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv= (ImageView) findViewById(R.id.iv);
        //透明
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(iv, "alpha", 1f, 0f, 1f);
        //旋转
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(iv, "rotation", 0f, 0f, 360f);
        //平移
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv, "translationY", 0f, 0f, 300f);
        //缩放
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(iv, "scaleY", 1f, 2f, 1f);
        AnimatorSet set = new AnimatorSet();
        set.play(animator2).with(animator1).with(animator).with(scaleYAnimator);
        set.setDuration(3000);
        set.start();

        handler=new Handler() ;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                            startActivity(intent);
                            finish();
                        }

                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}

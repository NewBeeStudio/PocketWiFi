package newbeestudio.pocketwifi;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class welcome extends Activity implements AnimationListener{
    private ImageView  imageView = null;
    private Animation alphaAnimation = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        imageView = (ImageView)findViewById(R.id.imageView);
        alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.welcome_alpha);
        alphaAnimation.setFillEnabled(true); //启动Fill保持
        alphaAnimation.setFillAfter(true);  //设置动画的最后一帧是保持在View上面
        imageView.setAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(this);  //为动画设置监听


    }




    @Override
    public void onAnimationEnd(Animation arg0) {
        // TODO Auto-generated method stub

        Intent  intent=new Intent(welcome.this,MainActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void onAnimationRepeat(Animation animation) {
        // TODO Auto-generated method stub

    }


    @Override
    public void onAnimationStart(Animation animation) {
        // TODO Auto-generated method stub

    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //在欢迎界面屏蔽BACK键
        if(keyCode==KeyEvent.KEYCODE_BACK) {
            return false;
        }
        return false;
    }



}

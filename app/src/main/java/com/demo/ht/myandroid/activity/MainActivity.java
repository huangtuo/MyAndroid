package com.demo.ht.myandroid.activity;

import android.Manifest;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatButton;
import android.view.ViewTreeObserver;
import android.widget.Button;


import com.demo.ht.myandroid.R;
import com.demo.ht.myandroid.base.BaseActivity;
import com.demo.ht.myandroid.dagger.bean.Pot;
import com.demo.ht.myandroid.dagger.component.DaggerDaggerTestComponent;
import com.demo.ht.myandroid.dagger.component.DaggerFlowerComponent;
import com.demo.ht.myandroid.dagger.component.DaggerPotComponent;
import com.demo.ht.myandroid.jni.JniUtil;
import com.demo.ht.myandroid.service.GrayService;
import com.demo.ht.myandroid.widget.StepsView;
import com.demo.ht.myandroid.widget.XCDropDownListView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.main_btn_fullSu)
    Button btnFullS;
    @BindView(R.id.main_btn_flowlayout)
    Button btnFlowlayout;
    @BindView(R.id.main_btn_callPhone)
    Button btnCallPhone;
    @BindView(R.id.main_btn_kotlin)
    AppCompatButton btnKotlin;
    @BindView(R.id.main_btn_service)
    AppCompatButton btnService;
    @BindView(R.id.main_btn_view)
    AppCompatButton btnView;
    @BindView(R.id.main_btn_dagger)
    AppCompatButton btnDagger;
    @BindView(R.id.main_btn_arithmetic)
    AppCompatButton btnArithmetic;
    @BindView(R.id.main_btn_toWeb)
    AppCompatButton btnOpenOther;
    @BindView(R.id.drop_down_list_view)
    XCDropDownListView dropDownListView;

    private boolean isBindService = false;
    @Inject
    Pot pot;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initBundleData() {

    }

    @Override
    protected void initView() {
        setListener();

        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0;i< 6;i++){
            list.add("下拉列表项"+(i+1));
        }
        dropDownListView.setItemsData(list);
    }

    @Override
    protected void initData() {

    }
    private void setListener() {


        btnFullS.setOnClickListener(view -> {
//            Intent intent = new Intent(MainActivity.this, FullScreenActivity.class);
//            startActivity(intent);
            showToast("返回：" + new JniUtil().getKey());
        });

        btnCallPhone.setOnClickListener(view -> {
//            callPermission(Manifest.permission.CALL_PHONE);
//            ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
//            showToast(manager.getMemoryClass() + "M");
            showToast("返回：" + new JniUtil().getKey().length());
        });
        btnKotlin.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, KotlinActivity.class);
            startActivity(intent);
        });

        btnCallPhone.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() { //实现这个监听可以获取到 控件的宽、高
                btnCallPhone.getWidth();
                btnCallPhone.getHeight();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    btnCallPhone.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        });
        btnService.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, GrayService.class);
            if(isBindService){
                //绑定服务
                bindService(intent, connection, BIND_AUTO_CREATE);
            }else{
                startService(intent);
//                Intent blackIntent = new Intent();
//                blackIntent.setAction("com.wake.gray");
//                sendBroadcast(blackIntent);
            }

        });

        btnView.setOnClickListener(view -> {
            startActivity(new Intent(this, SetpsViewActivity.class));
        });

        btnDagger.setOnClickListener( v -> {
//            DaggerDaggerTestComponent.create().inject(MainActivity.this);
            DaggerDaggerTestComponent.builder().potComponent(DaggerPotComponent.builder()
                                    .flowerComponent(DaggerFlowerComponent.create())
                                    .build()).build().inject(this);
            String str = pot.show();
            showToast(str);
        });

        btnArithmetic.setOnClickListener(v -> {
            startActivity(new Intent(this, ArithmeticHomeActivity.class));
        });

        btnOpenOther.setOnClickListener(v -> {
            startActivity(new Intent(this, WebViewActivity.class));
        });

    }

    private void threadUI(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    btnCallPhone.setText("123213");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    private void callPermission(String permission) {
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {
                new AlertDialog.Builder(this).setTitle("提示")
                        .setMessage("获取拨打电话权限")
                        .setPositiveButton("授权", (dialogInterface, i) -> {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{permission}, 1001);
                        })
                        .setNegativeButton("放弃", null)
                        .create()
                        .show();
            } else {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{permission}, 1001);
            }
        } else {
            callPhone();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1001) {
            if (permissions[0] == Manifest.permission.CALL_PHONE) {
                callPhone();
            } else {
                showToast("未获取到权限");
            }

            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void callPhone() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:10086");
        intent.setData(data);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

            return;
        }
        startActivity(intent);
    }

    GrayService.MyBinder myBinder;
    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myBinder = (GrayService.MyBinder) iBinder;
            if(myBinder != null){
                myBinder.toWork();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onDestroy() {
        Intent intent = new Intent(MainActivity.this, GrayService.class);
        if(isBindService){
            unbindService(connection);
        }else{
//            stopService(intent);
        }

        super.onDestroy();
    }


    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        switch (level){
            case TRIM_MEMORY_UI_HIDDEN:
                //释放内存
                break;
        }
    }

}

package com.bhl.testsystembartint;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			setTranslucentStatus(true);
		}
		SystemBarTintManager tintManager = new SystemBarTintManager(this);
		// 设置状态栏是否可以改变颜色
		tintManager.setStatusBarTintEnabled(true);
		// 设置导航栏是否可以改变颜色
		tintManager.setNavigationBarTintEnabled(true);

		tintManager.setStatusBarTintColor(Color.parseColor("#0000FF"));
		// 给所有的沉浸栏设置一个颜色
//		tintManager.setTintColor(Color.parseColor("#99000FF"));
		// 设置一个自定义导航栏的资源
//		tintManager.setNavigationBarTintResource(R.drawable.my_tint);
		// 设置自定义状态栏的资源
//		tintManager.setStatusBarTintDrawable(MyDrawable);
	}

	@TargetApi(19)
	private void setTranslucentStatus(boolean on) {
		Window win = getWindow();
		WindowManager.LayoutParams winParams = win.getAttributes();
		final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
		if (on) {
			winParams.flags |= bits;
		} else {
			winParams.flags &= ~bits;
		}
		win.setAttributes(winParams);
	}
}

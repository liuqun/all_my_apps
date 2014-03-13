package com.example.Android_Button_Test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.util.Stack;

public class MainActivity extends Activity implements View.OnClickListener {
	private final int DEFAULT_INITIAL_VALUE=0;
	int mVal;
	private Stack<Integer> mHistory;
//	private EditText tmp; // TODO: Try EditText to take place the old TextView widget
	private TextView mResult;
	private View mBtnRevert;
	/**
	 *
	 */
	@Override
	public void onCreate(Bundle icircle) {
		super.onCreate(icircle);
		setContentView(R.layout.main);
		mBtnRevert = findViewById(R.id.btn_revert);
		mBtnRevert.setEnabled(false);
		// TODO:
		// Restore mVal from database if it already exists
		mVal = DEFAULT_INITIAL_VALUE;
		mHistory = new Stack<Integer>();
		mHistory.push(mVal);
		mResult = (TextView) findViewById(R.id.tv_result);
		mResult.setText(String.valueOf(mVal));
	}
	/**
	 *
	 */
	@Override
	public void onDestroy() {
		super.onDestroy();
		mResult = null;
		mBtnRevert = null;
		// TODO:
		// Save mVal into cached-preferences or database
	}
	/**
	 *
	 */
	public void onClick(View view) {
		final String here = new String("MainActivity.onClick");
//		assert(mHistory!=null && !mHistory.isEmpty());
		if (mHistory==null || mHistory.isEmpty()) {
			Log.d(here, "mHistory==null || mHistory.isEmpty() //mHistory无数据异常情况");
			return;
		}
		switch (view.getId())
		{
		case R.id.btn_plus_1:
			mVal += 1;
			mHistory.push(mVal);
			mResult.setText(String.valueOf(mVal));
			break;
		case R.id.btn_minus_1:
			mVal -= 1;
			if (mVal < 0){
				mVal = 0;
			}
			mHistory.push(mVal);
			mResult.setText(String.valueOf(mVal));
			break;
		case R.id.btn_plus_10:
			mVal += 10;
			mHistory.push(mVal);
			mResult.setText(String.valueOf(mVal));
			break;
		case R.id.btn_minus_10:
			mVal -= 10;
			if (mVal < 0){
				mVal = 0;
			}
			mHistory.push(mVal);
			mResult.setText(String.valueOf(mVal));
			break;
		case R.id.btn_save:
			Log.d(here, "'save' button has been clicked");//TODO
			break;
		case R.id.btn_revert:
			Log.d(here, "'revert' button has been clicked");
//			assert(mHistory!=null && mHistory.size()>1);
			if(mHistory==null || mHistory.size()<=1) {
				Log.d(here, "Error! //当前revert按钮已被按下，可能存在程序逻辑bug");
				mBtnRevert.setEnabled(false);
				break;
			}
//			assert(mHistory!=null && !mHistory.isEmpty());
			mHistory.pop(); // 注：弹出栈顶端后，下一个才是要恢复的值
//			assert(mHistory!=null && !mHistory.isEmpty());
			mVal = mHistory.peek();
			mResult.setText(String.valueOf(mVal));
			break;
		default:
			break;
		}
		mBtnRevert.setEnabled(mHistory.size()>1); // 注：revert按钮只有在可撤销至上一次时才可点击
		return;
	}
}

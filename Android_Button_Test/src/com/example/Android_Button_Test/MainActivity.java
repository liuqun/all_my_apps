package com.example.Android_Button_Test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import java.util.Date;
import java.text.SimpleDateFormat;

public class MainActivity extends Activity implements View.OnClickListener {
	private TextView result;
	private Button btn;
	private SimpleDateFormat converter;
	/**
	 *
	 */
	@Override
	public void onCreate(Bundle icircle) {
		super.onCreate(icircle);
		setContentView(R.layout.main);
		result = (TextView) findViewById(R.id.tv_result);
		btn    = (Button)   findViewById(R.id.btn_update);
		btn.setOnClickListener(this);
		converter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		updateTime();
	}
	/**
	 *
	 */
	@Override
	public void onDestroy() {
		super.onDestroy();
		result = null;
		btn = null;
		converter = null;
	}
	/**
	 *
	 */
	public void onClick(View view) {
		updateTime();
	}
	/**
	 * Update the text value of current time
	 *
	 * @param None
	 * @return None
	 * NOTE: The return value will be stored in the TextView object "result" instead.
	 */
	private void updateTime() {
		result.setText(converter.format(new Date()));
	}
}

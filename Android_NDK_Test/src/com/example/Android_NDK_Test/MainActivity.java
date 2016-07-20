package com.example.Android_NDK_Test;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity{
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		this.setContentView(R.layout.main);
		libjpeg = new com.example.LibJPEG();
		String msg = "EMPTY MESSAGE";
		msg = libjpeg.stringOfVersion();
		if (null == msg) {
			android.util.Log.e("libjpeg", "Fatal Error: Failed to detect libjpeg version");
			System.exit(0);
		}
		android.util.Log.i("libjpeg", msg);
		msg = null;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		libjpeg = null;// FIXME: Never release resources by calling
		               //        init()/destroy() methods
	}

	private com.example.LibJPEG libjpeg;
}

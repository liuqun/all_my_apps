/* encoding="zh_CN.utf-8"
 * File: MainActivity.java
 * Description: ...
 */

package com.example.androidiotest;

// IO Exceptions
import java.io.IOException;
import java.io.FileNotFoundException;

// IO
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.util.ByteArrayBuffer;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * @author 刘群<liuqun68@gmail.com>
 *
 */
public class MainActivity extends Activity implements View.OnClickListener {
	private final String mDATA_FILE_NAME=new String("data.txt");
	private EditText mTextView;
	/**
	 *
	 */
	private String readDataInputStream(InputStream iStream) {
		String s;
		ByteArrayBuffer a = new ByteArrayBuffer(0);
		byte[] buf = new byte[20];
		int n = 0;
		s = "";
		if (null != iStream) {
			while (true){
				try {
					n = iStream.read(buf, 0, buf.length);
				} catch (IOException e2) {
					Log.d("readDataStream(inFileName)", e2.getMessage());
				}
				if (n <= 0) {
					break;
				}
				a.append(buf, 0, n);
			}
			s = new String(a.buffer());
		}
		return s;
	}
	/**
	 * Returns total bytes written into data file, or 0 on special null or empty input values (and flush OutputStream)
	 */
	private int writeDataOutputStream(OutputStream oStream, String s) {
		if (null==oStream) {
			return (-1);
		}
		if (null==s || s.isEmpty())
		{
			try {
				oStream.flush(); // Try to create empty file and flush onto disk
			} catch (IOException e) {
				Log.e("writeData()", e.getMessage());
			}
			return (0);
		}
		byte[] buf = s.getBytes();
		try {
			oStream.write(buf, 0, buf.length);
		} catch (IOException e) {
			Log.e("writeData()", e.getMessage());
			return (0);
		}
		return (buf.length);
	}
	/**
	 *
	 */
	private void closeDataOutputStream(OutputStream oStream) {
		try {
			oStream.close();
		} catch (IOException e) {
			Log.e("closeDataStream()", e.getMessage()); // TODO
		}
		oStream = null;
		return;
	}
	/**
	 *
	 */
	private void closeDataInputStream(InputStream iStream) {
		try {
			iStream.close();
		} catch (IOException e) {
			Log.e("closeDataStream()", e.getMessage()); // TODO
		}
		iStream = null;
		return;
	}
	/**
	 *
	 */
	private OutputStream openDataOutputStream(String fileName, int mode) {
		FileOutputStream oStream=null;
		try {
			oStream = openFileOutput(fileName, mode);
		} catch (FileNotFoundException e) { // TODO "Permission Denied" or "Not enough space on disk"
			oStream = null;
			Log.d("openDataStream(outFileName,mode)", e.getMessage());
		}
		return (oStream);
	}
	private InputStream openDataInputStream(String fileName) {
		FileInputStream iStream;
		try {
			iStream = openFileInput(fileName);
		} catch (FileNotFoundException e) { // TODO "Permission Denied" or "File not exist"
			iStream = null;
			Log.d("openDataStream(inFileName)", e.getMessage());
		}
		return (iStream);
	}
	/**
	 *
	 */
	@Override
	public void onCreate(Bundle icircle) {
		String sData;
		InputStream load;

		super.onCreate(icircle);
		setContentView(R.layout.main);
		sData = null;
		load = null;
		load = openDataInputStream(mDATA_FILE_NAME);
		if (null != load) {
			sData = readDataInputStream(load);
			closeDataInputStream(load);
			load = null;
		}
		mTextView = (EditText) findViewById(R.id.et_text);
		mTextView.setText(sData);
		mTextView.setSelectAllOnFocus(true);
		sData = null;

	}
	/**
	 *
	 */
	@Override
	public void onDestroy() {
		super.onDestroy();
		// TODO:
		// Save data into shared-preferences or other database
		mTextView = null;
	}
	/**
	 *
	 */
	public void onClick(View view) {
		final String HERE = new String("MainActivity.onClick");
		OutputStream save=null;
		String s=null;

		switch (view.getId())
		{
		case R.id.et_text:
			Log.d(HERE, "'EditText' view has been clicked");
			break;
		case R.id.btn_save:
			Log.d(HERE, "'save' button has been clicked");
			s = mTextView.getText().toString();
			Log.d(HERE, "s="+s);
			save = null;
			save = openDataOutputStream(mDATA_FILE_NAME, MODE_PRIVATE);
			if (save != null) {
				writeDataOutputStream(save, s);
				closeDataOutputStream(save);
				save = null;
			}
			break;
		case R.id.btn_delete:
			Log.d(HERE, "'delete' button has been clicked");
			s = "";
			mTextView.setText(s);
			save = null;
			save = openDataOutputStream(mDATA_FILE_NAME, MODE_PRIVATE);
			if (save != null) {
				writeDataOutputStream(save, s);
				closeDataOutputStream(save);
				save = null;
			}
			break;
		default:
			break;
		}
		return;
	}
}

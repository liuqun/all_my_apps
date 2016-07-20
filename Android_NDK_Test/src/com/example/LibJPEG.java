package com.example;

public class LibJPEG {
	public native String stringOfVersion();

	public native String unimplementedMethodFromJNI();// TODO: Implement this method

	static {
		/*
		 * Load library only once. This library has already been unpacked into
		 * /data/data/{App}/lib/lib{XXX}.so at installation time by the package
		 * manager.
		 */
		System.loadLibrary("jpeg-customized");
	}
}

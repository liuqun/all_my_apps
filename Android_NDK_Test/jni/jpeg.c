#include <jni.h>

extern jstring Java_com_example_LibJPEG_stringOfVersion(JNIEnv* env, jobject obj);

jstring Java_com_example_LibJPEG_stringOfVersion(JNIEnv* env, jobject obj)
{
	jstring version;

	version = (*env)->NewStringUTF(env, "libjpeg v6b modifiled by liuqun v2");
	return(version);
}

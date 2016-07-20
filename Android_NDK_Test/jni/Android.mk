LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := jpeg-customized
LOCAL_SRC_FILES := jpeg.c

include $(BUILD_SHARED_LIBRARY)

LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := jpeg
LOCAL_SRC_FILES := jpeg.cpp

include $(BUILD_SHARED_LIBRARY)

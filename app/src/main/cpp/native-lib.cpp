#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_tkid_eastmoney_util_EastMoney_stringFromJNI(
        JNIEnv* env,
        jclass clazz) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
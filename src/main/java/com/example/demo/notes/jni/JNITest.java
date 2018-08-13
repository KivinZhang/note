package com.example.demo.notes.jni;

/**
 * Created by zhangkai on 2018/8/13.
 */
public class JNITest {

    public native boolean initFbxManager();

    public native boolean loadFile(String filePath);
    //
    public native boolean converTriangulate();

    private native float [] getCenterPoint();

    private native Object getModelInfo();


    public static void main(String[] args) {

        System.out.println(System.getProperty("java.library.path"));

    }
}

package com.common.tools.http.utils;

import android.util.Log;

import java.util.Hashtable;

/**
 * 作者：heshuiguang
 * 日期：2021/12/27 11:42 AM
 * 类说明：日志打印
 */
public class HttpLog {

    public static boolean logFlag = true; // true 打开log，false 关闭log
    public final static String	tag	= "httptools";
    private final static int logLevel	= Log.VERBOSE;
    private static Hashtable<String, HttpLog> sLoggerTable = new Hashtable<String, HttpLog>();
    private static HttpLog klog;

    private HttpLog(){
    }

    /**
     * @return HttpLog
     */
    public static HttpLog log(){
        if(klog == null){
            klog = new HttpLog();
        }
        return klog;
    }


    /**
     * Get The Current Function Name
     * @return
     */
    private StackTraceElement[] sts;
    private String getFunctionName(){
        sts = Thread.currentThread().getStackTrace();
        if(sts == null){
            return null;
        }
        for(StackTraceElement st : sts){
            if(st.isNativeMethod()){
                continue;
            }
            if(st.getClassName().equals(Thread.class.getName())){
                continue;
            }
            if(st.getClassName().equals(this.getClass().getName())){
                continue;
            }
            return "[ " + Thread.currentThread().getName() + "; " + st.getFileName() + "; " + st.getLineNumber() + "-line; " + st.getMethodName() + " ]";
        }
        return null;
    }

    /**
     * The Log Level:i
     * @param str
     */
    public void i(Object str){
        if(logFlag){
            if(logLevel <= Log.INFO){
                String name = getFunctionName();
                if(name != null){
                    Log.i(tag, name + " - " + str);
                }else{
                    Log.i(tag, str.toString());
                }
            }
        }
    }

    /**
     * The Log Level:d
     * @param str
     */
    public void d(Object str){
        if(logFlag){
            if(logLevel <= Log.DEBUG){
                String name = getFunctionName();
                if(name != null){
                    Log.d(tag, name + " - " + str);
                }else{
                    Log.d(tag, str.toString());
                }
            }
        }
    }

    /**
     * The Log Level:V
     * @param str
     */
    public void v(Object str){
        if(logFlag){
            if(logLevel <= Log.VERBOSE){
                String name = getFunctionName();
                if(name != null){
                    Log.v(tag, name + " - " + str);
                }else{
                    Log.v(tag, str.toString());
                }
            }
        }
    }

    /**
     * The Log Level:w
     * @param str
     */
    public void w(Object str){
        if(logFlag){
            if(logLevel <= Log.WARN){
                String name = getFunctionName();
                if(name != null){
                    Log.w(tag, name + " - " + str);
                }else{
                    Log.w(tag, str.toString());
                }
            }
        }
    }

    /**
     * The Log Level:e
     * @param str
     */
    public void e(Object str){
        if(logFlag){
            if(logLevel <= Log.ERROR){
                String name = getFunctionName();
                if(name != null){
                    Log.e(tag, name + " - " + str);
                }else{
                    Log.e(tag, str.toString());
                }
            }
        }
    }

    /**
     * The Log Level:e
     * @param ex
     */
    public void e(Exception ex){
        if(logFlag){
            if(logLevel <= Log.ERROR){
                Log.e(tag, "error", ex);
            }
        }
    }

    /**
     * The Log Level:e
     * @param log
     * @param tr
     */
    public void e(String log, Throwable tr){
        if(logFlag){
            String line = getFunctionName();
            Log.e(tag, "{Thread:" + Thread.currentThread().getName() + "}" + "[" + line + ":] " + log + "\n", tr);
        }
    }
    
}

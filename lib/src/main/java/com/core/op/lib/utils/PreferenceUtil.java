package com.core.op.lib.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author op
 * @version 1.0
 * @description
 * @createDate 2016/11/11
 */
public class PreferenceUtil {

    public static final String fileName = "APP_PREFERENCE";

    public static void write(Context context, String k, int v) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putInt(k, v);
        editor.commit();
    }

    public static void write(Context context, String k,
                             boolean v) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putBoolean(k, v);
        editor.commit();
    }

    public static void write(Context context, String k,
                             String v) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putString(k, v);
        editor.commit();
    }


    public static void write(Context context, String fileName, String k, int v) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putInt(k, v);
        editor.commit();
    }

    public static void write(Context context, String fileName, String k,
                             boolean v) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putBoolean(k, v);
        editor.commit();
    }

    public static void write(Context context, String fileName, String k,
                             String v) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putString(k, v);
        editor.commit();
    }

    public static int readInt(Context context, String fileName, String k) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getInt(k, 0);
    }

    public static int readInt(Context context, String fileName, String k,
                              int defv) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getInt(k, defv);
    }

    public static boolean readBoolean(Context context, String fileName, String k) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getBoolean(k, false);
    }

    public static boolean readBoolean(Context context, String fileName,
                                      String k, boolean defBool) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getBoolean(k, defBool);
    }

    public static String readString(Context context, String fileName, String k) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getString(k, null);
    }

    public static String readString(Context context, String fileName, String k,
                                    String defV) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getString(k, defV);
    }

    public static int readInt(Context context, String k) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getInt(k, 0);
    }

    public static int readInt(Context context, String k,
                              int defv) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getInt(k, defv);
    }

    public static boolean readBoolean(Context context, String k) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getBoolean(k, false);
    }

    public static boolean readBoolean(Context context,
                                      String k, boolean defBool) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getBoolean(k, defBool);
    }

    public static String readString(Context context, String k) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getString(k, null);
    }

    public static String readStringWithDefV(Context context, String k,
                                            String defV) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getString(k, defV);
    }

    public static void remove(Context context, String fileName, String k) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.remove(k);
        editor.commit();
    }

    public static void remove(Context context, String k) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.remove(k);
        editor.commit();
    }

    public static void remove(Context context, String... k) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        for (String key : k) {
            editor.remove(key);
        }
        editor.commit();
    }

    public static void clean(Context cxt, String fileName) {
        SharedPreferences preference = cxt.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.clear();
        editor.commit();
    }
}

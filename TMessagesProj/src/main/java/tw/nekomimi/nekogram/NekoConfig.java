package tw.nekomimi.nekogram;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import org.telegram.messenger.ApplicationLoader;
import org.telegram.messenger.FileLog;

public class NekoConfig {

    private static final Object sync = new Object();
    public static boolean useIPv6 = false;
    public static boolean hidePhone = true;
    public static boolean ignoreBlocked = false;
    public static boolean forceTablet = false;
    public static int nameOrder = 1;
    public static boolean nya = false;
    public static String nyaSuffix = "喵";
    public static boolean transparentStatusBar = true;
    public static boolean navigationBarTint = true;
    public static boolean useMessagePanelColor = false;
    private static boolean configLoaded;

    static {
        loadConfig();
    }


    public static void saveConfig() {
        synchronized (sync) {
            try {
                SharedPreferences preferences = ApplicationLoader.applicationContext.getSharedPreferences("nekoconfing", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("useIPv6", useIPv6);
                editor.putBoolean("hidePhone", hidePhone);
                editor.putBoolean("ignoreBlocked", ignoreBlocked);
                editor.putBoolean("forceTablet", forceTablet);
                editor.putInt("nameOrder", nameOrder);
                editor.putBoolean("nya", nya);
                editor.putString("nyaSuffix", nyaSuffix);
                editor.putBoolean("transparentStatusBar", transparentStatusBar);
                editor.putBoolean("navigationBarTint", navigationBarTint);
                editor.putBoolean("useMessagePanelColor", useMessagePanelColor);

                editor.commit();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    public static void loadConfig() {
        synchronized (sync) {
            if (configLoaded) {
                return;
            }

            SharedPreferences preferences = ApplicationLoader.applicationContext.getSharedPreferences("nekoconfig", Activity.MODE_PRIVATE);
            useIPv6 = preferences.getBoolean("useIPv6", false);
            hidePhone = preferences.getBoolean("hidePhone", true);
            ignoreBlocked = preferences.getBoolean("ignoreBlocked", false);
            forceTablet = preferences.getBoolean("forceTablet", false);
            nameOrder = preferences.getInt("nameOrder", 1);
            nya = preferences.getBoolean("nya", false);
            nyaSuffix = preferences.getString("nyaSuffix", "喵");
            transparentStatusBar = preferences.getBoolean("transparentStatusBar", true);
            navigationBarTint = preferences.getBoolean("navigationBarTint", true);
            useMessagePanelColor = preferences.getBoolean("useMessagePanelColor", false);
            configLoaded = true;
        }
    }

    public static void toggleIPv6() {
        useIPv6 = !useIPv6;
        SharedPreferences preferences = ApplicationLoader.applicationContext.getSharedPreferences("nekoconfig", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("useIPv6", useIPv6);
        editor.commit();
    }

    public static void toggleHidePhone() {
        hidePhone = !hidePhone;
        SharedPreferences preferences = ApplicationLoader.applicationContext.getSharedPreferences("nekoconfig", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("hidePhone", hidePhone);
        editor.commit();
    }

    public static void toggleIgnoreBlocked() {
        ignoreBlocked = !ignoreBlocked;
        SharedPreferences preferences = ApplicationLoader.applicationContext.getSharedPreferences("nekoconfig", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("ignoreBlocked", ignoreBlocked);
        editor.commit();
    }

    public static void toggleForceTablet() {
        forceTablet = !forceTablet;
        SharedPreferences preferences = ApplicationLoader.applicationContext.getSharedPreferences("nekoconfig", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("forceTablet", forceTablet);
        editor.commit();
    }

    public static void toggleNya() {
        nya = !nya;
        SharedPreferences preferences = ApplicationLoader.applicationContext.getSharedPreferences("nekoconfig", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("nya", nya);
        editor.commit();
    }

    public static void setNyaSuffix(String suffix) {
        nyaSuffix = suffix;
        SharedPreferences preferences = ApplicationLoader.applicationContext.getSharedPreferences("nekoconfig", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("nyaSuffix", nyaSuffix);
        editor.commit();
    }

    public static void setNameOrder(int order) {
        nameOrder = order;
        SharedPreferences preferences = ApplicationLoader.applicationContext.getSharedPreferences("nekoconfig", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("nameOrder", nameOrder);
        editor.commit();
    }

    public static void toggleTransparentStatusBar() {
        transparentStatusBar = !transparentStatusBar;
        SharedPreferences preferences = ApplicationLoader.applicationContext.getSharedPreferences("nekoconfig", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("transparentStatusBar", transparentStatusBar);
        editor.commit();
    }

    public static void toggleNavigationBarTint() {
        navigationBarTint = !navigationBarTint;
        SharedPreferences preferences = ApplicationLoader.applicationContext.getSharedPreferences("nekoconfig", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("navigationBarTint", navigationBarTint);
        editor.commit();
    }

    public static void toggleUseMessagePanelColor() {
        useMessagePanelColor = !useMessagePanelColor;
        SharedPreferences preferences = ApplicationLoader.applicationContext.getSharedPreferences("nekoconfig", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("useMessagePanelColor", useMessagePanelColor);
        editor.commit();
    }

}

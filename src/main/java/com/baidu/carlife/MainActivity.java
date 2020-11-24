package com.baidu.carlife;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

    private static final int NEW_TASK_FLAG = Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent();
        intent.setClassName("net.icarbox.ailink", "net.icarbox.ailink.MainActivity");
        intent.putExtra("from_adb", true);
        launchNewTask(this, intent);
        finish();
    }

    public static void launchNewTask(Context context, Intent intent) {
        try {
            intent.addFlags(NEW_TASK_FLAG);
            context.startActivity(intent);
        } catch (SecurityException se) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

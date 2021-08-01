package com.catchingnow.icebox.sdk_client;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

class AuthorizeUtil {

    private static PendingIntent authorizePendingIntent = null;
    private static final int FLAG_MUTABLE;

    static {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            FLAG_MUTABLE = PendingIntent.FLAG_MUTABLE;
        } else {
            FLAG_MUTABLE = 0;
        }
    }
    
    @SuppressLint("WrongConstant")
    static PendingIntent getAuthorizedPI(Context context) {
        if (authorizePendingIntent == null) {
            authorizePendingIntent = PendingIntent.getBroadcast(context,
                    0x333, new Intent(context, StateReceiver.class), FLAG_MUTABLE);
        }
        return authorizePendingIntent;
    }

}

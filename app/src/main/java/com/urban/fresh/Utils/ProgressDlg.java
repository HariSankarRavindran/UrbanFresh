package com.urban.fresh.Utils;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;

import com.kaopiz.kprogresshud.KProgressHUD;

public class ProgressDlg {

    private static final ProgressDialog progressDialog = null;
    private static Dialog mDialog;
    private static KProgressHUD kProgressHUD;


    public static void showProgressDialog(Context context, String title, String message) {
        String content = message;
        if (message != null) {
            kProgressHUD = KProgressHUD
                    .create(context)
                    .setDetailsLabel(message)
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setCancellable(false)
                    .setSize(150, 150)
                    .setAnimationSpeed(1)
                    .setDimAmount(0.5f);
        } else {
            kProgressHUD = KProgressHUD
                    .create(context)
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setCancellable(false)
                    .setSize(85, 85)
                    .setAnimationSpeed(1)
                    .setDimAmount(0.5f);
        }

        if (kProgressHUD != null && !kProgressHUD.isShowing()) {
            kProgressHUD.show();
        }
    }

    public static void dismissProgressDialog() {
        try {
            if (kProgressHUD != null && kProgressHUD.isShowing()) {
                kProgressHUD.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clearDialog() {
        try {
            if (kProgressHUD != null) {
                kProgressHUD.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        kProgressHUD = null;
    }
}
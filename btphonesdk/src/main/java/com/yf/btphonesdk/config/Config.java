package com.yf.btphonesdk.config;

/**
 * FileName :  Config
 * Author   :  zhizhongbiao
 * Date     :  2018/10/8
 * Describe :
 */

public interface Config {

    interface ModuleKey {
        int KEY_KEY_BOARD = 0;
        int KEY_RECORD = 1;
        int KEY_CONTACTS = 2;
        int KEY_OFTEN = 3;
        int KEY_SETTING = 4;
    }

    interface Action
    {
        String ACTION_SERVICE="com.yf.bluetooth.action.REMOTE_BIND";
    }
}

package com.yf.btphonesdk.config;

/**
 * FileName :  Config
 * Author   :  zhizhongbiao
 * Date     :  2018/10/8
 * Describe :
 */

public interface Config {


    interface ModuleKey {
        /**
         * 各个模块的Key值
         */
        int KEY_KEY_BOARD = 0;//拨号键盘
        int KEY_RECORD = 1;//通话记录
        int KEY_CONTACTS = 2;//联系人
        int KEY_OFTEN = 3;//常用联系人
        int KEY_SETTING = 4;//蓝牙设置
    }

    /**
     * 远程服务的Action
     */
    interface Action {
        String ACTION_SERVICE = "com.yf.bluetooth.action.REMOTE_BIND";
    }
}

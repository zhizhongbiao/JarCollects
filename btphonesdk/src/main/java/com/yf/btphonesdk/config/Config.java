package com.yf.btphonesdk.config;

/**
 * FileName :  Config
 * Author   :  zhizhongbiao
 * Date     :  2018/10/8
 * Describe :
 */

public interface Config {

    /**
     * 各个模块的Key值
     */
    interface ModuleKey {

        /**
         * 拨号键盘
         */
        int KEY_KEY_BOARD = 0;
        /**
         * 通话记录
         */
        int KEY_RECORD = 1;
        /**
         * 联系人
         */
        int KEY_CONTACTS = 2;
        /**
         * 常用联系人
         */
        int KEY_OFTEN = 3;
        /**
         * 蓝牙设置
         */
        int KEY_SETTING = 4;
    }

    /**
     * Action清单
     */
    interface Action {
        /**
         * 远程服务的Action
         */
        String ACTION_SERVICE = "com.yf.bluetooth.action.REMOTE_BIND";
    }
}

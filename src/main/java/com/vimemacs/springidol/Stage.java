package com.vimemacs.springidol;

/**
 * Created by HWD on 2017/5/23.
 */
public class Stage {
    private Stage() {
    }

    // 延迟加载实例
    private static class StageSingletonHolder {
        static Stage instance = new Stage();
    }

    // 返回实例
    public static Stage getInstance() {
        return StageSingletonHolder.instance;
    }
}

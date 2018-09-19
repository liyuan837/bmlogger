package com.liyuan.bmlogger.constants;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 9:31 2018/9/10
 * @Modified By:
 */
public interface Logger {
    /**
     * 日志类型:1接口日志
     */
    interface LoggerType{
        int APITYPE = 1;
    }

    /**
     * 接口调用结果状态:1正常，0异常
     */
    interface LoggerApiState{
        int NORMAL = 1;
        int EXCEPTION = 0;
    }
}

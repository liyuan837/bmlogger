package com.liyuan.bmlogger.util;

import net.sf.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class JSONUtil {
    /**
     * 描述：组装json格式返回结果
     * @param isOk
     * @param resCode
     * @param errorMsg
     * @param obj
     * @return
     */
    public static Map<String, Object> createJson(boolean isOk, int resCode, String errorMsg, Object obj) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("result", isOk ? "ok" : "fail");
        jsonMap.put("rescode", resCode);
        jsonMap.put("msg", errorMsg);
        jsonMap.put("data", obj);
        return jsonMap;
    }

    /**
     * 描述：组装json格式返回结果
     * @param isOk
     * @param resCode
     * @param errorMsg
     * @param obj
     * @return
     */
    public static String createJsonString(boolean isOk, int resCode, String errorMsg, Object obj) {
        Map<String, Object> jsonMap = createJson(isOk, resCode, errorMsg, obj);
        JSONObject jsonObject = JSONObject.fromObject(jsonMap);
        return jsonObject.toString();
    }
}

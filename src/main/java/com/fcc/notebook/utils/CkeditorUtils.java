package com.fcc.notebook.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CkeditorUtils {
    public static void writeCkeditor(HttpServletResponse response, String url, String CKEditorFuncNum){
        String result = "<script type=\"text/javascript\">";
        result += "window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum
                + ",'"  + url + "','上传成功')";
        result += "</script>";
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

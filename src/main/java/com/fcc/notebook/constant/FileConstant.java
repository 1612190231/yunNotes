package com.fcc.notebook.constant;

import com.fcc.notebook.utils.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileConstant {

    @Value("${file.backup.path}")
    private static String basePath;

    public static final String VIEW_PATH = "/upload/";

    private static final String DEFAULT_SUB_FOLDER_FORMAT_AUTO = "yyyyMMdd";

    public static final String COMMON_UPLOAD_PATH = "common";

    /**
     * �ļ��ϴ����Ͷ��壨�����ϴ�ʱ�����ļ��д洢��
     */
    public static enum FileTypeEnum{
        TYPE_NEWS_PC(10, "news/pc"),
        TYPE_NEWS_M(11, "news/m"),
        TYPE_NEWS_CONTENT(12, "news/content"),
        TYPE_BOTTOM(20, "bottom"),
    	TYPE_CAROUSEL_PC(30, "carousel/pc"),//�ֲ�ͼ���Զ�
    	TYPE_CAROUSEL_M(31, "carousel/m"),//�ֲ�ͼ�ֻ���
    	TYPE_BUTTON(40, "button"),//��ҳ��ťͼƬ
        TYPE_ABOUT_PC(50, "about/pc"),
        TYPE_ABOUT_M(51, "about/m"),
        TYPE_ABOUT_CONTENT(52, "about/content");

        private Integer code;
        private String path;

        FileTypeEnum(Integer code, String path){
            this.code = code;
            this.path = path;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public static String getFileType(Integer type){
            if(StringUtils.isBlank(type)){
                return COMMON_UPLOAD_PATH + "/" + getDateStr();
            }
            for(FileTypeEnum e:FileTypeEnum.values()){
                if(type.equals(e.getCode())){
                    return e.getPath() + "/" + getDateStr();
                }
            }
            return null;
        }
    }

    public static String getDateStr(){
        return new SimpleDateFormat(DEFAULT_SUB_FOLDER_FORMAT_AUTO).format(new Date());
    }

    /**
     * ��ȡͼƬ�洢����·��
     * @return
     */
    public static String getUploadPath(){
        String os = System.getProperty("os.name");
        if(os.toLowerCase().startsWith("win")){
            return "D:\\Users\\lu\\Desktop\\Note";
        }else{
            return basePath;
        }
    }
}
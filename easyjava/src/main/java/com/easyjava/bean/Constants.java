package com.easyjava.bean;

import com.easyjava.utils.JsonUtils;
import com.easyjava.utils.PropertiesUtils;

public class Constants {

    public static String AUTHOR_COMMENT;
    public static Boolean IGNORE_TABLE_PREFIX;

    private static String PATH_JAVA = "java";
    private static String PATH_RESOURCES= "resources";
    public static String SUFFIX_BEAN_PARAM;
    public static String PATH_BASE;
    public static String PATH_PO;
    public static String PATH_UTILS;


    public static String PACKAGE_BASE;
    public static String PACKAGE_PO;
    public static String PACKAGE_UTILS;

    //需要忽略的属性
    public static String IGNORE_BEAN_TOJSON_FIELD;
    public static String IGNORE_BEAN_TOJSON_CLASS;
    public static String IGNORE_BEAN_TOJSON_EXPRESSION;

    //日期序列化，反序列化
    public static String BEAN_DATE_FORMAT_EXPRESSION;
    public static String BEAN_DATE_FORMAT_CLASS;

    public static String BEAN_DATE_UNFORMAT_EXPRESSION;
    public static String BEAN_DATE_UNFORMAT_CLASS;





    static {
        IGNORE_BEAN_TOJSON_FIELD = PropertiesUtils.getString("ignore.bean.tojson.field");
        IGNORE_BEAN_TOJSON_CLASS = PropertiesUtils.getString("ignore.bean.tojson.class");
        IGNORE_BEAN_TOJSON_EXPRESSION = PropertiesUtils.getString("ignore.bean.tojson.expression");

        BEAN_DATE_FORMAT_EXPRESSION = PropertiesUtils.getString("bean.date.format.expression");
        BEAN_DATE_FORMAT_CLASS = PropertiesUtils.getString("bean.date.format.class");

        BEAN_DATE_UNFORMAT_EXPRESSION = PropertiesUtils.getString("bean.date.parse.expression");
        BEAN_DATE_UNFORMAT_CLASS = PropertiesUtils.getString("bean.date.parse.class");






        AUTHOR_COMMENT = PropertiesUtils.getString("author.comment");
        SUFFIX_BEAN_PARAM = PropertiesUtils.getString("suffix.bean.param");
        IGNORE_TABLE_PREFIX = Boolean.valueOf(PropertiesUtils.getString("ignore.table.prefix"));

        PACKAGE_BASE = PropertiesUtils.getString("package.base");
        PACKAGE_PO = PACKAGE_BASE + "." + PropertiesUtils.getString("package.po");
        PACKAGE_UTILS = PACKAGE_BASE + "." + PropertiesUtils.getString("package.utils");

        PATH_BASE = PropertiesUtils.getString("path.base");
        PATH_BASE = PATH_BASE  +PATH_JAVA+ "/";
        PATH_PO = PATH_BASE +"/"+ PACKAGE_PO.replace(".","/");
        PATH_UTILS = PATH_BASE +"/"+ PACKAGE_UTILS.replace(".","/");

    }



    // SQL Date Time Types
    public static final String[] SQL_DATE_TIME_TYPES = new String[]{"datetime", "timestamp"};

    // SQL Date Types
    public static final String[] SQL_DATE_TYPES = new String[]{"date"};

    // SQL Decimal Types
    public static final String[] SQL_DECIMAL_TYPES = new String[]{"decimal", "double", "float"};

    // SQL String Types
    public static final String[] SQL_STRING_TYPES = new String[]{"char", "varchar", "text", "mediumtext", "longtext"};

    // Integer
    public static final String[] SQL_INTEGER_TYPES = new String[]{"int", "tinyint"};

    // Long
    public static final String[] SQL_LONG_TYPES = new String[]{"bigint"};


    public static void main(String[] args) {
        System.out.println(BEAN_DATE_FORMAT_EXPRESSION);
    }

}

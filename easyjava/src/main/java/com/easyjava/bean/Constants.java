package com.easyjava.bean;

import com.easyjava.utils.PropertiesUtils;

public class Constants {
    public static Boolean IGNORE_TABLE_PREFIX;

    public static String SUFFIX_BEAN_PARAM;
    static {
        SUFFIX_BEAN_PARAM = PropertiesUtils.getString("suffix.bean.param");
        IGNORE_TABLE_PREFIX = Boolean.valueOf(PropertiesUtils.getString("ignore.table.prefix"));
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

}

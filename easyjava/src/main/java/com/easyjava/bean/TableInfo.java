package com.easyjava.bean;

import com.easyjava.bean.FieldInfo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TableInfo {

    /**
     *表名
     */
    private static String tableName;

    /**
     * bean名
     */
    private static String beanName;

    /**
     * 参数名称
     */
    private static String beanParamName;

    /**
     * 表注释
     */
    private static String comment;

    /**
     * 字段信息
     */
    private List<FieldInfo> fieldList;

    /**
     * 唯一索引集合
     */
    private Map<String, List<FieldInfo>> keyIndexMap = new LinkedHashMap();

    /**
     * 是否有Date类型
     */
    private boolean haveDate;

    /**
     * 是否有DateTime类型
     */
    private boolean haveDateTime;

    /**
     * 是否有BigDecimal类型
     */
    private boolean haveBigDecimal;

    public static String getTableName() {
        return tableName;
    }

    public static void setTableName(String tableName) {
        TableInfo.tableName = tableName;
    }

    public static String getBeanName() {
        return beanName;
    }

    public static void setBeanName(String beanName) {
        TableInfo.beanName = beanName;
    }

    public static String getBeanParamName() {
        return beanParamName;
    }

    public static void setBeanParamName(String beanParamName) {
        TableInfo.beanParamName = beanParamName;
    }

    public static String getComment() {
        return comment;
    }

    public static void setComment(String comment) {
        TableInfo.comment = comment;
    }

    public List<FieldInfo> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<FieldInfo> fieldList) {
        this.fieldList = fieldList;
    }

    public Map<String, List<FieldInfo>> getKeyIndexMap() {
        return keyIndexMap;
    }

    public void setKeyIndexMap(Map<String, List<FieldInfo>> keyIndexMap) {
        this.keyIndexMap = keyIndexMap;
    }

    public boolean isHaveDate() {
        return haveDate;
    }

    public void setHaveDate(boolean haveDate) {
        this.haveDate = haveDate;
    }

    public boolean isHaveDateTime() {
        return haveDateTime;
    }

    public void setHaveDateTime(boolean haveDateTime) {
        this.haveDateTime = haveDateTime;
    }

    public boolean isHaveBigDecimal() {
        return haveBigDecimal;
    }

    public void setHaveBigDecimal(boolean haveBigDecimal) {
        this.haveBigDecimal = haveBigDecimal;
    }
}

package com.easyjava;

import com.easyjava.bean.TableInfo;
import com.easyjava.builder.BuildPO;
import com.easyjava.builder.BuildTable;

import java.util.List;
import java.util.logging.Logger;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;


public class RunApplication {
    public static void main(String[] args) {

        List<TableInfo> tableInfoList = BuildTable.getTables();
        for(TableInfo tableInfo :tableInfoList ) {
            BuildPO.execute(tableInfo);
        }
    }
}

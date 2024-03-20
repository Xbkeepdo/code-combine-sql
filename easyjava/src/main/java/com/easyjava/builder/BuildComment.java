package com.easyjava.builder;

import com.easyjava.bean.Constants;
import com.easyjava.utils.DateUtils;

import java.io.BufferedWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BuildComment {
    //构建类注释描述加时间
    public static void createClassComment(BufferedWriter bw,String classComment) throws Exception {
        /**
         *
         * @param bw
         * @param classComment
         * @throws Exception
         * @Description 构建类注释描述加时间
         * @date 2019-12-12
         */

        bw.write("/**");
        bw.newLine();
        bw.write(" * @Description:" + classComment);
        bw.newLine();
        //作者：xb
        bw.write(" * @Author:" + Constants.AUTHOR_COMMENT);
        bw.newLine();
        bw.write(" * @date: " + DateUtils.format(new Date(), DateUtils._YYYYMMDD));
        bw.newLine();
        bw.write(" */");
        bw.newLine();



    }

    //构建字段注释
    public static void createFieldComment(BufferedWriter bw,String fieldComment) throws Exception {
        /**
         *
         * @param bw
         * @param fieldComment
         * @param fieldName
         * @throws Exception
         * @Description 构建字段注释
         * @date 2019-12-12
         */

        bw.write("\t/**");
        bw.newLine();
        bw.write("\t * " +( fieldComment==null?"":fieldComment));
        bw.newLine();
        bw.write("\t */");
        bw.newLine();


    }

    public static void createMethodComment(){

    }

}

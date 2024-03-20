package com.easyjava.builder;

import com.easyjava.bean.Constants;
import com.easyjava.bean.FieldInfo;
import com.easyjava.bean.TableInfo;
import com.easyjava.utils.DateUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;


public class BuildPO {
    private static final Logger logger = LoggerFactory.getLogger(BuildPO.class);
    public static void execute(TableInfo tableInfo){

        File folder = new File(Constants.PATH_PO);
        if(!folder.exists()){
            folder.mkdirs();
        }

        File poFile = new File(folder,tableInfo.getBeanName()+ ".java");

        OutputStream out = null;
        OutputStreamWriter outw = null;
        BufferedWriter bw = null;
        try {
                out = new FileOutputStream(poFile);
                outw = new OutputStreamWriter(out,"utf8");
                bw = new BufferedWriter(outw);

                bw.write("package " + Constants.PACKAGE_PO + ";");
                bw.newLine();
                bw.newLine();
                bw.write("import java.io.Serializable;");
                bw.newLine();

            //导入时间包
                if(tableInfo.isHaveDateTime()||tableInfo.isHaveDate()){
                    bw.write("import java.util.Date;");
                    bw.newLine();
                    bw.write(Constants.BEAN_DATE_FORMAT_CLASS);
                    bw.newLine();
                    bw.write(Constants.BEAN_DATE_UNFORMAT_CLASS);
                    bw.newLine();
                }
                //导入BigDecimal包
                if (tableInfo.isHaveBigDecimal()){
                    bw.write("import java.math.BigDecimal;");
                    bw.newLine();
                }
                bw.newLine();

                //构建类注释
                BuildComment.createClassComment(bw,tableInfo.getComment() + "实体类");
                bw.write("public class "+ tableInfo.getBeanName() + " implements Serializable {");
                bw.newLine();

                //构建字段
                for(FieldInfo fieldInfo : tableInfo.getFieldList() ){
                    //构建字段注释
                    BuildComment.createFieldComment(bw,fieldInfo.getComment());

                    if(ArrayUtils.contains(Constants.SQL_DATE_TIME_TYPES,fieldInfo.getSqlType())){
                        //序列化
                        bw.write("\t"+String.format(Constants.BEAN_DATE_FORMAT_EXPRESSION, DateUtils.YYYY_MM_DD_HH_MM_SS));
                        bw.newLine();

                        //反序列化
                        bw.write("\t"+String.format(Constants.BEAN_DATE_UNFORMAT_EXPRESSION, DateUtils.YYYY_MM_DD_HH_MM_SS));
                        bw.newLine();


                    }

                    if(ArrayUtils.contains(Constants.SQL_DATE_TYPES,fieldInfo.getSqlType())){
                        //序列化
                        bw.write("\t"+String.format(Constants.BEAN_DATE_FORMAT_EXPRESSION, DateUtils.YYYY_MM_DD));
                        bw.newLine();

                        //反序列化
                        bw.write("\t"+String.format(Constants.BEAN_DATE_UNFORMAT_EXPRESSION, DateUtils.YYYY_MM_DD));
                        bw.newLine();
                    }

                    bw.write("\tprivate " + fieldInfo.getJavaType() + " "+ fieldInfo.getPropertyName() + ";" );
                    bw.newLine();
                    bw.newLine();
                }


                bw.write("}");
                bw.flush();

        }catch (Exception e){
            logger.error("创建PO失败",e);
        } finally {
            if(bw != null){
                try {
                    bw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }


    }


}

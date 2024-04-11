package com.easyjava.builder;

import com.easyjava.bean.Constants;
import com.easyjava.bean.FieldInfo;
import com.easyjava.bean.TableInfo;
import com.easyjava.utils.StringUtils;
import com.sun.org.apache.bcel.internal.Const;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BuildQuery {
    private static final Logger logger = LoggerFactory.getLogger(BuildQuery.class);

    public static void execute(TableInfo tableInfo){
        File folder = new File(Constants.PATH_QUERY);
        if(!folder.exists()){
            folder.mkdirs();
        }

        String className = tableInfo.getBeanName() + Constants.SUFFIX_BEAN_QUERY;

        File poFile = new File(folder, className + ".java");

        OutputStream out = null;
        OutputStreamWriter outw = null;
        BufferedWriter bw = null;
        try {
            out = new FileOutputStream(poFile);
            outw = new OutputStreamWriter(out, "utf8");
            bw = new BufferedWriter(outw);

            bw.write("package " + Constants.PACKAGE_QUERY + ";");
            bw.newLine();
            bw.newLine();

            if(tableInfo.isHaveBigDecimal()){
                bw.write("import java.math.BigDecimal;");
                bw.newLine();
            }

            if(tableInfo.isHaveDate() || tableInfo.isHaveDateTime()){
                bw.write("import java.util.Date;");
                bw.newLine();
            }

            bw.newLine();
            bw.newLine();

            //structure class note
            BuildComment.createClassComment(bw, tableInfo.getComment() +" search object");
            bw.write("public class " + className + " extends BaseQuery  {");
            bw.newLine();


            for (FieldInfo field : tableInfo.getFieldList()) {

                BuildComment.createFieldComment(bw, field.getComment());
                bw.write("\tprivate " + field.getJavaType() + " " + field.getPropertyName() + ";\n\n");


                //String Param
                if(ArrayUtils.contains(Constants.SQL_STRING_TYPES, field.getSqlType())){
                    String propertyName = field.getPropertyName() + Constants.SUFFIX_BEAN_QUERY_FUZZY;
                    bw.write("\tprivate " + field.getJavaType() + " " +propertyName +";");
                    bw.newLine();
                    bw.newLine();


                }

                if(ArrayUtils.contains(Constants.SQL_DATE_TIME_TYPES, field.getSqlType()) || ArrayUtils.contains(Constants.SQL_DATE_TYPES, field.getSqlType())){
                    bw.write("\tprivate String " +field.getPropertyName() + Constants.SUFFIX_BEAN_QUERY_TIME_START + ";");
                    bw.newLine();
                    bw.newLine();

                    bw.write("\tprivate String " +field.getPropertyName() + Constants.SUFFIX_BEAN_QUERY_TIME_END + "; ");
                    bw.newLine();
                    bw.newLine();


                }
            }

            List<FieldInfo> fieldInfoList = tableInfo.getFieldList();
            buildGetSet(bw, fieldInfoList);
            buildGetSet(bw, tableInfo.getFieldExtendList());

            bw.write("}");
            bw.flush();
        }catch (Exception e){
            logger.error("创建querry失败", e);
        }finally {
            if(bw!=null){
                try{
                    bw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(outw!=null){
                try{
                    outw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try{
                    out.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }


    private static void buildGetSet(BufferedWriter bw, List<FieldInfo> fieldInfoList) throws IOException {
        /** 生成 PO 的 set 和 get 方法 */
        for (FieldInfo field : fieldInfoList) {
            String tempField = StringUtils.upperCaseFirstLetter(field.getPropertyName());
            // set
            bw.write("\n\tpublic void set" + tempField + "(" + field.getJavaType() + " " + field.getPropertyName() + ") {");
            bw.newLine();
            bw.write("\t\tthis." + field.getPropertyName() + " = " + field.getPropertyName() + ";");
            bw.newLine();
            bw.write("\t}" + "\n");

            // get
            bw.write("\n\tpublic " + field.getJavaType() + " get" + tempField + "() {");
            bw.newLine();
            bw.write("\t\treturn " + field.getPropertyName() + ";");
            bw.newLine();
            bw.write("\t}" + "\n");
        }
    }
}
package com.easyjava.builder;

import com.easyjava.bean.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


//创建基础类
public class BuildBase {
    private static Logger logger = LoggerFactory.getLogger(BuildBase.class);

    public static void execute() {
        List<String> headerInfoList = new ArrayList();
        headerInfoList.add("package " + Constants.PACKAGE_UTILS );
        build(headerInfoList,"DateUtils", Constants.PATH_UTILS);
    }

    private static void build(List<String> headerInfoList, String fileName , String outputPath){
        File file = new File(outputPath);
        if(!file.exists()){
            file.mkdirs();
        }
        File javaFile = new File(outputPath,fileName + ".java");

        OutputStream out = null;
        OutputStreamWriter outw = null;
        BufferedWriter bw = null;

        InputStream in = null;
        InputStreamReader inr = null;
        BufferedReader br = null;

        try {
            out = new FileOutputStream(javaFile);
            outw = new OutputStreamWriter(out,"utf-8");
            bw = new BufferedWriter(outw);

            String templatePath = BuildBase.class.getClassLoader().getResource("template/" + fileName + ".txt").getPath();
            in = new FileInputStream(templatePath);
            inr = new InputStreamReader(in,"utf-8");
            br = new BufferedReader(inr);

            for(String headerInfo : headerInfoList){
                bw.write(headerInfo + ";");
                bw.newLine();
                if(headerInfo.contains("package")) {
                    bw.newLine();
                }
                bw.newLine();
            }

            String lineInfo = null;
            while((lineInfo = br.readLine()) != null){
                bw.write(lineInfo);
                bw.newLine();
            }
            bw.flush();

        } catch (Exception e) {
            logger.error("生成基础类：{} ，失败",fileName,e);
        } finally {
            if( br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if( inr != null){
                try {
                    inr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if( in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if( bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if( outw != null){
                try {
                    outw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if( out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }


    }
}

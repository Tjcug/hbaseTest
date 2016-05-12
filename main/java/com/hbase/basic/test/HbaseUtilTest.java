package com.hbase.basic.test;

import com.hbase.basic.HBaseTempUtil;
import com.hbase.basic.HBaseUtils;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by hadoop on 5/12/16.
 */

public class HbaseUtilTest {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });

        BeanFactory factory = (BeanFactory) context;
        HBaseTempUtil hBaseUtil = (HBaseTempUtil) factory.getBean("HBaseTempUtil");
        //System.out.println(hBaseUtil.get("DK00_NATIONEXP","1"));
        //System.out.println(hBaseUtil.get("DK00_NATIONEXP","1","info","KTTZ"));
        //System.out.println(hBaseUtil.find("DK00_NATIONEXP","1","4"));
        //System.out.println(hBaseUtil.execute("student","2","info","name","lisi"));
        //HBaseUtils.creatTable("company",new String[]{"info"});
        Result result=HBaseUtils.getRecordByRowKey("DK01_COMPEXP","1");
        for(Cell cell:result.getColumnCells("info".getBytes(),"KTTZ".getBytes())){
            System.out.println(new String(CellUtil.cloneValue(cell)));
        }

    }
}

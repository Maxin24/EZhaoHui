package com.join.ezhaohui.info;

import com.join.ezhaohui.entity.Info;
import com.join.ezhaohui.mapper.InfoMapper;
import com.join.ezhaohui.service.info.InfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author:ljx
 * @Date:2020/4/4
 * @Description:
 */
@SpringBootTest
public class InfoTests {
    @Autowired
    InfoService infoService;

    @Test()
    public void insertTest(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        Date date=new Date();
        String dateStr=sdf.format(date);

        Info record=new Info();
        record.setCompanyName("卓音");
        record.setCompanyNature("工作室");

        record.setEduBackground("本科");

        record.setIsRecommend("是");
        record.setJobName("前端");
        record.setJobNature("IT");
        record.setPosition("长春");
        record.setType("测试");
        record.setUrl("http://www.example.com/index.html#print");

        System.out.println(infoService.insert(record));
    }

    @Test
    public void testMultiSelect(){
        Info info=new Info();
        info.setJobName("前端");
        System.out.println(infoService.multiSelect(info));
    }

    @Test
    public void testMultiFuzzySelect(){
        Info msg = new Info();
        msg.setUrl("国企");
        msg.setPosition("上海");
        msg.setType("政法类");
        List<Info> msgs = infoService.multiFuzzySelect(msg);
        for(Info demo : msgs){
            System.out.println(demo.toString());
        }
        System.out.println(infoService.multiFuzzySelect(msg));
    }

    @Test
    public void updateByPrimaryKeySelective(){
        Info info=new Info();
        info.setJobName("打扫卫生");
        info.setId(1);
        System.out.println(infoService.updateByPrimaryKeySelective(info));
    }

    @Test
    public void deleteByPrimaryKey(){
        System.out.println(infoService.deleteByPrimaryKey(9));
    }
}

package com.gupao.vip;

import com.gupao.vip.PageHandler;
import com.gupao.vip.mapper.BillReadMapper;
import com.gupao.vip.pojo.BillRead;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/2
 * Time: 17:59
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring/app*.xml"})
public class BillReadTest {

    @Resource
    BillReadMapper billReadMapper;

    @Test
    public void readXml() {
    }

    @Test
    public void selectByBillRead(){
        String billId = "12345";
        BillRead billRead = new BillRead();
        billRead.setBillId(billId);
        List<BillRead> list = billReadMapper.selectByBillRead(billRead);
        List<BillRead> lists = billReadMapper.selectByBillRead(billRead);
        System.out.println(list);
    }

    @Test
    public void insert(){

    }

    @Test
    public void pageSelect(){
        BillRead billRead = new BillRead();
        billRead.setBillId("12345");
        billRead.setPagesize(2);
        billRead.setPagebegin(1);
        PageHandler.pageSet(billRead.getPagebegin(),billRead.getPagesize());
        List<BillRead> list = billReadMapper.selectByBillRead(billRead);
        //System.out.println(list);
    }

    @Test
    public void findClassType() throws NoSuchFieldException {
        Field field = BillRead.class.getDeclaredField("aaa");
        int mod = field.getModifiers();
    }


}

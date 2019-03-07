package com.owen.test;

import com.owen.Device;
import com.owen.Group;
import com.owen.User;
import com.owen.dao.repository.IDeviceDao;
import com.owen.service.IDeviceService;
import com.owen.service.IGroupService;
import com.owen.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yaml.snakeyaml.events.Event;

import javax.servlet.http.HttpSession;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Autowired
    private IGroupService groupService;
    @Autowired
    private IDeviceService deviceService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IDeviceDao deviceDao;

    @Test
    public void contextLoads() {

        Group gp=groupService.selectGroupByName(4);
        System.out.println(gp.toString());
//        Device dd=deviceService.queryAllByDeviceSn("asdasdasdasd");
//        System.out.println(dd.toString());
//
//            deviceService.addMid(123135,1);

//
//        Page<User> page = userService.findAllByLike("李科",pageRequest);
//        System.out.println(page.toString());
//          Device dd=deviceService.queryAllByDeviceSn("6546546456");
//        System.out.println(dd.toString());
//        PageRequest pageRequest=new PageRequest(1,4,null);
//        Page<Device> device=deviceService.findAllByName(4,pageRequest);
//        HttpSession session = request.getSession();
//          session.setAttribute("q","qqq");
//          String n=session.getAttribute("q").toString();
//          System.out.println(n);
//        int i=200;
//        String n=i.
//        System.out.println(i.);
    }

}


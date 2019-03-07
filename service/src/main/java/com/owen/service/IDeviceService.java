package com.owen.service;

import com.owen.Device;
import com.owen.service.support.IBaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.servlet.http.HttpSession;

public interface IDeviceService extends IBaseService<Device,Integer> {

    /**
     * 根据关键字查找设备并分页
     **/
    Page<Device> findAllByLike(String searchText, PageRequest pageRequest);


    /**
     * 根据公司ID查找（个人拥有的）设备
     **/
    Page<Device> assGroupId(String searchText, PageRequest pageRequest);

    /**
     * 增加或修改设备
     **/
    void saveOrUpdate(Device device);

//    void addMid(Integer d,Integer g);
    /**
     * 根据序列号查找设备
     **/
    Device queryAllByDeviceSn(String str);

    /**
     * 设备和公司关联
     **/
    void grant(Integer id,Integer groupId);

//    Device selectDeviceByName(String name,PageRequest pageRequest);

}

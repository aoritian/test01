package com.owen.service.impl;

import com.owen.Device;
import com.owen.Group;
import com.owen.User;
import com.owen.dao.repository.IDeviceDao;
import com.owen.dao.repository.support.IBaseDao;
import com.owen.service.IDeviceService;
import com.owen.service.IGroupService;
import com.owen.service.IUserService;
import com.owen.service.support.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *  设备表  实现类
 **/

@Service
public class DeviceServiceImpl extends BaseServiceImpl<Device,Integer> implements IDeviceService {

    @Autowired
    private IDeviceDao deviceDao;

    @Autowired
    private IGroupService groupService;

    @Autowired
    private IUserService UserService;


    @Override
    public Page<Device> findAllByLike(String searchText, PageRequest pageRequest) {
        if(StringUtils.isBlank(searchText)){
            searchText = "";
        }
        return deviceDao.findAllByDeviceSnContaining(searchText,pageRequest);
    }

    @Override
    public Page<Device> assGroupId(String searchText, PageRequest pageRequest) {
        if(StringUtils.isBlank(searchText)){
            searchText="";
        }
//        String s=searchText.replaceAll("[^0-9a-zA-Z\u4e00-\u9fa5.，,%。？“”]+","");
        return deviceDao.findAllByGroupIdContaining(searchText,pageRequest);
    }

    @Override
    public void saveOrUpdate(Device device) {

        if (device.getId()!=null){
            Device dbdevice=find(device.getId());
            dbdevice.setDeviceSn(device.getDeviceSn());
            dbdevice.setLocation(device.getLocation());
            dbdevice.setStatus(device.getStatus());
            dbdevice.setDeleteStr(device.getDeleteStr());
            dbdevice.setGroupId(device.getGroupId());
            dbdevice.setHardwareVer(device.getHardwareVer());
            dbdevice.setAppId(device.getAppId());
            dbdevice.setIp(device.getIp());
            dbdevice.setUpdateTime(new Date());
            dbdevice.setRemark(device.getRemark());
            update(dbdevice);
        }else {
            device.setCreateTime(new Date());
            device.setUpdateTime(new Date());
            save(device);
        }
    }


//    @Override
//    public void addMid(Integer d, Integer g) { }

    @Override
    public Device queryAllByDeviceSn(String str) {
        return deviceDao.queryAllByDeviceSn(str);
    }

    @Override
    public void grant(Integer id, Integer groupId) {
        Device device=find(id);
        Group group;
        Set<Group> groups=new HashSet<>();
        Integer gid=groupId;
        group=groupService.find(gid);
        groups.add(group);
        device.setGroups(groups);
        update(device);
    }

//    @Override
//    public Device selectDeviceByName(String name,PageRequest pageRequest) {
//        return deviceDao.selectDeviceByName(name,pageRequest);
//    }

    @Override
    public IBaseDao<Device, Integer> getBaseDao() {
        return this.deviceDao;
    }
}

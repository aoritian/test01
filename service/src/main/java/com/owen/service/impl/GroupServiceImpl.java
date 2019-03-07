package com.owen.service.impl;

import com.owen.Group;
import com.owen.dao.repository.support.IBaseDao;
import com.owen.service.IGroupService;
import com.owen.service.support.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.owen.dao.repository.IGroupDao;

/**
 *  公司实现类 实现类
 **/

@Service
public class GroupServiceImpl extends BaseServiceImpl<Group,Integer> implements IGroupService {

    @Autowired
    private IGroupDao groupDao;

    @Override
    public IBaseDao<Group, Integer> getBaseDao() {
        return this.groupDao;
    }

    @Override
    public Group selectGroupByName(Integer id) {
        return groupDao.selectGroupByName(id);
    }

}

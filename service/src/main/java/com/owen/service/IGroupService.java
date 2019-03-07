package com.owen.service;

import com.owen.Group;
import com.owen.service.support.IBaseService;

/**
 *  公司服务类
 **/
public interface IGroupService extends IBaseService<Group,Integer> {

    /**
     * 根据法人ID查找公司
     **/
    Group selectGroupByName(Integer id);

}

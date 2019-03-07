package com.owen.dao.repository;

import com.owen.Device;
import com.owen.dao.repository.support.IBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IDeviceDao extends IBaseDao<Device,Integer> {

    Page<Device> findAllByDeviceSnContaining(String searchText, Pageable pageable);

    Page<Device> findAllByGroupIdContaining(String searchText, Pageable pageable);

//    @Modifying
//    @Query(value = "insert into tb_device_group values (?1,?2)",nativeQuery = true)
//    void addMid(Integer d,Integer g);

    Device queryAllByDeviceSn(String str);

//    @Query(value = "SELECT d.* from tb_device d,tb_group g,tb_user u where d.group_id=g.id and g.gua_id=u.id and u.nick_name='?1'",nativeQuery = true)
//    Device selectDeviceByName(String name,Pageable pageable);
}

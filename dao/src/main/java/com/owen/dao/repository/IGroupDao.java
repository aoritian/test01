package com.owen.dao.repository;

import com.owen.Group;
import com.owen.dao.repository.support.IBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IGroupDao extends IBaseDao<Group, Integer> {

    @Query(value = "select g.* from tb_group g,tb_user u where g.gua_id=u.id and g.gua_id= ?1",nativeQuery = true)
    Group selectGroupByName(@Param("guaid")Integer id);

}

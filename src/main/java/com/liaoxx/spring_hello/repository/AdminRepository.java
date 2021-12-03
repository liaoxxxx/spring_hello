package com.liaoxx.spring_hello.repository;

import com.liaoxx.spring_hello.entity.Admin;
import com.liaoxx.spring_hello.entity.AdminUserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

//继承JpaRepository 来完成对数据库的操作
public interface AdminRepository extends JpaRepository<Admin,Integer> , JpaSpecificationExecutor<Admin>   {

    public Admin findByUsername(String username);
    //通过开启 Entity的属性映射查询
    @Query(value = "SELECT ar.name as roleName " +
            "FROM  #{#entityName} ad  " +
            "LEFT JOIN  AdminUserRole aur ON ad.id = aur.adminId " +
            "LEFT JOIN AdminRole ar ON aur.roleId = ar.id " +
            "WHERE ad.id = ?1")
    List<Map<String, Object>> getRoleNames(long adminId);

    @Override
    List<Admin> findAll();


    //
    //@Query("SELECT  ad,ar ,rl FROM admin ad   LEFT JOIN admin_role ar ON ad.id = ar.admin_id  LEFT JOIN  role rl ON ar.role_id = rl.id  where ad.id =?1   ")



}

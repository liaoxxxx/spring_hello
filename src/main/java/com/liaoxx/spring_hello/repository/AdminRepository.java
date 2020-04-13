package com.liaoxx.spring_hello.repository;

import com.liaoxx.spring_hello.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

//继承JpaRepository 来完成对数据库的操作
public interface AdminRepository extends JpaRepository<Admin,Integer> {

    public Admin findByUsername(String username);
    //通过开启 Entity的属性映射查询
    @Query(value = "SELECT rl.roleName as roleName " +
            "FROM  #{#entityName} ad  " +
            "LEFT JOIN  AdminRole ar ON ad.id = ar.adminId " +
            "LEFT JOIN Role rl ON ar.roleId = rl.id " +
            "WHERE ad.id = ?1")
    List<Map<String, Object>> getRoleNames(long adminId);





    /* //通过开启 nativeQuery开启原生语句查询
    @Query(value="SELECT ar.role_name " +
            "FROM  admin  " +
            "LEFT JOIN  admin_role ar ON ad.id = ar.admin_id " +
            "LEFT JOIN role rl ON ar.role_id = rl.id " +
            "WHERE ad.id = ?1",nativeQuery = true)
    List<Map<String, Object>> getRoleNamesNative(int adminId);*/

    //
    //@Query("SELECT  ad,ar ,rl FROM admin ad   LEFT JOIN admin_role ar ON ad.id = ar.admin_id  LEFT JOIN  role rl ON ar.role_id = rl.id  where ad.id =?1   ")



}

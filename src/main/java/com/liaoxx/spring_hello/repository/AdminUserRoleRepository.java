package com.liaoxx.spring_hello.repository;

import com.liaoxx.spring_hello.entity.AdminUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdminUserRoleRepository extends JpaRepository<AdminUserRole, Integer>, JpaSpecificationExecutor<AdminUserRole> {
}
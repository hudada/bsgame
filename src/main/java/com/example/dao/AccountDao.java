package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.bean.AccountBean;

public interface AccountDao extends JpaRepository<AccountBean, Long> {
	@Query("from AccountBean b where b.number=:number and b.pwd=:pwd")
    AccountBean findAccountByNumberAndPwd(@Param("number") String number,
    		@Param("pwd") String pwd);
	
	@Query("from AccountBean b where b.number=:number")
    AccountBean findAccountByNumber(@Param("number") String number);
}

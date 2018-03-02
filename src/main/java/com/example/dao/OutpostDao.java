package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.bean.AccountBean;
import com.example.bean.OutpostBean;

public interface OutpostDao extends JpaRepository<OutpostBean, Long> {
	
	@Query("from OutpostBean o order by o.theOrder")
	List<OutpostBean> findOutpostBeanOrderBy();
	
	@Query("from OutpostBean o where o.theOrder =:theOrder")
	OutpostBean findByTheOrder(@Param("theOrder") int theOrder);
}

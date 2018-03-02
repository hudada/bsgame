package com.example.apicontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.AccountBean;
import com.example.bean.BaseBean;
import com.example.bean.OutpostBean;
import com.example.dao.AccountDao;
import com.example.dao.OutpostDao;
import com.example.utils.ResultUtils;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/outpost")
public class ApiOutpostController {

	@Autowired
	private OutpostDao outpostDao;


	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public BaseBean<List<OutpostBean>> getList() {
		return ResultUtils.resultSucceed(outpostDao.findOutpostBeanOrderBy());
	}
}

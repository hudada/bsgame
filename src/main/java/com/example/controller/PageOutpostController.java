package com.example.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.annotations.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.bean.AccountBean;
import com.example.bean.AdminBean;
import com.example.bean.BaseBean;
import com.example.bean.OutpostBean;
import com.example.dao.AccountDao;
import com.example.dao.AdminDao;
import com.example.dao.OutpostDao;
import com.example.utils.ResultUtils;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import com.example.WebSecurityConfig;

@Controller
@RequestMapping(value = "/page/outpost")
public class PageOutpostController {

	@Autowired
	private OutpostDao outpostDao;

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseBean<OutpostBean> addUser(@RequestBody OutpostBean outpostBean) {
		if(outpostDao.findByTheOrder(outpostBean.getTheOrder())==null) {
			return ResultUtils.resultSucceed(outpostDao.save(outpostBean));
		}else {
			return ResultUtils.resultError("当前关卡已存在");
		}
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseBean<OutpostBean> editPage(@PathVariable String id, @RequestBody OutpostBean outpostBean) {
		OutpostBean bean = outpostDao.findOne(Long.parseLong(id));
		if(outpostDao.findByTheOrder(outpostBean.getTheOrder())==null || 
				bean.getTheOrder() == outpostBean.getTheOrder()) {
			bean.setCmds(outpostBean.getCmds());
			bean.setShowCmds(outpostBean.getShowCmds());
			return ResultUtils.resultSucceed(outpostDao.save(bean));
		}else {
			return ResultUtils.resultError("当前关卡已存在");
		}
		
	}

	@RequestMapping(value = "/detele/{id}", method = RequestMethod.GET)
	@ResponseBody
	public BaseBean<OutpostBean> delUser(@PathVariable String id) {
		outpostDao.delete(Long.parseLong(id));
		return ResultUtils.resultSucceed("");
	}
}

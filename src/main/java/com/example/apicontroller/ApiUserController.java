package com.example.apicontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.AccountBean;
import com.example.bean.BaseBean;
import com.example.dao.AccountDao;
import com.example.utils.ResultUtils;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/user")
public class ApiUserController {

	@Autowired
	private AccountDao accountDao;


	@RequestMapping(value = "/{num}/{pwd}", method = RequestMethod.GET)
	public BaseBean<AccountBean> addUser(@PathVariable String num,@PathVariable String pwd) {
		if (accountDao.findAccountByNumber(num) == null) {
			AccountBean accountBean = new AccountBean();
			accountBean.setNumber(num);
			accountBean.setPwd(pwd);
			return ResultUtils.resultSucceed(accountDao.save(accountBean));
		} else {
			return ResultUtils.resultError("该账号已存在！");
		}
	}


	@RequestMapping(value = "/login/{num}/{pwd}", method = RequestMethod.GET)
	public BaseBean<AccountBean> userLogin(@PathVariable String num,@PathVariable String pwd) {
		AccountBean accout = accountDao.findAccountByNumberAndPwd(num,pwd);
		if (accout != null) {
			return ResultUtils.resultSucceed(accout);
		} else {
			return ResultUtils.resultError("账号或密码不正确");
		}
	}

	@RequestMapping(value = "/where/{num}/{sum}", method = RequestMethod.GET)
	public BaseBean<AccountBean> where(@PathVariable String num,@PathVariable String sum) {
		AccountBean accout = accountDao.findAccountByNumber(num);
		if (accout != null) {
			accout.setCurrwhere(sum);
			return ResultUtils.resultSucceed(accountDao.save(accout));
		} else {
			return ResultUtils.resultError("账号异常");
		}
	}
}

package cn.comesaday.cw.action;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import cn.comesaday.cw.entity.User;
import cn.comesaday.cw.service.UserService;
import cn.comesaday.cw.utils.PageBean;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user = new User();
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	@Resource
	private UserService userService;
	private int currentPage;
	List<User> list = null;
	private static int pageSize = 10;
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String login() {
		User thisUser = userService.login(user);
		if (thisUser != null) {
			return "log_success";
		}
		return "log_fail";
	}
	
	public String info() {
		list = userService.findAll();
		List<User> users = userService.findThisPage(pageSize, currentPage);
 		PageBean pageBean = new PageBean(list.size(), users, pageSize, currentPage);
		ActionContext.getContext().getValueStack().set("page", pageBean);
		if (list != null && list.size() > 0) {
			return "user_info";
		}
		this.addActionMessage("没有人员信息！");
		return "user_info";
	}

}

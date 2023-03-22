package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.dao.MemberDAO;

public class CheckIdService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		
		//Data
		MemberDAO memberDAO = MemberDAO.getInstance();
		String id = request.getParameter("id");
		boolean existId = memberDAO.checkId(id);
		
		//세션 생성
		request.setAttribute("id", id);
		
		if (existId) {
			return "/member/checkIdFail.jsp";
		}
		else {
			return "/member/checkIdOk.jsp";
		}
	}
}
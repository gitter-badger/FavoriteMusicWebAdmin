package mplanweb.music.web.member;

import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	public final static String USER_KEY = "Member";
	
	@Autowired
	private MemberService memberservice;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUp(Model model) {
		model.addAttribute(USER_KEY, new Member());

		return "member/signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUP(@Valid Member member, BindingResult bindingresult) {
		if (bindingresult.hasErrors()) {
			return "member/signup";
		}
		String authority = "ROLE_USER";

		memberservice.adduser(member);
		memberservice.addgroup(member.getMp_userid(), authority);

		return "redirect:/member/main";
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {
		return "member/main";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "member/login";
	}

	@RequestMapping(value = "/editaccount", method = RequestMethod.GET)
	public String editaccount(Principal principal, Model model) {
		Member member = memberservice.getUser(principal.getName());
		model.addAttribute(USER_KEY, member);

		return "member/editaccount";
	}

	@RequestMapping(value = "/editaccount", method = RequestMethod.POST)
	public String editaccount(@Valid Member member,
			BindingResult bindingresult, Principal principal) {
		if (bindingresult.hasErrors()) {
			return "member/editaccount";
		}
		member.setMp_userid(principal.getName());

		int check = memberservice.editAccount(member);
		if (check < 1) {
			throw new AccessDeniedException("비밀번호가 틀립니다.");
		}

		return "redirect:/member/changepasswd";
	}

	@RequestMapping(value = "/changepasswd", method = RequestMethod.GET)
	public String changepasswd(Principal principal, Model model) {
		Member member = memberservice.getUser(principal.getName());

		model.addAttribute(USER_KEY, member);
		model.addAttribute("password", new Password());
		return "member/changepasswd";
	}

	@RequestMapping(value = "/changepasswd", method = RequestMethod.POST)
	public String changepasswd(@Valid Password password,
			BindingResult bindingresult, Model model, Principal principal) {
		if (bindingresult.hasErrors()) {
			Member member = memberservice.getUser(principal.getName());
			model.addAttribute(USER_KEY, member);
			return "member/changepasswd";
		}

		int check = memberservice.changepwd(password.getCurrentPasswd(),
				password.getNewPasswd(), principal.getName());

		if (check < 1) {
			throw new AccessDeniedException("현재 비밀번호가 틀립니다.");
		}
		return "redirect:/member/changepasswd_confirm";
	}

	@RequestMapping(value = "/changepasswd_confirm", method = RequestMethod.GET)
	public String changepasswd_confirm() {
		return "member/changepasswd_confirm";
	}

	@RequestMapping(value = "/drop", method = RequestMethod.GET)
	public String drop() {
		return "member/drop";
	}

	@RequestMapping(value = "/drop", method = RequestMethod.POST)
	public String drop(String mp_userid, String mp_pwd,
			HttpServletRequest request) throws ServletException {

		Member member = memberservice.login(mp_userid, mp_pwd);
		memberservice.drop(member);
		request.logout();

		return "redirect:/member/drop_confirm";
	}

	@RequestMapping(value = "/drop_confirm", method = RequestMethod.GET)
	public String drop_confirm() {
		return "member/drop_confirm";
	}

}

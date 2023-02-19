package my_first_new_spring.my_first_new_spring.controller;

import my_first_new_spring.my_first_new_spring.domain.Member;
import my_first_new_spring.my_first_new_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/login")
    public ModelAndView login(MemberForm memberForm) {
        String result = memberService.login(memberForm.getId(), memberForm.getPassword());
        if (result.equals("login")) {
            ModelAndView modelAndView = new ModelAndView(result);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("member", "id", result);
            return modelAndView;
        }
    }

    @PostMapping("/register")
    public ModelAndView register(MemberForm memberForm) {
        Member member = new Member();
        member.setId(memberForm.getId());
        member.setPassword(memberForm.getPassword());

        memberService.join(member);

        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }
}

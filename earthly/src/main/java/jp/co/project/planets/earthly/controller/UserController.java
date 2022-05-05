package jp.co.project.planets.earthly.controller;

import jp.co.project.planets.earthly.model.dto.UserDetailDto;
import jp.co.project.planets.earthly.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * user controller
 */
@Controller
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    /**
     * new instance user controller
     *
     * @param userService
     *         user service
     */
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    /**
     * 対象ユーザーを取得
     *
     * @param id
     *         ユーザーID
     * @param userDetailDto
     *         ユーザー情報
     * @return ユーザー詳細
     */
    @GetMapping("{userId}")
    public ModelAndView get(@PathVariable("userId") final String id, final HttpServletRequest request,
                            @AuthenticationPrincipal final UserDetailDto userDetailDto,
                            final Principal principal,
                            final Model model) {
        final var userEntity = userService.findById(id, userDetailDto);
        final var modelAndView = new ModelAndView("users/index");
        modelAndView.addObject(userEntity);
        return modelAndView;
    }
}

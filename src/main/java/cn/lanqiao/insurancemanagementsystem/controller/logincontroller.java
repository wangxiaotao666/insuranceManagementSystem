package cn.lanqiao.insurancemanagementsystem.controller;

import cn.lanqiao.insurancemanagementsystem.model.pojo.UserList;
import cn.lanqiao.insurancemanagementsystem.service.UserService;
import cn.lanqiao.insurancemanagementsystem.utils.ResponseUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tAdmin")
public class logincontroller {

    private static final Logger logger = LoggerFactory.getLogger(logincontroller.class);
    //1323
    // 依赖注入
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<ResponseUtils> login(@RequestBody LoginRequest request, HttpServletResponse response) {
        String username = request.getUsername();
        String password = request.getPassword();

        if (username == null || password == null) {
            logger.warn("Login request received with null username or password");
            return new ResponseEntity<>(new ResponseUtils(400, "用户名或密码不能为空"), HttpStatus.BAD_REQUEST);
        }

        logger.info("Received login request for username: {}", username);
        UserList user = userService.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            logger.info("Login successful for username: {}", username);
            Cookie cookie1 = new Cookie("name",user.getName());

            // 设置cookie的存活时间
            cookie1.setMaxAge(60 * 60 * 24);
            // 设置cookie的路径，使其在整个应用中可用
            cookie1.setPath("/");
            response.addCookie(cookie1);

            // 登录成功，返回用户类型
            return new ResponseEntity<>(new ResponseUtils(200, "登录成功", user.getType()), HttpStatus.OK);
        } else {
            logger.warn("Login failed for username: {}. Invalid credentials.", username);
            // 登录失败
            return new ResponseEntity<>(new ResponseUtils(401, "用户名或密码错误"), HttpStatus.UNAUTHORIZED);
        }
    }

    // 定义一个简单的请求对象来接收 JSON 数据
    public static class LoginRequest {
        private String username;
        private String password;

        // Getters and Setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    // 全局异常处理器
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseUtils> handleException(Exception ex) {
        logger.error("An error occurred: ", ex);
        return new ResponseEntity<>(new ResponseUtils(500,
                "服务器内部错误"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
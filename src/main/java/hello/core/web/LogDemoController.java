package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogDemoController {

    @Autowired
    private LogDemoService logDemoService;

//    @Autowired
//    private ObjectProvider<MyLogger> myLoggerObjectProvider;

    @Autowired
    private MyLogger myLogger;


    //request 스콥은 실제 고객의 요청이 들어와야 생성이 된다
    //provider 없이 빌드하면 Scope 'request' is not active for the current thread; 오류
    @ResponseBody
    @GetMapping("log-demo")
    public String logMemo(HttpServletRequest request) {
        System.out.println("myLogger = " + myLogger.getClass());

        String requestURL = request.getRequestURL().toString();
        //MyLogger myLogger = myLoggerObjectProvider.getObject(); 프록시 설정으로 해결
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");

        return "OK";
    }
}

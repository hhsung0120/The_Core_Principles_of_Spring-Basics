package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    @Autowired
    private MyLogger myLogger;

//    @Autowired
//    private ObjectProvider<MyLogger> myLoggerObjectProvider;

    public void logic(String id) {
//        MyLogger myLogger = myLoggerObjectProvider.getObject();
        myLogger.log("service id = " + id);
    }
}

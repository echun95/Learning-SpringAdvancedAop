package study.aop.exam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import study.aop.exam.annotation.Retry;
import study.aop.exam.annotation.Trace;

import java.lang.annotation.Target;

@Slf4j
@Repository
public class ExamRepository {

    private static int seq = 0;

    /**
     * 5번에 1번 실패하는 요청
     */
    @Trace
    @Retry(value = 4)
    public String save(String itemId){
        seq++;
        if(seq % 5 == 0){
            throw  new IllegalStateException("예외 발생");
        }
        return "ok";
    }

}

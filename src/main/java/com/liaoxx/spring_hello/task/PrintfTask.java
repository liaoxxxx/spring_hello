package com.liaoxx.spring_hello.task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class PrintfTask {

    private static final Logger logger= LoggerFactory.getLogger(PrintfTask.class);

   /* @Scheduled(cron = "0/1 * * * * ?")  //配置crontab 等 参数
    public void sc1() {
        System.out.println("线程id:"+Thread.currentThread().getId()+" sc1 " + System.currentTimeMillis());
    }
    @Scheduled(cron = "0/1 * * * * ?")
    public void sc2() {
        logger.info( "线程id:"+Thread.currentThread().getId()+" sc2 ()" + System.currentTimeMillis());

    }*/

    /*@Scheduled(cron = "0/1 * * * * ?")
    public void sc3() throws InterruptedException {

        logger.info( "线程id:"+Thread.currentThread().getId()+" sc3 ()" + System.currentTimeMillis());

        while (true) {
            Thread.sleep(3000);
            logger.info("=======sleep()=======");
        }
    }*/



   /* @Scheduled(cron = "0/1 2 * * * ?")
    @Async  //设为异步多线程执行*/
    public void sc4()  {
        logger.info( "线程id:"+Thread.currentThread().getId()+" sc4 ()" + System.currentTimeMillis());
    }

}

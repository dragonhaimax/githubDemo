package com.max.githubDemo.dao.common;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by max on 22/07/2017.
 */
public class CommonThreadPool {


    private int corePoolSize = 1;
    private int maxPooolSize = 10;
    private int keepAliveSeconds = 60;

    public ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;

    @PostConstruct
    public void init(){
        scheduledThreadPoolExecutor=new ScheduledThreadPoolExecutor(corePoolSize);
        scheduledThreadPoolExecutor.setKeepAliveTime(keepAliveSeconds, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.setMaximumPoolSize(maxPooolSize);
        scheduledThreadPoolExecutor.setCorePoolSize(corePoolSize);

    }

    @PreDestroy
    public void shutdown(){
        if(scheduledThreadPoolExecutor !=null){
            scheduledThreadPoolExecutor.shutdown();
            scheduledThreadPoolExecutor.shutdownNow();
        }
    }


    /**
     *  TO verify  if the threadpool is effective
     *
     *  @return
     *
     */
    public boolean available(){
        return  scheduledThreadPoolExecutor.getQueue().size() <=maxPooolSize;
    }

    /**
     * add missions
     * @param  task
     */

    public void addTask(Runnable task){
        scheduledThreadPoolExecutor.execute(task);
    }
    public int getCorePoolSize() {
        return corePoolSize;
    }

    /**
     * getters and setters
     * @param corePoolSize
     */
    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaxPooolSize() {
        return maxPooolSize;
    }

    public void setMaxPooolSize(int maxPooolSize) {
        this.maxPooolSize = maxPooolSize;
    }

    public int getKeepAliveSeconds() {
        return keepAliveSeconds;
    }

    public void setKeepAliveSeconds(int keepAliveSeconds) {
        this.keepAliveSeconds = keepAliveSeconds;
    }

}
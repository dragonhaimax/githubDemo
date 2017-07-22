package com.max.githubDemo.dao.common;


import com.zwzx.common.spring.PropertiesConfigurer;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by max on 21/07/2017.
 *  NOT very sure the  usage of this class
 */


public class GlobalConfigurations {

    public static boolean  isReleaseMode(){
        return StringUtils.equals(PropertiesConfigurer.getProperty("runmode","local"),"release");
    }
}

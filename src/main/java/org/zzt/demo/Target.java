package org.zzt.demo;

import org.springframework.stereotype.Component;

/**
 * Description: Target 目标类
 * date: 2020/4/18 11:04
 * author: 朱忠涛
 * version: 1.0
 */
@Component
public class Target {

    /**
     * description: 运行
     * version: 1.0
     * date: 2020/4/18 11:05
     * author: 朱忠涛
     *
     * @Param: []
     * @return: void
     */
    public String play(String name){
        return "\n"+name+"正在 play\n";
    }

}

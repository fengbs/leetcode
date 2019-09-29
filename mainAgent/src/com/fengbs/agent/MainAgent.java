package com.fengbs.agent;

import java.lang.instrument.Instrumentation;

/**
 * Created by lideqing@xiaomi.com on 19-9-26
 */
public class MainAgent {
    public static void premain(String agentOps, Instrumentation inst) {
        System.out.println("=========premain方法执行========");
        System.out.println(agentOps);
    }

    public static void premain(String agentOps) {
        System.out.println("=========premain方法执行2========");
        System.out.println(agentOps);
    }
}

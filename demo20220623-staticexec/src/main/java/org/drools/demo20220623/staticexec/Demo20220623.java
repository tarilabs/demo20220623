package org.drools.demo20220623.staticexec;

import org.drools.demo20220623.model.Message;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

public class Demo20220623 {

    public static String message(String inMsg) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieContainer(ks.newReleaseId("org.drools", "demo20220623-rules", "1.0-SNAPSHOT"));
        StatelessKieSession ksession = kc.newStatelessKieSession();

        final Message message = new Message();
        message.setMessage(inMsg);
        message.setStatus(Message.HELLO);

        ksession.execute(message);

        return message.getMessage();
    }

    public static void main(String[] args) {
        System.out.println(message("Hello from an hardcoded message in main"));
    }
}

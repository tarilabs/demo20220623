package org.drools.demo20220623;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.drools.demo20220623.model.Message;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

public class MessageTest {

    @Test
    public void test() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        StatelessKieSession ksession = kc.newStatelessKieSession();

        final List<String> rulesFired = new ArrayList<>();
        ksession.addEventListener(new DefaultAgendaEventListener() {
            @Override
            public void afterMatchFired(AfterMatchFiredEvent event) {
                rulesFired.add(event.getMatch().getRule().getName());
            }
        });

        final Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);

        ksession.execute(message);

        assertThat(message.getMessage()).isEqualTo("Goodbye Z world");
        assertThat(rulesFired).containsExactly("Hello World", "Good Bye");
    }
}

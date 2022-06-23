package org.drools.demo20220623.staticexec;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StaticTest {
    
    @Test
    public void testStaticExec() {
        assertThat(Demo20220623.message("Something")).isEqualTo("Goodbye Z world");
    }
}

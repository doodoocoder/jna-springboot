package org.demo.demo;

import com.sun.jna.Native;
import com.sun.jna.Platform;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JnaConfig {
    @Bean
    public CLibrary getClib(){
        CLibrary INSTANCE = (CLibrary)
                Native.loadLibrary((Platform.isWindows() ? "msvcrt" : "c"),
                        CLibrary.class);
        CLibrary SYNC_INSTANCE = (CLibrary)
                Native.synchronizedLibrary(INSTANCE);
        return SYNC_INSTANCE;
    }
}

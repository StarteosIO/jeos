package io.starteos.jeos.net;

import io.starteos.jeos.net.core.Json_Start;
import io.starteos.jeos.net.protocol.StartService;

public class StartFactory {
    public static StartEOS build(StartService startService) {
        return new Json_Start(startService);
    }
}

package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EnvController {

    @Value("${CF_INSTANCE_INDEX:34}") String cfInstanceIndex;
    @Value("${PORT:8675}") String port;
    @Value("${MEMORY_LIMIT:126}") String memoryLimit;
    @Value("${CF_INSTANCE_ADDR:123.sesame.street}") String address;

    public EnvController() {

    }

    public EnvController(String cfInstanceIndex, String port, String memoryLimit, String address) {
        this.cfInstanceIndex = cfInstanceIndex;
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.address = address;
    }


    @GetMapping("/env")
    public Map<String, String> getEnv() {
        return Map.of("PORT", port, "CF_INSTANCE_INDEX", cfInstanceIndex,
                "MEMORY_LIMIT",memoryLimit, "CF_INSTANCE_ADDR", address);
    }
}

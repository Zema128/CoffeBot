package telega.coffe.bot.command;

import org.checkerframework.checker.units.qual.C;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum Commands {
    START("/start"), STOP("/stop");

    private final String commandName;

    public String getCommandName() {
        return commandName;
    }

    Commands(String commandName) {
        this.commandName = commandName;
    }

    private static final Map<String, Commands> ENUM_MAP;

    static {
        Map<String, Commands> map = new ConcurrentHashMap<>();
        for (Commands instance : Commands.values()) {
            map.put(instance.getCommandName(), instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static Commands get (String name) {
        return ENUM_MAP.get(name);
    }
}

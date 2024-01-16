package cc.carm.tests.easyoptions;

import cc.carm.lib.easyoptions.OptionType;

public interface DemoOptions {

    /**
     * Option descriptions
     */
    OptionType<String> SEPARATOR = OptionType.of(":-:");

    /**
     * This prefix of logger messages.
     */
    OptionType<String> LOGGER_PREFIX = OptionType.of("[EASY-OPTIONS]");

}

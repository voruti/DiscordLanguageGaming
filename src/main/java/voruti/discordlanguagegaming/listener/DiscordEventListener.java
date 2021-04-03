package voruti.discordlanguagegaming.listener;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.StatusChangeEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiscordEventListener implements EventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiscordEventListener.class);

    @Override
    public void onEvent(@NotNull GenericEvent event) {
        if (event instanceof ReadyEvent) {
            LOGGER.info("ReadyEvent");
        } else if (event instanceof StatusChangeEvent) {
            LOGGER.info("{}", event);
        } else {
            LOGGER.debug("Dropped event {}", event);
        }
    }
}

package voruti.discordlanguagegaming.listener;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiscordListenerAdapter extends ListenerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiscordListenerAdapter.class);

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        LOGGER.info("Generous message: {}", event.getMessage());
    }
}

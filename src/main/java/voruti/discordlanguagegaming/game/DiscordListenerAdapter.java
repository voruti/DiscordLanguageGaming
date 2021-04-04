package voruti.discordlanguagegaming.game;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiscordListenerAdapter extends ListenerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiscordListenerAdapter.class);

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (!event.getAuthor().isBot()) {
            LOGGER.info("Generous message: {}", event.getMessage());

            Message msg = event.getMessage();
            msg.delete().queue();

            MessageChannel channel = event.getChannel();
            channel.sendMessage(msg).queue();

            if (msg.getContentRaw().contains("!was")) {
                channel.sendMessage("Man wei\u00DF halt einfach nicht, von wem die Nachricht kommt.").queue();
            }
        }
    }
}

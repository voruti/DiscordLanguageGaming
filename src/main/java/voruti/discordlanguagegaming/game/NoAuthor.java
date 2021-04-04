package voruti.discordlanguagegaming.game;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import voruti.discordlanguagegaming.utility.Constants;
import voruti.discordlanguagegaming.utility.StaticMethods;

public class NoAuthor extends ListenerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoAuthor.class);

    private final long botId;

    public NoAuthor(long botId) {
        this.botId = botId;
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if (event.getAuthor().getIdLong() != botId) {
            LOGGER.debug("Received message: {}", event.getMessage());

            // delete received message:
            Message msg = event.getMessage();
            msg.delete().queue();

            // send same message again:
            MessageChannel channel = event.getChannel();
            channel.sendMessage(msg).queue();

            // respond with help text, if requested:
            if (StaticMethods.messageMatchesCmd(msg, Constants.HELP_CMD)) {
                channel.sendMessage("Man wei\u00DF halt einfach nicht, von wem die Nachricht kommt.").queue();
            }
        }
    }
}

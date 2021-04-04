package voruti.discordlanguagegaming;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import voruti.discordlanguagegaming.game.NoAuthor;

import javax.security.auth.login.LoginException;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public Main() throws InterruptedException {
        LOGGER.info("Started");

        String token = System.getenv("TOKEN");

        try {
            JDA jda = JDABuilder.createDefault(token)
                    .build();
            jda.awaitReady();

            jda.addEventListener(new NoAuthor(jda.getSelfUser().getIdLong()));
        } catch (LoginException | IllegalArgumentException e) {
            LOGGER.error("Exception occurred", e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Main();
    }
}

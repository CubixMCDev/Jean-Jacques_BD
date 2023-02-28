package eu.cubix.mc.bot.discord;

import eu.cubix.mc.bot.discord.events.MemberEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Main {

    public static JDA jda;
    public static String prefix = "!";

    public static void main(String[] args) throws LoginException {
        jda = JDABuilder
                .createDefault(TOKEN)
                .addEventListeners(new MemberEvent())
                .setActivity(Activity.playing("CubixMC"))
                .build();

        System.out.println("I'm connected!");
    }
}

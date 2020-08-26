package eu.cubix.mc.bot.discord.events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class MemberEvent extends ListenerAdapter {

    String[] messagesJoin = {
            "[member] s'est joint. Nous devons construire des pylônes supplémentaires!",
            "Je n'abandonnerai jamais [member]! Je ne laisserai jamais tomber [member]!",
            "Hé! écoutez! [member] a rejoint!",
            "Ha! [member] a rejoint! Vous avez activé ma carte piège!",
            "Nous vous attendions, [member].",
            "Il est dangereux d'y aller seul, prenez [member]!",
            "Swoooosh. [member] vient d'atterrir.",
            "Préparez-vous. [member] vient de rejoindre le serveur.",
            "Un [member] sauvage est apparu.",
            "[member] vient de se glisser sur le serveur!",
            "Ermagherd. [member] est ici.",
            "[member] a rejoint votre parti.",
            "[member] vient de rejoindre le serveur. - glhf",
            "[member] vient de rejoindre. Tout le monde, faites semblant d'être occupé!",
            "[member] vient de rejoindre. Puis-je obtenir un soin?",
            "Bienvenue, [member]. Restez un moment et écoutez",
            "Bienvenue, [member]. Laissez vos armes près de la porte.",
            "Bienvenue, [member]. Nous espérons que vous avez apporté de la pizza.",
            "Préparez-vous. [member] vient de rejoindre le serveur.",
            "[member] vient de rejoindre. Cachez vos bananes.",
            "Un [member] est apparu sur le serveur.",
            "Le grand [member] est apparut!",
            "Où est [member]? Sur le serveur!",
            "[member] a sauté sur le serveur. Kangourou!!",
            "[member] vient d'arriver. Tenez ma bière.",
            "Challenger approche - [member] est apparu!",
            "C'est un oiseau! C'est un avion! Ah non, c'est juste [member].",
            "C'est [member]! Louez le soleil!",
            "Les roses sont rouges, les violettes sont bleues, [member] a rejoint ce serveur.",
            "Bonjour. Est-ce [member] que vous recherchez?",
            "[member] est là pour donner des coups de pied et mâcher du chewing-gum. Et [member] est tout en gomme.",
            "[member] est arrivé. La fête est finie.",
            "Joueur [member] prêt"
    };

    String[] messagesQuit = {
            "[member] nous a malheureusement quitté.",
            "[member] c'est envolé vers d'autres cieux.",
            "[member] a disparrut."
    };

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent e) {
        Random random = new Random();
        int number = random.nextInt(messagesJoin.length);

        EmbedBuilder join = new EmbedBuilder();
        join.setColor(0x4dd91e);
        join.setDescription(messagesJoin[number].replace("[member]", e.getMember().getAsMention()));

        e.getGuild().getDefaultChannel().sendMessage(join.build()).queue();
    }

    @Override
    public void onGuildMemberLeave(GuildMemberLeaveEvent e) {
        Random random = new Random();
        int number = random.nextInt(messagesQuit.length);

        EmbedBuilder quit = new EmbedBuilder();
        quit.setColor(0xd93d1e);
        quit.setDescription(messagesQuit[number].replace("[member]", e.getMember().getAsMention()));

        e.getGuild().getDefaultChannel().sendMessage(quit.build()).queue();
    }

}

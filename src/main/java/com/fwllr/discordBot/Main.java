package com.fwllr.discordBot;

import com.fwllr.discordBot.commands.helloWorld;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.requests.GatewayIntent;
public class Main {
    //Vars for easy modification
    //USE VARIABLES UNDER HERE
    //-------------------------
    private static String botToken = "abc";
    private static String activity = "with your mom";
    private static Long logID = 123L;
    private static Long welcomeID = 123L;
    //--------------------------
    //USE VARIABLES ABOVE HERE


    static JDA bot;
    static TextChannel log;
    static botListeners listeners;

    public static void main(String[] args) {

        System.out.println("Attempting to login to discord...");

        bot = null;


        try {
            bot = JDABuilder.createDefault(botToken)
                    .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                    .enableIntents(GatewayIntent.GUILD_MEMBERS)
                    .enableIntents(GatewayIntent.GUILD_VOICE_STATES)
                    .setActivity(Activity.playing(activity))
                    .addEventListeners(listeners = new botListeners())
                    .addEventListeners(new helloWorld())
                    .build().awaitReady();

            log = bot.getTextChannelById(logID);
            log.sendMessage("The bot has started").queue();

            bot.getGuildById("1037484592254435358").upsertCommand("helloworld", "get me the active developer badge").queue();

            System.out.println("... login succeeded");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (bot == null){
            System.out.println("...login failed");
        }
    }

    public static Long getLogID(){
        return logID;
    }

    public static Long getWelcomeID(){
        return welcomeID;
    }

}
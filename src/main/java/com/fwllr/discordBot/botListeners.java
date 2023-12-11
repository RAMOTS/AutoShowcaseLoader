package com.fwllr.discordBot;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class botListeners extends ListenerAdapter {


    public botListeners(){

    }

    @Override
    public void onGuildVoiceUpdate(GuildVoiceUpdateEvent event) {
        String author = event.getMember().getEffectiveName();
        TextChannel log = event.getJDA().getTextChannelById(Main.getLogID());

        if(event.getChannelJoined() != null){
            String channel = event.getChannelJoined().getName();

            log.sendMessage("The user \"" + author  + " with dc uid: " + event.getMember().getId() + "\" joined the voice channel \"" + channel + "\"").queue();
        }else{
            String channel = event.getChannelLeft().getName();

            log.sendMessage("The user \"" + author + "\" left the voice channel \"" + channel + "\"").queue();
        }
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if(!event.getAuthor().isBot()) {

            String messageContent = event.getMessage().getContentRaw();
            String messageChannel = event.getChannel().getName();
            String messageAuthor = event.getAuthor().getName();

            System.out.println("[" + messageChannel + "]: " + messageAuthor + ": " + messageContent);

            if(!messageContent.equals("")) {
                TextChannel log = event.getJDA().getTextChannelById(Main.getLogID());
                log.sendMessage("A Message was sent in \"" + messageChannel + "\" by User " + messageAuthor + " : " + messageContent).queue();

                //event.getMessage().reply("Thanks for your Message").queue();

                TextChannel channel = event.getChannel().asTextChannel();
                String authorID = event.getMember().getId();
                channel.sendMessage("<@" + authorID + "> send a Message").queue();
            }
        }
    }

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        TextChannel welcome = event.getJDA().getTextChannelById(Main.getWelcomeID());
        TextChannel log = event.getJDA().getTextChannelById(Main.getLogID());
        String joinedMember = event.getMember().getId();

        welcome.sendMessage("Welcome to Mini Varo 1, <@" + joinedMember + ">").queue();
        log.sendMessage("<@" + joinedMember + "> joined the server").queue();
    }
}

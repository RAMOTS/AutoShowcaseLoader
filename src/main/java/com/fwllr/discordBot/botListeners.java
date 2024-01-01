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
    public void onMessageReceived(MessageReceivedEvent event) {

        if(!event.getAuthor().isBot() && event.getChannel() == 730618613609922570L) {
            Message message = event.getMessage();

            List<Message.Attachment> attachments = message.getAttachments();
            if (!attachments.isEmpty()) {
                for (Message.Attachment attachment : attachments) {
                    String mediaUrl = attachment.getUrl();
                    System.out.println("Media URL: " + mediaUrl);
                }
            }

            List<MessageEmbed> embeds = message.getEmbeds();
            if (!embeds.isEmpty()) {
                for (MessageEmbed embed : embeds) {
                    List<MessageEmbed.Field> fields = embed.getFields();
                    for (MessageEmbed.Field field : fields) {
                        if (field.getName().equalsIgnoreCase("image")) { // or check for other types like video, etc.
                            String mediaUrl = field.getValue();
                            System.out.println("Media URL: " + mediaUrl);
                        }
                    }
                }
            }
        }
    }
}

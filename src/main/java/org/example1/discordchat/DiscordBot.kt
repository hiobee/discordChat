package org.example1.discordchat

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.awt.Color
import net.dv8tion.jda.api.events.guild.GuildReadyEvent
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.interactions.commands.build.CommandData
import net.dv8tion.jda.api.interactions.commands.build.Commands

object DiscordBot : ListenerAdapter() {
    private lateinit var plugin: DiscordChat

    fun initialize(plugin: DiscordChat) {
        this.plugin = plugin
    }

    val token = ""
    val jda = JDABuilder.createDefault(token).build()

    fun onSlashCommand(event: SlashCommandInteractionEvent) {
        val commandName = event.name

        // guild, channel Id 가져오기
        if (commandName == "register") {
            val guildId = event.guild?.id
            val channelId = event.channel.id

            val eb = if (guildId != null) {
                EmbedBuilder()
                    .setTitle("성공적으로 연동했습니다.")
                    .setColor(Color.green)
            } else {
                EmbedBuilder()
                    .setTitle("연동하는 데에 문제가 발생했습니다.")
                    .setColor(Color.red)
            }

            val guild = jda.getGuildById(guildId.toString())
            val textChannel = guild?.getTextChannelById(channelId)

            event.replyEmbeds(eb.build()).queue()
        }
    }

    override fun onGuildReady(event: GuildReadyEvent) {
        val commandData = mutableListOf<CommandData>()
        commandData.add(Commands.slash("register", "봇과 서버를 연동합니다."))
        event.jda.updateCommands().addCommands(*commandData.toTypedArray())
    }
}
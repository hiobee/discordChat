package org.example1.discordchat

import org.bukkit.plugin.java.JavaPlugin

class DiscordChat : JavaPlugin() {

    companion object {
        var instance : DiscordChat? = null
        val bot: DiscordBot = DiscordBot
    }

    override fun onEnable() {

        logger.info("DiscordChat plugin")

        instance = this
        bot.initialize(this)

        bot.jda.addEventListener(bot)
    }

    override fun onDisable() {

    }
}

package org.example1.discordchat.Events

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

object ChatEvent : Listener {

    @EventHandler
    fun onPlayerChatEvent(e: AsyncPlayerChatEvent) {

    }
}
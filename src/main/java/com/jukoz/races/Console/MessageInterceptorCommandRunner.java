package com.jukoz.races.Console;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class MessageInterceptorCommandRunner implements ConsoleCommandSender {
    private final StringBuilder msgLog = new StringBuilder();
    //private final Spigot spigotWrapper;
    private final ConsoleCommandSender wrappedSender;

    public MessageInterceptorCommandRunner(ConsoleCommandSender wrappedSender) {
        //this.spigotWrapper = new Spigot();
        this.wrappedSender = wrappedSender;
    }

    public String getMessageLog() {
        return msgLog.toString();
    }

    public String getMessageLogStripColor() {
        return ChatColor.stripColor(msgLog.toString());
    }

    public void clearMessageLog() {
        msgLog.setLength(0);
    }

    @Override
    public void sendMessage(@NotNull String message) {
        //wrappedSender.sendMessage(message);
        msgLog.append(message).append('\n');
    }

    @Override
    public void sendMessage(@NotNull String[] messages) {
        //wrappedSender.sendMessage(messages);
        for (String message : messages) {
            msgLog.append(message).append('\n');
        }
    }

    @Override
    public @NotNull Server getServer() {
        return wrappedSender.getServer();
    }

    @Override
    public @NotNull String getName() {
        return "OrderFulfiller";
    }

    @Override
    public Spigot spigot() {
        return new Spigot();
    }

    @Override
    public boolean isConversing() {
        return wrappedSender.isConversing();
    }

    @Override
    public void acceptConversationInput(String input) {
        wrappedSender.acceptConversationInput(input);
    }

    @Override
    public boolean beginConversation(Conversation conversation) {
        return wrappedSender.beginConversation(conversation);
    }

    @Override
    public void abandonConversation(Conversation conversation) {
        wrappedSender.abandonConversation(conversation);
    }

    @Override
    public void abandonConversation(Conversation conversation, ConversationAbandonedEvent details) {
        wrappedSender.abandonConversation(conversation, details);
    }

    @Override
    public void sendRawMessage(String message) {
        msgLog.append(message).append('\n');
    }

    @Override
    public boolean isPermissionSet(@NotNull String name) {
        return wrappedSender.isPermissionSet(name);
    }

    @Override
    public boolean isPermissionSet(@NotNull Permission perm) {
        return wrappedSender.isPermissionSet(perm);
    }

    @Override
    public boolean hasPermission(@NotNull String name) {
        return wrappedSender.hasPermission(name);
    }

    @Override
    public boolean hasPermission(@NotNull Permission perm) {
        return wrappedSender.hasPermission(perm);
    }

    @Override
    public @NotNull PermissionAttachment addAttachment(@NotNull Plugin plugin, @NotNull String name, boolean value) {
        return wrappedSender.addAttachment(plugin, name, value);
    }

    @Override
    public @NotNull PermissionAttachment addAttachment(@NotNull Plugin plugin) {
        return null;
    }

    @Override
    public @Nullable PermissionAttachment addAttachment(@NotNull Plugin plugin, @NotNull String name, boolean value, int ticks) {
        return null;
    }

    @Override
    public @Nullable PermissionAttachment addAttachment(@NotNull Plugin plugin, int ticks) {
        return null;
    }

    @Override
    public void removeAttachment(@NotNull PermissionAttachment attachment) {
        wrappedSender.removeAttachment(attachment);
    }

    @Override
    public void recalculatePermissions() {
        wrappedSender.recalculatePermissions();
    }

    @Override
    public @NotNull Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return wrappedSender.getEffectivePermissions();
    }

    @Override
    public boolean isOp() {
        return wrappedSender.isOp();
    }

    @Override
    public void setOp(boolean value) {
        wrappedSender.setOp(value);
    }
}
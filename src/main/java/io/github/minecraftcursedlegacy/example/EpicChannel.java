package io.github.minecraftcursedlegacy.example;

import java.nio.charset.Charset;

import io.github.minecraftcursedlegacy.api.networking.PluginChannel;
import net.minecraft.network.PacketHandler;

public class EpicChannel extends PluginChannel {

    @Override
    public String getChannelIdentifier() {
        return "modid:test";
    }

    @Override
    public void onRecieve(PacketHandler arg, byte[] data) {
       System.out.println(new String(data, Charset.forName("UTF-8")));
    }
    
}
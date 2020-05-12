package io.github.minecraftcursedlegacy.example.mixin;

import java.lang.reflect.Field;
import java.nio.charset.Charset;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.minecraftcursedlegacy.example.ExampleMod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.Player;
import net.minecraft.item.BedItem;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;

@Mixin(BedItem.class)
public class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "useOnTile")
	public void useOnTile(ItemInstance arg, Player arg1, Level arg2, int i, int j, int k, int i1, CallbackInfoReturnable<Boolean> info)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		if (arg2.isClient) {
			Field field = Minecraft.class.getDeclaredField("instance");
            field.setAccessible(true);
            Minecraft instance = (Minecraft) field.get(null);
			ExampleMod.channel.send(("This line is printed by an example mod channel!".getBytes(Charset.forName("UTF-8"))), instance);
		}	
	}
}

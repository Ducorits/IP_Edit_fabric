package net.ducorits.ip.edit;

import net.ducorits.ip.edit.item.PortalEditor;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IpEdit implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "ip_edit";
	public static final Logger LOGGER = LogManager.getLogger("ip_edit");
	public static PortalEditor PORTAL_EDITOR;// = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "portal_editor"), new Item(new FabricItemSettings().group(ItemGroup.TOOLS).maxCount(1)));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		PORTAL_EDITOR = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "portal_editor"), new PortalEditor(new FabricItemSettings().group(ItemGroup.TOOLS).maxCount(1)));
		LOGGER.info("Hello Fabric world!");
	}
}

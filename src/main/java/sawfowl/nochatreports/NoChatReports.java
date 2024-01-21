package sawfowl.nochatreports;

import java.nio.file.Path;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.hocon.HoconConfigurationLoader;
import org.spongepowered.configurate.reference.ConfigurationReference;
import org.spongepowered.configurate.reference.ValueReference;
import org.spongepowered.plugin.PluginContainer;
import org.spongepowered.plugin.builtin.jvm.Plugin;

import com.google.inject.Inject;

@Plugin("nochatreports")
public class NoChatReports {

	private static NoChatReports instance;
	private PluginContainer pluginContainer;
	private Logger logger;
	private Path configDir;
	private ForgeUtils forgeUtils = isForge() ? new ForgeUtils() : null;

	private ConfigurationReference<CommentedConfigurationNode> configurationReference;
	private ValueReference<Config, CommentedConfigurationNode> config;

	@Inject
	public NoChatReports(PluginContainer pluginContainer, @ConfigDir(sharedRoot = false) Path configDirectory) {
		instance = this;
		logger = LogManager.getLogger("NoChatReports");
		this.pluginContainer = pluginContainer;
		configDir = configDirectory;
	}

	private void saveConfig() {
		Path configPath = configDir.resolve("Config.conf");
		try {
			configurationReference = HoconConfigurationLoader.builder().path(configPath).build().loadToReference();
			this.config = configurationReference.referenceTo(Config.class);
			if(!configPath.toFile().exists()) {
				configurationReference.save();
			} configurationReference.load();
		} catch (ConfigurateException e) {
			e.printStackTrace();
		}
	}

	public static NoChatReports getInstance() {
		return instance;
	}

	public PluginContainer getPluginContainer() {
		return pluginContainer;
	}

	public Path getConfigDir() {
		return configDir;
	}

	public Logger getLogger() {
		return logger;
	}

	public Config getConfig() {
		if(config == null) saveConfig();
		return config.get();
	}

	public ForgeUtils getForgeUtils() {
		return forgeUtils;
	}

	private boolean isForge() {
		try {
			Class.forName("net.minecraftforge.fml.javafmlmod.FMLModContainer");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}

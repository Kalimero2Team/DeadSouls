import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
    `java-library`
    `maven-publish`
    signing
    id("xyz.jpenilla.run-paper") version "2.2.0"
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0"
}

group = "com.darkyen.minecraft"
version = "2.0.0"
description = "Dead Souls"

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper", "paper-api", "1.20.1-R0.1-SNAPSHOT")
    bukkitLibrary("cloud.commandframework", "cloud-paper", "1.8.4")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

bukkit {
    main = "com.darkyen.minecraft.DeadSouls"
    apiVersion = "1.20"
    load = BukkitPluginDescription.PluginLoadOrder.STARTUP
    authors = listOf("Darkyen")

    
    commands {
        register("souls") {
            description = "View and manipulate souls"
            usage = "/souls"
        }
    }
//        # Internal sub -commands =
//        # /souls page N     Show more souls
//        # /souls free ID    Free given soul
//        # /souls goto ID    Teleport to given soul
    permissions {
        register("deadsouls.hassoul") {
            description = "Has soul that holds onto their items."
            default = BukkitPluginDescription.Permission.Default.TRUE
        }
        register("deadsouls.hassoul.xp") {
            description = "If the player has a soul, it stores their XP"
            default = BukkitPluginDescription.Permission.Default.TRUE
        }
        register("deadsouls.hassoul.items") {
            description = "If the player has a soul, it stores their items"
            default = BukkitPluginDescription.Permission.Default.TRUE
        }
        register("deadsouls.spectatesouls") {
            description = "If the player is in spectator mode, they can see all souls"
            default = BukkitPluginDescription.Permission.Default.TRUE
        }
        register("deadsouls.coordinates") {
            description = "Coordinates of souls are visible in chat output for this player . Not recommended - breaks immersion ."
            default = BukkitPluginDescription.Permission.Default.TRUE
        }
        register("deadsouls.distance") {
            description = "Distance to the soul is visible in chat output for this player . Not recommended - breaks immersion ."
            default = BukkitPluginDescription.Permission.Default.TRUE
        }
        register("deadsouls.souls") {
            description = "List souls with /souls command"
            default = BukkitPluginDescription.Permission.Default.TRUE
        }
        register("deadsouls.souls.all") {
            description = "/souls displays all souls, even those that are not yours"
            default = BukkitPluginDescription.Permission.Default.OP
        }
        register("deadsouls.souls.free") {
            description = "Free to your souls through /souls command and through quick link"
            default = BukkitPluginDescription.Permission.Default.TRUE
        }
        register("deadsouls.souls.free.all") {
            description = "Free anyone 's soul through /souls command"
            default = BukkitPluginDescription.Permission.Default.OP
        }
        register("deadsouls.souls.goto") {
            description = "Teleport to your souls through /souls command"
            default = BukkitPluginDescription.Permission.Default.OP
        }
        register("deadsouls.souls.goto.all") {
            description = "Teleport to any soul through / souls command"
            default = BukkitPluginDescription.Permission.Default.OP
        }
    }
}

tasks {
    runServer {
        minecraftVersion("1.20")
    }
}

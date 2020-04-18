# Better Animals Plus
[![CurseForge](http://cf.way2muchnoise.eu/full_303557_downloads.svg)](https://minecraft.curseforge.com/projects/betteranimalsplus) [![CurseForge](http://cf.way2muchnoise.eu/versions/for%20Minecraft_303557_all.svg)](https://minecraft.curseforge.com/projects/betteranimalsplus/files) <a href="https://discord.betteranimalsplus.com/"> <img src="https://img.shields.io/discord/494803762087591947.svg?logo=discord" alt="Discord"></a>


Better Animals Plus is a Minecraft mod created by Cybercat5555 and its_meow. It adds not only animals but a variety of content, from blocks to armor. Better Animals Plus seeks to bring new life and creatures to your worlds, all with a unique flair and aesthetic compared to other mods of the same category. 

Visit our [website](https://betteranimalsplus.com/) for more information.

For planned features and development, join our [Discord](https://discord.betteranimalsplus.com/) or check out our [Trello](https://trello.com/b/N9Zznyyf/better-animals-plus-minecraft-mod).

## Installation

1. Download the relevant [Minecraft Forge](https://files.minecraftforge.net/) installer for your desired Minecraft version.
2. Download the latest [mod version](https://www.curseforge.com/minecraft/mc-mods/betteranimalsplus/files/all) for your desired Minecraft version (1.12.2-x, 1.14.4-x, etc.)
3. Run the downloaded Minecraft Forge installer.
4. Select `Install client` (if not already selected).
5. Select your `.minecraft` folder if it is not the default one.
6. Press OK.
7. Wait for Forge to finish installing.
8. Navigate to the selected `.minecraft` folder in your file explorer or terminal. On Windows, press WinKey+R and type in the box `%appdata%/.minecraft` and press OK.
9. If there is not a `mods` folder, create one.
10. Place the downloaded mod version in the `mods` folder.
11. Open the Minecraft Launcher.
12. Find the automatically created `forge` profile. (Menu to the left of play button)
    1. If there is not one, go to Installations.
    2. Press `New`.
    3. Name your new profile.
    4. Under `Version`, select the newly installed Forge (likely near the bottom `release x.x.x-forgex.x.x-x.x.x`)
    5. Press `Create`
    6. Select the profile in `Play`.
13. Press play!

## Adding as a dependency

Define `betteranimalsplus_version` in `gradle.properties`, or hardcode the version instead.

Only versions 9.0.1 and above are available on maven.

```groovy
repositories {
    maven {
        url = "https://maven.itsmeow.dev/"
    }
}
dependencies {
    // ForgeGradle 3 (1.13+)
    compileOnly fg.deobf("dev.itsmeow.betteranimalsplus:betteranimalsplus:${project.betteranimalsplus_version}")
    // ForgeGradle 2.x (1.12)
    deobfCompile "dev.itsmeow.betteranimalsplus:betteranimalsplus:${project.betteranimalsplus_version}"
}
```

## Building your own versions

1. Clone the repository or download it as a zip and extract it to a folder
2. Navigate to the folder using command prompt, powershell, or a terminal via `cd (destination folder)`
3. On command prompt: `gradlew build`. On a terminal or powershell: `./gradlew build`. On linux distributions you may need to execute `sudo chmod 777 gradlew` in order to grant execution permissions on `gradlew`.
4. Wait for the build to complete
5. Outputs are placed in `build/libs`. Use the non sources jar and place it in your mods folder.

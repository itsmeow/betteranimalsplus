![Better Animals Plus ~ Breathing new life into your worlds](https://i.imgur.com/Y8Q7ud0.png)

[![CurseForge](https://cf.way2muchnoise.eu/short_303557_downloads.svg?badge_style=for_the_badge)](https://minecraft.curseforge.com/projects/betteranimalsplus) [![CurseForge](https://cf.way2muchnoise.eu/versions/303557_all.svg?badge_style=for_the_badge)](https://minecraft.curseforge.com/projects/betteranimalsplus/files) [![Discord](https://img.shields.io/discord/494803762087591947?label=Discord&logo=discord&style=for-the-badge)](https://discord.betteranimalsplus.com/)

Better Animals Plus seeks to bring new life and creatures to your worlds, all with a unique flair and aesthetic compared to other mods of the same category. The mod adds over 35 animals, and is constantly growing. We add not only animals but a variety of content, from blocks to armor, supplementing the creatures in the mod.

Visit our [website](https://betteranimalsplus.com/) for more information.

For planned features and development, join our [Discord](https://discord.betteranimalsplus.com/) or check out our [Trello](https://trello.com/b/N9Zznyyf/better-animals-plus-minecraft-mod).

## License Statements

These are legally required statements regarding software used by the mod.

### IMDLib

Better Animals Plus depends on and includes [IMDLib](https://github.com/itsmeow/IMDLib), an entity management and configuration library, which is licensed under the [MIT License](https://github.com/itsmeow/IMDLib/blob/1.16/LICENSE).

IMDLib is Copyright itsmeow.

### Fiber

Better Animals Plus and IMDLib depend on and include [Fiber](https://github.com/FabLabsMC/fiber), a Fabric configuration library, which is licensed under the [Apache License 2.0](https://github.com/FabLabsMC/fiber/blob/master/LICENSE).

Fiber is Copyright FabLabsMC. No modifications were made to the original source.

### Jankson

Better Animals Plus, IMDLIB, and Fiber include [Jankson](https://github.com/falkreon/Jankson), an HJSON parser and processor, which is licensed under the [MIT License](https://github.com/falkreon/Jankson/blob/main/LICENSE)

Jankson is Copyright Falkreon.

## Technical Stuff

### Setting Up a Development Environment

1. Clone the repository `git clone https://github.com/itsmeow/betteranimalsplus`
    1. Download & install [git](https://git-scm.com/downloads) if necessary
2. Ensure the JDK 16 is installed
    1. Download & install [JDK 16](https://adoptopenjdk.net/?variant=openjdk16&jvmVariant=hotspot) if necessary
3. Open `build.gradle` in IntelliJ IDEA as a project
   1. Download & install [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) if neccessary
4. Go to `File -> Settings -> Build, Execution, and Deployment -> Build Tools -> Gradle` and ensure `Gradle JVM` is set to Java 16 or higher
5. Wait for the project to sync and index
6. Run the gradle task `genIntellijRuns`
7. Done!

### Building

1. Clone the repository `git clone https://github.com/itsmeow/betteranimalsplus`
   1. Download & install [git](https://git-scm.com/downloads) if necessary
2. Ensure the JDK on your system's PATH is Java 16 or higher
   1. Download & install [JDK 16](https://adoptopenjdk.net/?variant=openjdk16&jvmVariant=hotspot) if necessary
3. Run `./gradlew build` or `gradlew build`, depending on your shell. `chmod +x gradlew` may be required on some filesystems.
4. Done!
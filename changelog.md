# 11.0.3

- Updated Chinese Translation (Thanks chen_index)
- Coyotes can now be bred with antlers
- Fixed butterfly and dragonfly suffocating in farmland
- Fixed variants not re-generating when not found (errored textures on entities when variants are renamed)
- Fixed selective variant config not actually doing anything
- Made coyotes internally no longer extend the Feral Wolf
- Fixed possible desync with internal feature
- Forge 1.17: Fixed pack format version being incorrect
- 1.17&1.18: Fixed rendering crash with internal feature
- Forge 1.17&1.18: Fixed crash at mixin-time without Architectury installed preventing Forge from informing the user Architectury is missing

# 11.0.2

- Updated Russian Translation (Thanks Smollet777)
- Made crabs and horseshoe crabs bucketable
- 1.16: Tweaked deer model and texture to match 1.17/1.18
- Fixed deer looking up slightly all the time
- Fixed development-time dependencies on the mod
- Added missing language entry for config menu - `config.betteranimalsplus.coyote_hostile_daytime`
- Fabric: Fixed crash during mixin-plugin-time if Architectury was not present preventing Fabric from informing the user of missing dependencies
- Fabric: Fixed crash when connecting to dedicated servers

# 11.0.1

- 1.17: Removed goats (including associated items and advancements) due to vanilla adding goats
- 1.17: Tweaked deer model and texture

# 11.0.0

**Architectury is now REQUIRED for Forge and Fabric versions of the mod.**

## Feature Additions

- Remade turkey model and textures
- Remade tarantula model and textures + new variants
- Remade reindeer (+ head) model and textures
- Remade pheasant model and textures
- Remade lammergeier model and textures
- Remade jellyfish model and textures + new variants
- Remade coyote (+ head) model and textures
- Remade bear (+ head) model and textures
- Remade badger model and textures
- Remade boar (+ head) model and textures + new variants
- Remade squirrel model and textures
- Remade horseshoe crab model and textures + new variants
- Updated wolf and bear cape textures
- Updated venison texture
- Generally cleaned up and improve some animations (more sensible leg swing and timing)
- Made lammergeiers attack other types of skeleton (wither, stray)
- Make geese and pheasants drop feathers
- Improved tag compatibility with other mods (Pam's HC, Farmer's Delight) - now with Fabric tags
- Fabric: Added Trinkets compatibility
- Fabric: Added Cloth Config API and Mod Menu compatibility
- Removed large easter egg audios (Crab: now use any disk, Walrus: plays a shorter audio immediately)

## Bugfixes

- Fixed pack format being incorrect
- Fixed jellyfish, lamprey, eels, barracuda, flying fish, and piranha using empty buckets instead of water buckets to be "bucketed"
- Fixed possible crash with Octopus loading
- Fixed some models shaking when the game is 
- Fixed tamed animals attacking other tamed animals from the same owner
- All entities now have their own loot table and can be replaced by datapacks as expected
- Fixed raw language keys when killed by a tarantula hair or badger dirt
- Fixed turkey being unable to place on some blocks with solid tops
- Fixed turkey not breaking when neighbors update to remove support

## Fabric Notes

Fabric is mostly equivalent to Forge, however there are a few key differences.

The configuration is is "json5" format, which is also known as HJSON. It's a modified JSON specification with comment support. There are TOML <-> HJSON converters online that can convert a Forge config for you.

Otherwise, the config is basically equivalent. The Mod Menu compat allows editing of the config through Mod Menu, but you won't be able to edit the config of a currently loaded world, it must be done from the main menu.

Fabric uses Trinkets instead of Curios for the capes, which works basically the same as Curios.

A key problem when using the Fabric version with Trinkets is a crash can occur because of a Cardinal Components incompatibility. I have reported the issue, but as a workaround you can install the standalone Cardinal Components mod from CurseForge.

The last key difference is the default spawn biomes used by the spawning configuration - what biomes will be chosen to spawn an entity in. On Forge, we use the Biome Dictionary, which maps biomes to a set of 'types', like forest, snowy, etc. This does not exist on Fabric, so we made a nearly equivalent API that attempts to guess these based on a variety of attributes.

It is accurate for all vanilla biomes, but may encounter issues with modded biomes. You are always able to correct this in the configuration.

# 10.2.0

## Feature Additions
- Tags for foods (recipe support for Pam's HarvestCraft, etc)
- Configuration options to allow nerfing of boars
- New configuration layout, names, and comments (THIS WILL BREAK YOUR CONFIG! Back them up!)
- Live, in-game reloading of configuration (you need to exit to the menu for full functionality)
- Deer can now additionally be bred with golden carrots, apples, and golden apples (originally wheat and carrots)

## Bugfixes
- Fixed timing of shark and squid attacks
- Fixed some step sounds not working
- Improved code stability and readability
- Fixed turkey block not displaying correctly in campfires or item frames
- Fixed animals with eye glow not looking right/having a fully black texture with most shaders
- Fixed placement of animal heads and turkey blocks in water not waterlogging properly
- Fixed bees not being able to pollinate from trillium (added to small_flowers tag)
- Fixed feral wolves and coyotes not being set to full health when tamed
- Fixed feral wolves and coyotes whimpering at 1/3 health - now is 1/2
- Fixed insect (butterfly/dragonfly) pathfinder pathing to non-air or water blocks
- Fixed butterflies not pathing to a new position after reaching first position
- Tweak crab animations, fix slight floating off ground
- Improved behavior of crab easter egg (auto-expiration of animation)
- Decreased the rate of grass eating in animals that eat grass
- Cleaned up internal tags
- Fixed being unable to equip a cape if anything was in the chestplate slot
- Fixed tamed coyotes and feral wolves being considered hostiles
- Fixed deer not consuming wheat or carrots but still breeding
- Fixed serializable errors on newer Java versions (Java 11+)
- Fixed configuration using last loaded biomes as defaults instead of the actual defaults
- 1.15: Fixed duplicate spawn entries when the world is reloaded
- 1.16: Fixed GlobalEntityTypeAttributes.put warnings on newer Forge versions 
- 1.16: Fixed moose heads and brown bear heads not appearing in the creative menu or JEI
- 1.16: Essential Features portable jukebox compat now works with standalone version
- 1.16: Fixed config loading issues
- 1.16: Fixed animals not spawning in modded biomes properly

## Localization
- Updated Italian translation (Credit: NinoSecret)

# 10.1.0

## Feature Additions

- Added hunger system for predatory animals (read more about it on the wiki)
- Hunger for:
  - Sharks
  - Bears
  - Coyotes
  - Feral wolves
  - Piranhas
  - Barracudas
- Added Curios support for wolf and bear capes
- Added drop-blocking (like the Lamprey has) where killed targets of some animals will not drop items to reduce clutter
- Drop blocking will no longer affect animals from buckets or with special attribute like taming
- Drop blocking for:
  - Barracudas (exception when from bucket)
  - Octopus (exception when tamed or from bucket)
  - Sharks
  - Piranha (exception when from bucket)
  - Lamprey (already present in mod before update, exception when from bucket)
- Added "feral_wolf_tame_armor" tag to allow customizability of the helmet you must be wearing to tame a Feral Wolf
- 1.16: Default spawn biomes will now filter to the OVERWORLD forge Biome Dictionary tag (to prevent spawning in nether forests, etc)
- 1.16: Boars will not attack hoglins

## Bugfixes

- Fixed bug where all foods took 32 ticks to eat instead of 16 for some
- Fixed whales being invisible when they had no pitch
- Fixed deer fawn not following their parents
- Fixed black bear cubs not following their parents
- Fixed black bears not being territorial near players with cubs
- Fixed brown bear cubs following black bear adults
- Fixed bobbit worms not angling correctly when in non-water movable blocks (seagress, kelp)
- Fixed bug where piranhas would spawn adult skeleton horses when a baby horse was killed
- Fixed butterflies and moths sometimes suffocating themselves in walls when launching from a surface
- Fixed geese sometimes spawning naturally as the egg-spawned only variant (white goose)
- Fixed "tamed" octopi despawning
- Fixed bug where hammerhead sharks had no natural spawn biomes
- Fixed crab easter egg animations
- Fixed weird nose cubes on ribbon eel
- Fixed slow pathfinding in sharks, lampreys, giant/colossal squids, and octopus
- Improved land/water pathfinding in octopus
- Fixed octopus being bad at moving downwards
- Fixed giant/colossal squids getting stuck on the surface of water
- Fixed broken "ultimate succening" advancement, now works properly with Whisperwoods zotzpyres.

## Localization

- Updated Russian translation (Credit: Smollet777)
- Updated Spanish translation (Credit: F2P26)

# 10.0.0

## Feature Additions

### Animals

- Add butterflies
- Add dragonflies
- Add barracuda
- Add flying fish
- Add giant squid
- Add colossal squid
- Add piranha
- Add octopus

### Items

- Add bottled butterflies
- Add bottled dragonflies
- Add Bucket of Barracuda
- Add Bucket of Flying Fish
- Add Horseshoe Crab blood
- Add calamari

### Misc

- Add Octopus' Garden advancement
- Add 20,000 Leagues of Trouble advancement
- Add Bug Collector advancement
- Add secret developer feature

## Feature Changes

- 1.15: Remove all mythical features (Hand Of Fate, Zotzpyre, Hirschgeist + Skull + Advancements) They will be moved to our other mod Whisperwoods
- Feral Wolves can now only be tamed when wearing an Ender Dragon head
- Add custom textures for baby boar, deer, goose, pheasant, and turkey
- Add new shark variants (hammerhead, goblin, mako, great white)
- Update model for shark variants (tiger, whitetip, blue)
- Make *all* animals available and non-hostile on Peaceful mode
- Add baby brown bears (any meat)
- Add baby black bears (salmon or honeycomb on 1.15)
- Add baby feral wolves (antlers, must be tamed)
- Add baby badgers (only occur naturally)
- Brown bears, black bears, feral wolves, badgers, boar, crab, deer, goat, goose, horseshoe crab, turkey, squirrel, songbird, and pheasant will now naturally spawn as babies (25% chance)
- Antlers can now be crafted into 3 bonemeal each
- Bears can now rear and will defend their babies, like vanilla polar bears
- Goats will now remember their friend when the world is unloaded

## Localization

- Update Russian Translation
- Made more messages localizable (coyote/feral wolf messages, tooltips, etc)

## Bugs

- Make Lammergeiers Great Again! (No, seriously)
- Fix crashes related to null variants (Shark rendering, whale rendering)
- Fix heads with missing textures
- Add Romanian and Finnish Translations
- Fixed issue with serialization of types
- Fix random crashes when certain entities spawned naturally
- Fixed crash when taming animals
- Fixed reindeer having weird leg placement
- Fixed feral wolves not being able to heal to full health with food
- Fixed coyote, feral wolves, and goats having odd walking animations
- Fixed taranatulas spawning too much / in the light / in the wrong places
- Fixed weird desync with feral wolves and coyotes when sitting (walking while sitting, etc)
- Fix crash with Rosy's Update mod / overwriting vanilla bucket
- 1.15: Fix songbirds sometimes not appearing as landed
- 1.15: Fix walrus not moving when in water
- 1.15: Possibly fix crash with Lammergeier navigation
- 1.15: Fix Feral Wolves not dropping pelts and not changing eyes when tamed

9.0.1
-
- 1.14: Fixed crash when Zotzpyre rode a turtle partially submerged in water
- 1.12: Fixed freshwater eels spawning far too much
- 1.12: Updated Spanish Translation (9.0.0 equivalent)
- 1.12: Updated Russian Translation (9.0.0 equivalent)

9.0.0
-
- Added walrus
- Added geese
- Added whales (beluga, pilot, false killer, narwhal, bottlenose, and Cuvier's)
- Added saltwater eels
- Added freshwater eels
- Added albino deer variants and heads
- Added new deer model
- Added arctic, brown, and red feral wolf variants, capes, pelts, and heads
- Added greenland shark variant
- Improved shark animations
- Added goose egg
- Added golden goose egg
- Added blubber
- Updated advancemnts with new heads
- Added secret with the walrus (they like being fed fried eggs btw)
- Tweaked tarantulas so they rotate when on a wall
- Fix non-honey type badgers spawning in savannas
- Updated Spanish translation (partially updated to 9.0.0)
- Update French translation (8.2 equivalent)
- Update Chinese translation (8.2 equivalent)
- Update Russian translation (partially updated to 9.0.0)
- 1.12: Updated Thaumcraft aspects for new features
- 1.12: Added oredict listAllegg and listAllEgg to custom eggs
- 1.14: Biome based variants now enabled by default in config. No longer affects spawn eggs, only natural spawns. **Existing configs must be updated.**
- 1.14: Added a clientside config, also allows reindeer snow particles to be disabled
- 1.14: Made it so boars retaliate and summon their friends, like in 1.12
- 1.14: Added buckets for some water mobs (lamprey, nautilus, freshwater eel, saltwater eel, jellyfish)
- 1.14: Rewrote the ENTIRE variant system to make more sense and be named.
- 1.14: Rewrote the ENTIRE head-variant system to make more sense and be named.
- 1.14: Rewrites means that some items in worlds will break. **DO NOT take this update lightly. Back up your worlds.**

8.2.1
-
- 1.14: Fix crash "duplicate entity registry entry"

8.2.0
-
- Fix crabs and horseshoe crabs despawning by default (existing configs should be deleted or fixed)
- Remove zotzpyre in peaceful difficulty
- Fix zotzpyre spawning too much in some places
- Fix zotzpyre attacking other monsters (creepers especially)
- Fix zotzpyre sometimes going into ground
- Fix zotzpyre randomly floating mid-air
- Fix zotzpyre "attacking" horses
- Fix zotzpyre being unable to swim
- Fix boars not properly moving to crops
- Update portugeuse translation
- Fix goats not properly breeding from all tempt items and remove carrot on a stick as a tempt item
- Fix entities with nametags despawning if enabled in config
- Improved lamprey animations
- Fix tarantula spawning in deserts being very rare
- 1.14: Fix boars not properly pathing through berry bushes
- 1.14: Fix bears not properly pathing through berry bushes
- 1.14: Fix dispensers not outputting spawn eggs as entities but instead dropping them
- 1.14: Fix possible threading issues from packets
- 1.14: Fix possible configuration editing exploit from client to server
- 1.14: Fix reindeer spawning in frozen oceans
- 1.14: Update AI for lamprey to improve pathfinding
- 1.14: Fix crash with zotzpyre
- 1.14: Make boars immune to berry bush damage
- 1.14: Fix shark teleporting player to them when shot with arrows
- 1.14: Speed up sharks a bit

8.1.1
-
- 1.12: Fix crash with zotzpyre
- 1.12: Fix most of "Received passengers for unknown entity" log spam

8.1.0
-
- Add zotzpyre
- Add bobbit worm
- Revamped shark animations to reduce choppiness
- Added "Ultimate Succening" advancement for getting succed by a lamprey, bobbit worm, and zotzpyre
- Boars will now more actively seek crops to eat them
- Fixed feral wolf tail receding into body when tamed and added wagging for tamed wolves
- Fixed sharks attacking slowly/holding enemies and doing nothing
- Reduced water slowdown of bears
- Made squirrels immune to fall damage
- Added thaumcraft aspects for zotzpyre and bobbit
- Update Spanish translation to 8.1.0 features
- Update Russian translation for 8.0.0 features
- Update Japanese translation for 8.1.0 features
- Update German translation for 8.0.0 features
- Fix some entities with glowing eyes causing water behind them to be invisible
- Fix rare crash caused by some mods with armor displays and modeled armor (capes/hirschgeist skull). Test case Modern Warfare mod.
- 1.14: Brown Bears, Black Bears, and boars will now eat berries similar to foxes
- 1.14: Brown Bears and Black Bears are now immune to bush damage
- 1.14: Brown Bears will now attack salmon
- 1.14: Rewrote shark movement AI
- 1.14: Fixed some water mobs spawning on land (actually this time)

8.0.0
-
- Add moose
- Add turkey
- Add new songbird variant
- Add pheasant egg
- Add turkey egg
- Add fried egg
- Add turkey legs
- Add edible turkey block
- Update models for Feral Wolf (and heads)
- Lower reindeer health to 30
- Split coyote head into its own head (on 1.14 this will request an ID change, you WILL lose any coyote heads upon updating!)
- Add polish translation (slightly out of date)
- Fix being able to breed pheasant with wheat instead of pumpkin seeds
- Make deer drops better (always drop 2 antlers, sometimes venison)
- Fix coyote dropping wolf pelts
- Removed broken update checker
- 1.12: Fix fox dropping wolf pelts
- 1.12: Add oredictionary support to taming items config (format: "ore:oreName")
- 1.12: Add Thaumcraft 6 Aspects
- 1.12: Fix crash from Boar eating crops before the world is loaded
- 1.12: Fix cascading worldgen lag
- 1.12: Fix strange desync with lamprey
- 1.14: Fix heads, hand of fate, and trillium not dropping ever
- 1.14: Add campfire and smoker recipes for most cookables
- 1.14: Make nautilus by default despawn again (oops!)
- 1.14: Add Crab Rave support for Essential Features' Portable Jukebox
- 1.14: Fix crash when placing heads on tall grass or two-high plants
- 1.14: Internally rewrite configs and entity registration
- 1.14: Fix config not always generating with modded biomes (delete configs to get a new one)
- 1.14: Added waterlogging support for heads and hand of fate
- 1.14: Fix tame items config not working
- 1.14: Add tag support for tame item config (format: "#tagdomain:tagname")
- 1.14: Fix some water mobs spawning on land
- 1.14: Fix 'Unknown custom packet identifier' warnings in log

7.1.2
-
- 1.14: Fixed crashes for forge 1.14.4-28.1.0+

7.1.1
-
- Sharks will now retaliate
- Added a configuration option under all entities for despawn allowance
- Sharks now have limits on the size of things they can grab
- 1.14: Fixed "Get Badgered" happening whenever you take damage
- 1.14: Increased nautilus shell drop rate from nautilus (1/500 to 1/25)
- 1.14: Made lammergeiers less derpy and broken
- 1.14: Fixed crash with Forge 28.0.92+ (28.0.92+ REQUIRED for the mod from now on!)

7.1.0
-
- Added 25 advancements
- Entities killed by lamprey no longer drop items, to reduce clutter and lag
- Updated shark animations so their pitch relative to their trajectory
- Fixed lamprey not syncing grabs properly since 7.0.2
- Updated Chinese (simplified) translation
- 1.14: Fixed placement conditions for water entities (fixes things spawning outside of water)
- 1.14: Defer addition of biome generation features to prevent concurrent modification (fixes crash during loading sometimes)
- 1.14: Fix dismount firing on lampreys if the chunk is not loaded (fixes crash when loading new areas)

7.0.2
-
- Updated German Translation
- (Maybe?) Fixed "received passengers for unknown entity" spam
- 1.12: Fixed bear cape not rendering "arms" on armor stand
- 1.14: Fixed crash with shark dismounting targets
- 1.14: Fixed random crash with shark when grabbing some entities like skeletons

7.0.1
-
- Updated Russian Translation
- Updated Japanese Translation
- Added config to allow goat to dispense vanilla milk instead
- Flipped the nautilus so it swims in the right direction
- 1.12: Fixed lamprey spawning in ocean again, darn things!
- 1.12: Fixed snowy/classic wolf cape having broken texture and recipes
- 1.14: Fixed sided crash on server when using entity heads
- 1.14: Fixed crash from breeding unnamed reindeer
- 1.14: Fixed modded biomes not auto-generating in configs (also preventing spawns in modded biomes)
- 1.14: Fixed water entities not always spawning in water properly

7.0.0
-
- Added crabs
- Added nautilus
- Added sharks
- Added horseshoe crabs
- Added bear heads
- Added wolf capes (with baubles support)
- Added wolf pelts, used for crafting capes or wool and leather, drops from wolves
- Added bear capes (with baubles support)
- Added bear skin, used for crafting bear capes or woll and leather, drops from bears
- Added crab meat, drops from crabs
- Added a configuration option to allow variants to be selected based on biomes (white feral wolves -> snowy biomes), off by default
- Added Italian translation, thanks to Gaber373!
- Moved kermode bear into black bear egg as a rare variant
- Renamed creative tab and mod info name from "Better Animals+" to "Better Animals Plus"
- Added a secret with crabs (try mixing the disk of the skeleton and creeper with the raw crustacean) *wink*
- Fixed lampreys not dismounting upon death properly
- Fixed bears sometimes dropping the wrong head type

6.0.3
-
- Fixed random crash killing tameable animals
- Fixed desync of taming item config for servers and clients

6.0.2
-
- Added configuration for taming items
- Fixed milk bucket not being returned (again)
- Fixed crashes caused by animal heads
- Fixed taming items that are replaced by mods not working even though they match
- Fixed some broken loot tables
- Lamprey now drop fish
- Lamprey no longer spawn in the ocean by default (please re-generate configs for this)
- Lamprey now wander when not attacking
- Updated French Translation (Thanks to @Neerwan on GitHub)

6.0.1
-
- Fix crash from Lamprey moving (unknown cause)
- Fix invalid lang key on Hirschgeist daytime attack message

6.0.0
-
- Added Badgers
- Added Lampreys
- Added Songbirds
- Trillium now match biome grass color
- Lammergeiers have new animations
- Deer are breedable (wheat)
- Tamed Fox are breedable (raw rabbit or chicken)
- Hand of Fate has breaking progress and a nicer bounding box
- Deer no longer run without a single leg on the ground
- Deer will eat grass
- Goats will eat grass
- Lammergeiers will now land on the ground before sitting
- Fix some translations that were not working
- Fixed bug with deer drops/loot table causing it to not exist or not drop
- Fixed crashes with DataManager keys on Jellyfish
- Fixed heads with corrupted or invalid NBT data causing client to crash
- Fixed doSpawning config option doing nothing
- Fixed deer head icons not matching their antlers
- Removed doRegister from config
- Added config option to make coyotes always hostile
- Coyotes can now be tamed with cooked or raw chicken, rabbit, and pheasant as opposed to just raw rabbit.
- Code refactors (as usual) that make development easier

5.0.2
-
- Fix bug that caused modded biomes to be unable to spawn BA+ entities and made the configuration unable to affect it

5.0.1
-
- Fix random crash on client when loading chunks with Trillium or Hand of Fate, where the TE loads before the block.

5.0.0
-
- Added Boars
- Added Squirrels
- Added Boar heads
- Animal head items have textures for each variant
- Spawn eggs now show in the Better Animals Plus tab
- Added biomes configuration for spawning
- Fixed jellyfish floating/being too large
- Fixed reindeer neck rotating strangely when eating
- Fixed lammergeiers derping before attacking ("hesitating")
- Fixed minor offsets on resting leg models (should prevent feet half clipping into the ground or being angled)
- Fixed Esperanto translation
- Fixed some random crashes with Entity datamanager (may still afflict old worlds with older entities, try removing mod, loading world, and re-adding mod)
- Redo render factory system (use method references)
- Removed the useless "Common Proxy"


4.1.0
-
- Fixed bug where animal heads would not drop their item after being broken by external sources (like water)
- Added config options to disable natural spawning instead of removing entities alltogether
- Rewrote configuration / entity registration system to add more options (min, max) and categorize entities
- Lowered Coyote and Goat spawnrates slightly
- Increase size of deer hitbox by 0.2 blocks
- Coyotes no longer growl while tamed (unless attacking) and don't bark
- Tamed feral wolves will growl when attacking
- Foxes will not bark
- Fixed bug where HOF recipe was stuck on last oredict for stone
- The wearable Hirschgeist skull can now be repaired with bones and antlers
- Breaking and replacing wolf, deer, or reindeer skull will no longer pick a new variant, but instead persists through the item
- Wolves, deer, and reindeer will drop heads that match their skins
- Drop rate of heads greatly reduced
- Increased goat health
- Lammergeier now accepts any food for healing
- Fixed incorrect translation for "fox" in Hungarian
- Added more oredictionary values for venison (listAllvenisonraw/cooked, foodVenisonraw/cooked) (Pam's HarvestCraft)
- Added fox head (also drops correctly and such)
- Updated all translations for new content except Arabic and Chinese
- Updated hirschgeist skull (wearable) model on head
- Fixed bug where the worn hirschgeist skull would render backwards in the inventory screen

4.0.1
-
- Added naming a reindeer "Rudolph" and fixed spawning logic for red-nosed versions
- Fixed crash with Wings, Horns, and Hooves (chaning internal lang layout)
- Fixed all the translations (big oops)

4.0.0
-
- Added reindeer
- Added reindeer head
- Fixed bug where wolf skulls didn't save their type
- Added both antler variants to the deer head
- Added baby deer
- Added Translation: Hungarian
- Updated Translations:
 -  German
 -  Esperanto
 -  English
 -  Spanish
 -  French
 -  Japanese
 -  Portuguese
 -  Russian

3.0.1
-
- Fixed Hand of Fate breaking bug
- Added a secret :D
- Updated Translations:
 -  German
 -  Esperanto
 -  English
 -  Spanish
 -  French
 -  Japanese
 -  Portuguese
 -  Russian

3.0.0
-
- Added jellyfish
- Added pheasant
- Added pheasant meat
- Fixed bug where bucket would not be returned when making goat cheese
- Adjusted spawn rates, fixed BIG spawning bug

2.0.0
-
- Add goat
- Add goat cheese
- Add goat milk
- Add wolf head (includes coyote)
- Add deer head
- Fix server crash with loading and unloading Trillium on servers
- Fix error in configuration where Hirschgeist spawn weight was named "weight"
- Fix pesky off center-ness with Hirschgeist skull
- Fixed drops and placement being wrong for Hirschgeist skull
- Feral Wolves attack goats
- Fixed some loot tables for mobs
- Fixed large deer hitbox
- Increased size of Wolf/Coyote/Fox hitbox
- Updated translations with new content:
  - English
  - Spanish
  - Russian
  - Japanese
  - Esperanto

1.1.4
-
- New Languages:
  - Arabic (by MicroDroid)
  - German (by ekrempel)
  - Esperanto (by its_meow)
  - English (by its_meow)
  - Spanish (by its_meow and ikerleon02)
  - French (by slabruyere)
  - Japanese (by B_Wither)
  - Portuguese (by alexaldr)
  - Russian (by kellixon)
  - Chinese (Traditional) (by han880805)
  - Chinese (Simplified) (by han880805)



1.1.3
-
- Fixed fatal server crash
- Added config options to disable spawning of mobs/generation of trillium

1.1.2
-
- Reorganized internal codebase
- Fixed bug where some users would experience overspawning
- Updated to new entity registry system (the fix for spawning)
- Added configurable spawning weights (in mod config)
- Update mcmod.info to include proper update/project/site links and fix typo

1.1.1
-
- Added antler drop for deer (My bad)

1.1.0
-
- Added venisons to OreDictionary (listAllmeatraw and listAllmeatcooked)
- Fix hirschgeist bones sometimes moving out of the ghost part
- Added sound for hirschgeist and footstep sounds
- Added Russian Translation (Thank you to kellixon!)
- Fix invalid domain errors (May reset model of trillium and burning status of hand of fate)
- Added particle system (not used)
- Removed misc unused code (reduce filesize, cleanup)
- Added lammergeier landing to make taming easier
- Made some hostile mobs spawn in peaceful but are unable to attack
- Added rotation to trillium (rotate different placement directions like a chest)
- Fix bug where mobs that check for daytime (hirschgeist, coyote) would not always register daytime/nighttime
- Fix hirschgeist spawning in groups of more than one
- Add logo to mcmod.info
- Lammergeier now puts its head down while sitting (midair)
- Buffed feral wolf health (now more than normal wolves)
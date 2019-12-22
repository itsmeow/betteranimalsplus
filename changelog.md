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

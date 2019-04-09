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

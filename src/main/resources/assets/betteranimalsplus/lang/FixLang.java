package assets.betteranimalsplus.lang;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FixLang {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("entity.betteranimalsplus.BrownBear.name");
		set.add("entity.betteranimalsplus.BlackBear.name");
		set.add("entity.betteranimalsplus.KermodeBear.name");
		set.add("entity.betteranimalsplus.Deer.name");
		set.add("entity.betteranimalsplus.Lammergeier.name");
		set.add("entity.betteranimalsplus.FeralWolf.name");
		set.add("entity.betteranimalsplus.Coyote.name");
		set.add("entity.betteranimalsplus.Fox.name");
		set.add("entity.betteranimalsplus.Tarantula.name");
		set.add("entity.betteranimalsplus.Hirschgeist.name");
		set.add("entity.betteranimalsplus.Goat.name");
		set.add("entity.betteranimalsplus.Jellyfish.name");
		set.add("entity.betteranimalsplus.Pheasant.name");
		set.add("entity.betteranimalsplus.Reindeer.name");
		set.add("entity.betteranimalsplus.Boar.name");
		set.add("entity.betteranimalsplus.Squirrel.name");
		for(File file : new File("C:\\Users\\itsmeow\\Desktop\\Development\\Minecraft\\betteranimalsplus\\1.12\\betteranimalsplus\\src\\main\\resources\\assets\\betteranimalsplus\\lang").listFiles()) {
			try {
				if(file.getName().endsWith("us.lang")) {
					Map<String, String> newLine = new LinkedHashMap<String, String>();
					Scanner scanner = new Scanner(file);
					while(scanner.hasNextLine()) {
						String line = scanner.nextLine();
						set.forEach(match -> {
							if(line.contains(match)) {
								newLine.put(line, line.replace(match, match.toLowerCase()) + (scanner.hasNextLine() ? "\n" : ""));
							}
						});
						if(!newLine.containsKey(line)) {
							newLine.put(line, line + (scanner.hasNextLine() ? "\n" : ""));
						}
					}
					scanner.close();
					file.delete();
					file.createNewFile();
					BufferedWriter writer = new BufferedWriter(new FileWriter(file));
					for(String lines : newLine.values()) {
						writer.write(lines);
					}
					writer.close();
					for(String in : newLine.keySet()) {
						System.out.print(in + "     " + newLine.get(in));
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}

package rekt_adventure;

import java.util.Scanner;

class skeleton
{
	static String name = "skeleton";
	static int health = 2;
	static int attack = 2;
	static String swordText = "You swing your sword at the skeleton, causing it to break apart,\n"
		+ " but the falling bones are sharp and one punctures your foot, wounding you slightly.";
	static String gunText = "You shoot the skeleton, causing parts of it to chip away, but it continues towards you.";
	static String deathText = "Your attack caused it to break enough that it is no longer able to fight.";
}

class zombie
{
	static String name = "zombie";
	static int health = 5;
	static int attack = 1;
	static String swordText = "You take a slice at the zombie, but it attacks back, lightly grazing you.";
	static String gunText = "You take a shot at the zombie, but it barely reacts to the bullet.";
	static String deathText = "Your attack causes the attacking zombie to fall to the ground and die.";
}

class imp
{
	static String name = "imp";
	static int health = 1;
	static int attack = 4;
	static String gunText = "You fire a single shot at the imp. The bullet lands right between his eyes and he falls backwards as \n"
			+ "blood begins to trickle from his wound.";
	
	static String swordText = "You charge at the imp with your sword. You take a swing but miss, and your sword creates sparks as it strikes the ground. \n"
			+ "You take another slice at the imps head and cut through it.  While attacking, the imp cut you deeply.";
}

class boss
{
	static String name = "dragon";
	static int health = 5;
	static int attack = 5;
	static String swordText = "You charge the dragon with your sword. You hurt it but it also manages to retaliate before you back off.";
	static String gunText = "You shoot the dragon, and it flinches. It appeared to only injure it slightly. ";
	static String deathText = "After your barrage of attacks, you bested the dragon.";
}

class player
{
	int health = 10;
	int bullets = 4;
}


public class adventure {
	
	public static String combat(String monster, player player, Scanner input)
	{
		String name = "";
		int health = 0;
	    int attack = 0;
		
		if(monster.equals("skeleton"))
		{
			name = skeleton.name;
			health = skeleton.health;
			attack = skeleton.attack;
		}
		
		if(monster.equals("zombie"))
		{
			name = zombie.name;
			health = zombie.health;
			attack = zombie.attack;
		}
		
		if(monster.equals("imp"))
		{
			name = imp.name;
			health = imp.health;
			attack = imp.attack;
		}
		
		if(monster.equals("dragon"))
		{
			name = boss.name;
			health = boss.health;
			attack = boss.attack;
		}
		
		
		while(true)
		{
			System.out.printf("You have %d health left and %d bullets. %n"
					+ "What would you like to do (choose a number)?%n", player.health, player.bullets);
			
			System.out.println("1. Attack with your sword\n"
					+ "2. Shoot it with your gun\n"
					+ "3. Run");
			
			int action = input.nextInt();
			
			if(action == 1)
			{
				if(monster.equals("imp"))
				{
					System.out.println(imp.swordText);
				}
				else if(monster.equals("zombie"))
				{
					System.out.println(zombie.swordText);
				}
				else if(monster.equals("skeleton"))
				{
					System.out.println(skeleton.swordText);
				}
				else
				{
					System.out.println(boss.swordText);
				}
				health-= 2;
				player.health -= attack;
			}
			else if(action == 2)
			{
				if(player.bullets > 0)
				{
				player.bullets--;
				if(monster.equals("imp"))
				{
					System.out.println(imp.gunText);
				}
				else if(monster.equals("zombie"))
				{
					System.out.println(zombie.gunText);
				}
				else if(monster.equals("skeleton"))
				{
					System.out.println(skeleton.gunText);
				}
				else
				{
					System.out.println(boss.gunText);
				}
				health --;
				}
				else
				{
					System.out.println("You are out of bullets! Choose something else.");
				}
			}
			else
			{
				return "ran";
			}
			
			if(health <= 0 && player.health <= 0)
			{
				System.out.println("As you strike the finishing blow, the dragon takes one final swing, and you both fall to the floor, dead.");
				
			}
			
			if(health <= 0)
			{
				if(monster.equals("imp"))
				{
					//System.out.println(imp.deathText);
				}
				else if(monster.equals("zombie"))
				{
					System.out.println(zombie.deathText);
				}
				else if(monster.equals("skeleton"))
				{
					System.out.println(skeleton.deathText);
				}
				else if(monster.equals("dragon"))
				{
					System.out.println(boss.deathText);
				}
				return "victory";
			}
			
			if(player.health <= 0)
			{
				//kill player
				return "defeat";
			}
		}
		
		
		
	}
	
	public static void gameOver()
	{
		System.out.print("~~~~GAME OVER~~~~");
		System.exit(0);
	}
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner input = new Scanner(System.in);
		 
	player player = new player();	
	String r;
	System.out.println("Welcome to The Adventure, created by Brendan Sileo and Nick Orr.");
	System.out.println();
 	System.out.print("You begin your journey as you approach a dreary cave. Bats fly out ");
	System.out.println("as you stand at the mouth of the cave, giving an ominous effect. ");
	System.out.println("Do you enter? (y/n)");
	System.out.println();
	r = input.next();
	//System.out.println("right as you approach the mouth of the cave. Do you enter? (y/n)");
 	
	//If user chooses no, end game.
	if(r.equalsIgnoreCase("n"))
	{
		System.out.print("You choose to not enter the cave. Maybe another time...");
		gameOver();
	}
	
	System.out.println("As you enter the cave, you take inventory of what you have...");
	System.out.println();
	System.out.println("A sword, a gun, four bullets, ten hearts, and a rope.");
	//TODO Add inventory system with hearts and bullets update
	System.out.println();
	System.out.print("You enter a split in the cave. You hear screams from the left and see a distant light to the right.");
	System.out.print("Which way do you want to go?  (l/r)");
	//TODO Add left or right choice

	r=input.next();
	
	if(r.equalsIgnoreCase("l"))
	{
		
	System.out.println("As you walk to the left, the screams become much louder.");
	System.out.println();
//Imp Encounter	
	System.out.print("You enter a room, and see a human figured strung up. Blood is pouring from ");
	System.out.print("their body, and is creating a pool of blood on the ground. ");
	System.out.println();
	
	System.out.print("You see something move in your peripheral vision. An imp jumps in front of you ");
	System.out.println("His appearance is mennacing, but he looks weak.");
	System.out.println();
	r = combat("imp", player, input);
	
	if(r.equals("ran"))
	{
		//Text for running
		System.out.println("You begin to run. The screams are petrifying as you further yourself from them. You think you have gotten away");
		System.out.println(" but you hear a slicing sound and look down to see a sword extending out of your abdomen.");
		System.out.println();
		gameOver();
	}
	else if(r.equals("defeat"))
	{
		gameOver();
	}
	else
	{
	System.out.println();
	
	System.out.println("You look around the room to see there is only one way forward. You procede throught the opening");
	System.out.println();
	
	System.out.print("You enter a room to see there are two paths. One path looks like it leads to an exit.");
	System.out.println("There is an inscription on the cave wall.");
	System.out.println();
	System.out.println("'Voiceless it cries, Wingless flutters, Toothless bites, Mouthless mutters.' ");
	System.out.println();
	System.out.println("You can choose to go left or right (l/r)");
	//TODO Allow user to choose path, but it will do nothing. 
	r = input.next();
	System.out.println("As you are deciding which way to go, a gust of wind sweeps you away from the exit.");
	System.out.print("As you are being carried by the wind, you begin to hear a rattling sound.");
	
	System.out.println();
	
	System.out.println("The wind begins to die down, and you are brought back down to the ground. ");
	System.out.println();
	
	//Dragon Encounter at the bottom as both will be the same final text
	
	}
	}
	
	
	else if(r.equalsIgnoreCase("r"))
	{
	
	//Text for right path
	System.out.print("As you walk to the right, the light becomes dimmer.");
	System.out.println("You hear moaning coming from further down the  hall and then a sharp scream.");
	System.out.print("You enter the room to find a horrifying scene. There is a woman on fire stumbling around the room.");
	System.out.println("");
		
	System.out.println("Out of the corner of your eye, you see a figure moving in a slow, lethargic manner.");
	System.out.println("It appears to be a zombie and it looks tough.");
	
	r = combat("zombie", player, input);
	
	if(r.equals("ran"))
	{
		//Text for running

		System.out.println("You attempt to run away but stumble into the woman on fire. The zombie catches up to you, and bites your neck.");
		System.out.println("Slices of flesh hang from your neck as you attempt to crawl away, but you bleed out quickly.");
		System.out.println();
		gameOver();
	}
	else if(r.equals("defeat"))
	{
		gameOver();
	}
	else
	{
	System.out.println();
	
	
	//Post zombie killing text
	System.out.println("You look around the room to see the woman on fire still walking around, and her body illuminates an exit.");
	System.out.println("You leave the room and begin to hear a rattling sound coming from down the hall.");
	}}
	//Skeleton encounter
	System.out.println("You enter the next room, which is lightly illuminated by torches on the wall.");
	System.out.println("The source of the rattling becomes apparent as a skeleton turns around.");
	System.out.println("Bits of torn flesh hang from its bones, which are lightly stained red. It looks strong, and relatively sturdy for a skeleton.");
	
	r = combat("skeleton", player, input);
	
	if(r.equals("ran"))
	{
		//Text for running
		System.out.println("You attempt to run, but the skeleton is fast. It quickly turns and cuts at your back, cutting your spinal cord, and paralyzing you.");
		System.out.println();
		gameOver();
	}
	else if(r.equals("defeat"))
	{
		gameOver();
	}
	else
	{
	System.out.println();
	
	//Dragon
	System.out.print("You procede past the room and down a tunnel. Suddenly there is a loud roar, and you see fire.");
	System.out.println("You encountered a dragon.");
	System.out.println();
	
	r = combat("dragon", player,input);
	
	if(r.equals("ran"))
	{
		//Text for running
		System.out.print("As you attempt to flee, the dragon lets out a breath of fire. Your skin begins to burn as you crawl towards the exit.");
		System.out.println();
		gameOver();
	}
	else if(r.equals("defeat"))
	{
		gameOver();
	}
	else
	{
	System.out.println();
	System.out.println("Behind the dragon's corpse you discover a room filled with the dragon's treasure. Congratulations, you have survived the cave!\nThe End!");


	}
				}
			}
		
	}
		

			

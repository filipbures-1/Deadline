# 📚 Deadline 
> *A text-based adventure game where procrastination is your enemy and the homework deadline is tomorrow.*


## ℹ️ Overview

**Deadline** is a text-based adventure game where you play as Adam, a student who hasn't done any homework the night before the deadline. Collect items, interact with NPCs, and complete your homework before it's too late!


### ✍️ Authors

  
GitHub: [filipbures-1](https://github.com/filipbures-1)


## ⬇️ Installation

**Requirements:**
- Java 23 or higher
- IntelliJ IDEA (Community or Ultimate Edition)
- Git

**Steps:**

1. **Clone the repository**
   - Open Command Prompt (CMD) or PowerShell
   - Navigate to the folder where you want to download the project:
   ```bash
   cd C:\Users\YourUsername\Desktop
   ```
   - Use this command to clone the repository:
   ```bash
   git clone https://github.com/filipbures-1/Deadline.git
   ```

2. **Open the project in IntelliJ IDEA**
   - Open IntelliJ IDEA
   - Click `File` → `Open`
   - Navigate to the cloned `Deadline` folder and open it

3. **Build JAR file**
   - In IntelliJ IDEA, go to `File` → `Project Structure` → `Artifacts`
   - Click the `+` button → `JAR` → `From modules with dependencies`
   - Select `Main.Main` as the main class
   - Click `OK` and then `Apply`
   - Go to `Build` → `Build Artifacts` → `Build`
   - The JAR file will be created in the `out/artifacts` folder

4. **Run the game**
   - Open Command Prompt (CMD) or PowerShell
   - Navigate to the artifacts folder:
   ```bash
   cd path\to\Deadline-Project\out\artifacts\Deadline_Project_jar
   ```
   - Run the game:
   ```bash
   java -jar Deadline-Project.jar
   ```

*That's it! Enjoy the game!*


## 🎮 How to Play

### Commands
- `talk [NPC name]` - Start a conversation with an NPC
- `move [location]` - Travel to a neighboring location
- `pick [item]` - Pick up an item from the current location
- `drop [item]` - Drop an item from your inventory
- `inventory` - View items in your inventory
- `fight` - Start doing your homework (final challenge)
- `give [NPC] [item]` - Give an item to an NPC
- `steal [item]` - Attempt to steal an item
- `use [item]` - Use an item from your inventory
- `map` - Display the game map
- `hint` - Get a helpful hint
- `help` - Display all available commands
- `exit` - Quit the game

### Objective
1. Gather three essential items: **Homework List**, **Cheatsheet**, and **Homework Photo**
2. Return home with all items
3. Complete the homework by making the right choices
4. Turn in your completed homework to the Principal

### NPCs
- **Andrew** (The Nerd) - Has the homework list
- **Jacob** (Your Friend) - Can help you find the cheatsheet
- **Theodore** (The Bully) - Has the cheatsheet, but wants something in return
- **Adams Mom** - Reminds you about your homework responsibilities
- **Principal** - The final destination for your completed homework


## 📁 Project Structure

```
Deadline-Project/
├── src/
│   ├── Main/           # Game initialization and main loop
│   ├── Characters/     # Player and NPC classes
│   ├── Commands/       # Command pattern implementations
│   ├── Items/          # Item and inventory management
│   └── Locations/      # Room and location classes
├── Resources/
│   ├── gamedata.json   # Game data (NPCs, items, locations)
│   ├── startingtext    # Intro story text
│   ├── help            # Help text
│   ├── hint            # Hint text
│   └── map             # Map layout
└── lib/                # External libraries (Gson)
```


## 🛠️ Technical Features

- **Command Pattern** - Modular command system for easy extensibility
- **JSON Data Loading** - External game data using Gson
- **Object-Oriented Design** - Clean separation of concerns
- **State Management** - Player state, inventory, and room connections
- **Interactive Dialogue System** - Branching conversations with NPCs


## 📚 Libraries Used

- **[Gson](https://github.com/google/gson)** (v2.13.1) - Google's JSON library for Java
  - Used for parsing game data from `gamedata.json`
  - Handles game objects (NPCs, items, locations)

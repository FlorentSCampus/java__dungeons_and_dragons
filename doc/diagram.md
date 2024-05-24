``` mermaid
---
title: Class Diagram
---
classDiagram
    direction RL

    class App

    App -- Game

    %% BOARD %%

    class Board

    Board : -final List~Cell~ cells
    Board : +deleteCell(Cell cell, int playerPosition)

    Board -- Cell
    Board -- Game

    %% CELL %%

    class Cell
    <<Interface>> Cell
    class EmptyCell

    Cell <|.. EmptyCell : implements
    Cell <|.. Enemy : implements
    Cell <|.. Potion : implements

    %% DICE %%

    class DefaultDice
    class Dice
    <<Interface>> Dice
    class FakeDice

    Dice <|.. DefaultDice : implements
    Dice <|.. FakeDice : implements
    Dice -- Game

    %% ENEMY %%

    class Dragon
    class Enemy
    class Goblin
    class Necromancer

    Enemy <|-- Dragon : extends
    Enemy <|-- Goblin : extends
    Enemy <|-- Necromancer : extends

    %% GAME %%

    class Game

    Game : -final Board board
    Game : -final Dice dice
    Game : -final Menu menu
    Game : -int playerPosition
    Game : -boolean isWon
    Game : -boolean isGameOver
    Game : -final List~Player~ players
    Game : +init()
    Game : +launch()

    %% MENU %%

    class GameMenu
    class InitMenu
    class Menu

    GameMenu : -Scanner scanner
    GameMenu : -String userValue
    GameMenu : +rollDice(Player player) boolean
    GameMenu : +gameStat(int roleValue, int playerPosition)
    GameMenu : +playerStat(Player player)
    GameMenu : +displayCell(Cell cell)
    GameMenu : +isWon()
    GameMenu : +isGameOver()
    GameMenu : +isNewGame() boolean
    GameMenu : +battlePhase(Player player, Cell cell) boolean
    GameMenu : +battleInfo(Player player, Cell cell)

    InitMenu : -Warrior warrior
    InitMenu : -Wizard wizard
    InitMenu : -Scanner scanner
    InitMenu : -String userValue
    InitMenu : -String playerName
    InitMenu : -String playerJob
    InitMenu : -final int JOB_SELECTION_MENU
    InitMenu : -final int JOB_INFO_MENU
    InitMenu : -final int PLAYER_INFO_MODIFICATION_MENU
    InitMenu : -final int PLAYER_VALIDATION_MENU
    InitMenu : -final int CREATION
    InitMenu : -int menuIndex
    InitMenu : +create() Player
    InitMenu : +isNewGame() boolean
    InitMenu : +jobInfo() int
    InitMenu : +modifyPlayerInfo() int
    InitMenu : +validationPlayerInfo() int
    InitMenu : +createPlayer() Player

    InitMenu -- Warrior
    InitMenu -- Wizard

    Menu : -GameMenu gameMenu
    Menu : -InitMenuu initMenu

    Menu -- GameMenu
    Menu -- InitMenu
    Menu -- Game

    %% PLAYER %%

    class Player
    <<Abstract>> Player
    class Warrior
    class Wizard

    Player : #String name
    Player : #String job
    Player : #int health
    Player : #int strength
    Player : #DefStuff defStuff
    Player : #OffStuff offStuff

    Player <|-- Warrior : extends
    Player <|-- Wizard : extends
    Player -- DefStuff
    Player -- OffStuff
    
    %% POTION %%

    class Potion
    <<Abstract>> Potion
    class MaxiPotion
    class MiniPotion

    Potion : #String category
    Potion : #String name
    Potion : #int care

    Potion <|-- MaxiPotion : extends
    Potion <|-- MiniPotion : extends

    %% STUFF %%

    class Stuff
    <<Abstract>> Stuff
    class DefStuff
    <<Abstract>> DefStuff
    class Barrier
    class WoodenPanel
    class OffStuff
    <<Abstract>> OffStuff
    class Fire
    class Fireball
    class Lightning
    class IronMass
    class MithrilSword
    class WoodenSword

    Stuff : #String category
    Stuff : #String name
    Stuff : #int stat

    DefStuff <|-- Barrier : extends
    DefStuff <|-- WoodenPanel : extends
    OffStuff <|-- Fire : extends
    OffStuff <|-- Fireball : extends
    OffStuff <|-- Lightning : extends
    OffStuff <|-- IronMass : extends
    OffStuff <|-- MithrilSword : extends
    OffStuff <|-- WoodenSword : extends
    Stuff <|-- DefStuff : extends
    Stuff <|-- OffStuff : extends
```
<br><br><br><br><br>

``` mermaid
---
title: Use Case Diagram
---
sequenceDiagram

Game ->> GameMenu : 
GameMenu ->> rollDice() : throw dice
rollDice() -->> Game : true
Game ->> GameMenu : 
GameMenu ->> isWon() : 
isWin() ->> Game : "you won !"
Game ->> GameMenu : 
GameMenu ->> gameStat() : 
GameMenu ->> playerStat() : 
GameMenu ->> displayCell() : 
GameMenu ->> battlePhase() : 
GameMenu ->> isGameOver() : 
```
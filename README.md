# Math in Casinos: Video Poker

This project implements a **Video Poker** game, following the *Double Bonus 10/7* variant. It was developed as part of the *Object-Oriented Programming (OOP)* course (MEEC/LEEC – IST, 2021/22). The program simulates both interactive and automated play, using perfect strategy to achieve statistically accurate results.

## 🎯 Project Overview

Video Poker is a computerized version of five-card draw poker. The player places a bet, receives five cards, and chooses which to hold or discard. The program replaces the discarded cards and evaluates the final hand based on a paytable. In this project, the **Double Bonus 10/7** paytable is used, offering realistic casino payouts and strategy-driven play.

## 🧩 Features

* **Two Modes of Play**:

  * **Debug Mode** (`-d`): Loads pre-defined cards and commands from files for deterministic testing.
  * **Simulation Mode** (`-s`): Automatically plays multiple rounds using the optimal strategy to calculate average returns.
* **Perfect Strategy** implementation based on *Wizard of Odds*.
* **Statistical Output** displaying:

  * Frequency of each winning hand type.
  * Player’s final credit and theoretical return percentage.
* **Command-Line Interface (CLI)** with commands for betting, dealing, holding, advice, and statistics.

## ⚙️ Usage

### Debug Mode

```bash
java -jar VideoPoker.jar -d <credit> <cmd-file> <card-file>
```

### Simulation Mode

```bash
java -jar VideoPoker.jar -s <credit> <bet> <nbdeals>
```

### Commands

| Command | Description                                  |
| ------- | -------------------------------------------- |
| `b [i]` | Bet a specified amount (default: 5 credits). |
| `$`     | Display current credit.                      |
| `d`     | Deal a new hand.                             |
| `h`     | Hold specified cards.                        |
| `a`     | Show optimal advice (perfect strategy).      |
| `s`     | Show game statistics.                        |

## 📁 Project Structure

```
.
├── UML/        # UML diagrams
├── JDOC/       # JavaDoc documentation
├── TESTS/      # Sample command and card files
├── DOCS/       # Self-assessment and project documentation
└── VideoPoker.jar
```

## 🧠 Technical Details

* Language: **Java**
* Paradigm: **Object-Oriented Programming**
* Concepts used: Encapsulation, inheritance, polymorphism, and open–closed principle.
* Includes both **short-pay** and **full-pay** game variants.


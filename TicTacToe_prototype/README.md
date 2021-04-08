# HyperSkill Project: Tic-Tac-Toe with AI

Credit: https://hyperskill.org/projects/81

## About
Everybody remembers this paper-and-pencil game from childhood: Tic-Tac-Toe, also known as Noughts and crosses or Xs and Os. A single mistake usually costs you the game, but thankfully it is simple enough that most players discover the best strategy quickly. Let’s program Tic-Tac-Toe and get playing!

## Current Stage #5/5: An undefeated champion
Oh no, what have we created here? An unbeatable AI monster! Indeed, this complex algorithm guarantees a win or a draw.

### Description

Congratulations, you've almost reached the finish line! To complete the task, it's now time to turn the AI into a strong opponent by adding a hard difficulty level.

Unlike medium, when the AI is playing at hard level, it doesn't just look one move ahead to see an immediate win or prevent an immediate loss. At this level, it can look two moves ahead, three moves ahead, and even further. It can calculate all possible moves that might be played during the game, and choose the best one based on the assumption that its opponent will also play perfectly. So, it doesn't rely on the mistakes of its opponent and plays the game without fault from start to finish regardless of the opponent's skill!

The algorithm that implements this is called minimax. It's a brute force algorithm that maximizes the value of the AI's position and minimizes the worth of its opponent's. Minimax is not just for Tic-Tac-Toe. You can use it with any other game where two players make alternate moves, such as chess.
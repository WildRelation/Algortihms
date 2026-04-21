---
type: entity
tags: [rekursion, backtracking, sökning, optimering]
created: 2026-04-21
updated: 2026-04-21
sources: [F6-Backtracking]
---

# Backtracking

Backtracking är en rekursiv sökteknik där man **avbryter en sökstig så snart man vet att den inte kan leda till en bättre lösning** än den vi redan hittat.

## Grundidé

1. Utforska rekursivt alla möjliga lösningsvägar
2. Håll koll på bästa lösning hittills (`bestSoFar`)
3. Om nuvarande stig redan är sämre → returnera direkt (prune/klipp)

## Exempel: Hissen i lustiga huset

**Problem:** n våningar, upp/ned-knappar, hitta min antal resor.

**Utan backtracking (DFS med maxdjup):** ~22 miljoner anrop för nrOfTrips(78,15,8,35)

**Med backtracking (bestSoFar):**
```java
if (trips >= bestSoFar) return Integer.MAX_VALUE/2;
// ... fortsätt sök
if (bestSoFar > nrOfUp + trips) bestSoFar = nrOfUp + trips;
```
→ ~46 000 anrop — **500× färre!**

**Med BFS:** 1630 iterationer ([[BFS]])

## Mönster

```java
void search(State s, int bestSoFar) {
    if (isGoal(s)) { updateBest(s); return; }
    if (cannotImprove(s, bestSoFar)) return;  // PRUNE
    for (State next : neighbors(s)) {
        search(next, bestSoFar);
    }
}
```

## Viktiga detaljer

- Returnera `Integer.MAX_VALUE/2` (inte `MAX_VALUE`) för att undvika overflow vid addition
- `bestSoFar` kan skickas som parameter eller lagras i instansvariabel (men undvik globala variabler!)
- Fungerar bäst när lösningsrymden är strukturerad och tidig avbrytning är möjlig

## Vanliga backtracking-problem

- Hissen (kortaste väg)
- N-drottningproblemet
- Sudoku-lösare
- Kombinatorisk optimering

## Relaterat

- [[Rekursion]] — backtracking bygger på rekursion
- [[DFS]] — backtracking är DFS med pruning
- [[BFS]] — alternativ sökteknik (garanterar kortaste väg)

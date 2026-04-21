---
type: entity
tags: [sökning, BFS, graf, kö, algoritm]
created: 2026-04-21
updated: 2026-04-21
sources: [F6-Backtracking, F11-GrafDijkstraPrim]
---

# BFS — Bredden-först-sökning (Breadth-First Search)

BFS utforskar alla noder på nivå k **innan** den går till nivå k+1. Den garanterar **kortaste vägen** (mätt i antal steg).

## Grundalgoritm

```java
Queue<State> q = new ArrayDeque<>();
q.offer(startState);
while (!q.isEmpty()) {
    State t = q.poll();
    if (isGoal(t)) return t;
    for (State neighbor : getNeighbors(t)) {
        q.offer(neighbor);
    }
}
```

## Varför kö?

- Funktionsanrop hamnar på en **stack** → naturligt DFS (djupet-först)
- För BFS behöver vi **FIFO** → explicit [[Kö]]
- "Stacken har vi gratis. Kön måste vi hantera själva."

## Hissen i lustiga huset — BFS-lösning

```java
Queue<State> q = new ArrayDeque<>();
State t = new State(1, 0);  // startposition=1, resor=0
while (t.position != destination && t.nrOfTrips < 100) {
    if (t.position + up <= levels)   q.offer(new State(t.position+up, t.nrOfTrips+1));
    if (t.position - down >= 1)      q.offer(new State(t.position-down, t.nrOfTrips+1));
    t = q.poll();
}
return t.nrOfTrips;
```
**Resultat:** 1630 iterationer vs. ~22 miljoner för naiv DFS!

## BFS vs. DFS

| | BFS | DFS |
|--|-----|-----|
| Datastruktur | Kö (FIFO) | Stack (LIFO) / rekursion |
| Garanterar kortaste väg | Ja ✓ | Nej |
| Minnesbehov | O(b^d) (brett) | O(d) (djup) |
| Lämpar sig | Kortaste vägen | Existensproblem, backtracking |

## Komplexitet

- O(V + E) där V = antal noder, E = antal kanter

## Relaterat

- [[DFS]] — alternativ traversering
- [[Kö]] — datastruktur som möjliggör BFS
- [[Graf]] — BFS används för graftraversering
- [[Dijkstras algoritm]] — viktat kortaste-vägen (generalisering av BFS)

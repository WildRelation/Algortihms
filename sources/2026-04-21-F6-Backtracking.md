---
type: source-summary
tags: [rekursion, backtracking, BFS, DFS, hanoi]
created: 2026-04-21
lecture: F6
---

# F6 — Rekursion och Backtracking

**Ämnen:** Rekursiv lista, Hissen i lustiga huset, BFS med kö, Tornet i Hanoi, Backtracking

## Kärninnehåll

**Rekursiv definition av länkad lista:**
> En länkad lista är antingen tom eller består av en nod med en referens till ett data och en referens till en länkad lista.

**Hissen i lustiga huset** — klassiskt sökproblem
- n våningar, upp-knapp (upp våningar), ned-knapp (ned våningar)
- Hitta minsta antal resor från våning 1 till destination

**DFS (djupet-först) via rekursion:**
- Naivt: oändlig loop utan maxdjup
- Med maxdjup (30): fungerar men godtyckligt
- Antal anrop: ~22 miljoner för nrOfTrips(78,15,8,35)

**BFS (bredden-först) via kö:**
- Garanterar kortaste vägen
- State-klass: `{position, nrOfTrips}`
- Algoritm: kö med startposition, dequeue → enqueue grannar
- Antal iterationer: **1630** för samma problem!
- Kön hanteras explicit (stacken var gratis vid rekursion)

**Tornet i Hanoi** — O(2^n)
```java
static void hanoi(int n, int f, int t, int x){
    if(n>0){ hanoi(n-1,f,x,t); println(f+"->"+t); hanoi(n-1,x,t,f); }
}
```
- Flytta n-1 till hjälppinne, flytta 1 till mål, flytta n-1 till mål

**Backtracking:**
- Avbryt sökning när vi vet att lösning inte finns längs den vägen
- "bestSoFar"-teknik: om trips >= bestSoFar, avbryt
- Dramatisk minskning av antal anrop

**Nyckelinsikt:** DFS via stack (rekursion), BFS via kö (iteration).

---
type: entity
tags: [graf, kortaste vägen, Dijkstra, algoritm, heap]
created: 2026-04-21
updated: 2026-04-21
sources: [F11-Graf-Dijkstra-Prim, F14-Dynamisk-Programmering]
---

# Dijkstras algoritm

Dijkstras algoritm hittar kortaste vägen från en **startnod** till **alla övriga noder** i en viktad graf med icke-negativa vikter.

## Pseudokod

```
T = V                          // alla noder ej klara
för alla v∈T: d(v) = ∞
d(s) = 0
Medans T ≠ ∅:
    u = nod i T med minst d(u)  // kräver min-heap för effektivitet
    T = T – {u}
    För alla v angränsande till u:
        Om d(v) > d(u) + w(u,v):
            d(v) = d(u) + w(u,v)   // relaxering
            p(v) = u               // för att rekonstruera vägen
```

## Exempelkörning (graf A–H, start A)

| Steg | Behandlar | Uppdateringar |
|------|----------|---------------|
| 1 | A (d=0) | F=1, B=2, D=? |
| 2 | F (d=1) | D=2, G=6 |
| 3 | B,D (d=2) | C=4, E=5 |
| 4 | C (d=4) | H=5 |
| 5 | E,H (d=5) | G=6 (oförändrad) |

**Slutresultat:** A=0, B=2, C=4, D=2, E=5, F=1, G=6, H=5

## Komplexitet

| Implementation | Komplexitet |
|---------------|------------|
| Naiv (array) | O(V²) |
| PriorityQueue (min-[[Heap]]) | O((V+E) log V) |

## Krav

**Icke-negativa vikter!** Med negativa vikter: använd [[Floyd-Warshall]] (alla par) eller Bellman-Ford (en källa).

## Relation till Prim

[[Prims algoritm]] är nästan identisk — enda skillnaden:
- Dijkstra: `d(v) = d(u) + w(u,v)` (avstånd från källan)
- Prim: `d(v) = w(u,v)` (bara kantvikten)

## Relation till dynamisk programmering

Dijkstra kan ses som [[Dynamisk programmering]] — sparar kortaste kända väg till varje nod och återanvänder vid beräkning av grannars avstånd.

## Java-implementation

```java
PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
int[] dist = new int[n]; Arrays.fill(dist, Integer.MAX_VALUE);
dist[src] = 0;
pq.offer(new int[]{src, 0});
while (!pq.isEmpty()) {
    int[] curr = pq.poll();
    int u = curr[0], d = curr[1];
    if (d > dist[u]) continue;  // redan behandlad
    for (int[] edge : adj[u]) {
        int v = edge[0], w = edge[1];
        if (dist[u] + w < dist[v]) {
            dist[v] = dist[u] + w;
            pq.offer(new int[]{v, dist[v]});
        }
    }
}
```

## Relaterat

- [[Graf]] — datastruktur algoritmen opererar på
- [[Heap]] — PriorityQueue används för effektiv implementation
- [[BFS]] — Dijkstra är en viktad generalisering av BFS
- [[Prims algoritm]] — nästan identisk, hittar MST
- [[Floyd-Warshall]] — alternativ för alla par, hanterar negativa vikter

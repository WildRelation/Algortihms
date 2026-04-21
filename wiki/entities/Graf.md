---
type: entity
tags: [graf, datastruktur, nod, båge, viktad graf]
created: 2026-04-21
updated: 2026-04-21
sources: [F11-Graf-Dijkstra-Prim, F12-Giriga-Algoritmer]
---

# Graf

En graf G = (V, E) består av en mängd **noder** (vertices, V) och **bågar** (edges, E) som förbinder par av noder.

## Typer

| Typ | Förklaring |
|-----|-----------|
| Oriktad | Bågar utan riktning (A–B = B–A) |
| Riktad (digraf) | Bågar har riktning (A→B ≠ B→A) |
| Viktad | Varje båge har ett tal (vikt/kostnad) |
| Oviktad | Inga vikter |
| Sammanhängande | Det finns en väg mellan alla par av noder |
| Träd | Sammanhängande graf utan cykler |

## Representation

### Grannmatris (Adjacency Matrix)
`boolean adj[V][V]` — adj[i][j] = true om kant (i,j) finns
- Minne: O(V²)
- Kontrollera kants existens: O(1)
- Lista alla grannar till en nod: O(V)

### Grannlista (Adjacency List)
`List<Integer>[] adj` — adj[i] = lista av grannar
- Minne: O(V + E)
- Lista alla grannar till en nod: O(grannantal)
- Att föredra för glesa grafer

## Traversering

- [[BFS]] — bredden-först via [[Kö]]
- [[DFS]] — djupet-först via [[Rekursion]]/stack

## Kortaste vägen

| Problem | Algoritm | Komplexitet |
|---------|---------|------------|
| En källa, positiva vikter | [[Dijkstras algoritm]] | O((V+E)log V) |
| Alla par, ev. negativa vikter | [[Floyd-Warshall]] | O(V³) |
| Oviktad (antal kanter) | [[BFS]] | O(V+E) |

## Minimalt spännträd (MST)

- [[Prims algoritm]] — O((V+E)log V) med heap
- Kruskals algoritm — O(E log E)

## Relaterat

- [[BFS]] — graftraversering
- [[DFS]] — graftraversering
- [[Dijkstras algoritm]] — kortaste vägen
- [[Floyd-Warshall]] — kortaste vägen alla par

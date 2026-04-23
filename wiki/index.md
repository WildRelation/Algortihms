---
type: index
updated: 2026-04-21
---

# Wiki — Masterkatalog

> Underhålls automatiskt av wiki-agenten. Redigera inte manuellt.

---

## Entiteter (`wiki/entities/`)

### Datastrukturer
- [[Stack]] — LIFO; push/pop/peek O(1); array- och länkad-listaimpl; postfix-evaluering
- [[ADT Lista]] — interface, ArrayList, LinkedList; add O(1) amortera, get O(1)
- [[Länkad lista]] — enkel/dubbel/cirkulär; Iterator; O(n²) om index-loop!
- [[Kö]] — FIFO; cirkulär array; JCF Queue/ArrayDeque; O(1) allt
- [[Mängd]] — Set-ADT; HashSet, TreeSet, BitSet
- [[Avbildning]] — Map-ADT; nyckel-värde-par; HashMap, TreeMap
- [[Hashtabell]] — O(1) lookup; öppen adressering; länkning; load factor 75%
- [[Binärt träd]] — terminologi; full/perfekt/komplett/balanserat
- [[Binärt sökträd]] — BST; O(log n); traversering inorder=sorterat; borttagning 3 fall
- [[Heap]] — prioritetskö; komplett binärt träd; array-impl; insert/deleteMin O(log n)
- [[Graf]] — V+E; grannmatris/grannlista; BFS/DFS; kortaste vägen

### Algoritmer och paradigm
- [[Rekursion]] — basfall; rekursionsträd; svansrekursion; fibonacci; GCD
- [[Backtracking]] — DFS + pruning; bestSoFar; 500× färre anrop
- [[BFS]] — bredden-först; kö; garanterar kortaste väg; O(V+E)
- [[DFS]] — djupet-först; rekursion/stack; existensproblem
- [[Binär sökning]] — O(log n); kräver sorterat; T(n)=1+T(n/2)
- [[O-notation]] — Big-O; formell def; amorterad analys; klasser
- [[Dijkstras algoritm]] — kortaste väg från en källa; positiva vikter; O((V+E)log V)
- [[Floyd-Warshall]] — kortaste väg alla par; negativa vikter OK; O(V³)
- [[Girig algoritm]] — lokalt bästa val; optimal för schemaläggning, EJ alltid annars
- [[Söndra och härska]] — divide+conquer+combine; T(n)=2T(n/2)+n → O(n log n)
- [[Dynamisk programmering]] — överlappande delproblem; top-down/bottom-up; memoization

### Sortering
→ se [[Sorteringsalgoritmer]] (topic) för komplett jämförelsetabell

---

## Teman (`wiki/topics/`)

- [[Sorteringsalgoritmer]] — Komplett tabell: selection, insertion, shell, merge, heap, quick, counting, radix

---

## Syntesser (`wiki/synthesis/`)

- [[studieplan]] — 44-dagarsplan mot betyg C; fas 1–4; tentataktik och uppgiftsprioriteringar
- [[tentaanalys]] — Fullständig analys av 8 gamla tentor (2022–2025); frekvenstabeller; korrigerade prioriteringar
- [[iterator-djupdykning]] — Komplett guide: Iterable vs Iterator, O(n) vs O(n²), implementering av inre klass, tentavarianter

---

## Källor (`sources/`)

### Föreläsningar

| Fil | Ämne |
|-----|------|
| `2026-04-21-F1-ADT-Lista-On.md` | ADT, Lista, ArrayList, O-notation |
| `2026-04-21-F2-LankadLista-Iterator.md` | Länkad lista, Iterator, dubbellänkad |
| `2026-04-21-F3-Stack.md` | Stack, LIFO, ArrayStack, LinkedStack, postfix |
| `2026-04-21-F4-Ko.md` | Kö, FIFO, cirkulär array, JCF Queue |
| `2026-04-21-F5-Rekursion.md` | Rekursion, binär sökning, fibonacci, GCD |
| `2026-04-21-F6-Backtracking.md` | Backtracking, BFS, DFS, Hanoi |
| `2026-04-21-F7-Trad-BST.md` | Träd, BST, traversering, borttagning |
| `2026-04-21-F8-Mangd-Hash.md` | Mängd, avbildning, hashtabell, kollision |
| `2026-04-21-F9-Sortering.md` | Sortering, selection, insertion, shell |
| `2026-04-21-F10-Heap-Sortering.md` | Heap, heapsort, counting sort, radix |
| `2026-04-21-F11-Graf-Dijkstra-Prim.md` | Graf, Dijkstra, Prim |
| `2026-04-21-F12-Giriga-Algoritmer.md` | Giriga algoritmer, växel, kappsäck |
| `2026-04-21-F13-Sondra-Harska.md` | Söndra-härska, maximal delsekvens, skyline, closest pair |
| `2026-04-21-F14-Dynamisk-Programmering.md` | DP, fibonacci, Floyd-Warshall, kappsäck, Held-Karp |

### Gamla tentor

| Fil | Tenta |
|-----|-------|
| `2026-04-21-tenta-2025-06-03.md` | 2025-06-03 — matrisväg, iterator, BST, MST/Prim |
| `2026-04-21-tenta-2025-03-10.md` | 2025-03-10 — Kö, skolgårdslek, BST, söndra-härska |
| `2026-04-21-tenta-2024-06-04.md` | 2024-06-04 — iterator, backtracking, Heap, BST-complete |
| `2026-04-21-tenta-2024-03-13.md` | 2024-03-13 — Stack, nå-1-problem, BST, labyrint BFS |
| `2026-04-21-tenta-2023-06-07.md` | 2023-06-07 — BST-BFS, matrismax, mergesort, HashMap-par |
| `2026-04-21-tenta-2023-03-15.md` | 2023-03-15 — parenteser/Stack, klocka DP, BST, heap-validering |
| `2026-04-21-tenta-2022-06-10.md` | 2022-06-10 — BST, hoppspel BFS, selection sort, Dijkstra |
| `2026-04-21-tenta-2022-03-17.md` | 2022-03-17 — LinkedList, matrismax, BST, kappsäck |

---

## Statistik

| Mått              | Värde      |
| ----------------- | ---------- |
| Entiteter         | 22         |
| Teman             | 1          |
| Syntesser         | 3          |
| Föreläsningar     | 14 av 14 ✓ |
| Gamla tentor      | 8 av 8 ✓  |
| Senast uppdaterad | 2026-04-22 |

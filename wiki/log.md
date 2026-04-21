---
type: log
updated: 2026-04-21
---

# Aktivitetslogg

> Kronologisk historik över alla wiki-operationer.

---

## 2026-04-21

### SETUP — Wiki initierad
- Skapade mappstruktur och CLAUDE.md

### INGEST — F1–F14 (13 föreläsningar, F3 Stack saknar wikisida)

**Källfiler skapade (sources/):**
F1, F2, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13, F14

**Entiteter skapade (wiki/entities/):**
- ADT Lista, Länkad lista, Kö, Mängd, Avbildning
- Hashtabell, Binärt träd, Binärt sökträd, Heap, Graf
- Rekursion, Backtracking, BFS, DFS, Binär sökning
- O-notation, Dijkstras algoritm, Floyd-Warshall
- Girig algoritm, Söndra och härska, Dynamisk programmering

**Teman skapade (wiki/topics/):**
- Sorteringsalgoritmer — komplett jämförelsetabell

**Ingest F3 Stack (komplettering):**
- `sources/2026-04-21-F3-Stack.md`
- `wiki/entities/Stack.md`

**Syntes skapad:**
- `wiki/synthesis/studieplan.md` — 44-dagarsplan mot betyg C baserad på tentaanalys 2022–2026

**Wikin är nu komplett: alla 14 föreläsningar ingestade, 22 entiteter, 1 tema, 1 syntes.**

### INGEST — 8 gamla tentor (2022–2025)

**Källfiler skapade (sources/):**
- `2026-04-21-tenta-2025-06-03.md` — matrisväg, iterator, BST höjd/barnbarn, MST Prim
- `2026-04-21-tenta-2025-03-10.md` — Kö enkellänkad, skolgårdslek DP, BST add/perfekt, söndra-härska
- `2026-04-21-tenta-2024-06-04.md` — LinkedList iterator, backtracking matris, Heap impl, BST complete
- `2026-04-21-tenta-2024-03-13.md` — Stack enkellänkad, nå-1 rekursion+DP+BFS, BST höjd/siblings, labyrint BFS
- `2026-04-21-tenta-2023-06-07.md` — BST BFS-traversering, matrismax rekursion+DP, mergesort, HashMap par-sökning
- `2026-04-21-tenta-2023-03-15.md` — parenteser Stack, klocka rekursion+DP, BST find/grandChild/secondSmallest, heap-validering
- `2026-04-21-tenta-2022-06-10.md` — BST add+size, hoppspel BFS, selection sort, Graf+Dijkstra
- `2026-04-21-tenta-2022-03-17.md` — LinkedList remove+size, matrismax rekursion+DP, BST toString+isBalanced, kappsäck

**Syntessida skapad:**
- `wiki/synthesis/tentaanalys.md` — fullständig frekvensanalys av 8 tentor, korrigerade prioriteringar

**Viktig korrigering:** Uppgift 6 är INTE alltid HashMap. Uppgift 5 är inte alltid BST (Heap 2024-06, Mergesort 2023-06). BST, Rekursion+DP och BFS är de tre absolut viktigaste ämnena.

---

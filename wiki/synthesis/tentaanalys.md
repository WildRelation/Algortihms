---
type: synthesis
tags: [tentaanalys, mönster, betyg-C]
created: 2026-04-21
updated: 2026-04-21
sources: [tenta-2025-06-03, tenta-2025-03-10, tenta-2024-06-04, tenta-2024-03-13, tenta-2023-06-07, tenta-2023-03-15, tenta-2022-06-10, tenta-2022-03-17]
---

# Tentaanalys — 8 tentor 2022–2025

Baserad på fullständig genomläsning av alla 8 tillgängliga gamla tentor (2022–2025).

---

## Tentastruktur

- **Del 1** (15p): 2 teorifrågor (2p) + programmeringsuppgifter 3–6
- **Del 2**: Uppgift 7 — avancerad problem (bedöms bara om C nåtts på Del 1)
- **Betyg C**: 12–13p beroende på år (varierar), minst 1p på teorin

---

## Uppgift 3 — Datastruktur-implementation (3p, varannan tenta)

> OBS: "Godkänd på krysstalen" → hoppar över uppgift 3. Alltid 3p.

**Vad som dyker upp:**

| Tenta | Uppgift 3 |
|-------|-----------|
| 2025-06 | Matrisväg minsta summa (rekursion+DP) ← AVVIKELSE |
| 2025-03 | **Kö** med enkellänkad lista (enqueue/dequeue/peak/isEmpty O(1)) |
| 2024-06 | SingleLinkedList iterator + iterator(index) |
| 2024-03 | **Stack** med enkellänkad lista (pop/peek/push/isEmpty O(1)) |
| 2023-06 | BST bredd-först traversering (BFS, returnera String) |
| 2023-03 | **Parenteser** med Stack (matchning av ()[]{})) |
| 2022-06 | BST add + size (rekursivt) |
| 2022-03 | LinkedList remove + size (rekursivt) |

**Mönster:** Alternerar mellan Stack, Kö, LinkedList och BST-metoder. Ibland Stack-applikation (parenteser). **Alltid grundläggande O(1)-implementering.**

**Nyckelkunskap:** [[Stack]], [[Kö]], [[Länkad lista]], [[Binärt sökträd]]

---

## Uppgift 4 — Rekursion + Dynamisk programmering (4–6p, ALLTID)

**Alltid tvådelad: rekursiv lösning + DP-optimering.**

| Tenta | Uppgift 4 |
|-------|-----------|
| 2025-06 | LinkedList iterator (avvikelse — 3p) |
| 2025-03 | Skolgårdslek: max stenar (rekursion 2p + DP 2p) |
| 2024-06 | Matrisväg backtracking (4p) ← avvikelse |
| 2024-03 | Nå 1 via operationer (rekursion 2p + DP 2p + BFS 2p) |
| 2023-06 | Matris maximal summa (rekursion 3p + DP 2p) |
| 2023-03 | Klockproblem (rekursion 2p + DP 2p) |
| 2022-06 | Hoppspel (BFS, 5p) ← avvikelse |
| 2022-03 | Matris maximal summa (rekursion 3p + DP 2p) |

**Mönster:** Nästan alltid: rekursiv lösning → sedan DP-optimering av samma problem. Tre av åtta tentor är matrisproblem. Backtracking förekommer. BFS förekommer.

**Nyckelkunskap:** [[Rekursion]], [[Dynamisk programmering]], [[Backtracking]], [[BFS]]

---

## Uppgift 5 — BST-metoder (1–4p, ALLTID BST utom 2024-06)

| Tenta | Uppgift 5 |
|-------|-----------|
| 2025-06 | BST höjd (1p) + noder med 2 barnbarn (2p) |
| 2025-03 | BST add (2p) + perfektträd check (2p) |
| 2024-06 | **Min-heap implementation** (4p) ← avvikelse |
| 2024-03 | BST höjd (1p) + höjd med data (1p) + siblings (2p) |
| 2023-06 | Mergesort implementation (3p) ← avvikelse |
| 2023-03 | BST find (2p) + nrOneGrandChild (1p) + secondSmallest (1p) |
| 2022-06 | Sortering minsta platsbyten / Selection sort (2p) |
| 2022-03 | BST toString inorder (1p) + isBalanced (2p) |

**Mönster:** BST dyker upp i 5 av 8 tentor i uppgift 5. Undantagen är Heap (2024-06) och Sortering (2023-06, 2022-06).

**Nyckelkunskap:** [[Binärt sökträd]], [[Heap]], [[Sorteringsalgoritmer]]

---

## Uppgift 6 — Varierad (2–3p)

| Tenta | Uppgift 6 |
|-------|-----------|
| 2025-06 | MST / Prim, O(V²) (3p) |
| 2025-03 | Räkna target i sorterad array (söndra-härska) (2p) |
| 2024-06 | BST complete-check (2p) |
| 2024-03 | Labyrint med fällor, BFS ← Del 2-typ (uppgift 6 här) |
| 2023-06 | Par med given summa med HashMap O(n) (2p) |
| 2023-03 | Min-heap validering (array-check) (2p) |
| 2022-06 | Graf + Dijkstra (grannlista, kortaste väg) (3p) |
| 2022-03 | Kappsäck / kartongpackning (DP eller girig) (2p) |

**Mönster:** Uppgift 6 är den mest varierade. BFS/Graf, BST-check, HashMap, Heap-validering, DP, Prim. **Ingen tydlig upprepning.**

---

## Uppgift 7 (Del 2) — Avancerat sökproblem (3+p)

| Tenta | Uppgift 7 |
|-------|-----------|
| 2025-06 | Sammanhängande område med minsta summa (BFS/backtracking) |
| 2025-03 | Solitärspelet 4×4 (backtracking, dragsekvens) |
| 2024-06 | 3×3 rotationspussel (BFS state-space, antal drag) |
| 2024-03 | — (uppg 6 var labyrinten) |
| 2023-06 | Antal möjliga vägar i stad (DP/backtracking) |
| 2023-03 | NY-stad: hotell → alla sevärdheter (BFS, TSP-variant) |
| 2022-06 | Kulor i gropar (BFS/backtracking, minsta drag) |
| 2022-03 | Robotnavigering (BFS, antal sträckor) |

**Mönster:** Alltid ett kreativt sökproblem. **BFS eller backtracking är grunden.** Ofta State-klass-mönstret.

---

## Teorifrågorna (uppgift 1–2) — Exakta frågor per tenta

| Tenta | Fråga 1 | Fråga 2 |
|-------|---------|---------|
| 2025-06 | Definiera ett [[Binärt sökträd]] | Vad är en algoritm? |
| 2025-03 | Förklara [[O-notation]] O(n³), ge 2 exempel som skiljer sig | Vad är en [[Länkad lista\|iterator]]? När/varför viktigt? |
| 2024-06 | Vad är en [[ADT Lista\|abstrakt datatyp]]? Förhållande till datastrukturer? | [[Sorteringsalgoritmer\|Selection sort]] — O för jämförelser och platsbyten |
| 2024-03 | Rekursiv vs iterativ — för- och nackdelar ([[Rekursion]]) | [[Heap]] — O för insättning och borttagning, motivera |
| 2023-06 | [[ADT Lista\|add(E)]] på lista med array — O i olika fall, amorterat | `equals` och `hashCode` från Object — hur hänger de ihop? ([[Hashtabell]]) |
| 2023-03 | Fullt, komplett och balanserat [[Binärt träd]] — definiera | [[Mängd]] och [[Avbildning]] — beskriv och implementering |
| 2022-06 | Varför analysera algoritmers effektivitet teoretiskt? ([[O-notation]]) | [[ADT Lista\|Array]] vs [[Länkad lista]] — minst 2 för- och nackdelar |
| 2022-03 | [[Sorteringsalgoritmer\|Quicksort]] worst-case O(n²) — hur uppkommer det? | [[Hashtabell\|Öppen adressering]] — hur hanterar kollisioner för put/get/remove |

### Frekvens per wikisida

| Wikisida | Antal gånger som teorifråga |
|----------|-----------------------------|
| [[O-notation]] | 3 (O(n³), effektivitet, amorterad add) |
| [[Binärt sökträd]] | 1 (definition) |
| [[Binärt träd]] | 1 (full/komplett/balanserat) |
| [[Rekursion]] | 1 (rekursiv vs iterativ) |
| [[Heap]] | 1 (O insättning/borttagning) |
| [[ADT Lista]] | 2 (abstrakt datatyp, add(E) amorterad) |
| [[Länkad lista]] | 2 (iterator, array vs länkad) |
| [[Hashtabell]] | 2 (equals/hashCode, öppen adressering) |
| [[Mängd]] | 1 (definition + implementering) |
| [[Avbildning]] | 1 (definition + implementering) |
| [[Sorteringsalgoritmer]] | 2 (selection sort O, quicksort worst-case) |

**Teorifrågorna är breda men [[O-notation]], [[Hashtabell]] och [[Sorteringsalgoritmer]] är mest frekventa. Läs igenom alla wikisidor i listan ovan.**

---

## Frekvensanalys — Vad är viktigast?

| Ämne | Uppgifter | Prioritet |
|------|-----------|-----------|
| [[Binärt sökträd]] | Uppg 3, 5, 6 (5–6 av 8 tentor) | ⭐⭐⭐ KRITISK |
| [[Rekursion]] + [[Dynamisk programmering]] | Uppg 4 (7 av 8 tentor) | ⭐⭐⭐ KRITISK |
| [[BFS]] | Uppg 4,6,7 (6 av 8 tentor) | ⭐⭐⭐ KRITISK |
| [[Stack]] | Uppg 3 (3 av 8 tentor) | ⭐⭐ HÖG |
| [[Kö]] | Uppg 3 (2 av 8 tentor) | ⭐⭐ HÖG |
| [[Länkad lista]] | Uppg 3,4 (4 av 8 tentor) | ⭐⭐ HÖG |
| [[Backtracking]] | Uppg 4,7 (4 av 8 tentor) | ⭐⭐ HÖG |
| [[Heap]] | Uppg 5,6 (3 av 8 tentor) | ⭐ MEDEL |
| [[Sorteringsalgoritmer]] | Uppg 5 (2 av 8 tentor) | ⭐ MEDEL |
| [[Dijkstras algoritm]] / Graf | Uppg 6 (2 av 8 tentor) | ⭐ MEDEL |
| [[Hashtabell]] | Uppg 6 (1 av 8 tentor) | ⭐ MEDEL |

---

## Korrigering av studieplan

> [!warning] Studieplan uppdaterades baserat på ny analys
> Ursprunglig studieplan antog att uppgift 6 alltid var HashMap — det stämmer INTE. Uppgift 6 är den mest varierade uppgiften. Se [[studieplan]] för uppdaterad version.

**Prioritetsordning för betyg C (reviderad):**
1. BST-metoder (höjd, add, find, traversering, barnräkning) — uppgift 3 eller 5
2. Rekursion + DP-optimering av samma problem — uppgift 4
3. Stack eller Kö med länkad lista — uppgift 3
4. BFS grundmönster (State-klass, kö, memoization) — uppgift 4, 6, 7
5. Backtracking-mönster — uppgift 4, 7

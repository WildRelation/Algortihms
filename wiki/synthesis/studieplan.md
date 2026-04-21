---
type: synthesis
tags: [studieplan, tenta, betyg-C]
created: 2026-04-21
updated: 2026-04-21
---

# Studieplan — Algoritmer och datastrukturer
**Tentadatum:** 2026-06-04 | **Mål:** Betyg C eller högre | **Dagar kvar:** 44

---

## Vad tentan testar (baserat på gamla tentor 2022–2026)

Tentan har 5 programmeringsuppgifter (uppgift 3–7). Mönstret är konsekvent:

| Uppgift | Typisk uppgift | Nyckelkunskap |
|---------|---------------|---------------|
| 3 | Implementera en datastruktur (Kö, Stack, länkad lista) | [[Kö]], [[Stack]], [[Länkad lista]] |
| 4 | Rekursion eller DP (nrOfCombinations, växel) | [[Rekursion]], [[Dynamisk programmering]] |
| 5 | BST-operation (find, traversering, countInRange) | [[Binärt sökträd]] |
| 6 | HashMap/HashSet (mostRepeated, ordfrekv.) | [[Hashtabell]], [[Avbildning]] |
| 7 | BFS/kortaste vägen (labyrint, hiss) | [[BFS]], [[Graf]] |

**För betyg C:** Klara uppgift 3, 5 och 6 helt + delar av 4 och 7.

---

## Fas 1 — Grunder (dag 1–14, t.o.m. 2026-05-04)

Mål: Förstå alla datastrukturer och deras komplexitet. Kunna spåra algoritmer för hand.

### Vecka 1 (dag 1–7): F1–F7
| Dag | Ämne            | Uppgift                                                             | Wikisida                      |
| --- | --------------- | ------------------------------------------------------------------- | ----------------------------- |
| 1   | O-notation, ADT | Beräkna T(n) för 3 kodsnuttar                                       | [[O-notation]], [[ADT Lista]] |
| 2   | ArrayList       | Implementera add(index,e) och remove(index)                         | [[ADT Lista]]                 |
| 3   | Länkad lista    | Implementera iterator, spåra O(n²)-faran                            | [[Länkad lista]]              |
| 4   | Stack           | Implementera ArrayStack komplett + postfix-evaluering               | [[Stack]]                     |
| 5   | Kö              | Implementera cirkulär array-kö (enqueue, dequeue, peek, reallocate) | [[Kö]]                        |
| 6   | Rekursion       | Skriv: fibonacci (rekursivt + iterativt), GCD, binär sökning        | [[Rekursion]]                 |
| 7   | Repetition V1   | Spåra Stack, Kö, Länkad lista för hand med papper                   | —                             |

### Vecka 2 (dag 8–14): F7–F10
| Dag | Ämne | Uppgift | Wikisida |
|-----|------|---------|---------|
| 8 | BST grunder | Rita BST för indata {5,3,7,1,4,6,8}, spåra inorder | [[Binärt sökträd]] |
| 9 | BST operationer | Implementera: add, find, inOrder-traversering | [[Binärt sökträd]] |
| 10 | BST borttagning | Implementera remove (alla 3 fall), nrOfValuesInRange | [[Binärt sökträd]] |
| 11 | Hashtabell | Öppen adressering för hand (insert 5 element, kollision) | [[Hashtabell]] |
| 12 | HashMap i Java | Implementera mostRepeated med HashMap. Implementera wordCount | [[Hashtabell]], [[Avbildning]] |
| 13 | Backtracking | Spåra hiss-problemet med DFS+backtracking | [[Backtracking]], [[DFS]] |
| 14 | Repetition V2 | Gamla tentor: gör uppgift 5+6 från 2024-06-04 | — |

---

## Fas 2 — Fördjupning (dag 15–28, t.o.m. 2026-05-18)

Mål: Behärska BFS, Dijkstra, sortering och rekursiva mönster. Börja lösa hela tentor.

### Vecka 3 (dag 15–21): F9–F11
| Dag | Ämne | Uppgift | Wikisida |
|-----|------|---------|---------|
| 15 | Sortering | Spåra Selection sort och Insertion sort för hand på {5,2,8,1,9} | [[Sorteringsalgoritmer]] |
| 16 | Mergesort | Implementera mergesort rekursivt | [[Sorteringsalgoritmer]] |
| 17 | Heap | Bygg en min-heap för hand: insert {6,18,8,20,28,39,29}. Implementera offer/poll. | [[Heap]] |
| 18 | BFS grundläggande | Implementera BFS för hiss-problemet (uppgift 7 mönster) | [[BFS]] |
| 19 | BFS på bräde | Implementera shortestPath på 2D-bräde (labyrint/uppgift 7) | [[BFS]] |
| 20 | Dijkstra | Spåra Dijkstra för hand på exempelgrafen. Implementera med PriorityQueue | [[Dijkstras algoritm]] |
| 21 | Repetition V3 | Gamla tentor: gör uppgift 3+7 från 2025-06-03 | — |

### Vecka 4 (dag 22–28): F12–F14
| Dag | Ämne | Uppgift | Wikisida |
|-----|------|---------|---------|
| 22 | Söndra och härska | Implementera maximal delsekvens (söndra-härska + Kadane) | [[Söndra och härska]] |
| 23 | Giriga algoritmer | Implementera växelalgoritm (girig). Hitta motexempel | [[Girig algoritm]] |
| 24 | DP — Fibonacci | Implementera fib top-down och bottom-up. Räkna anrop | [[Dynamisk programmering]] |
| 25 | DP — Myntväxling | Implementera växel med top-down DP (fungerar för alla valutor) | [[Dynamisk programmering]] |
| 26 | Floyd-Warshall | Spåra algoritmen för hand på 3-nodsgraf | [[Floyd-Warshall]] |
| 27 | Prim | Spåra Prims algoritm. Jämför med Dijkstra | [[Dijkstras algoritm]] |
| 28 | Heltenta | Gör hela tentan 2025-03-10 (tidsbegränsad, max 4h) | — |

---

## Fas 3 — Tentaövning (dag 29–42, t.o.m. 2026-06-01)

Mål: Träna tentaformat, identifiera svagheter, repetera.

| Vecka | Aktivitet |
|-------|----------|
| V5 (dag 29–35) | Gör tenta 2024-03-13 + 2023-06-07. Rätta med lösningar. Notera alla fel. |
| V6 (dag 36–42) | Fokus på dina svagaste uppgiftstyper (se not nedan). Gör tenta 2023-03-15 + 2022-06-10. |

**Prioritetsordning vid begränsad tid:**
1. Kö-implementering (uppgift 3) — återkommer varje gång, följer alltid samma mönster
2. BST-operationer (uppgift 5) — add + find + inOrder + nrOfValuesInRange
3. HashMap-uppgift (uppgift 6) — mostRepeated / wordCount — kort kod, hög poäng
4. BFS (uppgift 7) — labyrint/hiss med State-klass
5. Rekursion/DP (uppgift 4) — svårast, ta sist

---

## Fas 4 — Slutspurt (dag 43–44, 2026-06-02–06-03)

| Dag | Aktivitet |
|-----|----------|
| 43 | Läs igenom alla wikisidor: [[Stack]], [[Kö]], [[Binärt sökträd]], [[Hashtabell]], [[BFS]]. Inga nya ämnen. |
| 44 | Vila. Läs Java snabbreferensen som medföljer tentan. Gå igenom postfix-algoritmen och BFS-mönstret en gång. |

---

## Tentan dag: Taktik för betyg C

**Tidsplanering (4h = 240 min):**
1. Läs ALLA uppgifter: 10 min
2. Uppgift 6 (HashMap) — enkel kod, snabb poäng: 20 min
3. Uppgift 3 (Kö/Stack/Lista): 40 min
4. Uppgift 5 (BST): 40 min
5. Uppgift 7 (BFS): 40 min
6. Uppgift 4 (Rekursion/DP): 40 min
7. Genomgång och komplettering: 50 min

**Checklistor att ha i minnet:**
- Kö: `front`, `rear`, `(rear+1)%maxSize`, `reallocate()` kopierar med modulo
- BST: `compareTo`, tre fall vid borttagning, inorder = sorterat
- BFS: `State`-klass, `memo`-array, `offer` INNAN `poll`, returnera när mål nås
- HashMap: `getOrDefault(key, 0)`, iterera med `entrySet()`

---

## Gamla tentor att använda (rekommenderad ordning)

| Prioritet | Tentadatum | Anm. |
|-----------|-----------|------|
| 1 | 2024-06-04 | Börja här — fas 1 |
| 2 | 2025-06-03 | Fas 2 |
| 3 | 2025-03-10 | Heltentaträning |
| 4 | 2024-03-13 | Fas 3 |
| 5 | 2023-06-07 | Fas 3 |
| 6 | 2023-03-15 | Fas 3 backup |
| 7 | 2022-06-10 | Backup |
| 8 | 2022-03-17 | Backup |
| 9 | 2026-03-11 | Sista veckan — färskast! |

> Lösningarna finns i `sources/Lösningar/`. Rätta alltid direkt efter du löst uppgiften.

---

## Relaterat
- [[Kö]] — uppgift 3-typ
- [[Binärt sökträd]] — uppgift 5-typ
- [[Hashtabell]] — uppgift 6-typ
- [[BFS]] — uppgift 7-typ
- [[Dynamisk programmering]] — uppgift 4-typ

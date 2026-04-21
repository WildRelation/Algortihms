---
type: entity
tags: [sökning, DFS, rekursion, stack, algoritm]
created: 2026-04-21
updated: 2026-04-21
sources: [F6-Backtracking]
---

# DFS — Djupet-först-sökning (Depth-First Search)

DFS utforskar en sökstig så **djupt som möjligt** innan den backar och prövar en annan stig.

## Grundprincip

- Följer en stig till slutet (eller ett maxdjup)
- Backar sedan och prövar nästa alternativ
- Naturligt implementerat via [[Rekursion]] (funktionsanrop = stack)

## Varför djupet-först?

Funktionsanrop hamnar på en **LIFO-stack** → senaste anropet bearbetas först → djupet-först.

## Problem med naiv DFS

Utan kontroll kan DFS loopa oändligt (t.ex. hiss-problemet):
```
1 → 4 → 7 → 6 → 5 → 4 → 7 → 6 → ... (oändligt)
```
Lösning: sätt ett maxdjup, eller använd [[Backtracking]].

## DFS för existensproblem

DFS är effektiv när vi söker *om* en lösning finns — inte nödvändigtvis den kortaste.

## Jämförelse med BFS

| | DFS | BFS |
|--|-----|-----|
| Datastruktur | Stack (rekursion) | [[Kö]] |
| Kortaste väg | Nej | Ja ✓ |
| Minnesbehov | O(djup) | O(bredd) |
| Implementering | Enkel (rekursion) | Kräver explicit kö |

## Relaterat

- [[BFS]] — garanterar kortaste vägen
- [[Backtracking]] — DFS med tidig avbrytning
- [[Rekursion]] — DFS implementeras naturligt rekursivt
- [[Graf]] — DFS används för graftraversering

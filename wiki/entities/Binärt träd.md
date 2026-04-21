---
type: entity
tags: [träd, datastruktur, binärt träd]
created: 2026-04-21
updated: 2026-04-21
sources: [F7-Trad-BST]
---

# Binärt träd

Ett binärt träd är ett träd där varje nod har **maximalt 2 barn** (vänster och höger subträd).

## Terminologi

| Term | Förklaring |
|------|-----------|
| Rot | Toppnoden, utan förälder |
| Nod | Element i trädet |
| Löv | Nod utan barn |
| Förälder | Nod ovanför |
| Barn | Nod nedanför |
| Höjd | Antal nivåer |
| Subträd | Del av trädet med en nod som rot |

**N noder → N-1 bågar** (alltid)

## Rekursiv definition

Ett binärt träd är antingen:
- Tomt, eller
- En rotnod med ett vänster binärt träd och ett höger binärt träd

## Typer av binära träd

| Typ | Definition |
|-----|-----------|
| **Full** | Varje nod har 0 eller 2 barn |
| **Perfekt** | Alla löv på samma nivå (alla nivåer fulla) |
| **Komplett** | Alla nivåer fulla utom sista; sista är vänsterjusterad |
| **Balanserat** | Höjdskillnad max 1 för vänster/höger subträd per nod |

> Perfekt ⊂ Komplett ⊂ Balanserat (strikt ordning)

## Egenskaper för perfekt träd med höjd h

- Antal noder: 2^h - 1
- Antal löv: 2^(h-1)

## Traversering

Se [[Binärt sökträd]] för traverseringsalgoritmer (gäller alla binära träd).

## Relaterat

- [[Binärt sökträd]] — ordnat binärt träd
- [[Heap]] — komplett binärt träd med heap-egenskap

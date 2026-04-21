---
type: entity
tags: [mängd, set, ADT, datastruktur]
created: 2026-04-21
updated: 2026-04-21
sources: [F8-Mangd-Hash]
---

# Mängd (Set)

En mängd är en samling element **utan kopior** — varje element förekommer maximalt en gång.

## Operationer (ADT)

- `contains(e)` — test för medlemskap
- `add(e)` — lägg till (ignoreras om redan finns)
- `remove(e)` — ta bort
- `union(other)` — förening A ∪ B
- `intersection(other)` — snitt A ∩ B
- `difference(other)` — differens A \ B
- `isSubset(other)` — delmängdstest

> Inom datalogin pratar vi även om **ordnade mängder** (element ordnade efter nyckel).

## Mängd i JCF

`Set<E>` är ett interface. Implementeringar:

| Klass | Implementering | Ordnad? | Komplexitet |
|-------|---------------|---------|-------------|
| `HashSet<E>` | [[Hashtabell]] | Nej | O(1) amortera |
| `TreeSet<E>` | Red-Black Tree ([[Binärt sökträd]]) | Ja | O(log n) |
| `LinkedHashSet<E>` | Hash + länk | Insättningsordning | O(1) |
| `BitSet` | Bit-array | — | O(1), 1 bit/element |

**BitSet:** extremt minneseffektivt för heltalsmängder — en bit per möjligt heltal.

## Välj rätt implementering

- Snabb lookup, ingen ordning → `HashSet`
- Sorterad iteration, range-frågor → `TreeSet`
- Bevara insättningsordning → `LinkedHashSet`
- Mängd av heltal i litet intervall → `BitSet`

> [!note] Återkommande teorifråga
> "Beskriv termerna mängd och avbildning. Beskriv kort hur man kan implementera en avbildning." (2023-03)
> Se [[tentaanalys]] för fullständig lista.

## Relaterat

- [[Avbildning]] — mängd av nyckel-värde-par
- [[Hashtabell]] — implementation av HashSet
- [[Binärt sökträd]] — implementation av TreeSet
- [[tentaanalys]] — frekvensanalys av teorifrågor

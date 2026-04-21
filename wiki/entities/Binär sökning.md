---
type: entity
tags: [sökning, algoritm, O(log n), rekursion]
created: 2026-04-21
updated: 2026-04-21
sources: [F5-Rekursion]
---

# Binär sökning

Binär sökning hittar ett element i ett **sorterat** material på O(log n) tid genom att halvera sökrymden vid varje steg.

## Krav

Materialet **måste vara sorterat**.

## Algoritm

```
Om arrayen är tom → return -1
Annars om mitten matchar → return mitt-index
Annars om target < mitten → sök vänstra halvan
Annars → sök högra halvan
```

## Java-implementation (rekursiv)

```java
public static int binarySearch(Object[] items, Comparable target) {
    return binarySearch(items, target, 0, items.length - 1);
}
private static int binarySearch(Object[] items, Comparable target, int first, int last) {
    if (first > last) return -1;
    int middle = (first + last) / 2;
    int compResult = target.compareTo(items[middle]);
    if (compResult == 0) return middle;
    if (compResult < 0) return binarySearch(items, target, first, middle - 1);
    return binarySearch(items, target, middle + 1, last);
}
```

## Komplexitetsanalys

T(1) = 1, T(n) = 1 + T(n/2)

| n | T(n) | log₂(n)+1 |
|---|------|-----------|
| 1 | 1 | 1 |
| 2 | 2 | 2 |
| 4 | 3 | 3 |
| 8 | 4 | 4 |

→ **T(n) = O(log n)** — varje dubbling av n ökar antalet steg med 1.

## Jämförelse med linjär sökning

| | Linjär sökning | Binär sökning |
|--|---------------|--------------|
| Krav | Inget | Sorterat |
| Komplexitet | O(n) | O(log n) |
| n=1 000 000 | ~500 000 jämförelser | ~20 jämförelser |

## Relaterat

- [[Rekursion]] — naturlig rekursiv implementation
- [[Binärt sökträd]] — O(log n) sökning i dynamisk struktur
- [[Sortering]] — förutsättning för binär sökning på array

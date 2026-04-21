---
type: entity
tags: [heap, prioritetskö, sortering, datastruktur, binärt träd]
created: 2026-04-21
updated: 2026-04-21
sources: [F10-Heap-Sortering]
---

# Heap

En heap är ett **komplett binärt träd** där rotens nyckel är minst (min-heap) eller störst (max-heap) och varje icke-tomt subträd också är en heap.

## Egenskaper

- **Komplett:** alla nivåer fulla utom sista (vänsterjusterad)
- **Heap-egenskap:** förälder ≤ barn (min-heap) eller förälder ≥ barn (max-heap)
- Rot = alltid min eller max → O(1) peek på extremvärdet

## Array-implementering

Komplett binärt träd passar perfekt i array (inga pekare behövs):

```
Nod vid index p:
  Vänster barn: 2p + 1
  Höger barn:   2p + 2
  Förälder:     (p - 1) / 2
```

```
Träd: 6, 18, 8, 20, 28, 39, 29, ...
Index:[0] [1] [2] [3] [4] [5] [6]
```

## Insättning — O(log n)

```
1. Lägg till element sist (index nextPos)
2. Medan element < förälder: byt plats (bubla upp)
```

## Borttagning av minimum — O(log n)

Kan **bara** ta bort rotelementet direkt.

```
1. Spara rotelementet (det vi returnerar)
2. Flytta sista elementet (S) till roten
3. Medan S > minsta barnet: byt med minsta barnet (sjunk ner)
```

## Komplexitetsöversikt

| Operation | Komplexitet |
|-----------|------------|
| peek (min/max) | O(1) |
| insert | O(log n) |
| deleteMin/Max | O(log n) |
| build (n inserts) | O(n log n) |
| build (heapify) | O(n) |

## Java: PriorityQueue

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();  // min-heap
pq.offer(element);   // insert O(log n)
pq.poll();           // deleteMin O(log n)
pq.peek();           // min O(1)
```
Kräver `Comparable` eller `Comparator`.

## Heapsort — O(n log n)

**Enkel:** Sätt in alla → ta ut alla (min-heap → stigande ordning).
Problem: kräver O(n) extra minne.

**In-place (max-heap):**
```
m=1; medan m<n: offer(a,m++)   // bygg max-heap i a[0..m-1]
m=n; medan m>1: a[m-1]=poll(a,m); m--  // rot (max) → sist
```

**Analys:**
| Egenskap | Värde |
|---------|-------|
| Tid | O(n log n) alltid |
| Minne | O(1) |
| Stabil | **Nej** |
| vs Quicksort | Långsammare i praktiken men bättre worst-case |
| vs Mergesort | Mergesort utnyttjar cache bättre och är stabil |

## Användningsområden

1. **Prioritetskö** — processschemaläggning, Dijkstras algoritm, Prim
2. **Heapsort** — in-place O(n log n) utan worst-case O(n²)
3. **Top-k** — hitta de k minsta/största elementen ur n element effektivt

## Relaterat

- [[Binärt träd]] — generell trädstruktur
- [[Heapsort]] → se denna sida
- [[Dijkstras algoritm]] — använder min-heap (PriorityQueue)
- [[Sortering]] — jämförelse med andra sorteringsalgoritmer

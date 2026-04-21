---
type: source-summary
tags: [heap, sortering, counting sort, radix sort, prioritetskö]
created: 2026-04-21
lecture: F10
---

# F10 — Heap, Heapsort, Icke-jämförande sortering

## Heap
Komplett binärt träd där:
- Rotens nyckel är **minst** (min-heap) eller störst (max-heap)
- Varje icke-tomt subträd är en heap

## Insättning — O(log n)
1. Sätt in element på första lediga plats (sist i trädet)
2. "Bubla upp": medans element < förälder → byt plats

## Borttagning av rot — O(log n)
Enda borttagning som stöds: rotnoden (alltid minsta/största).
1. Ersätt rot med sista elementet (S)
2. "Sjunk ner": medans S > något barn → byt med minsta barnet

## Array-implementering
Nod vid index p → vänster barn: 2p+1, höger barn: 2p+2, förälder: (p-1)/2

```
6 | 18 | 8 | 20 | 28 | 39 | 29 | 37 | 26 | 76 | ...
[0]  [1]  [2]  [3]  [4]  [5]  [6]  [7]  [8]  [9]
```

## Java: java.util.PriorityQueue<E>
Kräver Comparable eller Comparator. Standard: min-heap.

## Heapsort — O(n log n), O(1) extra minne, ej stabil
**Enkel version:** Sätt in alla i heap → ta ut alla → sorterad.
Problem: kräver n extra minne.

**In-place med max-heap:**
```
m = 1
Medan m < n: offer(a, m++)     // bygg max-heap
Medan m > 1: a[m-1] = poll(a, m); m--  // ta ut, lägg sorterat
```

**Analys:**
- O(n log n) alltid (bäst och värst)
- O(1) extra minne
- Ej stabil
- Långsammare än quicksort i praktiken men bättre worst-case (quicksort: O(n²) värst)
- Föredras i inbyggda system/säkerhetskritisk kod

## Counting Sort — O(n+k), ej jämförande
Räknar antal av varje värde.
```java
int[] count = new int[findMax(v)+1];
for(int a:v) count[a]++;
int i=0;
for(int j=0;j<count.length;j++) while(count[j]-->0) v[i++]=j;
```
- k = max värde, effektivt om k är litet
- Minne: O(k) extra

**Stabil variant** (för objekt): använd prefix-summor i count-arrayen.

## Radix Sort — O(d*(n+k))
Sortera siffra för siffra, från minst signifikant (LSD).
Varje pass: counting sort på en siffra (bas k).
Kräver stabil inre sortering för att fungera korrekt.

## Heapify — O(n) alternativ
Alternativ till att bygga heap med n insättningar (O(n log n)).
Bygg direkt från array på O(n). Kursen nöjer sig med O(n log n)-varianten.

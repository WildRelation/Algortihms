---
type: entity
tags: [länkad lista, datastruktur, iterator, JCF]
created: 2026-04-21
updated: 2026-04-21
sources: [F2-LankadLista-Iterator]
---

# Länkad lista

En länkad lista är en sekventiell datastruktur där varje element (nod) innehåller data och en eller flera pekare till grannarna. Till skillnad från en array behöver elementen inte ligga i minneskontinuitet.

## Varianter

### Enkellänkad lista
Varje nod har `next`. Kräver head-pekare.
- Borttagning kräver referens till **föregående** nod (eller separat föregåendepekare)
- Lägg till tail-pekare för O(1) append

### Dubbellänkad lista
Varje nod har `next` och `prev`. Har `head` och `tail`.

| Fördelar | Nackdelar |
|---------|-----------|
| Insätt/ta bort O(1) om nodref finns | 50% mer plats |
| Traversering åt bägge håll | |
| Ta bort nod utan föregående-pekare | |

### Cirkulär lista
Sista noden pekar på första (och vice versa).
- Traversera från godtycklig nod
- Undvika fall av lista
- OBS: undvik oändliga loopar!

## Komplexitet

| Operation | Array (ArrayList) | Länkad lista |
|-----------|------------------|--------------|
| get(index) | O(1) | O(n) |
| set(index, e) | O(1) | O(n) |
| add(e) sist | O(1) amorterat | O(1) |
| add(index, e) | O(n) | O(1) om nodref, O(n) för att hitta |
| remove(index) | O(n) | O(1) om nodref, O(n) för att hitta |

**Viktigt:** `LinkedList.get(i)` är O(n) → använd alltid iterator för traversering!

## LinkedList i JCF

```java
LinkedList<String> list = new LinkedList<>();
```

Implementerar: `List<E>`, `Queue<E>`, `Deque<E>`

Arvshierarki: `Object → AbstractCollection → AbstractList → AbstractSequentialList → LinkedList`

## Iterator — O(n) traversering

```java
Iterator<Integer> iter = aList.iterator();
while (iter.hasNext()) {
    int v = iter.next();
    if (condition) iter.remove();  // måste anropa next() före remove()
}

// Enhanced for (= iterator internt):
for (int v : aList) { ... }
```

**Varför inte index-loop?**
`aList.get(i)` på LinkedList = O(n) per anrop → O(n²) totalt!

## ListIterator

Ärver från `Iterator<E>`:
- `add(e)` — insättning vid nuvarande position O(1)
- `hasPrevious()` / `previous()` — bakåttraversering
- Hämtas: `aList.listIterator(startIndex)`

## Relaterat

- [[Kö]] — en av LinkedLists implementeringsroller
- [[Stack]] — kan implementeras med länkad lista
- [[Iterator]] — nyckelkoncept för effektiv traversering

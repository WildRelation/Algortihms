---
type: source-summary
tags: [länkad lista, iterator, dubbellänkad, JCF]
created: 2026-04-21
lecture: F2
---

# F2 — Länkad lista och Iterator

## Dubbellänkad lista
Varje nod har `next` och `prev` pekare. Finns `head` och `tail`.

Fördelar:
- Insättning/borttagning O(1) om man har referens till noden (ej bara index)
- Traversering åt bägge håll
- Ta bort nod utan referens till föregående

Nackdelar:
- Tar 50% mer plats (extra prev-pekare)

## Cirkulär lista
Sista noden → första noden (och vice versa vid dubbellänkad).
- Traversera från godtyckligt element
- Risk: oändliga loopar

## LinkedList i JCF
`java.util.LinkedList<E>` — dubbellänkad lista.
Implementerar: `List<E>`, `Queue<E>`, `Deque<E>`.
Arvshierarki: Object → AbstractCollection → AbstractList → AbstractSequentialList → LinkedList

## Iterator
`LinkedList` implementerar `Iterable<E>` → har metod `iterator()`.

**Interface Iterator<E>:**
| Metod | Beteende |
|-------|---------|
| `boolean hasNext()` | true om fler element finns |
| `E next()` | Returnerar nästa element |
| `void remove()` | Tar bort senast returnerat element |

**Viktigt:** Du **måste** anropa `next()` före varje `remove()`.

**Varför iterator och inte index-loop?**
- `iter.next()` → O(1) per steg → O(n) totalt
- `aList.get(index)` på LinkedList → O(n) per anrop → **O(n²) totalt!**

```java
// Rätt:
Iterator<Integer> iter = aList.iterator();
while (iter.hasNext()) { int v = iter.next(); }

// Fel (för LinkedList): 
for(int i=0; i<aList.size(); i++){ aList.get(i); }  // O(n²)!

// Enhanced for (använder iterator internt):
for(int v : aList) { ... }
```

## ListIterator
Ärver från `Iterator<E>`, extra funktionalitet:
- `add(E e)` — sätt in element vid nuvarande position
- `hasPrevious()`, `previous()` — traversera bakåt
- Hämtas med `aList.listIterator(index)`

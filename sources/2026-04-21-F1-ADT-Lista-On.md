---
type: source-summary
tags: [ADT, lista, ArrayList, O-notation, JCF]
created: 2026-04-21
lecture: F1
---

# F1 — Abstrakta datatyper, listor och effektivitet

## Algoritmer och datastrukturer
- Algoritm: begränsat antal instruktioner som från givna indata leder till korrekta utdata
- Datastruktur: organiserar data för effektiv lagring, åtkomst och processning
- Val av datastruktur kan vara mer än halva lösningen!

## ADT — Abstrakt DataTyp
Definierar **operationerna** vi kan utföra på data — inte implementationen.
I Java: interface. Ex på ADT: lista, stack, kö.
Kan implementeras med array eller länkad lista.

## ADT Lista — minimum av operationer
- `size()` — antal element
- `get(index)` — hämta element
- `add(index, element)` — sätt in
- `remove(index)` — ta bort

## JCF — Java Collections Framework (java.util)
- `ArrayList<E>` — lista med array
- `LinkedList<E>` — lista med länkad lista
- Båda implementerar interface `List<E>` → kan behandlas som `List`

## ArrayList<E>
Implementationsskelett:
```java
private E[] data;         // arrayen
private int nrElements;   // antal element
private int maxSize;      // arrayens storlek

// add(e): om full → reallocate (maxSize*=2); data[nrElements++]=e
// add(index, e): skifta element höger, data[index]=e
// get(index): return data[index]
// reallocate(): maxSize*=2; data=Arrays.copyOf(data, maxSize)
```

**Fördelar:** O(1) get/set, cache-vänlig
**Nackdelar:** O(n) add/remove mitt i, omallokering vid överfyllnad

## ArrayList JCF-arvshierarki
`Object → AbstractCollection → AbstractList → ArrayList`
Implementerar: `Serializable, Cloneable, Iterable, Collection, List, RandomAccess`

## O-notation
- T(n) = hur många enkla satser som körs
- O(n) = tillväxthastighet, ignorerar konstanter
- Nödvändigt: 100× snabbare dator löser bara O(n²)-problem 10× större
- 2^n: n=100 → olösligt. 100× snabbare: n=107 (obetydlig förbättring)

## ArrayList — komplexitet
| Operation | Komplexitet |
|-----------|------------|
| get(index) | O(1) |
| set(index, e) | O(1) |
| add(e) sist | O(1) amorterat |
| add(index, e) | O(n) |
| remove(index) | O(n) |

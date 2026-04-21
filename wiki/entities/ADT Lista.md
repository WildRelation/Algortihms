---
type: entity
tags: [ADT, lista, ArrayList, JCF, datastruktur]
created: 2026-04-21
updated: 2026-04-21
sources: [F1-ADT-Lista-On]
---

# ADT Lista

En lista är en sekventiell datastruktur där varje element har ett index. Elementen kan nås, sättas in och tas bort på godtycklig position.

## Minimioperationer (ADT)

| Metod | Beteende |
|-------|---------|
| `size()` | Antal element |
| `get(index)` | Hämta element på position |
| `add(index, e)` | Sätt in på position (skiftar resten höger) |
| `remove(index)` | Ta bort på position |
| `add(e)` | Lägg till sist (vanlig utökning) |

## Lista i JCF

`List<E>` är ett interface. Implementeringar:

| Klass | Intern struktur | get | add mitt | add sist |
|-------|----------------|-----|---------|---------|
| `ArrayList<E>` | Array | O(1) | O(n) | O(1) amortera |
| `LinkedList<E>` | Dubbellänkad lista | O(n) | O(1) om nodref | O(1) |

```java
List<String> list = new ArrayList<>();   // vanligast
List<String> list = new LinkedList<>();  // om mycket insättning/borttagning
```

## ArrayList — array-implementering

```java
private E[] data;          // start-storlek 10
private int nrElements;    // aktuellt antal
private int maxSize;       // array-storlek

boolean add(E e) {
    if (nrElements == maxSize) reallocate();  // dubbling
    data[nrElements++] = e;
    return true;
}

void add(int index, E e) {
    if (nrElements == maxSize) reallocate();
    for (int i = nrElements; i > index; i--) data[i] = data[i-1];
    data[index] = e; nrElements++;
}

private void reallocate() {
    maxSize *= 2;
    data = Arrays.copyOf(data, maxSize);
}
```

**Amorterat O(1) för add(e) sist:** dubbling sker sällan. n insättningar kostar ~2n kopieringar totalt.

## Välj Lista vs LinkedList

- **Mest get/set, lite insättning mitt i** → `ArrayList`
- **Mycket insättning/borttagning mitt i med iterator** → `LinkedList`
- **Behöver Queue/Deque** → `LinkedList` eller `ArrayDeque`

> [!note] Återkommande teorifråga
> - "Vad är en abstrakt datatyp? Förhållande till datastrukturer?" (2024-06)
> - "add(E) på lista med array — O i olika fall och amorterat snitt" (2023-06)
> Se [[tentaanalys]] för fullständig lista.

## Relaterat

- [[Länkad lista]] — alternativ implementation
- [[Stack]] — LIFO-lista
- [[Kö]] — FIFO-lista
- [[O-notation]] — analys av listoperationer
- [[tentaanalys]] — frekvensanalys av teorifrågor

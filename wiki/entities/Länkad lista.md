---
type: entity
tags: [länkad lista, datastruktur, iterator, JCF]
created: 2026-04-21
updated: 2026-04-22
sources: [F2-LankadLista-Iterator]
---

# Länkad lista

En länkad lista är en sekventiell datastruktur där varje element (nod) innehåller data och en eller flera pekare till grannarna. Till skillnad från en array behöver elementen inte ligga i minneskontinuitet.

## Minnesmodell — referens vs objekt

Det vanligaste missförståndet med länkade listor är skillnaden mellan **referens** och **objekt**.

**`head` är inte en nod — det är en referens till en nod.**

```java
private Node<E> head;  // referensvariabel, pekar på ingenting (null) från start
```

`head` är av typen `Node<E>`, men det betyder att den *kan hålla adressen till* ett Node-objekt — inte att objektet finns. Innan något läggs till i listan är `head = null`.

**`Node<E> next` inuti noden skapar heller ingen nod.**

```java
private class Node<E> {
    E data;
    Node<E> next;   // bara en referensplats, = null tills den kopplas
}
```

Att deklarera `Node<E> next` reserverar en referensplats i objektet. Inget nytt objekt skapas förrän `new Node<>(data)` anropas.

**Kedjan byggs explicit:**

```
head ──► [ data | next ] ──► [ data | next ] ──► null
            nod 1                 nod 2
```

- `head` → pekar på nod 1
- `nod1.next` → pekar på nod 2
- `nod2.next` → `null` (ingen mer nod)

`head` navigerar inte "med hjälp av next" — `head` är en egen referens till första noden. Varje nods `.next`-fält tar dig sedan till nästa nod i kedjan.

**Att lägga till en nod:**

```java
Node<E> nod = new Node<>(data);  // skapar ett nytt objekt
nod.next = head;                 // kopplar det till kedjan
head = nod;                      // head pekar nu på den nya noden (prepend)
```

---

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

> [!note] Återkommande teorifråga och programmeringsuppgift
> - Teorifråga: "Vad är en iterator? När/varför viktigt för effektiviteten?" (2025-03)
> - Teorifråga: "Array vs länkad lista — minst 2 för- och nackdelar" (2022-06)
> - Programmeringsuppg: Iterator, evenIterator (2025-06, 2024-06)
> - Programmeringsuppg: remove + size rekursivt (2022-03)
> Se [[tentaanalys]] för fullständig lista.

## Relaterat

- [[Kö]] — en av LinkedLists implementeringsroller
- [[Stack]] — kan implementeras med länkad lista
- [[ADT Lista]] — arraybaserat alternativ
- [[tentaanalys]] — frekvensanalys av teorifrågor

---
type: synthesis
tags: [iterator, länkad lista, iterable, inre klass, komplexitet, tenta]
created: 2026-04-22
updated: 2026-04-22
sources: [F2-LankadLista-Iterator, tenta-2025-06-03, tenta-2025-03-10, tenta-2024-06-04]
---

# Iterator — Djupdykning

Iterator är ett objekt som stegvis ger åtkomst till ett annat objekts element utan att avslöja den interna datastrukturen. Förekommer som **teorifråga (2025-03)** och som **programmeringsuppgift (2025-06, 2024-06)** — ett av de mer praktiska ämnena på tentan.

## Det kritiska komplexitetsargumentet

Det här är kärnan i teorifrågan: "När och varför är det viktigt att använda iterator?"

| Traversering | Komplexitet | Förklaring |
|---|---|---|
| `for(int i=0; i<list.size(); i++) list.get(i)` | **O(n²)** | `get(i)` på LinkedList räknar från head varje gång → O(n) per anrop |
| `Iterator<E> it = list.iterator(); it.next()` | **O(n)** | Iteratorn håller en pekare till nuvarande nod → O(1) per steg |
| `for(E e : list)` | **O(n)** | Enhanced for = syntaktiskt socker för iterator |

Index-loopen fungerar för `ArrayList` (O(1) random access) men är katastrofal för `LinkedList`.

## Java-interfacen

Två separata interface — viktigt att hålla isär:

| Interface | Vad det kräver | Vem implementerar det |
|---|---|---|
| `Iterable<E>` | Metoden `iterator()` | Din listklass |
| `Iterator<E>` | `hasNext()`, `next()`, `remove()` | Den inre iteratorklassen |

`Iterable<E>` på klassen aktiverar `for-each`-syntaxen. `Iterator<E>` är det objekt som `iterator()` returnerar.

```java
public interface Iterator<E> {
    boolean hasNext();  // finns fler element?
    E next();          // returnera nästa, flytta pekaren
    void remove();     // ta bort senast returnerat element (anropa next() först!)
}
```

**Regel:** `next()` måste anropas före `remove()`.

## Implementera en iterator från grunden

Typisk tentauppgift: "Skriv klart listan så att iteratorn fungerar."

```java
public class SingleLinkedList<E> implements Iterable<E> {

    private class Node<E> {
        E data;
        Node<E> next;
        Node(E d) { data = d; }
    }

    private Node<E> head;

    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<E> {
        private Node<E> current = head;  // börjar vid head

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E data = current.data;
            current = current.next;   // flytta pekaren
            return data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();  // krävs sällan på tenta
        }
    }
}
```

**Tre nyckelpunkter:**
1. Klassen implementerar `Iterable<E>` — ger `for-each`-stöd
2. `iterator()` skapar ett nytt `Iter`-objekt varje gång (flera oberoende iteratorer möjliga)
3. Den inre klassen ser `head` direkt utan getter — täcker det mesta av tentavarianter

## Tentavarianter

### `evenIterator` (2025-06)

Itererar element med jämna index (0, 2, 4, …):

```java
private class EvenIter implements Iterator<E> {
    private Node<E> current = head;

    @Override
    public boolean hasNext() { return current != null; }

    @Override
    public E next() {
        E data = current.data;
        current = current.next;
        if (current != null) current = current.next; // hoppa ett extra steg
        return data;
    }
}
```

### `iterator(int index)` (2024-06)

Börja iterera från givet startindex:

```java
public Iterator<E> iterator(int startIndex) {
    return new IndexedIter(startIndex);
}

private class IndexedIter implements Iterator<E> {
    private Node<E> current = head;

    IndexedIter(int index) {
        for (int i = 0; i < index && current != null; i++) {
            current = current.next; // flytta till startposition
        }
    }

    @Override
    public boolean hasNext() { return current != null; }

    @Override
    public E next() {
        E data = current.data;
        current = current.next;
        return data;
    }
}
```

## ListIterator

`ListIterator<E>` ärver från `Iterator<E>` och lägger till bakåtstöd:

| Metod | Funktion |
|---|---|
| `hasPrevious()` | finns element bakåt? |
| `previous()` | returnera föregående, flytta bakåt |
| `add(E e)` | sätt in vid nuvarande position O(1) |

Hämtas med `list.listIterator(startIndex)`. Kräver dubbellänkad lista för effektiv bakåttraversering.

## Snabbfakta för tentan

- Teorifråga (2025-03): Förklara vad en iterator är + komplexitetsargumentet
- Programmeringsuppg (2025-06): Implementera iterator + evenIterator i SingleLinkedList
- Programmeringsuppg (2024-06): Implementera iterator + iterator(index) i SingleLinkedList
- Mönstret är stabilt: **implementera Iterable på klassen, privat inre klass för Iterator**

## Relaterat

- [[Länkad lista]] — iterator är kritisk för O(n) traversering
- [[ADT Lista]] — kontexten för varför vi behöver iteratorer
- [[O-notation]] — O(n) vs O(n²) är hela poängen
- [[tentaanalys]] — frekvensanalys av tentauppgifter

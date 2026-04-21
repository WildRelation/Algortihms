---
type: entity
tags: [träd, BST, sökning, datastruktur]
created: 2026-04-21
updated: 2026-04-21
sources: [F7-Trad-BST]
---

# Binärt sökträd (BST)

Ett binärt sökträd är ett [[Binärt träd]] som är ordnat efter nodernas nycklar. Det möjliggör O(log n) sökning, insättning och borttagning om trädet är balanserat.

## Definition

- Tomt, eller:
- Rotnoden har två subträd (också BST)
- **Alla nycklar i vänster subträd < rotnodens nyckel**
- **Alla nycklar i höger subträd > rotnodens nyckel**
- Varje nyckel är unik (inga dubbletter)

## Komplexitet

| Operation | Balanserat | Obalanserat (värsta fall) |
|-----------|-----------|--------------------------|
| Sökning | O(log n) | O(n) |
| Insättning | O(log n) | O(n) |
| Borttagning | O(log n) | O(n) |

> **Varning:** Om element sätts in i sorterad ordning degenererar BST till en länkad lista → O(n) på allt. Använd då [[Självbalanserande BST]].

## Jämförelse med andra strukturer

| Struktur | Sökning | Insättning |
|----------|---------|-----------|
| Sorterad array | O(log n) | O(n) |
| Länkad lista | O(n) | O(1) |
| Balanserat BST | O(log n) | O(log n) |

**BST vinner** när man behöver både snabb sökning OCH snabb insättning/borttagning.

## Traversering

- **Inorder** (vänster → nod → höger): ger sorterad ordning ✓
- **Preorder** (nod → vänster → höger): rotbesök först
- **Postorder** (vänster → höger → nod): rotbesök sist

## Ta bort nod — 3 fall

**Fall 1: Löv** — sätt förälderns pekare till null.

**Fall 2: En barn** — ersätt noden med dess barn.

**Fall 3: Två barn** — ersätt noden med **minsta noden i höger subträd** (in-order successor):
- Den noden kan inte ha vänsterbarn (är minst) → är fall 1 eller 2 → lätt att ta bort

## Java-implementation

```java
public class BinarySearchTree<E extends Comparable<E>> {
    private static class Node<E> {
        E data; Node<E> left, right;
        Node(E d){ data=d; left=right=null; }
    }
    private Node<E> root;

    // add: följ trädet, häng på lövet
    // find: följ trädet med compareTo
    // inOrder: rekursivt vänster, nod, höger
}
```

## BST i JCF

- `TreeMap<K,V>` — avbildning (map) med BST
- `TreeSet<E>` — mängd med BST
- Båda implementerar **Red-Black Tree** (självbalanserande) → garanterar O(log n)

## Användning

- Implementera ordnad mängd (set) eller avbildning (map)
- Söka med nyckel (t.ex. telefonnummer via namn)

## Relaterat

- [[Binärt träd]] — generell trädstruktur
- [[Självbalanserande BST]] — Red-Black Tree, AVL-träd
- [[Heap]] — annat binärt träd (prioritetskö)
- [[Rekursion]] — traversering och operationer är rekursiva

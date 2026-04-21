---
type: entity
tags: [datastruktur, FIFO, queue, ADT]
created: 2026-04-21
updated: 2026-04-21
sources: [F4-Ko]
---

# Kö (Queue)

En kö är en linjär datastruktur med **FIFO**-princip (First In First Out) — element läggs till sist och tas bort först, precis som en kö i verkligheten.

## Gränssnitt (ADT)

| Metod | Beskrivning |
|-------|-------------|
| `enqueue(e)` / `offer(e)` | Lägg till element sist |
| `dequeue()` / `poll()` | Ta bort och returnera första elementet (null om tom) |
| `front()` / `peek()` | Titta på första utan att ta bort (null om tom) |
| `empty()` / `isEmpty()` | True om kön är tom |
| `size()` | Antal element |

## Queue i JCF

Interface `Queue<E>` har **två varianter per operation:**
- En som **kastar exception** om den misslyckas: `add()`, `remove()`, `element()`
- En som **returnerar null/false**: `offer()`, `poll()`, `peek()`

```java
Queue<String> q = new ArrayDeque<>();  // oftast snabbast
Queue<String> q = new LinkedList<>();
```

> **Regel:** Kan inte korrekt implementera Javas Queue-interface i en ren kö — iteratorn bryter mot kö-principen.

## Implementering 1: Cirkulär array

**Idé:** Undviker O(n)-skiftning genom att hålla `front`- och `rear`-index.

```java
offer(e): rear = (rear+1) % maxSize; data[rear] = e; size++;
poll():   E e = data[front]; front = (front+1) % maxSize; size--; return e;
peek():   return size==0 ? null : data[front];
```

- **Startvärden:** `front=0, rear=maxSize-1, size=0`
- **Full array:** `reallocate()` — dubbling, kopiera från front med modulo
- **Komplexitet:** O(1) amorterat på alla operationer

### Reallocate
```java
int newMaxSize = 2 * maxSize;
E[] newData = (E[]) new Object[newMaxSize];
int j = front;
for (int i = 0; i < size; i++) { newData[i] = data[j]; j = (j+1) % maxSize; }
front = 0; rear = size - 1; maxSize = newMaxSize; data = newData;
```

## Implementering 2: Länkad lista

- Fördel: alltid rätt storlek i minnet
- Nackdel: extra minnesutrymme för pekare
- Kräver **tail-pekare** för O(1) enqueue (annars O(n))
- Enkellänkad med tail ≈ lika stor som halvfull array-kö

## Komplexitetsjämförelse

| Operation | Cirkulär array | Länkad lista |
|-----------|---------------|--------------|
| offer | O(1) amortera | O(1) |
| poll | O(1) | O(1) |
| peek | O(1) | O(1) |

## Användning

- BFS (bredden-först-sökning) — kön hanterar nästnivåns noder
- Printköer, processköer, buffrar

## Relaterat
- [[Stack]] — LIFO, används för DFS
- [[BFS]] — algoritm som använder kö
- [[Länkad lista]] — en av implementeringarna

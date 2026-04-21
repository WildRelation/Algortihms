---
type: entity
tags: [stack, LIFO, ADT, datastruktur, postfix]
created: 2026-04-21
updated: 2026-04-21
sources: [F3-Stack]
---

# Stack

En stack är en linjär datastruktur med **LIFO**-princip (Last In First Out) — det senast inlagda elementet tas bort först, som en hög tallrikar.

## Gränssnitt (ADT)

| Metod | Beteende |
|-------|---------|
| `push(e)` | Lägg element överst |
| `pop()` | Ta bort och returnera toppelementet |
| `peek()` | Titta på toppelementet utan att ta bort |
| `empty()` | True om stacken är tom |

## Stack i JCF

**Undvik `java.util.Stack<E>`** — ärver felaktiga metoder från `Vector`, synkroniserad.

**Kursens rekommendation:**
```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(element);   // lägger på toppen
stack.pop();           // tar från toppen
stack.peek();          // tittar på toppen
stack.isEmpty();
```

`Deque`-interfacet implementeras av `ArrayDeque` och `LinkedList`. Obs: ej null-element.

## Implementering 1: Array

**Nyckelidé:** Toppen = **sista** elementet (index `top`). Börja med `top = -1`.

```java
push: if(full) reallocate(); data[++top] = obj;
pop:  return data[top--];
peek: return data[top];
empty: return top == -1;
```

Varför sist och inte index 0? Index 0 som topp kräver skiftning O(n) vid push/pop.

**Komplexitet:** Alla O(1), amorterat O(1) med dubbling.

## Implementering 2: Länkad lista

**Nyckelidé:** Toppen = **head-noden**. push/pop ändrar bara head.

```java
push: top = new Node<>(obj, top);
pop:  E r = top.data; top = top.next; return r;
```

**Komplexitet:** Alla O(1). Exakt rätt storlek alltid.

## Minnesjämförelse

| | Array | Länkad lista |
|--|-------|------------|
| Minnesbehov | Max 4× nödvändigt | Alltid 2× nödvändigt |
| Förutsägbarhet | Nej (dubbling) | Ja |
| Cache-lokalitet | Bättre | Sämre |

## Tillämpning: Postfix/Omvänd polsk notation

```
12 6 + 3 /  →  push 12, push 6, + → push 18, push 3, / → push 6  →  svar: 6
```

**Algoritm:**
```
för varje token:
    om siffra: push(token)
    om operator: höger=pop(); vänster=pop(); push(vänster OP höger)
return pop()
```

## Varför är stacken viktig?

- **Funktionsanrop** — processorn håller returadresser på en stack (JVM call stack)
- **DFS** — [[DFS]] implementeras naturligt via rekursionsstacken
- **Postfix-evaluering** — se ovan
- **Ångra-funktioner** (undo) — åtgärder läggs på stack, ångra = pop
- **Parentesmatchning** — kontrollera att `(` och `)` matchar

## Relaterat

- [[Kö]] — FIFO, omvänd princip
- [[Länkad lista]] — en av implementeringarna
- [[DFS]] — använder stacken naturligt via rekursion
- [[Rekursion]] — JVM:s call stack är en stack

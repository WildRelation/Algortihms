---
type: entity
tags: [rekursion, algoritm, problemlösning]
created: 2026-04-21
updated: 2026-04-21
sources: [F5-Rekursion, F6-Backtracking]
---

# Rekursion

Rekursion är en problemlösningsstrategi där en metod anropar sig själv med ett enklare delproblem tills ett **basfall** (termineringsvillkor) nås.

## Krav för korrekt rekursion

1. **Basfall** — ett eller flera fall som löses direkt (utan rekursivt anrop)
2. **Rekursivt steg** — varje anrop måste röra sig mot basfallet
3. Om inget basfall nås → StackOverflowError

## Rekursionsträd

Visar alla rekursiva anrop grafiskt. Viktigt för att analysera komplexitet.

**Fibonacci-exempel:**
```
f(5) = f(4) + f(3)
f(4) = f(3) + f(2)    f(3) = f(2) + f(1)
...
```
f(3) beräknas **två gånger** — dubbelarbete leder till O(2^n).

## Minneshantering

Varje funktionsanrop skapar en **stack frame** med:
- Lokala variabler
- Parametrar
- Återhoppsadress

→ Rekursion använder mer minne än iteration (en frame per anropsnivå).

## Svansrekursion

Enda rekursiva anrop är det **sista** i funktionen. Kompilatorer kan omvandla detta till iteration (inget extra stackutrymme).

```java
// Ej svansrekursiv (multiplikation kvar efter anrop):
int fak(int n){ if(n==0) return 1; return n * fak(n-1); }

// Svansrekursiv:
int fak(int n, int result, int factor){
    if(factor==n) return result*factor;
    return fak(n, result*factor, factor+1);
}
```

## Rekursion vs. iteration

| | Rekursion | Iteration |
|--|-----------|-----------|
| Kodläsbarhet | Ofta renare | Ofta mer verbos |
| Minnesutrymme | Mer (stack frames) | Mindre |
| Effektivitet | Ibland sämre | Ofta bättre |
| Alla problem kan lösas | Ja | Ja (kan alltid konverteras) |

> **Strategi:** Skriv ren rekursiv lösning, effektivisera sedan med [[Dynamisk programmering]] eller omskriv till iteration.

## Viktiga rekursiva algoritmer i kursen

| Algoritm | Komplexitet | Anteckning |
|----------|------------|------------|
| Fibonacci rekursivt | O(2^n) | Ineffektivt |
| Fibonacci iterativt | O(n) | |
| Fibonacci DP | O(n) | Sparar delproblem |
| Binär sökning | O(log n) | Svansrekursiv |
| Linjär sökning | O(n) | |
| GCD (Euklides) | O(log n) | |
| Hanoi | O(2^n) | Optimal lösning |
| Mergesort | O(n log n) | Söndra-härska |

## Relaterat
- [[Backtracking]] — rekursion + tidig avbrytning
- [[DFS]] — djupet-först via rekursionsstacken
- [[Binär sökning]] — klassisk rekursiv algoritm
- [[Dynamisk programmering]] — effektiviserar rekursion
- [[Tornet i Hanoi]]

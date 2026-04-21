---
type: entity
tags:
  - O-notation
  - komplexitet
  - algoritm-analys
  - Big-O
created: 2026-04-21
updated: 2026-04-21
sources:
  - F1-ADTListaOn
  - F9-Sortering
---

# O-notation (Big-O)

O-notation beskriver hur en algoritms resursförbrukning (tid eller minne) **växer** med inputstorleken n. Den fokuserar på beteendet för stora n och ignorerar konstanter.

## Formell definition

T(n) = O(f(n)) **omm** det existerar en positiv konstant c och ett heltal n₀ sådant att:
**cf(n) ≥ T(n) för alla n > n₀**

cf(n) är en övre gräns för T(n) för stora n.

**Exempel:** T(n) = 2n² + 5n + 25
- Vi väljer f(n) = n²
- Löser: 2n² + 5n + 25 ≤ c·n² vid n=5 → c = 4
- Alltså: T(n) = O(n²), visas med n₀=5, c=4

## Vanliga klasser (stigande ordning)

| O-notation | Namn | Exempel |
|-----------|------|---------|
| O(1) | Konstant | Array-index, hashtabell |
| O(log n) | Logaritmisk | Binär sökning, BST, heap |
| O(n) | Linjär | Linjär sökning, iterator |
| O(n log n) | Log-linjär | Mergesort, heapsort |
| O(n²) | Kvadratisk | Selection/Insertion/Bubble sort |
| O(n³) | Kubisk | Tre nästlade loopar |
| O(2^n) | Exponentiell | Rekursiv Fibonacci, Hanoi |
| O(n!) | Faktoriell | Permutationer |

## Praktiska konsekvenser vid 10⁻⁹ s/sats, n = 1 000 000

| O-notation | Tid |
|-----------|-----|
| O(log n) | 0.020 μs |
| O(n) | 1 ms |
| O(n log n) | ~20 ms |
| O(n²) | **16.7 minuter** |
| O(2^n) | astronomisk |

## Identifiera komplexitet i kod

**O(1):** enstaka operation, array-åtkomst
**O(log n):** halvering vid varje steg (i *= 2 eller binär sökning)
```java
for(i=1; i < n; i *= 2) { ... }  // O(log n)
```
**O(n):** en loop genom n element
**O(n²):** två nästlade loopar
```java
for(i=0; i<n; i++)
  for(j=0; j<n; j++) { ... }  // O(n²)
```
**O(n²) med inner j=i+1:** T(n) = n(n-1)/2 = O(n²) (halva av n²)

## Amorterad analys

`ArrayList.add(e)`: normalt O(1), men O(n) vid dubbling.
Amorterat O(1) eftersom dubbling sker sällan: n insättningar kostar totalt O(n).

**Lista med array:** start-storlek m, dubbling:
- ≤m adds: 0 kopieringar
- ≤2m adds: m kopieringar
- ≤4m adds: 3m kopieringar
Totalt efter n adds: ~2n kopieringar → O(1) amorterat

> [!note] Återkommande teorifråga
> O-notation är den **mest frekventa teorifrågan** — dyker upp i 3 av 8 tentor:
> - "Förklara O(n³), ge 2 komplexitetsfunktioner som skiljer sig" (2025-03)
> - "Varför analysera algoritmers effektivitet teoretiskt?" (2022-06)
> - "add(E) på lista med array — O i olika fall och amorterat" (2023-06)
> Se [[tentaanalys]] för fullständig lista.

## Relaterat

- [[Sorteringsalgoritmer]] — tillämpad analys av alla sorteringsalgoritmer
- [[Rekursion]] — rekurrensrelationer T(n) = 1 + T(n/2) → O(log n)
- [[Binär sökning]] — klassiskt O(log n)-bevis
- [[tentaanalys]] — frekvensanalys av teorifrågor

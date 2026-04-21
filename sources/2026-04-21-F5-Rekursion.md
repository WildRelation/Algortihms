---
type: source-summary
tags: [rekursion, algoritm, binär sökning, fibonacci]
created: 2026-04-21
lecture: F5
---

# F5 — Rekursion

**Ämnen:** Algoritm, Rekursion, Rekursionsträd, Funktionsanrop på stacken, Binär sökning

## Kärninnehåll

**Algoritm** — begränsat antal instruktioner för att lösa en uppgift
- Precision: varje steg exakt bestämt
- Determinism: resultatet av varje steg entydigt
- Ändlig: når målet efter ändligt antal steg

**Rekursion** — metod anropar sig själv
- Kräver alltid ett termineringsvillkor (basfall)
- Mäktig men kan använda mer minne än iteration

**Fibonacci — rekursivt vs. iterativt**
```java
// Rekursivt: O(2^n) — räknar om samma värden
static int fib(int n){ if(n==1||n==2) return 1; return fib(n-1)+fib(n-2); }

// Iterativt: O(n)
// Ännu bättre: stängd formel O(1) men kräver flyttal
```

**Minneshantering i JVM**
- Stack: lokala variabler, parametrar, återhoppsadress (primitiver + referenser)
- Heap: alla objekt
- Metodområde: klassvariabler, delas av alla trådar

**Svansrekursion** — enda rekursiva anrop är sista i funktionen
- Kompilatorer kan optimera detta till iteration

**Linjär sökning:** O(n)

**Binär sökning:** O(log n) — kräver sorterat material
- T(n) = 1 + T(n/2) → T(n) = O(log n)
- En dubbling av materialet ger en ökning med 1 i antal steg

**GCD (Euklides algoritm):**
```java
static int gcd(int a, int b){ if(b==0) return a; return gcd(b, a%b); }
```

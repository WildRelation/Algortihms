---
type: source-summary
tags: [dynamisk programmering, memoization, Floyd-Warshall, kappsäck]
created: 2026-04-21
lecture: F14
---

# F14 — Dynamisk programmering

## Grundidé
Används när uppdelning ger **överlappande delproblem**. Lös varje delproblem **en gång** och spara resultatet.

- **Top-down (memoization):** Rekursivt + tabellera resultat vid varje anrop
- **Bottom-up:** Iterativt, lös minsta delproblemen först och bygg upp

## Fibonacci
```java
// Rekursivt: O(2^n), fib(40) = 204 668 309 anrop
static long fib(int n){ if(n<=2) return 1; return fib(n-1)+fib(n-2); }

// Top-down DP: O(n), fib(40) = 77 anrop
static long fibDyn(int n){
    long[] tab = new long[n+1]; tab[1]=tab[2]=1;
    return fibDyn(n, tab);
}
static long fibDyn(int n, long[] tab){
    if(tab[n]!=0) return tab[n];
    tab[n] = fibDyn(n-1,tab) + fibDyn(n-2,tab);
    return tab[n];
}

// Bottom-up: O(n), O(1) minne
static long fibIter(int nFinal){
    long fn=1, fMinus1=1, fMinus2=1;
    for(int n=3; n<=nFinal; n++){ fn=fMinus1+fMinus2; fMinus2=fMinus1; fMinus1=fn; }
    return fn;
}
```

## Myntväxling — dynamiskt top-down
```
Förbered: tab[mynt[i]] = 1 för alla i (övriga = 0)
växel(belopp):
  om tab[belopp] ≠ 0: return tab[belopp]
  bäst = ∞
  för i = 0 till n-1:
    om mynt[i] < belopp: bäst = min(bäst, 1+växel(belopp-mynt[i]))
  tab[belopp] = bäst; return bäst
```
Fungerar för **godtyckliga valutor** (till skillnad från girig).

## Floyd-Warshall — kortaste vägen alla par, O(|V|³)
Använder DP bottom-up. Hittar kortaste vägen mellan VARJE par av noder.
- Kan hantera **negativa vikter** (ej Dijkstra)
- Kräver O(|V|²) minne

```
// Initiering
för alla bågar: a(i,j) = w(i,j)
a(i,i) = 0 för alla i
// DP
för k = 1 till N:      // tillåt nod k som mellanstation
  för i = 1 till N:
    för j = 1 till N:
      a(i,j) = min(a(i,j), a(i,k) + a(k,j))
```
Princip: kortasteVägen(i,j,k+1) = min(kortasteVägen(i,j,k), kortasteVägen(i,k+1,k) + kortasteVägen(k+1,j,k))

## Kappsäck — dynamiskt
m(w) = maximalt värde i kappsäck av storlek w
```
m(0) = 0
m(w) = max(v₁+m(w-w₁), v₂+m(w-w₂), ..., vₙ+m(w-wₙ))  [för wᵢ ≤ w]
```
Bottom-up: beräkna m(0), m(1), ..., m(W) iterativt.

## Handelsresande — Held-Karp, O(n²·2^n)
Bästa kända exakta algoritm för TSP. Använder DP med BitSet för att representera mängder av besökta städer.
- b(S,j) = kortaste vägen från j, genom alla städer ej i S, till stad 1
- Tabuleras i HashMap<PartPath, Integer> för O(1) lookup
- Implementering: naiv O(n!) → med tabulering O(n²·2^n)

## Dynamisk + BFS
Spara besökta tillstånd (memo-array) för att undvika att köa samma tillstånd.
Gör BFS mer effektivt utan att förlora kortaste-vägen-garantin.

## Hashtabell för DP
När delproblemen ej kan indexeras med heltal → använd HashMap som tabell.
Ex: handelsresande där nyckeln är (visited, currentCity).

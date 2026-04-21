---
type: entity
tags: [dynamisk programmering, DP, memoization, optimering]
created: 2026-04-21
updated: 2026-04-21
sources: [F14-Dynamisk-Programmering]
---

# Dynamisk programmering (DP)

Dynamisk programmering löser problem med **överlappande delproblem** genom att beräkna varje delproblem **exakt en gång** och spara resultatet.

## Krav för DP

1. **Optimal delstruktur** — optimal lösning byggs av optimala dellösningar
2. **Överlappande delproblem** — samma delproblem löses om och om igen rekursivt

## Två strategier

### Top-down (Memoization)
Skriv rekursiv lösning → lägg till tabell som cachar resultat.
```java
if (tab[n] != 0) return tab[n];  // cache-träff
tab[n] = beräkna...;             // beräkna och spara
return tab[n];
```

### Bottom-up
Börja med minsta delproblemen, bygg upp iterativt.
- Ofta mer effektivt (ingen rekursionsoverhead)
- Kräver att man planerar beräkningsordningen

## Exempel: Fibonacci

| Variant | Anrop fib(40) | Komplexitet |
|---------|--------------|------------|
| Rekursivt | 204 668 309 | O(2^n) |
| Top-down DP | 77 | O(n) |
| Bottom-up | 39 iterationer | O(n), O(1) minne |

## Exempel: Myntväxling

Söndra-härska löser fel delproblem om och om → top-down DP:
```
tab[mynt[i]] = 1 för alla i
växel(belopp):
    om tab[belopp] ≠ 0: return tab[belopp]
    bäst = min(1 + växel(belopp-mynt[i])) för alla passande mynt
    tab[belopp] = bäst; return bäst
```
Fungerar för **godtyckliga** valutor — [[Girig algoritm]] gör det inte.

## Exempel: Floyd-Warshall

Kortaste vägen alla par med DP bottom-up — se [[Floyd-Warshall]].

## Exempel: Kappsäck
```
m(0) = 0
m(w) = max over i: vᵢ + m(w - wᵢ)    [för wᵢ ≤ w]
```
Beräkna m(1), m(2), ..., m(W) iterativt → O(nW).

## Tabellering med hashtabell

Om delproblemen ej kan indexeras med heltal:
→ Använd `HashMap` som tabell (O(1) lookup trots komplexa nycklar)
Ex: handelsresande — nyckeln är (besökta städer + nuvarande stad) → `HashMap<PartPath, Integer>`

## DP vs Girig vs Söndra-härska

| Paradigm | Delproblem | Omvärdering | Optimal? |
|----------|-----------|-------------|---------|
| [[Girig algoritm]] | Ett åt gången | Aldrig | Ibland |
| [[Söndra och härska]] | Oberoende | — | Ja om substrukturen stämmer |
| Dynamisk programmering | Överlappande | Nej (tabelleras) | Ja |

## Relaterat

- [[Rekursion]] — top-down DP bygger på rekursion
- [[Hashtabell]] — tabulering av komplexa nycklar
- [[Floyd-Warshall]] — DP för kortaste vägen alla par
- [[Dijkstras algoritm]] — kan ses som DP
- [[Girig algoritm]] — enklare men ej alltid optimal

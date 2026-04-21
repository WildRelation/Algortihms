---
type: entity
tags: [graf, kortaste vägen, Floyd-Warshall, dynamisk programmering]
created: 2026-04-21
updated: 2026-04-21
sources: [F14-Dynamisk-Programmering]
---

# Floyd-Warshall

Floyd-Warshall hittar kortaste vägen mellan **varje par** av noder i en viktad graf med O(|V|³) tid.

## Egenskaper

| Egenskap | Värde |
|---------|-------|
| Komplexitet | O(V³) |
| Minne | O(V²) |
| Negativa vikter | **Ja** |
| Negativa cykler | Detekterar (a(i,i) < 0) |
| Rekonstruerar väg | Nej (bara avstånd) |

## Jämförelse med Dijkstra

| | [[Dijkstras algoritm]] | Floyd-Warshall |
|--|----------------------|----------------|
| Källa | En nod | Alla par |
| Negativa vikter | **Nej** | **Ja** |
| Komplexitet | O((V+E)log V) per källa | O(V³) totalt |
| Metod | Girig/Heap | DP bottom-up |

Kör Dijkstra V gånger → O(V²·log V + V·E). Floyd-Warshall O(V³) är bättre om grafen är tät.

## Algoritm

```
// Initiering
för alla bågar (i,j): a[i][j] = w(i,j)
för alla i: a[i][i] = 0
// Resterande = ∞

// DP: tillåt successivt nod k som mellanstation
för k = 1 till N:
    för i = 1 till N:
        för j = 1 till N:
            a[i][j] = min(a[i][j], a[i][k] + a[k][j])
```

## Principen (rekurrens)

`kortasteVägen(i,j,k)` = kortaste vägen från i till j med bara noder 1..k som mellannoder.

```
kortasteVägen(i,j,0)   = w(i,j)
kortasteVägen(i,j,k+1) = min(kortasteVägen(i,j,k),
                             kortasteVägen(i,k+1,k) + kortasteVägen(k+1,j,k))
```
Bottom-up: börja med k=0, öka k ett steg i taget.

## Relaterat

- [[Graf]] — datastruktur
- [[Dynamisk programmering]] — metoden
- [[Dijkstras algoritm]] — för en källnod, positiva vikter

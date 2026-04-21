---
type: entity
tags: [söndra och härska, divide and conquer, rekursion, paradigm]
created: 2026-04-21
updated: 2026-04-21
sources: [F13-Sondra-Harska, F9-Sortering]
---

# Söndra och härska (Divide and Conquer)

Söndra och härska löser ett problem genom att dela det i mindre delproblem av **samma typ**, lösa dem rekursivt och kombinera svaren.

## Tre steg

1. **Divide** — bryt ned problemet i 2+ delar
2. **Conquer** — lös varje del rekursivt (basfall vid litet problem)
3. **Combine** — slå ihop dellösningarna

## Typisk komplexitetsanalys

T(1) = 1, T(n) = 2T(n/2) + n → **O(n log n)**

Generellt Master Theorem: T(n) = aT(n/b) + f(n)

## Kursproblem

### Maximal delsekvens
Hitta delsekvens med störst summa. Ex: {24, 35, -87, **21, 80, -12, 32**, -90, 45, 10} → 121

```
maxSum(a, left, right):
  om left=right: return max(0, a[left])
  center = (left+right)/2
  maxLeft = max prefix-summa leftwards från center
  maxRight = max prefix-summa rightwards från center+1
  return max(maxLeft+maxRight, maxSum(left,center), maxSum(center+1,right))
```
T(n) = 2T(n/2) + n → O(n log n). OBS: Kadanes algoritm löser detta O(n)!

### Skyline-problemet
Givet n hus (x₁, y, x₂), beräkna silhuetten.
- Naivt: O(n²)
- Söndra och härska: O(n log n) — combine = merge av skylines

### Closest Pair (närmaste par)
Givet n punkter, hitta de två närmaste.
- Naivt: O(n²)
- Söndra och härska: O(n log n)
  - Combine-trick: kontrollera bara punkter inom ±d från mitten — **max 6 per punkt**!

### Växelproblemet
Rekursiv lösning fungerar men är ineffektivt (överlappande delproblem). Effektiviseras med [[Dynamisk programmering]].

### Mergesort
Klassisk söndra-och-härska-sortering. O(n log n) alltid. Se [[Sorteringsalgoritmer]].

## Söndra och härska vs DP

| | Söndra och härska | Dynamisk programmering |
|--|------------------|-----------------------|
| Delproblem | **Oberoende** | **Överlappande** |
| Tabellering | Nej | Ja |
| Exempel | Mergesort, Closest pair | Fibonacci, Floyd-Warshall |

## Relaterat

- [[Rekursion]] — söndra-härska är rekursivt
- [[Dynamisk programmering]] — för överlappande delproblem
- [[Sorteringsalgoritmer]] — Mergesort är söndra och härska

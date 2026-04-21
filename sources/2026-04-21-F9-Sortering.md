---
type: source-summary
tags: [sortering, algoritm, komplexitet, O-notation]
created: 2026-04-21
lecture: F9
---

# F9 — Sortering

## Egenskaper hos sorteringsalgoritmer
- Antal jämförelser (värst/medel/bäst)
- Antal platsbyten (värst/medel/bäst)
- Minnesbehov
- **Stabilitet:** behåller ordningen för lika element?

## Sortering i Java API
- `Arrays.sort`: primitiver → quicksort, objekt → timsort (mergesort-variant), O(n log n)
- `Collections.sort`: kopierar till array, sorterar, kopierar tillbaka
- Kräver `Comparable` (compareTo) eller `Comparator`

## Urvalssortering (Selection Sort) — O(n²)
```
För index = 0 till n-2:
  hitta minsta i index+1..n-1
  byt plats på a[index] och a[minIndex]
```
- Jämförelser: O(n²) alltid (oberoende av input)
- Platsbyten: O(n) alltid
- Minne: O(1)
- Stabil: **Nej** (med normal implementering)
- Användning: bra om platsbyten är dyra och data är litet

## Instickssortering (Insertion Sort) — O(n²) värst, O(n) bäst
```
För index = 1 till n-1:
  data = a[index]; dataIndex = index
  Medan dataIndex>0 och data < a[dataIndex-1]:
    a[dataIndex] = a[dataIndex-1]; dataIndex--
  a[dataIndex] = data
```
- Jämförelser: O(n²) värst, O(n) bäst (sorterad array)
- Obs: tilldelning, inte swap → snabb
- Stabil: **Ja**
- Bäst för **nästan sorterade arrayer** och **små arrayer**

## Jämförelse O(n²)-algoritmer
| Algoritm | Jämf. Bäst | Jämf. Värst | Byten Bäst | Byten Värst |
|----------|------------|------------|-----------|------------|
| Selection sort | O(n²) | O(n²) | O(n) | O(n) |
| Bubble sort | O(n) | O(n²) | O(1) | O(n²) |
| Insertion sort | O(n) | O(n²) | O(n) | O(n²) |

## Söndra och härska (Divide and Conquer)
Dela problem → lösa subproblem → kombinera. Lättast med rekursion.

**Exempel: hitta max i array:**
```java
int max(int a[], int low, int high){
  if(low==high) return a[low];
  int m1=max(a,low,(low+high)/2);
  int m2=max(a,(low+high)/2+1,high);
  return m1>m2 ? m1 : m2;
}
```

## Shellsort — bättre än O(n²) i praktiken
- Dela upp i subarrayer med gap = n/2, n/2.2, ..., 1
- Sortera varje subarray med instickssortering
- Effektivt: (1) insertion sort snabb på små arrayer, (2) utnyttjar befintlig ordning, (3) element hoppar långt direkt
- Algoritm: gap=n/2, medans gap>0: insickssortera med gap, om gap==2: gap=1, annars gap/=2.2

## O-notation

**Formell definition:** T(n) = O(f(n)) omm det existerar konstant c och n₀ sådant att cf(n) ≥ T(n) för alla n > n₀.

**Vanliga klasser:**
O(1) < O(log n) < O(n) < O(n log n) < O(n²) < O(n³) < O(2^n) < O(n!)

**n=1 000 000 vid 10⁻⁹ s/sats:**
- O(n): 1 ms
- O(n log n): ~20 ms
- O(n²): 16.7 minuter!

---
type: topic
tags: [sortering, algoritm, komplexitet, jämförelse]
created: 2026-04-21
updated: 2026-04-21
sources: [F9-Sortering, F10-Heap-Sortering]
---

# Sorteringsalgoritmer — Samlad översikt

## Komplett jämförelsetabell

| Algoritm | Tid Bäst | Tid Medel | Tid Värst | Minne | Stabil | Metod |
|----------|----------|-----------|-----------|-------|--------|-------|
| Selection sort | O(n²) | O(n²) | O(n²) | O(1) | Nej | Jämförelse |
| Insertion sort | **O(n)** | O(n²) | O(n²) | O(1) | **Ja** | Jämförelse |
| Bubble sort | O(n) | O(n²) | O(n²) | O(1) | Ja | Jämförelse |
| Shellsort | O(n log n) | O(n^1.5) | O(n²) | O(1) | Nej | Jämförelse |
| Mergesort | O(n log n) | O(n log n) | O(n log n) | **O(n)** | **Ja** | Söndra-härska |
| Heapsort | O(n log n) | O(n log n) | O(n log n) | **O(1)** | Nej | Heap |
| Quicksort | O(n log n) | O(n log n) | **O(n²)** | O(log n) | Nej | Söndra-härska |
| Counting sort | O(n+k) | O(n+k) | O(n+k) | O(k) | Ja | Icke-jämf. |
| Radix sort | O(d(n+k)) | O(d(n+k)) | O(d(n+k)) | O(n+k) | Ja | Icke-jämf. |

*k = max värde, d = antal siffror*

## Undre gräns för jämförande sortering

Jämförande sortering kan **aldrig** bli bättre än **O(n log n)** i värsta fall (informationsteori). Icke-jämförande algoritmer (counting, radix) kan bryta detta.

## Algoritmer i detalj

### Urvalssortering (Selection Sort)
- Hitta minsta → byt till position 0. Hitta näst minsta → byt till position 1. Osv.
- **Jämförelser alltid O(n²)** — ignorerar ordning helt
- **Platsbyten alltid O(n)** — bra om bytes är dyra
- Ej stabil med normal implementering

### Instickssortering (Insertion Sort)
- "Kortsorterar" — sätt in nästa element på rätt plats i redan sorterad del
- **O(n) på nästan sorterade arrayer** — används av Timsort och Shellsort som slutsteg
- Ingen swap — en tilldelning per flytt (snabbt)
- Stabil

### Shellsort
- Instickssortering med varierande gap: n/2 → n/2.2 → ... → 1
- Effektivt för medelstora arrayer
- Ej stabil, O(1) extra minne
- Komplexitet beror på gap-sekvens

### Mergesort
- Dela mitten, sortera rekursivt, slå samman
- **Garanterat O(n log n)** — kräver O(n) extra minne
- Stabil — föredras för länkade listor
- Java `Collections.sort` och `Arrays.sort(Object[])` använder Timsort (mergesort-variant)

### Heapsort
- Bygg max-heap → ta ut rot n gånger
- **O(n log n) alltid, O(1) minne**
- Ej stabil — föredras i säkerhetskritisk kod (ingen worst-case O(n²))

### Quicksort
- Välj pivot, dela i ≤pivot och >pivot, sortera rekursivt
- **O(n²) värsta fall** (men sällan i praktiken med bra pivot-val)
- Java `Arrays.sort(int[])` använder dual-pivot quicksort
- Ej stabil, snabb i praktiken pga cache-lokalitet

### Counting Sort
- Räkna förekomster → skriv tillbaka
- **O(n+k)** — inte jämförande! Kan vara bättre än O(n log n)
- Effektivt om max-värdet k är litet
- Extra minne O(k) — dåligt om k är stort

### Radix Sort
- Sortera siffra för siffra från minst signifikant
- Kräver **stabil** inre sortering (counting sort)
- O(d*(n+k)) där d = antal siffror/bokstäver

## Välj algoritm efter scenario

| Scenario | Rekommendation |
|----------|---------------|
| Generell storlek, okänd data | Mergesort / Timsort |
| Liten array (<20 element) | Insertion sort |
| Nästan sorterad | Insertion sort |
| Inget extra minne | Heapsort |
| Säkerhetskritisk (ingen O(n²)) | Heapsort |
| Heltal i känt litet intervall | Counting sort |
| Flercifrigt tal/sträng | Radix sort |
| Standardbibliotek Java | `Arrays.sort()` / `Collections.sort()` |

## Relaterat

- [[Heap]] — datastruktur för Heapsort och prioritetskö
- [[Rekursion]] — Mergesort och Quicksort är rekursiva
- [[Söndra och härska]] — Mergesort, Quicksort, Shellsort-paradigm
- [[O-notation]] — analys av alla ovanstående

---
type: source-summary
tags: [söndra och härska, divide and conquer, mergesort, rekursion]
created: 2026-04-21
lecture: F13
---

# F13 — Söndra och härska

## Definition
1. **Divide** — bryt ned problemet i mindre delar
2. **Conquer** — lös varje del (rekursivt)
3. **Combine** — kombinera dellösningarna

T(1) = 1, T(n) = 2T(n/2) + n → O(n log n) (typisk rekurrens)

## Maximal delsekvens
Hitta delsekvensen med störst summa i en array med positiva och negativa tal.
Exempel: 24, 35, -87, **21, 80, -12, 32**, -90, 45, 10 → svar: 121

**Söndra och härska O(n log n):**
```
maxSum(a, left, right):
  om left=right: return max(0, a[left])
  center = (left+right)/2
  // hitta max-summa som slutar vid center (scannar vänster)
  // hitta max-summa som börjar vid center+1 (scannar höger)
  maxÖverMitt = maxLeft + maxRight
  return max(maxÖverMitt, maxSum(a,left,center), maxSum(a,center+1,right))
```
T(n) = 2T(n/2) + n → O(n log n)

**Smartare O(n) (Kadane):**
```
maxSum(a):
  maxSumma = maxLokal = 0
  för i = 0 till n-1:
    maxLokal = max(maxLokal + a[i], 0)
    maxSumma = max(maxLokal, maxSumma)
  return maxSumma
```

## Skyline-problemet
Givet n hus (x₁, y, x₂), beräkna skyline.
- Naivt: O(n²) (sätt in ett hus i taget)
- Söndra och härska: T(1)=1, T(n)=2T(n/2)+n → O(n log n)
- Combine-steget: slå samman två skylines (som merge i mergesort)

## Closest pair (närmaste par)
Givet n punkter, hitta de två närmaste.
- Naivt: O(n²)
- Söndra och härska: O(n log n)
  - Dela vid mitten (x-koordinat)
  - Lös vänster och höger rekursivt → minAvstånd d
  - Combine: kontrollera bara punkter inom ±d från mitten
  - Varje punkt behöver kontrolleras mot max **6** grannar → O(n) combine
  - Kräver sortering av mittpunkterna efter y → O(n log n) totalt

## Växelproblemet med söndra och härska
```
växel(belopp):
  för i = 0 till n-1:
    om mynt[i] = belopp: return 1
  bäst = 100000
  för i = 0 till n-1:
    om mynt[i] < belopp:
      bäst = min(bäst, 1 + växel(belopp - mynt[i]))
  return bäst
```
Ineffektivt! Löser samma delproblem många gånger → **dynamisk programmering** (F14) effektiviserar.

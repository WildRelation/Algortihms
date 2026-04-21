---
type: source-summary
tags: [girig algoritm, greedy, växel, kappsäck, schemaläggning]
created: 2026-04-21
lecture: F12
---

# F12 — Giriga algoritmer

## Definition
En girig algoritm löser delproblem genom att **lokalt bästa val** vid varje steg utan att omvärdera tidigare val. Den ser inte det globala problemet.

Beroende på problem: optimal lösning | hygglig lösning | helt usel lösning.

## Växelproblemet
Minsta antal mynt för att ge x kr växel.

**Girig algoritm:**
```
n = 0
Medans x > 0:
    p = störst valör ≤ x
    x = x – p; n++
Svar: n
```
- Fungerar för svenska valutor (1, 2, 5, 10, 25, 50...)
- **Fungerar EJ för godtyckliga valutor!**
- Motexempel: 30 kr med valutor {1, 10, 25} → girig: 25+1+1+1+1+1 = 6 mynt; optimal: 10+10+10 = 3 mynt

→ Lösning med söndra-härska (F13) eller **dynamisk programmering** (F14) fungerar alltid.

## Kappsäcksproblemet (knapsack)
n varor med värde vᵢ och vikt wᵢ. Kappsäck max W kg. Maximera värdet.

**Obegränsad version** (av varje vara finns obegränsat antal):
Girig: välj vara med högst kr/kg, fyll på, sedan näst högst osv.
- Garanterat ≥ 50% av optimala värdet (obegränsad)
- Kan misslyckas med begränsad variant: 20kg kappsäck, 12kr/11kg, 10kr/10kg

**Dynamisk programmering** ger alltid optimal lösning.

## Schemaläggning
Sal + aktiviteter med start/sluttid. Schemalägga max antal.

**Girig (välj alltid den som slutar först):**
```
Medans V inte tom:
    Schemalägg aktivitet med tidigast sluttid
    Ta bort den + alla överlappande
```
→ **Ger faktiskt den optimala lösningen!**

## Färgläggning av karta (Vertex Coloring)
Färglägg länder så inga angränsande har samma färg.
- Alltid möjligt med max 4 färger (fyra-färgs-satsen)
- Ingen algoritm garanterar minimalt antal färger

**Girig:** välj land → ge lägsta tillgängliga färg
- Kan ge optimal lösning för viss ordning
- Kan ge sämsta möjliga för annan ordning

## Handelsresandeproblemet (TSP)
Besök alla städer exakt en gång, minimera total väg.

**Girig (Nearest Neighbour):**
```
Välj startstad
Medans obesökta städer finns:
    Res till närmaste obesökta stad
Res tillbaka till start
```
- Genomsnitt: 25% längre än optimal rutt
- Kan konstrueras att ge sämsta möjliga rutt
- Optimal lösning: O(n!) → behöver DP (Held-Karp: O(n²·2^n))

## Huffmankodning
Kortare koder för vanligare tecken → minimerar filstorlek.
Huffman-algoritmen kan anses girig.

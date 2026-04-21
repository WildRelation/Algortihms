---
type: source-summary
tags: [mängd, avbildning, hashtabell, hash, kollision]
created: 2026-04-21
lecture: F8
---

# F8 — Mängd, Avbildning, Hashtabell

## Mängd (Set)
Samling **utan kopior**. Lägger man till A i {A,B,C} → {A,B,C}.
Operationer: membership-test, add, remove, union, snitt, differens, delmängd.
JCF: `Set<E>` interface → `TreeSet` (ordnad), `HashSet`, `BitSet` (1 bit per heltal).

## Avbildning (Map)
Mängd av ordnade par **(nyckel, värde)**. Nycklar unika, värden behöver inte vara unika.
Metoder: `get(key)`, `put(key, value)`.

## Hashtabell — O(1) genomsnitt
**Princip:** nyckel → hashkod → tabellindex.
- Direkt nyckeln som index: tabell för stor.
- `nyckel % tabellstorlek`: ojämn distribution, för många kollisioner.
- **Bra hashfunktion:** jämnt fördelad, effektiv att beräkna.

**Java String hashCode:** `s[0]*31^(n-1) + ... + s[n-1]`. 31 är primtal → få kollisioner.

**Egna klasser:** alltid `override hashCode()` när du overridar `equals()`. Använd `Objects.hash(field1, field2, ...)`.

## Kollisionshantering

### Öppen adressering (linjär sondering)
- Insättning: om index upptagent → index++ (cirkulärt) tills null
- Sökning: index++ tills rätt nyckel eller null
- Borttagning: sätt **dummy** (kan inte sätta null — bryter sökning)
- **Aldrig tillåta full/nästan full tabell** → O(n) sökning
- Rehash vid 75% beläggning. Vid rehash: sätt INTE in dummies igen

### Kvadratisk sondering
Vid krock, proba positioner 1, 4, 9, 16... bort (minskar klustring).
`k+=2; index=(index+k)%table.length` (startar k=-1)
Kräver tabell max halvfull och primtalsstorlek för att garantera lediga platser.

### Länkning (Chaining / Bucket hashing)
Varje index → länkad lista av element med samma hashindex.
- Ingen dummy vid borttagning
- Dynamisk storlek, rehash ändå vid ~75% beläggning
- Tar mer plats (en pekare extra per element)

## Load factor (L) = fyllda platser / tabellstorlek
| L | Linjär sondering (probes) | Länkning (probes) |
|---|--------------------------|-------------------|
| 0.5 | 1.50 | 1.25 |
| 0.75 | 2.50 | 1.38 |
| 0.9 | 5.50 | 1.45 |

→ Länkning hanterar hög beläggning mycket bättre.

## Jämförelse: Hashtabell vs BST vs Sorterad array
| Struktur | Sökning | Insättning | Ordning |
|----------|---------|-----------|---------|
| Sorterad array | O(log n) | O(n) | Ja |
| BST (balanserat) | O(log n) | O(log n) | Ja |
| Hashtabell | O(1) | O(1) | Nej |

Hashtabell är bäst om ordning ej behövs.

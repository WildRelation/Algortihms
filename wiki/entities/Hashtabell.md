---
type: entity
tags: [hashtabell, hash, kollision, datastruktur, O(1)]
created: 2026-04-21
updated: 2026-04-21
sources: [F8-Mangd-Hash]
---

# Hashtabell

En hashtabell implementerar en [[Mängd]] eller [[Avbildning]] med O(1) genomsnittlig tid för sökning, insättning och borttagning via en hashfunktion.

## Princip

```
nyckel → hashfunktion → hashkod (int) → % tabellstorlek → index
```

## Hashkoder

**Java String:** `s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]`
- 31 är valt för att vara ett lagom primtal → jämn distribution
- `"Cat"` → `'C'×31² + 'a'×31 + 't' = 67510`
- Index i tabell: `s.hashCode() % table.length`

**Egna klasser:**
- Alla klasser ärver `hashCode()` från Object (intern adress — fel för value-equality)
- **Regel:** Om du overridar `equals()`, **måste** du overrida `hashCode()`
- Enklaste: `return Objects.hash(field1, field2, ...);`

## Kollisionshantering

### 1. Öppen adressering (linjär sondering)

**Insättning:** om index[h] är taget → h = (h+1) % storlek, tills null
**Sökning:** h++ tills rätt nyckel eller null
**Borttagning:** sätt **dummy** (kan ej sätta null — bryter sökstigar)
**Problem:** Klustring — poster staplas, O(n) i värsta fall
**Krav:** Tabell aldrig full; rehash vid 75% beläggning; lägg ej in dummies vid rehash

### 2. Kvadratisk sondering
Vid krock: proba position +1, +4, +9, +16... (`k+=2; index=(index+k)%length`)
Minskar klustring dramatiskt.
**Krav:** tabell max halvfull OCH primtalsstorlek → garanterar lediga platser

### 3. Länkning (Chaining / Bucket Hashing)
Varje index pekar på en länkad lista av element.
- Ingen dummy vid borttagning
- Hanterar hög beläggning bättre
- Rehash vid ~75% (kursens rekommendation; boken säger 300%)
- Tar mer plats (extra pekare per element)

## Load factor och prestanda

L = antal element / tabellstorlek

| L | Linjär sondering | Länkning |
|---|-----------------|----------|
| 0.5 | 1.50 | 1.25 |
| 0.75 | **2.50** | 1.38 |
| 0.9 | 5.50 | 1.45 |

→ Länkning drastiskt bättre vid hög beläggning.

## Tips: minska kollisioner

1. Använd **primtal** för tabellstorleken
2. Rehash vid 75% (öppen adressering) eller konfiguerbar (länkning)
3. Använd kvadratisk sondering istället för linjär

## Jämförelse med alternativ

| Struktur | Sökning | Insättning | Ordning |
|----------|---------|-----------|---------|
| Sorterad array | O(log n) | O(n) | Ja |
| [[Binärt sökträd]] | O(log n) | O(log n) | Ja |
| Hashtabell | **O(1)** | **O(1)** | Nej |

Välj hashtabell för snabb lookup utan krav på ordning.
Välj BST om du behöver sorterad iteration eller närmaste element.

## Java API
- `HashMap<K,V>` — avbildning via hashtabell
- `HashSet<E>` — mängd via hashtabell
- `LinkedHashMap` / `LinkedHashSet` — bevarar insättningsordning

> [!note] Återkommande teorifråga
> Hashtabell dyker upp som teorifråga i 2 av 8 tentor:
> - "equals och hashCode från Object — hur hänger de ihop?" (2023-06)
> - "Öppen adressering — hur hanterar kollisioner för put/get/remove?" (2022-03)
> Se [[tentaanalys]] för fullständig lista.

## Relaterat
- [[Mängd]] — ett av de ADT:er som hashtabell implementerar
- [[Avbildning]] — det andra ADT:t
- [[Binärt sökträd]] — alternativt sätt att implementera Map/Set
- [[Länkad lista]] — används i länkningsmetoden
- [[tentaanalys]] — frekvensanalys av teorifrågor

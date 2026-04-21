---
type: entity
tags: [avbildning, map, ADT, nyckel-värde]
created: 2026-04-21
updated: 2026-04-21
sources: [F8-Mangd-Hash]
---

# Avbildning (Map)

En avbildning är en **mängd av ordnade par (nyckel, värde)**. Nycklarna är unika; värdena behöver inte vara unika.

## Definition

`{(J, Jane), (B, Bill), (S, Sam), (B1, Bob), (B2, Bill)}`
- keySet: {J, B, S, B1, B2} — unika nycklar
- valueSet: {Jane, Bill, Sam, Bob, Bill} — kan ha kopior

## Operationer

| Metod | Beteende |
|-------|---------|
| `get(key)` | Returnera värde för nyckel (null om saknas) |
| `put(key, value)` | Lägg till/uppdatera par |
| `remove(key)` | Ta bort par |
| `containsKey(key)` | Membership-test |
| `keySet()` | Alla nycklar (en [[Mängd]]) |
| `values()` | Alla värden |
| `entrySet()` | Alla par |

## Avbildning i JCF

`Map<K,V>` är ett interface. Implementeringar:

| Klass | Implementering | Ordnad? | Komplexitet |
|-------|---------------|---------|-------------|
| `HashMap<K,V>` | [[Hashtabell]] | Nej | O(1) |
| `TreeMap<K,V>` | Red-Black Tree | Ja (nyckelordning) | O(log n) |
| `LinkedHashMap<K,V>` | Hash + länk | Insättningsordning | O(1) |

## Välj rätt implementering

- Snabb lookup utan ordning → `HashMap`
- Sorterade nycklar, range-frågor → `TreeMap`
- Bevara insättningsordning → `LinkedHashMap`

> [!note] Återkommande teorifråga
> "Beskriv termerna mängd och avbildning. Beskriv kort hur man kan implementera en avbildning." (2023-03)
> Se [[tentaanalys]] för fullständig lista.

## Relaterat

- [[Mängd]] — avbildning är en utökning av mängden
- [[Hashtabell]] — implementerar HashMap
- [[Binärt sökträd]] — implementerar TreeMap
- [[tentaanalys]] — frekvensanalys av teorifrågor

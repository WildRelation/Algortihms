---
type: entity
tags: [girig algoritm, greedy, optimering, heuristik]
created: 2026-04-21
updated: 2026-04-21
sources: [F12-Giriga-Algoritmer]
---

# Girig algoritm (Greedy Algorithm)

En girig algoritm gör vid varje steg det **lokalt bästa valet** utan att ta hänsyn till det globala problemet, och omvärderar aldrig tidigare val.

## Egenskaper

- Enkel att konstruera och implementera
- Ofta effektiv när den fungerar
- Ger ibland optimal lösning, ibland bara en approximation, ibland dålig lösning

## Paradigmjämförelse

| Paradigm | Strategi | Optimal? |
|---------|---------|---------|
| Girig | Lokalt bästa, aldrig backa | Ibland |
| [[Backtracking]] | Utforska allt, prune | Ja |
| [[Söndra och härska]] | Dela, lös, kombinera | Ja (för rätt problem) |
| [[Dynamisk programmering]] | Tabellera dellösningar | Ja |

## Problemexempel

### Växelproblemet
Girig: välj störst möjlig valör.
- **Fungerar:** standardvalutor (1,2,5,10,25,50,100,200,500,1000)
- **Fungerar EJ:** 30 kr med valutor {1,10,25}: girig ger 6 mynt (25+5×1), optimal ger 3 (10+10+10)

### Kappsäcksproblemet (obegränsad)
Girig: välj vara med högst värde/kg.
- Garanterat ≥ 50% av optimala värdet (obegränsad variant)
- Kan ge sämre resultat med begränsad variant

### Schemaläggning
Girig: välj alltid aktiviteten med tidigast sluttid.
- **Optimal!** Bevisat optimalt för maximize-antal-aktiviteter

### Färgläggning (Vertex Coloring)
Girig: ge varje nod lägsta tillgängliga färg.
- Ej optimal i allmänhet
- Resultat beror på ordningen noder väljs

### Handelsresandeproblemet (Nearest Neighbour)
Girig: res alltid till närmaste obesökta stad.
- I genomsnitt 25% längre än optimal rutt
- Kan konstrueras att ge sämsta möjliga

## När fungerar giriga algoritmer?

Fungerar garanterat optimalt när problemet har **girig-valbara egenskapen**: lokalt optimala val leder till globalt optimal lösning. Bevis krävs!

Exempel på provbart optimala giriga algoritmer:
- [[Prims algoritm]] — minimalt spännträd
- [[Dijkstras algoritm]] — kortaste väg (ibland klassad som girig)
- Schemaläggning (tidigt-sluttid-strategi)
- Huffmankodning

## Relaterat

- [[Dynamisk programmering]] — alternativ som garanterar optimal lösning
- [[Backtracking]] — utforskar alla alternativ
- [[Dijkstras algoritm]] — ibland klassad som girig

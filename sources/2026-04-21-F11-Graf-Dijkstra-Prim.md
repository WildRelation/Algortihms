---
type: source-summary
tags: [graf, Dijkstra, Prim, kortaste vägen, MST]
created: 2026-04-21
lecture: F11
---

# F11 — Graf, Dijkstra och Prim

## Dijkstras algoritm — kortaste vägen från en källa

Hittar kortaste vägen från en startnod s till alla övriga noder i en **viktad graf med icke-negativa vikter**.

**Pseudokod:**
```
T = V                        // alla noder ej klara
för alla v∈T: d(v) = ∞
d(s) = 0
Medans T ≠ ∅:
    Sätt u = nod i T med minst d(u)
    T = T – {u}
    För alla v angränsande till u:
        Om d(v) > d(u) + w(u,v):
            d(v) = d(u) + w(u,v)   // relaxering
            p(v) = u               // föregångare (för att rekonstruera väg)
```

**Exempelgraf A–H** (start A):
Steg 1 → F (d=1): uppdaterar D(2), G(6)
Steg 2 → D(2) och B(2): C=4, E=5 via B+D
Steg 3 → C(4): H=5
Steg 4 → E(5), H(5): G=6 (oförändrad)
Resultat: A=0, B=2, C=4, D=2, E=5, F=1, G=6, H=5

**Komplexitet:**
- Naivt (array): O(V²)
- Med PriorityQueue (min-heap): O((V+E) log V)

**Krav:** Icke-negativa vikter!

## Prims algoritm — minimalt spännträd (MST)

Hittar minimalt spännträd (träd som når alla noder med lägsta total vikt).

**Struktur:** nästan identisk med Dijkstra!
- Dijkstra: `d(v) = d(u) + w(u,v)` (avstånd från källa)
- Prim: `d(v) = w(u,v)` (kantvikt direkt)
- Annars samma algoritm och komplexitet

**Skillnad Dijkstra vs Prim:**
| | Dijkstra | Prim |
|--|---------|------|
| Mål | Kortaste vägen | Minimalt spännträd |
| d(v) uppdateras med | d(u)+w(u,v) | w(u,v) |
| Krav | Positiva vikter | Posit. vikter (generellt) |

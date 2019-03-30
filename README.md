# Treasures Quest
**Grupparbete - Testdriven Utveckling**

**Kursledare:** Holger Rosencrantz

**Deltagare** Alfred Grimlund, Sten Karlsson, Stefan Sundström

Länk till Planering: https://github.com/StenKarlsson/TDD-Grupparbete/projects/2

Inspiration: // Alfred kanske har en länk till brädspelet?

## Syfte

Syftet med uppgiften är att med hjälp av JUnit skriva tester som ska stå som grund för implementerad funktionalitet - att expandera applikationen utifrån dessa. Som platform för sammarbetet används Github där dokumentation och kod redovisas.

## Verktyg

* Eclipse
* JUnit4 
* Photoshop
* GitHub Desktop


## Om Applikationen

Applikationen är ett spel med 8-bitarskänsla som går ut på att en spelkaraktär vandrar omkring i en labyrintliknande värld och samlar skatter för att öppna dörren till nästa nivå. Spelaren har en viss tid på sig för att klara diverse bana och för att försvåra uppdraget finns bla rörliga eldklot som spelkaraktären måste akta sig för. 

## Inspiration/Bakgrund

// tankesättet för att komma igång med uppgiften och hur progammet i grunden är uppbyggt 



## Användarinput (KeyBindings)

// Om hur Keybindings fungerar, varför vi bytte från ActionListener, skillnader etc

## Sprites

Spelet bygger på "klossar" i en 2D Array. En stor del av testerna utgår från dessa och ligger som grund till implementationen av deras egenskaper.

* Spelkaraktär 
* Vägg
* Golv
* Dörr
* Laser
* Frågetecken

## Spelkaraktär

// Om spelkaraktären - vad denna ska kunna göra

### Tester

### Implementation

## Vägg

// Om vägg - vad denna har för egenskaper

### Tester

### Implementation

## Golv

// Om golv - vad denna har för egenskaper

### Tester

### Implementation

## Dörr

// Om dörr- vad denna har för egenskaper

### Tester

### Implementation

## Laser

// Om laser- vad denna har för egenskaper

### Tester

### Implementation

## Frågetecken 

Tanken med frågtecknet är att spelaren inte ska kunna förutsäga utfallet, man kan få skatter, liv, tid eller avaktivera lasern men även förlora liv och tid.

### Tester
Här handlar det givetvis inte om att testa java-metoden Math.random() utan att de möjliga utfallen resulterar i vad som är tänkt.
...... osv

### Implementation

Koden bygger på en slumpfunktion som sätter inputparametern till en switchsats vilket resulterar i ett av sex möjliga ufall.
```

		rand = (int)(6.0*Math.random());

		switch(rand) 
		{
			case 0: // Tar ett liv
			this.characterObject.subractLife(1);
			removeOneHeart();							
			break;

			case 1: // Plockar upp 5 skatter
			characterObject.grabTreasure(5);
			decreaseTreasuresLeftOnLevel(5);
			break;

			case 2: // Stänger av lasern

			...osv
			
```

## Svårigheter

- Grundläggande svårigheter med strukturen av spelplanen
- Ett smidigt sätt att rita upp nästa bana
- Få rörelse i lasern (även ta upp Stens tanke kring hur detta skulle kunnat göras)
- Färger och hantering av tester kring dessa / fördelar nackdelar

## Slutligen

// Om vad vi fått ut av uppgiften/testerna, samarbete..




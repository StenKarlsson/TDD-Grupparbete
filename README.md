# Treasures Quest
**Grupparbete - Testdriven Utveckling**

**Kursledare:** Holger Rosencrantz

**Deltagare** Alfred Grimlund, Sten Karlsson, Stefan Sundström

Länk till Planering: https://github.com/StenKarlsson/TDD-Grupparbete/projects/2



## Syfte

Syftet med uppgiften är att med hjälp av JUnit skriva tester som ska stå som grund för implementerad funktionalitet - att expandera applikationen utifrån dessa. Som platform för sammarbetet används Github där dokumentation och kod redovisas.

## Verktyg

* Eclipse
* JUnit4 
* Photoshop
* GitHub Desktop


## Om Applikationen

Applikationen är ett spel med 8-bitarskänsla som går ut på att en spelkaraktär vandrar omkring i en labyrintliknande värld och samlar skatter för att öppna dörren till nästa nivå. Spelaren har en viss tid på sig för att klara diverse bana och för att försvåra uppdraget finns bla rörliga eldklot som spelkaraktären måste akta sig för. 

## Bakgrund/Arbetsprocess

Inledningsvis började vi med att försöka konkretisera hur en 2d-Array kan översättas till ett grafiskt interface som en spelare kan använda sig av. Det finns gott om exempel/tutorials att titta på som illustrerar sådana exempel. I en tutorial (https://stackoverflow.com/questions/21142686/making-a-robust-resizable-swing-chess-gui) där ett schack-spel byggs upp så används ett Swingfönster som fylls med komponenten JButton. JButtons har inbyggda metoder för att visa färger och bilder som är enkla att hantera så valet föll på att göra en liknande modell. Vi valde också att disponera dessa JButtons med en GridLayout-Manager som placerar ut komponenterna i ett rutmönster som består av 25*25 rutor.  

Därefter påbörjades processen få det grafiska gränssnittet att översätta 2D-arrayens siffror till färger. I vårat projekt finns en klass som heter GameBoardInterface där dessa processer är implementerade. Metoderna buildButtonArray och paintButtonArray ansvarar för denna ”översättning”.  

Flera av de ursprungliga testerna hade som syfte att just få till implementering som skulle se till att de grundläggande funktionerna i spelet fanns. Till exempel, att en ruta kunde tilldelas en bild/färg, att förflytta en karaktär mellan olika rutor, att få karaktären att kunna ”ta” ett objekt i en ruta, att få till väggar som karaktären inte kan ta sig igenom osv. 

Att arbeta med 2d-arrayer kan vara ganska omständigt arbete eftersom varje punkt i det 2-dimensionella planet måste anropas med en position för rad och en position för kolumn (x och y-värden).
För att underlätta arbetet med att hämta data från en viss position i 2d-arrayerna skapades klassen Position som extendar klassen Point. Med hjälp av dess inbygda metoder kan man skapa olika positioner i det 2-dimensionella planet och arbeta med istället. Detta har underlättat både testandet och implementeringen av kod.  
         
När det gäller testerna så har utvecklingen av programmet skett växelvis med implementationen av kod. De tidiga testerna har handlat om grundläggande saker som att ifall man kan läsa in ett värde från 2d-arrayen som fungerar som en ritning för banan. 
I klassen RegisterPositionOnGameBoard så kollas till exempel om testmetoden kan returnera aktuellt värde från en specifik position från en 2d-array. 

Ju längre utvecklingen av spelet har kommit desto mer har testerna blivit baserade på antaganden om vilka metoder som kommer att behövas och vilken funktionalitet som dessa metoder behöver ha. 



## Användarinput (KeyBindings)

Vi använde till en början KeyListener för att förflytta spelarens karaktär, men på grund av problem med att fokus flyttades från komponenten
så blev det helt enkelt lättare att använda KeyBindings eftersom det funkar oavsett var fokus är.

## Sprites

Spelet bygger på rutor i en 2D Array. En stor del av testerna utgår från dessa och ligger som grund till implementationen av deras egenskaper.

Inledningsvis så tilldelades alla rutorna i spelet en egen färg för att få en visuell överblick över spelet. Senare har dessa positioner också tilldelats en bild för att få en grafik som syftar till att ge en sorts 8-bits-känsla. 


* Spelkaraktär 
* Vägg
* Golv
* Dörr
* Laser
* Frågetecken

## Spelkaraktär

Spelkaraktärens ruta gestaltas av färgen turkos (cyan) som tilldelas den ruta som är angiven som spelarens startposition. 

## Tester
Många tester av spelet har på något sätt med karaktären att göra. Det handlar om rörelser, kollisioner med andra sprites, om den kan "ta" skatter osv. Dessa finns i mappen characterMovementTests. Här görs tex olika asserteringar om att figuren inte ska kunna röra sig åt en riktning där det finns en vägg och asserteringar om att när spelaren trycker på knapp som syftar till att karaktären rör sig i den angivna riktningen verkligen gör det. 


### Implementation

Karaktären representeras av en egen klass somheter GameCharacter. I den klassen anges startposition, antal liv osv. Här finns ocks de metoder som anropas när figuren förflyttar sig. 
## Vägg

I spelet representeras väggen inte av en egen klass. Däremot så representeras den av en färg/bild på det 2-dimensionella spelbrädet. 
Alla positioner med värde 1 på spelplanen målas ut som en svart ruta. Efter att det grafiska manéeret är satt så visas också väggarna med en tegelmönstrad bild. Väggen ska till skillnad från de andra ytorna inte gå att passera. 

### Tester

I klassen AvoidWallCollisionTest så förflyttas karaktären mot en vägg. Implementationen som är en följd av detta test omöjliggör att karaktären kan ta sig igenom/förbi en vägg. 

### Implementation
I klassen GameBoardInterface finns en metod som heter positionEvent i där det triggas olika händelser beroende på var karaktären befinner sig. Om står står vid en vägg och rör sig i riktningen mot väggen så förhindras förflyttningen genom den metoden. 

## Golv

// Om golv - vad denna har för egenskaper

### Tester

### Implementation

## Dörr
Dörren som spelare ska passera igenom representeras av en egen klass som heter Door. En instans av Door finns i klassen GameBoardInterface. Dörren har egenskaper som position samt om den är låst eller inte.  

### Tester
I klassen newLevel görs asserteringar om att dörren ska byta tillstånd från att vara låst till att vara olåst om spelaren har fångat alla skatter i rummet samt att en ny bana läses in när spelaren passerar den olåsta dörren. 

### Implementation
Implementationen för klassen dörr är mycket grundläggande med instansvariabler för position och en boolsk variabel som avgör om den är låst eller inte. Dessa har också publika getters och setters som anropas från klassen GameBoardInterface när antalet hämtade skatter == 10. 

## Laser

I spelet representeras lasern inte av en egen klass utan av färgen röd på det 2-dimensionella spelbrädet, eftersom lasern ska vara rörlig utnyttjas två olika nummer när spelbrädet ritas up. Genom att låta dessa växla mellan laser och golv (utifrån färg färg) simuleras en förflyttning.

### Tester

I klassen CollisonWithLaserTest kontrolleras att spelakaraktären dör den gå på en laser, här kontrolleras också att spelakaraktären flyttas till startpositionen samt att en rörlig laser dödar en stillastående spelkaraktär. 

### Implementation

Lasern är representerad av en aktiv(indexvärde 3) och en inaktiv(indexvärde 6) laser på spelbrädet i klassen Levels. Dessa två värden pendlar mellan att ges färgen vit(som är golv) och röd(laser) med flipLaserOnGameBoard i GameBoardInterface-klassen. 

Dubbla for-loopar ittererar igenom alla index, själva kärnan i koden går sedan ut på att göra en knapp vit om den är röd och tvärt om förutsatt att värdet på spelbrädet är 3 eller 6.

```

if (value==3 || value ==6) 
{
if (color == color.RED) {colouriseSquare(color.WHITE,position);}
else { colouriseSquare(color.RED,position);
}

```
Från mainmetoden i klassen Main har lasern en egen tråd, denna metod anropas gång på gång i en while-loop, metoden Thread.sleep() avgör hur frekvent. Vi har här valt att med hjälp av getters och setters styra inparameters värde och kan på så sätt ändra laserns frekvens som en del av spelet

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

## Kända buggar

// Hoppas detta är åtgärdat

Spelet har en del oförutsedda sidoeffekter som vi inte hunnit åtgärda tex:
•	Att när en laser målas ut på en ruta som karaktären står på så försvinner karaktären från den rutan och ersätts med bilden på lasern. 
•	Att rutan som karaktären dör på ibland ersätts av en laser.

## Slutligen
Det har varit en lärorik process att skapa spelet. Inte bara för det skapat en större förståelse för hur testdriven utveckling kan gå till utan också för att det ökat förståelse för hur 2-dimensionella spel kan byggas. 
Jag tror att vi alla gärna hade fortsatt med utvecklingen och byggt vidare på spelet. Det finns oändligt många utvecklingmöjligheter med att lägga till olika features i spelet som vapen, monster osv, vilket hade varit kul. 




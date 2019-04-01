# Treasure Quest
**Grupparbete - Testdriven Utveckling**

**Kursledare:** Holger Rosencrantz

**Deltagare** Alfred Grimlund, Sten Karlsson, Stefan Sundström

Länk till Planering: https://github.com/StenKarlsson/TDD-Grupparbete/projects/2

Bilderna är "lånade" från https://thegameassetsmine.com, www.keywordhungry.com, www.opengameart.org och www.minecraftforum.net.

## Syfte

Syftet med uppgiften är att med hjälp av JUnit skriva tester som ska stå som grund för implementerad funktionalitet - att expandera applikationen utifrån dessa. Som platform för samarbetet används Github där dokumentation och kod redovisas.

## Verktyg

* Eclipse
* JUnit4 
* Photoshop
* GitHub Desktop


## Om Applikationen

Applikationen är ett spel med 8-bitarskänsla som går ut på att en spelkaraktär vandrar omkring i en labyrintliknande värld och samlar skatter för att öppna dörren till nästa nivå. Spelaren har en viss tid på sig för att klara diverse bana och för att försvåra uppdraget finns bla rörlig laser som spelkaraktären måste akta sig för. 

## Bakgrund/Arbetsprocess

Inledningsvis började vi med att försöka konkretisera hur en 2d-Array kan översättas till ett grafiskt interface som en spelare kan använda sig av. Det finns gott om exempel/tutorials att titta på som illustrerar sådana exempel. I en tutorial (https://stackoverflow.com/questions/21142686/making-a-robust-resizable-swing-chess-gui) där ett schack-spel byggs upp så används ett Swingfönster som fylls med komponenten JButton. JButtons har inbyggda metoder för att visa färger och bilder som är enkla att hantera så valet föll på att göra en liknande modell. Vi valde också att disponera dessa JButtons med en GridLayout-Manager som placerar ut komponenterna i ett rutmönster som består av 25*25 rutor.  

Därefter påbörjades processen få det grafiska gränssnittet att översätta 2D-arrayens siffror till färger. I vårat projekt finns en klass som heter GameBoardInterface där dessa processer är implementerade. Metoderna buildButtonArray och paintButtonArray ansvarar för denna ”översättning”.  

Flera av de ursprungliga testerna hade som syfte att just få till implementering som skulle se till att de grundläggande funktionerna i spelet fanns. Till exempel, att en ruta kunde tilldelas en bild/färg, att förflytta en karaktär mellan olika rutor, att få karaktären att kunna ”ta” ett objekt i en ruta, att få till väggar som karaktären inte kan ta sig igenom osv. 

Att arbeta med 2d-arrayer kan vara ganska omständigt arbete eftersom varje punkt i det 2-dimensionella planet måste anropas med en position för rad och en position för kolumn (x och y-värden).
För att underlätta arbetet med att hämta data från en viss position i 2d-arrayerna skapades klassen Position som extendar klassen Point. Med hjälp av dess inbyggda metoder kan man skapa olika positioner i det 2-dimensionella planet och arbeta med istället. Detta har underlättat både testandet och implementeringen av kod.  
         
När det gäller testerna så har utvecklingen av programmet skett växelvis med implementationen av kod. De tidiga testerna har handlat om grundläggande saker som att ifall man kan läsa in ett värde från 2d-arrayen som fungerar som en ritning för banan. 
I klassen RegisterPositionOnGameBoard så kollas till exempel om testmetoden kan returnera aktuellt värde från en specifik position från en 2d-array. 

Ju längre utvecklingen av spelet har kommit desto mer har testerna blivit baserade på antaganden om vilka metoder som kommer att behövas och vilken funktionalitet som dessa metoder behöver ha. 



## Användarinput (KeyBindings)

Vi använde till en början KeyListener för att förflytta spelarens karaktär, men på grund av problem med att fokus flyttades från komponenten
så blev det helt enkelt lättare att använda KeyBindings eftersom det funkar oavsett var fokus är.

## Timer

Det var ganska sent i processen vi adderade en timer till spelet (och då även den rörliga funktionen med lasern). Spelet kördes vid den tidpunkten i en tråd (utan loop) från mainmetoden, det behövdes inte mer då rörelsen av spelkaraktären visades grafiskt genom att ändra knapparnas egenskap för färg.

Eftersom vi kände att vi behövde hitta ett moment som innebar en utmaning bestämde vi oss för att begränsa tiden man har för att ta sig igenom en bana. Vi skapade en egen tråd för timern där vi kör metoden Threed.sleep() i en while-loop för att låta tråden vila 1 sek och sedan subtrahera 1 från variabeln timeInSeconds varje varv loopen körs. Med andra ord sätter variabeln timeInSeconds en nedräkning i sekunder, om tiden tar slut innan banan klarats så skrivs det "Game Over" och spelet är slut.

För att spelaren ska få en chans att se banan innan tiden börjar rulla så har vi satt en boolean som villkor (playerIsMoving) som triggar på en rörelse från spelkaraktären.

Lasern och Monstret gav vi också en egen tråd vilket beskrivs nedan. 

## Sprites

Spelet bygger på rutor i en 2D Array. En stor del av testerna utgår från dessa och ligger som grund till implementationen av deras egenskaper.

Inledningsvis så tilldelades alla rutorna i spelet en egen färg för att få en visuell överblick över spelet. Senare har dessa positioner också tilldelats en bild för att få en grafik som syftar till att ge en sorts 8-bits-känsla. 


* Spelkaraktär 
* Vägg
* Golv
* Dörr
* Laser
* Frågetecken
* Warp-Zone
* Monster

## Spelkaraktär

Spelkaraktärens ruta gestaltas av färgen turkos (cyan) som tilldelas den ruta som är angiven som spelarens startposition. 

**Tester**

Många tester av spelet har på något sätt med karaktären att göra. Det handlar om rörelser, kollisioner med andra sprites, om den kan "ta" skatter osv. Dessa finns i mappen characterMovementTests. Här görs tex olika asserteringar om att figuren inte ska kunna röra sig åt en riktning där det finns en vägg och asserteringar om att när spelaren trycker på knapp som syftar till att karaktären rör sig i den angivna riktningen verkligen gör det. 


**Implementation**

Karaktären representeras av en egen klass som heter GameCharacter. I den klassen anges startposition, antal liv osv. Här finns också de metoder som anropas när figuren förflyttar sig. 

## Vägg

I spelet representeras väggen inte av en egen klass. Däremot så representeras den av en färg/bild på det 2-dimensionella spelbrädet. 
Alla positioner med värde 1 på spelplanen målas ut som en svart ruta. Efter att det grafiska manéret är satt så visas också väggarna med en tegelmönstrad bild. Väggen ska till skillnad från de andra ytorna inte gå att passera. 

**Tester**

I klassen AvoidWallCollisionTest så förflyttas karaktären mot en vägg. Implementationen som är en följd av detta test omöjliggör att karaktären kan ta sig igenom/förbi en vägg. 

**Implementation**

I klassen GameBoardInterface finns en metod som heter positionEvent i där det triggas olika händelser beroende på var karaktären befinner sig. Om står står vid en vägg och rör sig i riktningen mot väggen så förhindras förflyttningen genom den metoden. 

## Golv

Precis som väggen har golvet ingen egen klass och representeras på samma sätt på spelbrädet. Golvet är neutralt i den mening att det inte inte tilldelas någon händelse i metoden positionEvent, däremot ingår golvet i många av testerna då det är viktigt för den grafiska representationen att de rörliga figurerna inte lämnar en "svans" efter sig. Vid en rörelse måste alltså positionen figuren rör sig till få figurens färg och positionen den rör sig från måste tilldelas golvets färg.

## Dörr

Dörren som spelare ska passera igenom representeras av en egen klass som heter Door. En instans av Door finns i klassen GameBoardInterface. Dörren har egenskaper som position samt om den är låst eller inte.  

**Tester**

I klassen newLevel görs asserteringar om att dörren ska byta tillstånd från att vara låst till att vara olåst om spelaren har fångat alla skatter i rummet samt att en ny bana läses in när spelaren passerar den olåsta dörren. 

**Implementation**

Implementationen för klassen dörr är mycket grundläggande med instansvariabler för position och en boolsk variabel som avgör om den är låst eller inte. Dessa har också publika getters och setters som anropas från klassen GameBoardInterface när antalet hämtade skatter == 10. 

## Laser

I spelet representeras lasern inte av en egen klass utan av färgen röd på det 2-dimensionella spelbrädet, eftersom lasern ska vara rörlig utnyttjas två olika heltal när spelbrädet ritas upp. Genom att låta dessa växla mellan laser och golv (röd och vit) simuleras en förflyttning.

**Tester**

I klassen CollisonWithLaserTest finns de tester som ligger till grund för implementationen - test för att se till att spelkaraktären dör när den går på en laser, att spelkaraktären flyttas till startpositionen samt att en rörlig laser dödar en stillastående spelkaraktär. 

**Implementation**

De två heltal som representerar laser på spelbrädet pendlar mellan att tilldelas färgen vit och röd i metoden flipLaserOnGameBoard i GameBoardInterface-klassen. 

Dubbla for-loopar ittererar igenom alla index, är värdet 3 eller 6 växlar färgen på dessa positioner mellan röd och vit. Dessa färger representerar laser och golv och är knutna till två bilder som också byts.

```

if (value==3 || value ==6) 
{
if (color == color.RED) {colouriseSquare(color.WHITE,position);}
else { colouriseSquare(color.RED,position);
}

```
Från mainmetoden i klassen Main har lasern en egen tråd, denna metod anropas i en while-loop där värdet som tas in i metoden Thread.sleep() avgör hur snabbt golv och laser byter plats. Vi har här valt att med hjälp av getters och setters styra inparameters värde och kan på så sätt ändra laserns hastighet som en del av spelet

## Frågetecken 

Tanken med frågetecknet är att spelaren inte ska kunna förutsäga utfallet, man kan få skatter, liv, tid eller avaktivera lasern men man riskerar även att öka hastighet på laser, förlora liv eller tid.

**Tester**

Här handlar det givetvis inte om att testa java-metoden Math.random() utan att de möjliga utfallen resulterar i vad som är tänkt.
...... osv

**Implementation**

Koden bygger på en slumpfunktion som sätter inputparametern till en switchsats vilket resulterar i ett av sex möjliga utfall.
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
## Warp-Zone

Fungerar som en portal, om spelkaraktären ställer sig på denna så sker en warp till en slumpmässigt vald golv-ruta.

**Tester**

Det enda testet som låg till grund för metoden som sköter warpen är ett test för att ta reda på att spelkaraktären är flyttad. Implementationen är så enkel och självklar (jämfört med att utforma ett test för att säkerhetsställa att karaktären flyttas till en golvyta i Arrayen). Därför valde vi att inte göra fler test.

**Implementation**

En While loop innehåller for-loopar som itererar igenom spelplanen och tar in slumpmässiga koordinater, när positionens värde är 0 (som motsvarar golv) så flyttas spelkaraktären till denna position. 

```

while(!CharacterMoved) 
	{
		int row = (int)(25.0*Math.random());
		int col = (int)(25.0*Math.random());
				
		for ( int q = 0; q < squares.length; q++ )
		          {
		              for ( int x = 0; x < squares[0].length; x++ )
		              {
		            	  if (getGridValueOfPosition(new Position(row, col))==0)
		            	  {
		            		  this.characterObject.setCurrentPosition(row, row); 
		            		  CharacterMoved = true;
		            	  } 
		              }   
		         }	
	}
	
```

## Monster

Monstret rör sig mot spelkaraktären över positioner på spelplanen som utgörs av golv och tar ett liv av spelkaraktären vid kollision. Monstret representeras av färgen gul och ritas upp genom att värdet 7 sätts i en array/bana i klassen Levels. 

**Tester**

Här har vi testat att monstret hela tiden rör sig mot spelkaraktären oavsett riktning och spelkaraktären dör när deras position är samma. Vi testar också att monstret och spelkaratären flyttas till sina startpositioner efter en kollison.

**Implementation**

Precis som vid implementationen av lasern bygger monstrets rörelse på att en metod i en egen tråd i Main-klassen och monstrets hastighet sätts på samma sätt. 

Riktningen styrs i metoden moveMonster(), där körs dubbla for-loopar som går igenom alla index i spelplanen och letar efter färgen ljusgrått som representerar ett monster. Sedan jämförs monstrets position med spelkaraktärens position i x och y-led.

Om monstrets position i x eller y-led är större än spelkaraktärens position så minskas monstrets position i relation till denna.

```

if (monster_x>char_x) 
           {
               movement_x= (monster_x)-1;
           }
	   
```
Monstret är tyvärr inte särskilt smart och står stilla om det inte hittar en yta med golv i optimal riktning. För att lösa detta hade vi behövt testa att monstret aldrig står stilla om det har möjlighet att röra sig och implementera detta i koden. 


## Svårigheter

Det var relativt enkelt att bygga spelplanen genom att "översätta" heltal till färger men inte lika lätt att skriva tester med färg som referens, det tog därför ett tag innan vi blev bekväma med det tankesättet. Ur testsynpunkt hade det varit mycket enklare att basera allt på den ursprungliga heltals-Arrayen men hade också sina fördelar. Exempelvis lasern gjordes rörlig genom att använda två olika heltal där ett sattes till att vara röd(laser) när den andra var vit (golv) och tvärt om. 

Vi fick också lägga lite tankeverksamhet på att hitta ett bra sätt att byta bana, dvs "översätta" nästa banas int-array till en färg-array på ett smidigt sätt. Vi kom fram till att det enklaste sättet var att inte rita ut en ny array utan istället byta färger på det spelbrädet vi redan hade och nollställa insamlade skatter på banan. 

En annan tanke vi hade som hade gjort koden mer lätthanterlig/överskådlig hade varit att skapa objekt av alla sprites och sätta egenskaper som färg och bild i respektive klasser. Vi testade detta efter att den grundläggande funktionaliteten var på plats genom att skapa instanser av sprites som ärvde av JButton och satte in dessa på spelplanen men tyvärr föll för mycket av vår befintliga funktionalitet. Till skillnad från en färg var de knutna till en specifik sprite vilket hade fler nackdelar än fördelar. 

## Slutligen

Det har varit en lärorik process att skapa spelet. Inte bara för det skapat en större förståelse för hur testdriven utveckling kan gå till utan också för att det ökat förståelse för hur 2-dimensionella spel kan byggas. 
Jag tror att vi alla gärna hade fortsatt med utvecklingen och byggt vidare på spelet. Det finns oändligt många utvecklingsmöjligheter med att lägga till olika features i spelet som vapen, fler monster osv, vilket hade varit kul. 

Vi har också märkt att GitHub tar mindre och mindre fokus vilket är ett tecken på att vi börjar bli bekväma med hur det fungerar. 






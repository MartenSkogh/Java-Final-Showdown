# Programmeringsteknik

Mårten Skogh 
Adam Tonderski
Grupp 121


1. Det som ställde till det mest för oss var hanterandet av undantag i 
parse(). Vi började med en ful men fungerande nestad try-catch-struktur
men när detta fungerade kände vi att koden var lite väl svåröverskådlig
så vi gjorde om utseendet på metoden och lade två try-catch efter 
varandra istället för nestade.					

2. Testprogrammet har ett antal hårdkodade fall och den jämför de korrekta 
lösningarna med resultaten från vår implementation av RatNum. Om något 
inte stämmer så skriver det ut vilket av fallen som misslyckades och 
avslutar sedan programmet. Det kollar även om vi kastar rätt typ av 
exception. Här är resultatet av vår körning:
>Inga fel!


3. RatNumTest3 testar de olika funktioner som utgör den tredje delen av 
laborationen. Den testar likheter mellan rationella tal och matematiska 
operationer. Den testar även exception hantering geonom att endast fånga 
sprcifika typer av exceptions. RatNum3 utnyttjar två olika testmetoder: 
en manuell där en användare manuellt kan slå in två rationella tal och en 
operation, samt en metod som utnyttjar en färdig fil med olika input som 
ska testas. RatNum3 inleder även med att testa några likheter och flyttals
omvandling samt att köra en testmetod från RatNum2.




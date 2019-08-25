# DependencyInjection workshop

## Hva er det?
Dependency Injection (DI) er en variant av [Inversion of Control](https://en.wikipedia.org/wiki/Inversion_of_control) prinsippet, hvor ulike ansvarsområder blir flyttet på for å gjøre det lettere å skalere kodebasen.

I en typisk java-applikasjon starter alt i main-metoden, og objekt-grafen bygges gradvis utover etterhvert som man oppretter nye objekter.
F.eks `new Controller(new Service(new DAO()))`. 
Sånn kodensnutten ovenfor ser ut må alle som vil ha en ny `Controller` forholde seg til en `Service` og en `DAO`.  
Disse må trossalt instansieres og sendes inn som parametere. 

I en DI/IoC verden fjerner man behovet for å forholde seg til `Service` og `DAO` objektene ved å flytte ansvaret for å finne disse inn i `Controller`. 

## Hvordan gjør vi det?

Vi skal lage noe ligner på [Spring](https://spring.io/), men kommer til å gjøre noen forenklinger underveis. 
Hovedfasene i vårt DI-bibliotek kommer til å bestå av tre faser;
1. Finn alle objekter av interesse
2. Instansier alle objektene
3. Wire-up

### Del 1: Basics 
[Spring](https://spring.io/) kan konfigureres opp på mange ulike måter.
Tidligere var det XML som ble brukt, men i nyere tid har de fleste gått over til å konfigurere opp spring i java-koden sin (`@Bean`, `@Inject`, `@Autowired` etc).
Men selv her her er det flere muligheter, e.g classpath-scanning eller vha konfigurasjons-filer ([Eksempel](https://github.com/nutgaard/springboot-jersey-boilerplate/blob/master/src/main/java/no/utgdev/ssrr/config/AppConfig.java)). 

For å undersøke classpath-scanning kommer vi til å ta ibruk ett veldig fint lite java-bibliotek: [reflections](https://github.com/ronmamo/reflections),
men det først vi må gjøre er å lage noen java-annotasjoner som vi kan lete etter etterpå.

##### Oppgave 1.1 Opprett `Bean` annotasjonen i `src/.../annotations/`, f.eks
```java
@Retention(value = RUNTIME)
@Target(value = {ElementType.METHOD})
public @interface Bean {
}
```
`Retention` og `@Target` er meta-annotasjoner som forklarer java-kompileren hvordan `@Bean` annotasjonen kan brukes.
`Retention` kan være en av tre verdier; `CLASS`, `RUNTIME` og `SOURCE`. Og sier noe om når informasjon om annotasjon skal være tilgjengelig.
`Target` kan ha mange forskjellige verdier, e.g `FIELD`, `PARAMETER` etc. Og sier noe om hvor annotasjonen kan brukes.

I eksemplet ovenfor bruker vi `@Retention(value = RUNTIME)` slik at informasjonen om `Bean` er tilgjengelig runtime.
Og vi bruker `@Target(value = {ElementType.METHOD})` for å indikere at det kun er lov å bruke annotasjonen på java-metoder.

##### Oppgave 1.2.1 Implementer `DIYStatic.scan(String classpath)` slik at i `Ex1Test.finnAlleBeans` kjører.
[reflections](https://github.com/ronmamo/reflections) biblioteket er bygd opp rundt konseptet "scanner". 
Det biblioteket gjør er å titte gjennom hele classpathen, og basert på hvilke "scanners" som er satt opp lagres ulik informasjon om klassene som finnes. 
Vi bryr for nå bare om annotasjoner på metoder, så det holder å bruke `MethodAnnotationsScanner`.

[Baeldung](https://www.baeldung.com/reflections-library) har en fin gjennomgang av hvordan man bruke biblioteket. Spesielt punkt 4.3 kan være nyttig. ;) 

##### Oppgave 1.2.2 Implementer `DIYStatic.scan(Class root)` slik at i `Ex1Test.finnAlleBeansFraRoot` kjører.

#### Konfigurasjons-filer:

Eksempel på konfigurasjons-filer:
```java
// no.utgdev.diy.Application.java
class Application {
    public static void main(String[] args){
        DIY.load(ApplicationConfig.class);
    }
}

// no.utgdev.diy.ApplicationConfig.java
@Import(values = { DAOConfig.class })
class ApplicationConfig {
    @Bean
    public Service service() {
        return new Service();
    }
}

// no.utgdev.diy.DAOConfig.java
class DAOConfig {
    @Bean
    public DAO dao() {
        return new DAO();
    }
}
```

##### Oppgave 1.3 Implementere `DIYStatic.instansiate(Set<Method> methods)` slik at `Ex2Test.instansiate` kjører


##### Oppgave 1.4 Implementere `DIYStatic.wireup(Map<String, Object> namedObjects)`
Ingen test for denne. :O Men man kan alltid bruke debuggeren til å titte litt på objektene man får tilbake etter `DIYStatic.wireup`.

##### Oppgave 1.5 Implementere `DIYStatic.getBean(Map<String, Object> objects, String name)` slik at `Ex3Test.wireup` kjører


### Del 2: Pakk det sammen
 
##### Oppgave 2.1 Implementer `DIY.load(String classPath)`
##### Oppgave 2.2 Implementer `DIY.load(Class root)`
##### Oppgave 2.3 Implementer `DIY.getBean(String name)`

Etter **Oppgave 2.3** burde `Ex4Test.run` kjøre. ;) 

### Del 3: Features

##### Oppgave 3.1 Opprett `@Named`, og respekter bønner med denne annotasjonen

Noen ganger kan det være greit å ha greit å ha flere bønner av samme, men man trenger da en måte å skille de på.
Dette håndteres via å gi alle bønner ett navn ([BeanNameGenerator](https://docs.spring.io/spring-framework/docs/5.1.9.RELEASE/javadoc-api/org/springframework/beans/factory/support/BeanNameGenerator.html)),
men for å slippe å holde styr på hvilken navn Spring velger å gi til bønnen vår så kan vi velge å gi den ett spesifikt navn selv.

I Spring brukes gjerne `@Qualifier` eller `@Named` for dette. 

```java
@Inject
@Named("minBønne")
Service service;

@Bean(name = "minBønne")
public Service enEllerAnnenService() {}
```

Hadde vi i eksemplet ovenfor ikke gitt `Service`-bønnen ett eksplisitt navn ville den brukt [metode-navnet](https://docs.spring.io/spring-javaconfig/docs/1.0-m2/reference/html/naming-strategy.html) `enEllerAnnenService` som navnet.

La oss se om vi kan få `Ex5Test.run` til å kjøre.


##### Oppgave 3.2 Opprett `@Component` og `@Service` annotasjonen i `src/.../annotations/`

Spring kommer med ett sett av [stereotype-annotasjoner](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-stereotype-annotations),
disse kan brukes for å annotere klasser slik at de blir automatisk plukket opp ved classpath-scanning, 
uten behovet for å skrive egne `@Bean`-metoder.

Alle steretype-annotasjonene er en spesialisering av `@Component`, men man ønsker ofte å skille mellom de når man skal begynne med [aspect-oriented-programming](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#aop).

Fiks `DIY.load(String classPath)` slik at den også laster inn klasser med steretype-annotasjoner, og etter det burde `Ex6Test.run` kunne fungere.

##### Oppgave 3.3 Opprett `@PostConstruct` i `src/.../annotations/`

Siden vi bare har implementer field-injection så vil ikke bønnene være klare når en evt konstruktør kjører.
Men i blandt vil vi fortsatt gjøre ting når en klasse blir instansiert.

`@PostConstruct` lar oss annotere en metode som vi vil at biblioteket skal kjøre etter instansiering og alle bønnene vi trenger har blitt injected.

Sjekk at `Ex7Test.run` kjører. 



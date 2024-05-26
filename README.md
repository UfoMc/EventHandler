<img src="eventhandler.png" width="2048" hight="400"/>

About
-

With the following repo its possible to create your own events and acess those easily.
It was codet by My (ufomc) for the organization NexChat (dm me on discord for more info. [ufo.dev])

Usage
-
 1. implement the classes into your project
 2. create your self a class for your events (as showen down below)
 3. create your event inside that class

```java
public class TestEvent extends EventManager {

    @EventHandler
    public void handle(TEvent event) {
        event.helloWorld();
    }

}
```

 4. trigger that event when ever you want

```java
EventRegistry.triggerEvent(new TEvent());
```

What is NexChat?
-

NexChat the chat system I found with `https://github.com/Ananmay125`.
We are still searching for disigners developers and supporters.
Please dm me (ufo.dev) on discord for more information

CopyRight
-

This project is owned by ufomc.
If want you use it for your project you can do that but
1. its forbidden to tell its yours.
2. its forbidden to sell it.
3. you may use it but if you make money with it please give us a credit.

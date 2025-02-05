### Pregunta 1
en el moment que els fils intenten fer una reserva pero no queden més reserves disponibles es queden en wait() i ja no poden fer el notifyall() perque surtin del wait().
### Pregunta 2
En la opció de 70 reserves 30 cancel·lar el que pasa es que trigara menys en parar perque es més facil quedarse sense reserves. En el cas 30 reserves 70 cancel·lar trigarà més en aturarse ja que es molt més facil que es cancel·lin resrves.

30 reservar 70 cancel·lar:
~~~~
@Override
    public void run() {
        while (true) {
            try {
                int accio = rnd.nextInt(10);

                synchronized (esdeveniment) {
                    if (accio >= 0 && accio <= 2) {
                        if(esdeveniment.ferReserva(this)){
                            esdeveniment.notifyAll();
                        }else{
                            esdeveniment.wait();
                        }
                         
                    } else {
                        if(esdeveniment.cancelaReserva(this)){
                            esdeveniment.notifyAll();
                        }else{
                            esdeveniment.wait();
                        }
                         
                    }
                }

                Thread.sleep(rnd.nextInt(1000));

            } catch (InterruptedException e) {
                System.out.println(nom + " ha sigut interrumput.");
                break;
            }
        }
    }
~~~~
5cM09UF02_23e4b91f\x5cbin' 'Organitzador' ;0f28dff3-5358-4ab0-afb5-eb0d05266dc7Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent 9 ha fet una reserva. Places disponibles: 4
Assistent 8 ha fet una reserva. Places disponibles: 3
Assistent 7 ha fet una reserva. Places disponibles: 2
Assistent 6 ha fet una reserva. Places disponibles: 1
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 2 ha fet una reserva. Places disponibles: 0
Assistent 1 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 6 ha cancel·lat una reserva. Places disponibles: 1
Assistent 6 ha fet una reserva. Places disponibles: 0
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 3 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 0 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 8 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 6 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 2 ha cancel·lat una reserva. Places disponibles: 1
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 9 ha cancel·lat una reserva. Places disponibles: 2
Assistent 7 ha cancel·lat una reserva. Places disponibles: 3
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 6 ha cancel·lat una reserva. Places disponibles: 4
Assistent 4 ha fet una reserva. Places disponibles: 3
Assistent 0 ha fet una reserva. Places disponibles: 2
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 4 ha cancel·lat una reserva. Places disponibles: 3
Assistent 8 ha cancel·lat una reserva. Places disponibles: 4
Assistent 2 ha fet una reserva. Places disponibles: 3
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 7 ha fet una reserva. Places disponibles: 2
Assistent 9 ha fet una reserva. Places disponibles: 1
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 0 ha cancel·lat una reserva. Places disponibles: 2
Assistent 6 ha fet una reserva. Places disponibles: 1
Assistent 5 ha fet una reserva. Places disponibles: 0
Assistent 9 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 5 ha cancel·lat una reserva. Places disponibles: 1
Assistent 9 ha fet una reserva. Places disponibles: 0
Assistent 1 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 0 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 3 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 7 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 9 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 2 ha cancel·lat una reserva. Places disponibles: 1
Assistent 3 ha fet una reserva. Places disponibles: 0
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 9 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 1 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 5 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 2 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 6 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 7 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 3 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 4 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 0 no ha pogut fer una reserva perque no queden places. Places disponibles:0
PS C:\Users\Alex\Desktop\2n Any cicle\M09\M09-UF2\M09UF02>  c:; cd 'c:\Users\Alex\Desktop\2n Any cicle\M09\M09-UF2\M09UF02'; & 'C:\Program Files\Microsoft\jdk-21.0.4.7-hotspot\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\Alex\AppData\Roaming\Code\User\workspaceStorage\ad7115494f77c505ac9e665783e96e3d\redhat.java\jdt_ws\M09UF02_23e4b91f\bin' 'Organitzador' 
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent 9 ha fet una reserva. Places disponibles: 4
Assistent 6 ha fet una reserva. Places disponibles: 3
Assistent 7 ha fet una reserva. Places disponibles: 2
Assistent 1 ha fet una reserva. Places disponibles: 1
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 4 ha fet una reserva. Places disponibles: 0
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 6 ha cancel·lat una reserva. Places disponibles: 1
Assistent 9 ha cancel·lat una reserva. Places disponibles: 2
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 8 ha fet una reserva. Places disponibles: 1
Assistent 8 ha fet una reserva. Places disponibles: 0
Assistent 7 ha cancel·lat una reserva. Places disponibles: 1
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 3 ha fet una reserva. Places disponibles: 0
Assistent 8 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 4 ha cancel·lat una reserva. Places disponibles: 1
Assistent 1 ha cancel·lat una reserva. Places disponibles: 2
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 3 ha cancel·lat una reserva. Places disponibles: 3
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 8 ha cancel·lat una reserva. Places disponibles: 4
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 0 ha fet una reserva. Places disponibles: 3
Assistent 5 ha fet una reserva. Places disponibles: 2
Assistent 4 ha fet una reserva. Places disponibles: 1
Assistent 6 ha fet una reserva. Places disponibles: 0
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 6 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 2 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 5 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 8 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 9 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 4 ha cancel·lat una reserva. Places disponibles: 1
Assistent 0 ha cancel·lat una reserva. Places disponibles: 2
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 8 ha cancel·lat una reserva. Places disponibles: 3
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 3 ha fet una reserva. Places disponibles: 2
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 4 ha fet una reserva. Places disponibles: 1
Assistent 5 ha fet una reserva. Places disponibles: 0
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 6 ha cancel·lat una reserva. Places disponibles: 1
Assistent 3 ha cancel·lat una reserva. Places disponibles: 2
Assistent 2 ha fet una reserva. Places disponibles: 1
Assistent 0 ha fet una reserva. Places disponibles: 0
Assistent 4 ha cancel·lat una reserva. Places disponibles: 1
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 8 ha fet una reserva. Places disponibles: 0
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 5 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 2 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 8 ha cancel·lat una reserva. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 0 ha cancel·lat una reserva. Places disponibles: 2
Assistent 2 ha fet una reserva. Places disponibles: 1
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 2 ha cancel·lat una reserva. Places disponibles: 2
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 2 ha fet una reserva. Places disponibles: 1
Assistent 5 ha cancel·lat una reserva. Places disponibles: 2
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 6 ha fet una reserva. Places disponibles: 1
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 6 ha cancel·lat una reserva. Places disponibles: 2
Assistent 6 ha fet una reserva. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 2 ha cancel·lat una reserva. Places disponibles: 2
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 8 ha fet una reserva. Places disponibles: 1
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 1 ha fet una reserva. Places disponibles: 0
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 6 ha cancel·lat una reserva. Places disponibles: 1
Assistent 8 ha fet una reserva. Places disponibles: 0
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 5 ha cancel·lat una reserva. Places disponibles: 1
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 4 ha fet una reserva. Places disponibles: 0
Assistent 1 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 2 ha cancel·lat una reserva. Places disponibles: 1
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 4 ha cancel·lat una reserva. Places disponibles: 2
Assistent 3 ha fet una reserva. Places disponibles: 1
Assistent 3 ha cancel·lat una reserva. Places disponibles: 2
Assistent 1 ha cancel·lat una reserva. Places disponibles: 3
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 2 ha fet una reserva. Places disponibles: 2
Assistent 4 ha fet una reserva. Places disponibles: 1
Assistent 8 ha cancel·lat una reserva. Places disponibles: 2
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 3 ha fet una reserva. Places disponibles: 1
Assistent 1 ha fet una reserva. Places disponibles: 0
Assistent 4 ha cancel·lat una reserva. Places disponibles: 1
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 8 ha cancel·lat una reserva. Places disponibles: 2
Assistent 5 ha fet una reserva. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 1 ha fet una reserva. Places disponibles: 0
Assistent 0 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 5 ha cancel·lat una reserva. Places disponibles: 1
Assistent 6 ha fet una reserva. Places disponibles: 0
Assistent 2 ha cancel·lat una reserva. Places disponibles: 1
Assistent 3 ha fet una reserva. Places disponibles: 0
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 1 ha cancel·lat una reserva. Places disponibles: 1
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 3 ha cancel·lat una reserva. Places disponibles: 2
Assistent 6 ha cancel·lat una reserva. Places disponibles: 3
Assistent 5 ha fet una reserva. Places disponibles: 2
Assistent 5 ha cancel·lat una reserva. Places disponibles: 3
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 3 ha cancel·lat una reserva. Places disponibles: 4
Assistent 4 ha fet una reserva. Places disponibles: 3
Assistent 3 ha fet una reserva. Places disponibles: 2
Assistent 1 ha cancel·lat una reserva. Places disponibles: 3
Assistent 6 ha fet una reserva. Places disponibles: 2
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 4 ha fet una reserva. Places disponibles: 1
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 8 ha fet una reserva. Places disponibles: 0
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 3 ha cancel·lat una reserva. Places disponibles: 1
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 6 ha cancel·lat una reserva. Places disponibles: 2
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 4 ha cancel·lat una reserva. Places disponibles: 3
Assistent 8 ha cancel·lat una reserva. Places disponibles: 4
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 3 ha fet una reserva. Places disponibles: 3
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 9 ha fet una reserva. Places disponibles: 2
Assistent 3 ha fet una reserva. Places disponibles: 1
Assistent 3 ha cancel·lat una reserva. Places disponibles: 2
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 4 ha cancel·lat una reserva. Places disponibles: 3
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 2 ha fet una reserva. Places disponibles: 2
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 9 ha cancel·lat una reserva. Places disponibles: 3
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 9 ha fet una reserva. Places disponibles: 2
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 6 ha fet una reserva. Places disponibles: 1
Assistent 3 ha cancel·lat una reserva. Places disponibles: 2
Assistent 1 ha fet una reserva. Places disponibles: 1
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 4 ha fet una reserva. Places disponibles: 0
Assistent 1 ha cancel·lat una reserva. Places disponibles: 1
Assistent 5 ha fet una reserva. Places disponibles: 0
Assistent 5 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 2 ha cancel·lat una reserva. Places disponibles: 1
Assistent 5 ha cancel·lat una reserva. Places disponibles: 2
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 4 ha cancel·lat una reserva. Places disponibles: 3
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 4 ha fet una reserva. Places disponibles: 2
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 9 ha cancel·lat una reserva. Places disponibles: 3
Assistent 6 ha cancel·lat una reserva. Places disponibles: 4
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 7 ha fet una reserva. Places disponibles: 3
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 7 ha cancel·lat una reserva. Places disponibles: 4
Assistent 3 ha fet una reserva. Places disponibles: 3
Assistent 1 ha fet una reserva. Places disponibles: 2
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 4 ha cancel·lat una reserva. Places disponibles: 3
Assistent 8 ha fet una reserva. Places disponibles: 2
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 8 ha cancel·lat una reserva. Places disponibles: 3
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 3 ha cancel·lat una reserva. Places disponibles: 4
Assistent 1 ha cancel·lat una reserva. Places disponibles: 5
Assistent 6 ha fet una reserva. Places disponibles: 4
Assistent 7 ha fet una reserva. Places disponibles: 3
Assistent 7 ha cancel·lat una reserva. Places disponibles: 4
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 6 ha cancel·lat una reserva. Places disponibles: 5
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent 4 ha fet una reserva. Places disponibles: 4
Assistent 8 ha fet una reserva. Places disponibles: 3
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 4 ha cancel·lat una reserva. Places disponibles: 4
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 8 ha cancel·lat una reserva. Places disponibles: 5
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent 7 ha fet una reserva. Places disponibles: 4
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 6 ha fet una reserva. Places disponibles: 3
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 5 ha fet una reserva. Places disponibles: 2
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 7 ha cancel·lat una reserva. Places disponibles: 3
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 6 ha fet una reserva. Places disponibles: 2
Assistent 8 ha fet una reserva. Places disponibles: 1
Assistent 4 ha fet una reserva. Places disponibles: 0
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 5 ha cancel·lat una reserva. Places disponibles: 1
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 4 ha fet una reserva. Places disponibles: 0
Assistent 7 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 6 ha cancel·lat una reserva. Places disponibles: 1
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 8 ha cancel·lat una reserva. Places disponibles: 2
Assistent 6 ha cancel·lat una reserva. Places disponibles: 3
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 4 ha fet una reserva. Places disponibles: 2
Assistent 5 ha fet una reserva. Places disponibles: 1
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 4 ha cancel·lat una reserva. Places disponibles: 2
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 7 ha fet una reserva. Places disponibles: 1
Assistent 5 ha cancel·lat una reserva. Places disponibles: 2
Assistent 9 ha fet una reserva. Places disponibles: 1
Assistent 8 ha fet una reserva. Places disponibles: 0
Assistent 8 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 9 ha cancel·lat una reserva. Places disponibles: 1
Assistent 1 ha fet una reserva. Places disponibles: 0
Assistent 6 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 4 ha cancel·lat una reserva. Places disponibles: 1
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 7 ha cancel·lat una reserva. Places disponibles: 2
Assistent 0 ha fet una reserva. Places disponibles: 1
Assistent 4 ha cancel·lat una reserva. Places disponibles: 2
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 0 ha fet una reserva. Places disponibles: 1
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 8 ha fet una reserva. Places disponibles: 0
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 8 ha cancel·lat una reserva. Places disponibles: 1
Assistent 1 ha cancel·lat una reserva. Places disponibles: 2
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 2 ha fet una reserva. Places disponibles: 1
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 0 ha fet una reserva. Places disponibles: 0
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 2 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 8 ha cancel·lat una reserva. Places disponibles: 1
Assistent 6 ha fet una reserva. Places disponibles: 0
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 3 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 6 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 5 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 0 ha cancel·lat una reserva. Places disponibles: 1
Assistent 7 ha fet una reserva. Places disponibles: 0
Assistent 0 ha cancel·lat una reserva. Places disponibles: 1
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 7 ha fet una reserva. Places disponibles: 0
Assistent 2 ha cancel·lat una reserva. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 0 ha cancel·lat una reserva. Places disponibles: 2
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 6 ha cancel·lat una reserva. Places disponibles: 3
Assistent 7 ha fet una reserva. Places disponibles: 2
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 7 ha cancel·lat una reserva. Places disponibles: 3
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 7 ha fet una reserva. Places disponibles: 2
Assistent 6 ha fet una reserva. Places disponibles: 1
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 4 ha fet una reserva. Places disponibles: 0
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 3 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 6 ha cancel·lat una reserva. Places disponibles: 1
Assistent 7 ha cancel·lat una reserva. Places disponibles: 2
Assistent 4 ha cancel·lat una reserva. Places disponibles: 3
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 7 ha fet una reserva. Places disponibles: 2
Assistent 7 ha fet una reserva. Places disponibles: 1
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 7 ha cancel·lat una reserva. Places disponibles: 2
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 9 ha fet una reserva. Places disponibles: 1
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 1 ha fet una reserva. Places disponibles: 0
Assistent 8 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 7 ha cancel·lat una reserva. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 9 ha cancel·lat una reserva. Places disponibles: 2
Assistent 4 ha fet una reserva. Places disponibles: 1
Assistent 3 ha fet una reserva. Places disponibles: 0
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 9 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 7 ha cancel·lat una reserva. Places disponibles: 1
Assistent 1 ha cancel·lat una reserva. Places disponibles: 2
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 2 ha fet una reserva. Places disponibles: 1
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 2 ha fet una reserva. Places disponibles: 0
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 7 ha cancel·lat una reserva. Places disponibles: 1
Assistent 4 ha cancel·lat una reserva. Places disponibles: 2
Assistent 3 ha cancel·lat una reserva. Places disponibles: 3
Assistent 1 ha fet una reserva. Places disponibles: 2
Assistent 0 ha fet una reserva. Places disponibles: 1
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 3 ha fet una reserva. Places disponibles: 0
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 2 ha cancel·lat una reserva. Places disponibles: 1
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 4 ha fet una reserva. Places disponibles: 0
Assistent 0 ha cancel·lat una reserva. Places disponibles: 1
Assistent 8 ha fet una reserva. Places disponibles: 0
Assistent 1 ha cancel·lat una reserva. Places disponibles: 1
Assistent 3 ha cancel·lat una reserva. Places disponibles: 2
Assistent 2 ha cancel·lat una reserva. Places disponibles: 3
Assistent 8 ha cancel·lat una reserva. Places disponibles: 4
Assistent 7 ha fet una reserva. Places disponibles: 3
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 8 ha fet una reserva. Places disponibles: 2
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 7 ha fet una reserva. Places disponibles: 1
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 4 ha fet una reserva. Places disponibles: 0
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 4 ha cancel·lat una reserva. Places disponibles: 1
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 9 ha fet una reserva. Places disponibles: 0
Assistent 3 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 5 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 8 ha cancel·lat una reserva. Places disponibles: 1
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 7 ha cancel·lat una reserva. Places disponibles: 2
Assistent 4 ha cancel·lat una reserva. Places disponibles: 3
Assistent 9 ha cancel·lat una reserva. Places disponibles: 4
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 7 ha cancel·lat una reserva. Places disponibles: 5
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent 4 ha fet una reserva. Places disponibles: 4
Assistent 1 ha fet una reserva. Places disponibles: 3
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 1 ha cancel·lat una reserva. Places disponibles: 4
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 4 ha fet una reserva. Places disponibles: 3
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 4 ha cancel·lat una reserva. Places disponibles: 4
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 1 ha fet una reserva. Places disponibles: 3
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 5 ha fet una reserva. Places disponibles: 2
Assistent 7 ha fet una reserva. Places disponibles: 1
Assistent 3 ha fet una reserva. Places disponibles: 0
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 4 ha cancel·lat una reserva. Places disponibles: 1
Assistent 6 ha fet una reserva. Places disponibles: 0
Assistent 5 ha cancel·lat una reserva. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 3 ha cancel·lat una reserva. Places disponibles: 2
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 6 ha cancel·lat una reserva. Places disponibles: 3
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 7 ha cancel·lat una reserva. Places disponibles: 4
Assistent 4 ha fet una reserva. Places disponibles: 3
Assistent 7 ha fet una reserva. Places disponibles: 2
Assistent 1 ha fet una reserva. Places disponibles: 1
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 2 ha fet una reserva. Places disponibles: 0
Assistent 3 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 4 ha cancel·lat una reserva. Places disponibles: 1
Assistent 2 ha cancel·lat una reserva. Places disponibles: 2
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 7 ha fet una reserva. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 3 ha fet una reserva. Places disponibles: 0
Assistent 1 ha cancel·lat una reserva. Places disponibles: 1
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 1 ha cancel·lat una reserva. Places disponibles: 2
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 8 ha fet una reserva. Places disponibles: 1
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 9 ha fet una reserva. Places disponibles: 0
Assistent 3 ha cancel·lat una reserva. Places disponibles: 1
Assistent 9 ha cancel·lat una reserva. Places disponibles: 2
Assistent 2 ha fet una reserva. Places disponibles: 1
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 7 ha cancel·lat una reserva. Places disponibles: 2
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 7 ha cancel·lat una reserva. Places disponibles: 3
Assistent 8 ha cancel·lat una reserva. Places disponibles: 4
Assistent 9 ha fet una reserva. Places disponibles: 3
Assistent 6 ha fet una reserva. Places disponibles: 2
Assistent 0 ha fet una reserva. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 6 ha cancel·lat una reserva. Places disponibles: 2
Assistent 9 ha cancel·lat una reserva. Places disponibles: 3
Assistent 2 ha cancel·lat una reserva. Places disponibles: 4
Assistent 5 ha fet una reserva. Places disponibles: 3
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 5 ha fet una reserva. Places disponibles: 2
Assistent 5 ha fet una reserva. Places disponibles: 1
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 8 ha fet una reserva. Places disponibles: 0
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 1 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 0 ha cancel·lat una reserva. Places disponibles: 1
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 1 ha fet una reserva. Places disponibles: 0
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 5 ha cancel·lat una reserva. Places disponibles: 1
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 8 ha fet una reserva. Places disponibles: 0
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 7 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 8 ha cancel·lat una reserva. Places disponibles: 1
Assistent 1 ha cancel·lat una reserva. Places disponibles: 2
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 5 ha fet una reserva. Places disponibles: 1
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 8 ha fet una reserva. Places disponibles: 0
Assistent 3 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 5 ha cancel·lat una reserva. Places disponibles: 1
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 5 ha fet una reserva. Places disponibles: 0
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 5 ha cancel·lat una reserva. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 9 ha fet una reserva. Places disponibles: 0
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 8 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 9 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 0 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 2 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 5 ha cancel·lat una reserva. Places disponibles: 1
Assistent 8 ha fet una reserva. Places disponibles: 0
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 1 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 8 ha cancel·lat una reserva. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 1 ha fet una reserva. Places disponibles: 0
Assistent 1 ha cancel·lat una reserva. Places disponibles: 1
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 8 ha cancel·lat una reserva. Places disponibles: 2
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 9 ha fet una reserva. Places disponibles: 1
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 5 ha cancel·lat una reserva. Places disponibles: 2
Assistent 8 ha cancel·lat una reserva. Places disponibles: 3
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 2 ha fet una reserva. Places disponibles: 2
Assistent 8 ha fet una reserva. Places disponibles: 1
Assistent 8 ha cancel·lat una reserva. Places disponibles: 2
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 4 ha fet una reserva. Places disponibles: 1
Assistent 6 ha fet una reserva. Places disponibles: 0
Assistent 2 ha cancel·lat una reserva. Places disponibles: 1
Assistent 6 ha cancel·lat una reserva. Places disponibles: 2
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 9 ha cancel·lat una reserva. Places disponibles: 3
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 4 ha cancel·lat una reserva. Places disponibles: 4
Assistent 7 ha fet una reserva. Places disponibles: 3
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 7 ha cancel·lat una reserva. Places disponibles: 4
Assistent 8 ha fet una reserva. Places disponibles: 3
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 4 ha fet una reserva. Places disponibles: 2
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 9 ha cancel·lat una reserva. Places disponibles: 3
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 8 ha cancel·lat una reserva. Places disponibles: 4
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 0 ha fet una reserva. Places disponibles: 3
Assistent 3 ha fet una reserva. Places disponibles: 2
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 4 ha cancel·lat una reserva. Places disponibles: 3
Assistent 3 ha cancel·lat una reserva. Places disponibles: 4
Assistent 9 ha fet una reserva. Places disponibles: 3
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 9 ha cancel·lat una reserva. Places disponibles: 4
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 1 ha fet una reserva. Places disponibles: 3
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 0 ha cancel·lat una reserva. Places disponibles: 4
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 1 ha cancel·lat una reserva. Places disponibles: 5
Assistent 3 ha fet una reserva. Places disponibles: 4
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 3 ha cancel·lat una reserva. Places disponibles: 5
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent 1 ha fet una reserva. Places disponibles: 4
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 5 ha fet una reserva. Places disponibles: 3
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 6 ha fet una reserva. Places disponibles: 2
Assistent 9 ha fet una reserva. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 9 ha cancel·lat una reserva. Places disponibles: 2
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 5 ha cancel·lat una reserva. Places disponibles: 3
Assistent 1 ha cancel·lat una reserva. Places disponibles: 4
Assistent 1 ha fet una reserva. Places disponibles: 3
Assistent 2 ha fet una reserva. Places disponibles: 2
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 1 ha fet una reserva. Places disponibles: 1
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 6 ha cancel·lat una reserva. Places disponibles: 2
Assistent 7 ha fet una reserva. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 2 ha cancel·lat una reserva. Places disponibles: 2
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 1 ha cancel·lat una reserva. Places disponibles: 3
Assistent 6 ha fet una reserva. Places disponibles: 2
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 7 ha fet una reserva. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 8 ha fet una reserva. Places disponibles: 0
Assistent 7 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 1 ha cancel·lat una reserva. Places disponibles: 1
Assistent 5 ha fet una reserva. Places disponibles: 0
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 2 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 8 ha cancel·lat una reserva. Places disponibles: 1
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 6 ha cancel·lat una reserva. Places disponibles: 2
Assistent 6 ha fet una reserva. Places disponibles: 1
Assistent 7 ha cancel·lat una reserva. Places disponibles: 2
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 5 ha fet una reserva. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 6 ha cancel·lat una reserva. Places disponibles: 2
Assistent 2 ha fet una reserva. Places disponibles: 1
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 1 ha fet una reserva. Places disponibles: 0
Assistent 5 ha cancel·lat una reserva. Places disponibles: 1
Assistent 6 ha fet una reserva. Places disponibles: 0
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 7 ha cancel·lat una reserva. Places disponibles: 1
Assistent 2 ha cancel·lat una reserva. Places disponibles: 2
Assistent 2 ha fet una reserva. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 1 ha fet una reserva. Places disponibles: 0
Assistent 0 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 6 ha cancel·lat una reserva. Places disponibles: 1
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 5 ha cancel·lat una reserva. Places disponibles: 2
Assistent 8 ha fet una reserva. Places disponibles: 1
Assistent 1 ha cancel·lat una reserva. Places disponibles: 2
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 2 ha cancel·lat una reserva. Places disponibles: 3
Assistent 7 ha fet una reserva. Places disponibles: 2
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 2 ha fet una reserva. Places disponibles: 1
Assistent 8 ha cancel·lat una reserva. Places disponibles: 2
Assistent 7 ha cancel·lat una reserva. Places disponibles: 3
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 6 ha fet una reserva. Places disponibles: 2
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 2 ha fet una reserva. Places disponibles: 1
Assistent 2 ha fet una reserva. Places disponibles: 0
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 1 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 6 ha cancel·lat una reserva. Places disponibles: 1
Assistent 1 ha fet una reserva. Places disponibles: 0
Assistent 2 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 1 ha cancel·lat una reserva. Places disponibles: 1
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 4 ha fet una reserva. Places disponibles: 0
Assistent 4 ha cancel·lat una reserva. Places disponibles: 1
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 9 ha fet una reserva. Places disponibles: 0
Assistent 9 ha cancel·lat una reserva. Places disponibles: 1
Assistent 7 ha fet una reserva. Places disponibles: 0
Assistent 2 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 7 ha cancel·lat una reserva. Places disponibles: 1
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 1 ha cancel·lat una reserva. Places disponibles: 2
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 8 ha fet una reserva. Places disponibles: 1
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 8 ha fet una reserva. Places disponibles: 0
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 9 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 2 ha cancel·lat una reserva. Places disponibles: 1
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 5 ha fet una reserva. Places disponibles: 0
Assistent 0 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 8 ha cancel·lat una reserva. Places disponibles: 1
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 2 ha cancel·lat una reserva. Places disponibles: 2
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 3 ha fet una reserva. Places disponibles: 1
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 3 ha fet una reserva. Places disponibles: 0
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 5 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 6 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 3 ha cancel·lat una reserva. Places disponibles: 1
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 8 ha cancel·lat una reserva. Places disponibles: 2
Assistent 5 ha cancel·lat una reserva. Places disponibles: 3
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 2 ha fet una reserva. Places disponibles: 2
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 8 ha fet una reserva. Places disponibles: 1
Assistent 3 ha cancel·lat una reserva. Places disponibles: 2
Assistent 6 ha fet una reserva. Places disponibles: 1
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 1 ha fet una reserva. Places disponibles: 0
Assistent 8 ha cancel·lat una reserva. Places disponibles: 1
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 3 ha fet una reserva. Places disponibles: 0
Assistent 2 ha cancel·lat una reserva. Places disponibles: 1
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 3 ha cancel·lat una reserva. Places disponibles: 2
Assistent 7 ha fet una reserva. Places disponibles: 1
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 6 ha cancel·lat una reserva. Places disponibles: 2
Assistent 0 ha fet una reserva. Places disponibles: 1
Assistent 6 ha fet una reserva. Places disponibles: 0
Assistent 6 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 1 ha cancel·lat una reserva. Places disponibles: 1
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 7 ha cancel·lat una reserva. Places disponibles: 2
Assistent 3 ha fet una reserva. Places disponibles: 1
Assistent 4 ha fet una reserva. Places disponibles: 0
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 2 ha cancel·lat una reserva. Places disponibles: 1
Assistent 9 ha fet una reserva. Places disponibles: 0
Assistent 6 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 3 ha cancel·lat una reserva. Places disponibles: 1
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 3 ha fet una reserva. Places disponibles: 0
Assistent 0 ha cancel·lat una reserva. Places disponibles: 1
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 9 ha cancel·lat una reserva. Places disponibles: 2
Assistent 3 ha cancel·lat una reserva. Places disponibles: 3
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 6 ha fet una reserva. Places disponibles: 2
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 4 ha fet una reserva. Places disponibles: 1
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 6 ha fet una reserva. Places disponibles: 0
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 7 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 2 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 4 ha cancel·lat una reserva. Places disponibles: 1
Assistent 5 ha fet una reserva. Places disponibles: 0
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 0 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 6 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 8 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 2 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 4 ha cancel·lat una reserva. Places disponibles: 1
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 1 ha fet una reserva. Places disponibles: 0
Assistent 5 ha cancel·lat una reserva. Places disponibles: 1
Assistent 1 ha cancel·lat una reserva. Places disponibles: 2
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 6 ha fet una reserva. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 1 ha fet una reserva. Places disponibles: 0
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 3 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 1 ha cancel·lat una reserva. Places disponibles: 1
Assistent 4 ha fet una reserva. Places disponibles: 0
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 4 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 6 ha cancel·lat una reserva. Places disponibles: 1
Assistent 6 ha cancel·lat una reserva. Places disponibles: 2
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 8 ha fet una reserva. Places disponibles: 1
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 4 ha cancel·lat una reserva. Places disponibles: 2
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 6 ha cancel·lat una reserva. Places disponibles: 3
Assistent 5 ha fet una reserva. Places disponibles: 2
Assistent 8 ha fet una reserva. Places disponibles: 1
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 2 ha fet una reserva. Places disponibles: 0
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 3 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 4 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 6 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 8 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 5 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 2 ha cancel·lat una reserva. Places disponibles: 1
Assistent 1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 6 ha cancel·lat una reserva. Places disponibles: 2
Assistent 5 ha cancel·lat una reserva. Places disponibles: 3
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 1 ha fet una reserva. Places disponibles: 2
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent 8 ha fet una reserva. Places disponibles: 1
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 7 ha fet una reserva. Places disponibles: 0
Assistent 2 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 1 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 7 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 8 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0



70 reservar 30 cancel·lar:

~~~~
@Override
    public void run() {
        while (true) {
            try {
                int accio = rnd.nextInt(10);

                synchronized (esdeveniment) {
                    if (accio >= 0 && accio <= 6) {
                        if(esdeveniment.ferReserva(this)){
                            esdeveniment.notifyAll();
                        }else{
                            esdeveniment.wait();
                        }
                         
                    } else {
                        if(esdeveniment.cancelaReserva(this)){
                            esdeveniment.notifyAll();
                        }else{
                            esdeveniment.wait();
                        }
                         
                    }
                }

                Thread.sleep(rnd.nextInt(1000));

            } catch (InterruptedException e) {
                System.out.println(nom + " ha sigut interrumput.");
                break;
            }
        }
    }
~~~~

edhat.java\x5cjdt_ws\x5cM09UF02_23e4b91f\x5cbin' 'Organitzador' ;5eaffe4e-67eb-46db-82e3-6a748c3e7d8eAssistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent 9 ha fet una reserva. Places disponibles: 4
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4     
Assistent 7 ha fet una reserva. Places disponibles: 3
Assistent 1 ha fet una reserva. Places disponibles: 2
Assistent 6 ha fet una reserva. Places disponibles: 1
Assistent 5 ha fet una reserva. Places disponibles: 0
Assistent 4 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 3 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 2 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 5 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 6 ha cancel·lat una reserva. Places disponibles: 1
Assistent 7 ha fet una reserva. Places disponibles: 0
Assistent 9 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 8 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 0 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 6 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 1 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 7 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 3 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 2 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 4 no ha pogut fer una reserva perque no queden places. Places disponibles:0
Assistent 5 no ha pogut fer una reserva perque no queden places. Places disponibles:0


### Pregunta 3

Sense la llista no es pot saber quin fil ha fet la acció de reservar o de cancel·lar la reserva.
# Problema dos Filósofos Famintos
O Problema dos Filósofos Famintos é um clássico problema de sincronização de processos que envolve um grupo de filósofos sentados em uma mesa redonda com pratos de comida intercalados com garfos. Cada filósofo precisa alternar entre pensar e comer. No entanto, para comer, um filósofo precisa de dois garfos que estão ao lado dele (um à sua esquerda e outro à sua direita). O desafio é garantir que os filósofos possam alternar entre comer e pensar de forma segura, evitando impasses (deadlock) e possibilitando que todos possam comer, mesmo que seja em turnos.

## Descrição do problema:

Suponha que existam N filósofos sentados em uma mesa redonda, numerados de 0 a N-1, cada um com um prato de comida à sua frente. Entre cada par de filósofos, há um garfo. Cada filósofo precisa de dois garfos para comer, um à sua esquerda e outro à sua direita. Inicialmente, todos os filósofos estão pensando.

## Regras do problema:

1. Um filósofo alterna entre os estados de pensar e comer. No estado de comer, ele precisa de dois garfos adjacentes (esquerda e direita) para poder comer;
2. Os filósofos podem pegar os garfos ao seu lado quando estiverem disponíveis (não sendo usados por outros filósofos) e liberar os garfos após terminar de comer.
3. Para evitar impasses, um filósofo pode apenas pegar garfos quando ambos estiverem disponíveis. Se um dos garfos estiver sendo usado por outro filósofo, o filósofo faminto deve esperar até que ambos os garfos estejam disponíveis.

## Objetivo do problema:

O objetivo do Problema dos Filósofos Famintos é projetar um mecanismo de sincronização
que permita que os filósofos alternem entre comer e pensar de forma segura, evitando
impasses e garantindo que todos os filósofos possam comer em algum momento.

# Contributing

You will find
[this article the rules of chess](https://en.wikipedia.org/wiki/Rules_of_chess)
on useful when working on Chessington.

In the `models` folder, you'll find the logic that powers the chess game. Here's
a guide to the models, telling you what they do and how they work.

## Coordinates

A position on the board is represented by the Coordinates class.

The coordinates start from (0, 0) at the top-left, and end with (7, 7) at the
bottom-right.

You can create a new `Coordinates` like so:

```java
var coordinates = new Coordinates(row, column)
```

## Board

You can use the `board.get(coordinates)` to get the piece on a given square.

## Pieces

When pieces are constructed, they are assigned a player, either `WHITE` or
`BLACK`.

Each piece needs to have the method `getAllowedMoves()`

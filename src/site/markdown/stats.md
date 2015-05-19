# Stats on tabletop games

Among the several ways tabletop games have of solving confrontations, one of the most common is assigning numerical values to the actors. These represents things such as their physical attributes, and are used by the game mechanics to find out if a task ends in success or failure.

This is achieved by matching said value to one or several others, where usually at least one is randomly generated. But the exact way this works will vary from game to game.

Of course, things are not always as simple. There is a tendency to find derived stats in games, meaning stats which are calculated from other stats, and it is also common to assign them other values, such as a name, a description or group.

And as more stats beging to appear, more values start becoming similar to them. If you take a look at those points you have to expend during character creation, they have a certaing glint of derived stats. And if stats can be spent, does that make ammo stats too?

Actually, in the context of the library, this will depend a lot on the intentions and use of the actual value.

## Stats in context

For this library, a stat is a value fitting at least one of the following criteria:

- It has dependencies with other values or mechanics.
- Other values or mechanics are dependent on it.
- It should be observable.
- It changes a system's status when modified.

Of course, this is not a checklist, it will still depend on the situation. But the general recommendation is that if you can avoid using this library, then probably you can get a better and simpler solution.

## Stats and mechanics

Basic stats are meant to be used as part of the usual success/failure confrontation mechanics. The exact way this is handled depends on the game, and currently is beyond the scope of this library.

## Variants

These are some of the most common types of attributes. Note that these are defined in general terms, and actual stats may vary from a game to another.

---

### Attributes

These are values which may have a name and are unique inside a scope. For example, a character may have the Strength attribute, and it will have just one Strength attribute.

Additionally, they are defined in number. So there may be five different attributes, and a character won't have any more or any less than five of them, at least without becoming an alternative type of character.

### Derived attributes

Derived attributes are the same as the attributes, but with one big difference. Their values are generated from other attributes.

For example, the derived attribute hitpoints may be the summation of the strength and constitution attributes. When one of the, changes, so does the hitpoints.

### Skills

In the most common shape, these are values with a name and a descriptor. They are very particular because sometimes it may be more important knowing the combination of name and skill than the value. And it may not even matter at all if they have a value, only if they are assigned to a character.

Also, they are potentially limitless. While the same combination of name and descriptor is disallowed, nothing stops a character from having a new skill with a new name.

### Points pools

Used during procedures such as character creation. These points are meant to be spent and refilled. The rules defining how is this to be done can be tricky and complex.

### Control values

These may seem to fit into some of the cases, but actually are not meant to be handled through this library.

An example would be a wargame, where there is a limit on the number of units you can buy. This generates a dependency to such value, and the player needs to be conscious of it, but probably in practice you won't do much more with it than a small query each time a new unit is added.

Of course, on the other hand, if the unit limit depends, for example, on the number of leaders on the list, it may, and only may, be a stat.
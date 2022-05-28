# CityParser
Read information from the textual representation of the directory and decompose the data into a City model with fields.
Task Description

It is necessary to implement the Main class using java.util.Scanner, read the information from the text view of the reference book and decompose the data into a City model with fields:

name - city name
region - region
district - federal district
population - the number of city residents
foundation - foundation date or first mention
The resulting list of City objects must be output to the console.

An example of the result obtained:
City{name='Adygeysk', region='Adygea', district='South', population=12248, foundation='1973'}
City{name='Maikop', region='Adygea', district='South', population=144246, foundation='1857'}
City{name='Gorno-Altaysk', region='Altai', district='Siberian', population=56928, foundation='1830'}

# Sorting
Task description

You need to implement the following sorting options:
Sort the list of cities by name in alphabetical descending order, case insensitive;
Sort the list of cities by federal district and the name of the city within each federal district in alphabetical descending order, case sensitive;
Output the resulting list of City objects to the console. When implementing sorting, pay attention to possible implementation options: Comporator, lambda expressions.

An example of the result obtained for sorting by name:

City{name='Abaza', region='Khakassia', district='Siberian', population=17111, foundation='1867'}
City{name='Abakan', region='Khakassia', district='Siberian', population=165183, foundation='1931'}
City{name='Abdulino', region='Orenburg Oblast', district='Privolzhsky', population=20663, foundation='1795'}
…
An example of the result obtained for sorting by two fields of the directory - the federal district and the name of the city:

City{name='Aldan', region='Yakutia', district='Far East', population=21277, foundation='1924'}
City{name='Aleksandrovsk-Sakhalinsky', region='Sakhalin Oblast', district='Far East', population=10613, foundation='1869'}
City{name='Amursk', region='Khabarovsk Krai', district='Far East', population=42977, foundation='1958'}
…
City{name='Abdulino', region='Orenburg Oblast', district='Privolzhsky', population=20663, foundation='1795'}
City{name='Agidel', region='Bashkortostan', district='Privolzhskiy', population=16365, foundation='1980'}
City{name='Agryz', region='Tatarstan', district='Volga', population=19299, foundation='1646'}
…

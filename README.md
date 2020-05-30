# ShoppingCartDiscountCalculator

Epic Context 

A big retail brand outlet, on the eve of Christmas, we want to offer attractive seasonal discounts to our customers to boost our retail sales. 

Story#1 As a retail outlet’s salesman, I should be able to calculate the customer's shopping cart bill after considering applicable discount rates that are based on the purchase amount and customer type so that our retail outlet      can maximize sales volume & value. 
 
Discount Slabs for various purchase amounts for the regular and premium customers are as follows: 
 
Customer Type:​ Regular                                                 Customer Type:​ Premium Purchase
Amount Slab                     Discount %  Purchase                                        Amount Slab                     Discount %
$0   -  $  5,000                    Nil  $                                                 0  -  $4,000                     10%
$5,000 - $10,000                    10%                                                    $ 4,000 -  $8,000                15%
$10,000 & above                     20%                                                    $8,000  -  $12,000               20%
                                                                                           $ 12,000 &  above                30%

Note:  Total​ ​discount would be the sum of discount calculated for each slab.
E.g. For purchase of $15,000 by a regular customer would entitle total discount $1500 which is sum of discount $500 for 2nd slab [10% of $(10000-5000)] & $1000 discount for 3rd slab [20% of $(15000-10000)].
 
Story Test-cases Here are some of the test cases and corresponding input / output expectations: 
 
Customer Type (input):​ Regular  Customer Type                                                                                                                  (input):​ Premium
Purchase Amount (input) | Bill Amount (output)                                                                                            Purchase Amount  (input)| Bill Amount (output)
$ 5,000                     $ 5,000                                                                                                          $ 4,000                    $ 3,600
$ 10,000                    $ 9,500                                                                                                          $ 8,000                    $ 7,000
$ 15,000                    $ 13,500                                                                                                         $ 12,000                   $ 10,200
                                                                                                                                             $20,000                    $15,800
  Solution Expectations’ Guidelines​:
  ● You should demonstrate the working software by building an application / test program that exercises the sample test-cases. Console inputs / outputs not needed.
  ● Maturity of your solution will be judged based on object oriented and / or functional programming design and your ability to write clean, modular, extensible, maintainable and testable code.
  ● Coding-challenge here does not require any knowledge of underlying databases, OS platforms or libraries (apart from standard development kit like JDK and xUnit framework).
  ● Based on this epic & story context, there could be other stories which could be asked to build-upon in upcoming interview rounds.  Example: Introduce new customer types like Gold, Diamond, Platinum, etc and their discounts slabs.
  ● Please don’t write on this paper sheet. You can email your solution zip (without .class files) to the HR representative.
 

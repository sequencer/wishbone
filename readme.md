# Diplomatic Wishbone
A toy project to help people understand diplomacy.

# Run
mill wishbone.tests

# IDE(Intellij, Metal) Integration
Simply use 
```
mill -i mill.contrib.BSP/install
```
to generate a [BSP](https://www.scala-lang.org/blog/2018/06/15/bsp.html) project. Then use Intellij or your favorite IDE open it.

Use
```
mill -i wishbone.tests.test
```
to run test.


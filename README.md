# hmrc

This is Java Test code

The test is completed using Java 1.7, maven 3.1 (on Java 1.6).

This test is designed considering that the product is a model and persisted in the database. Further discount is implemented in a hard coded way because it could be overkill to use the rules engine which can again be dynamically stored in the database.

There are different ways to use the rules engine. One way is to store the rules in the database in the form of javascript. Another way to store the discount in the database is using proprietary rules engine either ILog JRules or Drools (Since I have experience in these tools, mentioned about them explicitly)

Since the codebase is not big enough, the test coverage is not upto 85%. However considering the service class, the coverage is good enough.

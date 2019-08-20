**To run this file just make sure you have maven in there**
``mvn clean verify``

By using serenity.conf , we can run it with different properties , so in each properties will be different.


if you want to run it based on configuration you can run by add some parameter in maven for example

``mvn clean verify -Denvironment=staging``

After running automation , you can get the report in folder ``target/site/serenity/index.html`` and you will get your report
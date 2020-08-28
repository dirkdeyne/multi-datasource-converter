# multi-datasource-converter

Encrypt and Decrypt data [inspired by sunitk](https://github.com/sunitk/generic-jpa-converter-encrypt-decrypt)

Demo application as answer for [SO-question](https://stackoverflow.com/questions/63345837/not-getting-value-from-property-inside-attributeconverter-when-using-multiple-da)

 - creates foo and bar on startup
 - localhost:8080/foobar/1
 - localhost:8080/foo/1
 - localhost:8080/bar/1
 
 localhost/h2-console to see data:
 - user: sa
 - password:
 - JDBC URL: jdbc:h2:mem:bar or jdbc:h2:mem:foo

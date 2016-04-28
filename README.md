# VAT Information Exchange System (VIES)
VIES is an electronic means of transmitting information relating to VAT-registration (= validity of VAT-numbers) of companies registered in EU. Furthermore, information relating to (tax exempt) intra-Community supplies between Member States' administrations is also transmitted via VIES.

## VIES client
This client connects to the VIES database, which can be queried using SOAP communication protocol (thorugh [their public wsdl](http://ec.europa.eu/taxation_customs/vies/checkVatService.wsdl)).

The client API just implements two methods:
```java
EuropeanVat.isVatValid(vatNumber, countrCode)
EuropeanVat.isVatValid(vatNumberWithCountryCode)
```

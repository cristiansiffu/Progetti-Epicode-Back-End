# BE0222B-Progetto-Settimana8

Questo progetto testa i servizi REST di un'applicazione che simula un conto bancario. Le operazioni disponibili sono le seguenti:

## Funzionalità principali
- Visualizzazione, creazione, modifica ed eliminazione di un conto corrente
- Operazioni di deposito e prelievo
- Lista delle transazioni avvenute per ogni conto corrente
## URL Metodi PostmanAPI:
### GET
- **getAllBankAccounts: http://localhost:8080/ProgettoS8/rest/ewallet/get**
- **getBankAccountByIban: http://localhost:8080/ProgettoS8/rest/ewallet/iban?iban="inserireIbanContoCorrente"**
- **getFinancials: http://localhost:8080/ProgettoS8/rest/ewallet/financials?iban="inserireIbanContoCorrente"**

### POST
- **postBankAccount: http://localhost:8080/ProgettoS8/rest/ewallet/post**
- **Body { "iban" : "ESEMPIO111222333", "balance" : 100.00, "holder" : "Nome Cognome" }**
### PUT
- **putBankAccount: http://localhost:8080/ProgettoS8/rest/ewallet/put?iban="inserireIbanContoCorrente"&name="inserireNomeAggiornato"**
- **withdrawal: http://localhost:8080/ProgettoS8/rest/ewallet/withdrawal?iban="inserireIbanContoCorrente"&value="inserireCifra"**
- **deposit: http://localhost:8080/ProgettoS8/rest/ewallet/deposit?iban="inserireIbanContoCorrente"&value="inserireCifra"**
### DELETE
- **deleteBankAccount: http://localhost:8080/ProgettoS8/rest/ewallet/delete?iban="inserireIbanContoCorrente"**

Per ragioni sia pratiche che logiche nella PUT sarà possibile modificare solamente l'intestatario del conto corrente inserendo il nuovo intestatario come parametro URL

CREATE TABLE FAUCETTYPE (
    FID INT NOT NULL PRIMARY KEY,
    DESCRIPTION VARCHAR(100) NOT NULL
);

INSERT INTO FAUCETTYPE VALUES(1, 'Faucet Site');
INSERT INTO FAUCETTYPE VALUES(2, 'Android App');
INSERT INTO FAUCETTYPE VALUES(3, 'PTC site');
INSERT INTO FAUCETTYPE VALUES(4, 'Game');
INSERT INTO FAUCETTYPE VALUES(5, 'Wallet');
INSERT INTO FAUCETTYPE VALUES(6, 'Advertise');
INSERT INTO FAUCETTYPE VALUES(7, 'Service');

CREATE TABLE DESCRIPTION (
    DESCID INT NOT NULL PRIMARY KEY,
    PTDESC VARCHAR(255),
    ENGDESC VARCHAR(255)
);

INSERT INTO DESCRIPTION VALUES (1, 'Adquira de 5 a 15 satoshis a cada 10 minutos. Depósito imediato na carteira XAPO!', 'Claim 5 to 15 satoshi every 10 minutes. Payment directly to XAPO wallet!');
INSERT INTO DESCRIPTION VALUES (2, 'Adquira de 5 a 15 satoshis a cada 10 minutos. Depósito imediato na carteira XAPO!', 'Claim 5 to 15 satoshi every 10 minutes. Payment directly to XAPO wallet!');
INSERT INTO DESCRIPTION VALUES (3, 'Adquira de 2 a 10 satoshis a cada 5 minutos. Depósito imediato na carteira XAPO!', 'Claim 2 to 10 satoshis every 5 minutes. Payment directly to XAPO wallet!');
INSERT INTO DESCRIPTION VALUES (4, 'Satoshis a cada 5 minutos. Depósito imediato na carteira XAPO!', 'Claim satoshis every 5 minutes. Payment directly to XAPO wallet!');
INSERT INTO DESCRIPTION VALUES (5, 'Satoshis a cada 5 minutos, possui mineração via navegador e precisa acumular 1250 para enviar para a carteira XAPO.', 'Claim satoshis every 5 minutes, minimum amount: 1250 satoshi. Payment directly to XAPO wallet.');
INSERT INTO DESCRIPTION VALUES (6, 'Receba satoshis a cada 30 minutos e/ou resolvendo jogos matemáticos fáceis. Receba via Coinbase a cada 600 satoshis acumulados', 'Claim satoshis every 30 minutes and/or playing easy math games. Transfer to Coinbase Wallet when you get 600 satoshis.');
INSERT INTO DESCRIPTION VALUES (7, 'Carteira online com suporte para Bitcoin, Bitcoin Cash, Ethereum e Litecoin. Possui App android. Parte dos apps e serviços aqui listados depositam direto nesta carteira.', 'Online wallet for Bitcoin, Bitcoin Cash, Ethereum and Litecoin. Some apps and services listed here use this wallet to receive the coins.');
INSERT INTO DESCRIPTION VALUES (8, 'Receba para visualizar sites/propagandas. Saque ao atingir 0.10000 mBTC', 'Earn for view ADS. Minimum withdraw = 0.10000 mBTC.');
INSERT INTO DESCRIPTION VALUES (9, 'Uma das carteiras mais famosas.', 'One of the most famous Bitcoin wallets');
INSERT INTO DESCRIPTION VALUES (10, 'Se voce tem um site, receba para exibir os banners dos parceitos deste serviço. Você também pode pagar para divulgar seus sites/serviços.', 'Earn to show banners in your site. You also can pay to promote your site/service.');
INSERT INTO DESCRIPTION VALUES (11, 'Micro carteira para Bitcoin, Bitcoin Cash, Dodgecoin, Litecoin e Dashcoin. Alguns serviços depositam direto nesta carteira.', 'Cryptocurrency microwallet for Bitcoin, Bitcoin Cash, Litecoin, Dashcoin and Dodgecoin. Some services send payments directly to this microwallet.');
INSERT INTO DESCRIPTION VALUES (12, 'Receba satoshis a cada 5 minutos, depositados direto na carteira CoinPot. Possui mineração via navegador/browser.', 'Claim satoshis every 5 minutes. Payment directly to CoinPot. Contains browser mining.');
INSERT INTO DESCRIPTION VALUES (13, 'Receba satoshis a cada 15 minutos, depositados na carteira CoinPot.', 'Claim satoshis every 15 minutes. Payment to CoinPot wallet.');
INSERT INTO DESCRIPTION VALUES (14, 'Site com múltiplas funções como carteira, faucet e pesquisas. Alguns serviços pagam nesta carteira', 'Microwallet for multiple coin types, faucet, ads, offers, etc. Some faucet services deposit in this wallet addresses.');
INSERT INTO DESCRIPTION VALUES (15, 'Receba satoshis para clicar em propagandas. Permite sacar direto para carteiras ou para o FaucetHub (a partir de 10000).', 'Earn to click ADS. Can withdraw to FacetHub (minimum 10000) or directly (temporary available. Last try: Dec 25, 2017).');
INSERT INTO DESCRIPTION VALUES (16, 'Um dos sites mais famosos de coleta de satoshis. Adquira a cada 1 hora. Saque mínimo: 0.00030000 BTC', 'Claim random satoshi value every 60 minutes. One of the most famous sites. Withdraw: 0.00030000 BTC');
INSERT INTO DESCRIPTION VALUES (17, 'Adquira até 30 satoshis a cada 3 minutos. Pagamento via FaucetHub (mínimo 0.000003) ou direto (mínimo 0.0001).', 'Claim 1 to 30 satoshi every 3 minutes. Payment to FaucetHub (minimum 0.000003) or directly (minimum 0.0001)');
INSERT INTO DESCRIPTION VALUES (18, 'Recarregue seu telefone utilizando bitcoins! (Claro, Vivo, Tim, Oi)', '');

CREATE TABLE WALLET(
    ID INT NOT NULL PRIMARY KEY,
    NAME VARCHAR(100) NOT NULL,
    DESCRIPTIONID INT,
    URL VARCHAR(120) NOT NULL,
    MYADDRESS VARCHAR(60),
    ACTIVE BOOLEAN DEFAULT true
);

INSERT INTO WALLET VALUES (1, 'Coinbase', 7, 'https://www.coinbase.com/join/5a31ad6ce9469500fb7bb747', '1JMHXL2vxckW76g6LDth92eSkA1L4PUEek', true);
INSERT INTO WALLET VALUES (2, 'XAPO', 9, 'https://xapo.com/', null, true);
INSERT INTO WALLET VALUES (3, 'CoinPot', 11, 'https://coinpot.co/', null, true);
INSERT INTO WALLET VALUES (4, 'FaucetHub', 14, 'http://faucethub.io/r/30541613', null, true);

CREATE TABLE FAUCETOBJ (
    FID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    FTYPE INT NOT NULL,
    DESCRIPTIONID INT,
    NAME VARCHAR(100) NOT NULL,
    URL VARCHAR(120) NOT NULL,
    ACTIONDESCRIPTIONID INT,
    ACTIVE BOOLEAN NOT NULL DEFAULT true
);

INSERT INTO FAUCETOBJ VALUES (null, 1, 1, 'AD Banner Rotator', 'http://www.adbannerrotator.com/btc-faucet/?r=ascaloners@gmail.com', true);
INSERT INTO FAUCETOBJ VALUES (null, 1, 2, 'Admoneytrix', 'http://www.admoneytrix.com/faucet/?r=ascaloners@gmail.com', true);
INSERT INTO FAUCETOBJ VALUES (null, 1, 3, 'BTC4Free Blue', 'https://btc4free.site/faucet/?ref=104268', true);
INSERT INTO FAUCETOBJ VALUES (null, 1, 4, 'BTC4Free Orange', 'https://btc4free.today/?ref=113428', true);
INSERT INTO FAUCETOBJ VALUES (null, 1, 5, 'Instant BTC', 'https://www.instant-btc.eu/ref/eJxF11IK', true);
INSERT INTO FAUCETOBJ VALUES (null, 2, 6, 'Free Satoshi - Bitcoin', 'https://play.google.com/store/apps/details?id=com.wwwoestudios.bitcoinfaucets', true);
INSERT INTO FAUCETOBJ VALUES (null, 5, 7, 'Coinbase', 'https://www.coinbase.com/join/5a31ad6ce9469500fb7bb747', true);
INSERT INTO FAUCETOBJ VALUES (null, 3, 8, 'BTC Clicks', 'https://btcclicks.com/?r=fda920ad', true);
INSERT INTO FAUCETOBJ VALUES (null, 6, 10, 'Anonymous Ads', 'http://a-ads.com?partner=790804', true);
INSERT INTO FAUCETOBJ VALUES (null, 1, 12, 'Moon Bitcoin', 'http://moonbit.co.in/?ref=bc6068872b94', true);
INSERT INTO FAUCETOBJ VALUES (null, 1, 13, 'Bonus Bitcoin', 'http://bonusbitcoin.co/?ref=F1BED83F0B79', true);
INSERT INTO FAUCETOBJ VALUES (null, 1, 15, 'adBTC', 'https://ref.adbtc.top/585231', true);
INSERT INTO FAUCETOBJ VALUES (null, 1, 16, 'freebitcoin', 'https://freebitco.in/?r=271191', true);
INSERT INTO FAUCETOBJ VALUES (null, 1, 17, '1Katoshi', 'https://1katoshi.com?ref=803734dc4491de66beda47fbc3af9bbc', '', true);
INSERT INTO FAUCETOBJ VALUES (null, 7, 18, 'Recarga de Telefone', '/phonerecharge', true);

UPDATE WALLET SET MYADDRESS = '1JMHXL2vxckW76g6LDth92eSkA1L4PUEek' WHERE ID = 1;

CREATE TABLE MOBILEPROVIDER(
    MPID INT NOT NULL PRIMARY KEY,
    DESCRIPTION VARCHAR(90) NOT NULL
);

INSERT INTO MOBILEPROVIDER VALUES (1, 'Claro');
INSERT INTO MOBILEPROVIDER VALUES (2, 'Vivo');
INSERT INTO MOBILEPROVIDER VALUES (3, 'Tim');
INSERT INTO MOBILEPROVIDER VALUES (4, 'Oi');

CREATE TABLE MOBILERECHARGESTATUS(
    MRSID INT NOT NULL PRIMARY KEY,
    DESCRIPTION VARCHAR(90) NOT NULL
);

INSERT INTO MOBILERECHARGESTATUS VALUES (1, 'Pending');
INSERT INTO MOBILERECHARGESTATUS VALUES (2, 'Canceled');
INSERT INTO MOBILERECHARGESTATUS VALUES (3, 'Done');

CREATE TABLE PHONERECHARGE(
    PRID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(250),
    PHONENUMBER VARCHAR(20) NOT NULL,
    MOBILEPROVIDERID INT NOT NULL,
    RECHARGEVALUE INT NOT NULL,
    BTCVALUE VARCHAR(100) NOT NULL,
    REQUESTTIMESTAMP DATETIME NOT NULL,
    WALLET VARCHAR(120) NOT NULL,
    RECHARGESTATUSID INT NOT NULL
);

--27/12/2017
ALTER TABLE FAUCETOBJ ADD ACTIONDESCRIPTIONID INT;
ALTER TABLE FAUCETOBJ ADD IMAGESRC VARCHAR(255);
ALTER TABLE WALLET ADD IMAGESRC VARCHAR(255);

INSERT INTO DESCRIPTION VALUES (19, 'Recarregar', 'Recharge');
INSERT INTO DESCRIPTION VALUES (20, 'Coletar Satoshi', 'Colect Satoshi');
INSERT INTO DESCRIPTION VALUES (21, 'Google Play Download', 'Download on Google Play');
INSERT INTO DESCRIPTION VALUES (22, 'Divulgue seu Conteúdo', 'Advertise');

UPDATE FAUCETOBJ SET ACTIONDESCRIPTIONID = 20 WHERE FTYPE = 1 OR FTYPE = 3;
UPDATE FAUCETOBJ SET ACTIONDESCRIPTIONID = 21 WHERE FTYPE = 2;
UPDATE FAUCETOBJ SET ACTIONDESCRIPTIONID = 22 WHERE FTYPE = 6;
UPDATE FAUCETOBJ SET ACTIONDESCRIPTIONID = 19 WHERE NAME = 'Recarga de Telefone';

UPDATE FAUCETOBJ SET IMAGESRC = '../bitservices/images/bitbannercard.jpeg' WHERE NAME = 'Recarga de Telefone';
UPDATE FAUCETOBJ SET IMAGESRC = '../bitservices/images/adbannerrotator.png' WHERE NAME = 'AD Banner Rotator';
UPDATE FAUCETOBJ SET IMAGESRC = '../bitservices/images/admoneytrix.png' WHERE NAME = 'Admoneytrix';
UPDATE FAUCETOBJ SET IMAGESRC = '../bitservices/images/btc4freeblue.png' WHERE NAME = 'BTC4Free Blue';
UPDATE FAUCETOBJ SET IMAGESRC = '../bitservices/images/btc4freeorange.png' WHERE NAME = 'BTC4Free Orange';
UPDATE FAUCETOBJ SET IMAGESRC = '../bitservices/images/instantbtc.png' WHERE NAME = 'Instant BTC';
UPDATE FAUCETOBJ SET IMAGESRC = '../bitservices/images/freesatoshibtcapp.jpg' WHERE NAME = 'Free Satoshi - Bitcoin';
UPDATE FAUCETOBJ SET IMAGESRC = '../bitservices/images/btcclicks.png' WHERE NAME = 'BTC Clicks';

UPDATE WALLET SET IMAGESRC = '../bitservices/images/coinbase.png' WHERE ID = 1;
UPDATE WALLET SET IMAGESRC = '../bitservices/images/xapowallet.png' WHERE ID = 2;

--28/12/2017
CREATE TABLE NEWS(
    NID INT PRIMARY KEY NOT NULL,
    TITLE VARCHAR(200) NOT NULL,
    MYCOMMENT VARCHAR(255),
    NURL VARCHAR(255) NOT NULL,
    VOTESUP INT DEFAULT 0,
    VOTESDOWN INT DEFAULT 0,
    PUBLISHEDDATE DATETIME
);

UPDATE FAUCETOBJ SET IMAGESRC = 'https://storage.googleapis.com/app-static-files/1katoshipic.png' WHERE NAME = '1Katoshi';
UPDATE FAUCETOBJ SET IMAGESRC = 'https://storage.googleapis.com/app-static-files/bonusbitcoin.png' WHERE NAME = 'Bonus Bitcoin';
UPDATE FAUCETOBJ SET IMAGESRC = 'https://storage.googleapis.com/app-static-files/moonbitcoinpic.png' WHERE NAME = 'Moon Bitcoin';
UPDATE FAUCETOBJ SET IMAGESRC = 'https://storage.googleapis.com/app-static-files/freebitcoin.png' WHERE NAME = 'freebitcoin';
UPDATE FAUCETOBJ SET IMAGESRC = 'https://storage.googleapis.com/app-static-files/adbtcpic.png' WHERE NAME = 'adBTC';

UPDATE WALLET SET IMAGESRC = 'https://storage.googleapis.com/app-static-files/coinpotpic.png' WHERE ID = 3;
UPDATE WALLET SET IMAGESRC = 'https://storage.googleapis.com/app-static-files/faucethubpic.png' WHERE ID = 4;

--28/12/2017-2
INSERT INTO DESCRIPTION VALUES (23, 'Anda de Uber? Então adquira créditos via Uber Gift. Selecione a quantidade e os dados de envio dos créditos.', 'Do you use Uber? Here you can buy Uber Gift credits using your coins.');
INSERT INTO DESCRIPTION VALUES (24, 'Adquirir', 'Buy Gift Card');
INSERT INTO FAUCETOBJ VALUES (18, 7, 23, 'Uber Gift', '/ubergift', true, 24, 'https://storage.googleapis.com/app-static-files/images/uberpic.png');

--29/12/2017
CREATE TABLE PROMOCODE (
    CID INT NOT NULL PRIMARY KEY,
    CODE VARCHAR(12) NOT NULL UNIQUE,
    AMOUNT INT NOT NULL DEFAULT 1,
    USED INT NOT NULL DEFAULT 0,
    EXPIRATION DATETIME NOT NULL,
    ACTIVE BOOLEAN DEFAULT true,
    OWNERID INT
);

--INSERT INTO PROMOCODE VALUES(1, 'FLZ2018', 1, 0, '2018-01-01', true, 1);

CREATE TABLE BSUSER (
    UID INT NOT NULL PRIMARY KEY,
    FIRSTNAME VARCHAR(100),
    LASTNAME VARCHAR(100),
    EMAIL VARCHAR(200),
    PHONENUMBER VARCHAR(30)
);

--INSERT INTO BSUSER VALUES (1, 'Henrique', 'Passos', 'henriquepassos.fisio@gmail.com', '1199998888');

CREATE TABLE USEDPROMOCODE(
    USERID INT NOT NULL,
    CODEID INT NOT NULL,
    USEDDATE TIMESTAMP NOT NULL,
    FOREIGN KEY (USERID) REFERENCES BSUSER(UID),
    FOREIGN KEY (CODEID) REFERENCES PROMOCODE(CID)
);

CREATE TABLE UBERGIFT(
    ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    USEREMAIL VARCHAR(200),
    USERPHONE VARCHAR(40),
    USERFIRSTNAME VARCHAR(100),
    USERLASTNAME VARCHAR(100),
    VALUETODEPOSIT VARCHAR(30),
    REQUESTVALUE INT,
    REQUESTDATE TIMESTAMP,
    CREDITED BOOLEAN DEFAULT FALSE
);
--10/01/2018
INSERT INTO NEWS VALUES (191,'Empresa no Japão irá oferecer parte do pagamento de salários em bitcoin', "A 'GMO Internet' pretende pagar parte do salário de seus colaboradores em bitcoin. A proposta será ofertada para 4 mil colaboradores inicialmente. É uma proposta interessante para quem já convertia seu salário na cripto moeda.", 'https://www.theguardian.com/technology/2017/dec/15/japanese-company-paying-employees-bitcoin',0,0,'2017-12-15 04:27:00');
INSERT INTO NEWS VALUES (198,'De acordo com Warren Buffett as criptomoedas podem acabar mal...', "O investidor disse que tem quase certeza que 'irá acabar mal', no entanto não soube explicar quando, ou como. Se vai acabar mal nós não sabemos, mas até lá muita coisa ainda pode acontecer...", 'https://www.coindesk.com/warren-buffett-cryptocurrencies-will-come-to-a-bad-ending/?utm_content=buffer4e9d1&utm_medium=social&utm_source=twitter.com&utm_campaign=buffer',0,0,'2018-01-10 18:05:00');
--11/01/2018
INSERT INTO NEWS VALUES (204,'O que posso comprar no Brasil com bitcoin?', 'https://goo.gl/exHMzX',0,0,'2017-12-21 13:05:00', "A região sudeste do Brasil é aquela que concentra o maior número de produtos e serviços ofertados em cripto moeda, em especial São Paulo, Curitiba e Porto Alegre. A FIAP (www.fiap.com.br) em São Paulo tem até um ATM da moeda. Aqui mesmo neste site adicionamos alguns serviços que podem ser contratados, como recargas de telefone pré pago e gift cards do Uber (http://www.acucaradus.com/bitservices), no entanto, diversos serviços estão adotando o uso de outras moedas, pois a taxas do bitcoin estão elevadíssimas. Aprecie a matéria completa no link abaixo.");
--13/01/2018
ALTER TABLE NEWS ADD NIMG VARCHAR(255);
UPDATE NEWS SET NIMG = "https://storage.googleapis.com/app-static-files/images/microsoft.png" WHERE NID = 209;
UPDATE NEWS SET NIMG = "https://storage.googleapis.com/app-static-files/images/brazil.png" WHERE NID = 204;
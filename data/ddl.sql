-- Criação da tabela cardHolder
CREATE TABLE IF NOT EXISTS cardHolder (
  cardholderid UUID PRIMARY KEY,
  clientid UUID UNIQUE,
  status VARCHAR(20),
  creditlimit DOUBLE PRECISION,
  createdat DATE
);

-- Criação da tabela bankAccount
CREATE TABLE IF NOT EXISTS bankAccount (
  bankAccountId UUID PRIMARY KEY,
  account VARCHAR(10),
  agency VARCHAR(4),
  bankCode VARCHAR(3),
  createdat TIMESTAMP,
  updatedat TIMESTAMP,
  cardHolderId UUID REFERENCES cardHolder(cardHolderId)
);

-- Criação da tabela cards
CREATE TABLE IF NOT EXISTS cards (
  cardId UUID PRIMARY KEY,
  cardNumber VARCHAR(19),
  cvv INTEGER,
  dueDate DATE,
  createdat TIMESTAMP,
  updatedat TIMESTAMP,
  cardHolderId UUID REFERENCES cardHolder(cardHolderId)
);

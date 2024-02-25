CREATE TABLE `especie_veiculo` (
  `id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `descricao` varchar(50) DEFAULT NULL,
  `tipo_rodado` enum('UNITARIO','TRACAO','REBOQUE') NOT NULL,
  UNIQUE KEY `UK_especie_veiculo_descricao` (`descricao`)
);

CREATE TABLE `veiculo` (
  `id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `placa` varchar(7) DEFAULT NULL,
  `frota` varchar(50) DEFAULT NULL,
  `id_especie_veiculo` bigint NOT NULL,  
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  `updated_at` TIMESTAMP DEFAULT NULL,
  `actived` bit(1) DEFAULT b'1' NOT NULL,
  `observacao` tinytext,
  UNIQUE KEY `UK_veiculo_placa` (`placa`),
  KEY `FK_veiculo_id_especie_veiculo_id` (`id_especie_veiculo`),
  CONSTRAINT `FK_veiculo_id_especie_veiculo_id` FOREIGN KEY (`id_especie_veiculo`) REFERENCES `especie_veiculo` (`id`)
);

CREATE TABLE `pessoa` (
  `id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nome` varchar(75) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  `updated_at` TIMESTAMP DEFAULT NULL,
  `actived` bit(1) DEFAULT b'1' NOT NULL,
  `observacao` tinytext,
  UNIQUE KEY `UK_pessoa_cpf` (`cpf`),
  UNIQUE KEY `UK_pessoa_nome` (`nome`)
);

CREATE TABLE `enquadramento` (
  `id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `numero` varchar(6) DEFAULT NULL,
  `descricao` varchar(120) DEFAULT NULL,
  `base_legal` varchar(20) DEFAULT NULL,
  `infrator` enum('EMBARCADOR','MOTORISTA','OUTROS','PEDESTRE','TRANSPORTADOR') NOT NULL,
  `pontos` int DEFAULT 0 NOT NULL,
  `valor` float DEFAULT 0 NOT NULL,
  UNIQUE KEY `UK_enquadramento_numero` (`numero`)
);

CREATE TABLE `boleto` (
  `id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `codigo_barras` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL
);

CREATE TABLE `cobranca` (
  `id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `desconto` float DEFAULT 0 NOT NULL,
  `valor` float DEFAULT 0 NOT NULL,
  `data_vencimento` TIMESTAMP NOT NULL,
  `data_pagamento` TIMESTAMP DEFAULT NULL,
  `id_boleto` bigint DEFAULT NULL,
  UNIQUE KEY `UK_cobranca_id_boleto` (`id_boleto`),
  CONSTRAINT `FK_cobranca_id_boleto_boleto_id` FOREIGN KEY (`id_boleto`) REFERENCES `boleto` (`id`)
);

CREATE TABLE `penalidade` (
  `id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `tipo` enum('NORMAL','NAO_INDICACAO') DEFAULT 'NORMAL' NOT NULL,
  `id_cobranca` bigint NOT NULL,
  `data_recebimento` TIMESTAMP NOT NULL,
  `data_envio` TIMESTAMP DEFAULT NULL,  
  UNIQUE KEY `UK_penalidade_id_cobranca` (`id_cobranca`),
  CONSTRAINT `FK_penalidade_id_cobranca_cobranca_id` FOREIGN KEY (`id_cobranca`) REFERENCES `cobranca` (`id`)
);

CREATE TABLE `infracao` (
  `id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `data_hora` TIMESTAMP NOT NULL,
  `local` varchar(50) NOT NULL,
  `id_enquadramento` bigint NOT NULL,
  `numero_ait` varchar(30) DEFAULT NULL,
  `situacao` enum('ANALISE','ARQUIVADO','ISENTO','RECURSO','NORMAL') DEFAULT 'NORMAL' NOT NULL,
  `id_veiculo` bigint NOT NULL,
  `id_condutor` bigint DEFAULT NULL,
  `assinado` bit(1) DEFAULT b'0' NOT NULL,
  `indicado` bit(1) DEFAULT b'0' NOT NULL,
  `prazo_indicacao` TIMESTAMP DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  `updated_at` TIMESTAMP DEFAULT NULL,
  `actived` bit(1) DEFAULT b'1' NOT NULL,
  `observacao` tinytext,
  KEY `FK_infracao_id_enquadramento_enquadramento_id` (`id_enquadramento`),
  KEY `FK_infracao_id_condutor_pessoa_id` (`id_condutor`),
  KEY `FK_infracao_id_veiculo_veiculo_id` (`id_veiculo`),
  CONSTRAINT `FK_infracao_id_condutor_pessoa_id` FOREIGN KEY (`id_condutor`) REFERENCES `pessoa` (`id`),
  CONSTRAINT `FK_infracao_id_veiculo_veiculo_id` FOREIGN KEY (`id_veiculo`) REFERENCES `veiculo` (`id`),
  CONSTRAINT `FK_infracao_id_enquadramento_enquadramento_id` FOREIGN KEY (`id_enquadramento`) REFERENCES `enquadramento` (`id`)
);

CREATE TABLE `infracao_penalidade` (
  `id_infracao` bigint NOT NULL,
  `id_penalidade` bigint NOT NULL,
  UNIQUE KEY `UK_infracao_penalidade_id_penalidade` (`id_penalidade`),
  KEY `UK_infracao_penalidade_id_infracao` (`id_infracao`),
  CONSTRAINT `UK_infracao_penalidade_id_penalidade` FOREIGN KEY (`id_penalidade`) REFERENCES `penalidade` (`id`),
  CONSTRAINT `UK_infracao_penalidade_id_infracao` FOREIGN KEY (`id_infracao`) REFERENCES `infracao` (`id`)
);
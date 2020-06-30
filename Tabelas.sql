## 1- executar este primeiro.
CREATE TABLE `mtb310_ap_financeiro` (
  `id_agente` int NOT NULL AUTO_INCREMENT,
  `nome_agente` varchar(100) NOT NULL,
  `volume_transacional` float NOT NULL,
  PRIMARY KEY (`id_agente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

##2 - executar esse depois.
CREATE TABLE `mtb310_transaction` (
  `id_transacao` int NOT NULL,
  `data_hora` timestamp NOT NULL,
  `dispositivo` int NOT NULL,
  `valor_solic` float NOT NULL,
  `valor_aut` float NOT NULL,
  `status` int NOT NULL,
  `ag_financeiro` int NOT NULL,
  KEY `FK_idx` (`ag_financeiro`),
  CONSTRAINT `FK` FOREIGN KEY (`ag_financeiro`) REFERENCES `mtb310_ap_financeiro` (`id_agente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
--Migration para adicionar a coluna 'rank' na tabela 'tb_cadastro'

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);
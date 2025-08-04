# RELATORIO DE IMPLEMENTAÇÃO DE SERVIÇOS AWS

Data: 08-04-2025
Empresa: Abstergo Industries
Responsável: Nathan Tanzi

## Introdução
Este relatório apresenta o processo de implementação de ferramentas na empresa Abstergo Industries, realizado por Nathan Tanzi. O objetivo do projeto foi selecionar 3 serviços AWS, com a finalidade de realizar a diminuição de custos imediatos.

## Descrição do Projeto
O projeto de implementação de ferramentas foi dividido em 3 etapas, cada uma com seus objetivos específicos. A seguir, serão descritas as etapas do projeto:

Etapa 1:
- AWS Savings Plans
- Redução de custos em computação (EC2, Lambda, Fargate) com compromisso de uso antecipado.
- A farmacêutica pode garantir descontos (até 72%) em workloads estáveis (ex: servidores de banco de dados clínicos ou ambientes de pesquisa) ao assumir um compromisso de uso por 1 ou 3 anos.

Etapa 2:
- Amazon S3 Intelligent-Tiering
- Armazenamento de dados com custo otimizado automaticamente.
- Armazenar dados de ensaios clínicos, imagens médicas ou registros de pacientes que são acessados com frequência variável. O S3 move os dados entre tiers (frequente/infrequente) sem custo de transição, reduzindo custos em até 40% comparado ao S3 Standard.

Etapa 3:
- AWS Trusted Advisor
- Identificação de desperdícios e melhores práticas de custo/segurança.
- O AWS Trusted Advisor realiza auditorias automáticas para identificar oportunidades de redução de custos e melhoria de segurança, como detectar volumes EBS não utilizados (ex.: backups antigos que podem ser excluídos ou migrados para um tier mais barato), sugerir ajustes em Security Groups (evitando a exposição indevida de dados sensíveis, crítico para compliance em farmacêuticas) e recomendar a exclusão de ALBs/ELBs ociosos (comum em ambientes de teste farmacêuticos, onde recursos temporários podem ser esquecidos), garantindo otimização contínua sem comprometer a governança.

## Comclusão
A implementação das ferramentas na empresa Abstergo Industries tem como esperado:

- Redução de até 72% nos custos de computação com AWS Savings Plans

- Economia de até 40% em armazenamento utilizando Amazon S3 Intelligent-Tiering

- Otimização contínua de recursos através das recomendações do AWS Trusted Advisor

O que aumentará a eficiência e a produtividade da empresa. Recomenda-se a continuidade da utilização das ferramentas implementadas e a busca por novas tecnologias que possam melhorar ainda mais os processos da empresa.

Assinatura do Responável pelo Projeto:
Nathan Tanzi
